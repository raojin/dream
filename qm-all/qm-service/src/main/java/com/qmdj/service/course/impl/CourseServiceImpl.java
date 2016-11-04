package com.qmdj.service.course.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.CourseDAO;
import com.qmdj.service.bo.CourseBO;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.course.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	CourseDAO courseDAO;

	@Override
	public Result<Integer> addCourse(CourseBO course) {
		Result<Integer> re = new Result<Integer>();
		if(course==null || course.getParentid() == null || course.getCourseType() == null || course.getPrice() <= 0){
			//缺少参数
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
//		courseDAO.insert(CourseBeanUtil.qmdjCourseBOToDO(course));
		return null;
	}

}
