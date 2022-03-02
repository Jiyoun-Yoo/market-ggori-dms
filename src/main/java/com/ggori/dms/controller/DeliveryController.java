package com.ggori.dms.controller;

import com.ggori.dms.domain.Delivery;
import com.ggori.dms.domain.User;
import com.ggori.dms.service.DeliveryService;
import com.ggori.dms.service.UserService;
import com.ggori.dms.util.DateUtil;
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

  @Autowired DeliveryService deliveryService;
  @Autowired UserService userService;

  DateUtil dateUtil = new DateUtil();

  @GetMapping("new")
  public ModelAndView createDevlivery() {
    ModelAndView modelAndView = new ModelAndView("delivery/createDelivery");
    modelAndView.addObject("delivery", new Delivery());

    return modelAndView;
  }

  @PostMapping("new")
  public RedirectView createDevlivery(Model model, HttpSession session, @ModelAttribute("delivery") Delivery delivery) {

    User user = (User) session.getAttribute("login_user");

    delivery.setWriter(user);
    delivery.setRequestedDateTime(delivery.getRequestedDateTime().replace(",", " "));

    try {
      //TODO driver, admin user 검색 방식 develop
      delivery.setDriver_usr(userService.getUserByName(delivery.getDriver_usr().getName()));
      delivery.setAdmin_usr(userService.getUserByName(delivery.getAdmin_usr().getName()));

      delivery.setCreatedDtm(dateUtil.getNow());

      LOGGER.info(delivery.toString());

      deliveryService.addDelivery(delivery);
    } catch(Exception e) {
      e.printStackTrace();
    }

    model.addAttribute("msg", "배송 등록이 완료되었습니다.");

    return new RedirectView("/delivery/detail" );
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
