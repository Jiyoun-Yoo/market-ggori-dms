package com.teamfresh.teamfreshassignment.controller;

import com.teamfresh.teamfreshassignment.domain.Delivery;
import com.teamfresh.teamfreshassignment.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("delivery")
public class DeliveryController {

  @Autowired UserService userService;

  @GetMapping("new")
  public String createDevlivery() {
    return "delivery/createDelivery";
  }

  @PostMapping("new")
  public RedirectView createDevlivery(HttpServletRequest request, HttpSession session, Model model) {
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
