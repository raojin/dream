package com.qmdj.organization.controller.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qmdj.service.bo.CourseBO;
import com.qmdj.service.course.CourseService;



@Controller
@RequestMapping("/course")
public class CourseContrioller {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping("/toAddCourse")
	public String toLogin(Model model,HttpServletRequest request,HttpServletResponse response){
		return "course/flot.html";
	}
	
	@RequestMapping("/addCourse")
	public String addCourse(Model model,HttpServletRequest request,HttpServletResponse response,CourseBO course){
//		courseService
		return "course/flot.html";
	}

}
