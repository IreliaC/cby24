package com.joyowo.mytest.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

/**
 * Author: chenby
 * Date: 2017-12-15
 */
@ConfigurationProperties(prefix = "param.conn")
@Data
@Configuration
public class ConnectionProperties {

    @NotNull
    private String connectionName;


}
