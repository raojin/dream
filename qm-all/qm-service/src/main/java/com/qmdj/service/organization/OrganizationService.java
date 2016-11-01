package com.qmdj.service.organization;

import java.util.List;

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
	 * 查询有效的机构列表
	 * @param   type 0:全部 1:精品 2:普通
	 * @return Result<List<OrganizationBO>>
	 * @author chenjin
	 * @data   2016/11/1 
	 * */
	public Result<List<OrganizationBO>>  queryOrganization(Integer type);
	
	
	
	
	
}
