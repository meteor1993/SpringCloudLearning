package com.springcloud.spring_cloud_consumer.controller;

import com.springcloud.dubbo_api.model.UserModel;
import com.springcloud.spring_cloud_consumer.remote.UserRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/4
 * @Time: 23:54
 * @email: inwsy@hotmail.com
 * Description:
 */
@RestController
public class UserController {

    @Autowired
    UserRemote userRemote;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/saveByFeign")
    public UserModel saveByFeign(@RequestBody UserModel user) {
        return userRemote.save(user);
    }

    @DeleteMapping("/removeByFeign")
    public void removeByFeign(@RequestParam("id") Long userId) {
        userRemote.remove(userId);
    }

    @GetMapping("/findAllByFeign")
    public Collection<UserModel> findAllByFeign() {
        return userRemote.findAll();
    }

    @PostMapping("/saveByRestTemplate")
    public UserModel saveByRestTemplate(@RequestBody UserModel user) {
        return restTemplate.postForObject("http://dubbo-spring-cloud-provider-web/save/", user, UserModel.class);
    }

    @DeleteMapping("/removeByRestTemplate")
    public void removeByRestTemplate(@RequestParam("id") Long userId) {
        restTemplate.delete("http://dubbo-spring-cloud-provider-web/remove?id=" + userId);
    }

    @GetMapping("/findAllByRestTemplate")
    public Collection<UserModel> findAllByRestTemplate() {
        return restTemplate.getForObject("http://dubbo-spring-cloud-provider-web/findAll/", Collection.class);
    }
}
