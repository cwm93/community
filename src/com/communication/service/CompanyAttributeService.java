package com.communication.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.CompanyAttributeDao;
import com.communication.entity.CompanyAttribute;

@Service
public class CompanyAttributeService extends BaseService<CompanyAttribute> {
	
	@Resource
	private void setDao(CompanyAttributeDao dao){
		super.setDao(dao);
	}

}
