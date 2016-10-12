package com.service;

import com.qmdj.domin.user.UserTest;

public interface UserService {
	
	public int insertUser(UserTest user);
	
	public UserTest queryByid(int id);

}
