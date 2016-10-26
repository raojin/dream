package com.qmdj.service.common;

import java.io.Serializable;
import java.util.List;

import com.qmdj.biz.util.Query;

/**
 * @Class Pagination
 * @Description 分页查询对象
 * @Author chenjin
 * @Date 2016年10月25日
 */
public class Pagination<T> implements Serializable {

    private static final long serialVersionUID = -3441095898261801205L;


    private static final int DEFAULT_PAGE_SIZE = 10;

    private Integer currentPage = 1;

    /**
     * 存放当前页中的数据
     */
    private List<T> data;

    /**
     * 总记录数
     */
    private Integer totalCount = 0;

    /**
     * 每页显示的数据量
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 总页数

     */
    private Integer totalPage = 1;

    public Pagination() {
        super();
        setQuery(new Query());
    }

    public Pagination(Query query) {
        super();
        setQuery(query);
    }

    public Pagination(List<T> data){
        super();
        this.data = data;
        setQuery(new Query());
    }

    public Pagination(List<T> data, Query query){
        super();
        this.data = data;
        setQuery(query);
    }

    public void setQuery(Query query) {
        if (query != null) {
            this.pageSize = (query.getPageSize() != null) ? query.getPageSize().intValue() : 0;
            this.currentPage = (query.getCurrentPage() != null) ? query.getCurrentPage().intValue() : 1;
        }
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;

        // 自动设置总页数
        if (totalCount <= 0) {
            totalPage = 1;
        } else {
            totalPage = (totalCount + pageSize - 1) / pageSize;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }


}
