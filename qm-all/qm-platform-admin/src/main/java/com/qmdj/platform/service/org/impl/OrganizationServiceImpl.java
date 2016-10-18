package com.qmdj.platform.service.org.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.qmdj.dao.organization.OrganizationDAO;
import com.qmdj.domin.form.OrgForm;
import com.qmdj.domin.organization.OrganizationDO;
import com.qmdj.platform.service.org.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDAO organizationDAO;

	@Override
	public OrganizationDO queryByid(int id) {
		return organizationDAO.selectByPrimaryKey(id);
	}

	@Override
	public boolean save(OrganizationDO org) {
		
		org.setGmtCreate(new Date());
		int insertSelective = organizationDAO.insertSelective(org);
		if(insertSelective==1){
			return true;
		}
			return false;
	}

	@Override
	public boolean update(OrganizationDO org) {
		int updateByPrimaryKeySelective = organizationDAO.updateByPrimaryKeySelective(org);
		if(updateByPrimaryKeySelective==1){
			return true;
		}
		return false;
	}


	@Override
	public PageInfo<OrganizationDO> queryList(OrgForm orgForm) {
		
		List<OrganizationDO> selectListOrg = organizationDAO.selectListOrg(orgForm.enablePaging());
		System.out.println(selectListOrg.size());
		PageInfo<OrganizationDO> pageInfo = new PageInfo<OrganizationDO>(selectListOrg);
		return pageInfo;
	}

}
