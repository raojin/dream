package com.qmdj.platform.controller.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qmdj.common.base.Result;
import com.qmdj.domin.user.StaffDO;
import com.qmdj.platform.service.staff.StaffService;

/**
*@Description: 首页IndexController
*@author chenjin
*@date 2016/10/12
*/
@Controller
public class IndexController{
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping("/index")
	public String index(Model model,HttpServletRequest request,HttpServletResponse response){
		return "public/index.html";
	}
	
	@RequestMapping("/tologin")
	public String tologin(Model model,HttpServletRequest request,HttpServletResponse response){
		return "public/login.html";
	}

	@RequestMapping("/login")
	public String login(Model model,HttpServletRequest request,HttpServletResponse response,String loginName,String password){
		Result<StaffDO> re=staffService.login(loginName, password);
		String message=null;
		if(re!=null){
			if(re.isSuccess()){
				model.addAttribute("staff", re.getDate());
				request.getSession().setAttribute("staff", re.getCode());
				return "public/index.html";
			}else{
				message=re.getMessage();
			}
       }else{
    	   message="系统错误";
       }
		model.addAttribute("error", message);
		return "public/login.html";
	}
	
	
}
