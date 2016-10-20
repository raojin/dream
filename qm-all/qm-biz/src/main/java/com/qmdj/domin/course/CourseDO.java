package com.qmdj.domin.course;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

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
	@NotNull
	private Integer couseTypeId;
	
	/**
	 * 
	 * 课程名
	 * */
	@NotNull
	private String couseName;
	
	
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

}
