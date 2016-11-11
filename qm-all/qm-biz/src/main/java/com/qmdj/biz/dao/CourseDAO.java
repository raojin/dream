package com.qmdj.biz.dao;

import java.util.List;

import com.qmdj.biz.domin.CourseDO;
import com.qmdj.biz.pogo.qo.CourseQO;

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
     * 方法insert的功能描述：新增
     * 
     * @param record
     * @return int
     * <PRE>
     * author chenjin  
     * Date 2016年11月7日16:21:41
     * </PRE>
     */
    int insertSelective(CourseDO record);


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
    int update(CourseDO record);

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
    CourseDO getById(Long id);
    
    
    /**
     * 
     * 查询总条数
     * 
     * @param id
     * @return  List<CourseDO>
     * <PRE>
     * author xw  
     * Date 2016年11月04日
     * </PRE>
     */
    int queryForPageCount(CourseQO courseQO);
    
    /**
     * 
     * 分页查询
     * 
     * @param id
     * @return  List<CourseDO>
     * <PRE>
     * author xw  
     * Date 2016年11月04日
     * </PRE>
     */
    List<CourseDO> queryForPage(CourseQO courseQO);
    
}