package com.qmdj.dao.user;



import java.util.List;

import com.qmdj.domin.user.UserDO;

public interface UserDAO {
	
	public int saveUser(UserDO userDO);
	
	public UserDO queryUserByUserId(int userId);
	
	public List<UserDO> queryUserList();

}
