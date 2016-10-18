package com.qmdj.platform.controller.org;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qmdj.domin.organization.OrganizationDO;
import com.qmdj.platform.service.org.impl.OrganizationServiceImpl;

@Controller
@RequestMapping("/org")
public class OrgController {
	
	@Autowired
	private OrganizationServiceImpl organizationService;

		@RequestMapping("/add")
	   public  String  toAddOrg(Model model,HttpServletRequest request,HttpServletResponse response){
		   return "org/add.html";
		}
   
		@RequestMapping("/addOrganization")
		   public  String  AddOrg(Model model,HttpServletRequest request,HttpServletResponse response,OrganizationDO org){
			organizationService.save(org);
			   return "org/add.html";
		}
		
	    @RequestMapping("/list")
	   public  String  orgList(Model model,HttpServletRequest request,HttpServletResponse response){
		   return "org/list.html";
	    }
	    
		@RequestMapping("/save")
	   public  String  save(Model model,HttpServletRequest request,HttpServletResponse response){
		   return "org/add.html";
		}
		
}
