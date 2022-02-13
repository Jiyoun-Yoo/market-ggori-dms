package com.teamfresh.teamfreshassignment.config;

import com.teamfresh.teamfreshassignment.interceptor.AdminInterceptor;
import com.teamfresh.teamfreshassignment.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    LoginInterceptor loginInterceptor = new LoginInterceptor();
    registry.addInterceptor(loginInterceptor)
        .addPathPatterns(loginInterceptor.login_necessary)
        .excludePathPatterns(loginInterceptor.login_unnecessary);

    AdminInterceptor adminInterceptor = new AdminInterceptor();
    registry.addInterceptor(adminInterceptor)
        .addPathPatterns(adminInterceptor.admin_necessary);
  }

}
