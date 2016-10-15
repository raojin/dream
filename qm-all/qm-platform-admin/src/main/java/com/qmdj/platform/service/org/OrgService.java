package com.qmdj.platform.service.org;

import java.util.List;

import com.qmdj.common.base.Result;
import com.qmdj.domin.organization.OrganizationDO;

/**
*@Description: 机构信息接口
*@author chenjin
*@date 2016/10/14
*/
public interface OrgService {

	/**
	 * 根据Id查询机构负责人信息
	 * 
	 * @param userId
	 * @return Id
	 * @author chenjin 2016年10月23日 
	 */
	public Result<Integer> saveOrganization(OrganizationDO org);
	
	/**
	 * 根据Id查询机构负责人信息
	 * 
	 * @param userId
	 * @return List<OrganizationDO>
	 * @author chenjin 2016年10月23日 
	 */
	public Result<List<OrganizationDO>> queryOrganizationList();
}
