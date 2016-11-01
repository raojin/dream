package com.qmdj.service.app.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qmdj.service.app.AppModelService;
import com.qmdj.service.bo.ModelBO;
import com.qmdj.service.common.Result;

@Service
public class AppModelServiceImpl implements AppModelService {

	@Override
	public Result<List<ModelBO>> queryModelList(List<String> moduleCodes, int moduleType) {
		return null;
	}

}
