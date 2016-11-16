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
import com.qmdj.service.bo.app.AppOrgDetailBO;
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
	}


	@Override
	public Result<AppOrgDetailBO> queryOrganizationDetails(Long orgId) {
		Result<AppOrgDetailBO> re=new Result<AppOrgDetailBO>();
		if(orgId==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		if(orgId<=0){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		try {
			OrganizationDO orgDO=organizationDAO.selectByPrimaryKey(Integer.parseInt(orgId+""));
			AppOrgDetailBO appOrg=new AppOrgDetailBO();
			if(orgDO!=null){
				appOrg.setAddrName(orgDO.getAddrName());
				CourseDO courseDO=new CourseDO();
				courseDO.setParentid(orgId);
				int coutCourse=0;
				List<CourseDO> list=courseDAO.findByCondition(courseDO);
				if(list!=null){
					coutCourse=list.size();
				}
				appOrg.setCountCourse(coutCourse);
				appOrg.setCountScore(0.9); // 现在没有这个功能
				appOrg.setCountStudent(120); // 现在没有这个功能
				appOrg.setDetail(orgDO.getDetail());
				appOrg.setImage(orgDO.getImage());
				appOrg.setName(orgDO.getName());
				appOrg.setOrganizationId(orgDO.getId());
				appOrg.setPhone(orgDO.getPhone());
				appOrg.setTitle(orgDO.getTitle());
			}
			re.setSuccess(true);
			re.setDate(appOrg);
			return re;
		} catch (NumberFormatException e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	};
	
	
}
