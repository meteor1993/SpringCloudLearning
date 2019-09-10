package com.springcloud.consumer_fallback.fallback;

import com.springcloud.consumer_fallback.remote.HelloRemote;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/1
 * @Time: 18:45
 * @email: inwsy@hotmail.com
 * Description:
 */
@Component
public class HelloRemoteFallBack implements HelloRemote {
    @Override
    public String hello() {
        return "Feign FallBack Msg";
    }
}
