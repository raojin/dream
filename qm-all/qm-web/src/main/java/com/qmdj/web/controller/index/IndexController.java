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
import com.qmdj.biz.pogo.qo.ModelQO;
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
	
	@Autowired
	private AppOrganizationService appOrganizationService;
	
	@ResponseBody
	@RequestMapping(value="/index/top")
	public String IndexTop(Model model,HttpServletRequest request,HttpServletResponse response){
		List<ModelQO> querys=new ArrayList<ModelQO>();
		querys.add(new ModelQO("logo",1)); 
		querys.add(new ModelQO("index_nav_model",1));
		querys.add(new ModelQO("index_top_banner",1));
		 Result<AppHomeTopBO> re= appCourseService.queryAppHomeTop(querys,5,true);
		 System.out.println(JSONObject.toJSONString(re));
		return JSONObject.toJSONString(re);
	}
	
	@ResponseBody
	@RequestMapping("/index/organization")
	public String IndexOrg(Model model,HttpServletRequest request,HttpServletResponse response){
		Result<Map<Integer,List<OrganizationBO>>> re= appOrganizationService.queryOrganization(0);
		System.out.println(JSONObject.toJSONString(re));
		return JSONObject.toJSONString(re);
	}
}
