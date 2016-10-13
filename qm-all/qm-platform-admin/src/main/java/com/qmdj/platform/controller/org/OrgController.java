package com.qmdj.platform.controller.org;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/org")
public class OrgController {

	@RequestMapping("/add")
   public  String  toAddOrg(Model model,HttpServletRequest request,HttpServletResponse response){
	   return "org/add.html";
   }
   
	@RequestMapping("/list")
	   public  String  orgList(Model model,HttpServletRequest request,HttpServletResponse response){
		   System.out.println("ssssssssssss");
		   return "org/list.html";
	   }
	   
   
   
}
