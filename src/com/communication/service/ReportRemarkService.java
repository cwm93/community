package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.ReportRemarkDao;
import com.communication.entity.ReportRemark;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class ReportRemarkService extends BaseService<ReportRemark> {

	@Resource
	private void setDao(ReportRemarkDao dao) {
		super.setDao(dao);
	}

	public ReportRemark queryByReportIdAndYearMonth(long reportId, String loadingYear, String loadingMonth) {
		List<ReportRemark> reportRemarkList = getDao().findAll(Order.desc("id"), Property.eq("report.id", reportId),
				Property.eq("year", loadingYear), Property.eq("month", loadingMonth));
		if (reportRemarkList != null && reportRemarkList.size() > 0) {
			return reportRemarkList.get(0);
		}
		return null;
	}

	public List<ReportRemark> queryAll() {
		List<ReportRemark> list = getDao().findAll(Order.desc("id"));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public List<ReportRemark> queryByUserId(long userId) {
		List<ReportRemark> list = getDao().findAll(Order.desc("id"), Property.eq("userId", userId));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public ReportRemark queryByReportIdAndYearWeek(long reportId, String loadingYear, String loadingWeek) {
		List<ReportRemark> reportRemarkList = getDao().findAll(Order.desc("id"), Property.eq("report.id", reportId),
				Property.eq("year", loadingYear), Property.eq("week", loadingWeek));
		if (reportRemarkList != null && reportRemarkList.size() > 0) {
			return reportRemarkList.get(0);
		}
		return null;
	}

}
