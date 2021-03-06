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
public class AdminInterceptor implements HandlerInterceptor {

  private static final Logger log = LogManager.getLogger(AdminInterceptor.class);

  public List admin_necessary
      = Arrays.asList("/admin/**", "/delivery/new", "/penalty/new");

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    User loginUser = (User) request.getSession().getAttribute("loginUser");

    if(loginUser == null || !loginUser.getAdmin_yn().equalsIgnoreCase("y")) {
      (request.getSession()).setAttribute("errorMsg", "접근 권한이 없는 페이지입니다.");
      response.sendRedirect(request.getServletContext().getContextPath() + "/errorMsg");
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
