package com.qmdj.service.app.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.ArticleDAO;
import com.qmdj.biz.domin.ArticleDO;
import com.qmdj.service.app.AppArticleService;
import com.qmdj.service.bo.ArticleBO;
import com.qmdj.service.bo.util.ArticleBeanUtil;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;

@Service
public class AppArticleServiceImpl implements AppArticleService {
	
	@Autowired
	private ArticleDAO articleDAO;

	
	@Override
	public Result<List<ArticleBO>> queryArticleList(int numbers) {
		Result<List<ArticleBO>> re=new Result<List<ArticleBO>>();
		ArticleDO articleDO=new ArticleDO();
		articleDO.setStatus(1);
		try {
			List<ArticleDO> list=articleDAO.findByCondition(articleDO);
			if(list!=null){
				if(numbers<list.size()){
					list.subList(0, numbers);
				}
			}
			
			List<ArticleBO> listBO=new ArrayList<ArticleBO>();
			for(ArticleDO article:list){
				listBO.add(ArticleBeanUtil.articleDOToBO(article));
			}
			re.setDate(listBO);
			re.setSuccess(true);
			return re;
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}


}
