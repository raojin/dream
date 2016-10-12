package com.qmdj.org.service;

import com.qmdj.domin.user.UserTest;

/**
*@Description: 用户信息接口
*@author chenjin
*@date 2016/10/12
*/
public interface UserService {
	
	public int insertUser(UserTest user);
	
	public UserTest queryByid(int id);

}
