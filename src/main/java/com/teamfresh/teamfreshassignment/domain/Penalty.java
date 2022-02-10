package com.teamfresh.teamfreshassignment.domain;

import java.util.Date;

public class Penalty {
  private int no;
  private User admin_usr; //팀프레시 관리자
  private User penalty_usr; //팀프레시 관리자
  private String reason;
  private Date createdDate;
  private Delivery devliery; //배송 건
  private Date updatedDate;
  private Date deletedDate;
  private String state; //처리 상태(P: 진행중, Y: 완료. Z: 취소)
  private Date endDate; //종료일
  private int admin_comment;
  private int usr_comment;
}
