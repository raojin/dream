package com.qmdj.web.controller.index;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.qmdj.service.app.AppCourseService;
import com.qmdj.service.app.AppOrganizationService;
import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.bo.app.AppHomeTopBO;
import com.qmdj.service.common.Result;

/**
*@Description: 首页控制器
*@author chenjin
*@date 2016/10/12
*/
@Controller
public class IndexController {
	
	@Autowired
	private AppCourseService appCourseService;
	
	private AppOrganizationService appOrganizationService;
	
	@ResponseBody
	@RequestMapping("/index/top")
	public String IndexTop(Model model,HttpServletRequest request,HttpServletResponse response){
		 List<String> moduleCodes=new ArrayList<String>();
		 Result<AppHomeTopBO> re= appCourseService.queryAppHomeTop(moduleCodes, 1, 5,true);
		return JSONObject.toJSONString(re);
	}
	
	@ResponseBody
	@RequestMapping("/index/organization")
	public String IndexOrg(Model model,HttpServletRequest request,HttpServletResponse response){
		Result<Map<Integer,List<OrganizationBO>>> re= appOrganizationService.queryOrganization(0);
		return JSONObject.toJSONString(re);
	}
}
