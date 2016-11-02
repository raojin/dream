package com.qmdj.biz.domin;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
*@Description: 机构信息
*@author chenjin
*@date 2016/10/12
*/
public class OrganizationDO extends BaseDO  implements Serializable{

	private static final long serialVersionUID = -2789408297518190989L;
	
	
	 /**
	  * 
	  * 首图
	  * */
   private String image;
   
	
	/**
	 * 
	 * 机构名称
	 * */
	@NotNull
	private String name;
	
	/**
	 * 
	 *机构详细地址
	 * */
	private String addrName;
	
	
	/**
	 * 
	 * 标题
	 * */
	private String title;
	
	/**
	 * 
	 * 联系方式
	 * */
	@NotNull
	private String phone;
	
    /**
     * 
     *负责人ID
     */
	@NotNull
	private Long userId;
	
    /**
     * 
     *负责人名字
     */
	@NotNull
	private String userName;
    
    /**
     * 
     * 结构介绍
     * */
	private String detail;
	
	/**
	 * 
	 * 开始时间
	 * */
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date  startTime;
	
	/**
	 * 
	 * 结束时间
	 * */
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date  endTime;
	
	 /**
	  * 
	  * 图片集
	  * */
   private String images;
   
	 /**
	  * 
	  * 状态 1:审核中（不展示,默认） 2:审核通过（展示） 3:审核不通过（不展示）
	  * */
   private Integer status;
   
	   /**
	    * 
	    * 是否删除  1未删除  2删除
	    * */
   private Integer  isDel;
   
   
   /**
    * 标签  0:普通 默认， 1：精品 
    * */
   private Integer tags;
   
   
   /**
    * 
    * 排序值
    * */
   private Integer sort;

   
	public Integer getIsDel() {
	return isDel;
}

public void setIsDel(Integer isDel) {
	this.isDel = isDel;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getDetail() {
		return detail;
	}

	public void setDetails(String detail) {
		this.detail = detail;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getTags() {
		return tags;
	}

	public void setTags(Integer tags) {
		this.tags = tags;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
