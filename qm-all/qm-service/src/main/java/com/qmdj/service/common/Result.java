package com.qmdj.service.common;

public class Result<T> {

	/**
	 * 
	 * 是否成功
	 * */
	private boolean isSuccess=false;
	
	/**
	 * 
	 * 数据集
	 * */
	private T date;
	/**
	 * 
	 * 错误信息
	 * */
	private String message;
	/**
	 * 
	 * 错误码
	 * */
	private String code;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}

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
