package com.teamfresh.teamfreshassignment.controller;

import com.teamfresh.teamfreshassignment.domain.User;
import com.teamfresh.teamfreshassignment.service.UserService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("user")
public class UserController {

  private static final Logger LOGGER = LogManager.getLogger(UserController.class);

  @Autowired UserService userService;

  @GetMapping("login")
  public String login(Model model) {
    model.addAttribute("data", "team fresh!!");
    return "user/login";
  }

  @PostMapping("login")
  public String login(String usr_id, String usr_pwd, String saveId,
      HttpServletResponse response, HttpSession session) throws Exception {
    LOGGER.info("ID: " + usr_id + "로그인 시도");

    //쿠키에 아이디 저장
    Cookie id_cookie = new Cookie("id_cookie", usr_id);

    if (saveId != null) {
      id_cookie.setMaxAge(60 * 60 * 24 * 7);
      LOGGER.info(usr_id + "쿠키에 아이디 저장");
    } else {
      id_cookie.setMaxAge(0);
    }

    response.addCookie(id_cookie);
    User user = userService.get(usr_id, usr_pwd);

    if (user == null ||
        user.getBlock_yn().equalsIgnoreCase("y") ||
        user.getUse_yn().equalsIgnoreCase("n")) {
      LOGGER.info(usr_id + "로그인 에러");
//      return "user/loginError";
    }

    if (!user.getAdmin_yn().equalsIgnoreCase("y")) {
      return "admin/main";
    }
    
    return "common/main";
  }


}
