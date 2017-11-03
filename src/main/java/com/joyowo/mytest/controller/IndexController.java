package com.joyowo.mytest.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: chenby
 * Date: 2017-11-03
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 */
@RestController
@Api(value = "test", description = "我就是测试一下")
public class IndexController {
    @ApiOperation("信息软删除")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功"),
            @ApiResponse(code = 500, message = "服务器内部异常"),
            @ApiResponse(code = 405, message = "invalid input") })
    @RequestMapping(value ="/test",method = RequestMethod.DELETE)
    public String delete(@ApiParam(value = "id",required = true) String[] id) {
        return "delete";
    }

    @RequestMapping(value ="/test",method = RequestMethod.POST)
    public String post() {
        return "post";
    }

    @RequestMapping(value ="/test",method = RequestMethod.GET)
    public String get() {
        return "get";
    }

    @RequestMapping(value ="/test",method = RequestMethod.PATCH)
    public String patch() {
        return "patch";
    }

    @RequestMapping(value ="/test",method = RequestMethod.PUT)
    public String put() {
        return "put";
    }


}
