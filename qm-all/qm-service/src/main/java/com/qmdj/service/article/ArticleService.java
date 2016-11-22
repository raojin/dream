package com.qmdj.service.article;

import com.qmdj.biz.pogo.qo.ArticleQO;
import com.qmdj.service.bo.ArticleBO;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.Result;

/**
 * 
 * 文章信息接口
 * */
public interface ArticleService {
	
    /**
     * 
     * 插入
     * */
	public Result<Boolean> insertArticle(ArticleBO article);
	/**
	 * 
	 * 删除
	 * */
	public Result<Boolean> delArticle(ArticleBO article);
	
	/**
	 * 
	 * 更新
	 * */
	public Result<Boolean> updateArticle(ArticleBO article);
	
	/**
	 * 
	 * 根据ID查询
	 * */
	public Result<ArticleBO> queryArticleById(Long articleId);
	
	/**
	 * 
	 * 分页查询
	 * */
	public Result<Pagination<ArticleBO>> quertForPage(ArticleQO queryQO);
}
