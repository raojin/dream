package com.qmdj.platform.service.staff;

import com.qmdj.common.base.Result;
import com.qmdj.domin.user.Staff;

public interface StaffService {
	
	/**
	 * 
	 * 登陆
	 * */
	public Result<Staff> login(String loginName,String password);

}
