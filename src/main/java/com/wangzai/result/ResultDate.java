package com.wangzai.result;

import lombok.Data;

@Data
public class ResultDate {

    public String returnCode;

    public String errorCode;

    public String errorMessage;

    public void returnCode(String s) {
    }
}
