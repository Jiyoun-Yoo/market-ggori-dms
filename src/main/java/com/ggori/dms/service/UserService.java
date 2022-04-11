package com.ggori.dms.service;

import com.ggori.dms.domain.User;
import java.util.List;

public interface UserService {
  int addUser(User user) throws Exception;
  int updateUser(User user) throws Exception;
  int updateUserPwd(int userNo, String password) throws Exception;
  int deleteUser(int no) throws Exception;
  int undeleteUser(int no) throws Exception;
  List<User> list() throws Exception;
  User checkUserID(String id) throws Exception;
  User getUser(String id, String password) throws Exception;
  List<User> getUserByName(String name) throws Exception;
  User getUserByUsrNo(int no) throws Exception;
  User getUserId(String name, String tel) throws Exception;
  User getUserPwd(String email, String name, String tel) throws Exception;
}
