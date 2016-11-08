package com.qmdj.service.bo;

/**
 * 类QmdjCourseTypeBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月04日
 */
public class CourseTypeBO {
    /**
     * 主键Id
     */
    private Long courseTypeId;
    /**
     * 创建时间
     */
    private java.util.Date gmtCreate;
    /**
     * 修改时间
     */
    private java.util.Date gmtModified;
    /**
     * 课程导航Id
     */
    private Long courseNavId;
    
    /**
     * 
     * 可惜类型名称
     * */
    private String navName;
    
    /**
     * 课程类型名称
     */
    private String courseName;
    /**
     * 类型 1:自定义 ,2 平台添加
     */
    private Integer type;
    /**
     * 状态 1:正常 ,2 隐藏 自定义默认为2
     */
    private Integer status;
    /**
     * 排序，值越大越靠前，自定义类型默认为0
     */
    private Integer sort;

    public CourseTypeBO() {
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
    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public Integer getType(){
        return type;
    }

    public void setType(Integer type){
        this.type = type;
    }
    public Integer getStatus(){
        return status;
    }

    public void setStatus(Integer status){
        this.status = status;
    }
    public Integer getSort(){
        return sort;
    }

    public void setSort(Integer sort){
        this.sort = sort;
    }

	public Long getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(Long courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public Long getCourseNavId() {
		return courseNavId;
	}

	public void setCourseNavId(Long courseNavId) {
		this.courseNavId = courseNavId;
	}

	public String getNavName() {
		return navName;
	}

	public void setNavName(String navName) {
		this.navName = navName;
	}
}