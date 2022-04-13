package com.ggori.dms.domain;

import java.util.Date;

public class VOC {
  private int voc_no;
  private int delivery_no; //배송 건
  private User writer;
  private User admin_usr; //마켓꼬리 관리자
  private String detail;
  private String createdDtm;
  private String updatedDtm;
  private String state; //처리 상태(P: 진행중, Y: 완료. Z: 취소)
  private String penalty_yn; //패널티 여부
  private String admin_memo;

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

  public int getDelivery_no() {
    return delivery_no;
  }

  public VOC setDelivery_no(int delivery_no) {
    this.delivery_no = delivery_no;
    return this;
  }

  public String getDetail() {
    return detail;
  }

  public VOC setDetail(String detail) {
    this.detail = detail;
    return this;
  }

  public String getCreatedDtm() {
    return createdDtm;
  }

  public VOC setCreatedDtm(String createdDtm) {
    this.createdDtm = createdDtm;
    return this;
  }

  public String getUpdatedDtm() {
    return updatedDtm;
  }

  public VOC setUpdatedDtm(String updatedDtm) {
    this.updatedDtm = updatedDtm;
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

  public String getAdmin_memo() {
    return admin_memo;
  }

  public VOC setAdmin_memo(String admin_memo) {
    this.admin_memo = admin_memo;
    return this;
  }

}
