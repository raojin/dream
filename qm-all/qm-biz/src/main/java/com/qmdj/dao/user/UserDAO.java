package com.qmdj.dao.user;



import java.util.List;

import com.qmdj.domin.user.UserDO;

public interface UserDAO {
	
	public int saveUser(UserDO userDO);
	
	public UserDO queryUserByUserId(long userId);
	
	public List<UserDO> queryUserList();
	
	public UserDO login(String loginName,String password);

}
