package com.mryi.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
  // 日期转换为字符串
  public static String date2String(Date date, String patt) {
    SimpleDateFormat sdf = new SimpleDateFormat(patt);
    String s = sdf.format(date);
    return s;
  }
  // 字符串转换为日期
  public static Date string2date(String str, String patt) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat(patt);
    Date parse = sdf.parse(str);
    return parse;
  }
}
