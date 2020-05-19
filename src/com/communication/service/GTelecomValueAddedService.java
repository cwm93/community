package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.GTelecomValueAddedDao;
import com.communication.entity.GTelecomValueAdded;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class GTelecomValueAddedService extends BaseService<GTelecomValueAdded> {
	
	@Resource
	private void setDao(GTelecomValueAddedDao dao){
		super.setDao(dao);
	}

	public List<GTelecomValueAdded> queryByYearMonth(String yearMonth) {
		List<GTelecomValueAdded> list = getDao().findAll(Order.asc("id"), Property.eq("yearMonth", yearMonth));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
	
	public boolean isExisted(Integer year,Integer month){
		List<GTelecomValueAdded> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public Long countByBatch(Integer batch,String propertyName,String propertyValue) {
		Long counter = getDao().countByProperty("id",Property.eq("batch.id", batch), Property.eq(propertyName, propertyValue));
		return counter;
	}
	
	public Long countZmByBatch(Integer batch,String propertyName,String propertyValue) {
		Long counter = getDao().countByProperty("id",Property.like("code", "自贸"),Property.eq("batch.id", batch), Property.eq(propertyName, propertyValue));
		return counter;
	}

}
