package com.qmdj.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.UserDAO;
import com.qmdj.biz.domin.UserDO;
import com.qmdj.biz.pogo.qo.UserQO;
import com.qmdj.service.bo.UserBO;
import com.qmdj.service.bo.util.UserBeanUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.user.OrgUserSerice;

@Service
public class OrgUserSericeImpl implements OrgUserSerice {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Result<Integer> saveUser(UserBO userBO) {
		Result<Integer> re=new Result<Integer>();
		if(userBO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		if(StringUtils.isBlank(userBO.getLoginName())||StringUtils.isBlank(userBO.getPassword())||StringUtils.isBlank(userBO.getAddrName())||
				StringUtils.isBlank(userBO.getName())||StringUtils.isBlank(userBO.getLinkPhone())||userBO.getIdentity()==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
	    try {
			int id=userDAO.insert(UserBeanUtil.userBOToDO(userBO));
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
	public Result<Boolean> updateUser(UserBO userBO) {
		
		Result<Boolean> re=new Result<Boolean>();
		if(userBO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		if(userBO.getUserId()==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		UserDO userDO=UserBeanUtil.userBOToDO(userBO);
		try {
			    userDAO.update(userDO);
				re.setDate(true);
				re.setSuccess(true);
				return re;
		} catch (Exception e) {
			return re;
		}
	}

	@Override
	public Result<UserBO> queryUserById(long userId) {
		Result<UserBO> re=new Result<UserBO>();
       if(userId<=0){
    	   re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
       }		
       try {
		   UserDO user=userDAO.queryUserByUserId(userId);
		   re.setSuccess(true);
		   re.setDate(UserBeanUtil.userDOToBO(user));
	} catch (Exception e) {
		e.printStackTrace();
		re.setCode(ReCode.SYS_REEOR.getCode());
		re.setMessage(ReCode.SYS_REEOR.getMessage()+":"+e);
	}
	  return re;
	}

	@Override
	public Result<List<UserBO>> queryUserList() {
		Result<List<UserBO>> re=new Result<List<UserBO>>();
		try {
			List<UserDO> list=userDAO.queryUserList();
			List<UserBO> listBO=new ArrayList<>();
			for(UserDO userDO:list){
				listBO.add(UserBeanUtil.userDOToBO(userDO));
			}
			re.setSuccess(true);
			re.setDate(listBO);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage()+":"+e);
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<Pagination<UserBO>> queryOrgUserForPage(UserQO queryQO) {
		Result<Pagination<UserBO>> re=new Result<Pagination<UserBO>>();
		if(queryQO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		
		try {
			List<UserDO> users=userDAO.findOrgUserForPage(queryQO);
			List<UserBO> list=new ArrayList<>();
			if(users!=null){
				for(UserDO userDO:users){
					list.add(UserBeanUtil.userDOToBO(userDO));
				}
			}
			int count=userDAO.findOrgUserForPageCount(queryQO);
			
			Pagination<UserBO> page=new Pagination<UserBO>();
			page.setData(list);
			page.setTotalCount(count);
			
			re.setDate(page);
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}

}
