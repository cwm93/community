package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.GMobileResaleEnterpriseDao;
import com.communication.entity.GMobileResaleEnterprise;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GMobileResaleEnterpriseService extends BaseService<GMobileResaleEnterprise>{
	
	@Autowired
	private void setDao(GMobileResaleEnterpriseDao dao){
		super.setDao(dao);
	}
	
	
	public List<GMobileResaleEnterprise> queryListByYear(Integer year){
		List<GMobileResaleEnterprise> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	public boolean isExisted(Integer year,Integer month){
		List<GMobileResaleEnterprise> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}


	public List<GMobileResaleEnterprise> queryDataForCharts() {
		Order[] orders = {Order.desc("year"),Order.desc("month")};
		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GMobileResaleEnterprise> list = getDao().findByPager(pager, orders);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

}
