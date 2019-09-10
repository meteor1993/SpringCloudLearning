package com.springcloud.consumer_fallback.utils;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/1
 * @Time: 18:58
 * @email: inwsy@hotmail.com
 * Description:
 */
public class ExceptionUtil {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionUtil.class);

    public static SentinelClientHttpResponse handleException(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
        logger.error(ex.getMessage(), ex);
        return new SentinelClientHttpResponse("RestTemplate FallBack Msg");
    }
}
