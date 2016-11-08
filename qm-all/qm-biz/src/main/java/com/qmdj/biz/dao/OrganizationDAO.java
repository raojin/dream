package com.qmdj.biz.dao;

import java.util.List;

import com.qmdj.biz.domin.OrgForm;
import com.qmdj.biz.domin.OrganizationDO;
import com.qmdj.biz.pogo.qo.OrganizationQO;

public interface OrganizationDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(OrganizationDO record);

    int insertSelective(OrganizationDO record);

    OrganizationDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrganizationDO record);

    int updateByPrimaryKey(OrganizationDO record);
    
    List<OrganizationDO> selectListOrg(OrgForm orgForm);
    
    List<OrganizationDO> findOrganizationForPage(OrganizationQO queryQO);
    
    int  findOrganizationForPageCount(OrganizationQO queryQO);
    
    /*tags 1:精品, 2:普通*/
    List<OrganizationDO> findOrganizationBytags(Integer tags);
    
    //根据userid查询
    OrganizationDO selectOrgByUserid(long userId);
    
    
    
}