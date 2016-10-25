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
	private static final int DEFAULT_PAGE_SIZE = 10;
	private static final Integer DEFAULT_FIRST_PAGE = 1; // 默认第一页
	private Integer pageSize = DEFAULT_PAGE_SIZE; // 每页大小
	private Integer currentPage = 1; // 当前页
	private int begin = 0; // 起始行

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {

        if (pageSize == null || pageSize <= 0) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
        // 重新设置查询 begin 位置
        this.calculateBegin();

	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {

		if (currentPage == null || currentPage <= 0) {
			this.currentPage = DEFAULT_FIRST_PAGE;
		} else {
			this.currentPage = currentPage;
		}

		// 重新设置查询 begin 位置
        this.calculateBegin();
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

    /**
     * 重新计算 分页起始位置
     */
	public void calculateBegin() {

		this.begin = this.pageSize * (this.currentPage - 1);
	}

}
