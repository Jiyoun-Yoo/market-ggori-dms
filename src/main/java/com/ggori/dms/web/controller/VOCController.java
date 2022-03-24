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
@RequestMapping("voc")
public class VOCController {

  private static final Logger LOGGER = LoggerFactory.getLogger(VOCController.class);

  @GetMapping("new")
  public String createVOC() {
    return "voc/createVOC";
  }

  @PostMapping("new")
  public RedirectView createVOC(String content, Model model) {
    return new RedirectView("/");
  }

  @GetMapping("detail")
  public String readVOC() {
    return "voc/readVOC";
  }

  @GetMapping("list")
  public String penaltyList(Model model) {
    return "voc/VOCList";
  }
}
