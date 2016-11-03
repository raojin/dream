package com.qmdj.biz.dao;

import java.util.List;

import com.qmdj.biz.domin.CourseNavDO;

public interface CourseNavDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseNavDO record);

    int insertSelective(CourseNavDO record);

    CourseNavDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseNavDO record);

    int updateByPrimaryKey(CourseNavDO record);
    
    List<CourseNavDO> queryCourseTypeList();
}