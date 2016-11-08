package com.qmdj.biz.domin;

import java.io.Serializable;


/**
*@Description: 发布课程
*@author chenjin
*@date 2016/10/12
*/
public class CourseDO extends BaseDO implements Serializable{

	private static final long serialVersionUID = 4598288964369536060L;

	/**
	 * 
	 * parent
	 * */
	private Long parentid;
	
	/**
	 * 
	 * 辅导课程（courseId,以,号隔开）
	 * */
     private String  courseIds;

     /**
      * 课程类型 com.qmdj.biz.domin.CourseTypeDO
      * */
     private Long courseType; 
     
     /**
      * 
      *授课方式 1:老师上门,2:学生上门
      */
     private Integer teachingWay;
     
     /**
      * 
      *授课时间(以逗号隔开)  com.qmdj.biz.domin.TeachingTimeEnum
      */
     private String teachingTimes;
     
     /**
      * 
      *授课区域
      */
     private String teachingAddre;
     
     /**
      * 
      * 价钱
      * */
     private long price;
     
     /**
      * 
      * 时间类型 1:/小时，2:/天，3:/周，4:/月
      * */
     private Integer timeType;
     
     /**
      * 
      * 排序，值越大越靠前
      * */
     private Integer sort;
     
     /**
      * 
      * 1:正常（显示），2:隐藏 ，
      * */
     private Integer status;
     
     /**
      * 
      * 课程介绍，目录
      * */
     private String introduce;
     
     /**
      * 
      * 课程标题
      * */
     private String title;

	public Long getCourseType() {
		return courseType;
	}

	public void setCourseType(Long courseType) {
		this.courseType = courseType;
	}

	public String getTeachingAddre() {
		return teachingAddre;
	}

	public void setTeachingAddre(String teachingAddre) {
		this.teachingAddre = teachingAddre;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Integer getTimeType() {
		return timeType;
	}

	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}

	public String getTeachingTimes() {
		return teachingTimes;
	}

	public void setTeachingTimes(String teachingTimes) {
		this.teachingTimes = teachingTimes;
	}

	public String getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(String courseIds) {
		this.courseIds = courseIds;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}



	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public Integer getTeachingWay() {
		return teachingWay;
	}

	public void setTeachingWay(Integer teachingWay) {
		this.teachingWay = teachingWay;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
