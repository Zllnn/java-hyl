package com.hyl.hyl.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
//            @Override
            public void configureCors(CorsRegistry registry) {
                // 允许所有源跨域访问（开发阶段方便调试，生产要注意）
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
                // 或者可以指定具体源，比如：
                //registry.addMapping("/login")
                //        .allowedOrigins("http://localhost:5173")
                //        .allowedMethods("POST")
                //        .allowedHeaders("Content-Type");
            }
        };
    }
}
