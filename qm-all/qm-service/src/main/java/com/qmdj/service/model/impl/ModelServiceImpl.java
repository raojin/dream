package com.qmdj.service.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.ModelDAO;
import com.qmdj.biz.domin.ModelDO;
import com.qmdj.biz.pogo.qo.ModelQO;
import com.qmdj.service.bo.ModelBO;
import com.qmdj.service.bo.util.ModelBeanUtil;
import com.qmdj.service.common.Pagination;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;
import com.qmdj.service.model.ModelService;

@Service
public class ModelServiceImpl implements ModelService {
	
	@Autowired
	private ModelDAO modelDAO;

	@Override
	public Result<Boolean> insertModel(ModelBO model) {
		Result<Boolean> re=new Result<Boolean>();
		if(model==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		ModelDO modeldo=ModelBeanUtil.qmdjModelBOToDO(model);
		try {
			modelDAO.insert(modeldo);
			re.setSuccess(true);
			re.setDate(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<Boolean> updateModel(ModelBO model) {
		Result<Boolean> re=new Result<Boolean>();
		if(model==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		ModelDO modeldo=ModelBeanUtil.qmdjModelBOToDO(model);
		if(modeldo.getId()==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		try{
		modelDAO.updateById(modeldo);
		re.setSuccess(true);
		re.setDate(true);
	} catch (Exception e) {
		re.setCode(ReCode.SYS_REEOR.getCode());
		re.setMessage(ReCode.SYS_REEOR.getMessage());
		e.printStackTrace();
	}
		return re;
	}

	@Override
	public Result<ModelBO> queryModelById(Long modelId) {
		Result<ModelBO> re=new Result<ModelBO>();
		if(modelId==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		try {
			ModelDO modelDO=modelDAO.findById(modelId);
			re.setDate(ModelBeanUtil.qmdjModelDOToBO(modelDO));
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Result<Pagination<ModelBO>> queryForPage(ModelQO queryQO) {
		Result<Pagination<ModelBO>> re=new Result<Pagination<ModelBO>>();
		if(queryQO==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		try {
			List<ModelDO> mdolDOlist= modelDAO.queryForPage(queryQO);
			List<ModelBO> list=new ArrayList<ModelBO>();
			if(mdolDOlist!=null){
				for(ModelDO model:mdolDOlist){
					list.add(ModelBeanUtil.qmdjModelDOToBO(model));
				}
			}
			Pagination<ModelBO> page =new Pagination<ModelBO>();
			int count= modelDAO.queryForPageCount(queryQO);
			page.setData(list);
			page.setTotalCount(count);
			page.setQuery(queryQO);
			re.setDate(page);
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		
		return re;
	}

}
