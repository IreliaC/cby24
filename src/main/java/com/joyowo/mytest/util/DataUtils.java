
/*
 *
 * Copyright (c) 2015, joyowo. All rights reserved.
 */
package com.joyowo.mytest.util;


import com.joyowo.mytest.exception.ApiException;

import java.net.URLDecoder;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: DataUtils
 * @Description: 常用工具类
 * @author xingxp
 * @date 2015-9-9 上午11:07:50
 *
 */
public class DataUtils {
    public static final String numberChar = "0123456789";
    /**
     * @Title: isNull
     * @Description: 判断是否为空
     * @param str
     * @return true表示为空，false表示不为空
     */
    public static boolean isNull(String str){
        boolean flag = false;
        if(str == null || str.length() <= 0){
            flag = true;
        }
        return flag;
    }

    /**
     * @Title: isEmpty
     * @Description: 判断是否为空值
     * @param str
     * @return true表示为空值，false表示不为空值
     */
    public static boolean isEmpty(String str){
        boolean flag = false;
        if(str != null && str.length() <= 0){
            flag = true;
        }
        return flag;
    }

    /**
     * 邮箱验证
     * @param email
     * @return
     */
    public static boolean emailIsValid(String email){
        String check = "^([a-z0-9A-Z_]+[-|\\.]?)@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        return  matcher.matches();
    }

