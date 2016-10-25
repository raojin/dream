package com.qmdj.biz.pogo.bo;

/**
 * 类QmdjCourseTypeBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年10月25日
 */
public class CourseTypeBO {
    /**
     * 主键id
     */
    private Long courseTypeId;
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
     * 类型 1:自定义 ,2 平台添加
     */
    private Integer type;

    public CourseTypeBO() {
    }
    
    

	public Long getCourseTypeId() {
		return courseTypeId;
	}



	public void setCourseTypeId(Long courseTypeId) {
		this.courseTypeId = courseTypeId;
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
    
}