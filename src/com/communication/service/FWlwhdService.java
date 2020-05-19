package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FWlwhdDao;
import com.communication.entity.FWlwhd;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FWlwhdService extends BaseService<FWlwhd> {
	
	@Resource 
	private void setDao(FWlwhdDao dao){
		super.setDao(dao);
	}

	public List<FWlwhd> queryByReportLog(long reportLogId, long insertUserId) {
		List<FWlwhd>  list = getDao().findAll(Order.asc("id"), Property.eq("reportLogId", reportLogId), Property.eq("insertUserId", insertUserId));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}

}
