package com.qmdj.biz.pogo.qo;


import org.apache.commons.lang.StringUtils;

import com.qmdj.biz.util.Query;

public class ModelQO extends Query{

	private static final long serialVersionUID = 1L;
	
	private String moduleName;
	
	private Integer moduleType;

	  /**
     * 模块类型 1:图片 2 :文字
     */
	private String moduleCode;
	
	public ModelQO(){}
	
	
	public ModelQO(String moduleCode,Integer moduleType){
		this.moduleCode=moduleCode;
		this.moduleType=moduleType;
	}
	
	
	public boolean checkCodeAndType(){
		if(StringUtils.isBlank(this.moduleCode)){
			return false;
		}
		if(moduleType==null){
			return false;
		}
		if(moduleType!=1&&moduleType!=2){
			return false;
		}
		
		return true;
	}
	
	
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Integer getModuleType() {
		return moduleType;
	}

	public void setModuleType(Integer moduleType) {
		this.moduleType = moduleType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	
}
