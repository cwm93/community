package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FPriceSpeedDao;
import com.communication.entity.FPriceSpeed;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FPriceSpeedService extends BaseService<FPriceSpeed> {
	
	@Resource
	private void setDao(FPriceSpeedDao dao){
		super.setDao(dao);
	}

	public FPriceSpeed queryByReportLogId(long reportLogId) {
		List<FPriceSpeed> list = getDao().findAll(Order.desc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
