package com.qmdj.service.user.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.StaffDAO;
import com.qmdj.biz.domin.StaffDO;
import com.qmdj.service.bo.StaffBO;
import com.qmdj.service.bo.util.StaffBeanUtil;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.user.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffDAO staffDAO;

	@Override
	public Result<StaffBO> login(String loginName,String password) {
		Result<StaffBO> re=new Result<StaffBO>();
		if(StringUtils.isBlank(loginName)||StringUtils.isBlank(password)){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getCode());
			return re;
		}
		try {
			StaffDO satff=staffDAO.login(loginName, password);
			if(satff!=null){
				re.setSuccess(true);
				re.setDate(StaffBeanUtil.staffDOtoBO(satff));
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
