package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FResaleRealNameRegistrationDao;
import com.communication.entity.FResaleRealNameRegistration;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FResaleRealNameRegistrationService extends BaseService<FResaleRealNameRegistration> {

	
	@Resource
	private void setDao(FResaleRealNameRegistrationDao dao){
		super.setDao(dao);
	}

	public FResaleRealNameRegistration queryByReportLogId(long reportLogId) {
		List<FResaleRealNameRegistration>  list = getDao().findAll(Order.asc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
