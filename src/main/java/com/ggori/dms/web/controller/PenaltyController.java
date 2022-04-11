package com.ggori.dms.web.controller;

import com.ggori.dms.domain.Delivery;
import com.ggori.dms.service.DeliveryService;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("penalty")
public class PenaltyController {
  private static final Logger log = LoggerFactory.getLogger(PenaltyController.class);

  @Autowired
  DeliveryService deliveryService;

  @GetMapping("new/{delivery_no}")
  public ModelAndView createPenalty(@PathVariable int delivery_no) {
    ModelAndView modelAndView = new ModelAndView("penalty/createPenalty");

    log.info("########## delivery_no          " + delivery_no);
    try {
      Delivery delivery = deliveryService.getDeliveryByNo(delivery_no);
      log.info("########## delivery          " + delivery.toString());
      modelAndView.addObject("delivery", delivery);

    } catch(Exception e) {
      log.error(e.getMessage());
    }

    return modelAndView;
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
