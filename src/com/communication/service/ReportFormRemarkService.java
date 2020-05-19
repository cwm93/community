package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.ReportFormRemarkDao;
import com.communication.entity.ReportFormRemark;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class ReportFormRemarkService extends BaseService<ReportFormRemark> {
	
	@Resource
	private void setDao(ReportFormRemarkDao dao) {
		super.setDao(dao);
	}
	
	public List<ReportFormRemark> list(Long reportId){
		List<ReportFormRemark> reportFormRemarkList = getDao().findAll(Order.desc("year"), Property.eq("reportId", reportId));
		if(reportFormRemarkList!=null&&reportFormRemarkList.size()>0) {
			return reportFormRemarkList;
		}
		return null;
	}

	public ReportFormRemark queryByReportIdAndYear(Long reportId, Integer year) {
		List<ReportFormRemark> reportFormRemarkList = getDao().findAll(Order.desc("id"), Property.eq("reportId", reportId), Property.eq("year", year));
		if(reportFormRemarkList!=null&&reportFormRemarkList.size()>0) {
			return reportFormRemarkList.get(0);
		}
		return null;
	}

}
