/**
 *
 */
package com.wangzai.result;

import java.io.Serializable;

/**
 * @ClassName: ApiResult
 * @Description: TODO
 * @author zhangw
 * @date 2018-9-28 上午11:05:52
 */
public class ApiResult implements Serializable {

	private static final long serialVersionUID = 7436679719646824776L;
	private boolean isSuccess = true;
	private Object data;
	private String error;
	private int code = ResultCode.SUCCESS.getCode();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.isSuccess = false;
		this.error = error;
	}
	public void setError(ResultCode resultCode) {
		this.error=resultCode.getMessage();
		this.code=resultCode.getCode();
		this.isSuccess=false;
	}
	public void setError(ResultCode resultCode,String message) {
		this.error=String.format(resultCode.getMessage(),message);
		this.code=resultCode.getCode();
		this.isSuccess=false;
	}

}
