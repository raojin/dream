package com.qmdj.platform.service.org;

import com.github.pagehelper.PageInfo;
import com.qmdj.common.base.Result;
import com.qmdj.domin.form.OrgForm;
import com.qmdj.domin.organization.OrganizationDO;

public interface OrganizationService {
	
	public Result<OrganizationDO> queryByid(int org);
	
	public Result<Integer> save(OrganizationDO org);
	
	public Result<Integer> update(OrganizationDO org);
	
	public Result<PageInfo<OrganizationDO>> queryList(OrgForm org);

}
