package com.teamfresh.teamfreshassignment.domain;

import java.util.Date;

public class Delivery {
  private int no;
  private User writer; //등록자
  private User admin_usr; //관리 담당자
  private User delivery_usr; //배송 담당자
  private String departure; //출발지
  private String destination; //도착지
  private Date createdDate; //배송 요청 발생일
  private Date requestedDate; //배송 완료 요청일
  private Date startDate; //배송 출발일
  private Date complatedDate; //배송일
  private String state; //진행 상태(D: 예정, P: 진행중, Y: 완료, Z:취소, D: 보류)
  private String memo;
  private String admin_comment;

  public Delivery(int no, User writer, User admin_usr,
      User delivery_usr, String departure, String destination, Date startDate, String state,
      String memo, String admin_comment) {
    this.no = no;
    this.writer = writer;
    this.admin_usr = admin_usr;
    this.delivery_usr = delivery_usr;
    this.departure = departure;
    this.destination = destination;
    this.startDate = startDate;
    this.state = state;
    this.memo = memo;
    this.admin_comment = admin_comment;
  }

  public int getNo() {
    return no;
  }

  public Delivery setNo(int no) {
    this.no = no;
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

  public Date getStartDate() {
    return startDate;
  }

  public Delivery setStartDate(Date startDate) {
    this.startDate = startDate;
    return this;
  }

  public Date getComplatedDate() {
    return complatedDate;
  }

  public Delivery setComplatedDate(Date complatedDate) {
    this.complatedDate = complatedDate;
    return this;
  }

  public String getState() {
    return state;
  }

  public Delivery setState(String state) {
    this.state = state;
    return this;
  }

  public String getMemo() {
    return memo;
  }

  public Delivery setMemo(String memo) {
    this.memo = memo;
    return this;
  }

  public String getAdmin_comment() {
    return admin_comment;
  }

  public Delivery setAdmin_comment(String admin_comment) {
    this.admin_comment = admin_comment;
    return this;
  }

}
