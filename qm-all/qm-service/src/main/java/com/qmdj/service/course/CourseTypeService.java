package com.qmdj.service.course;

import java.util.List;

import com.qmdj.biz.pogo.qo.CourseTypeQO;
import com.qmdj.service.bo.CourseTypeBO;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.Result;

public interface CourseTypeService {
	
	/**
	 * 
	 * 插入课程类型
	 * */
	Result<Boolean> inserCourseType(CourseTypeBO courseTypeBO); 
	
	/**
	 * 
	 * 更新课程类型
	 * */
	Result<Boolean> updateCourseType(CourseTypeBO courseTypeBO);
	
	/**
	 * 
	 * 根据courseTypeId查询
	 * */
	Result<CourseTypeBO> queryCourseTypeById(Long Id);
	
	/**
	 * 
	 * 分页查询
	 * */
	Result<Pagination<CourseTypeBO>> queryForPage(CourseTypeQO queryQO);
	
	/**
	 * 
	 * 查询课程类型，
	 * */
	Result<List<CourseTypeBO>> selectCourseType(); 

}
