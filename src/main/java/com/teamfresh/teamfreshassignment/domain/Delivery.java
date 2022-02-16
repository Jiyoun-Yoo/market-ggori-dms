package com.teamfresh.teamfreshassignment.domain;

import java.util.Date;

public class Delivery {
  private int delivery_no;
  private User writer; //등록자
  private User admin_usr; //관리 담당자
  private User delivery_usr; //배송 담당자
  private String deliver_check_yn; //배송 담당자 확인 여부
  private String departure; //출발지
  private String destination; //도착지
  private Date createdDate; //배송 요청 발생일
  private Date requestedDate; //배송 요청일
  private Date complatedcDate; //배송일
  private String state; //진행 상태(D: 예정, P: 진행중, Y: 완료, Z:취소, D: 보류)
  private String detail;
  private String admin_memo;

  public Delivery(int no, User writer, User admin_usr,
      User delivery_usr, String departure, String destination, Date startDate, String state,
      String detail, String admin_comment) {
    this.delivery_no = no;
    this.writer = writer;
    this.admin_usr = admin_usr;
    this.delivery_usr = delivery_usr;
    this.departure = departure;
    this.destination = destination;
    this.complatedcDate = startDate;
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

  public User getAdmin_usr() {
    return admin_usr;
  }

  public Delivery setAdmin_usr(User admin_usr) {
    this.admin_usr = admin_usr;
    return this;
  }

  public User getDelivery_usr() {
    return delivery_usr;
  }

  public Delivery setDelivery_usr(User delivery_usr) {
    this.delivery_usr = delivery_usr;
    return this;
  }

  public String getDeliver_check_yn() {
    return deliver_check_yn;
  }

  public Delivery setDeliver_check_yn(String deliver_check_yn) {
    this.deliver_check_yn = deliver_check_yn;
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

  public Date getCreatedDate() {
    return createdDate;
  }

  public Delivery setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  public Date getRequestedDate() {
    return requestedDate;
  }

  public Delivery setRequestedDate(Date requestedDate) {
    this.requestedDate = requestedDate;
    return this;
  }

  public Date getComplatedcDate() {
    return complatedcDate;
  }

  public Delivery setComplatedcDate(Date complatedcDate) {
    this.complatedcDate = complatedcDate;
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

}
