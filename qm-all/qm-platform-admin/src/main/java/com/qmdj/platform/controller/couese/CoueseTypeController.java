package com.qmdj.platform.controller.couese;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qmdj.biz.domin.CourseTypeDO;
import com.qmdj.biz.util.DwzJsonResultUtil;
import com.qmdj.biz.util.ReCode;
import com.qmdj.biz.util.Result;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.platform.service.course.CourseTypeService;

@Controller
@RequestMapping("/coueseType")
public class CoueseTypeController {


	@Autowired
	private CourseTypeService coueseTypeService;
	
	@RequestMapping("/list")
	public String list(Model model,HttpServletRequest request,HttpServletResponse response){
		Result<List<CourseTypeDO>> re= coueseTypeService.queryCoueseTypeList();
		model.addAttribute("courseTypeList", re.getDate());
		return  "courseType/courseTypeList.html";
	}
	
	
	@RequestMapping("/toAdd")
	public String tologin(Model model,HttpServletRequest request,HttpServletResponse response){
		return "courseType/courseTypeAdd.html";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Model model,HttpServletRequest request,HttpServletResponse response,CourseTypeDO cousesTypeDO){
		String message="success";
		 Result<Integer> re=coueseTypeService.saveCoueseType(cousesTypeDO);
		 if(re!=null){
			 if(re.isSuccess()){
				 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"coueseTypeList");
			 }else{
				 message=re.getCode()+":"+re.getMessage();
			 }
		 }else{
			 message=ReCode.SYS_REEOR.getMessage();
		 }
		 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"coueseTypeList");
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdate(Model model,HttpServletRequest request,HttpServletResponse response,int id){
		CourseTypeDO selectCoueseTypeById = coueseTypeService.selectCoueseTypeById(id);
		model.addAttribute(Constant.BEAN, selectCoueseTypeById);
		return "courseType/toUpdateCourseType.html";
	}
	
	@RequestMapping("/updateCousesType")
	@ResponseBody
	public String updateCousesType(Model model,HttpServletRequest request,HttpServletResponse response,CourseTypeDO cousesTypeDO){
		String message="success";
		 Result<Integer> re=coueseTypeService.updateCoueseType(cousesTypeDO);
		 if(re!=null){
			 if(re.isSuccess()){
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
