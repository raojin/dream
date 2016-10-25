package com.qmdj.biz.dao;

import java.util.List;

import com.qmdj.biz.domin.OrgForm;
import com.qmdj.biz.domin.OrganizationDO;

public interface OrganizationDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(OrganizationDO record);

    int insertSelective(OrganizationDO record);

    OrganizationDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrganizationDO record);

    int updateByPrimaryKey(OrganizationDO record);
    
    List<OrganizationDO> selectListOrg(OrgForm orgForm);
    
}