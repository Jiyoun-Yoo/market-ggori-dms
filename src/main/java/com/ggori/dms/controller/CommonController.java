package com.ggori.dms.controller;

import com.ggori.dms.domain.User;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CommonController {

  @GetMapping("main")
  public RedirectView main(Model model, HttpSession session) {

    User user = (User) session.getAttribute("loginUser");

    if(user == null) {
      return new RedirectView("/user/login");
    } else if (user.getAdmin_yn().equalsIgnoreCase("y")) {
      return new RedirectView("/admin/main");
//      return "admin/main";
    }
    return new RedirectView("/user/main");

//    return "common/main";
  }

  @GetMapping("error")
  public String error(Model model, HttpSession session) {
    model.addAttribute("msg", " 하헤히호후 ");
//    model.addAttribute("msg", session.getAttribute("msg"));
    return "error";
  }

  @GetMapping("ask")
  public String ask(Model model) {
    return "common/ask";
  }

  @PostMapping("ask")
  public RedirectView ask(String content, String contactWay, String contactInfo, Model model) {
    return new RedirectView("/main");
  }
}