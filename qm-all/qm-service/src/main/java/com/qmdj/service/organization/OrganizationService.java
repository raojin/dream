package com.qmdj.service.organization;


import com.qmdj.biz.pogo.qo.OrganizationQO;
import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.Result;

/**
*@Description: 机构接口
*@author chenjin
*@date 2016/10/26
*/
public interface OrganizationService {
	
	
	/**
	 * @param  orgId 机构Id 必填
	 * @return Result<OrganizationBO>
	 * @author chenjin
	 * @data   2016/10/26 
	 * */
	public Result<OrganizationBO> queryByOrganizationId(long orgId);
	
	
	
	/**
	 * @param  OrganizationQO 分页查询机构
	 * @return Result<Pagination<OrganizationBO>>
	 * @author chenjin
	 * @data   2016/10/27 
	 * */
	public Result<Pagination<OrganizationBO>> queryOrganizationForPage(OrganizationQO queryQO);
	
	
	/**
	 * @param  OrganizationBO 保存机构信息
	 * @return Result<Boolean>
	 * @author chenjin
	 * @data   2016/11/3
	 * */
	public Result<Boolean> insertOrganization(OrganizationBO organizationBO);
	
	
	/**
	 * @param  OrganizationBO 更新机构信息
	 * @return Result<Boolean>
	 * @author chenjin
	 * @data   2016/11/3
	 * */
	public Result<Boolean> updateOrganization(OrganizationBO organizationBO);
	
	/**
	 * @param  根据userId查询
	 * @return Result<Boolean>
	 * @author xw
	 * @data   2016年11月8日17:11:07
	 * */
	public Result<OrganizationBO> selectOrganizationByUserid(Long userId);
	
		
}
