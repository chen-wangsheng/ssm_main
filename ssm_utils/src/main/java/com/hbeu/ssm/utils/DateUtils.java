package com.hbeu.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈旺生
 * @create 2019-11-07 19:45
 */
public class DateUtils {
    //日期转字符串
    public static String date2String(Date date, String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }
    //字符串转日期
    public static Date string2Date(String str,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
