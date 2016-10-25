package com.qmdj.organization.user.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.UserDAO;
import com.qmdj.biz.domin.UserDO;
import com.qmdj.biz.pogo.bo.UserBO;
import com.qmdj.biz.pogo.bo.util.UserBeanUtil;
import com.qmdj.biz.util.ReCode;
import com.qmdj.biz.util.Result;
import com.qmdj.organization.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserDAO userDAO;

	@Override
	public Result<UserBO> login(String loginName, String password) {
		Result<UserBO> re=new Result<UserBO>();
		if(StringUtils.isBlank(loginName)||StringUtils.isBlank(password)){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage("用户名或密码不能为空");
			return re;
		}
		try {
			UserDO user=userDAO.login(loginName, password);
			UserBO userBO=UserBeanUtil.qmdjUserDOToBO(user);
			if(userBO!=null){
				re.setSuccess(true);
				re.setDate(userBO);
			}else{
				re.setCode(ReCode.SYS_REEOR.getCode());
				re.setMessage("用户名或密码错误");
			}
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		return re;
	}

}
