package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.GMobileFraudReportDao;
import com.communication.entity.GMobileFraudReport;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GMobileFraudReportService extends BaseService<GMobileFraudReport> {
	
	@Resource
	private void setDao(GMobileFraudReportDao dao){
		super.setDao(dao);
	}
	
	public List<GMobileFraudReport> queryListByYear(Integer year){
		List<GMobileFraudReport> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	public boolean isExisted(Integer year,Integer month){
		List<GMobileFraudReport> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GMobileFraudReport> queryDataForCharts() {
		Order[] orders = { Order.desc("year"), Order.desc("month") };
		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GMobileFraudReport> list = getDao().findByPager(pager, orders);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public GMobileFraudReport queryOneByYearAndMonth(Integer year, Integer month) {
		List<GMobileFraudReport> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
