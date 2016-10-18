package com.qmdj.platform.service.org;

import org.springframework.stereotype.Service;

import com.qmdj.domin.organization.OrganizationDO;

@Service
public interface OrganizationService {
	
	public OrganizationDO queryByid(int org);
	
	public boolean save(OrganizationDO org);
	
	public Integer update(OrganizationDO org);

}
