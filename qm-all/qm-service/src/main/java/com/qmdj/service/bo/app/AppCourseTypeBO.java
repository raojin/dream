package com.qmdj.service.bo.app;

public class AppCourseTypeBO {
	 /**
     * 主键Id
     */
    private Long courseTypeId;
    /**
     * 课程类型名称
     */
    private String courseTypeName;
    
    /**
     * 排序，值越大越靠前
     */
    private Integer sort;

	public Long getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(Long courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
