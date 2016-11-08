package com.qmdj.platform.controller.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qmdj.biz.pogo.qo.CourseNavQO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.bo.CourseNavBO;
import com.qmdj.service.common.DwzJsonResultUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.course.CourseNavService;

@Controller
@RequestMapping("/coueseNav")
public class CoueseNavController {

	@Autowired
	private CourseNavService courseNavService;

	
	@RequestMapping("/list")
	public String list(Model model,CourseNavQO querQO){
		Result<Pagination<CourseNavBO>> re= courseNavService.queryForPage(querQO);
		model.addAttribute(Constant.BEAN_LIST, re.getDate());
		return  "courseNav/courseNavList.html";
	}
	
	
	@RequestMapping("/toAdd")
	public String tologin(Model model,@RequestParam(value = "courseNavId",required=false) Long courseNavId){
		if(courseNavId!=null){
			Result<CourseNavBO> re=	courseNavService.queryCourseNavById(courseNavId);
			model.addAttribute(Constant.BEAN, re.getDate());
			return "courseNav/courseUpdaye.html";
		}
		return "courseNav/courseNavAdd.html";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Model model,CourseNavBO courseNavBO){
		String message="success";
		 Result<Boolean> re=courseNavService.insertCourseNav(courseNavBO);
		 if(re!=null){
			 if(re.isSuccess()&&re.getDate()){
				 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"coueseNavList");
			 }else{
				 message=re.getCode()+":"+re.getMessage();
			 }
		 }else{
			 message=ReCode.SYS_REEOR.getMessage();
		 }
		 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"coueseNavList");
	}
	
	@RequestMapping("/updateCousesNav")
	@ResponseBody
	public String updateCousesType(Model model,CourseNavBO courseNavBO){
		String message="error";
		 Result<Boolean> re=courseNavService.updateCourseNav(courseNavBO);
		 if(re!=null){
			 if(re.isSuccess()){
				 message="success";
				 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"coueseNavList");
			 }else{
				 message=re.getCode()+":"+re.getMessage();
			 }
		 }else{
			 message=ReCode.SYS_REEOR.getMessage();
		 }
		 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"coueseTypeList");
	}
	
}
