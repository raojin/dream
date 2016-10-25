package com.qmdj.biz.dao;

import java.util.List;

import com.qmdj.biz.domin.CourseTypeDO;

public interface CourseTypeDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseTypeDO record);

    int insertSelective(CourseTypeDO record);

    CourseTypeDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseTypeDO record);

    int updateByPrimaryKey(CourseTypeDO record);
    
    List<CourseTypeDO> queryCourseTypeList();
}