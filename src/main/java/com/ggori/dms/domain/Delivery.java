package com.ggori.dms.domain;

import java.util.Date;

public class Delivery {
  private int delivery_no;
  private User writer; //등록자
  private User admin_usr; //관리 담당자
  private String requestedCompany; //요청업체
  private User driver_usr; //배송 담당자
  private String driver_check_yn; //배송 담당자 확인 여부
  private String product; //배송 물품
  private String departure; //출발지
  private String destination; //도착지
  private String createdDtm; //배송 요청 발생일
  private String requestedDateTime; //배송 요청일
  private Date completedDtm; //배송일
  private String state; //진행 상태(D: 예정, P: 진행중, Y: 완료, Z:취소, D: 보류)
  private String detail;
  private String admin_memo;

  public Delivery() {
  }

  public Delivery(int no, User writer, User admin_usr,
      User penalty_usr, String departure, String destination, Date startDate, String state,
      String detail, String admin_comment) {
    this.delivery_no = no;
    this.writer = writer;
    this.admin_usr = admin_usr;
    this.driver_usr = penalty_usr;
    this.departure = departure;
    this.destination = destination;
    this.completedDtm = startDate;
    this.state = state;
    this.detail = detail;
    this.admin_memo = admin_comment;
  }

  public int getDelivery_no() {
    return delivery_no;
  }

  public Delivery setDelivery_no(int delivery_no) {
    this.delivery_no = delivery_no;
    return this;
  }

  public User getWriter() {
    return writer;
  }

  public Delivery setWriter(User writer) {
    this.writer = writer;
    return this;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public User getAdmin_usr() {
    return admin_usr;
  }

  public Delivery setAdmin_usr(User admin_usr) {
    this.admin_usr = admin_usr;
    return this;
  }

  public String getRequestedCompany() {
    return requestedCompany;
  }

  public void setRequestedCompany(String requestedCompany) {
    this.requestedCompany = requestedCompany;
  }

  public User getDriver_usr() {
    return driver_usr;
  }

  public Delivery setDriver_usr(User driver_usr) {
    this.driver_usr = driver_usr;
    return this;
  }

  public String getDriver_check_yn() {
    return driver_check_yn;
  }

  public Delivery setDriver_check_yn(String driver_check_yn) {
    this.driver_check_yn = driver_check_yn;
    return this;
  }

  public String getDeparture() {
    return departure;
  }

  public Delivery setDeparture(String departure) {
    this.departure = departure;
    return this;
  }

  public String getDestination() {
    return destination;
  }

  public Delivery setDestination(String destination) {
    this.destination = destination;
    return this;
  }

  public String getCreatedDtm() {
    return createdDtm;
  }

  public void setCreatedDtm(String createdDtm) {
    this.createdDtm = createdDtm;
  }

  public String getRequestedDateTime() {
    return requestedDateTime;
  }

  public void setRequestedDateTime(String requestedDateTime) {
    this.requestedDateTime = requestedDateTime;
  }

  public Date getCompletedDtm() {
    return completedDtm;
  }

  public Delivery setCompletedDtm(Date completedDtm) {
    this.completedDtm = completedDtm;
    return this;
  }

  public String getState() {
    return state;
  }

  public Delivery setState(String state) {
    this.state = state;
    return this;
  }

  public String getDetail() {
    return detail;
  }

  public Delivery setDetail(String detail) {
    this.detail = detail;
    return this;
  }

  public String getAdmin_memo() {
    return admin_memo;
  }

  public Delivery setAdmin_memo(String admin_memo) {
    this.admin_memo = admin_memo;
    return this;
  }

  @Override
  public String toString() {
    return "Delivery{" +
        "delivery_no=" + delivery_no +
        ", writer=" + writer +
        ", admin_usr=" + admin_usr +
        ", requestedCompany='" + requestedCompany + '\'' +
        ", driver_usr=" + driver_usr +
        ", driver_check_yn='" + driver_check_yn + '\'' +
        ", product='" + product + '\'' +
        ", departure='" + departure + '\'' +
        ", destination='" + destination + '\'' +
        ", createdDtm='" + createdDtm + '\'' +
        ", requestedDateTime='" + requestedDateTime + '\'' +
        ", completedDate=" + completedDtm +
        ", state='" + state + '\'' +
        ", detail='" + detail + '\'' +
        ", admin_memo='" + admin_memo + '\'' +
        '}';
  }
}
