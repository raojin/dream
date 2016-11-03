package com.qmdj.service.user;

import java.util.List;

import com.qmdj.biz.domin.UserDO;
import com.qmdj.service.bo.UserBO;
import com.qmdj.service.common.Result;

/**
*@Description: 添加机构负责人信息
*@author chenjin
*@date 2016/10/13
*/
public interface OrgUserSerice {
	

	/**
	 * 添加机构负责人
	 * 
	 * @param UserDO
	 * @return id
	 * @author chenjin 2016年10月23日
	 */
	public Result<Integer> saveUser(UserBO userBO);
	
	/**
	 * 更新机构负责人
	 * 
	 * @param UserDO
	 * @return Boolean 
	 * @author chenjin 2016年10月23日 
	 */
	public Result<Boolean> updateUser(UserBO userBO);
	
	/**
	 * 根据Id查询机构负责人信息
	 * 
	 * @param userId
	 * @return Id
	 * @author chenjin 2016年10月23日 
	 */
	public Result<UserBO> queryUserById(long userId);
	
	
	/**
	 * 查询机构负责人信息列表,只包含有效的数据
	 * 
	 * @param 
	 * @return List<UserDO>
	 * @author chenjin 2016年10月23日 
	 */
	public Result<List<UserBO>> queryUserList();
	
	
	/**
	 * 删除机构负责人
	 * 
	 * @param userId
	 * @return int
	 * @author chenjin 2016年10月13日 
	 */
	public Result<Integer> daleteUserById(long userId);
	
}
