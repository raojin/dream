package com.qmdj.service.bo;

import java.io.Serializable;

/**
	*@Description: 运营平台管理人信息
	*@author chenjin
	*@date 2016/10/12
	*/
	public class StaffBO implements Serializable{

		private static final long serialVersionUID = 8254062168956914711L;

		private Long id;
		
		private String loginName;
		
		private String password;
		
		private String name;
		
		private String linkPhone;
		
		private Integer sex;

		private Integer isDel;
		
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
		

		public Integer getIsDel() {
			return isDel;
		}

		public void setIsDel(Integer isDel) {
			this.isDel = isDel;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
}
