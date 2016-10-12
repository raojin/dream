package com.qmdj.domin.teacher;

import java.io.Serializable;

import com.qmdj.domin.base.BaseDO;


/**
*@Description: 教师发布的任教
*@author chenjin
*@date 2016/10/12
*/
public class Teaching extends BaseDO implements Serializable{

	private static final long serialVersionUID = 4598288964369536060L;

	/**
	 * 
	 * userId
	 * */
	private Long userId;
	
	/**
	 * 
	 * 辅导课程（courseId,以,号隔开）
	 * */
     private String  courseIds;

     /**
      * 课程类型（以,号隔开） com.qmdj.domin.course.CoueseTypeEnum
      * */
     private String courseTypes; 
     
     /**
      * 
      *授课方式 1:老师上门,2:学生上门
      */
     private String teachingWay;
     
     /**
      * 
      *授课时间(存Id 以逗号隔开)  com.qmdj.domin.teacher.TeachingTimeEnum
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(String courseIds) {
		this.courseIds = courseIds;
	}

	public String getCourseTypes() {
		return courseTypes;
	}

	public void setCourseTypes(String courseTypes) {
		this.courseTypes = courseTypes;
	}

	public String getTeachingWay() {
		return teachingWay;
	}

	public void setTeachingWay(String teachingWay) {
		this.teachingWay = teachingWay;
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
     
}
