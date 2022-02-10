package com.teamfresh.teamfreshassignment.domain;

import java.util.Date;

public class User {
  private int no;
  private String usr_id;
  private String email;
  private String name;
  private String tel;
  private String usr_pwd;
  private Date createdDate;
  private Date recentVisitedDate;
  private String photo;
  private int penalty_cnt; //패널티 횟수
  private String admin_yn; //관리자 여부
  private String use_yn; //사용 여부
  private String block_yn; //차단 여부
  private String admin_comment;

}
