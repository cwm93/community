package com.communication.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.TelecomOperatorDao;
import com.communication.entity.TelecomOperator;

@Service
public class TelecomOperatorService extends BaseService<TelecomOperator> {
	
	@Resource
	private void setDao(TelecomOperatorDao dao){
		super.setDao(dao);
	}
	

}
