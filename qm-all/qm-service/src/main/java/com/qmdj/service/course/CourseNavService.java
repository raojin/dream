package com.qmdj.service.course;


import java.util.List;

import com.qmdj.biz.pogo.qo.CourseNavQO;
import com.qmdj.service.bo.CourseNavBO;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.Result;

/**
 * 
 * 课程导航接口
 * chenjin
 * */
public interface CourseNavService {
  
	/**
	 * 
	 *新增 
	 * */
	public Result<Boolean> insertCourseNav(CourseNavBO courseNav);
	
	
	/**
	 * 
	 * 更新
	 * */
	public Result<Boolean> updateCourseNav(CourseNavBO courseNav);
	
	
	/**
	 * 
	 * 根据ID查询
	 * */
	public Result<CourseNavBO> queryCourseNavById(Long navId);
	
	
	/**
	 * 
	 * 分页查询
	 * */
	public Result<Pagination<CourseNavBO>> queryForPage(CourseNavQO querQO);
	
	/**
	 * 
	 * 多条件查询
	 * */
	public Result<List<CourseNavBO>> queryByCondition(CourseNavBO courseNavBO);

}
