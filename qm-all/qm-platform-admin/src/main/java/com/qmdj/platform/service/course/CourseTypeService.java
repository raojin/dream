package com.qmdj.platform.service.course;

import java.util.List;

import com.qmdj.biz.domin.CourseTypeDO;
import com.qmdj.service.common.Result;

/**
*@Description: 课程类型接口
*@author chenjin
*@date 2016/10/15
*/
public interface CourseTypeService {

	/**
	 * 保存课程类型
	 * 
	 * @param 
	 * @return id
	 * @author chenjin 2016年10月15日 
	 */
	public Result<Integer> saveCoueseType(CourseTypeDO cousesTypeDO);
	
	/**
	 * 查询课程类型列表,只包含有效的数据
	 * 
	 * @param 
	 * @return List<CousesTypeDO>
	 * @author chenjin 2016年10月15日 
	 */
	public Result<List<CourseTypeDO>> queryCoueseTypeList();
	
	
	/**
	 * 修改课程类型
	 * 
	 * @param 
	 * @return id
	 * @author xw 2016年10月20日09:03:35
	 */
	public Result<Integer> updateCoueseType(CourseTypeDO cousesTypeDO);
	
	/**
	 * 根据ID查询
	 * 
	 * @param 
	 * @return id
	 * @author xw 2016年10月20日09:03:35
	 */
	public CourseTypeDO selectCoueseTypeById(int id);
}
