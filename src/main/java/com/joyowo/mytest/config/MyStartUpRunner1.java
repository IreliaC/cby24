package com.joyowo.mytest.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Author: chenby
 * Date: 2017-11-13
 */
@Component
@Order(1)
public class MyStartUpRunner1 implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("222222222222,加载文件成功");
    }
}
