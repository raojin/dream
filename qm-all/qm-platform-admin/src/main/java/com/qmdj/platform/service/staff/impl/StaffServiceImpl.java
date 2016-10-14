package com.qmdj.platform.service.staff.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.common.base.ReCode;
import com.qmdj.common.base.Result;
import com.qmdj.dao.user.StaffDAO;
import com.qmdj.domin.user.Staff;
import com.qmdj.platform.service.staff.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffDAO staffDAO;

	@Override
	public Result<Staff> login(String loginName,String password) {
		Result<Staff> re=new Result<Staff>();
		if(StringUtils.isBlank(loginName)||StringUtils.isBlank(password)){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getCode());
			return re;
		}
		try {
			Staff satff=staffDAO.login(loginName, password);
			if(satff!=null){
				re.setSuccess(true);
				re.setDate(satff);
			}else{
				re.setCode(ReCode.CUSTOM_ERROR.getCode());
				re.setMessage("用户名密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		return re;
	}

}
