package com.springcloud.dubbo_api.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Date: 2019/9/4 14:53
 * @Version: 1.0
 * @Desc:
 */
@Data
public class UserModel implements Serializable {
    private Long id;
    private String name;
    private int age;
}
