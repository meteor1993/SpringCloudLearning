package com.springcloud.consumer_server.controller;

import com.springcloud.consumer_server.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/1
 * @Time: 15:50
 * @email: inwsy@hotmail.com
 * Description:
 */
@RestController
public class HelloController {
    @Autowired
    HelloRemote helloRemote;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/helloByFeign")
    public String helloByFeign() {
        return helloRemote.hello();
    }

    @GetMapping("/helloByRestTemplate")
    public String helloByRestTemplate() {
        return restTemplate.getForObject("http://spring-cloud-provider-server/hello", String.class);
    }
}
