package com.xingyu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String date2String(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr=simpleDateFormat.format(date);
        return dateStr;
    }
}
