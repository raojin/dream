package com.qmdj.domin.teacher;

public enum TeachingTimeEnum {
	
	Monday_AM(1,"周一上午"),Tuesday_AM(2,"周二上午"),Wednesday_AM(3,"周三上午"),Thursday_AM(4,"周四上午"),Friday_AM(5,"周五上午"),Saturday_AM(6,"周六上午"),Sunday_AM(7,"周日上午"),
	Monday_PM(11,"周一下午"),Tuesday_PM(22,"周二下午"),Wednesday_PM(33,"周三下午"),Thursday_PM(44,"周四下午"),Friday_PM(55,"周五下午"),SaturdayPM(66,"周六下午"),Sunday_PM(77,"周日下午");
	
	private TeachingTimeEnum(Integer id,String time){
		
		this.id=id;
		this.time=time;
	}
	

	 private Integer id;
	 
	 private String time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
