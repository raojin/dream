package com.qmdj.domin.course;

import java.io.Serializable;

import com.qmdj.domin.base.BaseDO;

public class CousesTypeDO extends BaseDO  implements Serializable{

	private static final long serialVersionUID = -3993661368339960753L;
	
	/**
	 * 
	 * 类型名称 如:学龄前，小学，中学，高中，钢琴...
	 */
	private String name;
	
	/**
	 * 
	 * 类型 1:自定义 ,2 平台添加
	 * */
	private Integer type;
	
	/**
	 * 
	 * 状态 1:展示,2:不展示
	 * */
	private Integer status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
