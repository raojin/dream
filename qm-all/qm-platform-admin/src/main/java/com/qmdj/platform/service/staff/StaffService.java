package com.qmdj.platform.service.staff;

import com.qmdj.common.base.Result;
import com.qmdj.domin.user.StaffDO;

public interface StaffService {
	
	/**
	 * 
	 * 登陆
	 * */
	public Result<StaffDO> login(String loginName,String password);

}
