package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FAppealLocalDao;
import com.communication.entity.FAppealLocal;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FAppealLocalService extends BaseService<FAppealLocal> {
	
	@Resource
	private void setDao(FAppealLocalDao dao) {
		super.setDao(dao);
	}

	public FAppealLocal queryByReportLogId(long reportLogId) {
		List<FAppealLocal> list = getDao().findAll(Order.desc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
