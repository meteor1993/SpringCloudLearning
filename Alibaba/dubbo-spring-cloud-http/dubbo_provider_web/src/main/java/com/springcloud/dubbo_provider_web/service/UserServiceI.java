package com.springcloud.dubbo_provider_web.service;

import com.google.common.collect.Maps;
import com.springcloud.dubbo_api.model.UserModel;
import com.springcloud.dubbo_api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/4
 * @Time: 23:33
 * @email: inwsy@hotmail.com
 * Description:
 */
@Service(version = "1.0.0")
@RestController
@Slf4j
public class UserServiceI implements UserService {

    private Map<Long, UserModel> usersRepository = Maps.newHashMap();

    @Override
    @PostMapping("/save")
    public UserModel save(@RequestBody UserModel user) {
        return usersRepository.put(user.getId(), user);
    }

    @Override
    @DeleteMapping("/remove")
    public void remove(@RequestParam("id") Long userId) {
        usersRepository.remove(userId);
    }

    @Override
    @GetMapping("/findAll")
    public Collection<UserModel> findAll() {
        return usersRepository.values();
    }
}
