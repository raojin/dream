package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.PublishCourseDO;
import com.qmdj.service.bo.PublishCourseBO;

/**
 * 类QmdjPublishCourseBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年10月27日
 */
public class PublishCourseBeanUtil {

    private PublishCourseBeanUtil(){
    }

    public static PublishCourseDO publishCourseBOToDO(PublishCourseBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        PublishCourseDO targetObj = new PublishCourseDO();
        targetObj.setId(srcObj.getPublishCourseId());//id
        targetObj.setParentId(srcObj.getParentid());//家教发布的就是userId  机构发布的就是orgId  
        targetObj.setCourseIds(srcObj.getCourseIds());//辅导课程（courseId,以,号隔开）当机构发布套餐的时候ids为多个
        targetObj.setCourseType(srcObj.getCourseType());//课程类型 com.qmdj.biz.domin.CourseTypeDO
        targetObj.setTeachingWay(srcObj.getTeachingWay());//授课方式 1:老师上门,2:学生上门
        targetObj.setTeachingTimes(srcObj.getTeachingTimes());//授课时间(以逗号隔开)  com.qmdj.biz.domin.TeachingTimeEnum
        targetObj.setTeachingAddre(srcObj.getTeachingAddre());//授课区域,家教教师时不能为空
        targetObj.setPrice(srcObj.getPrice());//price
        targetObj.setTimeType(srcObj.getTimeType());//时间类型 1:/小时，2:/天，3:/周，4:/月
        targetObj.setStatus(srcObj.getStatus());//1:正常 ,2:隐藏，（家教教师为 3:等待预约，4:已经预约,2:隐藏）
        targetObj.setSort(srcObj.getSort());//排序，值越大越靠前
        return targetObj;
    }

    public static PublishCourseBO publishCourseDOToBO(PublishCourseDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        PublishCourseBO targetObj = new PublishCourseBO();
        targetObj.setPublishCourseId(srcObj.getId());//id
        targetObj.setParentid(srcObj.getParentId());//家教发布的就是userId  机构发布的就是orgId  
        targetObj.setCourseIds(srcObj.getCourseIds());//辅导课程（courseId,以,号隔开）当机构发布套餐的时候ids为多个
        targetObj.setCourseType(srcObj.getCourseType());//课程类型 com.qmdj.biz.domin.CourseTypeDO
        targetObj.setTeachingWay(srcObj.getTeachingWay());//授课方式 1:老师上门,2:学生上门
        targetObj.setTeachingTimes(srcObj.getTeachingTimes());//授课时间(以逗号隔开)  com.qmdj.biz.domin.TeachingTimeEnum
        targetObj.setTeachingAddre(srcObj.getTeachingAddre());//授课区域,家教教师时不能为空
        targetObj.setPrice(srcObj.getPrice());//price
        targetObj.setTimeType(srcObj.getTimeType());//时间类型 1:/小时，2:/天，3:/周，4:/月
        targetObj.setStatus(srcObj.getStatus());//1:正常 ,2:隐藏，（家教教师为 3:等待预约，4:已经预约,2:隐藏）
        targetObj.setSort(srcObj.getSort());//排序，值越大越靠前
        return targetObj;
    }
}