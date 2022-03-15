package com.ggori.dms.web.controller;

import com.ggori.dms.domain.User;
import com.ggori.dms.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminController {

  private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

  @Autowired
  UserService userService;


  @GetMapping("main")
  public String main(Model model) {
    return "admin/main";
  }

  @GetMapping("newService")
  public String newService(Model model) {
    return "admin/newService";
  }

  @GetMapping("checkQnA")
  public String checkQnA(Model model) {
    return "admin/QnAList";
  }

  @GetMapping("readQnA")
  public String readQnA(Model model) {
    return "admin/readQnA";
  }

  @GetMapping("userList")
  public ModelAndView userList(Model model) {

    ModelAndView modelAndView = new ModelAndView("admin/userList");
    List<User> userList;

    try {
      userList = userService.list();
      modelAndView.addObject("userList", userList);
    } catch(Exception e) {
      LOGGER.error(e);
    }

    return modelAndView;
  }

}