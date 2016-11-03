package com.qmdj.service.user;

import com.qmdj.service.bo.StaffBO;
import com.qmdj.service.common.Result;

public interface StaffService {
	
	/**
	 * 
	 * 登陆
	 * */
	public Result<StaffBO> login(String loginName,String password);

}
