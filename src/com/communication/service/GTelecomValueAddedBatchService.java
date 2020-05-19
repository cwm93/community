package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.GTelecomValueAddedBatchDao;
import com.communication.entity.GTelecomValueAddedBatch;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class GTelecomValueAddedBatchService extends BaseService<GTelecomValueAddedBatch> {

	@Autowired
	private void setDao(GTelecomValueAddedBatchDao dao) {
		super.setDao(dao);
	}

	public GTelecomValueAddedBatch queryByYearMonth(Integer year,Integer month) {
		List<GTelecomValueAddedBatch> list = getDao().findAll(Order.desc("id"), Property.eq("year", year), Property.eq("month", month));
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	public GTelecomValueAddedBatch queryLatestOne() {
		List<GTelecomValueAddedBatch> list = getDao().findAll(Order.desc("id"));
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}
