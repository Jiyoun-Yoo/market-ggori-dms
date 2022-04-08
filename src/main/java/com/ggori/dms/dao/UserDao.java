package com.ggori.dms.dao;

import com.ggori.dms.domain.User;
import java.util.List;
import java.util.Map;

public interface UserDao {
  List<User> findUserByName(String name) throws Exception;
//  List<User> findAll() throws Exception;
  User checkId(String usr_id) throws Exception;
  User findUserByUsrNo(int usr_no) throws Exception;
  List<User> findUserByNo(int usr_no) throws Exception;
  List<User> findAll(String keyword) throws Exception;
  List<User> findAllAdmin(Map<String, Object> map) throws Exception;
  int insertUser(User user) throws Exception;
  int updateUser(User user) throws Exception;
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
