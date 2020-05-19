package com.communication.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.LogLoginDao;
import com.communication.entity.LogLogin;

@Service
public class LogLoginService extends BaseService<LogLogin> {

	@Resource
	private void setDao(LogLoginDao dao){
		super.setDao(dao);
	}
}
