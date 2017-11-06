package com.joyowo.mytest.controller;//
//      ┏┛ ┻━━━━━┛ ┻┓
//      ┃　　　　　　 ┃
//      ┃　　　━　　　┃
//      ┃　┳┛　  ┗┳　┃
//      ┃　　　　　　 ┃
//      ┃　　　┻　　　┃
//      ┃　　　　　　 ┃
//      ┗━┓　　　┏━━━┛
//        ┃　　　┃   神兽保佑
//        ┃　　　┃   代码无BUG！
//        ┃　　　┗━━━━━━━━━┓
//        ┃　　　　　　　    ┣┓
//        ┃　　　　         ┏┛
//        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//          ┃ ┫ ┫   ┃ ┫ ┫
//          ┗━┻━┛   ┗━┻━┛

import com.joyowo.mytest.pojo.Cat;
import com.joyowo.mytest.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by ireliac on 2017/11/5.
 */
@RestController
public class CatController {

    @Autowired
    private CatService catService;

    @RequestMapping(value = "/add",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add() {
        Cat cat = new Cat();
        cat.setCatAge(2);
        cat.setCatName("Tom");
        cat.setBirth(new Date());
        catService.add(cat);
        return "save:ok";
    }

    @RequestMapping("/delete")
    public String delete() {
        Cat cat = new Cat();
        cat.setCatId(1);
        catService.delete(cat);
        return "delete:ok";
    }

    @RequestMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Cat> getAll() {
        return catService.getAll();
    }
}