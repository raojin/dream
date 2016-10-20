package com.qmdj.platform.service.course;

import com.github.pagehelper.PageInfo;
import com.qmdj.common.base.Result;
import com.qmdj.domin.course.CourseDO;
import com.qmdj.domin.form.CourseForm;

public interface CourseService {
	
	/**
	 * 添加course
	 * @param course
	 * @return
	 * @author xw
	 * @Date 2016年10月20日10:12:33
	 */
	public Result<Integer> save(CourseDO course);
	
	/**
	 * 修改course
	 * @param course
	 * @return
	 * @author xw
	 * @Date 2016年10月20日10:12:33
	 */
	public Result<Integer> update(CourseDO course);
	
	/**
	 * 查询courseList
	 * @param course
	 * @return
	 * @author xw
	 * @Date 2016年10月20日10:12:33
	 */
	public PageInfo<CourseDO> selectList(CourseForm courseForm);
	
	/**
	 * 查询course
	 * @param course
	 * @return
	 * @author xw
	 * @Date 2016年10月20日10:12:33
	 */
	public CourseDO select(int id);

}
