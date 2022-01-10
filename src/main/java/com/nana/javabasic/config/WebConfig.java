package com.nana.javabasic.config;

import com.nana.javabasic.example.annotation.interceptor.CustomInterceptor;
import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Nana
 * @date 2022/1/7
 */
@Configuration
@EnableAspectJAutoProxy
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private CustomInterceptor customInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor);
    }
}
