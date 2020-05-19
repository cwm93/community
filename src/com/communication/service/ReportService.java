package com.communication.service;


import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.communication.dao.ReportDao;
import com.communication.entity.Report;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class ReportService extends BaseService<Report> {
	
	@Resource
	private void setDao(ReportDao dao) {
		super.setDao(dao);
	}

	public Report findByFormCode(String formCode) {
		List<Report> list = getDao().findAll(Order.desc("id"), Property.eq("formCode", formCode));
		if(list!=null &&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public long countAll() {
		return getDao().countByProperty("id")==null ? 0 : getDao().countByProperty("id");
	}
}
