package com.qmdj.biz.pogo.bo;

import java.util.Date;

/**
 * 类QmdjOrganizationBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年10月25日
 */
public class OrganizationBO {
    /**
     * 主键ID
     */
    private Long organizationId;
    /**
     * 首图
     */
    private String image;
    /**
     * 机构名称
     */
    private String name;
    /**
     * 机构详细地址
     */
    private String addrName;
    /**
     * 标题
     */
    private String title;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 负责人
     */
    private Long userId;
    /**
     * 机构介绍
     */
    private String detail;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 介绍时间
     */
    private Date endTime;
    /**
     * 图片集
     */
    private String images;
    /**
     * 状态 1:审核中（不展示,默认） 2:审核通过（展示） 3:审核不通过（不展示）4:删除
     */
    private Integer status;
    /**
     * 创建时间
     */
    private java.util.Date gmtCreate;
    /**
     * 最后操作时间
     */
    private java.util.Date gmtModified;
    /**
     * 是否删除 1未删除 2已删除
     */
    private Integer isDel;
    /**
     * 负责人名字
     */
    private String userName;

    public OrganizationBO() {
    }

    public Long getOrganizationId() {
		return organizationId;
	}


	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}


	public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getAddrName(){
        return addrName;
    }

    public void setAddrName(String addrName){
        this.addrName = addrName;
    }
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getDetail(){
        return detail;
    }

    public void setDetail(String detail){
        this.detail = detail;
    }
    
    public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getImages(){
        return images;
    }

    public void setImages(String images){
        this.images = images;
    }
   
    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
    public Integer getIsDel(){
        return isDel;
    }

    public void setIsDel(Integer isDel){
        this.isDel = isDel;
    }
    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}