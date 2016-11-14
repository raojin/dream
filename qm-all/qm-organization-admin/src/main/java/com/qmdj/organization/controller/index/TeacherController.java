package com.qmdj.organization.controller.index;

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

@Controller
public class TeacherController {

	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/toAddTeacher")
	public String toAdd(Model model,HttpServletRequest request,HttpServletResponse response){
		return "teacher/addTeacher";
	}
	
	@ResponseBody
	@RequestMapping("/addTeacher")
	public String addTeacher(Model model,HttpServletRequest request,HttpServletResponse response,TeacherBO teacherBO){
		UserBO userBO =(UserBO)request.getSession().getAttribute(Constant.SESSION_BEAN);
		teacherBO.setUserId(userBO.getUserId());
		teacherBO.setName(userBO.getName());
		Result<Integer> addTeacher = teacherService.addTeacher(teacherBO);
		return Constant.GSON.toJson(addTeacher.isSuccess());
	}
	
	@RequestMapping("/teacherList")
	public String teacherList(Model model,HttpServletRequest request,HttpServletResponse response,TeacherQO teacherQO){
		Result<PageInfo<TeacherBO>> selectTeacherList = teacherService.selectTeacherList(teacherQO);
		model.addAttribute(Constant.BEAN_LIST, selectTeacherList);
		return "teacher/teacherList";
	}
}
