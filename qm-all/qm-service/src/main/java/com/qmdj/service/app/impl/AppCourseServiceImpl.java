package com.qmdj.service.app.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.service.app.AppArticleService;
import com.qmdj.service.app.AppCourseService;
import com.qmdj.service.app.AppModelService;
import com.qmdj.service.bo.ArticleBO;
import com.qmdj.service.bo.ModelBO;
import com.qmdj.service.bo.app.AppCourseTypeNavBO;
import com.qmdj.service.bo.app.AppHomeTopBO;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;

@Service
public class AppCourseServiceImpl implements AppCourseService {
	
	@Autowired
	private AppArticleService appArticleService;
	
	@Autowired
	private AppModelService appModelService;

	@Override
	public Result<List<AppCourseTypeNavBO>> queryCourse() {
		return null;
	}

	
	@Override
	public Result<AppHomeTopBO> queryAppHomeTop(List<String> moduleCodes,int moduleType,int articleNumber,boolean needCourseNav) {
		 Result<AppHomeTopBO> re=new Result<AppHomeTopBO>();
		 if(moduleCodes!=null||articleNumber<=0||moduleType<=0){
			 re.setCode(ReCode.PARAM_ERROR.getCode());
			 re.setMessage(ReCode.PARAM_ERROR.getMessage());
			 return re;
		 }
		 
		 try {
			 AppHomeTopBO appHomeTop=new AppHomeTopBO();
			 
			 if(needCourseNav){
				 Result<List<AppCourseTypeNavBO>> reCourse=queryCourse();
				 if(reCourse.isSuccess()){
					 re.setSuccess(true);
					 appHomeTop.setAppCourseTypes(reCourse.getDate());
				 }else{
					 re.setCode(reCourse.getCode());
					 re.setMessage(reCourse.getMessage());
					// return re;
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
			 
			 Result<List<ModelBO>>  modelRe=appModelService.queryModelList(moduleCodes, moduleType);
			 if(modelRe.isSuccess()){
				 re.setSuccess(true);
				 appHomeTop.setModels(modelRe.getDate());
			 }else{
				 re.setCode(modelRe.getCode());
				 re.setMessage(modelRe.getMessage());
				 return re;
			 }
		} catch (Exception e) {
			 re.setCode(ReCode.SYS_REEOR.getCode());
			 re.setMessage(ReCode.SYS_REEOR.getMessage());
			 e.printStackTrace();
		}
		return re;
	}
}
