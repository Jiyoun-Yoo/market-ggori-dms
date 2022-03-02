package com.ggori.dms.service.impl;

import com.ggori.dms.domain.User;
import com.ggori.dms.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {
//  UserDao userDao;
//
//  public DefaultUserService(UserDao userDao) {
//    this.userDao = userDao;
//  }

  @Override
  public List<User> list(String keyword) throws Exception {
    return null;
  }

  @Override
  public User getUser(String id, String password) throws Exception {
    return null;
  }

  @Override
  public User getUserByName(String name) throws Exception {
    return null;
  }

  @Override
  public User getId(String name, String tel) throws Exception {
    return null;
  }

  @Override
  public User getPwd(String email, String name, String tel) throws Exception {
    return null;
  }

  @Override
  public int addUser(User user) throws Exception {
    return 0;
  }

  @Override
  public int updateUser(User user) throws Exception {
    return 0;
  }

  @Override
  public int updatePwd(int userNo, String password) throws Exception {
    return 0;
  }

  @Override
  public int delete(int no) throws Exception {
    return 0;
  }

  @Override
  public int undelete(int no) throws Exception {
    return 0;
  }
}
