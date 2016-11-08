package com.qmdj.service.course.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.CourseNavDAO;
import com.qmdj.biz.domin.CourseNavDO;
import com.qmdj.biz.pogo.qo.CourseNavQO;
import com.qmdj.service.bo.CourseNavBO;
import com.qmdj.service.bo.util.CourseNavBeanUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.course.CourseNavService;

@Service
public class CourseNavServiceImpl implements CourseNavService{
	
	@Autowired
	private CourseNavDAO courseNavDAO;

	@Override
	public Result<Boolean> insertCourseNav(CourseNavBO courseNav) {
		Result<Boolean> re=new Result<Boolean>();
		if(courseNav==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		
		if(StringUtils.isBlank(courseNav.getName())||courseNav.getSort()==null||courseNav.getType()==null||courseNav.getStatus()==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		
		CourseNavDO courseNavDO=CourseNavBeanUtil.courseNavBOToDO(courseNav);
		try {
			courseNavDAO.insert(courseNavDO);
			re.setDate(true);
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<Boolean> updateCourseNav(CourseNavBO courseNav) {
		Result<Boolean> re=new Result<Boolean>();
		if(courseNav==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		if(courseNav.getCourseNavId()==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		
		CourseNavDO courseNavDO=CourseNavBeanUtil.courseNavBOToDO(courseNav);
		try {
			courseNavDAO.updateById(courseNavDO);
			re.setSuccess(true);
			re.setDate(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<CourseNavBO> queryCourseNavById(Long navId) {
		Result<CourseNavBO> re=new Result<CourseNavBO>();
		if(navId==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		try {
			CourseNavDO courseNav=courseNavDAO.findById(navId);
			re.setDate(CourseNavBeanUtil.qmdjCourseNavDOToBO(courseNav));
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<Pagination<CourseNavBO>> queryForPage(CourseNavQO querQO) {
		Result<Pagination<CourseNavBO>> re=new Result<Pagination<CourseNavBO>>();
		if(querQO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		
		try {
			int cout=courseNavDAO.queryForPageCount(querQO);
			List<CourseNavDO> courseNavList= courseNavDAO.queryForPage(querQO);
			List<CourseNavBO> list=new ArrayList<>();
			for(CourseNavDO navDO:courseNavList){
				list.add(CourseNavBeanUtil.qmdjCourseNavDOToBO(navDO));
			}
			
			Pagination<CourseNavBO> page=new Pagination<CourseNavBO>();
			page.setData(list);
			page.setTotalCount(cout);
			page.setQuery(querQO);
			re.setSuccess(true);
			re.setDate(page);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		
		return re;
	}

}
