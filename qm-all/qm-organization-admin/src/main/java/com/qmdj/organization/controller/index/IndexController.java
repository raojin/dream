package com.qmdj.organization.controller.index;

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
	@ResponseBody
	public String toLogin(Model model,HttpServletRequest request,HttpServletResponse response){
		System.out.println("sssssss");
		return "ssss";
	}
	
	@RequestMapping("/login")
	public String login(Model model,HttpServletRequest request,String loginName,String password){
		Result<UserBO> re=userService.login(loginName, password);
		if(re!=null){
			if(re.isSuccess()){
//				request.getSession().setAttribute("user", re.getDate());
				model.addAttribute("user", re);
				return index(model);
			}else{
				model.addAttribute("error", re.getMessage());
			}
		}
		return index(model);
	}
	
	
	@RequestMapping("/index")
	public String index(Model model){
		return "public/index1.jsp";
		
	}

}
