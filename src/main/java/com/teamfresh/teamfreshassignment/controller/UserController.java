package com.teamfresh.teamfreshassignment.controller;

import com.teamfresh.teamfreshassignment.domain.User;
import com.teamfresh.teamfreshassignment.service.UserService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

  private static final Logger LOGGER = LogManager.getLogger(UserController.class);

  @Autowired UserService userService;

  @GetMapping("join")
  public String join() {
    return "user/join";
  }

  @PostMapping("join")
  public RedirectView join(HttpServletRequest request, Model model, HttpSession session) {
    String name = request.getParameter("name");
    String usr_id = request.getParameter("usr_id");
    String usr_pwd = request.getParameter("usr_pwd");
    String email = request.getParameter("email");
    String tel = request.getParameter("tel");
    String admin_yn = request.getParameter("admin_yn");
    String use_yn = request.getParameter("use_yn");
    String block_yn = request.getParameter("block_yn");

    User user = new User(name, usr_id, usr_pwd, email, tel, admin_yn, use_yn, block_yn);

    try {
      userService.add(user);
    } catch(Exception e) {
      e.printStackTrace();
    }

    return new RedirectView("/login");
  }

  @GetMapping("login")
  public String login(Model model, HttpSession session) {

    User user = (User) session.getAttribute("login_user");

    if (user != null) {
      model.addAttribute("msg", "이미 로그인 된 상태입니다.");
      model.addAttribute("login_id", "(로그인 ID : " + user.getUsr_id() + ")");
      return "user/main";
    }
    return "user/login";
  }

  @PostMapping("login")
  public RedirectView login(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
    String usr_id = request.getParameter("usr_id");
    String usr_pwd = request.getParameter("usr_pwd");

      LOGGER.info("#####    " + usr_id + "로그인 시도");

//    //쿠키에 아이디 저장
//    Cookie id_cookie = new Cookie("id_cookie", usr_id);
//
//    if (saveId != null) {
//      id_cookie.setMaxAge(60 * 60 * 24 * 7);
//      LOGGER.info("##### " + usr_id + "쿠키에 아이디 저장");
//    } else {
//      id_cookie.setMaxAge(0);
//    }
//    response.addCookie(id_cookie);

    //mock user
    User usr_admin = new User("jiyounyoo","jiyoun_admin" ,"1234", "jiyounyoo@test.com","010-1234-1234", "y" , "y" ,"n");
    User usr_general = new User("jiyounyoo","jiyoun_normal" ,"1234", "jiyounyoo@test.com","010-1234-1234", "n" , "y" ,"n");
    User usr_blocked = new User("jiyounyoo","jiyoun_normal" ,"1234", "jiyounyoo@test.com","010-1234-1234", "n" , "y" ,"y");
    User usr_notInUse = new User("jiyounyoo","jiyoun_normal" ,"1234", "jiyounyoo@test.com","010-1234-1234", "n" , "n" ,"n");

    User user = usr_general;

//    try {
//      user = userService.get(usr_id, usr_pwd);
//    } catch(Exception e) {
//      e.printStackTrace();
//    }
    session.setAttribute("login_user", user);

    if(user == null) {
      session.setAttribute("msg", "아이디와 비밀번호가 일치하지 않습니다. <br> 입력하신 정보가 정확한지 확인하시길 바랍니다.");
      return new RedirectView("/user/login-error");
//    } else if(user.getBlock_yn().equalsIgnoreCase("y")) {
//      session.setAttribute("msg", "접근이 차단된 계정으로 로그인하셨습니다.");
//      return new RedirectView("/user/login-error");
//    } else if (user.getUse_yn().equalsIgnoreCase("n")) {
//      session.setAttribute("msg", "사용이 중지된 계정으로 로그인하셨습니다.");
//      return new RedirectView("/user/login-error");
    }

    session.setAttribute("loginUser", user);
    session.setAttribute("msg", usr_id + " 로그인 성공");

    if (user.getAdmin_yn().equalsIgnoreCase("y")) {
      LOGGER.info("#####  " + usr_id + "관리자 usr_id =" + usr_id + " 로그인 완료");
//      return new RedirectView("/admin/main");
    } else {
      LOGGER.info("#####  " + usr_id + "일반 회원 usr_id =" + usr_id +  " 로그인 완료");
    }

    return new RedirectView("/main");
  }

  @GetMapping("login-error")
  public String loginError(Model model, HttpSession session) {
    LOGGER.info("#####  " + session.getAttribute("msg"));
    model.addAttribute("msg", session.getAttribute("msg"));
    return "user/loginError";
  }

  @GetMapping("user/main")
  public String main() {
    return "user/main";
  }

  @GetMapping("user/ask")
  public String ask() {
    return "user/ask";
  }

}
