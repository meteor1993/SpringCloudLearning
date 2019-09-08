package com.springcloud.orderserver.service;


import com.springcloud.common.OperationResponse;
import com.springcloud.common.order.PlaceOrderRequestVO;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/7
 * @Time: 21:37
 * @email: inwsy@hotmail.com
 * Description:
 */
public interface OrderService {
    OperationResponse placeOrder(PlaceOrderRequestVO placeOrderRequestVO);
}
