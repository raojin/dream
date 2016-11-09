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
	 * 添加user
	 * @param  userBO
	 * @return Result<UserBO>
	 * @author xw
	 * */
	public Result<Integer> addUser(UserBO userBO);
	
	/**
	 * 更新user
	 * @param  userBO
	 * @return Result<UserBO>
	 * @author xw
	 * */
	public Result<Integer> updateUser(UserBO userBO);
	
	/**
	 * 删除user
	 * @param  userBO
	 * @return Result<UserBO>
	 * @author xw
	 * */
	public Result<Integer> delUser(long userBOId);
	
	

}
