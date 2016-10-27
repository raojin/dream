package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.TeacherDO;
import com.qmdj.service.bo.TeacherBO;

/**
 * 类QmdjTeacherBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年10月27日
 */
public class TeacherBeanUtil {

    private TeacherBeanUtil(){
    }

    public static TeacherDO qmdjTeacherBOToDO(TeacherBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        TeacherDO targetObj = new TeacherDO();
        targetObj.setId(srcObj.getTeacherId());//主键Id
        targetObj.setUserId(srcObj.getUserId());//基础信息
        targetObj.setIdentity(srcObj.getIdentity());//1:机构教师 ,2 家教教师
        targetObj.setOrganizationId(srcObj.getOrganizationId());//机构Id  是机构教师时 organizationId不能为空
        targetObj.setIsPublic(srcObj.getIspublic());//是否愿意家教
        targetObj.setCode(srcObj.getCode());//编号(8位字符串) 平台教师以O开头，家教教师以T开头
        targetObj.setEducation(srcObj.getEducation());//education
        targetObj.setName(srcObj.getName());//name
        targetObj.setSchool(srcObj.getSchool());//school
        targetObj.setProfessional(srcObj.getProfessional());//professional
        targetObj.setImages(srcObj.getImages());//图片集
        targetObj.setStatus(srcObj.getStatus());//状态 1:审核通过  2:审核中 3审核不通过
        return targetObj;
    }

    public static TeacherBO qmdjTeacherDOToBO(TeacherDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        TeacherBO targetObj = new TeacherBO();
        targetObj.setTeacherId(srcObj.getId());//主键Id
        targetObj.setUserId(srcObj.getUserId());//基础信息
        targetObj.setIdentity(srcObj.getIdentity());//1:机构教师 ,2 家教教师
        targetObj.setOrganizationId(srcObj.getOrganizationId());//机构Id  是机构教师时 organizationId不能为空
        targetObj.setIspublic(srcObj.getIsPublic());//是否愿意家教
        targetObj.setCode(srcObj.getCode());//编号(8位字符串) 平台教师以O开头，家教教师以T开头
        targetObj.setEducation(srcObj.getEducation());//education
        targetObj.setName(srcObj.getName());//name
        targetObj.setSchool(srcObj.getSchool());//school
        targetObj.setProfessional(srcObj.getProfessional());//professional
        targetObj.setImages(srcObj.getImages());//图片集
        targetObj.setStatus(srcObj.getStatus());//状态 1:审核通过  2:审核中 3审核不通过
        return targetObj;
    }
}