package com.qmdj.service.bo;

/**
 * 类QmdjTeacherBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年10月27日
 */
public class TeacherBO {
    /**
     * 主键Id
     */
    private Long teacherId;
    /**
     * 基础信息
     */
    private Long userId;
    /**
     * 1:机构教师 ,2 家教教师
     */
    private Integer identity;
    /**
     * 机构Id  是机构教师时 organizationId不能为空
     */
    private Long organizationId;
    /**
     * 是否愿意家教
     */
    private Integer ispublic;
    /**
     * 编号(8位字符串) 平台教师以O开头，家教教师以T开头
     */
    private String code;
    /**
     * education
     */
    private String education;
    /**
     * name
     */
    private String name;
    /**
     * school
     */
    private String school;
    /**
     * professional
     */
    private String professional;
    /**
     * 图片集
     */
    private String images;
    /**
     * 状态 1:审核通过  2:审核中 3审核不通过
     */
    private Integer status;

    public TeacherBO() {
    }

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getIdentity(){
        return identity;
    }

    public void setIdentity(Integer identity){
        this.identity = identity;
    }
  
    public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getIspublic(){
        return ispublic;
    }

    public void setIspublic(Integer ispublic){
        this.ispublic = ispublic;
    }
    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }
    public String getEducation(){
        return education;
    }

    public void setEducation(String education){
        this.education = education;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getSchool(){
        return school;
    }

    public void setSchool(String school){
        this.school = school;
    }
    public String getProfessional(){
        return professional;
    }

    public void setProfessional(String professional){
        this.professional = professional;
    }
    public String getImages(){
        return images;
    }

    public void setImages(String images){
        this.images = images;
    }
    public Integer getStatus(){
        return status;
    }

    public void setStatus(Integer status){
        this.status = status;
    }

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
    
    
}