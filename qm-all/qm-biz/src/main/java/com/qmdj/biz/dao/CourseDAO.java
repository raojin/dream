package com.qmdj.biz.dao;

import java.util.List;

import com.qmdj.biz.domin.CourseDO;
import com.qmdj.biz.domin.CourseForm;

public interface CourseDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseDO record);

    int insertSelective(CourseDO record);

    CourseDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseDO record);

    int updateByPrimaryKey(CourseDO record);
    
    List<CourseDO> selectCourseList(CourseForm courseForm);
}