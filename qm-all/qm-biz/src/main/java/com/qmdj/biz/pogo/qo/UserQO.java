package com.qmdj.biz.pogo.qo;

import com.qmdj.biz.util.Query;

public class UserQO extends Query {
	private static final long serialVersionUID = -9143534158063743128L;
	
	
	private String loginName;


	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	

}
