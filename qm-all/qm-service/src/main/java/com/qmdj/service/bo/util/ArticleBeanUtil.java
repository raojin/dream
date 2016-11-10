package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.ArticleDO;
import com.qmdj.service.bo.ArticleBO;
import com.qmdj.service.common.date.DateStyle;
import com.qmdj.service.common.date.DateUtil;

/**
 * 类QmdjArticleBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年11月01日
 */
public class ArticleBeanUtil {

    private ArticleBeanUtil(){
    }

    public static ArticleDO articleBOToDO(ArticleBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        ArticleDO targetObj = new ArticleDO();
        targetObj.setId(srcObj.getArticleId());//id
        targetObj.setGmtCreate(DateUtil.StringToDate(srcObj.getGmtCreate(), DateStyle.YYYY_MM_DD_HH_MM_SS));//开始时间
        targetObj.setGmtModified(DateUtil.StringToDate(srcObj.getGmtModified(), DateStyle.YYYY_MM_DD_HH_MM_SS));//介绍时间
        targetObj.setTitle(srcObj.getTitle());//标题
        targetObj.setContent(srcObj.getContent());//内容
        targetObj.setSort(srcObj.getSort());//排序值，越大越靠前
        targetObj.setAuthor(srcObj.getAuthor());
        targetObj.setDigest(srcObj.getDigest());
        targetObj.setStatus(srcObj.getStatus());
        return targetObj;
    }

    public static ArticleBO articleDOToBO(ArticleDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        ArticleBO targetObj = new ArticleBO();
        targetObj.setArticleId(srcObj.getId());//id
        targetObj.setGmtCreate(DateUtil.dateToString(srcObj.getGmtCreate(), DateStyle.YYYY_MM_DD_HH_MM_SS));
        targetObj.setGmtModified(DateUtil.dateToString(srcObj.getGmtModified(), DateStyle.YYYY_MM_DD_HH_MM_SS));
        targetObj.setTitle(srcObj.getTitle());//标题
        targetObj.setContent(srcObj.getContent());//内容
        targetObj.setSort(srcObj.getSort());//排序值，越大越靠前
        targetObj.setAuthor(srcObj.getAuthor());
        targetObj.setDigest(srcObj.getDigest());
        targetObj.setStatus(srcObj.getStatus());
        return targetObj;
    }
}