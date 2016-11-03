package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.CourseTypeDO;
import com.qmdj.service.bo.CourseBO;

/**
 * 类QmdjCourseBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年10月27日
 */
public class CourseBeanUtil {

    private CourseBeanUtil(){
    }

    public static CourseTypeDO qmdjCourseBOToDO(CourseBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseTypeDO targetObj = new CourseTypeDO();
        targetObj.setId(srcObj.getQmdjCourseId());//主键Id
        targetObj.setCourseTypeId(srcObj.getCourseTypeId());//课程类型
        targetObj.setCourseName(srcObj.getCourseName());//课程名称
        targetObj.setType(srcObj.getType());//类型 1:自定义 ,2 平台添加
        targetObj.setStatus(srcObj.getStatus());//状态 1:正常 ,2 隐藏
        return targetObj;
    }

    public static CourseBO qmdjCourseDOToBO(CourseTypeDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseBO targetObj = new CourseBO();
        targetObj.setQmdjCourseId(srcObj.getId());//主键Id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//修改时间
        targetObj.setCourseTypeId(srcObj.getCourseTypeId());//课程类型
        targetObj.setCourseName(srcObj.getCourseName());//课程名称
        targetObj.setType(srcObj.getType());//类型 1:自定义 ,2 平台添加
        targetObj.setStatus(srcObj.getStatus());//状态 1:正常 ,2 隐藏
        return targetObj;
    }
}