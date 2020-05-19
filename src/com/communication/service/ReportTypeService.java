package com.communication.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.ReportTypeDao;
import com.communication.entity.ReportType;

@Service
public class ReportTypeService extends BaseService<ReportType> {
	
	@Resource
	private void setDao(ReportTypeDao dao){
		super.setDao(dao);
	}

}
