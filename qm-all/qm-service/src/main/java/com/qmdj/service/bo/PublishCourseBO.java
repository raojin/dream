package com.qmdj.service.bo;

/**
 * 类QmdjPublishCourseBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年10月27日
 */
public class PublishCourseBO {
    /**
     * id
     */
    private Long publishCourseId;
    
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
     * price
     */
    private Long price;
    /**
     * 时间类型 1:/小时，2:/天，3:/周，4:/月
     */
    private Integer timeType;
    /**
     * 1:正常 ,2:隐藏，（家教教师为 3:等待预约，4:已经预约,2:隐藏）
     */
    private Integer status;
    /**
     * 排序，值越大越靠前
     */
    private Integer sort;

    public PublishCourseBO() {
    }
   
    public Long getPublishCourseId() {
		return publishCourseId;
	}

	public void setPublishCourseId(Long publishCourseId) {
		this.publishCourseId = publishCourseId;
	}

	
    public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public String getCourseIds(){
        return courseIds;
    }

    public void setCourseIds(String courseIds){
        this.courseIds = courseIds;
    }
    
    public Long getCourseType() {
		return courseType;
	}

	public void setCourseType(Long courseType) {
		this.courseType = courseType;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
    
}