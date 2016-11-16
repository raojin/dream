package com.qmdj.service.bo;

/**
 * 类QmdjCourseTheacherBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月16日
 */
public class CourseTheacherBO {
    /**
     * id
     */
    private Long courseTheacherId;
    /**
     * 课程Id
     */
    private Long courseId;
    /**
     * 教师ID
     */
    private Long teacherId;
    /**
     * 状态 1正常 100删除
     */
    private Integer status;
    /**
     * gmtCreate
     */
    private java.util.Date gmtCreate;
    /**
     * gmtModified
     */
    private java.util.Date gmtModified;

    public CourseTheacherBO() {
    }
    public Integer getStatus(){
        return status;
    }

    public void setStatus(Integer status){
        this.status = status;
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
	public Long getCourseTheacherId() {
		return courseTheacherId;
	}
	public void setCourseTheacherId(Long courseTheacherId) {
		this.courseTheacherId = courseTheacherId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
    
}