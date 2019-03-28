package com.eva.sp.h2test.bean;

/**
 * RestAPI 統一回傳物件
 * @author Eva.Wu
 *
 */
public class RestResult {

	private String resCode;
	
	private String msg;
	
	private Object restData;
	
	public RestResult(String resCode, String msg, Object restData) {
		super();
		this.resCode = resCode;
		this.msg = msg;
		this.restData = restData;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getRestData() {
		return restData;
	}

	public void setRestData(Object restData) {
		this.restData = restData;
	}

	
}
