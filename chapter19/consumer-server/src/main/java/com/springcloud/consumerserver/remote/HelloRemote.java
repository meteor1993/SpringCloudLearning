package com.springcloud.consumerserver.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/23
 * @Time: 21:43
 * @email: inwsy@hotmail.com
 * Description:
 */
@FeignClient("provider-server")
public interface HelloRemote {

    @GetMapping("/hello")
    String hello();
}
