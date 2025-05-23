package com.hyl.hyl.config;

import com.hyl.hyl.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//给环境配置拦截器
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                "/upload/**" // 排除头像静态资源路径
        );
        // .excludePathPatterns("/login");  // 这里可以排除登录页面不被拦截 （这里不用排除，jwt拦截器已经排除）
    }
}

