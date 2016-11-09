package com.qmdj.service.user.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.UserDAO;
import com.qmdj.biz.domin.UserDO;
import com.qmdj.biz.util.core.Constant;
import com.qmdj.service.bo.UserBO;
import com.qmdj.service.bo.util.UserBeanUtil;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.user.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	public UserDAO userDAO;

	@Override
	public Result<UserBO> login(String loginName, String password) {
		log.info("请求入参：loginName：{}，password，{}",loginName,password);
		long startTime = System.currentTimeMillis();
		Result<UserBO> re=new Result<UserBO>();
		if(StringUtils.isBlank(loginName)||StringUtils.isBlank(password)){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage("用户名或密码不能为空");
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		try {
			UserDO user=userDAO.login(loginName, password);
			UserBO userBO=UserBeanUtil.userDOToBO(user);
			if(userBO!=null){
				if(userBO.getIdentity()==4 || userBO.getIdentity() == 5){
					re.setSuccess(true);
					re.setDate(userBO);
				}else{
					re.setCode(ReCode.AUTH_ERROR.getCode());
					re.setMessage(ReCode.AUTH_ERROR.getMessage());
				}
			}else{
				re.setCode(ReCode.SYS_REEOR.getCode());
				re.setMessage("用户名或密码错误");
			}
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<Integer> addUser(UserBO userBO) {
		log.info("请求入参：{}",Constant.GSON.toJson(userBO));
		long startTime = System.currentTimeMillis();
		Result<Integer> re = new Result<Integer>();
		if(userBO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		try {
			UserDO userBOToDO = UserBeanUtil.userBOToDO(userBO);
			userBOToDO.setIdentity(4);//默认为机构教师
			userBOToDO.setStatus(1);//状态为正常
			int insertSelective = userDAO.insertSelective(userBOToDO);
			re.setSuccess(true);
			re.setDate(insertSelective);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<Integer> updateUser(UserBO userBO) {
		log.info("请求入参：{}",Constant.GSON.toJson(userBO));
		long startTime = System.currentTimeMillis();
		Result<Integer> re = new Result<Integer>();
		if(userBO==null || userBO.getUserId()==null ||userBO.getStatus() == 2){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		try {
			UserDO userBOToDO = UserBeanUtil.userBOToDO(userBO);
			int insertSelective = userDAO.update(userBOToDO);
			re.setSuccess(true);
			re.setDate(insertSelective);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}",Constant.GSON.toJson(re));
		log.info("请求完成耗时：{}",System.currentTimeMillis()-startTime);
		return re;
	}

	@Override
	public Result<Integer> delUser(long userBOId) {
		log.info("请求入参：{}",Constant.GSON.toJson(userBOId));
		long startTime = System.currentTimeMillis();
		Result<Integer> re = new Result<Integer>();
		if(userBOId<=0){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			log.info("参数异常，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		UserDO queryUserByUserId = userDAO.queryUserByUserId(userBOId);
		if(queryUserByUserId ==null){
			//对象不存在
			re.setCode(ReCode.FIND_ERROR.getCode());
			re.setMessage(ReCode.FIND_ERROR.getMessage());
			log.info("对象不存在，请求耗时：{}",System.currentTimeMillis()-startTime);
			return re;
		}
		try {
			queryUserByUserId.setStatus(2);//删除
			int insertSelective = userDAO.update(queryUserByUserId);
			re.setSuccess(true);
			re.setDate(insertSelective);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		log.info("返回参数：{}，耗时：{}",Constant.GSON.toJson(re),System.currentTimeMillis()-startTime);
		return re;
	}

}
