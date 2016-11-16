package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.ImageDO;
import com.qmdj.service.bo.ImageBO;

/**
 * 类ImageBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年11月16日
 */
public class ImageBeanUtil {

    private ImageBeanUtil(){
    }

    public static ImageDO ImageBOToDO(ImageBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        ImageDO targetObj = new ImageDO();
        targetObj.setId(srcObj.getImageId());//id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        targetObj.setAlbumId(srcObj.getAlbumId());//相册Id
        targetObj.setPicUrl(srcObj.getPicUrl());//图片地址
        targetObj.setPicName(srcObj.getPicName());//图片名称
        targetObj.setStatus(srcObj.getStatus());//状态 1正常  100 删除
        return targetObj;
    }

    public static ImageBO ImageDOToBO(ImageDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        ImageBO targetObj = new ImageBO();
        targetObj.setImageId(srcObj.getId());//id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//gmtModified
        targetObj.setAlbumId(srcObj.getAlbumId());//相册Id
        targetObj.setPicUrl(srcObj.getPicUrl());//图片地址
        targetObj.setPicName(srcObj.getPicName());//图片名称
        targetObj.setStatus(srcObj.getStatus());//状态 1正常  100 删除
        return targetObj;
    }
}