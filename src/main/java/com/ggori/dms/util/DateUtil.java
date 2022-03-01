package com.ggori.dms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

  SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
  SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

  public String getToday() {
    return format1.format(new Date());
  }

  public String getNow() {
    return format2.format(new Date());
  }

}
