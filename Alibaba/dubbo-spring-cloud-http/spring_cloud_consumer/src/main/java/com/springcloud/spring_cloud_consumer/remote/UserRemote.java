package com.springcloud.spring_cloud_consumer.remote;

import com.springcloud.dubbo_api.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "dubbo-spring-cloud-provider-web")
public interface UserRemote {

    @PostMapping("/save")
    UserModel save(@RequestBody UserModel user);

    @DeleteMapping("/remove")
    void remove(@RequestParam("id") Long userId);

    @GetMapping("/findAll")
    Collection<UserModel> findAll();
}
