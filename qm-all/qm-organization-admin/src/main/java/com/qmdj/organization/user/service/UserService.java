package com.qmdj.organization.user.service;

import com.qmdj.biz.pogo.bo.UserBO;
import com.qmdj.common.base.Result;

/**
*@Description: 用户信息接口
*@author chenjin
*@date 2016/10/12
*/
public interface UserService {
	
	public Result<UserBO> login(String logName,String password);

}
