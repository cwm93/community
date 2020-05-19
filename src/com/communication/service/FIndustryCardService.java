package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FIndustryCardDao;
import com.communication.entity.FIndustryCard;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FIndustryCardService extends BaseService<FIndustryCard> {

	
	@Resource 
	private void setDao(FIndustryCardDao dao){
		super.setDao(dao);
	}

	public FIndustryCard queryByReportLogId(long reportLogId) {
		List<FIndustryCard> list = getDao().findAll(Order.asc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
