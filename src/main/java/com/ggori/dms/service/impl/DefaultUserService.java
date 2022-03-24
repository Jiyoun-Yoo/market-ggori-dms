package com.ggori.dms.service.impl;

import com.ggori.dms.dao.UserDao;
import com.ggori.dms.domain.User;
import com.ggori.dms.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {
  UserDao userDao;

  public DefaultUserService(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public User checkUserID(String usr_id) throws Exception {
     return userDao.checkId(usr_id);
  }

  @Override
  public List<User> list() throws Exception {
    return userDao.findAll(null);
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
  public User getUserId(String name, String tel) throws Exception {
    return null;
  }

  @Override
  public User getUserPwd(String email, String name, String tel) throws Exception {
    return null;
  }

  @Override
  public int addUser(User user) throws Exception {
    return this.userDao.insertUser(user);
  }

  @Override
  public int updateUser(User user) throws Exception {
    return 0;
  }

  @Override
  public int updateUserPwd(int userNo, String password) throws Exception {
    return 0;
  }

  @Override
  public int deleteUser(int no) throws Exception {
    return 0;
  }

  @Override
  public int undeleteUser(int no) throws Exception {
    return 0;
  }
}
