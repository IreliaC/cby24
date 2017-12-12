package com.joyowo.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: chenby
 * Date: 2017-11-28
 */
@Configuration
//@ExcudeAnnotation
public class TestConfig {

    @Bean
    public IRule ribbonRandom() {
        return new RandomRule();
    }

}
