package com.qmdj.biz.util;

import java.io.Serializable;


/**
 * @Class Query
 * @Description 分页查询器
 * @Author chenjin
 * @Date 2016年10月25日
 */
public class Query implements Serializable {
	
	private static final long serialVersionUID = -1966676061502218563L;

	/**
	 * 默认每页大小
	 */
	private static final int DEFAULT_PAGE_SIZE = 20;
	
	private static final Integer DEFAULT_FIRST_PAGE = 1; // 默认第一页
	
	private Integer numPerPage = DEFAULT_PAGE_SIZE; // 每页大小
	
	private Integer pageNum=1; //当前页
	
	private Integer begin = 0; // 起始行
	

	private Integer currentPage=1; 
	
	 public int getStartIndex() {
	        int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
	        return pageNum * this.getNumPerPage();
	    }

	public Integer getCurrentPage() {
		 int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		 if(pageNum==0){
			 return DEFAULT_FIRST_PAGE;
		 }
		return pageNum;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getNumPerPage() {
		return numPerPage;
	}


	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}


	public Integer getPageNum() {
		return pageNum;
	}


	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getBegin() {
		return getStartIndex();
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	
}