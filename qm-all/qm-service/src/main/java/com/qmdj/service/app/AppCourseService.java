package com.qmdj.service.app;

import java.util.List;

import com.qmdj.biz.pogo.qo.ModelQO;
import com.qmdj.service.bo.app.AppCourseNavBO;
import com.qmdj.service.bo.app.AppHomeTopBO;
import com.qmdj.service.common.Result;

public interface AppCourseService {
	

	/**
	 * 查询有效课程列表
	 * */
	public Result<List<AppCourseNavBO>> queryCourse();

	
	
	/**
	 * 查询文章列表,课程导航列表,模块坑位列表
	 * 
	 * @param querys checkCodeAndType==true
	 * @param articleNumber 文章数量  // 0:全部  
	 * @param needCourseNav 是否需要课程导航  
	 * */
	public Result<AppHomeTopBO> queryAppHomeTop(List<ModelQO> querys,int articleNumber,boolean needCourseNav);

	
}
