package com.qmdj.platform.service.impl.org;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qmdj.common.base.Result;
import com.qmdj.domin.user.UserDO;
import com.qmdj.platform.service.org.OrgUserSerice;

@Service
public class OrgUserSericeImpl implements OrgUserSerice {

	@Override
	public Result<Integer> saveUser(UserDO userDO) {
		Result<Integer> re=new Result<Integer>();
		
		return re;
	}

	@Override
	public Result<Boolean> updateUser(UserDO userDO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<UserDO> queryUserById(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<List<UserDO>> queryUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> daleteUserById(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
