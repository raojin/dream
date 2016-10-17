package com.qmdj.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.qmdj.dao.organization.OrganizationDAO;
import com.qmdj.domin.organization.OrganizationDO;
import com.qmdj.org.service.OrganizationService;

public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDAO organizationDAO;

	@Override
	public OrganizationDO queryByid(int id) {
		return organizationDAO.selectByPrimaryKey(id);
	}

	@Override
	public Integer save(OrganizationDO org) {
		
		return organizationDAO.insertSelective(org);
	}

	@Override
	public Integer update(OrganizationDO org) {
		return organizationDAO.updateByPrimaryKeySelective(org);
	}

}
