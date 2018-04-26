package com.joyowo.mytest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * dev1
 * 对系统中的异常处理，这里取名errcode和errmsg主要是参考了微信公众号API
 *dfsdss111111111111111111111
 * @author zhangsheng
 * @version 1.0
 */
@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
    private static final String ERROR_MSG = "msg";//传给前端的名字
    private static final String OUR_ERROR_MSG = "msg2";//给我们自己看的msg
    private static final String ERROR_CODE = "errcode";//传给前端的code
    private static final String STATUS = "status";//传给前端的状态
    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Object> handleInvalidRequest(Exception e, WebRequest request) {
        Map<String, String> error = new HashMap<>();
        error.put(STATUS,"1");
        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            error.put(ERROR_CODE, apiException.getErrcode());
            String errmsg ="";
            if(!StringUtils.isEmpty(apiException.getErrmsg())){
                errmsg += apiException.getErrmsg();
            }
            error.put(ERROR_MSG, errmsg);
        } else if (e instanceof DuplicateKeyException) {
            // 主键重复
            logger.error(e.getMessage());
            error.put(ERROR_CODE, "10008");
            error.put(ERROR_MSG, "系统异常，请稍候再试.");
        } else if (e instanceof BadSqlGrammarException) {
            logger.error(e.getMessage());
            e.printStackTrace();
            error.put(ERROR_CODE, "10005");
            error.put(ERROR_MSG, "系统异常，请稍候再试.");
            error.put(OUR_ERROR_MSG, "sql error: " + ((BadSqlGrammarException) e).getSQLException().getMessage());
        } else if (e instanceof SQLException) {
            error.put(ERROR_CODE, "10006");
            error.put(ERROR_MSG, "系统异常，请稍候再试.");
            error.put(OUR_ERROR_MSG, "sql error: " +  e.getMessage());
        } else if (e instanceof NullPointerException) {
            // 空指针异常
            e.printStackTrace();
            logger.error(e.getMessage());
            error.put(ERROR_CODE, "10007");
            error.put(ERROR_MSG, "系统异常，请稍候再试.");
            error.put(OUR_ERROR_MSG, e.getMessage());
        } else {
            logger.error(e.getMessage());
            e.printStackTrace();
            error.put(ERROR_CODE, "10001");
            error.put(ERROR_MSG, "系统异常，请稍候再试.");
            error.put(OUR_ERROR_MSG, "System error");
        }
        HttpHeaders headers = new HttpHeaders();
        //当设为MediaType.APPLICATION_JSON时一直出现中文乱码问题
        //根据猜测是spring-web版本问题，这里需要改成APPLICATION_JSON_UTF8
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return handleExceptionInternal(e, error, headers, HttpStatus.OK, request);
    }
}

