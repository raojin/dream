package com.qmdj.service.model;

import com.qmdj.biz.pogo.qo.ModelQO;
import com.qmdj.service.bo.ModelBO;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.Result;


/**
 * 
 * 营销位
 * */
public interface ModelService {
	
	/**
	 * 
	 *插入营销位 
	 * */
	public Result<Boolean> insertModel(ModelBO model);

	/**
	 * 
	 * 更新营销位
	 * */
	public Result<Boolean> updateModel(ModelBO model);
	
	/**
	 * 
	 * 根据Id查询营销位
	 * */
	public Result<ModelBO> queryModelById(Long modelId);
	
	/**
	 * 
	 * 分页查询
	 * */
	public Result<Pagination<ModelBO>> queryForPage(ModelQO queryQO);
	
}
