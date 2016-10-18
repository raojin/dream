package com.qmdj.organization.controller.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qmdj.common.base.Result;
import com.qmdj.domin.user.UserDO;
import com.qmdj.organization.service.impl.RedisClientImpl;
import com.qmdj.organization.user.service.UserService;

/**
*@Description: 首页IndexController
*@author chenjin
*@date 2016/10/12
*/
@Controller
public class IndexController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/toLogin")
	public String toLogin(Model model,HttpServletRequest request,HttpServletResponse response){
		return "public/login.html";
	}
	
	@RequestMapping("/login")
	public String login(Model model,HttpServletRequest request,HttpServletResponse response,String loginName,String password){
		Result<UserDO> re=userService.login(loginName, password);
		if(re!=null){
			if(re.isSuccess()){
				
			}else{
				
			}
		}
		return index(model, request, response);
	}
	
	@RequestMapping("/index")
	public String index(Model model,HttpServletRequest request,HttpServletResponse response){
		System.out.println("去登陆");
		return "public/index.html";
		
	}

}
