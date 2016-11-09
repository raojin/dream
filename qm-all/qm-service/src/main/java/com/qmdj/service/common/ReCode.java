package com.qmdj.service.common;

public enum ReCode {

	SYS_REEOR("SYS_ERROR","系统错误"),
	PARAM_ERROR("PARAM_ERROR","参数错误"),
	CUSTOM_ERROR("CUSTOM_ERROR","自定义错误"),
	AUTH_ERROR("AUTH_ERROR","没有权限"),
	FIND_ERROR("FIND_ERROR","对象不存在");
	
	ReCode(String code,String message){
		this.code=code;
		this.message=message;
	};
	
	private String message;
	
	private String code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
