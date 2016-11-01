package com.qmdj.service.bo;

/**
 * 类QmdjModelBO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月01日
 */
public class ModelBO {
    /**
     * id
     */
    private Integer qmdjModelId;
    /**
     * gmtCreate
     */
    private java.util.Date gmtCreate;
    /**
     * gmtModified
     */
    private java.util.Date gmtModified;
    /**
     * 模块编码
     */
    private String moduleCode;
    /**
     * 图片地址
     */
    private String picUrl;
    /**
     * text
     */
    private String text;
    /**
     * 模块类型 1:图片 2 :文字
     */
    private Integer moduleType;
    /**
     * 图片链接目标地址
     */
    private String linkUrl;
    /**
     * 模块名字
     */
    private String moduleName;
    /**
     * 排序值，越大与靠前
     */
    private Integer sort;
    /**
     * 状态 2：隐藏 1：显示
     */
    private Integer status;
    /**
     * 开始时间
     */
    private java.util.Date startTime;
    /**
     * 结束时间
     */
    private java.util.Date endTime;

    public ModelBO() {
    }

    public Integer getQmdjModelId(){
        return qmdjModelId;
    }

    public void setQmdjModelId(Integer qmdjModelId){
        this.qmdjModelId = qmdjModelId;
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
    public String getModuleCode(){
        return moduleCode;
    }

    public void setModuleCode(String moduleCode){
        this.moduleCode = moduleCode;
    }
    public String getPicUrl(){
        return picUrl;
    }

    public void setPicUrl(String picUrl){
        this.picUrl = picUrl;
    }
    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
    public Integer getModuleType(){
        return moduleType;
    }

    public void setModuleType(Integer moduleType){
        this.moduleType = moduleType;
    }
    public String getLinkUrl(){
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl){
        this.linkUrl = linkUrl;
    }
    public String getModuleName(){
        return moduleName;
    }

    public void setModuleName(String moduleName){
        this.moduleName = moduleName;
    }
    public Integer getSort(){
        return sort;
    }

    public void setSort(Integer sort){
        this.sort = sort;
    }
    public Integer getStatus(){
        return status;
    }

    public void setStatus(Integer status){
        this.status = status;
    }
    public java.util.Date getStartTime(){
        return startTime;
    }

    public void setStartTime(java.util.Date startTime){
        this.startTime = startTime;
    }
    public java.util.Date getEndTime(){
        return endTime;
    }

    public void setEndTime(java.util.Date endTime){
        this.endTime = endTime;
    }
}