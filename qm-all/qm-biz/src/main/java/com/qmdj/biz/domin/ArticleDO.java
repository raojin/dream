package com.qmdj.biz.domin;

/**
 * 类QmdjArticleDO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月01日
 */
public class ArticleDO {
    /**
     * id
     */
    private Integer id;
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
     * 
     * 作者
     * */
    private String author;
    /**
     * 
     * 摘要
     * */
    private String digest;
    /**
     * 排序值，越大越靠前
     */
    private Integer sort;
    /**
     * 
     * 1正常 2：不显示 100删除
     * */
    private Integer status;
    

    public ArticleDO() {
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}