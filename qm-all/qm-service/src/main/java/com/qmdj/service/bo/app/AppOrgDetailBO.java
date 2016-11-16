package com.qmdj.service.bo.app;

public class AppOrgDetailBO {
	/**
     * 主键ID
     */
    private Long organizationId;
    /**
     * 首图
     */
    private String image;
    /**
     * 机构名称
     */
    private String name;
    /**
     * 机构详细地址
     */
    private String addrName;
    /**
     * 标题
     */
    private String title;
    /**
     * 报名电话
     */
    private String phone;
	
    /**
     *有效课程数量
     * */
    private Integer countCourse;
    
    /**
     * 评分数
     * */
    private Double  countScore;
	
    /**
     * 学生人数
     * */
    private Integer countStudent;
    
    /**
     * 机构详情
     */
    private String detail;

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCountCourse() {
		return countCourse;
	}

	public void setCountCourse(Integer countCourse) {
		this.countCourse = countCourse;
	}

	public Double getCountScore() {
		return countScore;
	}

	public void setCountScore(Double countScore) {
		this.countScore = countScore;
	}

	public Integer getCountStudent() {
		return countStudent;
	}

	public void setCountStudent(Integer countStudent) {
		this.countStudent = countStudent;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
    
}
