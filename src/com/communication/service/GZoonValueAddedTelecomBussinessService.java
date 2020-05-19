package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.GZoonValueAddedTelecomBussinessDao;
import com.communication.entity.GZoonValueAddedTelecomBussiness;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GZoonValueAddedTelecomBussinessService extends BaseService<GZoonValueAddedTelecomBussiness> {

	@Autowired
	private void setDao(GZoonValueAddedTelecomBussinessDao dao) {
		super.setDao(dao);
	}

	public List<GZoonValueAddedTelecomBussiness> queryByYear(Integer year) {
		List<GZoonValueAddedTelecomBussiness> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public boolean isExisted(Integer year, Integer month) {
		List<GZoonValueAddedTelecomBussiness> list = getDao().findAll(Order.asc("month"), Property.eq("year", year), Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GZoonValueAddedTelecomBussiness> queryDataForCharts() {
		Order[] orders = {Order.desc("year"),Order.desc("month")};
		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GZoonValueAddedTelecomBussiness> list = getDao().findByPager(pager, orders);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	public GZoonValueAddedTelecomBussiness queryOneByYearAndMonth(Integer year, Integer month) {
		List<GZoonValueAddedTelecomBussiness> list = getDao().findAll(Order.asc("id"), Property.eq("year", year), Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
