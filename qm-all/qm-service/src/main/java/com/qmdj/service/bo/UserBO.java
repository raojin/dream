package com.qmdj.service.bo;

/**
 * 类QmdjUserBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年10月25日
 */
public class UserBO {
    /**
     * 主键id
     */
    private Long userId;
    /**
     * 创建时间
     */
    private java.util.Date gmtCreate;
    /**
     * 修改时间
     */
    private java.util.Date gmtModified;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 身份 1:教师,2:家长,3:学生,4:机构教师,5:机构负责人
     */
    private Integer identity;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别 1男 2女
     */
    private Integer sex;
    /**
     * 联系方式
     */
    private String linkPhone;
    /**
     * 介绍
     */
    private String introduce;
    /**
     * 头像
     */
    private String image;
    /**
     * 状态 1:正常，2删除
     */
    private Integer status;
    /**
     * 邮箱
     */
    private String email;
    /**
     * age
     */
    private Integer age;

    public UserBO() {
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
    public String getLoginName(){
        return loginName;
    }

    public void setLoginName(String loginName){
        this.loginName = loginName;
    }
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public Integer getIdentity(){
        return identity;
    }

    public void setIdentity(Integer identity){
        this.identity = identity;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public Integer getSex(){
        return sex;
    }

    public void setSex(Integer sex){
        this.sex = sex;
    }
    public String getLinkPhone(){
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone){
        this.linkPhone = linkPhone;
    }
    public String getIntroduce(){
        return introduce;
    }

    public void setIntroduce(String introduce){
        this.introduce = introduce;
    }
    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }
    public Integer getStatus(){
        return status;
    }

    public void setStatus(Integer status){
        this.status = status;
    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
}