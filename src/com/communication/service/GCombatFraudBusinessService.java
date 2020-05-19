package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.GCombatFraudBusinessDao;
import com.communication.entity.GCombatFraudBusiness;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GCombatFraudBusinessService extends BaseService<GCombatFraudBusiness> {

	@Resource
	private void setDao(GCombatFraudBusinessDao dao) {
		super.setDao(dao);
	}

	public List<GCombatFraudBusiness> queryByYear(Integer year) {
		Order[] orders = {Order.asc("month"),Order.asc("day")};
		List<GCombatFraudBusiness> list = getDao().findAll(orders, Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	public boolean isExisted(Integer year,Integer month,Integer day){
		List<GCombatFraudBusiness> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month),Property.eq("day", day));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GCombatFraudBusiness> queryDataForCharts() {
		Order[] orders = { Order.desc("year"), Order.desc("month"), Order.desc("day") };
		Pager pager = new Pager();
		pager.setPageSize("15");
		List<GCombatFraudBusiness> list = getDao().findByPager(pager, orders);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public GCombatFraudBusiness queryOneByYearAndMonth(Integer year,Integer month) {
		List<GCombatFraudBusiness> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
