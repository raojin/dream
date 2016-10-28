package com.qmdj.service.organization.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.OrganizationDAO;
import com.qmdj.biz.domin.OrganizationDO;
import com.qmdj.biz.pogo.qo.OrganizationQO;
import com.qmdj.biz.util.Query;
import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.bo.util.OrganizationBeanUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.organization.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDAO organizationDAO;

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
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
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

	
	
}
