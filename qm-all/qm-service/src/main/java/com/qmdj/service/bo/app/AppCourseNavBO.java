package com.qmdj.service.bo.app;

import java.util.ArrayList;
import java.util.List;

public class AppCourseNavBO {
	 /**
     * 主键id
     */
    private Long courseNavId;
    /**
     * name
     */
    private String name;
    /**
     * 类型 1:机构导航 ,2 家教导航
     */
    private Integer type;
    /**
     * 排序，值越大越靠前
     */
    private Integer sort;

    /**
     * 
     * 导航下的类型
     * */
    private List<AppCourseTypeBO> courseTypes=new ArrayList<>();

	public Long getCourseNavId() {
		return courseNavId;
	}

	public void setCourseNavId(Long courseNavId) {
		this.courseNavId = courseNavId;
	}

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

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public List<AppCourseTypeBO> getCourseTypes() {
		return courseTypes;
	}

	public void setCourseTypes(List<AppCourseTypeBO> courseTypes) {
		this.courseTypes = courseTypes;
	}
}
