package com.joyowo.mytest.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Author: chenby
 * Date: 2017-11-13
 */
@Component
@Order(2)
public class MyStartUpRunner2 implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("11111111,文件加载完成");
    }
}