    /**
     * 用户名验证
     * @param userName
     * @return
     */
    public static boolean isNumberAndLetters(String userName){
        String check = "[A-Za-z0-9]*";
        Pattern regex = Pattern.compile(check);
        Matcher matcher=regex.matcher(userName);
        return matcher.matches();
    }
    /**
     * 判断是否为数字(浮点也包括)
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
    /**
     * 手机号格式校验
     * @param phone
     * @return
     */
    public static boolean phoneIsValid(String phone) {
        String check = "^1[34578]\\d{9}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(phone);
        return matcher.matches();
    }
    /**
     * @Title: arrToString
     * @Description: 字符串数组转为字符串
     * @param resourceIdsList
     * @return String
     */
    public static String arrToString(List<Integer> resourceIdsList){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < resourceIdsList.size(); i++){
            sb. append(String.valueOf(resourceIdsList.get(i))+",");
        }
        return sb.toString();
    }
    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @return 随机字符串
     */
    public static String generateString() {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i <=15; i++) {
            sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
        }
        return sb.toString();
    }

    /**
     * 证件正则匹配
     * @param cardNum
     * @return
     */
    public static boolean IdentityCard(String cardNum){
        String check ="^\\d{6}(((19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])\\d{3}([0-9]|x|X))|(\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])\\d{3}))$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(cardNum);
        return  matcher.matches();
    }

    /**
     * 根据身份编号获取年龄
     *
     * @param idCard
     *            身份编号
     * @return 年龄
     */
    public static int getAgeByIdCard(String idCard) {
        int iAge;
        Calendar cal = Calendar.getInstance();
        String year = idCard.substring(6, 10);
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }

    /**
     * 根据身份证号获取年龄(周岁)
     * @param idCard 身份证
     * @return 年龄
     */
    public static int getFullAgeByIdCard(String idCard){
        Calendar cal1 = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        cal1.set(Integer.parseInt(idCard.substring(6,10)),
                Integer.parseInt(idCard.substring(10,12)),
                Integer.parseInt(idCard.substring(12,14)));
        int m = (today.get(today.MONTH))+1 - (cal1.get(cal1.MONTH));
        int y = (today.get(today.YEAR)) - (cal1.get(cal1.YEAR));
        int d = (today.get(today.DAY_OF_MONTH)) - (cal1.get(cal1.DAY_OF_MONTH));
        if (m <= 0){
            if (m == 0){
                if (d < 0) y--;
            }else {
                y--;
            }
        }
        return y;
    }

    /**
     * 根据身份编号获取生日
     *
     * @param idCard 身份编号
     * @return 生日(yyyyMMdd)
     */
    public static String getBirthByIdCard(String idCard) {
        return idCard.substring(6, 14);
    }

    /**
     * 根据身份编号获取生日年
     *
     * @param idCard 身份编号
     * @return 生日(yyyy)
     */
    public static Short getYearByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(6, 10));
    }

    /**
     * 根据身份编号获取生日月
     *
     * @param idCard
     *            身份编号
     * @return 生日(MM)
     */
    public static Short getMonthByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(10, 12));
    }

    /**
     * 根据身份编号获取生日天
     *
     * @param idCard
     *            身份编号
     * @return 生日(dd)
     */
    public static Short getDateByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(12, 14));
    }

    /**
     * 根据身份编号获取性别
     *
     * @param idCard 身份编号
     * @return 性别(M-男，F-女，N-未知)
     */
    public static int getGenderByIdCard(String idCard) {
        int sGender;
        String sCardNum = idCard.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = 1;//男
        } else {
            sGender = 2;//女
        }
        return sGender;
    }

    /**
     * 根据年龄返回年龄类型
     * @param age
     * @return
     */


    /**
     * Object 转 string
     *
     * @param str
     * @param def
     * @return
     */
    public static String isEmpty(Object str, String def) {
        if (str == null || "".equals(str.toString().trim()) || str.equals("null")) {
            return def;
        } else {
            return str.toString();
        }
    }
    /**
     * Object 转 int
     *
     * @param inputNumber
     * @param defaultNumber
     * @return Integer
     */
    public static Integer parseInt(Object inputNumber, Integer defaultNumber) {
        if (inputNumber == null)
            return defaultNumber;
        try {
            return Integer.parseInt(inputNumber.toString().trim());
        } catch (Exception ex) {
            return defaultNumber;
        }
    }
    public static Double parseDouble(Object inputNumber, Double defaultNumber){
        if (inputNumber == null)
            return defaultNumber;
        try {
            return Double.parseDouble(inputNumber.toString().trim());
        } catch (Exception ex) {
            return defaultNumber;
        }
    }

    public static String dealWithUrl(String url){
        if(url.length() > 0 &&  url.indexOf("/") == 0){
            url = "[\"" + "http:" + url + "\"]";
        }else if(url.length() > 0 && url.indexOf(":") == 0 ){
            url = "[\"" + "http" + url  + "\"]";
        }else{
            url = "[\"" +  url  + "\"]";
        }
        return url;
    }
    public static String urlToUri(String url){
        String pattern = "[https]?:\\/\\/[-.a-zA-Z]+\\/([^\\?]+)\\?.*";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(url);
        return URLDecoder.decode(m.replaceAll("$1"));
    }

    /**
     * 获取map的值，若获取的值为null或者空则返回默认值
     * @param map
     * @param key
     * @param defaultValue
     * @return
     */
    public static Object mapGetDefaultWithEmpty(Map map, Object key, Object defaultValue){
        if (map.get(key) == null || "".equals(map.get(key))){
            return defaultValue;
        }
        return map.get(key);
    }

    /**
     * 获取时间倒计时
     * 如果倒计时为2天或2天以上则返回x天，否则返回xx小时xx分钟xx秒
     * @param time 时间戳
     * @return
     */
    public static String getTimeCountDown(Long time){
        long dd = time / 60 / 60 /24;
        long hh = time / 60 / 60 % 60;
        long mm = time / 60 % 60;
        long ss = time % 60;
        if (dd == 0L){
            return (hh + "小时" + mm + "分钟" + ss + "秒");
        }else {
            dd++;
            return (dd+"天");
        }
    }

    /**
     *转换成众安所需的身份证编码
     * @param cardType
     * @return
     */
    public static String parseZACardType(Integer cardType){
        if (cardType == 1){
            return "I";
        }else if (cardType == 2){
            return "P";
        }else {
            return "";
        }
    }

    /**
     * 转换成众安所需性别编码
     * @param sex
     * @return
     */
    public static String parseZASex(Integer sex){
        if (sex == 1){
            return "M";
        }else if (sex == 2){
            return "F";
        }else {
            return "";
        }
    }



    public static void returnErrorMsg(Map<String,Object> map,String errCode){
        if(map != null && map.get("status") != null && !("0").equals(map.get("status").toString())){
            if(map.get("errmsg") != null){
                throw new ApiException(errCode,map.getOrDefault("errmsg","").toString());
            }else if(map.get("msg") != null){
                throw new ApiException(errCode,map.getOrDefault("msg","").toString());
            }
        }
    }
}