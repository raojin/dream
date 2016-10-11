package com.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.dao.user.UserDAO;
import com.qmdj.domin.user.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public int insertUser(User user) {
		
	   return userDAO.insertUser(user);
	}
	
	public User queryByid(int id){
		return  userDAO.queryUserById(id);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


}
