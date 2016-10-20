package com.qmdj.platform.service.org.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.qmdj.common.base.Result;
import com.qmdj.dao.organization.OrganizationDAO;
import com.qmdj.domin.form.OrgForm;
import com.qmdj.domin.organization.OrganizationDO;
import com.qmdj.platform.service.org.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDAO organizationDAO;

	@Override
	public Result<OrganizationDO> queryByid(int id) {
		Result<OrganizationDO> re=new Result<OrganizationDO>();
		OrganizationDO selectByPrimaryKey = organizationDAO.selectByPrimaryKey(id);
		if(selectByPrimaryKey!=null){
			re.setSuccess(true);
			re.setDate(selectByPrimaryKey);
		}
		return re;
	}

	@Override
	public Result<Integer> save(OrganizationDO org) {
		Result<Integer> re=new Result<Integer>();
		org.setGmtCreate(new Date());
		int insertSelective = organizationDAO.insertSelective(org);
		if(insertSelective==1){
			re.setSuccess(true);
			re.setDate(insertSelective);
		}
		return re;
	}

	@Override
	public Result<Integer> update(OrganizationDO org) {
		Result<Integer> re=new Result<Integer>();
		org.setGmtCreate(new Date());
		int insertSelective = organizationDAO.updateByPrimaryKeySelective(org);
		if(insertSelective==1){
			re.setSuccess(true);
			re.setDate(insertSelective);
		}
		return re;
	}


	@Override
	public PageInfo<OrganizationDO> queryList(OrgForm orgForm) {
		List<OrganizationDO> selectListOrg = organizationDAO.selectListOrg(orgForm.enablePaging());
		PageInfo<OrganizationDO> pageInfo = new PageInfo<OrganizationDO>(selectListOrg);
		return pageInfo;
	}

}
