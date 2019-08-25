package com.springcloud.consumer.controller;

import com.springcloud.consumer.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019/8/22 16:50
 * @Version: 1.0
 * @Desc:
 */
@RestController
public class HelloController {

    @Autowired
    HelloRemote helloRemote;

    @GetMapping("/hello")
    public String hello(String name){
        return helloRemote.hello(name);
    }
}
