package com.qmdj.biz.dao;
import com.qmdj.biz.domin.ImageDO;

/**
 *  DAO接口
 * 
 * @Author chenjin 
 * @Date 2016年11月16日
 */
public interface ImageDAO{

    /**
     * 
     * 方法insert的功能描述：新增
     * 
     * @param record
     * @return int
     * <PRE>
     * author chenjin  
     * Date 2016年11月16日
     * </PRE>
     */
    int insert(ImageDO record);

    /**
     * 
     * 方法deleteById的功能描述：根据Id删除
     * 
     * @param id
     * @return int
     * <PRE>
     * author chenjin  
     * Date 2016年11月16日
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
     * Date 2016年11月16日
     * </PRE>
     */
    int updateById(ImageDO record);

    /**
     * 
     * 方法findById的功能描述：根据Id查询
     * 
     * @param id
     * @return ImageDO
     * <PRE>
     * author chenjin  
     * Date 2016年11月16日
     * </PRE>
     */
    ImageDO findById(Long id);
}