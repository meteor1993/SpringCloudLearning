package com.springcloud.consumerserver.controller;

import com.springcloud.consumerserver.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/23
 * @Time: 21:55
 * @email: inwsy@hotmail.com
 * Description:
 */
@RestController
public class HelloController {
    @Autowired
    HelloRemote helloRemote;

    @GetMapping("/hello")
    public String hello() {
        return helloRemote.hello();
    }
}
