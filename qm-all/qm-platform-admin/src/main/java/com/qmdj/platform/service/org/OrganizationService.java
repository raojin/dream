package com.qmdj.platform.service.org;

import com.github.pagehelper.PageInfo;
import com.qmdj.domin.form.OrgForm;
import com.qmdj.domin.organization.OrganizationDO;

public interface OrganizationService {
	
	public OrganizationDO queryByid(int org);
	
	public boolean save(OrganizationDO org);
	
	public boolean update(OrganizationDO org);
	
	public PageInfo<OrganizationDO> queryList(OrgForm org);

}
