package com.qmdj.biz.dao;

import java.util.List;

import com.qmdj.biz.domin.CourseTypeDO;
import com.qmdj.biz.pogo.qo.CourseTypeQO;

/**
 *  DAO接口
 * 
 * @Author chenjin 
 * @Date 2016年11月04日
 */
public interface CourseTypeDAO{

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
    int insertSelective(CourseTypeDO record);

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
    int updateById(CourseTypeDO record);

    /**
     * 
     * 方法findById的功能描述：根据Id查询
     * 
     * @param id
     * @return QmdjCourseTypeDO
     * <PRE>
     * author chenjin  
     * Date 2016年11月04日
     * </PRE>
     */
    CourseTypeDO findById(Long id);
    
    
    /**
     * author chenjin 
     * 分页查询
     * */
    List<CourseTypeDO> queryForPage(CourseTypeQO queryQO);
    
    
    /**
     * author chenjin 
     * 分页查询条数
     * */
    int queryForPageCount(CourseTypeQO queryQO);
    
    
    
    /**
     * 多条件查询
     * */
    List<CourseTypeDO> findByCondition(CourseTypeDO courseTypeDO);
}