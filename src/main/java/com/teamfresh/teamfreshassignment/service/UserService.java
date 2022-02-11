package com.teamfresh.teamfreshassignment.service;

import com.teamfresh.teamfreshassignment.domain.User;
import java.util.List;
import java.util.Map;

public interface UserService {
  List<User> list(String keyword) throws Exception;
  User get(String id, String password) throws Exception;
  User getId(String name, String tel) throws Exception;
  User getPwd(String email, String name, String tel) throws Exception;
  int add(User user) throws Exception;
  int update(User user) throws Exception;
  int updatePwd(int userNo, String password) throws Exception;
  int delete(int no) throws Exception;
  int undelete(int no) throws Exception;
}
