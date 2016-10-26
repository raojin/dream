package com.qmdj.platform.service.org;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.domin.OrgForm;
import com.qmdj.biz.domin.OrganizationDO;
import com.qmdj.service.common.Result;

public interface OrganizationTempService {
	
	public OrganizationDO queryByid(int org);
	
	public Result<Integer> save(OrganizationDO org);
	
	public Result<Integer> update(OrganizationDO org);
	
	public PageInfo<OrganizationDO> queryList(OrgForm org);
	
	public Result<Integer> del(OrganizationDO org);

}