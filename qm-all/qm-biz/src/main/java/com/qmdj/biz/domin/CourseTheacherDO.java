package com.qmdj.biz.domin;

/**
 * 类QmdjCourseTheacherDO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月15日
 */
public class CourseTheacherDO {
    /**
     * id
     */
    private Integer id;
    /**
     * 课程Id
     */
    private Integer courseid;
    /**
     * 教师ID
     */
    private Integer teacherid;

    public CourseTheacherDO() {
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
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