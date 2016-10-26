package com.qmdj.service.user;

import com.qmdj.service.bo.UserBO;
import com.qmdj.service.common.Result;

/**
*@Description: 用户信息接口
*@author chenjin
*@date 2016/10/12
*/
public interface UserService {
	
	public Result<UserBO> login(String logName,String password);

}
