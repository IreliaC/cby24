package com.joyowo.mytest;

import com.joyowo.mytest.service.TestService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author: chenby
 * Date: 2017-11-14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MytestApplication.class)
public class TestServiceTest {
    @Autowired
    TestService testService;

    public void test() {
    }
}
