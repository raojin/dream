package com.qmdj.service.bo;

import java.io.Serializable;

/**
 * 类CourseBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月04日
 */
public class CourseBO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * id
     */
    private Long courseId;
    /**
     * gmtCreate
     */
    private java.util.Date gmtCreate;
    /**
     * gmtModified
     */
    private java.util.Date gmtModified;
    /**
     * 家教发布的就是userId  机构发布的就是orgId  
     */
    private Long parentid;
    /**
     * 辅导课程（courseId,以,号隔开）当机构发布套餐的时候ids为多个
     */
    private String courseIds;
    /**
     * 课程类型 com.qmdj.biz.domin.CourseTypeDO
     */
    private Long courseType;
    /**
     * 授课方式 1:老师上门,2:学生上门
     */
    private Integer teachingWay;
    /**
     * 授课时间(以逗号隔开)  com.qmdj.biz.domin.TeachingTimeEnum
     */
    private String teachingTimes;
    /**
     * 授课区域,家教教师时不能为空
     */
    private String teachingAddre;
    /**
     * 价钱
     */
    private Long price;
    /**
     * 时间类型 1:/小时，2:/天，3:/周，4:/月
     */
    private Integer timeType;
    /**
     * 1:正常 ,2:隐藏，（家教教师为 3:等待预约，4:已经预约, 2:隐藏）
     */
    private Integer status;
    /**
     * 排序，值越大越靠前
     */
    private Integer sort;
    /**
     * 标题
     */
    private String title;
    /**
     * 课程介绍，目录
     */
    private String introduce;

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
    public String getCourseIds(){
        return courseIds;
    }

    public void setCourseIds(String courseIds){
        this.courseIds = courseIds;
    }
    public Integer getTeachingWay(){
        return teachingWay;
    }

    public void setTeachingWay(Integer teachingWay){
        this.teachingWay = teachingWay;
    }
    public String getTeachingTimes(){
        return teachingTimes;
    }

    public void setTeachingTimes(String teachingTimes){
        this.teachingTimes = teachingTimes;
    }
    public String getTeachingAddre(){
        return teachingAddre;
    }

    public void setTeachingAddre(String teachingAddre){
        this.teachingAddre = teachingAddre;
    }
   
    public Integer getTimeType(){
        return timeType;
    }

    public void setTimeType(Integer timeType){
        this.timeType = timeType;
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
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getIntroduce(){
        return introduce;
    }

    public void setIntroduce(String introduce){
        this.introduce = introduce;
    }

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public Long getCourseType() {
		return courseType;
	}

	public void setCourseType(Long courseType) {
		this.courseType = courseType;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
}