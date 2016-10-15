package com.qmdj.dao.user;


import org.apache.ibatis.annotations.Param;

import com.qmdj.domin.user.StaffDO;

public interface StaffDAO {
	
	public StaffDO login(@Param("loginName") String loginName,@Param("password") String password);

	public int deleteStaffById(@Param("staffId") long staffId);
}
