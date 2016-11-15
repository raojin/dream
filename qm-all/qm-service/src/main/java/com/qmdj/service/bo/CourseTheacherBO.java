package com.qmdj.service.bo;

/**
 * 类QmdjCourseTheacherBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月15日
 */
public class CourseTheacherBO {
    /**
     * id
     */
    private Integer courseTheacherId;
    /**
     * 课程Id
     */
    private Integer courseid;
    /**
     * 教师ID
     */
    private Integer teacherid;

    public CourseTheacherBO() {
    }

  
    public Integer getCourseTheacherId() {
		return courseTheacherId;
	}


	public void setCourseTheacherId(Integer courseTheacherId) {
		this.courseTheacherId = courseTheacherId;
	}


	public Integer getCourseid(){
        return courseid;
    }

    public void setCourseid(Integer courseid){
        this.courseid = courseid;
    }
    public Integer getTeacherid(){
        return teacherid;
    }

    public void setTeacherid(Integer teacherid){
        this.teacherid = teacherid;
    }
}