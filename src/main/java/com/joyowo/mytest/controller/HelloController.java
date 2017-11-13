package com.joyowo.mytest.controller;//

import com.joyowo.mytest.pojo.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by ireliac on 2017/11/4.
 */
@RestController
public class HelloController {
    @RequestMapping(value= "/hello",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Data hello() {
        Data data = new Data();
        data.setDate(new Date());
        data.setId(1);
        data.setName("刘德华");
        return data;
    }
}
