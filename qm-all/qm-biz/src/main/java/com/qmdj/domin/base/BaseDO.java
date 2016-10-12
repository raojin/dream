package com.qmdj.domin.base;

import java.io.Serializable;
import java.util.Date;

/**
*@Description: 实体类基类
*@author chenjin
*@date 2016/10/12
*/
public class BaseDO implements Serializable{

	private static final long serialVersionUID = -4529028591118244850L;

	
	/**
	 * 主键
	 */
	private Long Id;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
}
