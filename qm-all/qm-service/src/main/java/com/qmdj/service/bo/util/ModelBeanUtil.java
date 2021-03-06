package com.qmdj.service.bo.util;

import java.util.ArrayList;
import java.util.List;

import com.qmdj.biz.domin.ModelDO;
import com.qmdj.service.bo.ModelBO;
import com.qmdj.service.common.date.DateStyle;
import com.qmdj.service.common.date.DateUtil;

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
        targetObj.setId(srcObj.getModelId());//id
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
        targetObj.setStartTime(DateUtil.StringToDate(srcObj.getStartTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));//开始时间
        targetObj.setEndTime(DateUtil.StringToDate(srcObj.getEndTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));//介绍时间
        return targetObj;
    }

    
    public static ModelBO qmdjModelDOToBO(ModelDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        ModelBO targetObj = new ModelBO();
        targetObj.setModelId(srcObj.getId());//id
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
        targetObj.setStartTime(DateUtil.dateToString(srcObj.getStartTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));//开始时间
        targetObj.setEndTime(DateUtil.dateToString(srcObj.getEndTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));//介绍时间
        return targetObj;
    }
    
    
    public static List<ModelBO> qmdjModelDOToBOList(List<ModelDO> listDO){
    	if(listDO==null){
    		return null;
    	}
    	List<ModelBO>  modelBOs=new ArrayList<ModelBO>();
    	for(ModelDO modelDO:listDO){
    		modelBOs.add(qmdjModelDOToBO(modelDO));
    	}
    	return modelBOs;
    }
    
}