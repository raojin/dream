package com.qmdj.biz.pogo.qo;

import com.qmdj.biz.util.Query;

public class ArticleQO extends Query{
	private static final long serialVersionUID = 1L;
	/**
     * 标题
     */
    private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
