package com.qmdj.biz.dao;

import java.util.List;

import com.qmdj.biz.domin.CourseTypeDO;
import com.qmdj.biz.domin.CourseForm;

public interface CourseTypeDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseTypeDO record);

    int insertSelective(CourseTypeDO record);

    CourseTypeDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseTypeDO record);

    int updateByPrimaryKey(CourseTypeDO record);
    
    List<CourseTypeDO> selectCourseList(CourseForm courseForm);
}