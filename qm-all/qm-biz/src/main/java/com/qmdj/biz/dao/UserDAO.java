package com.qmdj.biz.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qmdj.biz.domin.UserDO;
import com.qmdj.biz.pogo.qo.UserQO;

public interface UserDAO {
	
	public int saveUser(UserDO userDO);
	
	public UserDO queryUserByUserId(long userId);
	
	public List<UserDO> queryUserList();
	
	public UserDO login(@Param("loginName")String loginName,@Param("password")String password);
	
	public int insert(UserDO userDO);
	
	public int update(UserDO userDO);
	
	public int findByCondition(UserDO userDO);
	
	public List<UserDO> findOrgUserForPage(UserQO queryQO);
	
	public int findOrgUserForPageCount(UserQO queryQO);
	
	int insertSelective(UserDO userDO);

}
