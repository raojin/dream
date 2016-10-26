package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.UserDO;
import com.qmdj.service.bo.UserBO;

/**
 * 类QmdjUserBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年10月25日
 */
public class UserBeanUtil {

    private UserBeanUtil(){
    }

    public static UserDO qmdjUserBOToDO(UserBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        UserDO targetObj = new UserDO();
        targetObj.setId(srcObj.getUserId());//主键id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//修改时间
        targetObj.setLoginName(srcObj.getLoginName());//登录名
        targetObj.setPassword(srcObj.getPassword());//密码
        targetObj.setIdentity(srcObj.getIdentity());//身份 1:教师,2:家长,3:学生,4:机构教师,5:机构负责人
        targetObj.setName(srcObj.getName());//姓名
        targetObj.setSex(srcObj.getSex());//性别 1男 2女
        targetObj.setLinkPhone(srcObj.getLinkPhone());//联系方式
        targetObj.setIntroduce(srcObj.getIntroduce());//介绍
        targetObj.setImage(srcObj.getImage());//头像
        targetObj.setStatus(srcObj.getStatus());//状态 1:正常，2删除
        targetObj.setEmail(srcObj.getEmail());//邮箱
        targetObj.setAge(srcObj.getAge());//age
        return targetObj;
    }

    public static UserBO qmdjUserDOToBO(UserDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        UserBO targetObj = new UserBO();
        targetObj.setUserId(srcObj.getId());//主键id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//修改时间
        targetObj.setLoginName(srcObj.getLoginName());//登录名
        targetObj.setPassword(srcObj.getPassword());//密码
        targetObj.setIdentity(srcObj.getIdentity());//身份 1:教师,2:家长,3:学生,4:机构教师,5:机构负责人
        targetObj.setName(srcObj.getName());//姓名
        targetObj.setSex(srcObj.getSex());//性别 1男 2女
        targetObj.setLinkPhone(srcObj.getLinkPhone());//联系方式
        targetObj.setIntroduce(srcObj.getIntroduce());//介绍
        targetObj.setImage(srcObj.getImage());//头像
        targetObj.setStatus(srcObj.getStatus());//状态 1:正常，2删除
        targetObj.setEmail(srcObj.getEmail());//邮箱
        targetObj.setAge(srcObj.getAge());//age
        return targetObj;
    }
}