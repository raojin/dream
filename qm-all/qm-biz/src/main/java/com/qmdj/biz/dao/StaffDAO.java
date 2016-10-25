package com.qmdj.biz.dao;


import org.apache.ibatis.annotations.Param;

import com.qmdj.biz.domin.StaffDO;

public interface StaffDAO {
	
	public StaffDO login(@Param("loginName") String loginName,@Param("password") String password);

	public int deleteStaffById(@Param("staffId") long staffId);
}
