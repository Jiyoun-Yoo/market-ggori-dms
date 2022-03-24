package com.ggori.dms.web.controller;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("penalty")
public class PenaltyController {

  private static final Logger log = LoggerFactory.getLogger(PenaltyController.class);

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
