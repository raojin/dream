package com.qmdj.biz.dao;

import com.qmdj.biz.domin.CourseDO;

/**
 *  DAO接口
 * 
 * @Author chenjin 
 * @Date 2016年11月04日
 */
public interface CourseDAO{

    /**
     * 
     * 方法insert的功能描述：新增
     * 
     * @param record
     * @return int
     * <PRE>
     * author chenjin  
     * Date 2016年11月04日
     * </PRE>
     */
    int insert(CourseDO record);

    /**
     * 
     * 方法deleteById的功能描述：根据Id删除
     * 
     * @param id
     * @return int
     * <PRE>
     * author chenjin  
     * Date 2016年11月04日
     * </PRE>
     */
    int deleteById(Long id);

    /**
     * 
     * 方法updateById的功能描述：根据Id更新
     * 
     * @param record
     * @return int
     * <PRE>
     * author chenjin  
     * Date 2016年11月04日
     * </PRE>
     */
    int updateById(CourseDO record);

    /**
     * 
     * 方法findById的功能描述：根据Id查询
     * 
     * @param id
     * @return QmdjCourseDO
     * <PRE>
     * author chenjin  
     * Date 2016年11月04日
     * </PRE>
     */
    CourseDO findById(Long id);
}