/**
 * 
 */
package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FHmzyDao;
import com.communication.entity.FHmzy;
import com.communication.util.Order;
import com.communication.util.Property;

/**
 * @author liliang
 *
 */
@Service
public class FHmzyService extends BaseService<FHmzy> {
	
	@Resource
	private void setDao(FHmzyDao dao){
		super.setDao(dao);
	}
	
	@Resource
	private FHmzyDao formDao;

	public List<FHmzy> queryByReportLog(long reportLogId, long insertUserId) {
		List<FHmzy> list = getDao().findAll(Order.desc("id"), Property.eq("reportLogId", reportLogId), Property.eq("insertUserId", insertUserId));
		
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}

	public FHmzy queryByReportLogId(long reportLogId) {
		List<FHmzy> list = getDao().findAll(Order.desc("id"), Property.eq("reportLogId", reportLogId));

		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	public long count(String propertyName,long reportLogId){
		long counter = getDao().executeCount("from FHmzy f where f.reportLogId=?",reportLogId);
		return counter;
		
	}
	
	public int sumByReportLogId(String propertyName,long reportLogId){
		Integer sum  = getDao().sumByProperty(propertyName, Property.eq("reportLogId", reportLogId));
			return sum;
	}
	
	public int sumByReportLogId(String propertyName,long reportLogId,long inserUserId){
		int sum  = getDao().sumByProperty(propertyName, Property.eq("reportLogId", reportLogId),Property.eq("insertUserId", inserUserId));
		return sum;
	}

	public void deleteByReportLogId(long reportLogId) {
		formDao.deleteByReportLogId(reportLogId);	
	}

}
