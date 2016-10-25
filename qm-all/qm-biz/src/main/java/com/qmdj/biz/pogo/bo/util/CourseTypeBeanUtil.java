package com.qmdj.biz.pogo.bo.util;

import com.qmdj.biz.pogo.bo.CourseTypeBO;
import com.qmdj.domin.course.CourseTypeDO;

/**
 * 类QmdjCourseTypeBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年10月25日
 */
public class CourseTypeBeanUtil {

    private CourseTypeBeanUtil(){
    }

    public static CourseTypeDO qmdjCourseTypeBOToDO(CourseTypeBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseTypeDO targetObj = new CourseTypeDO();
        targetObj.setId(srcObj.getCourseTypeId());//主键id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        targetObj.setName(srcObj.getName());//name
        targetObj.setStatus(srcObj.getStatus());//状态 1:展示,2:不展示
        targetObj.setType(srcObj.getType());//类型 1:自定义 ,2 平台添加
        return targetObj;
    }

    public static CourseTypeBO qmdjCourseTypeDOToBO(CourseTypeDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseTypeBO targetObj = new CourseTypeBO();
        targetObj.setCourseTypeId(srcObj.getId());//主键id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        targetObj.setName(srcObj.getName());//name
        targetObj.setStatus(srcObj.getStatus());//状态 1:展示,2:不展示
        targetObj.setType(srcObj.getType());//类型 1:自定义 ,2 平台添加
        return targetObj;
    }
}