package com.qmdj.service.course;

import com.qmdj.service.bo.CourseBO;
import com.qmdj.service.common.Result;

public interface CourseService {
	
	Result<Integer> addCourse(CourseBO course);
	
	
}
