package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.GCheckJobListDao;
import com.communication.entity.GCheckJobList;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class GCheckJobListService extends BaseService<GCheckJobList> {
	
	@Autowired
	private void setDao(GCheckJobListDao dao) {
		super.setDao(dao);
	}
	
	public List<GCheckJobList> queryByYear(Integer year){
		List<GCheckJobList> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}
	
	public boolean isExisted(Integer year, Integer month) {
		List<GCheckJobList> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}
	
	
	public GCheckJobList queryOneByYearAndMonth(Integer year, Integer month) {
		List<GCheckJobList> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
