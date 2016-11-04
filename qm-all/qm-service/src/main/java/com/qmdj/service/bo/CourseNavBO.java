package com.qmdj.service.bo;

/**
 * 类QmdjCourseNavBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月04日
 */
public class CourseNavBO {
    /**
     * 主键id
     */
    private Long courseNavId;
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
     * 状态 1:展示,2:不展示
     */
    private Integer status;
    /**
     * 类型 1:机构导航 ,2 家教导航
     */
    private Integer type;
    /**
     * 排序，值越大越靠前
     */
    private Integer sort;

    public CourseNavBO() {
    }

    public Long getCourseNavId() {
		return courseNavId;
	}

	public void setCourseNavId(Long courseNavId) {
		this.courseNavId = courseNavId;
	}

	public java.util.Date getGmtCreate(){
        return gmtCreate;
    }

    public void setGmtCreate(java.util.Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }
    public java.util.Date getGmtModified(){
        return gmtModified;
    }

    public void setGmtModified(java.util.Date gmtModified){
        this.gmtModified = gmtModified;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public Integer getStatus(){
        return status;
    }

    public void setStatus(Integer status){
        this.status = status;
    }
    public Integer getType(){
        return type;
    }

    public void setType(Integer type){
        this.type = type;
    }
    public Integer getSort(){
        return sort;
    }

    public void setSort(Integer sort){
        this.sort = sort;
    }
}