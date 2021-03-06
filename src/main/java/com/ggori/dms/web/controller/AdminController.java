package com.ggori.dms.web.controller;

import com.ggori.dms.domain.User;
import com.ggori.dms.service.UserService;
import groovy.util.logging.Slf4j;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping("admin")
public class AdminController {
  private static final Logger log = LoggerFactory.getLogger(AdminController.class);

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

  @GetMapping("users")
  public ModelAndView users(Model model) {
    ModelAndView modelAndView = new ModelAndView("admin/userList");
    List<User> userList;

    try {
      userList = userService.list();
      modelAndView.addObject("userList", userList);
    } catch(Exception e) {
      log.error(e.getMessage());
    }

    return modelAndView;
  }

  @GetMapping("userInfo/{usr_no}")
  public ModelAndView userDetail(@PathVariable int usr_no) {
    ModelAndView modelAndView = new ModelAndView("admin/userInfo");

    try {
      User user = userService.getUserByUsrNo(usr_no);
      log.info(user.toString());
      modelAndView.addObject("user", user);

    } catch(Exception e) {
      log.error(e.getMessage());
    }

    return modelAndView;
  }

}