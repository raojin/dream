package com.qmdj.service.course.impl;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.CourseNavDAO;
import com.qmdj.biz.dao.CourseTypeDAO;
import com.qmdj.biz.domin.CourseNavDO;
import com.qmdj.biz.domin.CourseTypeDO;
import com.qmdj.biz.pogo.qo.CourseTypeQO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.bo.CourseTypeBO;
import com.qmdj.service.bo.util.CourseTypeBeanUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.course.CourseTypeService;


@Service
public class CourseTypeImpl implements CourseTypeService{
	
	private Logger log = LoggerFactory.getLogger(CourseTypeImpl.class);
	
	@Autowired
	private CourseTypeDAO courseTypeDAO;
	
	@Autowired
	private CourseNavDAO courseNavDAO;

	@Override
	public Result<Boolean> inserCourseType(CourseTypeBO courseType) {
		Result<Boolean> re=new Result<Boolean>();
		CourseTypeDO courseTypeDO=CourseTypeBeanUtil.courseTypeBOToDO(courseType);
		if(courseTypeDO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		if(courseType.getCourseNavId()==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		
		try {
			CourseNavDO courseNavDO= courseNavDAO.findById(courseType.getCourseNavId());
			if(courseNavDO!=null){
				courseTypeDO.setCourseNavName(courseNavDO.getName());
			}
		 courseTypeDAO.insertSelective(courseTypeDO);
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
	public Result<Boolean> updateCourseType(CourseTypeBO courseTypeBO) {
		Result<Boolean> re=new Result<Boolean>();
		CourseTypeDO courseTypeDO=CourseTypeBeanUtil.courseTypeBOToDO(courseTypeBO);
		if(courseTypeDO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		if(courseTypeBO.getCourseNavId()==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		try {
			CourseNavDO courseNavDO= courseNavDAO.findById(courseTypeBO.getCourseNavId());
			if(courseNavDO!=null){
				courseTypeDO.setCourseNavName(courseNavDO.getName());
			}
			courseTypeDAO.updateById(courseTypeDO);
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
	public Result<CourseTypeBO> queryCourseTypeById(Long Id) {
		Result<CourseTypeBO> re=new Result<CourseTypeBO>();
		if(Id==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		try {
			CourseTypeDO courseTypeDO= courseTypeDAO.findById(Id);
			re.setDate(CourseTypeBeanUtil.courseTypeDOToBO(courseTypeDO));
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<Pagination<CourseTypeBO>> queryForPage(CourseTypeQO queryQO) {
		Result<Pagination<CourseTypeBO>> re=new Result<Pagination<CourseTypeBO>>();
		Pagination<CourseTypeBO> page=new Pagination<CourseTypeBO>();
		if(queryQO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;	
		}
		try {
			List<CourseTypeDO> listDO=courseTypeDAO.queryForPage(queryQO);
			List<CourseTypeBO> list=new ArrayList<>();
			if(listDO!=null){
				for(CourseTypeDO courseDO:listDO){
					list.add(CourseTypeBeanUtil.courseTypeDOToBO(courseDO));
				}
			}
			
			int count=courseTypeDAO.queryForPageCount(queryQO);
			page.setTotalCount(count);
			page.setQuery(queryQO);
			page.setData(list);
			re.setDate(page);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<List<CourseTypeBO>> selectCourseType() {
		log.info("请求方法：{}，参数：{}",Constant.GSON.toJson(CourseTypeImpl.class.toString()),"无");
		long startTime = System.currentTimeMillis();
		Result<List<CourseTypeBO>> re = new Result<List<CourseTypeBO>>();
		try {
			List<CourseTypeDO> selectCourseTypeList = courseTypeDAO.selectCourseTypeList();
			List<CourseTypeBO> courseBoList= new ArrayList<CourseTypeBO>();
			for (CourseTypeDO courseTypeDO : selectCourseTypeList) {
				CourseTypeBO courseTypeDOToBO = CourseTypeBeanUtil.courseTypeDOToBO(courseTypeDO);
				courseBoList.add(courseTypeDOToBO);
			}
			re.setDate(courseBoList);
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}
	

}
