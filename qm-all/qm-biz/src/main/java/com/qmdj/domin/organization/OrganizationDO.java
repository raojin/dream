package com.qmdj.domin.organization;

import java.io.Serializable;
import java.util.Date;

import com.qmdj.domin.base.BaseDO;

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
	private String tile;
	
	/**
	 * 
	 * 联系方式
	 * */
	private String phone;
	
    /**
     * 
     *负责人ID
     */
	private Long userId;
    
    /**
     * 
     * 结构介绍
     * */	
	private String detail;
	
	/**
	 * 
	 * 开始时间
	 * */
	private Date  startTime;
	
	/**
	 * 
	 * 结束时间
	 * */
	private Date  endTime;
	
	 /**
	  * 
	  * 图片集
	  * */
   private String images;
   
   /**
    * 课程类型 com.qmdj.domin.course.CoueseTypeEnum
    * */
   private String courseTypes; 
   
   /**
    * 
    * 办教课程
    * */
   private String  courseIds;

	 /**
	  * 
	  * 状态 1:审核中（不展示,默认） 2:审核通过（展示） 3:审核不通过（不展示）4:删除
	  * */
   private Integer status;
   
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

	public String getTile() {
		return tile;
	}

	public void setTile(String tile) {
		this.tile = tile;
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

	public String getCourseTypes() {
		return courseTypes;
	}

	public void setCourseTypes(String courseTypes) {
		this.courseTypes = courseTypes;
	}

	public String getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(String courseIds) {
		this.courseIds = courseIds;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}
	
}