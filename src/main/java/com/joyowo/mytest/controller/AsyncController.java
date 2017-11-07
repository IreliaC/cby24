package com.joyowo.mytest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * User: chenby
 * Date: 2017-11-07
 */

@RestController
@RequestMapping("/async")
public class AsyncController {

    public String sync() {
        RestTemplate restTemplate = new RestTemplate();
        return "";
    }

}
