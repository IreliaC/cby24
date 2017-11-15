package com.joyowo.servicefeign.controller;

import com.joyowo.servicefeign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: chenby
 * Date: 2017-11-10
 * ----------Dragon be here!----------/
 */
@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    @RequestMapping("/hi")
    public String sayHi(String name) {
        return feignService.sayHi(name);
    }
}
