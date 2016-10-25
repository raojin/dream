package com.qmdj.platform.controller.org;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.domin.OrgForm;
import com.qmdj.biz.domin.OrganizationDO;
import com.qmdj.biz.domin.UserDO;
import com.qmdj.biz.util.DwzJsonResultUtil;
import com.qmdj.biz.util.Result;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.platform.service.org.impl.OrgUserSericeImpl;
import com.qmdj.platform.service.org.impl.OrganizationServiceImpl;

@Controller
@RequestMapping("/org")
public class OrgController {
	
    @Autowired
	private OrgUserSericeImpl orgUserSerice;
	
	@Autowired
	private OrganizationServiceImpl organizationService;
	

    @RequestMapping("/list")
    public  String  orgList(Model model,HttpServletRequest request,HttpServletResponse response,OrgForm orgForm){
		PageInfo<OrganizationDO> queryList = organizationService.queryList(orgForm);
		model.addAttribute(Constant.BEAN_LIST, queryList);
		return "org/list.html";

	}

		@RequestMapping("/toAdd")
	   public  String  toAddOrg(Model model){
			Result<List<UserDO>> userlist=orgUserSerice.queryUserList();
		    model.addAttribute("userList", userlist.getDate());
		   return "org/add.html";
		}
   
		
		@ResponseBody
		@RequestMapping("/saveOrganization")
	   public  String  saveOrganization(Model model,OrganizationDO org){
			 String message="success";
			  try {
		     Result<UserDO> reuser= orgUserSerice.queryUserById(org.getUserId());
		     org.setUserName(reuser.getDate().getName());
		     org.setStatus(2);
		     org.setIsDel(1);
			 Result<Integer> re = organizationService.save(org);
			  if(re!=null){
				    if(re.isSuccess()&&re.getDate()>0){
				    	 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"orglist");
				    }else{
				    	message="error:"+re.getCode()+re.getMessage();
				    }
			     }
			} catch (Exception e) {
				e.printStackTrace();
				message="error"+e.getMessage();
			}
		return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"orglist");
		}
		
		
		@RequestMapping("/toUpdate")
		   public  String  toUpdateOrg(Model model,int orgId){
			 OrganizationDO queryByid = organizationService.queryByid(orgId);
			 Result<List<UserDO>> userlist=orgUserSerice.queryUserList();
			 model.addAttribute("userList", userlist.getDate());
			 model.addAttribute(Constant.BEAN, queryByid);
			 return "org/update.html";
			}
		
		@ResponseBody
		@RequestMapping("/updateOrganization")
		   public  String  updateOrg(Model model,OrganizationDO org){
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
		
}