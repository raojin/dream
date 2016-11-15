package com.qmdj.service.app.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.CourseNavDAO;
import com.qmdj.biz.dao.CourseTypeDAO;
import com.qmdj.biz.domin.CourseNavDO;
import com.qmdj.biz.domin.CourseTypeDO;
import com.qmdj.biz.pogo.qo.ModelQO;
import com.qmdj.service.app.AppArticleService;
import com.qmdj.service.app.AppCourseService;
import com.qmdj.service.app.AppModelService;
import com.qmdj.service.bo.ArticleBO;
import com.qmdj.service.bo.ModelBO;
import com.qmdj.service.bo.app.AppCourseNavBO;
import com.qmdj.service.bo.app.AppCourseTypeBO;
import com.qmdj.service.bo.app.AppHomeTopBO;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;

@Service
public class AppCourseServiceImpl implements AppCourseService {
	
	@Autowired
	private AppArticleService appArticleService;
	
	@Autowired
	private AppModelService appModelService;
	
	@Autowired
	private CourseNavDAO courseNavDAO;
	
	@Autowired
	private CourseTypeDAO courseTypeDAO;

	@Override
	public Result<List<AppCourseNavBO>> queryCourse() {
		Result<List<AppCourseNavBO>> re=new Result<List<AppCourseNavBO>>();
		try {
			CourseNavDO courseNavDO=new CourseNavDO();
			courseNavDO.setStatus(1);
			List<AppCourseNavBO> date=new ArrayList<>();
			List<CourseNavDO>  listNav= courseNavDAO.findByCondition(courseNavDO);
			if(listNav==null){
				re.setSuccess(true);
				re.setDate(date);
				return re;
			}
			for(CourseNavDO nav:listNav){
				AppCourseNavBO navBO=new AppCourseNavBO();
				navBO.setCourseNavId(nav.getId());
				navBO.setName(nav.getName());
				navBO.setSort(nav.getSort());
				navBO.setType(nav.getType());
				CourseTypeDO querytype=new CourseTypeDO();
				querytype.setStatus(1);
				querytype.setCourseNavId(nav.getId());
				List<CourseTypeDO>  list= courseTypeDAO.findByCondition(querytype);
				if(list!=null){
				  for(CourseTypeDO typeDO:list){
					  AppCourseTypeBO appType=new AppCourseTypeBO();
					  appType.setCourseTypeId(typeDO.getId());
					  appType.setCourseTypeName(typeDO.getCourseTypeName());
					  appType.setSort(typeDO.getSort());
					  navBO.getCourseTypes().add(appType);
				  }
				}
				 date.add(navBO);
			}
			re.setDate(date);
			re.setSuccess(true);
		} catch (Exception e) {
			 re.setCode(ReCode.SYS_REEOR.getCode());
			 re.setMessage(ReCode.SYS_REEOR.getMessage());
			 e.printStackTrace();
		}
		return re;
	}
	
	@Override
	public Result<AppHomeTopBO> queryAppHomeTop(List<ModelQO> querys,int articleNumber,boolean needCourseNav) {
		 Result<AppHomeTopBO> re=new Result<AppHomeTopBO>();
		 if(querys==null){
			 re.setCode(ReCode.PARAM_ERROR.getCode());
			 re.setMessage(ReCode.PARAM_ERROR.getMessage());
			 return re;
		 }
		 
		 try {
			 AppHomeTopBO appHomeTop=new AppHomeTopBO();
			 
			 if(needCourseNav){
				 Result<List<AppCourseNavBO>> reCourse=queryCourse();
				 if(reCourse.isSuccess()){
					 re.setSuccess(true);
					 appHomeTop.setCourseNavs(reCourse.getDate());
				 }else{
					 re.setCode(reCourse.getCode());
					 re.setMessage(reCourse.getMessage());
				 }
			 }
			 
			 Result<List<ArticleBO>> articleRe=  appArticleService.queryArticleList(articleNumber);
			 if(articleRe.isSuccess()){
				 re.setSuccess(true);
				 appHomeTop.setArticles(articleRe.getDate());
			 }else{
				 re.setCode(articleRe.getCode());
				 re.setMessage(articleRe.getMessage());
				 return re;
			 }
			 
			 Result<Map<String,List<ModelBO>>>  modelRe=appModelService.queryModelList(querys);
			 if(modelRe.isSuccess()){
				 re.setSuccess(true);
				 appHomeTop.setModels(modelRe.getDate());
			 }else{
				 re.setCode(modelRe.getCode());
				 re.setMessage(modelRe.getMessage());
				 return re;
			 }
			 re.setDate(appHomeTop);
		} catch (Exception e) {
			 re.setCode(ReCode.SYS_REEOR.getCode());
			 re.setMessage(ReCode.SYS_REEOR.getMessage());
			 e.printStackTrace();
		}
		return re;
	}
}
