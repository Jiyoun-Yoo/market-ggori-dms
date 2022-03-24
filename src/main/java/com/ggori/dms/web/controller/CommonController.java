package com.ggori.dms.web.controller;

import com.ggori.dms.domain.User;
import groovy.util.logging.Slf4j;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
public class CommonController {

  private static final Logger log = LoggerFactory.getLogger(CommonController.class);

  @GetMapping("main")
  public RedirectView main(Model model, HttpSession session) {

    User user = (User) session.getAttribute("loginUser");

    if(user == null) {
      return new RedirectView("/login");
    } else if (user.getAdmin_yn().equalsIgnoreCase("y")) {
      return new RedirectView("/admin/main");
    }
    return new RedirectView("/user/main");
  }

  @GetMapping("ask")
  public String ask(Model model) {
    return "common/ask";
  }

  @PostMapping("ask")
  public RedirectView ask(String content, String contactWay, String contactInfo, Model model) {
    return new RedirectView("/main");
  }

  @GetMapping("errorMsg")
  public String error(Model model, HttpSession session) {
    model.addAttribute("errorMsg", session.getAttribute("errorMsg"));
    return "/errorMsg";
  }

}