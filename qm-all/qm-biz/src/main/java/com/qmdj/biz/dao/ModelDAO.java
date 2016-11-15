package com.qmdj.biz.dao;

import java.util.List;

import com.qmdj.biz.domin.ModelDO;
import com.qmdj.biz.pogo.qo.ModelQO;

/**
 *  DAO接口
 * 
 * @Author chenjin 
 * @Date 2016年11月01日
 */
public interface ModelDAO{

    /**
     * 
     * 方法insert的功能描述：新增
     * 
     * @param record
     * @return int
     * <PRE>
     * author chenjin  
     * Date 2016年11月01日
     * </PRE>
     */
    int insert(ModelDO record);

    /**
     * 
     * 方法deleteById的功能描述：根据Id删除
     * 
     * @param id
     * @return int
     * <PRE>
     * author chenjin  
     * Date 2016年11月01日
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
     * Date 2016年11月01日
     * </PRE>
     */
    int updateById(ModelDO record);

    /**
     * 
     * 方法findById的功能描述：根据Id查询
     * 
     * @param id
     * @return QmdjModelDO
     * <PRE>
     * author chenjin  
     * Date 2016年11月01日
     * </PRE>
     */
    ModelDO findById(Long id);
    
    
    /**
     * 
     * 分页查询
     * */
    List<ModelDO> queryForPage(ModelQO queryQO);
    
    /**
     * 
     * 分页查询条数
     * */
    int queryForPageCount(ModelQO queryQO);
    
    
    /**
     * 
     * 条件查询
     * */
    List<ModelDO> findByCondition(ModelDO modelDO);
    
}