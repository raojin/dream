package com.qmdj.organization.user.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.common.base.ReCode;
import com.qmdj.common.base.Result;
import com.qmdj.dao.user.UserDAO;
import com.qmdj.domin.user.UserDO;
import com.qmdj.organization.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserDAO userDAO;

	@Override
	public Result<UserDO> login(String loginName, String password) {
		Result<UserDO> re=new Result<UserDO>();
		if(StringUtils.isBlank(loginName)||StringUtils.isBlank(password)){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		
		try {
			UserDO user=userDAO.login(loginName, password);
			if(user!=null){
				re.setSuccess(true);
				re.setDate(user);
			}else{
				re.setCode(ReCode.SYS_REEOR.getCode());
				re.setMessage(ReCode.SYS_REEOR.getMessage());
			}
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage()+":"+e);
		}
		return re;
	}

}
