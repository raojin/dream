package com.qmdj.platform.controller.upload;

public class ReUpload<T> {
	
 private	boolean isSuccess =false;
 
 private    T date ;

 private    String ErMage;

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

public String getErMage() {
	return ErMage;
}

public void setErMage(String erMage) {
	ErMage = erMage;
}
 
 
}
