package com.qmdj.service.app.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmdj.biz.dao.ModelDAO;
import com.qmdj.biz.domin.ModelDO;
import com.qmdj.biz.pogo.qo.ModelQO;
import com.qmdj.service.app.AppModelService;
import com.qmdj.service.bo.ModelBO;
import com.qmdj.service.bo.util.ModelBeanUtil;
import com.qmdj.service.common.ReCode;
import com.qmdj.service.common.Result;

@Service
public class AppModelServiceImpl implements AppModelService {

	@Autowired
	private ModelDAO modelDAO;
	
	@Override
	public Result<List<ModelBO>> queryModelList(List<String> moduleCodes, int moduleType) {
		Result<List<ModelBO>> re=new Result<List<ModelBO>>();
		if(moduleCodes==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		
		ModelQO modelQO=new ModelQO();
		modelQO.setModuleType(moduleType);
		modelQO.setModuleCodes(moduleCodes);
		try {
			List<ModelDO> listDO= modelDAO.findByModelQO(modelQO);
			List<ModelBO> list=new ArrayList<>();
			if(listDO!=null){
				for(ModelDO m:listDO){
					list.add(ModelBeanUtil.qmdjModelDOToBO(m));
				}
			}
			re.setDate(list);
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}

}
