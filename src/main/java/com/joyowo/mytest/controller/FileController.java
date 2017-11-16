package com.joyowo.mytest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: chenby
 * Date: 2017-11-14
 */
@Controller
public class FileController {
    @RequestMapping("file")
    public String file() {
        return "/file";
    }

/*    public void upLoad() {
        return
    }*/

}
