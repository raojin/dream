package com.qmdj.service.bo;

/**
 * 类QmdjArticleBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月01日
 */
public class ArticleBO {
    /**
     * id
     */
    private Integer qmdjArticleId;
    /**
     * gmtCreate
     */
    private java.util.Date gmtCreate;
    /**
     * gmtModified
     */
    private java.util.Date gmtModified;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 排序值，越大越靠前
     */
    private Integer sort;

    public ArticleBO() {
    }

    public Integer getQmdjArticleId(){
        return qmdjArticleId;
    }

    public void setQmdjArticleId(Integer qmdjArticleId){
        this.qmdjArticleId = qmdjArticleId;
    }
    public java.util.Date getGmtCreate(){
        return gmtCreate;
    }

    public void setGmtCreate(java.util.Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }
    public java.util.Date getGmtModified(){
        return gmtModified;
    }

    public void setGmtModified(java.util.Date gmtModified){
        this.gmtModified = gmtModified;
    }
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }
    public Integer getSort(){
        return sort;
    }

    public void setSort(Integer sort){
        this.sort = sort;
    }
}