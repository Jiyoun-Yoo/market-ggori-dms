package com.ggori.dms.controller;

import com.ggori.dms.domain.Delivery;
import com.ggori.dms.interceptor.LoginInterceptor;
import com.ggori.dms.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("delivery")
public class DeliveryController {

  private static final Logger LOGGER = LogManager.getLogger(DeliveryController.class);

  @Autowired
  UserService userService;

  @GetMapping("new")
  public ModelAndView createDevlivery() {
    ModelAndView modelAndView = new ModelAndView("delivery/createDelivery");
    modelAndView.addObject("delivery", new Delivery());

    return modelAndView;
  }

  @PostMapping("new")
  public RedirectView createDevlivery(HttpServletRequest request, HttpSession session, @ModelAttribute("delivery") Delivery delivery) {
    LOGGER.info(delivery.toString());

//    return "delivery/readDelivery";
    return new RedirectView("/delivery/detail");
  }

  @GetMapping("list")
  public String deliveryList() {
    return "delivery/deliveryList";
  }

  @GetMapping("detail")
  public String readDelivery() {
    return "delivery/readDelivery";
  }
}
