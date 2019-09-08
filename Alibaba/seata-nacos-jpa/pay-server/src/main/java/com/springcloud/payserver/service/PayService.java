package com.springcloud.payserver.service;


import com.springcloud.common.OperationResponse;
import com.springcloud.common.pay.ReduceBalanceRequestVO;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/7
 * @Time: 22:01
 * @email: inwsy@hotmail.com
 * Description:
 */
public interface PayService {
    OperationResponse reduceBalance(ReduceBalanceRequestVO reduceBalanceRequestVO) throws Exception;
}
