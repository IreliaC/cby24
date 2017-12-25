package com.joyowo.mytest.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * Author: chenby
 * Date: 2017-12-14
 */
public enum EnumTest {
    sun("rest"),mon("work"),tues("work"),wed("work"),thu("work"),fri("work"),sat("rest");
    private String status;
    EnumTest(String status) {
        this.status = status;
    }
    public static void main(String[] args) {
        String status = EnumTest.sat.status;
        System.out.println(status);
        int i = TimeUtil.parseTimeToInt(LocalDateTime.now());
        System.out.println(i);
        System.out.println(System.currentTimeMillis());
    }
}
