package com.qmdj.organization.controller.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	@RequestMapping("/addCourse")
	public String addCourse(Model model,HttpServletRequest request,HttpServletResponse response,CourseBO course){
		System.out.println(Constant.GSON.toJson(course));
		UserBO userBO = (UserBO)request.getSession().getAttribute(Constant.SESSION_BEAN);
		Result<Integer> re =new Result<Integer>();
		if(userBO==null){
			return Constant.GSON.toJson(re.isSuccess());
		}
		course.setCourseId(userBO.getUserId());
		if(userBO.getIdentity()==5){
			Result<OrganizationBO>	selectOrganizationByUserid = organizationService.selectOrganizationByUserid(course.getCourseId());
			Long organizationId = selectOrganizationByUserid.getDate().getOrganizationId();
			course.setParentid(organizationId);
		}
		re = courseService.addCourse(course);
		return Constant.GSON.toJson(re.isSuccess());
	}
	
	@RequestMapping("/courselist")
	public String courseList(Model model,HttpServletRequest request,HttpServletResponse response,CourseQO courseQO){
		 Result<PageInfo<CourseBO>> queryForPage = courseService.queryForPage(courseQO);
		System.out.println(queryForPage.getDate().getList().size());
		model.addAttribute(Constant.BEAN_LIST, queryForPage);
		return "course/courseList";
	}
	
	@RequestMapping("/toUpdateCourse")
	public String toUpdateCourse(Model model,HttpServletRequest request,HttpServletResponse response,long courseId){
		Result<CourseBO> selectCourse = courseService.selectCourse(courseId);
		model.addAttribute(Constant.BEAN,selectCourse);
		return "course/updateCourse";
	}
	
	@ResponseBody
	@RequestMapping("/updateCourse")
	public String updateCourse(Model model,HttpServletRequest request,HttpServletResponse response,CourseBO course){
		Result<Integer> updateCourse = courseService.updateCourse(course);
		return Constant.GSON.toJson(updateCourse.isSuccess());
	}
	
	@RequestMapping("/delCourse")
	public String delCourse(Model model,HttpServletRequest request,HttpServletResponse response,long courseId){
		Result<Integer> updateCourse = courseService.delCourse(courseId);
		CourseQO courseQO =new CourseQO(); 
		return courseList(model, request, response, courseQO);
	}
}
