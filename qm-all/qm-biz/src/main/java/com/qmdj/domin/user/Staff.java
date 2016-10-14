package com.qmdj.domin.user;

import java.io.Serializable;

import com.qmdj.domin.base.BaseDO;

/**
*@Description: 运营平台管理人信息
*@author chenjin
*@date 2016/10/12
*/
public class Staff extends BaseDO implements Serializable{

	private static final long serialVersionUID = 8254062168956914711L;

	private String loginName;
	
	private String password;
	
	private String name;
	
	private String linkPhone;
	
	private Integer sex;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	
}
