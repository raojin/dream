package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.ArticleDO;
import com.qmdj.service.bo.ArticleBO;

/**
 * 类QmdjArticleBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年11月01日
 */
public class ArticleBeanUtil {

    private ArticleBeanUtil(){
    }

    public static ArticleDO qmdjArticleBOToDO(ArticleBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        ArticleDO targetObj = new ArticleDO();
        targetObj.setId(srcObj.getQmdjArticleId());//id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//gmtCreate
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        targetObj.setTitle(srcObj.getTitle());//标题
        targetObj.setContent(srcObj.getContent());//内容
        targetObj.setSort(srcObj.getSort());//排序值，越大越靠前
        return targetObj;
    }

    public static ArticleBO qmdjArticleDOToBO(ArticleDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        ArticleBO targetObj = new ArticleBO();
        targetObj.setQmdjArticleId(srcObj.getId());//id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//gmtCreate
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        targetObj.setTitle(srcObj.getTitle());//标题
        targetObj.setContent(srcObj.getContent());//内容
        targetObj.setSort(srcObj.getSort());//排序值，越大越靠前
        return targetObj;
    }
}