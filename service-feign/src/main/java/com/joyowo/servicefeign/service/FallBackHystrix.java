package com.joyowo.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * User: chenby
 * Date: 2017-11-10
 */

@Component
public class FallBackHystrix implements FeignService{
    @Override
    public String sayHi(String name) {
        return "hi"+name + "sorry err";
    }
}
