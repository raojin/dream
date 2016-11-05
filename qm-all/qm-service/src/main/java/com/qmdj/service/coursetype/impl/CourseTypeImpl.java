package com.qmdj.service.coursetype.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.CourseTypeDAO;
import com.qmdj.biz.domin.CourseTypeDO;
import com.qmdj.biz.domin.UserDO;
import com.qmdj.service.bo.UserBO;
import com.qmdj.service.bo.util.UserBeanUtil;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.coursetype.CourseTypeService;


@Service
public class CourseTypeImpl implements CourseTypeService{
	
	@Autowired
	CourseTypeDAO courseTypeDAO;

	@Override
	public Result<Integer> addCourseType(CourseTypeDO courseType) {
		Result<Integer> re=new Result<Integer>();
		try {
			courseType.setGmtCreate(new Date());
			if(courseType.getStatus()==null){
				courseType.setStatus(2);
			}
			if(courseType.getSort() ==null){
				courseType.setSort(0);
			}
			int insertSelective = courseTypeDAO.insertSelective(courseType);
			re.setSuccess(false);
			re.setDate(insertSelective);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		return re;
	}
	

}
