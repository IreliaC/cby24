package com.joyowo.eurekaribbon.controller;

import com.joyowo.eurekaribbon.service.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @RequestMapping("/hi")
    public String hello(String name) {
        return helloService.hiService(name);
    }
    @GetMapping("/test")
    public void test() {
        ServiceInstance instance = this.loadBalancerClient.choose("SERVICE-HI");
        System.out.println("111: " + instance.getServiceId() + ": " + instance.getHost() + ": " + instance.getPort());
//        System.out.println(instance.toString());

		ServiceInstance instance1 = this.loadBalancerClient.choose("SERVICE-HI-1");
		System.out.println("222: " + instance1.getServiceId() + ": " + instance1.getHost() + ": " + instance1.getPort());
//        System.out.println(instance1);
//        System.out.println(instance == instance1);
    }

}
