package com.joyowo.mytest.exception;//
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

/**
 * Created by ireliac on 2017/11/6.
 */
public class ApiException extends RuntimeException {
    private String errCode;
    private String errMeg;

    public ApiException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMeg = errMsg;
    }
    public String getErrcode() {
        return errCode;
    }

    public String getErrmsg() {
        return errMeg;
    }
}
