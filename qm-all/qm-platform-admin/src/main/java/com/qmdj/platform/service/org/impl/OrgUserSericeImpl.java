package com.qmdj.platform.service.org.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.UserDAO;
import com.qmdj.biz.domin.UserDO;
import com.qmdj.platform.service.org.OrgUserSerice;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;

@Service
public class OrgUserSericeImpl implements OrgUserSerice {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Result<Integer> saveUser(UserDO userDO) {
		Result<Integer> re=new Result<Integer>();
		if(userDO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		if(StringUtils.isBlank(userDO.getLoginName())||StringUtils.isBlank(userDO.getPassword())||StringUtils.isBlank(userDO.getAddrName())||
				StringUtils.isBlank(userDO.getName())||StringUtils.isBlank(userDO.getLinkPhone())||userDO.getIdentity()==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
	    try {
			int id=userDAO.saveUser(userDO);
			re.setDate(id);
			re.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage()+":"+e);
		}
		
		return re;
	}

	@Override
	public Result<Boolean> updateUser(UserDO userDO) {
		return null;
	}

	@Override
	public Result<UserDO> queryUserById(long userId) {
		Result<UserDO> re=new Result<UserDO>();
       if(userId<=0){
    	   re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
       }		
       try {
		   UserDO user=userDAO.queryUserByUserId(userId);
		   re.setSuccess(true);
		   re.setDate(user);
	} catch (Exception e) {
		e.printStackTrace();
		re.setCode(ReCode.SYS_REEOR.getCode());
		re.setMessage(ReCode.SYS_REEOR.getMessage()+":"+e);
	}
	  return re;
	}

	@Override
	public Result<List<UserDO>> queryUserList() {
		Result<List<UserDO>> re=new Result<List<UserDO>>();
		try {
			List<UserDO> list=userDAO.queryUserList();
			re.setSuccess(true);
			re.setDate(list);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage()+":"+e);
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<Integer> daleteUserById(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
