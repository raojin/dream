package com.qmdj.dao.organization;

import java.util.List;

import com.qmdj.domin.form.OrgForm;
import com.qmdj.domin.organization.OrganizationDO;

public interface OrganizationDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(OrganizationDO record);

    int insertSelective(OrganizationDO record);

    OrganizationDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrganizationDO record);

    int updateByPrimaryKey(OrganizationDO record);
    
    List<OrganizationDO> selectListOrg(OrgForm orgForm);
    
}