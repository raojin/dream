package com.qmdj.organization.controller.article;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.pogo.qo.ArticleQO;
import com.qmdj.biz.pogo.qo.CourseQO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.article.ArticleService;
import com.qmdj.service.bo.ArticleBO;
import com.qmdj.service.bo.CourseBO;
import com.qmdj.service.bo.CourseTypeBO;
import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.bo.UserBO;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.Result;
import com.qmdj.service.course.CourseService;
import com.qmdj.service.course.CourseTypeService;
import com.qmdj.service.organization.OrganizationService;



@Controller
public class ArticleContrioller {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/toAddArticle")
	public String toAdd(Model model,HttpServletRequest request,HttpServletResponse response){
		return "article/toAddArticle";
	}
	
	@ResponseBody
	@RequestMapping(value="/addArticle",method=RequestMethod.POST)
	public String addArticle(Model model,HttpServletRequest request,HttpServletResponse response,ArticleBO articleBO){
		Result<Boolean> re = articleService.insertArticle(articleBO);
		return Constant.GSON.toJson(re.isSuccess());
	}
	
	@ResponseBody
	@RequestMapping("/updateArticle")
	public String updateArticle(Model model,HttpServletRequest request,HttpServletResponse response,ArticleBO articleBO){
		Result<Boolean> re = articleService.updateArticle(articleBO);
		return Constant.GSON.toJson(re.isSuccess());
	}
	
	@ResponseBody
	@RequestMapping("/delArticle")
	public String delArticle(Model model,HttpServletRequest request,HttpServletResponse response,ArticleBO articleBO){
		Result<Boolean> re = articleService.delArticle(articleBO);
		return Constant.GSON.toJson(re.isSuccess());
	}
	
	
	@RequestMapping("/articleList")
	public String articleList(Model model,HttpServletRequest request,HttpServletResponse response,ArticleQO articleQO){
		Result<Pagination<ArticleBO>> re = articleService.quertForPage(articleQO);
		model.addAttribute(Constant.BEAN_LIST, re);
		return "article/articleList";
	}
	
	@RequestMapping("/articleDetail")
	public String articleDetail(Model model,HttpServletRequest request,HttpServletResponse response,long articleId){
	 	Result<ArticleBO> re = articleService.queryArticleById(articleId);
		model.addAttribute(Constant.BEAN, re);
		return "article/articleDetail";
	}
}
