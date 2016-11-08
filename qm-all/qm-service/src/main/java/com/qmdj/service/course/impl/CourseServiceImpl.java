package com.qmdj.service.course.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.dao.CourseDAO;
import com.qmdj.biz.domin.CourseDO;
import com.qmdj.biz.pogo.qo.CourseQO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.bo.CourseBO;
import com.qmdj.service.bo.util.CourseBeanUtil;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.course.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	private Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);
	@Autowired
	CourseDAO courseDAO;

	@Override
	public Result<Integer> addCourse(CourseBO course) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(course));
		long startTime = System.currentTimeMillis();
		Result<Integer> re = new Result<Integer>();
		if(course==null || course.getParentid() == null || course.getCourseType() == null || course.getPrice() < 0){
			//缺少参数
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		CourseDO courseBOToDO = CourseBeanUtil.courseBOToDO(course);
		courseBOToDO.setGmtCreate(new Date());
		int insertSelective = courseDAO.insertSelective(courseBOToDO);
		if(insertSelective==1){
			re.setSuccess(true);
			re.setDate(insertSelective);
		}
		log.info("返回参数：{}",Constant.GSON.toJson(re));
		log.info("请求完成耗时：{}",System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<Integer> updateCourse(CourseBO course) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(course));
		long startTime = System.currentTimeMillis();
		Result<Integer> re = new Result<Integer>();
		if(course==null){
			//缺少参数
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		
		try {
			CourseDO courseBOToDO = CourseBeanUtil.courseBOToDO(course);
			courseBOToDO.setGmtCreate(new Date());
			int update = courseDAO.update(courseBOToDO);
			if(update==1){
				re.setSuccess(true);
				re.setDate(update);
			}
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}",Constant.GSON.toJson(re));
		log.info("请求完成耗时：{}",System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<Integer> delCourse(CourseBO course) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(course));
		long startTime = System.currentTimeMillis();
		Result<Integer> re = new Result<Integer>();
		if(course==null||course.getCourseId()==null){
			//缺少参数
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		
		try {
			CourseDO courseBOToDO = CourseBeanUtil.courseBOToDO(course);
			course.setStatus(0);
			int update = courseDAO.update(courseBOToDO);
			if(update==1){
				re.setSuccess(true);
				re.setDate(update);
			}
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		
		log.info("返回参数：{}",Constant.GSON.toJson(re));
		log.info("请求完成耗时：{}",System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<PageInfo<CourseQO>> queryForPage(CourseQO course) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(course));
		long startTime = System.currentTimeMillis();
		Result<PageInfo<CourseQO>> re=new Result<PageInfo<CourseQO>>();
		if(course==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		try {
			PageInfo<CourseQO> pageInfo = new PageInfo<CourseQO>(courseDAO.queryForPage(course.enablePaging()));
			re.setDate(pageInfo);
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}",Constant.GSON.toJson(re));
		log.info("请求完成耗时：{}",System.currentTimeMillis()-startTime);
		return re;
	}

}
