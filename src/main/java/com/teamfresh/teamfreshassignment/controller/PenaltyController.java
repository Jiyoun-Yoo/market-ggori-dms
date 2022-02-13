package com.teamfresh.teamfreshassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("penalty")
public class PenaltyController {

  @GetMapping("new")
  public String main(Model model) {
    return "penalty/new";
  }

  @PostMapping("new")
  public RedirectView main(String departure, Model model) {
    return new RedirectView("/");
  }
}
