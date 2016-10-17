package com.qmdj.org.service;

import com.qmdj.domin.organization.OrganizationDO;

public interface OrganizationService {
	
	public OrganizationDO queryByid(int org);
	
	public Integer save(OrganizationDO org);
	
	public Integer update(OrganizationDO org);

}
