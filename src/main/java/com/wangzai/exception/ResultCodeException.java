package com.wangzai.exception;


import com.wangzai.result.ResultCode;

/**
 * Created by zhangw on 18/9/28.
 */
public class ResultCodeException extends Exception {

    private ResultCode resultCode = null;

    public ResultCodeException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.setResultCode(resultCode);
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
