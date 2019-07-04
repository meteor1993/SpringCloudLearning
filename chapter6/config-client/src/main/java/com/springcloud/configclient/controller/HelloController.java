package com.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: shiyao.wei
 * @Date: 2019/7/4 16:19
 * @Version: 1.0
 * @Desc:
 */
@RestController
public class HelloController {

    @Value("${springcloud.hello}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }
}
