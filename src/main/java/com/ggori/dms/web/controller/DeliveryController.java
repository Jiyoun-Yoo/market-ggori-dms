package com.ggori.dms.web.controller;

import com.ggori.dms.domain.Delivery;
import com.ggori.dms.domain.User;
import com.ggori.dms.service.DeliveryService;
import com.ggori.dms.service.UserService;
import com.ggori.dms.util.DateUtil;
import groovy.util.logging.Slf4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
public class DeliveryController {
  private static final Logger log = LoggerFactory.getLogger(DeliveryController.class);

  @Autowired DeliveryService deliveryService;
  @Autowired UserService userService;

  DateUtil dateUtil = new DateUtil();

  @GetMapping("delivery/new")
  public ModelAndView createDevlivery() {
    ModelAndView modelAndView = new ModelAndView("delivery/createDelivery");
    modelAndView.addObject("delivery", new Delivery());

    return modelAndView;
  }

  @PostMapping("delivery/new")
  public RedirectView createDevlivery(Model model, HttpSession session, @ModelAttribute("delivery") Delivery delivery) {
    delivery.setAdmin_usr((User) session.getAttribute("login_user"));
    delivery.setRequestedDateTime(delivery.getRequestedDateTime().replace(",", " "));
    delivery.setCreatedDtm(dateUtil.getNow());

    User driver;
    try {
      driver = userService.getUserByName(delivery.getDriver_usr().getName()).get(0);
      delivery.setDriver_usr(driver);

      deliveryService.addDelivery(delivery);

      log.info("delivery_no :       " + delivery.getDelivery_no());
    } catch(Exception e) {
      e.printStackTrace();
    }

    return new RedirectView("/delivery/" + delivery.getDelivery_no());
  }

  @PostMapping("delivery/checkDriver")
  @ResponseBody
  public Map<Object, Object> checkDriver(@RequestParam Map<String, Object> paramMap) {
    String name = (String) paramMap.get("driver_name");
    Map<Object, Object> map = new HashMap<>();

    log.info("[[" + name + "]] 이름 검색");

    List<User> userList = new ArrayList<>();

    try {
      userList = userService.getUserByName(name);
      if (userList.size() == 0) {
        map.put("result", "zero");
        map.put("errorMsg", "입력한 이름의 배송 기사가 없습니다.");
        return map;
      } else if (userList.size() > 1) {
        map.put("result", "select");
        map.put("userList", userList);
      }

      map.put("result", "success");
      map.put("userList", userList);

    } catch(Exception e) {
      e.printStackTrace();
    }

    return map;
  }


  @GetMapping("deliveries")
  public ModelAndView deliveryList() {
    ModelAndView modelAndView = new ModelAndView("delivery/deliveryList");
    List<Delivery> deliveryList;

    try {
      deliveryList = deliveryService.list();
      log.info("########      " + deliveryList.toString());
      modelAndView.addObject("deliveryList", deliveryList);

    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return modelAndView;
  }

  @GetMapping("delivery/{delivery_no}")
  public ModelAndView readDelivery(@PathVariable int delivery_no) {
    ModelAndView modelAndView = new ModelAndView("delivery/readDelivery");
    try {
      Delivery delivery = deliveryService.getDeliveryByNo(delivery_no);
      modelAndView.addObject("delivery", delivery);

    } catch(Exception e) {
      log.error(e.getMessage());
    }
    return modelAndView;
  }
}




