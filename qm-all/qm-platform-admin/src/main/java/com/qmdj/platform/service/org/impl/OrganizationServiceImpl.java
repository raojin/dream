package com.qmdj.platform.service.org.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.qmdj.dao.organization.OrganizationDAO;
import com.qmdj.domin.organization.OrganizationDO;
import com.qmdj.platform.service.org.OrganizationService;

public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDAO organizationDAO;

	@Override
	public OrganizationDO queryByid(int id) {
		return organizationDAO.selectByPrimaryKey(id);
	}

	@Override
	public boolean save(OrganizationDO org) {
		int insertSelective = organizationDAO.insertSelective(org);
		if(insertSelective==1){
			return true;
		}else
			return false;
	}

	@Override
	public Integer update(OrganizationDO org) {
		
		return organizationDAO.updateByPrimaryKeySelective(org);
	}

}
