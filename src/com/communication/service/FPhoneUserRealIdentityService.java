package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FPhoneUserRealIdentityDao;
import com.communication.entity.FPhoneUserRealIdentity;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FPhoneUserRealIdentityService extends BaseService<FPhoneUserRealIdentity> {
	
	@Resource
	private void setDao(FPhoneUserRealIdentityDao dao){
		super.setDao(dao);
	}

	public FPhoneUserRealIdentity queryByReportLogId(long reportLogId) {
		List<FPhoneUserRealIdentity> list = getDao().findAll(Order.desc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
