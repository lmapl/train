package com.train.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 *
 * @author wangbo
 * @version 1.0 2017/8/22
 */
public class DateUtil {
    public static final String YMD_FORMAT = "yyyyMMdd";

    private static final String YYYYMM_FORMAT = "yyyy-MM";
    private static final String DATETIME_FORMAT = "yyyy-MM-dd";

    private static final String ISO_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String format(Calendar date, String pattern) {
        return format(date.getTime(), pattern);
    }

    public static Date parse(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat(ISO_DATETIME_FORMAT);
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parse(String dateStr, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

}
