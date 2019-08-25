package com.springcloud.consumer.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Date: 2019/8/22 16:49
 * @Version: 1.0
 * @Desc:
 */
@FeignClient(name = "spring-cloud-provider-server")
public interface HelloRemote {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
}
