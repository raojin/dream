package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.OrganizationDO;
import com.qmdj.service.bo.OrganizationBO;
import com.qmdj.service.common.date.DateStyle;
import com.qmdj.service.common.date.DateUtil;

/**
 * 类QmdjOrganizationBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年10月25日
 */
public class OrganizationBeanUtil {

    private OrganizationBeanUtil(){
    }

    public static OrganizationDO qmdjOrganizationBOToDO(OrganizationBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        OrganizationDO targetObj = new OrganizationDO();
        targetObj.setId(srcObj.getOrganizationId());//主键ID
        targetObj.setImage(srcObj.getImage());//首图
        targetObj.setName(srcObj.getName());//机构名称
        targetObj.setAddrName(srcObj.getAddrName());//机构详细地址
        targetObj.setTitle(srcObj.getTitle());//标题
        targetObj.setPhone(srcObj.getPhone());//联系方式
        targetObj.setUserId(srcObj.getUserId());//负责人
        targetObj.setDetail(srcObj.getDetail());//机构介绍
        targetObj.setStartTime(DateUtil.StringToDate(srcObj.getStartTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));//开始时间
        targetObj.setEndTime(DateUtil.StringToDate(srcObj.getEndTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));//介绍时间
        targetObj.setImages(srcObj.getImages());//图片集
        targetObj.setStatus(srcObj.getStatus());//状态 1:审核中（不展示,默认） 2:审核通过（展示） 3:审核不通过（不展示）4:删除
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//最后操作时间
        targetObj.setIsDel(srcObj.getIsDel());//是否删除 1未删除 2已删除
        targetObj.setUserName(srcObj.getUserName());//负责人名字
        targetObj.setSort(srcObj.getSort());//排序值
        targetObj.setTags(srcObj.getSort());//标签
        return targetObj;
    }

    public static OrganizationBO qmdjOrganizationDOToBO(OrganizationDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        OrganizationBO targetObj = new OrganizationBO();
        targetObj.setOrganizationId(srcObj.getId());//主键ID
        targetObj.setImage(srcObj.getImage());//首图
        targetObj.setName(srcObj.getName());//机构名称
        targetObj.setAddrName(srcObj.getAddrName());//机构详细地址
        targetObj.setTitle(srcObj.getTitle());//标题
        targetObj.setPhone(srcObj.getPhone());//联系方式
        targetObj.setUserId(srcObj.getUserId());//负责人
        targetObj.setDetail(srcObj.getDetail());//机构介绍
        targetObj.setStartTime(DateUtil.dateToString(srcObj.getStartTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));//开始时间
        targetObj.setEndTime(DateUtil.dateToString(srcObj.getEndTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));//介绍时间
        targetObj.setImages(srcObj.getImages());//图片集
        targetObj.setStatus(srcObj.getStatus());//状态 1:审核中（不展示,默认） 2:审核通过（展示） 3:审核不通过（不展示）4:删除
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//最后操作时间
        targetObj.setIsDel(srcObj.getIsDel());//是否删除 1未删除 2已删除
        targetObj.setUserName(srcObj.getUserName());//负责人名字
        targetObj.setSort(srcObj.getSort());//排序值
        targetObj.setTags(srcObj.getSort());//标签
        return targetObj;
    }
    
    public static OrganizationBO appHomeOrganizationDOToBO(OrganizationDO srcObj,Long lowestPrice) {
        if (srcObj == null) {
            return null;
        }
        OrganizationBO targetObj = new OrganizationBO();
        targetObj.setOrganizationId(srcObj.getId());//主键ID
        targetObj.setImage(srcObj.getImage());//首图
        targetObj.setName(srcObj.getName());//机构名称
        targetObj.setTitle(srcObj.getTitle());//标题
        targetObj.setSort(srcObj.getSort());//排序值
        targetObj.setLowestPrice(lowestPrice);
        targetObj.setTags(srcObj.getTags());//标签 占时还没有这个功能
        return targetObj;
    }
}