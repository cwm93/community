package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FIOTSecurityManagementSegmentDao;
import com.communication.entity.FIOTSecurityManagementSegment;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FIOTSecurityManagementSegmentService extends BaseService<FIOTSecurityManagementSegment> {

	@Resource
	private void setDao(FIOTSecurityManagementSegmentDao dao) {
		super.setDao(dao);
	}
	
	public List<FIOTSecurityManagementSegment> queryListByReportLogId(long reportLogId) {
		List<FIOTSecurityManagementSegment> list = getDao().findAll(Order.asc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	
	public int sum(String column,long reportLogId,String type,String digitType) {
		return getDao().sumByProperty(column, Property.eq("reportLogId", reportLogId), Property.eq("type", type), Property.eq("digitType", digitType));
	}
}
