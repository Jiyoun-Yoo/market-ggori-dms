package com.ggori.dms.web.interceptor;

import com.ggori.dms.domain.User;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {

  private static final Logger LOGGER = LogManager.getLogger(LoginInterceptor.class);

  public List login_necessary
      = Arrays.asList("/user/mypage", "/delivery/**" ,"/vox/**", "/penalty/**");

  public List login_unnecessary
      = Arrays.asList("/main", "/join", "/login" ,"/common/ask", "/error", "/errorMsg");

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    User loginUser = (User) request.getSession().getAttribute("loginUser");

    if(loginUser == null) {
      (request.getSession()).setAttribute("errorMsg", "로그인 회원만 접근 가능한 페이지입니다.");
      response.sendRedirect(request.getServletContext().getContextPath() + "/login");
      return false;
    }

    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    (request.getSession()).setAttribute("errorMsg", "");
  }
}
