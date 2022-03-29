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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("delivery")
public class DeliveryController {
  private static final Logger log = LoggerFactory.getLogger(DeliveryController.class);

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

    delivery.setAdmin_usr(user);
    delivery.setRequestedDateTime(delivery.getRequestedDateTime().replace(",", " "));
    delivery.setState("D");

    try {
      //TODO driver, admin user 검색 방식 develop
//      delivery.setDriver_usr(userService.getUserByName(delivery.getDriver_usr().getName()));
//      delivery.setAdmin_usr(userService.getUserByName(delivery.getAdmin_usr().getName()));

      delivery.setCreatedDtm(dateUtil.getNow());

      log.info(delivery.toString());

      deliveryService.addDelivery(delivery);
    } catch(Exception e) {
      e.printStackTrace();
    }

    model.addAttribute("alertMSG", "배송 등록이 완료되었습니다.");

    return new RedirectView("/delivery/detail" );
  }

  @PostMapping("checkDriver")
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

//      map.put("result", "success");
      map.put("result", "select");
      map.put("userList", userList);

    } catch(Exception e) {
      e.printStackTrace();
    }

    return map;
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
