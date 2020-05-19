package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.GCodeClassificationDao;
import com.communication.entity.GCodeClassification;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class GCodeClassificationService extends BaseService<GCodeClassification> {
	
	@Resource
	private void setDao(GCodeClassificationDao dao){
		super.setDao(dao);
	}

	public long countByCodeClass(String codeClass,Integer batch) {
		long counter = getDao().countByProperty("id", Property.eq("classification", codeClass), Property.eq("batch.id", batch));
		return counter;
	}

	public long countAll(Integer batch) {
		long counter = getDao().countByProperty("id", Property.eq("batch.id", batch));
		return counter;
	}

	public List<GCodeClassification> queryLastBatch(Integer batch) {
		List<GCodeClassification> list = getDao().findAll(Order.desc("id"),Property.eq("batch.id", batch));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public List<GCodeClassification> queryByBatch(Integer batch) {
		List<GCodeClassification> list = getDao().findAll(Order.desc("id"),Property.eq("batch.id", batch));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

}
