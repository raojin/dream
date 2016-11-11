package com.qmdj.biz.util.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Class Constant
 * @Description 常数工具类
 * @Author xw
 * @Date 2016年10月18日16:07:26
 */
public class Constant {
	public static String MSG="msg";
	public static String SUCCESS="SUCCESS";
	public static String FAIL="FAIL";
	public static String BEAN_LIST="BeanList";
	public static String BEAN="Bean";
	public static String SESSION_BEAN="Session_Bean";
	public static String ERROR="error";
	public static String ERROR_MESSAGE="账号或密码不能为空";
	
	public static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
	

}
