package com.teamfresh.teamfreshassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VOCController {

  @GetMapping("createVOC")
  public String createVOC(Model model) {
    model.addAttribute("data", "Team Fresh");
    return "voc/createVOC";
  }

  @GetMapping("readVOC")
  public String readVOC(Model model) {
    model.addAttribute("data", "Team Fresh");
    return "voc/readVOC";
  }
}
