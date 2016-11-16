package com.qmdj.service.bo.util;

import com.qmdj.biz.domin.AlbumDO;
import com.qmdj.service.bo.AlbumBO;

/**
 * 类QmdjAlbumBeanUtil.java的实现描述：工具类
 * 
 * @Author chenjin 
 * @Date 2016年11月16日
 */
public class AlbumBeanUtil {

    private AlbumBeanUtil(){
    }

    public static AlbumDO qmdjAlbumBOToDO(AlbumBO srcObj) {
        if (srcObj == null) {
            return null;
        }
        AlbumDO targetObj = new AlbumDO();
        targetObj.setId(srcObj.getAlbumId());//id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//修改时间
        targetObj.setStutas(srcObj.getStutas());//状态 1 正常，100 删除
        targetObj.setName(srcObj.getName());//相册名字
        targetObj.setParentName(srcObj.getParentName());//所属者名称，家教教师为教师名称，机构为机构名称
        targetObj.setParentid(srcObj.getParentid());//相册所属者，org为orgId ，家教教师创建为userId，
        return targetObj;
    }

    public static AlbumBO qmdjAlbumDOToBO(AlbumDO srcObj) {
        if (srcObj == null) {
            return null;
        }
        AlbumBO targetObj = new AlbumBO();
        targetObj.setAlbumId(srcObj.getId());//id
        targetObj.setGmtCreate(srcObj.getGmtCreate());//创建时间
        targetObj.setGmtModified(srcObj.getGmtModified());//修改时间
        targetObj.setStutas(srcObj.getStutas());//状态 1 正常，100 删除
        targetObj.setName(srcObj.getName());//相册名字
        targetObj.setParentName(srcObj.getParentName());//所属者名称，家教教师为教师名称，机构为机构名称
        targetObj.setParentid(srcObj.getParentid());//相册所属者，org为orgId ，家教教师创建为userId，
        return targetObj;
    }
}