package com.qmdj.platform.controller.org;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.util.DwzJsonResultUtil;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.common.base.Result;
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
   
		
		@ResponseBody
		@RequestMapping("/addOrganization")
	   public  String  addOrg(Model model,HttpServletRequest request,HttpServletResponse response,@Valid OrganizationDO org){
			 String message="success";
			  try {
			Result<Integer> re = organizationService.save(org);
			  if(re!=null){
				    if(re.isSuccess()&&re.getDate()>0){
				    	 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"addOrganization");
				    }else{
				    	message="error:"+re.getCode()+re.getMessage();
				    }
			     }
			} catch (Exception e) {
				message="error"+e.getMessage();
			}
		return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"addOrganization");
		}
		
		
		@RequestMapping("/toUpdate")
		   public  String  toUpdateOrg(Model model,HttpServletRequest request,HttpServletResponse response,int orgId){
			 OrganizationDO queryByid = organizationService.queryByid(orgId);
			 model.addAttribute(Constant.BEAN, queryByid);
			 return "org/update.html";
			}
		
		@ResponseBody
		@RequestMapping("/updateOrganization")
		   public  String  updateOrg(Model model,HttpServletRequest request,HttpServletResponse response,OrganizationDO org){
			 String message="success";
			  try {
				  Result<Integer> re = organizationService.update(org);
			  if(re!=null){
				    if(re.isSuccess()){
				    	 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"updateOrganization");
				    }else{
				    	message="error:"+re.getCode()+re.getMessage();
				    }
			     }
			} catch (Exception e) {
				message="error"+e.getMessage();
			}
		return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"updateOrganization");
			}
		
		
	    @RequestMapping("/list")
	   public  String  orgList(Model model,HttpServletRequest request,HttpServletResponse response,OrgForm orgForm){
			PageInfo<OrganizationDO> queryList = organizationService.queryList(orgForm);
			model.addAttribute(Constant.BEAN_LIST, queryList);
			return "org/list.html";

		}
	    
		@RequestMapping("/save")
	   public  String  save(Model model,HttpServletRequest request,HttpServletResponse response){
		   return "org/add.html";
		}
		
		
		@ResponseBody
		@RequestMapping("/delOrganization")
		   public  String  delOrg(Model model,HttpServletRequest request,HttpServletResponse response,OrganizationDO org){
			 String message="success";
			  try {
				  Result<Integer> re = organizationService.del(org);
			  if(re!=null){
				    if(re.isSuccess()){
				    	 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"updateOrganization");
				    }else{
				    	message="error:"+re.getCode()+re.getMessage();
				    }
			     }
			} catch (Exception e) {
				message="error"+e.getMessage();
			}
		return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"updateOrganization");
			}
		
}
