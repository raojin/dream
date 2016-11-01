package com.qmdj.service.app;

import java.util.List;

import com.qmdj.service.bo.ModelBO;
import com.qmdj.service.common.Result;

public interface AppModelService {

	/**
	 * 查询模块列表，按sort倒叙排序。只是展示中的坑位
	 *@param moduleCodes 不能为空
	 *@param moduleType  moduleType=0时，文字，图片坑位一起查询
	 * 
	 * */
	public Result<List<ModelBO>>  queryModelList(List<String> moduleCodes,int moduleType);
}
