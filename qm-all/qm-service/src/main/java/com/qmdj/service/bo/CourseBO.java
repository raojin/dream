package com.qmdj.service.bo;

/**
 * 类QmdjCourseBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年10月27日
 */
public class CourseBO {
    /**
     * 主键Id
     */
    private Long qmdjCourseId;
    /**
     * 创建时间
     */
    private java.util.Date gmtCreate;
    /**
     * 修改时间
     */
    private java.util.Date gmtModified;
    /**
     * 课程类型
     */
    private Integer courseTypeId;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 类型 1:自定义 ,2 平台添加
     */
    private Integer type;
    /**
     * 状态 1:正常 ,2 隐藏
     */
    private Integer status;

    public CourseBO() {
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
   
    public Long getQmdjCourseId() {
		return qmdjCourseId;
	}


	public void setQmdjCourseId(Long qmdjCourseId) {
		this.qmdjCourseId = qmdjCourseId;
	}


	public Integer getCourseTypeId() {
		return courseTypeId;
	}


	public void setCourseTypeId(Integer courseTypeId) {
		this.courseTypeId = courseTypeId;
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
}