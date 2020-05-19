package com.communication.dao;

import org.springframework.stereotype.Repository;

import com.communication.entity.FHmzy;

@Repository
public class FHmzyDao extends BaseDao<FHmzy>{

	public void deleteByReportLogId(long reportLogId) {
		String del_report_log = "DELETE FROM zf_hmzy WHERE report_log_id=? ";
		getSession().createSQLQuery(del_report_log).setLong(0, reportLogId).executeUpdate();
	}

}
