package com.qmdj.service.article.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.ArticleDAO;
import com.qmdj.biz.domin.ArticleDO;
import com.qmdj.biz.pogo.qo.ArticleQO;
import com.qmdj.service.article.ArticleService;
import com.qmdj.service.bo.ArticleBO;
import com.qmdj.service.bo.util.ArticleBeanUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;

@Service
public class ArticleServiceimpl implements ArticleService {
	
	@Autowired
	private ArticleDAO articleDAO;

	@Override
	public Result<Boolean> insertArticle(ArticleBO articleBO) {
		Result<Boolean> re=new Result<Boolean>();
		if(articleBO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
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
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<Boolean> updateArticle(ArticleBO articleBO) {
		Result<Boolean> re=new Result<Boolean>();
		if(articleBO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
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
			e.printStackTrace();
		}
		
		return re;
	}

	@Override
	public Result<ArticleBO> queryArticleById(Long articleId) {
		Result<ArticleBO> re=new Result<ArticleBO>();
		if(articleId==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
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
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<Pagination<ArticleBO>> quertForPage(ArticleQO queryQO) {
		Result<Pagination<ArticleBO>> re=new Result<Pagination<ArticleBO>>();
		if(queryQO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
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
			e.printStackTrace();
		}
		
		return re;
	}

}
