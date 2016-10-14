package com.qmdj.platform.service.org;

import java.util.List;

import com.qmdj.common.base.Result;
import com.qmdj.domin.organization.OrganizationDO;

/**
*@Description: 机构信息接口
*@author chenjin
*@date 2016/10/14
*/
public interface OrgService {

	public Result<Integer> saveOrganization(OrganizationDO org);
	
	public Result<List<OrganizationDO>> queryOrganizationList();
}
