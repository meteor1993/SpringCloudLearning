package com.springcloud.consumers.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: shiyao.wei
 * @Date: 2019/7/2 11:14
 * @Version: 1.0
 * @Desc:
 */
@FeignClient(name= "SPRING-CLOUD-PRODUCER")
public interface HelloRemote {
    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);
}
