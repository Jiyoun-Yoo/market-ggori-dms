package com.teamfresh.teamfreshassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

  @GetMapping("login")
  public String common(Model model) {
    model.addAttribute("data", "team fresh!!");
    return "auth/login";
  }

  @PostMapping("login")
  public RedirectView login(String inputID, String inputPassword) {

    return new RedirectView("main");
  }


}
