package com.qmdj.platform.service.course.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.dao.CourseDAO;
import com.qmdj.biz.domin.CourseDO;
import com.qmdj.biz.domin.CourseForm;
import com.qmdj.common.base.Result;
import com.qmdj.platform.service.course.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDAO courseDAO;

	@Override
	public Result<Integer> save(CourseDO course) {
		Result<Integer> re= new Result<Integer>(); 
		course.setGmtCreate(new Date());
		int insertSelective = courseDAO.insertSelective(course);
		if(insertSelective == 1 ){
			re.setSuccess(true);
			re.setDate(insertSelective);
		}
		return re;
	}

	@Override
	public Result<Integer> update(CourseDO course) {
		Result<Integer> re= new Result<Integer>(); 
		int insertSelective = courseDAO.updateByPrimaryKeySelective(course);
		if(insertSelective == 1 ){
			re.setSuccess(true);
			re.setDate(insertSelective);
		}
		return re;
	}

	@Override
	public PageInfo<CourseDO> selectList(CourseForm courseForm) {
		List<CourseDO> selectCourseList = courseDAO.selectCourseList(courseForm);
		PageInfo<CourseDO> pageInfo = new PageInfo<>(selectCourseList);
		return pageInfo;
	}

	@Override
	public CourseDO select(int id) {
		CourseDO selectByPrimaryKey = courseDAO.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public Result<Integer> del(CourseDO course){
		Result<Integer> re= new Result<Integer>();
		course.setIsDel(1);
		int insertSelective = courseDAO.updateByPrimaryKeySelective(course);
		if(insertSelective == 1 ){
			re.setSuccess(true);
			re.setDate(insertSelective);
		}
		return re;
	}
}
