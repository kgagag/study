package com.gray.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间工具类
 * 
 * @author liuyingbo
 * @CreateTime 2015年01月08日
 */
public class DateUtil {
    private static final Logger logger = LoggerFactory
            .getLogger(DateUtil.class);

    public final static String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public final static String YMD_PATTERN = "yyyyMMdd";

    public final static String YMD_HYPHEN_PATTERN = "yyyy-MM-dd";

    private final static String MSG_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    private final static SimpleDateFormat sf = new SimpleDateFormat();

    /**
     * 返回yyyy-MM-dd格式的日期字符串<BR>
     * 
     * @param date
     * @return
     */
    public static String format(Date date) {
        if (date == null) {
            return "";
        }
        sf.applyPattern(YMD_HYPHEN_PATTERN);
        return sf.format(date);
    }

    /**
     * 返回相应格式的日期字符串<BR>
     * 
     * @param date
     * @param formatPattern
     *            若未指定则默认为“yyyy-MM-dd”格式
     * @return
     */
    // public static String format(Date date, String formatPattern) {
    // if (date == null) {
    // return "";
    // }
    // if (StringHelper.isBlank(formatPattern)) {
    // formatPattern = YMD_HYPHEN_PATTERN;
    // }
    // sf.applyPattern(formatPattern);
    // return sf.format(date);
    // }

    /**
     * 将给定的日期转换为yyyy-MM-dd HH:mm:ss格式的字符串
     * 
     * @param date
     *            长整型格式的日期
     * @return yyyy-MM-dd HH:mm:ss格式的日期字符串
     */
    public static String format(Long date) {
        return format(date, DATE_TIME);
    }

    /**
     * 将给定的日期转换为指定格式的日期字符串
     * 
     * @param date
     *            长整形格式的日期
     * @param pattern
     *            指定格式如：yyyy-MM-dd HH:mm:ss
     * @return 指定格式的日期字符串
     */
    public static String format(Long date, String pattern) {
        sf.applyPattern(pattern);
        return sf.format(date);
    }

    /**
     * 将当前日期转换为yyyy-MM-dd格式的字符串
     * 
     * @return yyyy-MM-dd格式的日期字符串
     */
    public static String format() {
        sf.applyPattern(YMD_HYPHEN_PATTERN);
        return sf.format(System.currentTimeMillis());
    }

    /**
     * 根据不同pattern解析日期字符串<BR>
     * 
     * @param dateStr
     * @param pattern
     *            若未指定则默认为“yyyy-MM-dd”格式
     * @return
     */
    // public static Date parse(String dateStr, String pattern) {
    // if (StringHelper.isBlank(dateStr)) {
    // return null;
    // }
    // if (StringHelper.isBlank(pattern)) {
    // pattern = YMD_HYPHEN_PATTERN;
    // }
    // try {
    // sf.applyPattern(pattern);
    // return sf.parse(dateStr);
    // }
    // catch (ParseException e) {
    // logger.error(e.getMessage(), e);
    // }
    // return null;
    // }

    /**
     * 当前时间的时间戳（精确到秒）。
     * 
     * @return
     */
    public static Integer nowTimeStamp() {
        Long nowTime = System.currentTimeMillis() / 1000;
        return Integer.valueOf(nowTime.toString());
    }

    /**
     * 获取指定日期的时间戳。
     * 
     * @param date
     * @return
     */
    public static int getTimestamp(Date date) {
        if (date == null) {
            return 0;
        }
        return (int) (date.getTime() / 1000);
    }

    /**
     * 获取指定日期的时间戳。
     * 
     * @param date
     *            日期字符串
     * @param pattern
     *            日期格式
     * @return
     */
    // public static int getTimestamp(String date, String pattern) {
    // return getTimestamp(parse(date, pattern));
    // }

    public static String getMessageTime() {
        Calendar cal = Calendar.getInstance();
        int millis = cal.getTimeZone().getRawOffset();
        String sign;
        // assign sign + or - for GMT offset
        if (millis < 0) {
            sign = "-";
            millis = millis * (-1);
        }
        else {
            sign = "+";
        }
        int hr = (millis / 60000) / 60;
        int min = (millis / 60000) % 60;
        String hrs = "" + hr;
        String ms = "" + min;
        if (min < 10) {
            ms = "0" + ms;
        }
        if (hr < 10) {
            hrs = "0" + hrs;
        }
        String gmtOffset = sign + hrs + ":" + ms;
        sf.applyPattern(MSG_PATTERN);
        String messageTime = sf.format(new Date()) + gmtOffset;
        return messageTime;
    }

    /**
     * 返回相应格式的日期字符串 DateUtil.getDateString()<BR>
     * <P>
     * Author : hanweiwang
     * </P>
     * <P>
     * Date : 2015-3-9
     * </P>
     * 
     * @param date
     * @param formatPattern
     * @return
     */
    public static String getDateString(Date date, String formatPattern) {
        if (date == null) {
            return "";
        }
        if ((formatPattern == null) || formatPattern.equals("")) {
            formatPattern = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(formatPattern);
        return sdf.format(date);
    }

    /**
     * 返回距离给定日期的特定天数的日期
     * 
     * @param date
     * @param days>0时往前推，days<0时往后推
     * @return
     */
    public static Date getDiffDays(Date date, int days) {
        Date newDate = null;
        if (date == null) {
            return newDate;
        }
        if (days == 0) {
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        newDate = calendar.getTime();
        return newDate;
    }
}
