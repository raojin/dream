package com.qmdj.dao.course;

import java.util.List;

import com.qmdj.domin.course.CourseTypeDO;

public interface CourseTypeDAO {

	
	public int saveCourseType(CourseTypeDO cousesTypeDO);
	
	
	public List<CourseTypeDO> queryCourseTypeList();
}
