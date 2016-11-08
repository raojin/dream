package com.qmdj.service.organization.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.OrganizationDAO;
import com.qmdj.biz.domin.OrganizationDO;
import com.qmdj.biz.pogo.qo.OrganizationQO;
import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.bo.UserBO;
import com.qmdj.service.bo.util.OrganizationBeanUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.organization.OrganizationService;
import com.qmdj.service.user.OrgUserSerice;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDAO organizationDAO;
	
	@Autowired
    private OrgUserSerice orgUserSerice;

	@Override
	public Result<OrganizationBO> queryByOrganizationId(long orgId) {
		Result<OrganizationBO> re=new Result<OrganizationBO>();
		if(orgId<=0){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		try {
			int id=Integer.parseInt(orgId+"");
			OrganizationDO  organizationDO= organizationDAO.selectByPrimaryKey(id);
			re.setSuccess(true);
			re.setDate(OrganizationBeanUtil.qmdjOrganizationDOToBO(organizationDO));//数据转换
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			//e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<Pagination<OrganizationBO>> queryOrganizationForPage(OrganizationQO queryQO) {
		Result<Pagination<OrganizationBO>> re=new Result<Pagination<OrganizationBO>>();
		if(queryQO==null){
			queryQO=new OrganizationQO();
		}
		
		try {
			List<OrganizationDO> listDO= organizationDAO.findOrganizationForPage(queryQO);
			List<OrganizationBO> list=new ArrayList<OrganizationBO>();
			if(listDO!=null){
			  for(OrganizationDO orgDO:listDO){
				  list.add(OrganizationBeanUtil.qmdjOrganizationDOToBO(orgDO));
			  }
			}
			
			int count =organizationDAO.findOrganizationForPageCount(queryQO);
			Pagination<OrganizationBO> page=new Pagination<OrganizationBO>(list,queryQO);
			page.setData(list);
			page.setTotalCount(count);
			re.setDate(page);
			re.setSuccess(true);
			return re;
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		return re;
	}

	@Override
	public Result<Boolean> insertOrganization(OrganizationBO org) {
		Result<Boolean> re=new Result<Boolean>();
		if(org==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		if(org.getUserId()==null||org.getUserId()<=0||StringUtils.isBlank(org.getPhone())||org.getSort()==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
		   return re;
		}
		try {
			Result<UserBO> reUser=orgUserSerice.queryUserById(org.getUserId());
			if(reUser.isSuccess()){
			 org.setUserName(reUser.getDate().getName());
			 }
			OrganizationDO  record=OrganizationBeanUtil.qmdjOrganizationBOToDO(org);
			organizationDAO.insert(record);
			re.setDate(true);
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<Boolean> updateOrganization(OrganizationBO org) {
		Result<Boolean> re=new Result<Boolean>();
		if(org==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		if(org.getOrganizationId()==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
		   return re;
		}
		try {
		   if(org.getUserId()!=null){
			Result<UserBO> reUser=orgUserSerice.queryUserById(org.getUserId());
			if(reUser.isSuccess()){
			 org.setUserName(reUser.getDate().getName());
			 }
		   }
			OrganizationDO  record=OrganizationBeanUtil.qmdjOrganizationBOToDO(org);
			organizationDAO.updateByPrimaryKeySelective(record);
			re.setDate(true);
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<OrganizationBO> selectOrganizationByUserid(Long userId) {
		Result<OrganizationBO> re=new Result<OrganizationBO>();
		if(userId == null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
		   return re;
		}
		try {
			OrganizationDO selectOrgByUserid = organizationDAO.selectOrgByUserid(userId);
			re.setDate(OrganizationBeanUtil.qmdjOrganizationDOToBO(selectOrgByUserid));
			re.setSuccess(true);
		} catch (Exception e) {
				re.setCode(ReCode.SYS_REEOR.getCode());
				re.setMessage(ReCode.SYS_REEOR.getMessage());
				e.printStackTrace();
			}
	
		return re;
	}
	
}
