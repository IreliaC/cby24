package com.joyowo.mytest.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: chenby
 * Date: 2017-11-08
 */
@RestController
@RequestMapping("/aop")
public class AopController {

    @RequestMapping("/before")
    public String doBefore(Integer number) {

        return "200";
    }

    @RequestMapping("/afterReturning")
    public String doAfterReturning(String keys) {
        return "200";
    }

    @RequestMapping("/afterThrowing")
    public String doAfterThrowing(String keys) {
        if (keys.equals("a")) {
            throw new NullPointerException();
        }
        return "200";
    }

    @RequestMapping("/doAround")
    public String doAround(String keys) {
        return "200";
    }
}
