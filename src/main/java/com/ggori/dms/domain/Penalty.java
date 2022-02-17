package com.ggori.dms.domain;

import java.util.Date;

public class Penalty {
  private int penalty_no;
  private int delivery_no;
  private int voc_no;
  private User admin_usr; //마켓꼬리 관리자
  private User penalty_usr; //패널티 받는 배송 기사
  private Date createdDate;
  private int penalty_amount; //패널티 금액
  private String usr_check_yn;
  private String state; //처리 상태(P: 진행중, Y: 완료. Z: 취소)
  private Date updatedDate;
  private int admin_memo;

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

  public int getVoc_no() {
    return voc_no;
  }

  public Penalty setVoc_no(int voc_no) {
    this.voc_no = voc_no;
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

  public int getAdmin_memo() {
    return admin_memo;
  }

  public Penalty setAdmin_memo(int admin_memo) {
    this.admin_memo = admin_memo;
    return this;
  }

}
