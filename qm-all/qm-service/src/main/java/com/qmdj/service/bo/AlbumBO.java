package com.qmdj.service.bo;

/**
 * 类QmdjAlbumBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月16日
 */
public class AlbumBO {
    /**
     * id
     */
    private Long albumId;
    /**
     * 创建时间
     */
    private java.util.Date gmtCreate;
    /**
     * 修改时间
     */
    private java.util.Date gmtModified;
    /**
     * 状态 1 正常，100 删除
     */
    private Integer stutas;
    /**
     * 相册名字
     */
    private String name;
    /**
     * 所属者名称，家教教师为教师名称，机构为机构名称
     */
    private String parentName;
    /**
     * 相册所属者，org为orgId ，家教教师创建为userId，
     */
    private Long parentid;

    public AlbumBO() {
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
    public Integer getStutas(){
        return stutas;
    }

    public void setStutas(Integer stutas){
        this.stutas = stutas;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getParentName(){
        return parentName;
    }

    public void setParentName(String parentName){
        this.parentName = parentName;
    }


	public Long getAlbumId() {
		return albumId;
	}


	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}


	public Long getParentid() {
		return parentid;
	}


	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
}