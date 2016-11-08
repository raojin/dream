package com.qmdj.organization.controller.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.bo.CourseBO;
import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.bo.UserBO;
import com.qmdj.service.common.Result;
import com.qmdj.service.course.CourseService;
import com.qmdj.service.organization.OrganizationService;



@Controller
public class CourseContrioller {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	OrganizationService organizationService;
	
	
	@RequestMapping("/toAddCourse")
	public String toAdd(Model model,HttpServletRequest request,HttpServletResponse response){
		return "course/addCourse.html";
	}
	
	@RequestMapping("/addCourse")
	public String addCourse(Model model,HttpServletRequest request,HttpServletResponse response,CourseBO course){
		System.out.println(Constant.GSON.toJson(course));
		UserBO userBO = (UserBO)request.getSession().getAttribute(Constant.SESSION_BEAN);
		
		course.setCourseId(userBO.getUserId());
		if(userBO.getIdentity()==5){
			Result<OrganizationBO> selectOrganizationByUserid = organizationService.selectOrganizationByUserid(course.getCourseId());
			Long organizationId = selectOrganizationByUserid.getDate().getOrganizationId();
			course.setParentid(organizationId);
		}
		Result<Integer> re = courseService.addCourse(course);
		System.out.println(Constant.GSON.toJson(re));
		if(re.isSuccess()){
			
			
		}else{
			model.addAttribute(Constant.ERROR, re.getMessage());
			return "forward:public/login.html";//toLogin(model,request,response);//"public/login.html";
		}
		return toAdd( model, request, response);
	}

}
