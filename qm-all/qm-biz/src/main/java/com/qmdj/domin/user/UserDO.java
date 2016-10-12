package com.qmdj.domin.user;

import java.io.Serializable;

import com.qmdj.domin.base.BaseDO;

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
	private String loginName;
	
	/**
	 * 
     *密码
     **/
	private String password;
	
	/**
	 * 
	 * 身份 1:教师,2:家长,3:学生,4:机构教师
	 */
    private Integer identity;
    
    
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
	 * 地址
	 * */
	private String addre;
	
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

	public String getAddre() {
		return addre;
	}

	public void setAddre(String addre) {
		this.addre = addre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
	
	
}
