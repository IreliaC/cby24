package com.joyowo.mytest.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Author: chenby
 * Date: 2017-11-30
 */
@Data
@ToString
@NoArgsConstructor
public class ValidateBean {
    @NotNull(message = "name is not null")
    private String name;
    @Min(value = 18, message = "age must be more than 18")
    @Max(value = 56, message = "age must be less than 56")
    private Integer age;

}
