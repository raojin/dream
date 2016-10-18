package com.qmdj.platform.controller.org;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.domin.form.OrgForm;
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
	   public  String  addOrg(Model model,HttpServletRequest request,HttpServletResponse response,@Valid OrganizationDO org){
		if(organizationService.save(org)){
			model.addAttribute("message", Constant.SUCCESS);
		}else{
			model.addAttribute("message", Constant.FAIL);
		}
		return "result/success.html";
		}
		
		@RequestMapping("/update")
		   public  String  toUpdateOrg(Model model,HttpServletRequest request,HttpServletResponse response,int orgId){
			OrganizationDO organizationDO = organizationService.queryByid(orgId);
			model.addAttribute("queryByid", organizationDO);
			   return "org/update.html";
			}
		@RequestMapping("/updateOrganization")
		   public  String  updateOrg(Model model,HttpServletRequest request,HttpServletResponse response,OrganizationDO org){
			if(organizationService.update(org)){
				model.addAttribute("message", Constant.SUCCESS);
			}else{
				model.addAttribute("message", Constant.FAIL);
			}
			return "result/success.html";
			}
		
		
	    @RequestMapping("/list")
	   public  String  orgList(Model model,HttpServletRequest request,HttpServletResponse response,OrgForm orgForm){
	    	PageInfo<OrganizationDO> queryList = organizationService.queryList(orgForm);
	    	System.out.println(queryList.getSize());
	    	model.addAttribute(Constant.BEAN_LIST, queryList);
		   return "org/list.html";
	    }
	    
		@RequestMapping("/save")
	   public  String  save(Model model,HttpServletRequest request,HttpServletResponse response){
		   return "org/add.html";
		}
		
}
