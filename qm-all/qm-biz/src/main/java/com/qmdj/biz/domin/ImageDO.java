package com.qmdj.biz.domin;

/**
 * 类QmdjImageDO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月16日
 */
public class ImageDO extends BaseDO{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

    public ImageDO() {
    }
    
    public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
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
}