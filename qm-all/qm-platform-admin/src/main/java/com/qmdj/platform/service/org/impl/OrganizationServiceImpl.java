package com.qmdj.platform.service.org.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.dao.OrganizationDAO;
import com.qmdj.biz.domin.OrgForm;
import com.qmdj.biz.domin.OrganizationDO;
import com.qmdj.platform.service.org.OrganizationService;
import com.qmdj.service.common.Result;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDAO organizationDAO;

	@Override
	public OrganizationDO queryByid(int id) {
		OrganizationDO selectByPrimaryKey = organizationDAO.selectByPrimaryKey(id);
		return selectByPrimaryKey;
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
	
	@Override
	public Result<Integer> del(OrganizationDO org) {
		Result<Integer> re=new Result<Integer>();
		OrganizationDO selectByPrimaryKey = organizationDAO.selectByPrimaryKey(org.getId().intValue());
		selectByPrimaryKey.setIsDel(1);
		int insertSelective = organizationDAO.updateByPrimaryKeySelective(selectByPrimaryKey);
		if(insertSelective==1){
			re.setSuccess(true);
			re.setDate(insertSelective);
		}
		return re;
	}

}
