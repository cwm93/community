package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.ReportLogDao;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

@Service
public class ReportLogService extends BaseService<ReportLog> {

	@Resource
	private void setDao(ReportLogDao dao) {
		super.setDao(dao);
	}

	public List<ReportLog> query(String status, Pager pager,String isDeleted) {
		List<ReportLog> reportLogList = getDao().findByPager(pager, Order.desc("id"), Property.eq("status", status), Property.eq("isDeleted", isDeleted));
		return reportLogList;
	}

	public List<ReportLog> queryByFromUser(User fromUser, String status, Pager pager,String isDeleted) {
		List<ReportLog> reportLogList = getDao().findByPager(pager, Order.desc("id"), Property.eq("fromUser", fromUser),Property.eq("status", status), Property.eq("isDeleted", isDeleted));
		return reportLogList;
	}

	public List<ReportLog> queryByToUser(User toUser, String status, Pager pager,String isDeleted) {
		List<ReportLog> reportLogList = getDao().findByPager(pager, Order.desc("id"), Property.eq("toUser", toUser),Property.eq("status", status), Property.eq("isDeleted", isDeleted));
		return reportLogList;
	}

	public long count(String isDeleted) {
		long count = getDao().countByProperty("id", Property.eq("isDeleted", isDeleted));
		return count;
	}

	public long count(String status,String isDeleted) {
		long count = getDao().countByProperty("id", Property.eq("status", status), Property.eq("isDeleted", isDeleted));
		return count;
	}

	public long countByFromUser(User user, String status,String isDeleted) {
		long count = getDao().countByProperty("id", Property.eq("fromUser", user), Property.eq("status", status), Property.eq("isDeleted", isDeleted));
		return count;
	}

	public long countByToUser(User user, String status,String isDeleted) {
		long count = getDao().countByProperty("id", Property.eq("toUser", user), Property.eq("status", status), Property.eq("isDeleted", isDeleted));
		return count;
	}

	public ReportLog getReportLogByCreatedId(User fromUser,String isDeleted) {
		List<ReportLog> list = getDao().findAll(Order.desc("id"), Property.eq("fromUser", fromUser), Property.eq("isDeleted", isDeleted));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public List<ReportLog> queryByReport(long reportId, int year, int month,String isDeleted) {
		List<ReportLog> list = getDao().findAll(Order.desc("id"), Property.eq("report.id", reportId),
				Property.eq("writeYear", year), Property.eq("writeMonth", month), Property.eq("isDeleted", isDeleted));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public List<ReportLog> queryByReportAndWeek(long reportId, int year, int week,String isDeleted) {
		List<ReportLog> list = getDao().findAll(Order.desc("id"), Property.eq("report.id", reportId),
				Property.eq("writeYear", year), Property.eq("writeWeek", week), Property.eq("isDeleted", isDeleted));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public List<ReportLog> queryByReportAndMonth(Long reportId, Integer loadingYear, Integer loadingMonth,String isDeleted) {
		List<ReportLog> list = getDao().findAll(Order.desc("id"), Property.eq("report.id", reportId),
				Property.eq("writeYear", loadingYear), Property.eq("writeMonth", loadingMonth), Property.eq("isDeleted", isDeleted));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	public List<ReportLog> queryByReportAndMonthAndAudited(Long reportId, Integer loadingYear, Integer loadingMonth,String isDeleted,String auditStatus) {
		List<ReportLog> list = getDao().findAll(Order.desc("id"), Property.eq("report.id", reportId),
				Property.eq("writeYear", loadingYear), Property.eq("writeMonth", loadingMonth), Property.eq("isDeleted", isDeleted), Property.eq("auditStatus", auditStatus));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	//新增2017-8-17
	
	public List<ReportLog> query(String status, Pager pager,String isDeleted,String auditStatus) {
		List<ReportLog> reportLogList = getDao().findByPager(pager, Order.desc("id"), Property.eq("status", status), Property.eq("isDeleted", isDeleted), Property.eq("auditStatus", auditStatus));
		return reportLogList;
	}

	public List<ReportLog> queryByFromUser(User fromUser, String status, Pager pager,String isDeleted,String auditStatus) {
		List<ReportLog> reportLogList = getDao().findByPager(pager, Order.desc("id"), Property.eq("fromUser", fromUser),Property.eq("status", status), Property.eq("isDeleted", isDeleted), Property.eq("auditStatus", auditStatus));
		return reportLogList;
	}

	public List<ReportLog> queryByToUser(User toUser, String status, Pager pager,String isDeleted,String auditStatus) {
		List<ReportLog> reportLogList = getDao().findByPager(pager, Order.desc("id"), Property.eq("toUser", toUser),Property.eq("status", status), Property.eq("isDeleted", isDeleted), Property.eq("auditStatus", auditStatus));
		return reportLogList;
	}
	public long count(String status,String isDeleted,String auditStatus) {
		long count = getDao().countByProperty("id", Property.eq("status", status), Property.eq("isDeleted", isDeleted), Property.eq("auditStatus", auditStatus));
		return count;
	}

	public long countByFromUser(User user, String status,String isDeleted,String auditStatus) {
		long count = getDao().countByProperty("id", Property.eq("fromUser", user), Property.eq("status", status), Property.eq("isDeleted", isDeleted), Property.eq("auditStatus", auditStatus));
		return count;
	}

	public long countByToUser(User user, String status,String isDeleted,String auditStatus) {
		long count = getDao().countByProperty("id", Property.eq("toUser", user), Property.eq("status", status), Property.eq("isDeleted", isDeleted), Property.eq("auditStatus", auditStatus));
		return count;
	}
	
	//
	public List<ReportLog> nquery(String status, Pager pager,String isDeleted) {
		List<ReportLog> reportLogList = getDao().findByPager(pager, Order.desc("id"), Property.ne("status", status), Property.eq("isDeleted", isDeleted));
		return reportLogList;
	}

	public List<ReportLog> nqueryByFromUser(User fromUser, String status, Pager pager,String isDeleted) {
		List<ReportLog> reportLogList = getDao().findByPager(pager, Order.desc("id"), Property.eq("fromUser", fromUser),Property.ne("status", status), Property.eq("isDeleted", isDeleted));
		return reportLogList;
	}

	public List<ReportLog> nqueryByToUser(User toUser, String status, Pager pager,String isDeleted) {
		List<ReportLog> reportLogList = getDao().findByPager(pager, Order.desc("id"), Property.eq("toUser", toUser),Property.ne("status", status), Property.eq("isDeleted", isDeleted));
		return reportLogList;
	}

	public long ncount(String status,String isDeleted) {
		long count = getDao().countByProperty("id", Property.ne("status", status), Property.eq("isDeleted", isDeleted));
		return count;
	}

	public long ncountByFromUser(User user, String status,String isDeleted) {
		long count = getDao().countByProperty("id", Property.eq("fromUser", user), Property.ne("status", status), Property.eq("isDeleted", isDeleted));
		return count;
	}

	public long ncountByToUser(User user, String status,String isDeleted) {
		long count = getDao().countByProperty("id", Property.eq("toUser", user), Property.ne("status", status), Property.eq("isDeleted", isDeleted));
		return count;
	}
}
