package com.qmdj.platform.controller.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qmdj.biz.pogo.qo.ModelQO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.bo.ModelBO;
import com.qmdj.service.common.DwzJsonResultUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.model.ModelService;

@Controller
@RequestMapping("/modelResourse")
public class ModelController {
	
	@Autowired
	private ModelService modelSerice;

	
	@RequestMapping("/list")
	public String list(Model model,@RequestParam(value = "querQO",required=false) ModelQO querQO){
		Result<Pagination<ModelBO>> re= modelSerice.queryForPage(querQO);
		model.addAttribute(Constant.BEAN_LIST, re.getDate());
		return  "modelResource/list.html";
	}
	
	
	@RequestMapping("/toAdd")
	public String tologin(Model model,@RequestParam(value = "modelId",required=false) Long modelId){
		if(modelId!=null){
			Result<ModelBO> re=	modelSerice.queryModelById(modelId);
			model.addAttribute(Constant.BEAN, re.getDate());
			return "modelResource/update.html";
		}
		return "modelResource/add.html";
	}
	
	@RequestMapping("/saveModel")
	@ResponseBody
	public String save(Model model,ModelBO modelBO){
		String message="success";
		 Result<Boolean> re=modelSerice.insertModel(modelBO);
		 if(re!=null){
			 if(re.isSuccess()&&re.getDate()){
				 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"modelList");
			 }else{
				 message=re.getCode();
			 }
		 }else{
			 message=ReCode.SYS_REEOR.getMessage();
		 }
		 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"modelList");
	}
	
	@RequestMapping("/updateModel")
	@ResponseBody
	public String updateCousesType(Model model,ModelBO modelBO){
		String message="error";
		 Result<Boolean> re=modelSerice.updateModel(modelBO);
		 if(re!=null){
			 if(re.isSuccess()){
				 message="success";
				 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"modelList");
			 }else{
				 message=re.getCode();
			 }
		 }else{
			 message=ReCode.SYS_REEOR.getMessage();
		 }
		 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"modelList");
	}
}
