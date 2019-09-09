package com.springcloud.web_flux.controller;

import com.alibaba.csp.sentinel.adapter.reactor.SentinelReactorTransformer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/1
 * @Time: 13:34
 * @email: inwsy@hotmail.com
 * Description:
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    @SentinelResource("hello")
    public Mono<String> mono() {
        return Mono.just("Hello Web Flux")
                .transform(new SentinelReactorTransformer<>("resourceName"));
    }
}
