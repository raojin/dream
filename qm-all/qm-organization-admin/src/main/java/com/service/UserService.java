package com.service;

import com.qmdj.domin.user.User;

public interface UserService {
	
	public int insertUser(User user);
	
	public User queryByid(int id);

}
