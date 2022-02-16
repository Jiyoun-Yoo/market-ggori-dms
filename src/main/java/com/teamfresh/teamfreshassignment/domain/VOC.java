package com.teamfresh.teamfreshassignment.domain;

import java.util.Date;

public class VOC {
  private int voc_no;
  private User writer;
  private User admin_usr; //팀프레시 관리자
  private Delivery devliery; //배송 건
  private String reason;
  private Date createdDate;
  private Date updatedDate;
  private String state; //처리 상태(P: 진행중, Y: 완료. Z: 취소)
  private String penalty_yn; //패널티 여부
  private int admin_memo;
  private int fault_usr_memo;

  public int getVoc_no() {
    return voc_no;
  }

  public VOC setVoc_no(int voc_no) {
    this.voc_no = voc_no;
    return this;
  }

  public User getWriter() {
    return writer;
  }

  public VOC setWriter(User writer) {
    this.writer = writer;
    return this;
  }

  public User getAdmin_usr() {
    return admin_usr;
  }

  public VOC setAdmin_usr(User admin_usr) {
    this.admin_usr = admin_usr;
    return this;
  }

  public Delivery getDevliery() {
    return devliery;
  }

  public VOC setDevliery(Delivery devliery) {
    this.devliery = devliery;
    return this;
  }

  public String getReason() {
    return reason;
  }

  public VOC setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public VOC setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  public Date getUpdatedDate() {
    return updatedDate;
  }

  public VOC setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

  public String getState() {
    return state;
  }

  public VOC setState(String state) {
    this.state = state;
    return this;
  }

  public String getPenalty_yn() {
    return penalty_yn;
  }

  public VOC setPenalty_yn(String penalty_yn) {
    this.penalty_yn = penalty_yn;
    return this;
  }

  public int getAdmin_memo() {
    return admin_memo;
  }

  public VOC setAdmin_memo(int admin_memo) {
    this.admin_memo = admin_memo;
    return this;
  }

  public int getFault_usr_memo() {
    return fault_usr_memo;
  }

  public VOC setFault_usr_memo(int fault_usr_memo) {
    this.fault_usr_memo = fault_usr_memo;
    return this;
  }
}
