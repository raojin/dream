package com.qmdj.dao.user;



import com.qmdj.domin.user.UserTest;

public interface UserDAO {
	
	public int insertUser(UserTest user);
	
	public UserTest queryUserById(int id);
	

}
