package com.qmdj.biz.pogo.qo;

import com.qmdj.biz.util.Query;

public class CourseTypeQO  extends Query {

	private static final long serialVersionUID = 1L;
	
	private String courseTypeName;

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

}
