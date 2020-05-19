package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.GCodeClassificationBatchDao;
import com.communication.entity.GCodeClassificationBatch;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class GCodeClassificationBatchService extends BaseService<GCodeClassificationBatch> {
	
	@Autowired
	private void setDao(GCodeClassificationBatchDao dao){
		super.setDao(dao);
	}

	public GCodeClassificationBatch queryOneByYearAndMonth(Integer year,Integer month) {
		List<GCodeClassificationBatch> list =  getDao().findAll(Order.desc("id"), Property.eq("year",year), Property.eq("month", month));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public GCodeClassificationBatch queryLastOne() {
		List<GCodeClassificationBatch> list =  getDao().findAll(Order.desc("id"));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
