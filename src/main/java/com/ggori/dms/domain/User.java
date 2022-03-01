package com.ggori.dms.domain;

public class User {
  private int usr_no;
  private String svc_id;
  private String usr_id;
  private String email;
  private String name;
  private String tel;
  private String usr_pwd;
  private String createdDtm; //가입일
  private String recentVisitDtm;
  private int penalty_cnt; //패널티 횟수
  private String admin_yn; //관리자 여부
  private String use_yn; //사용 여부
  private String block_yn; //차단 여부
  private String admin_memo; //관리자 메모

  public User() {
  }

  public User(String name, String usr_id, String usr_pwd, String email,  String tel, String admin_yn, String use_yn, String block_yn) {
    this.name = name;
    this.usr_id = usr_id;
    this.usr_pwd = usr_pwd;
    this.email = email;
    this.tel = tel;
    this.admin_yn = admin_yn;
    this.use_yn = use_yn;
    this.block_yn = block_yn;
  }

  public int getUsr_no() {
    return usr_no;
  }

  public User setUsr_no(int usr_no) {
    this.usr_no = usr_no;
    return this;
  }

  public String getSvc_id() {
    return svc_id;
  }

  public void setSvc_id(String svc_id) {
    this.svc_id = svc_id;
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

  public String getCreatedDtm() {
    return createdDtm;
  }

  public User setCreatedDtm(String createdDtm) {
    this.createdDtm = createdDtm;
    return this;
  }

  public String getRecentVisitDtm() {
    return recentVisitDtm;
  }

  public User setRecentVisitDtm(String recentVisitDtm) {
    this.recentVisitDtm = recentVisitDtm;
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

  public String getAdmin_memo() {
    return admin_memo;
  }

  public User setAdmin_memo(String admin_memo) {
    this.admin_memo = admin_memo;
    return this;
  }

  @Override
  public String toString() {
    return "User{" +
        "usr_no=" + usr_no +
        ", svc_id='" + svc_id + '\'' +
        ", usr_id='" + usr_id + '\'' +
        ", email='" + email + '\'' +
        ", name='" + name + '\'' +
        ", tel='" + tel + '\'' +
        ", usr_pwd='" + usr_pwd + '\'' +
        ", createdDate=" + createdDtm +
        ", recentVisitDate=" + recentVisitDtm +
        ", penalty_cnt=" + penalty_cnt +
        ", admin_yn='" + admin_yn + '\'' +
        ", use_yn='" + use_yn + '\'' +
        ", block_yn='" + block_yn + '\'' +
        ", admin_memo='" + admin_memo + '\'' +
        '}';
  }
}
