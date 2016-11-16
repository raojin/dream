package com.qmdj.service.bo;

/**
 * 类QmdjImageBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月16日
 */
public class ImageBO {
    /**
     * id
     */
    private Long imageId;
    /**
     * 创建时间
     */
    private java.util.Date gmtCreate;
    /**
     * gmtModified
     */
    private java.util.Date gmtModified;
    /**
     * 相册Id
     */
    private Long albumId;
    /**
     * 图片地址
     */
    private String picUrl;
    /**
     * 图片名称
     */
    private String picName;
    /**
     * 状态 1正常  100 删除
     */
    private Integer status;

    public ImageBO() {
    }

   
    public java.util.Date getGmtCreate(){
        return gmtCreate;
    }

    public void setGmtCreate(java.util.Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }
    public java.util.Date getGmtModified(){
        return gmtModified;
    }

    public void setGmtModified(java.util.Date gmtModified){
        this.gmtModified = gmtModified;
    }
   
    public String getPicUrl(){
        return picUrl;
    }

    public void setPicUrl(String picUrl){
        this.picUrl = picUrl;
    }
    public String getPicName(){
        return picName;
    }

    public void setPicName(String picName){
        this.picName = picName;
    }
    public Integer getStatus(){
        return status;
    }

    public void setStatus(Integer status){
        this.status = status;
    }


	public Long getImageId() {
		return imageId;
	}


	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}


	public Long getAlbumId() {
		return albumId;
	}


	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
}