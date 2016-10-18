package com.qmdj.organization.user.service;

import com.qmdj.common.base.Result;
import com.qmdj.domin.user.UserDO;

/**
*@Description: 用户信息接口
*@author chenjin
*@date 2016/10/12
*/
public interface UserService {
	
	public Result<UserDO> login(String logName,String password);

}
