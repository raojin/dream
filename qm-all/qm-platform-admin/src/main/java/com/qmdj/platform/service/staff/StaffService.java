package com.qmdj.platform.service.staff;

import com.qmdj.biz.domin.StaffDO;
import com.qmdj.biz.util.Result;

public interface StaffService {
	
	/**
	 * 
	 * 登陆
	 * */
	public Result<StaffDO> login(String loginName,String password);

}
