package com.teamfresh.teamfreshassignment.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

  HttpSession session;

  @GetMapping("main")
  public String main(Model model) {

    return "admin/main";
  }
}
