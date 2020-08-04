package com.xiaoyitong.app.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Method $
 * @Author $
 * @Version 1.0
 * @Description $
 * @Return $
 * @Exception $
 * @Date $ $
 */
public class DateFormatUtil {
    public static Date format(String date) throws ParseException {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date time= (java.util.Date) dateFormat.parse(date);
        return time;
    }
}
