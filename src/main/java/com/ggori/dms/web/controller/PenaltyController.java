package com.ggori.dms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("penalty")
public class PenaltyController {

  private static final Logger LOGGER = LogManager.getLogger(PenaltyController.class);


  @GetMapping("new")
  public String createPenalty(Model model) {
    return "penalty/createPenalty";
  }

  @PostMapping("new")
  public RedirectView createPenalty(String departure, Model model) {
    return new RedirectView("/");
  }

  @GetMapping("detail")
  public String detail(Model model) {
    return "penalty/readPenalty";
  }

  @GetMapping("list")
  public String list(Model model) {
    return "penalty/penaltyList";
  }
}
