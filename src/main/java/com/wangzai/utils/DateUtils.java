package com.wangzai.utils;

import com.github.pagehelper.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangw
 * @ClassName: DateUtils
 * @Description: TODO
 * @date 2018-9-29 上午11:17:14
 */
public class DateUtils {

    public static final long SECONDSPERDAY = 24 * 60 * 60;
    public static final String DATE_LONGER = "yyyy-MM-dd HH:mm:ss";

    /**
     * 得到当前时间
     *
     * @return Date 返回信息
     */
    public static Date getCurDateTime() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.getTime());
    }

    /**
     * 得到当前日期
     *
     * @return Date 返回信息
     */
    public static Date getCurDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return getShortDate(df.format(new Date()));
    }

    /**
     * 把字符串转换成短日期(yyyy-MM-dd)
     *
     * @param strDate 输入对象
     * @return Date 返回信息
     */
    public static Date getShortDate(String strDate) {
        Date date = null;

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            date = df.parse(strDate);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return date;
    }

    /**
     * 增加小时
     *
     * @param date
     * @param hours
     * @return
     */
    public static Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);

        return calendar.getTime();
    }

    /**
     * 增加分钟
     *
     * @param date
     * @param minutes
     * @return
     */
    public static Date addMinutes(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);

        return calendar.getTime();
    }

    /**
     * 增加天数
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);

        return calendar.getTime();
    }

    /**
     * 增加月数
     *
     * @param date
     * @param months
     * @return
     */
    public static Date addMonth(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);

        return calendar.getTime();
    }

    /**
     * 增加年数
     *
     * @param date
     * @param years
     * @return
     */
    public static Date addYear(Date date, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);

        return calendar.getTime();
    }

    /**
     * 把字符串转换成长日期(yyyy-MM-dd HH:mm:ss)
     *
     * @param strDate 输入对象
     * @return Date 返回信息
     */
    public static Date getLongDate(String strDate) {
        Date date = null;

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = df.parse(strDate);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return date;
    }

    /**
     * 把字符串转换成日期(yyyy-MM-dd HH:mm:ss)
     *
     * @param strDate 输入对象
     * @return Date 返回信息
     */
    public static Date getMiddleDate(String strDate) {
        Date date = null;

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            date = df.parse(strDate);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return date;
    }

    /**
     * 格式化时间
     *
     * @param date
     * @param pattern 例如 : yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * 格式化时间 date 为null返回defaultIfNull
     *
     * @param date
     * @param pattern
     * @param defaultIfNull
     * @return
     */
    public static String format(Date date, String pattern, String defaultIfNull) {
        if (date == null) {
            return defaultIfNull;
        }
        return format(date, pattern);
    }

    /**
     * 按默认格式yyyy-MM-dd HH:mm:ss 格式化时间
     *
     * @param date
     * @return
     */
    public static String toString(Date date) {
        if (date == null) {
            return "";
        }
        return DateUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 计算两个时间之间的相隔天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getIntervalDays(Date startDate, Date endDate) {

        // 分别得到两个时间的毫秒数
        long sl = startDate.getTime();
        long el = endDate.getTime();

        long ei = el - sl;

        // 根据毫秒数计算间隔天数
        return (int) (ei / (1000 * 60 * 60 * 24));
    }

    /**
     * 计算两个时间之间的相隔月数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getIntervalMonths(Date startDate, Date endDate) {
        /**
         * int iMonth = 0; int flag = 0; Calendar calendarStart =
         * Calendar.getInstance(); calendarStart.setTime(startDate); Calendar
         * calendarEnd = Calendar.getInstance(); calendarEnd.setTime(endDate);
         * if (calendarEnd.equals(calendarStart)) { return 0; } if
         * (calendarStart.after(calendarEnd)) { Calendar temp = calendarStart;
         * calendarStart = calendarEnd; calendarEnd = temp; } // if
         * (calendarEnd.get(Calendar.DAY_OF_MONTH) <
         * calendarStart.get(Calendar.DAY_OF_MONTH)) // flag = 1; if
         * (calendarEnd.get(Calendar.YEAR) > calendarStart.get(Calendar.YEAR)) {
         * iMonth = ((calendarEnd.get(Calendar.YEAR) -
         * calendarStart.get(Calendar.YEAR)) * 12 +
         * calendarEnd.get(Calendar.MONTH) - flag) -
         * calendarStart.get(Calendar.MONTH); } else { iMonth =
         * calendarEnd.get(Calendar.MONTH) - calendarStart.get(Calendar.MONTH) -
         * flag; } return iMonth;
         **/
        // 分别得到两个时间的毫秒数
        long sl = startDate.getTime();
        long el = endDate.getTime();

        long ei = el - sl;

        // 根据毫秒数计算间隔月数
        return Math.round((ei / ((1000 * 60 * 60 * 24) * 30.5F)));
    }

    /**
     * 计算两个时间之间的相隔月数，向上取整
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getIntervalMonthsCeil(Date startDate, Date endDate) {
        // 分别得到两个时间的毫秒数
        long sl = startDate.getTime();
        long el = endDate.getTime();

        long ei = el - sl;

        // 根据毫秒数计算间隔月数
        return (int) Math.ceil((ei / ((1000 * 60 * 60 * 24) * 30.5F)));
    }

    /**
     * 计算两个时间之间的相隔年数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getIntervalYears(Date startDate, Date endDate) {

        // 分别得到两个时间的毫秒数
        long sl = startDate.getTime();
        long el = endDate.getTime();

        long ei = el - sl;

        // 根据毫秒数计算间隔年数
        return Math.round((ei / (1000 * 60 * 60 * 24) / 365));
    }

    /**
     * 计算两个时间之间的相隔年数，向上取整
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getIntervalYearsCeil(Date startDate, Date endDate) {
        // 分别得到两个时间的毫秒数
        long sl = startDate.getTime();
        long el = endDate.getTime();

        long ei = el - sl;

        // 根据毫秒数计算间隔年数
        return (int) Math.ceil((ei / (1000 * 60 * 60 * 24) / 365F));
    }

    /**
     * 计算两个时间之间的相隔分钟数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getIntervalMinutes(Date startDate, Date endDate) {

        // 分别得到两个时间的毫秒数
        long sl = startDate.getTime();
        long el = endDate.getTime();

        long ei = el - sl;

        // 根据毫秒数计算间隔分钟数
        return (int) (ei / (1000 * 60));
    }

    /**
     * 计算两个时间之间的相隔秒数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getIntervalSeconds(Date startDate, Date endDate) {

        // 分别得到两个时间的毫秒数
        long sl = startDate.getTime();
        long el = endDate.getTime();

        long ei = el - sl;

        // 根据毫秒数计算间隔分钟数
        return (int) (ei / 1000);
    }

    /**
     * 计算两个时间之间的相隔分钟数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getIntervalMinutes(long startDate, long endDate) {
        long ei = endDate - startDate;

        // 根据毫秒数计算间隔分钟数
        return (int) (ei / (1000 * 60));
    }

    /**
     * 计算两个时间之间的相隔小时数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getIntervalHours(Date startDate, Date endDate) {

        // 分别得到两个时间的毫秒数
        long sl = startDate.getTime();
        long el = endDate.getTime();

        long ei = el - sl;

        // 根据毫秒数计算间隔小时数
        return (int) (ei / (1000 * 60 * 60));
    }

    /*
     * Get a java.util.Date according to java.sql.Date and java.sql.Time
     *
     * @param date -the date, yyyy-mm-dd
     *
     * @param time -the time, hh:mm:ss
     *
     * @return if date is null then return null, else return java.util.Date
     */

    public static Date parse(String date, String time) {

        if (date != null && time != null) {
            return DateUtils.getLongDate(String.format("%s %s", date, time));
        }

        if (date != null) {
            return DateUtils.getShortDate(date);
        }
        return null;
    }

    /**
     * 解析与给定date匹配的pattern日期类型Date
     *
     * @param
     * @param datePattern
     * @return
     */
    public static Date parseDate(String strDate, String datePattern) {
        Date date = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat(datePattern);
            date = df.parse(strDate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    /**
     * @param date
     * @return 周一到周日分别为 1 2 3 4 5 6 0
     */
    public static int getWeekDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek - 1;
    }

    /**
     * 获取某年第一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getCurrYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getCurrYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * 获取当月的月份
     *
     * @param date
     * @return
     */
    public static int getMonthofYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * @param @param  longDate
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     * @Title: formatToStandardDate
     * @Description: 传入yyyyMMddHHmm 传出标准格式
     */
    public static String formatToStandardDate(String longDate) {
        String year = null;
        String month = null;
        String day = null;
        String hour = null;
        String min = null;
        String result = "";
        if (longDate.length() == 12) {
            year = longDate.substring(0, 4);
            month = longDate.substring(4, 6);
            day = longDate.substring(6, 8);
            hour = longDate.substring(8, 10);
            min = longDate.substring(10, 12);
            result = year.concat("-").concat(month).concat("-").concat(day)
                    .concat(" ").concat(hour).concat(":").concat(min);
            return result;
        }

        if (longDate.length() == 10) {
            year = longDate.substring(0, 4);
            month = longDate.substring(4, 6);
            day = longDate.substring(6, 8);
            hour = longDate.substring(8, 10);

            result = year.concat("-").concat(month).concat("-").concat(day)
                    .concat(" ").concat(hour).concat(":00");
            return result;
        }
        if (longDate.length() == 8) {
            year = longDate.substring(0, 4);
            month = longDate.substring(4, 6);
            day = longDate.substring(6, 8);

            result = year.concat("-").concat(month).concat("-").concat(day);

            return result;
        }
        if (longDate.length() == 6) {
            year = longDate.substring(0, 4);
            month = longDate.substring(4, 6);
            result = year.concat("-").concat(month);
            return result;
        }
        if (longDate.length() == 4) {
            year = longDate.substring(0, 4);
            month = longDate.substring(4, 6);
            result = year;
            return result;
        }
        return "";

    }


    /**
     * 将时间转化成字符
     *
     * @param date 日期类型 (Null时,取当前时间)
     * @param form 匹配模式 (默认:YYYY-MM-DD HH:mm:ss)
     * @return
     */
    public static String getDateFormat(Date date, String form) {
        if (date == null)
            date = new Date(System.currentTimeMillis());
        SimpleDateFormat sf;
        if (StringUtil.isEmpty(form))
            sf = new SimpleDateFormat(DATE_LONGER);
        else
            sf = new SimpleDateFormat(form);
        return sf.format(date);
    }

    public static String getDateFormat(java.util.Date date) {
        if (date == null)
            date = new Date(System.currentTimeMillis());
        SimpleDateFormat sf;
        sf = new SimpleDateFormat(DATE_LONGER);
        return sf.format(date);
    }

//    private static int getParkingDay(String beginTime, String endTime) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        long begin = 0;
//        long end = 0;
//        try {
//            end = sdf.parse(endTime.replace("%20", " ")).getTime();
//            sdf = new SimpleDateFormat("yyyy-MM-dd");
//            begin = sdf.parse(beginTime.replace("%20", " ")).getTime();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        int timeSecond = (int) ((end - begin) / 1000);//计算相差多少秒
//        int day = timeSecond / (24 * 60 * 60) + 1;//取整
//        return day;
//    }

//    public static void main(String[] args) {
//
////        Date d = DateUtils.parseDate(toString(new Date()), "yyyy-MM-dd HH:mm");
////        System.out.println(d);
//        int parkingDay = getParkingDay("2019-07-19 23:39:00", "2019-07-26 07:39:52");
//        System.err.println(parkingDay);
//    }
}
