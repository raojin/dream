package com.qmdj.dao.user;


import org.apache.ibatis.annotations.Param;

import com.qmdj.domin.user.Staff;

public interface StaffDAO {
	
	public Staff login(@Param("loginName") String loginName,@Param("password") String password);

	public int deleteStaffById(@Param("staffId") long staffId);
}
