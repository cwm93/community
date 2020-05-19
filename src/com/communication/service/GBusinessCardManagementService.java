package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.GBusinessCardManagementDao;
import com.communication.entity.GBusinessCardManagement;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GBusinessCardManagementService extends BaseService<GBusinessCardManagement> {

	@Autowired
	private void setDao(GBusinessCardManagementDao dao) {
		super.setDao(dao);
	}

	public List<GBusinessCardManagement> queryByYear(Integer year) {
		List<GBusinessCardManagement> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public boolean isExisted(Integer year, Integer month) {
		List<GBusinessCardManagement> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),
				Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GBusinessCardManagement> queryDataForCharts() {
		Order[] orders = { Order.desc("year"), Order.desc("month") };
		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GBusinessCardManagement> list = getDao().findByPager(pager, orders);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public GBusinessCardManagement queryOneByYearAndMonth(Integer year, Integer month) {
		List<GBusinessCardManagement> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
