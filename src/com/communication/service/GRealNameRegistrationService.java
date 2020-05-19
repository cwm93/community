package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.GRealNameRegistrationDao;
import com.communication.entity.GRealNameRegistration;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GRealNameRegistrationService extends BaseService<GRealNameRegistration> {

	@Autowired
	private void setDao(GRealNameRegistrationDao dao) {
		super.setDao(dao);
	}

	public List<GRealNameRegistration> queryByYear(Integer year) {
		List<GRealNameRegistration> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	public boolean isExisted(Integer year,Integer month){
		List<GRealNameRegistration> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GRealNameRegistration> queryDataForCharts() {
		
		Order[] orders = {Order.desc("year"),Order.desc("month")};
		
		Pager pager = new Pager();
		pager.setPageSize("12");
		
		List<GRealNameRegistration> list = getDao().findByPager(pager, orders);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	public GRealNameRegistration queryOneByYearAndMonth(Integer year, Integer month) {
		List<GRealNameRegistration> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
