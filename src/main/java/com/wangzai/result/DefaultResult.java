/**
 * 
 */
package com.wangzai.result;

import java.io.Serializable;

/**
 * @ClassName: DefaultResult
 * @Description: TODO
 * @author zhangw
 * @date 2018-9-27 下午10:49:53
 */
public class DefaultResult implements Serializable {

    /** 序列化ID */
    private static final long serialVersionUID = 8078388378341252234L;

    /** 是否成功 */
    private boolean           success;

    /** 返回码 */
    private int               code;

    /** 返回信息 */
    private String            info;

    public DefaultResult() {

    }

    public DefaultResult(boolean success) {
        this.success = success;
    }

    public DefaultResult(boolean success, int code) {
        this.success = success;
        this.code = code;
    }

    public DefaultResult(boolean success, int code, String info) {
        this.success = success;
        this.code = code;
        this.info = info;
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
