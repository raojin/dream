package com.qmdj.service.bo.app;

import java.util.List;

import com.qmdj.service.bo.ArticleBO;
import com.qmdj.service.bo.ModelBO;
import com.qmdj.service.bo.app.AppCourseTypeNavBO;

public class AppHomeTopBO {
	
	/**
	 * 
	 * 课程导航
	 * */
	private List<AppCourseTypeNavBO> appCourseTypes;
	
	/**
	 * 
	 * 文章列表
	 * */
	private List<ArticleBO> articles;
	
	/**
	 * 
	 * 模块坑位列表
	 * */
	private List<ModelBO> models;

	public List<AppCourseTypeNavBO> getAppCourseTypes() {
		return appCourseTypes;
	}

	public void setAppCourseTypes(List<AppCourseTypeNavBO> appCourseTypes) {
		this.appCourseTypes = appCourseTypes;
	}

	public List<ArticleBO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleBO> articles) {
		this.articles = articles;
	}

	public List<ModelBO> getModels() {
		return models;
	}

	public void setModels(List<ModelBO> models) {
		this.models = models;
	}
}
