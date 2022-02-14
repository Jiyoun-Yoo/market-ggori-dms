package com.teamfresh.teamfreshassignment.domain;

import java.util.Date;

public class Penalty {
  private int penalty_no;
  private User admin_usr; //팀프레시 관리자
  private User penalty_usr; //패널티 받는 배송 기사
  private VOC voc;
  private String reason;
  private Date createdDate;
  private Date updatedDate;
  private String state; //처리 상태(P: 진행중, Y: 완료. Z: 취소)
  private int admin_comment;
  private int usr_comment;

  public Penalty(int penalty_no, User admin_usr,
      User penalty_usr, VOC voc, String reason, Date createdDate, Date updatedDate,
      String state, int admin_comment, int usr_comment) {
    this.penalty_no = penalty_no;
    this.admin_usr = admin_usr;
    this.penalty_usr = penalty_usr;
    this.voc = voc;
    this.reason = reason;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
    this.state = state;
    this.admin_comment = admin_comment;
    this.usr_comment = usr_comment;
  }

  public int getPenalty_no() {
    return penalty_no;
  }

  public Penalty setPenalty_no(int penalty_no) {
    this.penalty_no = penalty_no;
    return this;
  }

  public User getAdmin_usr() {
    return admin_usr;
  }

  public Penalty setAdmin_usr(User admin_usr) {
    this.admin_usr = admin_usr;
    return this;
  }

  public User getPenalty_usr() {
    return penalty_usr;
  }

  public Penalty setPenalty_usr(User penalty_usr) {
    this.penalty_usr = penalty_usr;
    return this;
  }

  public VOC getVoc() {
    return voc;
  }

  public Penalty setVoc(VOC voc) {
    this.voc = voc;
    return this;
  }

  public String getReason() {
    return reason;
  }

  public Penalty setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public Penalty setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  public Date getUpdatedDate() {
    return updatedDate;
  }

  public Penalty setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

  public String getState() {
    return state;
  }

  public Penalty setState(String state) {
    this.state = state;
    return this;
  }

  public int getAdmin_comment() {
    return admin_comment;
  }

  public Penalty setAdmin_comment(int admin_comment) {
    this.admin_comment = admin_comment;
    return this;
  }

  public int getUsr_comment() {
    return usr_comment;
  }

  public Penalty setUsr_comment(int usr_comment) {
    this.usr_comment = usr_comment;
    return this;
  }
}
