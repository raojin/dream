package com.qmdj.platform.controller.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qmdj.biz.pogo.qo.CourseTypeQO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.bo.CourseNavBO;
import com.qmdj.service.bo.CourseTypeBO;
import com.qmdj.service.common.DwzJsonResultUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.course.CourseNavService;
import com.qmdj.service.course.CourseTypeService;

@Controller
@RequestMapping("/coueseType")
public class CourseTypeController {

	@Autowired
	private CourseTypeService courseTypeService;
	
	@Autowired
	private CourseNavService courseNavService;
	
	
	@RequestMapping("/list")
	public String list(Model model,@RequestParam(value = "querQO",required=false) CourseTypeQO querQO){
		if(querQO==null){
			querQO =new CourseTypeQO();
		} 
		Result<Pagination<CourseTypeBO>> re= courseTypeService.queryForPage(querQO);
		model.addAttribute(Constant.BEAN_LIST, re.getDate());
		return  "courseType/courseTypeList.html";
	}
	
	
	@RequestMapping("/toAdd")
	public String tologin(Model model,@RequestParam(value = "courseTypeId",required=false) Long courseTypeId){
		CourseNavBO courseNavBO=new CourseNavBO();
		courseNavBO.setStatus(1);
		Result<List<CourseNavBO>> navRe=courseNavService.queryByCondition(courseNavBO);
		model.addAttribute("courseNavList", navRe.getDate());
		if(courseTypeId!=null){
			Result<CourseTypeBO> re=courseTypeService.queryCourseTypeById(courseTypeId);
			model.addAttribute(Constant.BEAN, re.getDate());
			return "courseType/courseTypeUpdaye.html";
		}
		return "courseType/courseTypeAdd.html";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Model model,CourseTypeBO courseTypeBO){
		String message="success";
		 Result<Boolean> re=courseTypeService.inserCourseType(courseTypeBO);
		 if(re!=null){
			 if(re.isSuccess()&&re.getDate()){
				 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"coueseTypeList");
			 }else{
				 message=re.getCode()+":"+re.getMessage();
			 }
		 }else{
			 message=ReCode.SYS_REEOR.getMessage();
		 }
		 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"coueseTypeList");
	}
	
	@RequestMapping("/updateCousesType")
	@ResponseBody
	public String updateCousesType(Model model,CourseTypeBO courseTypeBO){
		String message="error";
		 Result<Boolean> re=courseTypeService.updateCourseType(courseTypeBO);
		 if(re!=null){
			 if(re.isSuccess()){
				 message="success";
				 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"coueseTypeList");
			 }else{
				 message=re.getCode()+":"+re.getMessage();
			 }
		 }else{
			 message=ReCode.SYS_REEOR.getMessage();
		 }
		 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"coueseTypeList");
	}
	
}
