package com.qmdj.dao.course;

import java.util.List;

import com.qmdj.domin.course.CourseTypeDO;

public interface CourseTypeDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseTypeDO record);

    int insertSelective(CourseTypeDO record);

    CourseTypeDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseTypeDO record);

    int updateByPrimaryKey(CourseTypeDO record);
    
    List<CourseTypeDO> queryCourseTypeList();
}