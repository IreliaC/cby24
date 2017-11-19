package com.joyowo.mytest.service;

import org.springframework.stereotype.Service;

/**
 * Author: chenby
 * Date: 2017-11-14
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public void test() {
        System.out.println(1111);
    }
}
