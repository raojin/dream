package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.ModelDO;
import com.qmdj.service.bo.ModelBO;

/**
 * 类QmdjModelBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年11月01日
 */
public class ModelBeanUtil {

    private ModelBeanUtil(){
    }

    public static ModelDO qmdjModelBOToDO(ModelBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        ModelDO targetObj = new ModelDO();
        targetObj.setId(srcObj.getQmdjModelId());//id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//gmtCreate
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        targetObj.setModuleCode(srcObj.getModuleCode());//模块编码
        targetObj.setPicUrl(srcObj.getPicUrl());//图片地址
        targetObj.setText(srcObj.getText());//text
        targetObj.setModuleType(srcObj.getModuleType());//模块类型 1:图片 2 :文字
        targetObj.setLinkUrl(srcObj.getLinkUrl());//图片链接目标地址
        targetObj.setModuleName(srcObj.getModuleName());//模块名字
        targetObj.setSort(srcObj.getSort());//排序值，越大与靠前
        targetObj.setStatus(srcObj.getStatus());//状态 2：隐藏 1：显示
        targetObj.setStartTime(srcObj.getStartTime());//开始时间
        targetObj.setEndTime(srcObj.getEndTime());//结束时间
        return targetObj;
    }

    public static ModelBO qmdjModelDOToBO(ModelDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        ModelBO targetObj = new ModelBO();
        targetObj.setQmdjModelId(srcObj.getId());//id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//gmtCreate
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        targetObj.setModuleCode(srcObj.getModuleCode());//模块编码
        targetObj.setPicUrl(srcObj.getPicUrl());//图片地址
        targetObj.setText(srcObj.getText());//text
        targetObj.setModuleType(srcObj.getModuleType());//模块类型 1:图片 2 :文字
        targetObj.setLinkUrl(srcObj.getLinkUrl());//图片链接目标地址
        targetObj.setModuleName(srcObj.getModuleName());//模块名字
        targetObj.setSort(srcObj.getSort());//排序值，越大与靠前
        targetObj.setStatus(srcObj.getStatus());//状态 2：隐藏 1：显示
        targetObj.setStartTime(srcObj.getStartTime());//开始时间
        targetObj.setEndTime(srcObj.getEndTime());//结束时间
        return targetObj;
    }
}