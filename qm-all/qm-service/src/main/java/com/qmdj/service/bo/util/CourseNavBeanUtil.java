package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.CourseNavDO;
import com.qmdj.service.bo.CourseNavBO;

/**
 * 类QmdjCourseNavBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年11月04日
 */
public class CourseNavBeanUtil {

    private CourseNavBeanUtil(){
    }

    public static CourseNavDO courseNavBOToDO(CourseNavBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseNavDO targetObj = new CourseNavDO();
        targetObj.setId(srcObj.getCourseNavId());//主键id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        targetObj.setName(srcObj.getName());//name
        targetObj.setStatus(srcObj.getStatus());//状态 1:展示,2:不展示
        targetObj.setType(srcObj.getType());//类型 1:机构导航 ,2 家教导航
        targetObj.setSort(srcObj.getSort());//排序，值越大越靠前
        return targetObj;
    }

    public static CourseNavBO qmdjCourseNavDOToBO(CourseNavDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseNavBO targetObj = new CourseNavBO();
        targetObj.setCourseNavId(srcObj.getId());//主键id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        targetObj.setName(srcObj.getName());//name
        targetObj.setStatus(srcObj.getStatus());//状态 1:展示,2:不展示
        targetObj.setType(srcObj.getType());//类型 1:机构导航 ,2 家教导航
        targetObj.setSort(srcObj.getSort());//排序，值越大越靠前
        return targetObj;
    }
}