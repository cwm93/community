package com.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.SysLogDao;
import com.communication.entity.SmsLogEntity;
import com.communication.util.Order;

@Service
public class SmsLogService extends BaseService<SmsLogEntity> {
	
	@Autowired
	private void setDao(SysLogDao dao) {
		super.setDao(dao);
	}

	public List<SmsLogEntity> queryAll() {
		List<SmsLogEntity> list = getDao().findAll(Order.desc("id"));
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

}
