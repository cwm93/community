package com.communication.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.AdministrationReportDao;
import com.communication.entity.AdministrationReport;

@Service
public class AdministrationReportService extends BaseService<AdministrationReport> {
	@Resource
	private void setDao(AdministrationReportDao dao){
		super.setDao(dao);
	}
}
