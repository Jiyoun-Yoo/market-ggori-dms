package com.ggori.dms.config;

import com.ggori.dms.web.interceptor.AdminInterceptor;
import com.ggori.dms.web.interceptor.AuthInterceptor;
import com.ggori.dms.web.interceptor.LoginInterceptor;
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

    AuthInterceptor authInterceptor = new AuthInterceptor();
    registry.addInterceptor(authInterceptor)
        .excludePathPatterns(authInterceptor.auth_unnecessary);
  }

}
