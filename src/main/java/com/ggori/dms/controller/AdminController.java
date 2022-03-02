package com.ggori.dms.controller;

import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

  private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

  @GetMapping("main")
  public String main(Model model) {
    return "admin/main";
  }
}
