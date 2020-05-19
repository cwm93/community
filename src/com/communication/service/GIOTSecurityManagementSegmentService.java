package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.GIOTSecurityManagementSegmentDao;
import com.communication.entity.GIOTSecurityManagementSegment;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GIOTSecurityManagementSegmentService extends BaseService<GIOTSecurityManagementSegment>{

	@Resource
	private void setDao(GIOTSecurityManagementSegmentDao dao) {
		super.setDao(dao);
	}
	
	public List<GIOTSecurityManagementSegment> queryByYear(Integer year) {
		List<GIOTSecurityManagementSegment> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public boolean isExisted(Integer year, Integer month) {
		List<GIOTSecurityManagementSegment> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),
				Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GIOTSecurityManagementSegment> queryDataForCharts() {
		Order[] orders = { Order.desc("year"), Order.desc("month") };
		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GIOTSecurityManagementSegment> list = getDao().findByPager(pager, orders);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public GIOTSecurityManagementSegment queryOneByYearAndMonth(Integer year, Integer month) {
		List<GIOTSecurityManagementSegment> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
