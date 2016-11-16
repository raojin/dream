package com.qmdj.web.controller.organization;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.qmdj.service.app.AppOrganizationService;
import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.bo.app.AppOrgDetailBO;
import com.qmdj.service.common.Result;

@Controller
public class OrganizationController {
	
	@Autowired
	private AppOrganizationService appOrganizationService;
	

	@ResponseBody
	@RequestMapping("/organization/detail")
	public String queryOrgDetail(Model model,Long orgId){
		Result<AppOrgDetailBO> re=appOrganizationService.queryOrganizationDetails(orgId);
		System.out.println(JSONObject.toJSONString(re));
		return JSONObject.toJSONString(re);
	}
	
	
	@ResponseBody
	@RequestMapping("/organization/list")
	public String queryOrgDetail(Model model,Integer tags){
		Result<Map<Integer,List<OrganizationBO>>>  re= appOrganizationService.queryOrganization(tags);
		System.out.println(JSONObject.toJSONString(re));
		return JSONObject.toJSONString(re);
	}

}
