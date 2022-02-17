package com.ggori.dms.interceptor;

import com.ggori.dms.domain.User;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

  private static final Logger LOGGER = LogManager.getLogger(LoginInterceptor.class);

  public List login_necessary
      = Arrays.asList("/user/detail", "/delivery/**" ,"/vox/**", "/penalty/**");

  public List login_unnecessary
      = Arrays.asList("/main", "/join", "/login" ,"/common/ask");

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    User loginUser = (User) request.getSession().getAttribute("loginUser");

    if(loginUser == null) {
      (request.getSession()).setAttribute("msg", "로그인 회원만 접근 가능한 페이지입니다.");
      response.sendRedirect(request.getServletContext().getContextPath() + "/user/login");
      return false;
    } else if(loginUser.getBlock_yn().equalsIgnoreCase("y")) {
      (request.getSession()).setAttribute("msg", "접근이 차단된 계정으로 로그인하셨습니다.");
      response.sendRedirect(request.getServletContext().getContextPath() + "/user/login-error");
      return false;
    } else if (loginUser.getUse_yn().equalsIgnoreCase("n")) {
      (request.getSession()).setAttribute("msg", "사용이 중지된 계정으로 로그인하셨습니다.");
      response.sendRedirect(request.getServletContext().getContextPath() + "/user/login-error");
      return false;
    }

    return true;
  }
}
