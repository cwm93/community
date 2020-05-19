package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.GFixedNumberResourceDao;
import com.communication.entity.GFixedNumberResource;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GFixedNumberResourceService extends BaseService<GFixedNumberResource> {

	@Resource
	private void setDao(GFixedNumberResourceDao dao) {
		super.setDao(dao);
	}

	public List<GFixedNumberResource> queryByYear(Integer year) {
		List<GFixedNumberResource> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public boolean isExisted(Integer year, Integer month) {
		List<GFixedNumberResource> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),
				Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GFixedNumberResource> queryDataForCharts() {
		Order[] orders = { Order.desc("year"), Order.desc("month") };
		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GFixedNumberResource> list = getDao().findByPager(pager, orders);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public GFixedNumberResource queryOneByYearAndMonth(Integer year, Integer month) {
		List<GFixedNumberResource> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
