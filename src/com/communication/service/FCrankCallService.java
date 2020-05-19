package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FCrankCallDao;
import com.communication.entity.FCrankCall;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FCrankCallService extends BaseService<FCrankCall>{

	@Resource
	private void setDao(FCrankCallDao dao) {
		super.setDao(dao);
	}
	
	public List<FCrankCall> queryByReportLog(long reportLogId, long insertUserId) {
		List<FCrankCall> list = getDao().findAll(Order.asc("id"), Property.eq("reportLogId", reportLogId), Property.eq("insertUserId", insertUserId));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}

	public FCrankCall queryByReportLogId(long reportLogId) {
		List<FCrankCall> list = getDao().findAll(Order.asc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
