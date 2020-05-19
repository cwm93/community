package com.communication.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FAppealAnalysisContentDao;
import com.communication.entity.FAppealAnalysisContent;

@Service
public class FAppealAnalysisContentService extends BaseService<FAppealAnalysisContent> {
	
	@Resource
	private void setDao(FAppealAnalysisContentDao dao) {
		super.setDao(dao);
	}

}
