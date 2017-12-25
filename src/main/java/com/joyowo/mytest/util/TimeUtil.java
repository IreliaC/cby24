package com.joyowo.mytest.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;


/**
 * 基于JDK8 time包的时间工具类
 *
 * @author wanglei
 * @date 2017.12.12
 * @since v1.0.0
 */
public final class TimeUtil {

    /**
     * 获取默认时间格式: yyyy-MM-dd HH:mm:ss
     */
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = TimeFormat.LONG_DATE_PATTERN_LINE.formatter;

    /**
     * 获取默认时区: Asia/Shanghai
     */
    private static final ZoneId DEFAULT_ZONE = ZoneId.of("Asia/Shanghai");

    /**
     * 获取默认时区偏移量: +8
     */
    private static final ZoneOffset DEFAULT_ZONE_OFF_SET = ZoneOffset.of("+8");

    private TimeUtil() {
        // no construct function
    }

    /**
     * 时间转 String
     *
     * @param time 待转时间
     * @return String
     */
    private static String parseTime(LocalDateTime time) {
        return DEFAULT_DATETIME_FORMATTER.format(time);
    }

    /**
     * 时间转 String
     *
     * @param time 待转时间
     * @param format 时间格式
     * @return String
     */
    private static String parseTime(LocalDateTime time, TimeFormat format) {
        return format.formatter.format(time);
    }

    /**
     * int 转时间
     *
     * @param time 待转时间
     * @return LocalDateTime
     */
    private static LocalDateTime parseTime(int time) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(time), DEFAULT_ZONE);
    }

    /**
     * int 转时间
     *
     * @param time 待转时间
     * @return LocalDateTime
     */
    private static LocalDate parseTimeToDate(int time) {
        return parseTime(time).toLocalDate();
    }

    /**
     * 时间转 int
     *
     * @param time 待转时间
     * @return int
     */
    public static int parseTimeToInt(LocalDateTime time) {
        return (int)time.toEpochSecond(DEFAULT_ZONE_OFF_SET);
    }

    /**
     * 获取当前时间(秒)
     *
     * @return int
     */
    public static int getCurrentTime() {
        return parseTimeToInt(LocalDateTime.now());
    }

    /**
     * int 转时间String
     *
     * @param time 待转时间
     * @param format 时间格式
     * @return String
     */
    public static String parseTime(int time, TimeFormat format) {
        return parseTime(parseTime(time), format);
    }

    /**
     * 时间加 (正数为加，负数为减)
     *
     * @param time 待处理时间
     * @param num   数量
     * @param temporalUnit 时间单位 ChronoUnit.DAYS，ChronoUnit.YEARS，ChronoUnit.MONTHS
     * @return int
     */
    public static int timePlus(int time, int num, TemporalUnit temporalUnit) {
        return parseTimeToInt(parseTime(time).plus(num, temporalUnit));
    }

    /**
     * 获取日期差额（跨年计算不适用）
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return Period
     */
    private static Period dateBetween(int startTime, int endTime) {
        return Period.between(parseTimeToDate(startTime), parseTimeToDate(endTime));
    }

    /**
     * 获取相差天数
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 0相等 <0前者大 >后者大
     */
    public static int daysBetween(int startTime, int endTime) {
        LocalDate start = parseTimeToDate(startTime);
        LocalDate end = parseTimeToDate(endTime);
        return (int)start.until(end, ChronoUnit.DAYS);
    }

    /**
     * 获取相差月份
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 0相等 <0前者大 >0后者大
     */
    public static int monthsBetween(int startTime, int endTime) {
        LocalDate start = parseTimeToDate(startTime);
        LocalDate end = parseTimeToDate(endTime);
        return (end.getYear() - start.getYear()) * 12 + (end.getMonthValue() - start.getMonthValue());
    }

    /**
     * 获取时间差额
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return Duration
     */
    private static Duration timeBetween(int startTime, int endTime) {
        return Duration.between(parseTime(startTime), parseTime(endTime));
    }

    /**
     * 时间格式
     */
    public enum TimeFormat {

        /**
         * 短时间格式
         */
        SHORT_DATE_PATTERN_LINE("yyyy-MM-dd"),
        SHORT_DATE_PATTERN_SLASH("yyyy/MM/dd"),
        SHORT_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd"),
        SHORT_DATE_PATTERN_NONE("yyyyMMdd"),
        SHORT_DATE_PATTERN_WORD("yyyy年MM月dd日"),

        /**
         * 长时间格式
         */
        LONG_DATE_PATTERN_LINE("yyyy-MM-dd HH:mm:ss"),
        LONG_DATE_PATTERN_SLASH("yyyy/MM/dd HH:mm:ss"),
        LONG_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss"),
        LONG_DATE_PATTERN_NONE("yyyyMMdd HH:mm:ss"),

        /**
         * 长时间格式 带毫秒
         */
        LONG_DATE_PATTERN_WITH_MILSEC_LINE("yyyy-MM-dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_SLASH("yyyy/MM/dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_NONE("yyyyMMdd HH:mm:ss.SSS");

        private transient DateTimeFormatter formatter;

        TimeFormat(String pattern) {
            formatter = DateTimeFormatter.ofPattern(pattern);
        }
    }
}
