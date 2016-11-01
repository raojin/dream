package com.qmdj.service.app;

import java.util.List;

import com.qmdj.service.bo.app.AppCourseTypeNavBO;
import com.qmdj.service.bo.app.AppHomeTopBO;
import com.qmdj.service.common.Result;

public interface AppCourseService {
	

	/**
	 * 查询有效课程列表
	 * */
	public Result<List<AppCourseTypeNavBO>> queryCourse();

	
	
	/**
	 * 查询文章列表,课程导航列表,模块坑位列表
	 * 
	 * @param moduleCodes  模块编码   //必填
	 * @param moduleType   模块类型   // 0:全部，1:图片 2:文字
	 * @param articleNumber 文章数量  // 0:全部  
	 * @param needCourseNav 是否需要课程导航  
	 * */
	public Result<AppHomeTopBO> queryAppHomeTop(List<String> moduleCodes,int moduleType,int articleNumber,boolean needCourseNav);

	
}
