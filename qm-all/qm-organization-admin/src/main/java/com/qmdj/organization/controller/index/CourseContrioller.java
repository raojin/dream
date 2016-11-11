package com.qmdj.organization.controller.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.pogo.qo.CourseQO;
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
		return "course/addCourse";
	}
	
	@RequestMapping("/addCourse")
	public String addCourse(Model model,HttpServletRequest request,HttpServletResponse response,CourseBO course){
		System.out.println(Constant.GSON.toJson(course));
		UserBO userBO = (UserBO)request.getSession().getAttribute(Constant.SESSION_BEAN);
		if(userBO==null){
			return "public/login";
		}
		course.setCourseId(userBO.getUserId());
		if(userBO.getIdentity()==5){
			Result<OrganizationBO> selectOrganizationByUserid = organizationService.selectOrganizationByUserid(course.getCourseId());
			Long organizationId = selectOrganizationByUserid.getDate().getOrganizationId();
			course.setParentid(organizationId);
		}
		Result<Integer> re = courseService.addCourse(course);
		System.out.println(Constant.GSON.toJson(re));
		if(re.isSuccess()){
			model.addAttribute(Constant.MSG, true);
		}else{
			model.addAttribute(Constant.ERROR, re.getMessage());
			return "forward:public/login";//toLogin(model,request,response);//"public/login.html";
		}
		return toAdd( model, request, response);
	}
	
	@RequestMapping("/courselist")
	public String courseList(Model model,HttpServletRequest request,HttpServletResponse response,CourseQO courseQO){
		 Result<PageInfo<CourseBO>> queryForPage = courseService.queryForPage(courseQO);
		System.out.println(queryForPage.getDate().getList().size());
		model.addAttribute(Constant.BEAN_LIST, queryForPage);
		return "course/courseList";
	}

}
