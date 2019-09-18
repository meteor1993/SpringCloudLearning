package com.springcloud.dubbo_api.service;



import com.springcloud.dubbo_api.model.UserModel;

import java.util.Collection;

/**
 * @Date: 2019/9/4 16:22
 * @Version: 1.0
 * @Desc:
 */
public interface UserService {
    UserModel save(UserModel user);

    void remove(Long userId);

    Collection<UserModel> findAll();
}
