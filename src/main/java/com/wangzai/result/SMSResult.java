package com.wangzai.result;

import lombok.Data;

@Data
public class SMSResult {
    private String msgid;
    private String result;
    private String desc;
    private String failPhones;

}
