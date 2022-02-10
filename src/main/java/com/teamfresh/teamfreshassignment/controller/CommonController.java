package com.teamfresh.teamfreshassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

  @GetMapping("hello")
  public String hello( ) {
    return "hello";
  }

  @GetMapping("common")
  public String common(Model model) {
    model.addAttribute("data", "team fresh!!");
    return "common/common";
  }
}