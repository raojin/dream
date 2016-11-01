package com.qmdj.web.controller.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qmdj.service.organization.OrganizationService;

/**
*@Description: 首页控制器
*@author chenjin
*@date 2016/10/12
*/
@Controller
public class IndexController {

	@Autowired
    private OrganizationService organizationService;
	
	@ResponseBody
	@RequestMapping("/index")
	public String Index(Model model,HttpServletRequest request,HttpServletResponse response){
		
		return  "/index.html";
	}
	
}
