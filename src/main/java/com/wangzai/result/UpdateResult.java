/**
 * 
 */
package com.wangzai.result;

/**
 * @ClassName: UpdateResult
 * @Description: TODO
 * @author zhangw
 * @date 2018-9-29 下午10:49:23
 */
public class UpdateResult extends DefaultResult {

    /** 序列化ID */
    private static final long serialVersionUID = 3235847415382032976L;

    public UpdateResult() {
        super();
    }

    public UpdateResult(boolean success) {
        super(success);
    }

    public UpdateResult(boolean success, int code) {
        super(success, code);
    }

    public UpdateResult(boolean success, int code, String info) {
        super(success, code, info);
    }

}
