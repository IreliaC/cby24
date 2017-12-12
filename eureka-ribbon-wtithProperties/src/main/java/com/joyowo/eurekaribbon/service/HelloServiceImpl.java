package com.joyowo.eurekaribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * User: chenby
 * Date: 2017-11-10
 */
@Service
public class HelloServiceImpl {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "errMethod")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String errMethod(String name) {
        return "sorry err";
    }

}
