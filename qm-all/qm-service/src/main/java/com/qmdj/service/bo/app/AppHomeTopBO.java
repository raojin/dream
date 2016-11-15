package com.qmdj.service.bo.app;

import java.util.List;
import java.util.Map;

import com.qmdj.service.bo.ArticleBO;
import com.qmdj.service.bo.ModelBO;

public class AppHomeTopBO {
	
	/**
	 * 
	 * 课程导航
	 * */
	private List<AppCourseNavBO> courseNavs;
	
	/**
	 * 
	 * 文章列表
	 * */
	private List<ArticleBO> articles;
	
	/**
	 * 
	 * 模块坑位列表 key:modelCode  value:List<ModelBO>
	 * */
	private Map<String,List<ModelBO>> models;

	public List<ArticleBO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleBO> articles) {
		this.articles = articles;
	}

	public Map<String, List<ModelBO>> getModels() {
		return models;
	}

	public void setModels(Map<String, List<ModelBO>> models) {
		this.models = models;
	}

	public List<AppCourseNavBO> getCourseNavs() {
		return courseNavs;
	}

	public void setCourseNavs(List<AppCourseNavBO> courseNavs) {
		this.courseNavs = courseNavs;
	}

}
