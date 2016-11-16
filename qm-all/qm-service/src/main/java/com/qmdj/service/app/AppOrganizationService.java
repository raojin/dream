package com.qmdj.service.app;

import java.util.List;
import java.util.Map;

import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.bo.app.AppOrgDetailBO;
import com.qmdj.service.common.Result;

public interface AppOrganizationService {
	
	
	/**
	 * 查询有效的机构列表
	 * @param   tags 0:全部 1:精品 2:普通
	 * @return Result<List<OrganizationBO>>
	 * @author chenjin
	 * @data   2016/11/1 
	 * */
	public Result<Map<Integer,List<OrganizationBO>>>  queryOrganization(Integer tags);

	
	/**
	 * 查询机构详情
	 * @param   orgId 机构Id  不能为空
	 * @return Result<AppOrgDetails>
	 * @author chenjin
	 * @data   2016/11/15 
	 * */
	public Result<AppOrgDetailBO> queryOrganizationDetails(Long orgId);
}
