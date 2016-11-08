package com.qmdj.service.course;

import com.github.pagehelper.PageInfo;
import com.qmdj.biz.pogo.qo.CourseQO;
import com.qmdj.service.bo.CourseBO;
import com.qmdj.service.common.Result;

/**
 * 
 * @author xw
 *
 */
public interface CourseService {
	
	/**
	 * 添加
	 * @param course
	 * @return
	 */
	Result<Integer> addCourse(CourseBO course);
	
	/**
	 * 更新
	 * @param course
	 * @return
	 */
	Result<Integer> updateCourse(CourseBO course);
	
	/**
	 * 删除
	 * @param course
	 * @return
	 */
	Result<Integer> delCourse(CourseBO course);
	
	/**
	 * 分页查询
	 * @param course
	 * @return
	 */
	public Result<PageInfo<CourseQO>> queryForPage(CourseQO course);
	
	
}
