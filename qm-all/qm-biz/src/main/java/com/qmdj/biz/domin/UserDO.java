package com.qmdj.biz.domin;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
*@Description: 用户基本信息
*@author chenjin
*@date 2016/10/12
*/
public class UserDO extends BaseDO implements Serializable{

	private static final long serialVersionUID = 6345395190141768910L;
	
	 /**
	  * 
	  * 头像
	  * */
    private String image;
	
	/**
	 *
	 * 登陆账号
	 * */
    @NotEmpty
	private String loginName;
	
	/**
	 * 
     *密码
     **/
    @NotEmpty
	private String password;
	
	/**
	 * 
	 * 身份 1:教师,2:家长,3:学生,4:机构教师,5:机构负责人
	 */
    private Integer identity;
    
    /**
     * 
     * 真实姓名
     * */
    private String name;
    
    /**
     * 
     * 性别
     * */
    private Integer sex;
    
	/**
	 * 
	 * 地址  以后考虑做地图的时候换成经纬度
	 * */
	private String addrName;
	
	/**
	 * 
	 * 联系电话
	 * */
	private String linkPhone;
	
	/**
	 * 
	 * 年龄
	 * */
	private Integer age;
	
	/**
	 * 
	 * 邮箱
	 * */
	private String email;
	
	/**
	 * 
	 * 介绍
	 * */
	private String introduce;
	
	/**
	 * 
	 * 状态 1:正常，2删除
	 * */
	private Integer status;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
}
