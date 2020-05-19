package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FXxzpDao;
import com.communication.entity.FXxzp;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FXxzpService extends BaseService<FXxzp> {
	
	@Resource
	private void setDao(FXxzpDao dao){
		super.setDao(dao);
	}

	public FXxzp queryByReportLog(long reportLogId, long insertUserId) {
		List<FXxzp> list = getDao().findAll(Order.desc("id"), Property.eq("reportLogId", reportLogId), Property.eq("insertUserId", insertUserId));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public FXxzp queryByReportLogId(long reportLogId) {
		List<FXxzp> list = getDao().findAll(Order.desc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
