package com.ggori.dms.service;

import com.ggori.dms.domain.User;
import java.util.List;

public interface UserService {
  List<User> list(String keyword) throws Exception;
  User getUser(String id, String password) throws Exception;
  User getUserByName(String name) throws Exception;
  User getId(String name, String tel) throws Exception;
  User getPwd(String email, String name, String tel) throws Exception;
  int addUser(User user) throws Exception;
  int updateUser(User user) throws Exception;
  int updatePwd(int userNo, String password) throws Exception;
  int delete(int no) throws Exception;
  int undelete(int no) throws Exception;
}
