package com.springcloud.zuulsimple.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: weishiyao
 * @Date: 2019/7/6
 * @Time: 16:10
 * @email: inwsy@hotmail.com
 * Description:
 */
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
