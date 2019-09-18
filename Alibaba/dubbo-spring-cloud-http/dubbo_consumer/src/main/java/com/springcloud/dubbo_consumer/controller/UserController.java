package com.springcloud.dubbo_consumer.controller;

import com.springcloud.dubbo_api.model.UserModel;
import com.springcloud.dubbo_api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Date: 2019/9/5 11:22
 * @Version: 1.0
 * @Desc:
 */
@RestController
public class UserController {

    @Reference(version = "1.0.0")
    UserService userService;

    @PostMapping("/save")
    public UserModel save(@RequestBody UserModel user) {
        return userService.save(user);
    }

    @DeleteMapping("/remove")
    public void remove(@RequestParam("id") Long userId) {
        userService.remove(userId);
    }

    @GetMapping("/findAll")
    public Collection<UserModel> findAll() {
        return userService.findAll();
    }
}
