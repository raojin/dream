package com.qmdj.domin.course;


/**
*@Description: 课程类型
*@author chenjin
*@date 2016/10/12
*/
public enum CoueseTypeEnum {
	
	PreSchool(1,"学龄前"),PriSchool(2,"小学"),MidSchool(3,"中学"),HighSchool(4,"高中"); //之后想到再添加
	
	
	private CoueseTypeEnum(Integer id,String describe){
		this.id=id;
		this.describe=describe;
	}

	private Integer id;
	
	private String describe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	} 
	
	
}
