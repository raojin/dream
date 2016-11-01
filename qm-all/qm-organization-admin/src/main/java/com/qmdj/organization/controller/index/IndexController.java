package com.qmdj.organization.controller.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qmdj.service.bo.UserBO;
import com.qmdj.service.common.Result;
import com.qmdj.service.user.UserService;

/**
*@Description: 首页IndexController
*@author chenjin
*@date 2016/10/12
*/
@Controller
public class IndexController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/tologin")
	public String toLogin(Model model,HttpServletRequest request,HttpServletResponse response){
		return "public/login.html";
	}
	
	@RequestMapping("/login")
	public String login(Model model,HttpServletRequest request,String loginName,String password){
		Result<UserBO> re=userService.login(loginName, password);
		if(re!=null){
			if(re.isSuccess()){
				request.getSession().setAttribute("user", re.getDate());
				return index(model);
			}else{
				model.addAttribute("error", re.getMessage());
			}
		}
		return index(model);
	}
	
	
	@RequestMapping("/index")
	public String index(Model model){
		return "public/index.html";
		
	}

}
