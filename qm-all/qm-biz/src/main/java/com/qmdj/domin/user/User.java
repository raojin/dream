package com.qmdj.domin.user;

import java.io.Serializable;

import com.qmdj.domin.base.BaseDO;

/**
*@Description: 用户基本信息
*@author chenjin
*@date 2016/10/12
*/
public class User extends BaseDO implements Serializable{

	private static final long serialVersionUID = 6345395190141768910L;
	
 
	/**
	 *
	 * 登陆账号
	 * */
	private String loginName;
	
	/**
	 * 
     *密码
     **/
	private String password;
	
	/**
	 * 
	 * 身份 1:教师,2:家长,3:学生,4机构
	 */
    private Integer identity;
    
    
	/**
	 * 
	 * 真实姓名
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
	 * 
	 * 学历
	 * */
	private String education;
	
	/**
	 * 
	 * 状态；－1，删除，0，默认值；
	 */
	private Integer status;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddre() {
		return addre;
	}

	public void setAddre(String addre) {
		this.addre = addre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
