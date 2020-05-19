package com.communication.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.ReportKindDao;
import com.communication.entity.ReportKind;

@Service
public class ReportKindService extends BaseService<ReportKind> {
	
	@Resource 
	private void setDao(ReportKindDao dao){
		super.setDao(dao);
	}

}
