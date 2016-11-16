package com.qmdj.biz.domin;

/**
 * 类QmdjCourseTheacherDO.java的实现描述：
 * 
 * @Author chenjin 
 * @Date 2016年11月15日
 */
public class CourseTheacherDO extends BaseDO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 课程Id
     */
    private Long courseId;
    /**
     * 教师ID
     */
    private Long teacherId;
    
    /**
     * 状态 1正常 100删除
     */
    private Integer status;

    public CourseTheacherDO() {
    }
	public Long getCourseId() {
		return courseId;
	}


	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}


	public Long getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
    
}