package com.qmdj.platform.service.org;

import java.util.List;

import com.qmdj.common.base.Result;
import com.qmdj.domin.user.UserDO;

/**
*@Description: 添加机构负责人信息
*@author chenjin
*@date 2016/10/13
*/
public interface OrgUserSerice {
	

	/**
	 * 添加公益创建人
	 * 
	 * @param UserDO
	 * @return id
	 * @author ShenQuan 
	 */
	public Result<Integer> saveUser(UserDO userDO);
	
	/**
	 * 更新公益创建人
	 * 
	 * @param UserDO
	 * @return Boolean 
	 * @author chenjin 2016年10月23日 
	 */
	public Result<Boolean> updateUser(UserDO userDO);
	
	/**
	 * 根据Id查询机构负责人信息
	 * 
	 * @param userId
	 * @return Id
	 * @author chenjin 2016年10月23日 
	 */
	public Result<UserDO> queryUserById(long userId);
	
	
	/**
	 * 查询机构负责人信息列表,只包含有效的数据
	 * 
	 * @param 
	 * @return List<UserDO>
	 * @author chenjin 2016年10月23日 
	 */
	public Result<List<UserDO>> queryUserList();
	
	
	/**
	 * 删除机构负责人
	 * 
	 * @param userId
	 * @return int
	 * @author chenjin 2016年10月13日 
	 */
	public Result<Integer> daleteUserById(long userId);
}
