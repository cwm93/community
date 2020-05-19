package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.GBroadbandTariffDao;
import com.communication.entity.GBroadbandTariff;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GBroadbandTariffService extends BaseService<GBroadbandTariff> {

	@Autowired
	private void setDao(GBroadbandTariffDao dao) {
		super.setDao(dao);
	}

	public List<GBroadbandTariff> queryByYear(Integer year) {
		List<GBroadbandTariff> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public boolean isExisted(Integer year, Integer month) {
		List<GBroadbandTariff> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GBroadbandTariff> queryDataForCharts() {
		Order[] orders = { Order.desc("year"), Order.desc("month") };

		Pager pager = new Pager();
		pager.setPageSize("12");

		List<GBroadbandTariff> list = getDao().findByPager(pager, orders);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public GBroadbandTariff queryOneByYearAndMonth(Integer year,Integer month) {
		List<GBroadbandTariff> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
