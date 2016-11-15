package com.qmdj.service.app.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.CourseDAO;
import com.qmdj.biz.dao.OrganizationDAO;
import com.qmdj.biz.domin.CourseDO;
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

	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	public Result<Map<Integer,List<OrganizationBO>>> queryOrganization(Integer tags) {
		Result<Map<Integer,List<OrganizationBO>>> re=new Result<Map<Integer,List<OrganizationBO>>>();
		Map<Integer,List<OrganizationBO>> map=new HashMap<Integer,List<OrganizationBO>>();
		 if(tags==0){
			 tags=null;
		 }
		 List<OrganizationDO> listDO=new ArrayList<>();
		 try {
			 listDO= organizationDAO.findOrganizationBytags(tags);
			 List<OrganizationBO> list=new ArrayList<>();
			 for(OrganizationDO orgDO:listDO){
				 Long lowestPrice=getOrgLowestPrice(orgDO.getId());
				 list.add(OrganizationBeanUtil.appHomeOrganizationDOToBO(orgDO,lowestPrice));
			 }
			
			 if(tags==null){
				 List<OrganizationBO> plist=new ArrayList<>();
				 List<OrganizationBO> jlist=new ArrayList<>();
				 for(OrganizationBO orgBO:list){
					 if(orgBO.getTags()==1){
						 jlist.add(orgBO);
					 }else if(orgBO.getTags()==2){
						 plist.add(orgBO);
					 }
				 } 
				 map.put(1, jlist);
				 map.put(2, plist);
			 }else{
				 map.put(tags, list);
			 }
			 re.setDate(map);
			 re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}
	
	
	private Long getOrgLowestPrice(Long orgId){
		  CourseDO	courseDO= courseDAO.queryLowestPrice(orgId);
		 Long lowestPrice=0L;
		  if(courseDO!=null){
			  lowestPrice=courseDO.getPrice();
		  }
		return lowestPrice;
	};
	
	
}
