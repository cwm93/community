package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.GMillionUserComplaintRateDao;
import com.communication.entity.GMillionUserComplaintRate;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GMillionUserComplaintRateService extends BaseService<GMillionUserComplaintRate> {

	@Autowired
	private void setDao(GMillionUserComplaintRateDao dao){
		super.setDao(dao);
	}

	public List<GMillionUserComplaintRate> queryByYear(Integer year) {
		List<GMillionUserComplaintRate> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	public boolean isExisted(Integer year,Integer month){
		List<GMillionUserComplaintRate> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GMillionUserComplaintRate> queryDataForCharts() {
		Order[] orders = {Order.desc("year"),Order.desc("month")};
		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GMillionUserComplaintRate> list = getDao().findByPager(pager, orders);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	public GMillionUserComplaintRate queryOneByYearAndMonth(Integer year, Integer month) {
		List<GMillionUserComplaintRate> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
}
