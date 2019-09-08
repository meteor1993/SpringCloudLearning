package com.springcloud.orderserver.service.impl;

import com.springcloud.common.OperationResponse;
import com.springcloud.common.order.PlaceOrderRequestVO;
import com.springcloud.common.pay.ReduceBalanceRequestVO;
import com.springcloud.common.storage.ReduceStockRequestVO;
import com.springcloud.orderserver.dao.OrderDao;
import com.springcloud.orderserver.model.Order;
import com.springcloud.orderserver.model.OrderStatus;
import com.springcloud.orderserver.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/7
 * @Time: 21:45
 * @email: inwsy@hotmail.com
 * Description:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderDao orderDao;

    private final String STORAGE_SERVICE_HOST = "http://spring-cloud-storage-server/storage";
    private final String PAY_SERVICE_HOST = "http://spring-cloud-pay-server/pay";

    @Override
    @GlobalTransactional
    public OperationResponse placeOrder(PlaceOrderRequestVO placeOrderRequestVO) {
        Integer amount = 1;
        Integer price = placeOrderRequestVO.getPrice();

        Order order = Order.builder()
                .userId(placeOrderRequestVO.getUserId())
                .productId(placeOrderRequestVO.getProductId())
                .status(OrderStatus.INIT)
                .payAmount(price)
                .build();

        order = orderDao.save(order);

        log.info("保存订单{}", order.getId() != null ? "成功" : "失败");
        log.info("当前 XID: {}", RootContext.getXID());

        // 扣减库存
        log.info("开始扣减库存");
        ReduceStockRequestVO reduceStockRequestVO = ReduceStockRequestVO.builder()
                .productId(placeOrderRequestVO.getProductId())
                .amount(amount)
                .build();
        String storageReduceUrl = String.format("%s/reduceStock", STORAGE_SERVICE_HOST);
        OperationResponse storageOperationResponse = restTemplate.postForObject(storageReduceUrl, reduceStockRequestVO, OperationResponse.class);
        log.info("扣减库存结果:{}", storageOperationResponse);

        // 扣减余额
        log.info("开始扣减余额");
        ReduceBalanceRequestVO reduceBalanceRequestVO = ReduceBalanceRequestVO.builder()
                .userId(placeOrderRequestVO.getUserId())
                .price(price)
                .build();

        String reduceBalanceUrl = String.format("%s/reduceBalance", PAY_SERVICE_HOST);
        OperationResponse balanceOperationResponse = restTemplate.postForObject(reduceBalanceUrl, reduceBalanceRequestVO, OperationResponse.class);
        log.info("扣减余额结果:{}", balanceOperationResponse);

        Integer updateOrderRecord = orderDao.updateOrder(order.getId(), OrderStatus.SUCCESS);
        log.info("更新订单:{} {}", order.getId(), updateOrderRecord > 0 ? "成功" : "失败");

        return OperationResponse.builder()
                .success(balanceOperationResponse.isSuccess() && storageOperationResponse.isSuccess())
                .build();
    }
}
