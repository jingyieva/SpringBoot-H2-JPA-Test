package com.eva.sp.h2test.controller;

import com.eva.sp.h2test.bean.RestResult;
import com.eva.sp.h2test.config.AppCode;

public class BaseController {

	protected RestResult buildResult() {
		return buildResult(AppCode.DATA.HTTP.OK.getCode(), AppCode.DATA.HTTP.OK.getMsg(), null);
	}
	
	protected RestResult buildResult(AppCode.DATA.HTTP resCode) {
		return buildResult(resCode.getCode(), resCode.getMsg(), null);
	}
	
	protected RestResult buildResult(Object data) {
		return buildResult(AppCode.DATA.HTTP.OK.getCode(), AppCode.DATA.HTTP.OK.getMsg(), data);
	}
	
	protected RestResult buildResult(AppCode.DATA.HTTP resCode, Object data) {
		return buildResult(resCode.getCode(), resCode.getMsg(), data);
	}

	protected RestResult buildResult(String appCode, String msg, Object data) {
		return new RestResult(appCode, msg, data);
	}
}
