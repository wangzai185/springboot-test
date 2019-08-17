/*
 * Copyright 2014 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */
package com.wangzai.result;

/**
 * @ClassName: PlainResult
 * @Description: TODO
 * @author zhangw
 * @date 2018-9-28 下午23:40:33
 * @param <T>
 */
public class PlainResult<T> extends BaseResult {
    private static final long serialVersionUID = -6827545105702977853L;

    private T                 data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
