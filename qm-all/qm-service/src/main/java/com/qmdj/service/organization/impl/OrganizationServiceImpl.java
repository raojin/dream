package com.qmdj.service.organization.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.OrganizationDAO;
import com.qmdj.biz.domin.OrganizationDO;
import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.bo.util.OrganizationBeanUtil;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.organization.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDAO organizationDAO;

	@Override
	public Result<OrganizationBO> queryByOrganizationId(long orgId) {
		Result<OrganizationBO> re=new Result<OrganizationBO>();
		if(orgId<=0){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		try {
			int id=Integer.parseInt(orgId+"");
			OrganizationDO  organizationDO= organizationDAO.selectByPrimaryKey(id);
			re.setSuccess(true);
			re.setDate(OrganizationBeanUtil.qmdjOrganizationDOToBO(organizationDO));//数据转换
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			//e.printStackTrace();
		}
		return re;
	}

	
	
}
