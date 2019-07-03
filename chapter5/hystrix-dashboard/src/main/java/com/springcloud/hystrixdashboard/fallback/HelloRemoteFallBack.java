package com.springcloud.hystrixdashboard.fallback;

import com.springcloud.hystrixdashboard.remote.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: weishiyao
 * @Date: 2019/7/2
 * @Time: 23:14
 * @email: inwsy@hotmail.com
 * Description:
 */
@Component
public class HelloRemoteFallBack implements HelloRemote {
    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello " + name + ", i am fallback massage";
    }
}
