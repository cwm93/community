package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.GInternetPlatformSpamMessageDao;
import com.communication.entity.GInternetPlatformSpamMessage;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class GInternetPlatformSpamMessageService extends BaseService<GInternetPlatformSpamMessage> {

	@Resource
	private void setDao(GInternetPlatformSpamMessageDao dao) {
		super.setDao(dao);
	}

	public List<GInternetPlatformSpamMessage> queryByYear(Integer year) {
		List<GInternetPlatformSpamMessage> list = getDao().findAll(Order.asc("month"), Property.eq("year", year));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public boolean isExisted(Integer year, Integer month) {
		List<GInternetPlatformSpamMessage> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),
				Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<GInternetPlatformSpamMessage> queryDataForCharts() {
		Order[] orders = { Order.desc("year"), Order.desc("month") };
		Pager pager = new Pager();
		pager.setPageSize("12");
		List<GInternetPlatformSpamMessage> list = getDao().findByPager(pager, orders);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public GInternetPlatformSpamMessage queryOneByYearAndMonth(Integer year, Integer month) {
		List<GInternetPlatformSpamMessage> list = getDao().findAll(Order.asc("month"), Property.eq("year", year),Property.eq("month", month));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
