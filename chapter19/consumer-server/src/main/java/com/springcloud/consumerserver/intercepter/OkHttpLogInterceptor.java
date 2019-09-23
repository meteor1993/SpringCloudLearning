package com.springcloud.consumerserver.intercepter;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/23
 * @Time: 22:15
 * @email: inwsy@hotmail.com
 * Description:
 */
@Slf4j
public class OkHttpLogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        log.info("OkHttpUrl : " + chain.request().url());
        return chain.proceed(chain.request());
    }
}
