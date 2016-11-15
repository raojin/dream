package com.qmdj.service.app;

import java.util.List;
import java.util.Map;

import com.qmdj.biz.pogo.qo.ModelQO;
import com.qmdj.service.bo.ModelBO;
import com.qmdj.service.common.Result;

public interface AppModelService {

	/**
	 * 查询模块列表，按sort倒叙排序。只是展示中的坑位
	 *@param moduleCodes 不能为空
	 *@param moduleType  不能为空  1:图片 2 :文字
	 * 
	 * */
	public Result<Map<String,List<ModelBO>>>  queryModelList(List<ModelQO> querys);
}
