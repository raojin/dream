package com.qmdj.biz.dao;

import com.qmdj.biz.domin.PublishCourseDO;

/**
 *  DAO接口
 * 
 * @Author chenjin 
 * @Date 2016年10月27日
 */
public interface PublishCourseDao{

    /**
     * 
     * 方法insert的功能描述：新增
     * 
     * @param record
     * @return int
     * <PRE>
     * author chenjin  
     * Date 2016年10月27日
     * </PRE>
     */
    int insert(PublishCourseDO record);

    /**
     * 
     * 方法deleteById的功能描述：根据Id删除
     * 
     * @param id
     * @return int
     * <PRE>
     * author chenjin  
     * Date 2016年10月27日
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
     * Date 2016年10月27日
     * </PRE>
     */
    int updateById(PublishCourseDO record);

    /**
     * 
     * 方法findById的功能描述：根据Id查询
     * 
     * @param id
     * @return QmdjPublishCourseDO
     * <PRE>
     * author chenjin  
     * Date 2016年10月27日
     * </PRE>
     */
    PublishCourseDO findById(Long id);
}