package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.StaffDO;
import com.qmdj.service.bo.StaffBO;

public class StaffBeanUtil {
	
	public StaffBeanUtil(){
	}
	
	
	public static StaffDO staffBOtoDO(StaffBO srcObj){
		if(srcObj==null){
			return null;
		}
		
		StaffDO targetObj=new StaffDO();
		targetObj.setId(srcObj.getId());
		targetObj.setIsDel(srcObj.getIsDel());
		targetObj.setLinkPhone(srcObj.getLinkPhone());
		targetObj.setLoginName(srcObj.getLoginName());
		targetObj.setName(srcObj.getName());
		targetObj.setPassword(srcObj.getPassword());
		targetObj.setSex(srcObj.getSex());
		
		return targetObj;
	}
	
	public static StaffBO staffDOtoBO(StaffDO srcObj){
		if(srcObj==null){
			return null;
		}
		StaffBO targetObj =new StaffBO();
		targetObj.setId(srcObj.getId());
		targetObj.setIsDel(srcObj.getIsDel());
		targetObj.setLinkPhone(srcObj.getLinkPhone());
		targetObj.setLoginName(srcObj.getLoginName());
		targetObj.setName(srcObj.getName());
		targetObj.setPassword(srcObj.getPassword());
		targetObj.setSex(srcObj.getSex());
		return targetObj;
	}

}
