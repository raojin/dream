package com.qmdj.biz.domin;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

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
	private Integer courseTypeId;
	
	/**
	 * 
	 * 课程名
	 * */
	@NotNull
	private String courseName;
	
	
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



	public Integer getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(Integer courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
