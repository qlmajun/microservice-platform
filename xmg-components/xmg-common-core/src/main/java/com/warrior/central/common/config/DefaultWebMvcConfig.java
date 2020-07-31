package com.warrior.central.common.config;

import com.warrior.central.common.feign.UserServiceApi;
import com.warrior.central.common.resolver.ClientArgumentResolver;
import com.warrior.central.common.resolver.TokenArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author 小马哥
 * @description 默认SpringMVC拦截配置
 * @date 2020/6/16
 */
public class DefaultWebMvcConfig implements WebMvcConfigurer {

    @Lazy
    @Autowired
    private UserServiceApi userServiceApi;

    /***
     * Token 参数解析
     * @param resolvers 解析类
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        //注入用户信息
        resolvers.add(new TokenArgumentResolver(userServiceApi));
        //注入应用信息
        resolvers.add(new ClientArgumentResolver());
    }
}
