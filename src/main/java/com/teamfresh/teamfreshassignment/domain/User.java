package com.teamfresh.teamfreshassignment.domain;

import java.util.Date;

public class User {
  private int no;
  private String usr_id;
  private String email;
  private String name;
  private String tel;
  private String usr_pwd;
  private Date createdDate;
  private Date recentVisitedDate;
  private String photo;
  private int penalty_cnt; //패널티 횟수
  private String admin_yn; //관리자 여부
  private String use_yn; //사용 여부
  private String block_yn; //차단 여부
  private String admin_comment;

  public int getNo() {
    return no;
  }

  public User setNo(int no) {
    this.no = no;
    return this;
  }

  public String getUsr_id() {
    return usr_id;
  }

  public User setUsr_id(String usr_id) {
    this.usr_id = usr_id;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getName() {
    return name;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public String getTel() {
    return tel;
  }

  public User setTel(String tel) {
    this.tel = tel;
    return this;
  }

  public String getUsr_pwd() {
    return usr_pwd;
  }

  public User setUsr_pwd(String usr_pwd) {
    this.usr_pwd = usr_pwd;
    return this;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public User setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  public Date getRecentVisitedDate() {
    return recentVisitedDate;
  }

  public User setRecentVisitedDate(Date recentVisitedDate) {
    this.recentVisitedDate = recentVisitedDate;
    return this;
  }

  public String getPhoto() {
    return photo;
  }

  public User setPhoto(String photo) {
    this.photo = photo;
    return this;
  }

  public int getPenalty_cnt() {
    return penalty_cnt;
  }

  public User setPenalty_cnt(int penalty_cnt) {
    this.penalty_cnt = penalty_cnt;
    return this;
  }

  public String getAdmin_yn() {
    return admin_yn;
  }

  public User setAdmin_yn(String admin_yn) {
    this.admin_yn = admin_yn;
    return this;
  }

  public String getUse_yn() {
    return use_yn;
  }

  public User setUse_yn(String use_yn) {
    this.use_yn = use_yn;
    return this;
  }

  public String getBlock_yn() {
    return block_yn;
  }

  public User setBlock_yn(String block_yn) {
    this.block_yn = block_yn;
    return this;
  }

  public String getAdmin_comment() {
    return admin_comment;
  }

  public User setAdmin_comment(String admin_comment) {
    this.admin_comment = admin_comment;
    return this;
  }
}
