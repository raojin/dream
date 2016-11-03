package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.CourseNavDO;
import com.qmdj.service.bo.CourseTypeBO;

/**
 * 类QmdjCourseTypeBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年10月25日
 */
public class CourseTypeBeanUtil {

    private CourseTypeBeanUtil(){
    }

    public static CourseNavDO qmdjCourseTypeBOToDO(CourseTypeBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseNavDO targetObj = new CourseNavDO();
        targetObj.setId(srcObj.getCourseTypeId());//主键id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        targetObj.setName(srcObj.getName());//name
        targetObj.setStatus(srcObj.getStatus());//状态 1:展示,2:不展示
        targetObj.setType(srcObj.getType());//类型 1:自定义 ,2 平台添加
        return targetObj;
    }

    public static CourseTypeBO qmdjCourseTypeDOToBO(CourseNavDO srcObj) {
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