package com.qmdj.org.controller.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qmdj.org.service.UserService;
import com.qmdj.org.service.impl.RedisClientImpl;
import com.qmdj.org.service.impl.UserServiceImpl;

/**
*@Description: 首页IndexController
*@author chenjin
*@date 2016/10/12
*/
@Controller
public class IndexController{

	@Autowired
 private UserService userService;	
	
	@Autowired
 private RedisClientImpl redisClient;
	
	@RequestMapping("/login")
	public String index(Model model,HttpServletRequest request,HttpServletResponse response){
		System.out.println("去登陆");
		model.addAttribute("name", "陈金");
		return "public/login.html";
	}
	
	@RequestMapping("/index")
	public String IndexMenu(Model model,HttpServletRequest request,HttpServletResponse response){
		System.out.println("去登陆");
		return "public/index.html";
		
	}
	
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

	public void setRedisClient(RedisClientImpl redisClient) {
		this.redisClient = redisClient;
	}
}
