package com.qmdj.service.article.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.ArticleDAO;
import com.qmdj.biz.domin.ArticleDO;
import com.qmdj.biz.pogo.qo.ArticleQO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.article.ArticleService;
import com.qmdj.service.bo.ArticleBO;
import com.qmdj.service.bo.util.ArticleBeanUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;

@Service
public class ArticleServiceimpl implements ArticleService {
	private Logger log = LoggerFactory.getLogger(ArticleServiceimpl.class);
	
	@Autowired
	private ArticleDAO articleDAO;

	@Override
	public Result<Boolean> insertArticle(ArticleBO articleBO) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(articleBO));
		long startTime = System.currentTimeMillis();
		Result<Boolean> re=new Result<Boolean>();
		if(Objects.isNull(articleBO)){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，返回参数：{}请求耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
			return re;
		}
		ArticleDO article=ArticleBeanUtil.articleBOToDO(articleBO);
		try {
			articleDAO.insert(article);
			re.setSuccess(true);
			re.setDate(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<Boolean> updateArticle(ArticleBO articleBO) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(articleBO));
		long startTime = System.currentTimeMillis();
		Result<Boolean> re=new Result<Boolean>();
		if(Objects.isNull(articleBO)){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，返回参数：{}请求耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
			return re;
		}
		ArticleDO article=ArticleBeanUtil.articleBOToDO(articleBO);
		try {
			articleDAO.updateById(article);
			re.setSuccess(true);
			re.setDate(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<ArticleBO> queryArticleById(Long articleId) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(articleId));
		long startTime = System.currentTimeMillis();
		Result<ArticleBO> re=new Result<ArticleBO>();
		if(articleId<=0){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，返回参数：{}请求耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
			return re;
		}
		
		try {
			ArticleDO  articleDO =articleDAO.findById(articleId);
			ArticleBO  articleBO=ArticleBeanUtil.articleDOToBO(articleDO);
			re.setDate(articleBO);
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<Pagination<ArticleBO>> quertForPage(ArticleQO queryQO) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(queryQO));
		long startTime = System.currentTimeMillis();
		Result<Pagination<ArticleBO>> re=new Result<Pagination<ArticleBO>>();
		if(Objects.isNull(queryQO)){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，返回参数：{}请求耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
			return re;
		}
		try {
			int cout=articleDAO.queryForPageCount(queryQO);
			List<ArticleDO> courseNavList= articleDAO.queryForPage(queryQO);
			List<ArticleBO> list=new ArrayList<>();
			for(ArticleDO articleDO:courseNavList){
				list.add(ArticleBeanUtil.articleDOToBO(articleDO));
			}
			Pagination<ArticleBO> page=new Pagination<ArticleBO>();
			page.setData(list);
			page.setTotalCount(cout);
			page.setQuery(queryQO);
			re.setSuccess(true);
			re.setDate(page);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<Boolean> delArticle(ArticleBO articleBO) {
		log.info("请求入参：course：{}",Constant.GSON.toJson(articleBO));
		long startTime = System.currentTimeMillis();
		Result<Boolean> re=new Result<Boolean>();
		if(Objects.isNull(articleBO)||Objects.isNull(articleBO.getArticleId())){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，返回参数：{}请求耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
			return re;
		}
		ArticleDO article=ArticleBeanUtil.articleBOToDO(articleBO);
		article.setStatus(100);//删除
		try {
			articleDAO.updateById(article);
			re.setSuccess(true);
			re.setDate(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

}
