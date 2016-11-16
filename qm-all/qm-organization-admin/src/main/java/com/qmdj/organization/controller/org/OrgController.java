package com.qmdj.organization.controller.org;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.bo.UserBO;
import com.qmdj.service.common.Result;
import com.qmdj.service.organization.OrganizationService;

/**
*@Description: 首页IndexController
*@author chenjin
*@date 2016/10/12
*/
@Controller
public class OrgController{
	
	@Autowired
	private OrganizationService  organizationService;
	
	@RequestMapping("/toUpdateOrg")
	public String toUpdate(Model model,HttpServletRequest request,HttpServletResponse response,long orgId){
		Result<OrganizationBO> re = organizationService.queryByOrganizationId(orgId);
		model.addAttribute(Constant.BEAN, re);
		return "org/updateOrg";
	}
	
	@ResponseBody
	@RequestMapping("/updateOrg")
	public String updateOrg(Model model,HttpServletRequest request,HttpServletResponse response,OrganizationBO organizationBO){
		Result<Boolean> re = organizationService.updateOrganization(organizationBO);
		return Constant.GSON.toJson(re.isSuccess());
	}
	
	
	
//	@RequestMapping("/")
//	public String index(Model model,HttpServletRequest request,HttpServletResponse response){
//		UserBO attribute = (UserBO)request.getSession().getAttribute(Constant.SESSION_BEAN);
//		Result<UserBO> re=new Result<UserBO>();
//		re.setDate(attribute);
//		model.addAttribute(Constant.BEAN, re);
//		return "public/index";
//	}
//	@RequestMapping(value="/",method=RequestMethod.GET)
//	public String loginGet(Model model,HttpServletRequest request,HttpServletResponse response){
//		return "public/login";
//	}
//	
//	@RequestMapping(value="/",method=RequestMethod.POST)
//	public String login(Model model,HttpServletRequest request,UserBO user,HttpServletResponse response) throws IOException{
//		Result<UserBO> re=userService.login(user.getLoginName(), user.getPassword());
//		if(re!=null){
//			if(re.isSuccess()){
//				request.getSession().setAttribute(Constant.SESSION_BEAN, re.getDate());
//				request.getSession().setAttribute(Constant.NAME, re.getDate().getName());
//				model.addAttribute(Constant.BEAN, re);
//				return "public/index";
//				
//			}else{
//				model.addAttribute(Constant.ERROR, re.getMessage());
//				return toLogin(model,request,response);//"public/login.html";
//			}
//		}else{
//		return toLogin(model,request,response);//"public/login.html";
//		}
//		
//	}
//	
//	
//	@RequestMapping("/")
//	public String index(Model model,HttpServletRequest request , UserDO user){
//		
//		Result<UserBO> re=userService.login(user.getLoginName(), user.getPassword());
//		if(re!=null){
//			if(re.isSuccess()){
//				request.getSession().setAttribute("user", re.getDate());
//				model.addAttribute("user", re);
//			}else{
//				model.addAttribute("error", re.getMessage());
//			}
//		return "public/login.html";
//		}else{
//			
//		return "public/login.html";
//		}
//	}
//	@RequestMapping("/")
//	public String loginOut(Model model,HttpServletRequest request , UserDO user){
//		request.getSession().removeAttribute(Constant.SESSION_BEAN);
//		return "public/login";
//	}
	
	

}
