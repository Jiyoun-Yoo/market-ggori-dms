package com.teamfresh.teamfreshassignment.domain;

import java.util.Date;

public class VOC {
  private int no;
  private User writer;
  private User admin_usr; //팀프레시 관리자
  private Delivery devliery; //배송 건
  private String reason;
  private Date createdDate;
  private Date updatedDate;
  private String state; //처리 상태(P: 진행중, Y: 완료. Z: 취소)
  private Date endDate; //종료일
  private String penalty_yn; //패널티 여부
  private int admin_comment;
  private int usr_comment;
}
