package com.spring.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = formatter.format(date);
        return strDate;
    }
    public static String getDateConvert(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String strDate = formatter.format(date);
        return strDate;
    }
}
