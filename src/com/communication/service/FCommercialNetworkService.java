package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FCommercialNetworkDao;
import com.communication.entity.FCommercialNetwork;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FCommercialNetworkService extends BaseService<FCommercialNetwork> {

	@Resource
	private void setDao(FCommercialNetworkDao dao){
		super.setDao(dao);
	}

	public List<FCommercialNetwork> queryByReportLog(long reportLogId, long insertUserId) {
		List<FCommercialNetwork> list = getDao().findAll(Order.asc("id"), Property.eq("reportLogId", reportLogId), Property.eq("insertUserId", insertUserId));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}

	public FCommercialNetwork queryByReportLogId(long reportLogId) {
		List<FCommercialNetwork> list = getDao().findAll(Order.asc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
