package com.joyowo.eurekaribbon.controller;

import com.joyowo.eurekaribbon.service.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: chenby
 * Date: 2017-11-10
 */
@RestController
public class HelloController {

    @Autowired
    HelloServiceImpl helloService;
    @RequestMapping("/hi")
    public String hello(String name) {
        return helloService.hiService(name);
    }

}
