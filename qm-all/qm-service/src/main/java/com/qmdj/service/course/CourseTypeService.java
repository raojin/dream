package com.qmdj.service.course;

import com.qmdj.biz.domin.CourseTypeDO;
import com.qmdj.service.common.Result;

public interface CourseTypeService {
	
	Result<Integer> addCourseType(CourseTypeDO courseType); 

}
