package com.qmdj.service.teacher.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.dao.TeacherDAO;
import com.qmdj.biz.domin.TeacherDO;
import com.qmdj.biz.pogo.qo.TeacherQO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.biz.util.core.QmdjUtils;
import com.qmdj.service.bo.TeacherBO;
import com.qmdj.service.bo.util.TeacherBeanUtil;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.teacher.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	private Logger log = LoggerFactory.getLogger(TeacherServiceImpl.class);
	
	@Autowired
	TeacherDAO teacherDAO;

	@Override
	public Result<Integer> addTeacher(TeacherBO teacherBO) {
		log.info("请求入参：{}",Constant.GSON.toJson(teacherBO));
		long startTime = System.currentTimeMillis();
		Result<Integer> re = new Result<Integer>();
		if(teacherBO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		try {
			TeacherDO qmdjTeacherBOToDO = TeacherBeanUtil.qmdjTeacherBOToDO(teacherBO);
			qmdjTeacherBOToDO.setGmtCreate(new Date());
			qmdjTeacherBOToDO.setStatus(2);//默认为审核中
			qmdjTeacherBOToDO.setImages("qiniuImage");//七牛文件保存策略
			qmdjTeacherBOToDO.setCode(QmdjUtils.getCode(qmdjTeacherBOToDO.getIdentity()));//添加code
			int insertSelective = teacherDAO.insertSelective(qmdjTeacherBOToDO);
			re.setSuccess(true);
			re.setDate(insertSelective);
		} catch (Exception e) {
			Constant.GSON.toJson(e.getMessage());
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<Integer> updateTeacher(TeacherBO teacherBO) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(teacherBO));
		long startTime = System.currentTimeMillis();
		Result<Integer> re = new Result<Integer>();
		if(teacherBO==null){
			//缺少参数
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		try {
			TeacherDO qmdjTeacherBOToDO = TeacherBeanUtil.qmdjTeacherBOToDO(teacherBO);
			int updateById = teacherDAO.updateById(qmdjTeacherBOToDO);
			if(updateById==1){
				re.setSuccess(true);
				re.setDate(updateById);
			}
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<Integer> delTeacher(long teacherBOId) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(teacherBOId));
		long startTime = System.currentTimeMillis();
		Result<Integer> re = new Result<Integer>();
		if(teacherBOId<=0){
			//缺少参数
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		 TeacherDO findById = teacherDAO.findById(teacherBOId);
		if(findById == null){
			//对象不存在
			re.setCode(ReCode.FIND_ERROR.getCode());
			re.setMessage(ReCode.FIND_ERROR.getMessage());
			log.info("对象不存在，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		try {
			findById.setStatus(100);
			int update = teacherDAO.updateById(findById);
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
	public Result<PageInfo<TeacherBO>> selectTeacherList(TeacherQO teacherQO) {
		Result<PageInfo<TeacherBO>> re = new Result<PageInfo<TeacherBO>>();
		List<TeacherDO> selectTeacherList = teacherDAO.selectTeacherList(teacherQO.enablePaging());
		List<TeacherBO> teacherBOList = new ArrayList<TeacherBO>();
		if(selectTeacherList.size()>0){
			for (TeacherDO teacherDO : selectTeacherList) {
				teacherBOList.add(TeacherBeanUtil.qmdjTeacherDOToBO(teacherDO));
			}
		}
		PageInfo<TeacherBO> pageList =new PageInfo<TeacherBO>(teacherBOList);
		re.setDate(pageList);
		return re;
	}


}
