package com.chenshinan.framework.infra.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间/日期相关
 *
 * @author shinan.chen
 * @since 2021/5/16
 */
public class DateUtil {

    /**
     * 注意：SimpleDateFormat不是线程安全的，因此在多线程环境中使用时，需要使用同步代码synchronized
     */
    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 时间转字符串
     *
     * @param date 时间
     * @return 字符串
     */
    public synchronized static String date2Str(Date date) {
        return dateTimeFormat.format(date);
    }

    /**
     * 字符串转时间
     *
     * @param dateStr 字符串
     * @return 时间
     */
    public synchronized static Date str2Date(String dateStr) {
        try {
            return dateTimeFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间戳转字符串
     *
     * @param timestamp 时间戳
     * @return 字符串
     */
    public synchronized static String timestamp2Str(long timestamp) {
        return dateTimeFormat.format(new Date(timestamp));
    }

    /**
     * 获取当前时间搓
     *
     * @return 当前时间搓
     */
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
