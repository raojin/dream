package com.qmdj.dao.user;



import com.qmdj.domin.user.User;

public interface UserDAO {
	
	public int insertUser(User user);
	
	public User queryUserById(int id);
	

}
