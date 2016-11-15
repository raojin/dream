package com.qmdj.service.bo.util;

import java.util.ArrayList;
import java.util.List;

import com.qmdj.biz.domin.CourseTypeDO;
import com.qmdj.service.bo.CourseTypeBO;

/**
 * 类QmdjCourseTypeBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年11月04日
 */
public class CourseTypeBeanUtil {

    private CourseTypeBeanUtil(){
    }

    public static CourseTypeDO courseTypeBOToDO(CourseTypeBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseTypeDO targetObj = new CourseTypeDO();
        targetObj.setId(srcObj.getCourseTypeId());//主键Id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//修改时间
        targetObj.setCourseNavId(srcObj.getCourseNavId());//课程导航Id
        targetObj.setCourseNavName(srcObj.getCourseNavName());//课程导航名称
        targetObj.setCourseTypeName(srcObj.getCourseTypeName());//课程类型名称
        targetObj.setType(srcObj.getType());//类型 1:自定义 ,2 平台添加
        targetObj.setStatus(srcObj.getStatus());//状态 1:正常 ,2 隐藏 自定义默认为2
        targetObj.setSort(srcObj.getSort());//排序，值越大越靠前，自定义类型默认为0
        return targetObj;
    }

    public static CourseTypeBO courseTypeDOToBO(CourseTypeDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        CourseTypeBO targetObj = new CourseTypeBO();
        targetObj.setCourseTypeId(srcObj.getId());//主键Id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//修改时间
        targetObj.setCourseNavId(srcObj.getCourseNavId());//课程导航Id
        targetObj.setCourseTypeName(srcObj.getCourseTypeName());//课程类型名称
        targetObj.setCourseNavName(srcObj.getCourseNavName());//课程导航名称
        targetObj.setType(srcObj.getType());//类型 1:自定义 ,2 平台添加
        targetObj.setStatus(srcObj.getStatus());//状态 1:正常 ,2 隐藏 自定义默认为2
        targetObj.setSort(srcObj.getSort());//排序，值越大越靠前，自定义类型默认为0
        return targetObj;
    }
    
    public static List<CourseTypeBO> courseTypeDOToBOList(List<CourseTypeDO> courseTypes){
    	if(courseTypes==null){
    		return null;
    	}
    	List<CourseTypeBO> list=new ArrayList<CourseTypeBO>();
    	for( CourseTypeDO type:courseTypes){
    		list.add(courseTypeDOToBO(type));
    	}
		return list;
    	
    }
}