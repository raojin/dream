package com.qmdj.domin.course;

import java.io.Serializable;

import com.qmdj.domin.base.BaseDO;

/**
*@Description: 课程
*@author chenjin
*@date 2016/10/12
*/
public class CourseDO extends BaseDO  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * 课程类型 com.qmdj.domin.course.CousesTypeDO
	 * */
	private Integer couseTypeId;
	
	/**
	 * 
	 * 课程名
	 * */
	private String couseName;
	
	
	/**
	 * 
	 * 类型 1:自定义 ,2 平台添加
	 * */
	private Integer type;

	
	public Integer getCouseTypeId() {
		return couseTypeId;
	}

	public void setCouseTypeId(Integer couseTypeId) {
		this.couseTypeId = couseTypeId;
	}

	public String getCouseName() {
		return couseName;
	}

	public void setCouseName(String couseName) {
		this.couseName = couseName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	

}
