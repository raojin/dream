package com.qmdj.platform.controller.couese;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.util.DwzJsonResultUtil;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.common.base.ReCode;
import com.qmdj.common.base.Result;
import com.qmdj.domin.course.CourseDO;
import com.qmdj.domin.form.CourseForm;
import com.qmdj.platform.service.course.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {


	@Autowired
	private CourseService coueseService;
	
	@RequestMapping("/list")
	public String list(Model model,HttpServletRequest request,HttpServletResponse response,CourseForm courseForm){
		PageInfo<CourseDO> selectList = coueseService.selectList(courseForm);
		model.addAttribute(Constant.BEAN_LIST, selectList);
		return  "course/courseList.html";
	}
	
	
	@RequestMapping("/toAdd")
	public String tologin(Model model,HttpServletRequest request,HttpServletResponse response){
		return "course/courseAdd.html";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Model model,HttpServletRequest request,HttpServletResponse response,@Valid CourseDO cousesDO){
		String message="success";
		 Result<Integer> re=coueseService.save(cousesDO);
		 if(re!=null){
			 if(re.isSuccess()){
				 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"saveCouese");
			 }else{
				 message=re.getCode()+":"+re.getMessage();
			 }
		 }else{
			 message=ReCode.SYS_REEOR.getMessage();
		 }
		 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"saveCouese");
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdate(Model model,HttpServletRequest request,HttpServletResponse response,int id){
		CourseDO select = coueseService.select(id);
		model.addAttribute(Constant.BEAN, select);
		return "course/toUpdateCourse.html";
	}
	
	@RequestMapping("/updateCourses")
	@ResponseBody
	public String updateCousesType(Model model,HttpServletRequest request,HttpServletResponse response,CourseDO cousesDO){
		String message="success";
		 Result<Integer> re=coueseService.update(cousesDO);
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
	
	@RequestMapping("/delCourses")
	@ResponseBody
	public String delCousesType(Model model,HttpServletRequest request,HttpServletResponse response,CourseDO courseDO){
		String message="success";
		 Result<Integer> re=coueseService.del(courseDO);
		 if(re!=null){
			 if(re.isSuccess()){
				 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"delCourses");
			 }else{
				 message=re.getCode()+":"+re.getMessage();
			 }
		 }else{
			 message=ReCode.SYS_REEOR.getMessage();
		 }
		 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"delCourses");
	}
	
}
