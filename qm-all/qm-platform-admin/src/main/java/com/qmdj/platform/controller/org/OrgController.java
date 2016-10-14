package com.qmdj.platform.controller.org;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qmdj.biz.util.DwzJsonResultUtil;
import com.qmdj.common.base.Result;
import com.qmdj.domin.user.UserDO;
import com.qmdj.platform.service.impl.org.OrgUserSericeImpl;

@Controller
@RequestMapping("/org")
public class OrgController {
	
	    @Autowired
	   private OrgUserSericeImpl orgUserSerice;

		@RequestMapping("/add")
	   public  String  toAddOrg(Model model,HttpServletRequest request,HttpServletResponse response){
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
		
	   @RequestMapping("/userAdd")
	   public  String  toAddUser(Model model,HttpServletRequest request,HttpServletResponse response){
		   return "org/userAdd.html";
	   }
	   
	   @ResponseBody
	   @RequestMapping("/userSave")
	   public  String  userSave(Model model,HttpServletRequest request,HttpServletResponse response,UserDO userDO){
		   String message="success";
		   try {
			   userDO.setIdentity(5);
			Result<Integer> re=orgUserSerice.saveUser(userDO);
			   if(re!=null){
				    if(re.isSuccess()&&re.getDate()>0){
				    	 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"orguserlist");
				    }else{
				    	message="error:"+re.getCode()+re.getMessage();
				    }
			     }
			} catch (Exception e) {
				message="error"+e.getMessage();
			}
		return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"orguserlist");
	   }
	   
	   
	   
	    @RequestMapping("/userList")
	   public  String  userList(Model model,HttpServletRequest request,HttpServletResponse response){
	    	Result<List<UserDO>> re= orgUserSerice.queryUserList();
	    	model.addAttribute("userList", re.getDate());
		   return "org/userlist.html";
	   }


		public void setOrgUserSerice(OrgUserSericeImpl orgUserSerice) {
			this.orgUserSerice = orgUserSerice;
		}
	    
}