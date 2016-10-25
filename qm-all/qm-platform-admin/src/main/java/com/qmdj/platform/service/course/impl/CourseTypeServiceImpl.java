package com.qmdj.platform.service.course.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.CourseTypeDAO;
import com.qmdj.biz.domin.CourseTypeDO;
import com.qmdj.common.base.ReCode;
import com.qmdj.common.base.Result;
import com.qmdj.platform.service.course.CourseTypeService;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {

	@Autowired
	private CourseTypeDAO coueseTypeDAO;
	
	@Override
	public Result<Integer> saveCoueseType(CourseTypeDO cousesTypeDO) {
		Result<Integer> re=new Result<Integer>();
		if(cousesTypeDO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		if(StringUtils.isBlank(cousesTypeDO.getName())||cousesTypeDO.getStatus()==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		try {
			cousesTypeDO.setType(2);
			int id=coueseTypeDAO.insertSelective(cousesTypeDO);
			if(id>0){
				re.setSuccess(true);
				re.setDate(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage()+":"+e);
		}
		
		return re;
	}

	@Override
	public Result<List<CourseTypeDO>> queryCoueseTypeList() {
		Result<List<CourseTypeDO>> re=new Result<List<CourseTypeDO>>();
		try {
			List<CourseTypeDO> list=coueseTypeDAO.queryCourseTypeList();
			re.setSuccess(true);
			re.setDate(list);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage()+":"+e);
		}
		return re;
	}

	@Override
	public Result<Integer> updateCoueseType(CourseTypeDO cousesTypeDO) {
		Result<Integer> re=new Result<Integer>();
		int updateByPrimaryKeySelective = coueseTypeDAO.updateByPrimaryKeySelective(cousesTypeDO);
		if(updateByPrimaryKeySelective==1){
			re.setSuccess(true);
			re.setDate(updateByPrimaryKeySelective);
		}
		return re;
	}

	@Override
	public CourseTypeDO selectCoueseTypeById(int id) {
		CourseTypeDO selectByPrimaryKey = coueseTypeDAO.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

}
