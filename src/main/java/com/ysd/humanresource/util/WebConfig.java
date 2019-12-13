package com.ysd.humanresource.util;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ysd.humanresource.Interceptor.LoginInterceptor;

@SpringBootConfiguration
public class WebConfig implements WebMvcConfigurer {
	
	@Bean
	public LoginInterceptor LoginInterceptor() {
		return new LoginInterceptor();
	}
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/kaoshi","/defen");
    }
	
}
