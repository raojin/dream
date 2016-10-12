package com.qmdj.web.controller.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*@Description: 首页控制器
*@author chenjin
*@date 2016/10/12
*/
@Controller
public class IndexController {

	@RequestMapping("/index")
	public String Index(Model model,HttpServletRequest request,HttpServletResponse response){
		model.addAttribute("name", "杰克");
		return  "/index.html";
	}
	
}
