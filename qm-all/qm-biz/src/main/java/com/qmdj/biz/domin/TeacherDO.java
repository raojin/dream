package com.qmdj.biz.domin;

import java.io.Serializable;

/**
*@Description: 教师信息
*@author chenjin
*@date 2016/10/12
*/
public class TeacherDO extends BaseDO implements Serializable{

	private static final long serialVersionUID = 3801273681205489552L;

	/**
     *
     * 基础信息
     * */
	private Long userId;
	
	/**
	 * 
	 * 1:机构教师 ,2 家教教师
	 */
    private Integer identity;
    
    /**
     * 
     * 机构Id  是机构教师时 organizationId不能为空
     * */
    private Long organizationId;
    
    /**
     * 
     * 是否愿意家教
     * */
    private Integer isPublic;
	
    /**
     * 
     * 编号(8位字符串) 平台教师以O开头，家教教师以T开头
     * */
    public String code;
    
	/**
	 * 
	 * 学历
	 * */
	private String education;
	
	/**
	 * 
	 * 真实姓名
	 * */
	private String name;
	
     /**
      * 
      * 毕业学校
      * */
     private String school;
     
     /**
      * 
      * 所选专业
      * */
     private  String professional;
     
     /**
      * 
      * 图片集
      * */     
     private String images;
     
 	/**
 	 * 
 	 * 状态 1:审核通过 2审核中 3:审核不通过  100 ：删除
 	 */
 	private Integer status;

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public Integer getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
