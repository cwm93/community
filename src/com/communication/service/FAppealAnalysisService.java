package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FAppealAnalysisDao;
import com.communication.entity.FAppealAnalysis;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FAppealAnalysisService extends BaseService<FAppealAnalysis> {
	
	@Resource
	private void setDao(FAppealAnalysisDao dao) {
		super.setDao(dao);
	}

	public FAppealAnalysis queryByReportLogId(long reportLogId) {
		List<FAppealAnalysis> list = getDao().findAll(Order.desc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
