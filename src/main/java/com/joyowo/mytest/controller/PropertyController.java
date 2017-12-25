package com.joyowo.mytest.controller;

import com.joyowo.mytest.config.ConnectionProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: chenby
 * Date: 2017-12-15
 */
@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    ConnectionProperties connectionProperties;


    @RequestMapping("/")
    public ConnectionProperties getProperty() {
        return connectionProperties;
    }
}
