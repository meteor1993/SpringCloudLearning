package com.springcloud.providerserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Version: 1.0
 * @Desc:
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "Hello Spring Cloud! Port : " + request.getServerPort();
    }
}
