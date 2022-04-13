package com.ggori.dms.web.controller;

import com.ggori.dms.domain.Delivery;
import com.ggori.dms.domain.VOC;
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
@RequestMapping("voc")
public class VOCController {

  private static final Logger log = LoggerFactory.getLogger(VOCController.class);

  @Autowired
  DeliveryService deliveryService;

  @GetMapping("new/{delivery_no}")
  public ModelAndView createVOC(@PathVariable int delivery_no) {
    ModelAndView modelAndView = new ModelAndView("voc/createVOC");
    modelAndView.addObject("voc", new VOC());

    try {
      Delivery delivery = deliveryService.getDeliveryByNo(delivery_no);
      modelAndView.addObject("delivery", delivery);

    } catch(Exception e) {
      log.error(e.getMessage());
    }

    return modelAndView;
  }

  @PostMapping("voc")
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
