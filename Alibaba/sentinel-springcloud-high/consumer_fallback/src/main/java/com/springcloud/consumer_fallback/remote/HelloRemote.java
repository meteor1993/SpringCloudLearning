package com.springcloud.consumer_fallback.remote;

import com.springcloud.consumer_fallback.fallback.HelloRemoteFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/1
 * @Time: 15:49
 * @email: inwsy@hotmail.com
 * Description:
 */
@FeignClient(name = "spring-cloud-provider-server", fallback = HelloRemoteFallBack.class)
public interface HelloRemote {
    @GetMapping("/hello")
    String hello();
}
