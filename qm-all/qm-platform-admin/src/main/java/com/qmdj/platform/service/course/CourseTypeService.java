package com.qmdj.platform.service.course;

import java.util.List;

import com.qmdj.common.base.Result;
import com.qmdj.domin.course.CourseTypeDO;

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
}
