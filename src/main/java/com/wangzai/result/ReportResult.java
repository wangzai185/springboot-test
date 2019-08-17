package com.wangzai.result;

/**
 * @ClassName: CreateResult
 * @Description: TODO
 * @author zhangw
 * @date 2018-9-28 上午10:56:50
 */
public class ReportResult<T> extends DefaultResult {

    private static final long serialVersionUID = 7446700922262531640L;

    private T                 data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ReportResult() {
        super();
    }

    public ReportResult(boolean success) {
        super(success);
    }

    public ReportResult(boolean success, int code) {
        super(success, code);
    }

    public ReportResult(boolean success, int code, String info) {
        super(success, code, info);
    }

}
