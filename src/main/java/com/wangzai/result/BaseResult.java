/*
 * Copyright 2014 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */
package com.wangzai.result;

import java.io.Serializable;

/**
 * @ClassName: BaseResult
 * @Description: TODO
 * @author zhangw
 * @date 2018-9-28 下午9:40:24
 */
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 5962668785982017381L;

    private boolean           success          = true;                           //default is successful

    private int               code             = ResultCode.SUCCESS.getCode();

    private String            message          = ResultCode.SUCCESS.getMessage();

    /**
     * 请求的唯一标识
     */
    private String            requestId;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setResultCode(ResultCode rc, Object... args) {
        success = rc.isSuccess();
        code = rc.getCode();
        if (args == null || args.length == 0) {
            message = rc.getMessage();
        } else {
            message = String.format(rc.getMessage(), args);
        }
    }

    @Override
    public String toString() {
        return "BaseResult [success=" + success + ", code=" + code + ", message=" + message + ", requestId="
                + requestId + "]";
    }

}
