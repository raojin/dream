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
    private Integer articleId;
    /**
     * gmtCreate
     */
    private String gmtCreate;
    /**
     * gmtModified
     */
    private String gmtModified;
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
     * 1正常 2：显示 100删除
     * */
    private Integer status;

    public ArticleBO() {
    }

    public Integer getArticleId() {
		return articleId;
	}


	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
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

	public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}
    
}