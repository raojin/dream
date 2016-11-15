package com.qmdj.service.app.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Result<Map<String, List<ModelBO>>> queryModelList(List<ModelQO> querys) {
		Result<Map<String, List<ModelBO>>> re=new Result<Map<String, List<ModelBO>>>();
		if(querys==null){
			re.setCode(ReCode.PARAM_ERROR.getCode());
			re.setMessage(ReCode.PARAM_ERROR.getMessage());
			return re;
		}
		
		Map<String, List<ModelBO>> map=new HashMap<String,List<ModelBO>>();
		try {
			for(ModelQO query:querys){
				if(query.checkCodeAndType()){
					ModelDO querym=new ModelDO();
					querym.setModuleCode(query.getModuleCode());
					querym.setModuleType(query.getModuleType());
					querym.setStatus(1);
					List<ModelDO> listDO=modelDAO.findByCondition(querym);
					map.put(query.getModuleCode(),ModelBeanUtil.qmdjModelDOToBOList(listDO));
				}
			}
			re.setDate(map);
			re.setSuccess(true);
		} catch (Exception e) {
			re.setCode(ReCode.SYS_REEOR.getCode());
			re.setMessage(ReCode.SYS_REEOR.getMessage());
			e.printStackTrace();
		}
		return re;
	}


}
