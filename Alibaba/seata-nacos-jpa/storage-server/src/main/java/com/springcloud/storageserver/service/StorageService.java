package com.springcloud.storageserver.service;


import com.springcloud.common.OperationResponse;
import com.springcloud.common.storage.ReduceStockRequestVO;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/7
 * @Time: 22:11
 * @email: inwsy@hotmail.com
 * Description:
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param reduceStockRequestVO 请求 VO
     * @return 操作结果
     * @throws Exception 扣减失败时抛出异常
     */
    OperationResponse reduceStock(ReduceStockRequestVO reduceStockRequestVO) throws Exception;
}
