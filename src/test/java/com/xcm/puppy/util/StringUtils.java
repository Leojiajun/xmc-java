package com.xcm.puppy.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jenkins on 24/8/16.
 */
public class StringUtils {

    public static String now(String format)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }

    public static String getDate(String format, int days)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, days);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(calendar.getTime());
    }

    public static String substring(String str, String left, String right)
    {
        int beginIndex = str.indexOf(left) + left.length();
        int endIndex = str.indexOf(right);
        return str.substring(beginIndex, endIndex);
    }
}
