package com.qmdj.biz.pogo.qo;

import java.util.List;

import com.qmdj.biz.util.Query;

public class ModelQO extends Query{

	private static final long serialVersionUID = 1L;
	
	private String moduleName;
	
	private List<String> moduleCodes;
	
	private Integer moduleType;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<String> getModuleCodes() {
		return moduleCodes;
	}

	public void setModuleCodes(List<String> moduleCodes) {
		this.moduleCodes = moduleCodes;
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
}
