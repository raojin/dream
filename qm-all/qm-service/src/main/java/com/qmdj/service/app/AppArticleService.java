package com.qmdj.service.app;

import java.util.List;

import com.qmdj.service.bo.ArticleBO;
import com.qmdj.service.common.Result;

public interface AppArticleService {
	
	
	 /**
	  * 查询文章列表
	  * @param numbers 查询条数 numbers=0时 查询全部有效的文章
	  * */
     public	Result<List<ArticleBO>> queryArticleList(int numbers);

}
