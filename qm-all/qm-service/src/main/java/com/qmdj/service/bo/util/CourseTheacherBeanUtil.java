package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.CourseTheacherDO;
import com.qmdj.service.bo.CourseTheacherBO;

/**
 * 类QmdjCourseTheacherBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年11月15日
 */
public class CourseTheacherBeanUtil {

    private CourseTheacherBeanUtil(){
    }

    public static CourseTheacherDO courseTheacherBOToDO(CourseTheacherBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseTheacherDO targetObj = new CourseTheacherDO();
        targetObj.setId(srcObj.getCourseTheacherId());//id
        targetObj.setCourseid(srcObj.getCourseid());//课程Id
        targetObj.setTeacherid(srcObj.getTeacherid());//教师ID
        return targetObj;
    }

    public static CourseTheacherBO courseTheacherDOToBO(CourseTheacherDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseTheacherBO targetObj = new CourseTheacherBO();
        targetObj.setCourseTheacherId(srcObj.getId());//id
        targetObj.setCourseid(srcObj.getCourseid());//课程Id
        targetObj.setTeacherid(srcObj.getTeacherid());//教师ID
        return targetObj;
    }
}