package com.qmdj.biz.domin;

/**
 * 类QmdjAlbumDO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月16日
 */
public class AlbumDO extends BaseDO {
	
	private static final long serialVersionUID = 1L;
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

    public AlbumDO() {
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
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
}