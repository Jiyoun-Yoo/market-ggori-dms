package com.teamfresh.teamfreshassignment.dao;

import com.teamfresh.teamfreshassignment.domain.User;
import java.util.List;
import java.util.Map;

public interface UserDao {
  List<User> findByName(String name) throws Exception;
  List<User> findAll(String keyword) throws Exception;
  List<User> findAllAdmin(Map<String, Object> map) throws Exception;
  int insert(User user) throws Exception;
  int update(User user) throws Exception;
  int updatePwd(Map<String, Object> map) throws Exception;
  int delete(int no) throws Exception;
  int inactive(int no) throws Exception;
  int active(int no) throws Exception;
  User findByIDPassword(Map<String, Object> map) throws Exception;
  User findId(Map<String, Object> map) throws Exception;
  User findPassword(Map<String, Object> map) throws Exception;
  User findByEmail(String email) throws Exception;
  List<User> count(String keyword) throws Exception;
}
