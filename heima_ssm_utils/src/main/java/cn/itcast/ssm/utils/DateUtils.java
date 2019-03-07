package cn.itcast.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String dateToString(Date date,String patten){
         return new SimpleDateFormat(patten).format(date);
    }

    public static Date stringToDate(String date,String patten) throws ParseException {
        return new SimpleDateFormat("patten").parse(date);
    }
}
