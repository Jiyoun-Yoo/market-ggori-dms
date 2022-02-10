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
}
