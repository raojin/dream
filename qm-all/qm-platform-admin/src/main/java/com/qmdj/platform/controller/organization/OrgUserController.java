package com.qmdj.platform.controller.organization;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qmdj.biz.pogo.qo.UserQO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.bo.UserBO;
import com.qmdj.service.common.DwzJsonResultUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.Result;
import com.qmdj.service.user.OrgUserSerice;

@Controller
@RequestMapping("/orgUser")
public class OrgUserController {
	
	   @Autowired
	   private OrgUserSerice orgUserSerice;
	 
	   @RequestMapping("/userList")
	   public  String  userList(Model model, UserQO queryQO){
	    	Result<Pagination<UserBO>> re= orgUserSerice.queryOrgUserForPage(queryQO);
	    	model.addAttribute(Constant.BEAN_LIST, re.getDate());
		   return "org/userlist.html";
	   }

	   @RequestMapping("/userAdd")
	   public  String  toAddUser(Model model,@RequestParam(value = "userId",required=false) Long userId){
		       if(userId!=null&&userId>0){
		    	   Result<UserBO> re=  orgUserSerice.queryUserById(userId);
		    	   if(re.isSuccess()){
		    		   model.addAttribute(Constant.BEAN, re.getDate());
		    		   return "org/userUpdate.html";
		    	   }
		       }
			   return "org/userAdd.html";
	   }

	   @ResponseBody
	   @RequestMapping("/userSave")
	   public  String  userSave(Model model,HttpServletRequest request,HttpServletResponse response,UserBO userDO){
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
	   
	   @ResponseBody
	   @RequestMapping("/userUpdate")
	   public  String  update(Model model,HttpServletRequest request,HttpServletResponse response,UserBO userBO){
		   String message="error";
			   Result<Boolean> re=orgUserSerice.updateUser(userBO);
				    if(re.isSuccess()&&re.getDate()){
				    	 message="success";
				    	 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"orguseradd");
				    }
		   return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"orguseradd");
	   }
}
