package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.CourseTheacherDO;
import com.qmdj.service.bo.CourseTheacherBO;

/**
 * 类QmdjCourseTheacherBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年11月16日
 */
public class CourseTheacherBeanUtil {

    private CourseTheacherBeanUtil(){
    }

    public static CourseTheacherDO qmdjCourseTheacherBOToDO(CourseTheacherBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseTheacherDO targetObj = new CourseTheacherDO();
        targetObj.setId(srcObj.getCourseTheacherId());//id
        targetObj.setCourseId(srcObj.getCourseId());//课程Id
        targetObj.setTeacherId(srcObj.getTeacherId());//教师ID
        targetObj.setStatus(srcObj.getStatus());//状态 1正常 100删除
        targetObj.setGmtCreate(srcObj.getGmtCreate());//gmtCreate
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        return targetObj;
    }

    public static CourseTheacherBO qmdjCourseTheacherDOToBO(CourseTheacherDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseTheacherBO targetObj = new CourseTheacherBO();
        targetObj.setCourseTheacherId(srcObj.getId());//id
        targetObj.setCourseId(srcObj.getCourseId());//课程Id
        targetObj.setTeacherId(srcObj.getTeacherId());//教师ID
        targetObj.setStatus(srcObj.getStatus());//状态 1正常 100删除
        targetObj.setGmtCreate(srcObj.getGmtCreate());//gmtCreate
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        return targetObj;
    }
}