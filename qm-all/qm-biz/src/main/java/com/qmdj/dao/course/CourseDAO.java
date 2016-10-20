package com.qmdj.dao.course;

import java.util.List;

import com.qmdj.domin.course.CourseDO;
import com.qmdj.domin.form.CourseForm;

public interface CourseDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseDO record);

    int insertSelective(CourseDO record);

    CourseDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseDO record);

    int updateByPrimaryKey(CourseDO record);
    
    List<CourseDO> selectCourseList(CourseForm courseForm);
}