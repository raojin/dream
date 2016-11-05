package com.qmdj.platform.controller.organization;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qmdj.biz.pogo.qo.OrganizationQO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.bo.UserBO;
import com.qmdj.service.common.DwzJsonResultUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.Result;
import com.qmdj.service.organization.OrganizationService;
import com.qmdj.service.user.OrgUserSerice;

@Controller
@RequestMapping("/org")
public class OrgController {
	
    @Autowired
	private OrgUserSerice orgUserSerice;
	
	@Autowired
	private OrganizationService organizationService;
	

    @RequestMapping("/list")
    public  String  orgList(Model model,@RequestParam(value = "queryQO",required=false) OrganizationQO queryQO){
    	Result<Pagination<OrganizationBO>> queryList = organizationService.queryOrganizationForPage(queryQO);
		model.addAttribute(Constant.BEAN_LIST, queryList.getDate());
		model.addAttribute(Constant.BEAN, queryQO);
		return "org/list.html";
	}
   
		@ResponseBody
		@RequestMapping("/saveOrganization")
	   public  String  saveOrganization(Model model,OrganizationBO org){
			 String message="success";
			  try {
		     Result<UserBO> reuser= orgUserSerice.queryUserById(org.getUserId());
		     org.setUserName(reuser.getDate().getName());
		     org.setStatus(2);
		     org.setIsDel(1); 
			 Result<Boolean> re= organizationService.insertOrganization(org);
			  if(re!=null){
				    if(re.isSuccess()&&re.getDate()){
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
		
		
		@RequestMapping("/toAdd")
		   public  String  toUpdateOrg(Model model,@RequestParam(value = "orgId",required=false) Long orgId){
			 Result<List<UserBO>> userlist=orgUserSerice.queryUserList();
			 model.addAttribute("userList", userlist.getDate());
			  if(orgId==null){
					 return "org/add.html";
				}
			 Result<OrganizationBO> re = organizationService.queryByOrganizationId(orgId);
			 model.addAttribute(Constant.BEAN, re.getDate());
			 return "org/update.html";
			}
		
		@ResponseBody
		@RequestMapping("/updateOrganization")
		   public  String  updateOrg(Model model,OrganizationBO org){
			 String message="error";
			  try {
				  Result<Boolean> re = organizationService.updateOrganization(org); 
			  if(re!=null){
				    if(re.isSuccess()&&re.getDate()){
				    	message="success";
				    	 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"orglist");
				    }else{
				    	message="error:"+re.getCode()+re.getMessage();
				    }
			     }
			} catch (Exception e) {
				message="error"+e.getMessage();
			}
		   return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"orglist");
			}
		
		
		@ResponseBody
		@RequestMapping("/updateOrgStatus")
		public String updateOrgStatus(Long orgId,@RequestParam(value = "isDel",required=false) Integer isDel,
				@RequestParam(value = "status",required=false) Integer status){
			 String message="error";
			 if(orgId!=null){
				 OrganizationBO org=new OrganizationBO();
				 org.setStatus(status);
				 org.setIsDel(isDel);
				 org.setOrganizationId(orgId);
				 Result<Boolean> re = organizationService.updateOrganization(org);
				 if(re.isSuccess()&&re.isSuccess()){
					 message="success";
					 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"orglist");
				 }
			 }
			return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"orglist");
		}
		
		
}