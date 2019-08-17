package com.wangzai.result;

/**
 *
 * 功能描述: 返回状态码 如有需要 自行定义
 *
 * @param:
 * @return:
 * @auther: zhangw
 * @date: 2018/9/29 11:01
 */
public enum ResultCode {
    INVOKE_EXCEPTION(100, "exception occur:%s"),
    RESULT_IS_NULL(101, "result is null the id is:%s"),
    SUCCESS(200, "sucessful"),
    CHECK_USER_FAIL(80000, "check user fail \'.\'"),
    PASSWORD_CHECK_FAIL(80001, "old password is error"),
    MUST_HAVE_ONE_POINT(80002, "menuToken must have one point"),
    TOKEN_IS_REPEAT(80003, "token is repeat"),
    ID_CANNOT_NULL(80004,"id is null"),
    CANNOT_ADD_BUSINESS(80005, "token不能重复!"),
    USER_IS_REPEAT(80006,"用户已存在!"),
    PRIVILEGE_REQUIRED(80007, "privilege required"),
    UPDATE_WHERE_CANNOT_NULL(80008, "更新操作时，条件不能为空"),
	;
    private int code;
    private String message;

    private ResultCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public static ResultCode valueOf(int code) {
        for (ResultCode value : values()) {
            if (code == value.code) {
                return value;
            }
        }

        return SUCCESS; // default is successful
    }

}