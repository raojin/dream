package com.qmdj.biz.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qmdj.biz.domin.UserDO;

public interface UserDAO {
	
	public int saveUser(UserDO userDO);
	
	public UserDO queryUserByUserId(long userId);
	
	public List<UserDO> queryUserList();
	
	public UserDO login(@Param("loginName")String loginName,@Param("password")String password);

}
