package com.qmdj.biz.pogo.qo;

import java.io.Serializable;

import com.qmdj.biz.util.core.AbstractPageForm;

public class CourseQO  extends AbstractPageForm<CourseQO> implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String  name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
