package com.qmdj.service.teacher;

import com.qmdj.service.bo.TeacherBO;
import com.qmdj.service.common.Result;


public interface TeacherService {
	
	/**
	 * 添加
	 * @return
	 */
	Result<Integer> addTeacher(TeacherBO teacherBO);
	
	Result<Integer> updateTeacher(TeacherBO teacherBO);
	
	Result<Integer> delTeacher(long teacherBOId);

}
