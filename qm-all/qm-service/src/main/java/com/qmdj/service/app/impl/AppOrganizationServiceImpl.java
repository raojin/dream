package com.qmdj.service.app.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.OrganizationDAO;
import com.qmdj.biz.domin.OrganizationDO;
import com.qmdj.service.app.AppOrganizationService;
import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.bo.util.OrganizationBeanUtil;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;

@Service
public class AppOrganizationServiceImpl implements AppOrganizationService {

	@Autowired
	private OrganizationDAO organizationDAO;

	@Override
	public Result<Map<Integer,List<OrganizationBO>>> queryOrganization(Integer type) {
		Result<Map<Integer,List<OrganizationBO>>> re=new Result<Map<Integer,List<OrganizationBO>>>();
		Map<Integer,List<OrganizationBO>> map=new HashMap<Integer,List<OrganizationBO>>();
		 if(type==0){
			 type=null;
		 }
		 List<OrganizationDO> listDO=new ArrayList<>();
		 try {
			 listDO= organizationDAO.findOrganizationBytype(type);
			 List<OrganizationBO> list=new ArrayList<>();
			 for(OrganizationDO orgDO:listDO){
				 list.add(OrganizationBeanUtil.qmdjOrganizationDOToBO(orgDO));
			 }
			 if(type!=0){
				 map.put(type, list);
			 }else{
				 List<OrganizationBO> plist=list;
				 List<OrganizationBO> jlist=list;
//				 for(OrganizationBO orgBO:list){
//				 } 暂时没有数据 
				 map.put(1, plist);
				 map.put(2, jlist);
			 }
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
		}
		return re;
	}

	
	
	
}
