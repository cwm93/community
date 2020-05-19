package com.communication.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FAppealLocalTopTenDao;
import com.communication.entity.FAppealLocalTopTen;

@Service
public class FAppealLocalTopTenService extends BaseService<FAppealLocalTopTen> {
	
	@Resource
	private void setDao(FAppealLocalTopTenDao dao) {
		super.setDao(dao);
	}

}
