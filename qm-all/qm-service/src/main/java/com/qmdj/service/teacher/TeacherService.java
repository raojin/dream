package com.qmdj.service.teacher;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.pogo.qo.TeacherQO;
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
	
	Result<PageInfo<TeacherBO>> selectTeacherList(TeacherQO teacherBOId);

}
