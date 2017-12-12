package com.joyowo.mytest.controller;

import com.joyowo.mytest.pojo.ValidateBean;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Author: chenby
 * Date: 2017-11-30
 */
@RestController
public class ValidateController {

    @RequestMapping("/validate")
    public String validate(@Valid ValidateBean validateBean, BindingResult bindingResult,
                           @Valid ValidateBean validateBean1, BindingResult bindingResult1 ) {
       return bindingResult.hasErrors() || bindingResult1.hasErrors() ?
               bindingResult.getFieldError().getDefaultMessage() + "||" +
               bindingResult1.getFieldError().getDefaultMessage() : "correct";
    }
}
