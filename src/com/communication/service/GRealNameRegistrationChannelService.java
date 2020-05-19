package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.GRealNameRegistrationChannelDao;
import com.communication.entity.GRealNameRegistrationChannel;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GRealNameRegistrationChannelService extends BaseService<GRealNameRegistrationChannel> {
	@Resource
	private void setDao(GRealNameRegistrationChannelDao dao) {
		super.setDao(dao);
	}

	public List<GRealNameRegistrationChannel> queryListByYear(Integer year) {
		List<GRealNameRegistrationChannel> list = getDao().findAll(Order.asc("month"),Property.eq("year", year));
		if ((list != null) && (list.size() > 0)) {
			return list;
		}
		return null;
	}

	public boolean isExisted(Integer year,Integer month){
		List<GRealNameRegistrationChannel> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}
	
	public GRealNameRegistrationChannel queryOneByYearAndMonth(Integer year,Integer month){
		List<GRealNameRegistrationChannel> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	public List<GRealNameRegistrationChannel> queryDataForCharts(){
		
		Order[] orders = {Order.desc("year"),Order.desc("month")};
		
		Pager pager = new Pager();
		pager.setPageSize("12");
		
		List<GRealNameRegistrationChannel> list = getDao().findByPager(pager, orders);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}
}