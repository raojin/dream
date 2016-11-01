package com.qmdj.service.bo.app;

import java.util.List;

import com.qmdj.service.bo.CourseBO;

public class AppCourseTypeNavBO {
	
	/**
     * 主键id
     */
    private Long courseTypeId;
    /**
     * 创建时间
     */
    private java.util.Date gmtCreate;
    /**
     * gmtModified
     */
    private java.util.Date gmtModified;
    /**
     * name
     */
    private String name;
    
    /**
     * 
     *课程
     * */
    private List<CourseBO> courses;

	public Long getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(Long courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public java.util.Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(java.util.Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public java.util.Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(java.util.Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CourseBO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseBO> courses) {
		this.courses = courses;
	}
}
