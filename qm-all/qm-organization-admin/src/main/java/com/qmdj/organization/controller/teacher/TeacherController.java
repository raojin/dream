package com.qmdj.organization.controller.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.pogo.qo.TeacherQO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.bo.TeacherBO;
import com.qmdj.service.bo.UserBO;
import com.qmdj.service.common.Result;
import com.qmdj.service.teacher.TeacherService;
import com.qmdj.service.user.UserService;

@Controller
public class TeacherController {

	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/toAddTeacher")
	public String toAdd(Model model,HttpServletRequest request,HttpServletResponse response){
		return "teacher/addTeacher";
	}
	
	@ResponseBody
	@RequestMapping("/addTeacher")
	public String addTeacher(Model model,HttpServletRequest request,HttpServletResponse response,TeacherBO teacherBO,UserBO userBO){
		Result<Integer> addUser = userService.addUser(userBO);
		teacherBO.setUserId(Long.valueOf(addUser.getDate()));
		teacherBO.setName(userBO.getName());
		Result<Integer> re = teacherService.addTeacher(teacherBO);
		return Constant.GSON.toJson(re.isSuccess());
	}
	
	@RequestMapping("/teacherList")
	public String teacherList(Model model,HttpServletRequest request,HttpServletResponse response,TeacherQO teacherQO){
		Result<PageInfo<TeacherBO>> re = teacherService.selectTeacherList(teacherQO);
		model.addAttribute(Constant.BEAN_LIST, re);
		return "teacher/teacherList";
	}
	
	
	@RequestMapping("/toUpdateTeacher")
	public String toUpdateTeacher(Model model,HttpServletRequest request,HttpServletResponse response){
		UserBO userBO =(UserBO)request.getSession().getAttribute(Constant.SESSION_BEAN);
		Result<TeacherBO> re = teacherService.selectTeacherByUserId(userBO.getUserId());
		model.addAttribute(Constant.BEAN, re);
		return "teacher/updateTeacher";
	}
	
	@ResponseBody
	@RequestMapping("/updateTeacher")
	public String updateTeacher(Model model,HttpServletRequest request,HttpServletResponse response,TeacherBO teacherBO){
		UserBO userBO =(UserBO)request.getSession().getAttribute(Constant.SESSION_BEAN);
		teacherBO.setUserId(userBO.getUserId());
		Result<Integer> re = teacherService.updateTeacher(teacherBO);
		return Constant.GSON.toJson(re.isSuccess());
	}
}
