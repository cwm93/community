package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.GVirtualOperatorDao;
import com.communication.entity.GVirtualOperator;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GVirtualOperatorService extends BaseService<GVirtualOperator> {
	
	@Autowired
	private void setDao(GVirtualOperatorDao dao){
		super.setDao(dao);
	}

	public List<GVirtualOperator> queryByYear(Integer year) {
		List<GVirtualOperator> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	public boolean isExisted(Integer year,Integer month){
		List<GVirtualOperator> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GVirtualOperator> queryDataForCharts() {
		Order[] orders = {Order.desc("year"),Order.desc("month")};
		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GVirtualOperator> list = getDao().findByPager(pager, orders);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	public GVirtualOperator queryOneByYearAndMonth(Integer year, Integer month) {
		List<GVirtualOperator> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
