package com.teamfresh.teamfreshassignment.service.impl;

import com.teamfresh.teamfreshassignment.dao.UserDao;
import com.teamfresh.teamfreshassignment.domain.User;
import com.teamfresh.teamfreshassignment.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {
  UserDao userDao;

  public DefaultUserService(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public List<User> list(String keyword) throws Exception {
    return null;
  }

  @Override
  public User get(String id, String password) throws Exception {
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
  public int add(User user) throws Exception {
    return 0;
  }

  @Override
  public int update(User user) throws Exception {
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
