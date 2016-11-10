package com.qmdj.platform.controller.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qmdj.biz.pogo.qo.ArticleQO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.article.ArticleService;
import com.qmdj.service.bo.ArticleBO;
import com.qmdj.service.common.DwzJsonResultUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;

@RequestMapping("/article")
@Controller
public class ArticleController {

	
	@Autowired
	private ArticleService articleService;
	@RequestMapping("/list")
	public String list(Model model,ArticleQO querQO){
		Result<Pagination<ArticleBO>> re= articleService.quertForPage(querQO);
		model.addAttribute(Constant.BEAN_LIST, re.getDate());
		return  "article/articleList.html";
	}
	
	
	@RequestMapping("/toAdd")
	public String tologin(Model model,@RequestParam(value = "articleId",required=false) Long articleId){
		if(articleId!=null){
			Result<ArticleBO> re=articleService.queryArticleById(articleId);
			model.addAttribute(Constant.BEAN, re.getDate());
			return "article/articleUpdaye.html";
		}
		return "article/articleAdd.html";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Model model,ArticleBO ArticleBO){
		String message="success";
		 Result<Boolean> re=articleService.insertArticle(ArticleBO);
		 if(re!=null){
			 if(re.isSuccess()&&re.getDate()){
				 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"articleList");
			 }else{
				 message=re.getCode()+":"+re.getMessage();
			 }
		 }else{
			 message=ReCode.SYS_REEOR.getMessage();
		 }
		 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"articleList");
	}
	
	@RequestMapping("/updateArticle")
	@ResponseBody
	public String updateCousesType(Model model,ArticleBO ArticleBO){
		String message="error";
		 Result<Boolean> re=articleService.updateArticle(ArticleBO);
		 if(re!=null){
			 if(re.isSuccess()){
				 message="success";
				 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_200, message,"articleList");
			 }else{
				 message=re.getCode();
			 }
		 }else{
			 message=ReCode.SYS_REEOR.getMessage();
		 }
		 return DwzJsonResultUtil.createJsonString(DwzJsonResultUtil.STATUS_CODE_300, message,"articleList");
	}
	
}
