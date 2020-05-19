package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.GLandlineFraudReportDao;
import com.communication.entity.GLandlineFraudReport;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GLandlineFraudReportService extends BaseService<GLandlineFraudReport> {
	
	@Resource
	private void setDao(GLandlineFraudReportDao dao){
		super.setDao(dao);
	}

	public List<GLandlineFraudReport> queryByYear(Integer year) {
		List<GLandlineFraudReport> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
	
	public boolean isExisted(Integer year,Integer month){
		List<GLandlineFraudReport> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GLandlineFraudReport> queryDataForCharts() {
		Order[] orders = { Order.desc("year"), Order.desc("month") };

		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GLandlineFraudReport> list = getDao().findByPager(pager, orders);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public GLandlineFraudReport queryOneByYearAndMonth(Integer year, Integer month) {
		List<GLandlineFraudReport> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
