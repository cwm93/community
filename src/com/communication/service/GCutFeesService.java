package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.GCutFeesDao;
import com.communication.entity.GCutFees;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GCutFeesService extends BaseService<GCutFees> {
	
	@Autowired
	private void setDao(GCutFeesDao dao){
		super.setDao(dao);
	}
	
	public List<GCutFees> queryByYear(Integer year) {
		List<GCutFees> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	public boolean isExisted(Integer year,Integer month){
		List<GCutFees> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GCutFees> queryDataForCharts() {
		Order[] orders = { Order.desc("year"), Order.desc("month") };

		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GCutFees> list = getDao().findByPager(pager, orders);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public GCutFees queryOneByYearAndMonth(Integer year, Integer month) {
		List<GCutFees> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
