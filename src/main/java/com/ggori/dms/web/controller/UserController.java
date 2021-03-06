package com.ggori.dms.web.controller;

import com.ggori.dms.domain.User;
import com.ggori.dms.service.UserService;
import com.ggori.dms.util.DateUtil;
import groovy.util.logging.Slf4j;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
public class UserController {

  private static final Logger log = LoggerFactory.getLogger(UserController.class);

  @Autowired UserService userService;

  DateUtil dateUtil = new DateUtil();

  @GetMapping("join")
  public ModelAndView join() {
    ModelAndView modelAndView = new ModelAndView("user/join");
    modelAndView.addObject("user", new User());

    return modelAndView;
  }

  @PostMapping("join")
  public RedirectView join(Model model, @ModelAttribute("user") User user) {
    try {
      user.setCreatedDtm(dateUtil.getNow());
      userService.addUser(user);
    } catch(Exception e) {
      e.printStackTrace();
    }

    model.addAttribute("msg", "회원 가입이 완료되었습니다.");
    return new RedirectView("/login");
  }

  @PostMapping("checkID")
  @ResponseBody
  public Map<Object, Object> checkID(@RequestParam Map<String, Object> paramMap) {
    Map<Object, Object> map = new HashMap<>();

    String usr_id = (String) paramMap.get("usr_id");

    String userIDRegex = "^[a-zA-Z0-9]{8,20}$";
    boolean flag1 = Pattern.matches(userIDRegex, usr_id);

    if (flag1 == false) {
      map.put("result", false);
      map.put("errorMsg", "아이디는 숫자, 문자(영문)로 이루어진 8 ~ 20자리의 문자열이어야 합니다.");
      return map;
    }

    try {
      User user =  userService.checkUserID(usr_id);

      if (user != null) {
        map.put("result", false);
        map.put("errorMsg", "입력하신 아이디는 이미 사용중입니다.");
        return map;
      }

      map.put("result", true);

    } catch (Exception e) {
      e.printStackTrace();
    }

    return map;
  }

  @PostMapping("checkPW")
  @ResponseBody
  public Map<Object, Object> checkPW(@RequestParam Map<String, Object> paramMap) {
    Map<Object, Object> map = new HashMap<>();

    String usr_pwd = (String) paramMap.get("usr_pwd");
    String confirm_pwd = (String) paramMap.get("confirm_pwd");

    String userpassRegex = "^[a-zA-Z0-9!@#$%^&*()?_~]{8,20}$";
    boolean flag1 = Pattern.matches(userpassRegex, usr_pwd);

    boolean flag2 = true;
    if (!usr_pwd.equals(confirm_pwd)) {
      flag2 = false;
    }

    if (flag1 == false) {
      map.put("result", false);
      map.put("errorMsg", "비밀번호는 숫자, 문자, 특수문자(!@#$%^&*()?_~)로 이루어진 8 ~ 20자리의 문자열이어야 합니다.");
    } else if (flag2 == false) {

      map.put("result", false);
      map.put("errorMsg", "두 비밀번호가 일치하지 않습니다.");
    } else {

      map.put("result", true);
    }

    return map;
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

//    //쿠키에 아이디 저장
//    Cookie id_cookie = new Cookie("id_cookie", usr_id);
//
//    if (saveId != null) {
//      id_cookie.setMaxAge(60 * 60 * 24 * 7);
//      log.info("##### " + usr_id + "쿠키에 아이디 저장");
//    } else {
//      id_cookie.setMaxAge(0);
//    }
//    response.addCookie(id_cookie);

    //mock user
    User usr_admin = new User("jiyounyoo","jiyoun_admin" ,"1234", "2022-01-01 14:00:00", "jiyounyoo@test.com","010-1234-1234", "y" , "y" ,"n");
//    User usr_general = new User("jiyounyoo","jiyoun_normal" ,"1234","2022-01-01 14:00:00" , "jiyounyoo@test.com","010-1234-1234", "n" , "y" ,"n");
//    User usr_blocked = new User("jiyounyoo","jiyoun_blocked" , "1234","2022-01-01 14:00:00", "jiyounyoo@test.com","010-1234-1234", "n" , "y" ,"y");
//    User usr_notInUse = new User("jiyounyoo","jiyoun_notInUse" ,"1234", "2022-01-01 14:00:00", "jiyounyoo@test.com","010-1234-1234", "n" , "n" ,"n");

    User user = usr_admin;

//    try {
//      user = userService.getUser(usr_id, usr_pwd);
//    } catch(Exception e) {
//      e.printStackTrace();
//    }

    user.setRecentVisitDtm(dateUtil.getNow());
    session.setAttribute("login_user", user);

    if(user == null) {
      session.setAttribute("msg", "아이디와 비밀번호가 일치하지 않습니다. <br> 입력하신 정보가 정확한지 확인하시길 바랍니다.");
      return new RedirectView("/errorMsg");
    }

    session.setAttribute("loginUser", user);
    session.setAttribute("msg", usr_id + " 로그인 성공");

    if (user.getAdmin_yn().equalsIgnoreCase("y")) {
      log.info("#####  " + usr_id + "관리자 usr_id =" + usr_id + " 로그인 완료");
//      return new RedirectView("/admin/main");
    } else {
      log.info("#####  " + usr_id + "일반 회원 usr_id =" + usr_id +  " 로그인 완료");
    }

    return new RedirectView("/main");
  }

  @GetMapping("user/main")
  public String main() {
    return "user/main";
  }

  @GetMapping("user/mypage")
  public String detail() throws Exception {
    log.info(userService.getUserByName("유지연").toString());

    return "user/detail";
  }

  @GetMapping("user/ask")
  public String ask() {
    return "user/ask";
  }

  @GetMapping("user/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "user/main";
  }


}
