package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.GCheckedStoreDao;
import com.communication.entity.GCheckedStore;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GCheckedStoreService extends BaseService<GCheckedStore> {

	@Resource
	private void setDao(GCheckedStoreDao dao) {
		super.setDao(dao);
	}

	public List<GCheckedStore> queryListByYear(Integer year) {
		List<GCheckedStore> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public boolean isExisted(Integer year, Integer month) {
		List<GCheckedStore> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),
				Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GCheckedStore> queryDataForCharts() {
		Order[] orders = { Order.desc("year"), Order.desc("month") };

		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GCheckedStore> list = getDao().findByPager(pager, orders);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public GCheckedStore queryOneByYearAndMonth(Integer year, Integer month) {
		List<GCheckedStore> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),
				Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
