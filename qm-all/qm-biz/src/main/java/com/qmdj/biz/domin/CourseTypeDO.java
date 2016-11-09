package com.qmdj.biz.domin;

import java.io.Serializable;

/**
*@Description: 课程
*@author chenjin
*@date 2016/10/12
*/
public class CourseTypeDO extends BaseDO  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * 课程导航 
	 * */
	private Long courseNavId;
	
	/**
	 * 
	 * 导航名称
	 * */
	private String courseNavName;
	
	/**
	 * 
	 * 课程类型名
	 * */
	private String courseTypeName;
	
	
	/**
	 * 
	 * 类型 1:自定义 ,2 平台添加
	 * */
	private Integer type;
	
	/**
	 * 
	 * 状态 1:正常 ,2 隐藏
	 * */
	private Integer status;
	
	
	/**
	 * 
	 * 值越大越靠前
	 * */
	private Integer sort;


	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Long getCourseNavId() {
		return courseNavId;
	}

	public void setCourseNavId(Long courseNavId) {
		this.courseNavId = courseNavId;
	}

	public String getCourseNavName() {
		return courseNavName;
	}

	public void setCourseNavName(String courseNavName) {
		this.courseNavName = courseNavName;
	}

}
