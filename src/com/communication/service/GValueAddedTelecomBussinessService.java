package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.GValueAddedTelecomBussinessDao;
import com.communication.entity.GValueAddedTelecomBussiness;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GValueAddedTelecomBussinessService extends BaseService<GValueAddedTelecomBussiness> {

	@Autowired
	private void setDao(GValueAddedTelecomBussinessDao dao){
		super.setDao(dao);
	}
	
	public List<GValueAddedTelecomBussiness> queryByYear(Integer year) {
		List<GValueAddedTelecomBussiness> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	public boolean isExisted(Integer year,Integer month){
		List<GValueAddedTelecomBussiness> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GValueAddedTelecomBussiness> queryDataForCharts() {
		Order[] orders = {Order.desc("year"),Order.desc("month")};
		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GValueAddedTelecomBussiness> list = getDao().findByPager(pager, orders);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	public GValueAddedTelecomBussiness queryOneByYearAndMonth(Integer year,Integer month) {
		List<GValueAddedTelecomBussiness> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
