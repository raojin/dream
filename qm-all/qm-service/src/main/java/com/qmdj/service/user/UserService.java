package com.qmdj.service.user;

import com.qmdj.service.bo.UserBO;
import com.qmdj.service.common.Result;

/**
*@Description: 用户信息接口
*@author chenjin
*@date 2016/10/12
*/
public interface UserService {
	/**
	 * @param  logName password
	 * @return Result<UserBO>
	 * @author chenjin
	 * */
	public Result<UserBO> login(String logName,String password);
	
	/**
	 * @param  logName password
	 * @return Result<UserBO>
	 * @author xw
	 * */
	public Result<Integer> addUser(UserBO userBO);
	
	

}
