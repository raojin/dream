package com.qmdj.domin.user;

import java.io.Serializable;

public class TeacherDO implements Serializable{

	private static final long serialVersionUID = 6345395190141768910L;
	
 
	/**
	 *
	 * 登陆账号
	 * */
	private String nick;
	
	/**
	 * 
     *密码
     **/
	private String password;
	
	/**
	 * 
	 * 姓名
	 * */
	private String addrName;
	
	/**
	 * 
	 * 联系电话
	 * */
	private String linkPhone;
	
	/**
	 * 
	 * 年龄
	 * */
	private Integer age;
	
	/**
	 * 
	 * 地址
	 * */
	private String addre;
	
	/**
	 * 
	 * 邮箱
	 * */
	private String email;
	
	
	/**
	 * 状态；－1，删除，0，默认值；
	 */
	private Integer status;
	
	
}
