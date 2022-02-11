package com.teamfresh.teamfreshassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeliveryController {

  @GetMapping("createDevlivery")
  public String createDevlivery() {
    return "delivery/createDelivery";
  }

  @GetMapping("deliveryList")
  public String deliveryList() {
    return "delivery/deliveryList";
  }

  @GetMapping("readDelivery")
  public String readDelivery() {
    return "delivery/readDelivery";
  }
}
