package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FIOTSecurityManagementDao;
import com.communication.entity.FIOTSecurityManagement;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FIOTSecurityManagementService extends BaseService<FIOTSecurityManagement> {
	@Resource
	private void setDao(FIOTSecurityManagementDao dao) {
		super.setDao(dao);
	}
	public List<FIOTSecurityManagement> queryByReportLog(long reportLogId, long insertUserId) {
		List<FIOTSecurityManagement> list = getDao().findAll(Order.asc("id"), Property.eq("reportLogId", reportLogId), Property.eq("insertUserId", insertUserId));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}

	public FIOTSecurityManagement queryByReportLogId(long reportLogId) {
		List<FIOTSecurityManagement> list = getDao().findAll(Order.asc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	public List<FIOTSecurityManagement> queryByYear(Integer loadingYear) {
		List<FIOTSecurityManagement> list = getDao().findAll(Order.asc("month"), Property.eq("year", loadingYear));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
}
