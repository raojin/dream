package com.qmdj.service.course.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<Integer> updateCourse(CourseBO course) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(course));
		long startTime = System.currentTimeMillis();
		Result<Integer> re = new Result<Integer>();
		if(course==null || course.getStatus() == 0){
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
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<Integer> delCourse(long course) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(course));
		long startTime = System.currentTimeMillis();
		Result<Integer> re = new Result<Integer>();
		if(course<=0){
			//缺少参数
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		CourseDO findById = courseDAO.getById(course);
		if(findById == null){
			//对象不存在
			re.setCode(ReCode.FIND_ERROR.getCode());
			re.setMessage(ReCode.FIND_ERROR.getMessage());
			log.info("对象不存在，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		try {
			findById.setStatus(100);
			int update = courseDAO.update(findById);
			if(update==1){
				re.setSuccess(true);
				re.setDate(update);
			}
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<PageInfo<CourseBO>> queryForPage(CourseQO course) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(course));
		long startTime = System.currentTimeMillis();
		Result<PageInfo<CourseBO>> re=new Result<PageInfo<CourseBO>>();
		if(course==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		try {
			List<CourseDO> queryForPage = courseDAO.queryForPage(course.enablePaging());
			List<CourseBO> courseBOlist = new ArrayList<CourseBO>();
			if(queryForPage!=null){
				for (CourseDO courseDO : queryForPage) {
					courseBOlist.add(CourseBeanUtil.qmdjCourseDOToBO(courseDO));
				}
			}
			PageInfo<CourseBO> pageInfo = new PageInfo<CourseBO>(courseBOlist);
			re.setDate(pageInfo);
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

}
