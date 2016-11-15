package com.qmdj.organization.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.bo.UserBO;
import com.qmdj.service.common.Result;
import com.qmdj.service.user.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/toAddUser")
	public String toAddUser(Model model,HttpServletRequest request,HttpServletResponse response){
		return "user/addUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(Model model,HttpServletRequest request,HttpServletResponse response,UserBO userBO){
		Result<Integer> addUser = userService.addUser(userBO);
		return Constant.GSON.toJson(addUser.isSuccess());
	}
	
	@RequestMapping("/toUpdateUser")
	public String toUpdateUser(Model model,HttpServletRequest request,HttpServletResponse response){
		UserBO userBO = (UserBO)request.getSession().getAttribute(Constant.SESSION_BEAN);
		Result<UserBO> selectUser = userService.selectUser(userBO.getUserId());
		model.addAttribute(Constant.BEAN, selectUser);
		return "user/updateUser";
	}
	
	@ResponseBody
	@RequestMapping("/updateUser")
	public String updateUser(Model model,HttpServletRequest request,HttpServletResponse response,UserBO userBO){
		UserBO userBOSession = (UserBO)request.getSession().getAttribute(Constant.SESSION_BEAN);
		userBO.setUserId(userBOSession.getUserId());
		Result<Integer> updateUser = userService.updateUser(userBO);
		return Constant.GSON.toJson(updateUser.isSuccess());
	}

}
