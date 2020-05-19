package com.communication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.SmsDao;
import com.communication.entity.SmsEntity;

@Service
public class SmsService extends BaseService<SmsEntity> {

	@Autowired
	private void setDao(SmsDao dao) {
		super.setDao(dao);
	}
	
	public boolean isOpen(Integer smsId) {
		SmsEntity smsEntity = getDao().find(smsId);
		if(null != smsEntity) {
			if("0".equals(smsEntity.getClosed())) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
