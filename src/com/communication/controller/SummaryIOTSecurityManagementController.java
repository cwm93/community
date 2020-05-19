package com.communication.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.FIOTSecurityManagement;
import com.communication.entity.ReportLog;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.FIOTSecurityManagementSegmentService;
import com.communication.service.FIOTSecurityManagementService;
import com.communication.service.ReportLogService;
import com.communication.service.ReportService;
import com.communication.service.UserService;
import com.communication.util.Constants;
import com.communication.util.R;

@Controller
@RequestMapping("/summary")
public class SummaryIOTSecurityManagementController {

	public static final Logger logger = LoggerFactory.getLogger(SummaryIOTSecurityManagementController.class);

	@Resource
	private FIOTSecurityManagementService iOTSecurityManagementService;
	@Resource
	private UserService userService;
	@Resource
	private ReportService reportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FIOTSecurityManagementSegmentService fIOTSecurityManagementSegmentService;

	/**
	 * @author liliang
	 * @desc 物联网行业卡安全管理（新）
	 * @param year,month,reportId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/iOTSecurityManagementJson", method = RequestMethod.GET)
	public @ResponseBody R iOTSecurityManagementJson(@RequestParam("loadingYear") Integer loadingYear,
			@RequestParam("loadingMonth") Integer loadingMonth, @RequestParam("reportId") Integer reportId) {
		logger.info("获取物联网行业卡安全管理（新）:" + loadingYear + "-" + loadingMonth);
		List<ReportLog> reportLogList = new ArrayList<ReportLog>();
		// reportLogList = reportLogService.queryByReport(reportId, loadingYear,
		// loadingMonth, "0");
		// 获取三家物联网行业卡安全管理（新）
		FIOTSecurityManagement f_telecom = null;
		FIOTSecurityManagement f_mobile = null;
		FIOTSecurityManagement f_unicom = null;
		int[] sumarr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		try {
			reportLogList = reportLogService.queryByReport(reportId, loadingYear, loadingMonth, "0");
			if (reportLogList != null && reportLogList.size() > 0) {
				f_telecom = new FIOTSecurityManagement();
				f_mobile = new FIOTSecurityManagement();
				f_unicom = new FIOTSecurityManagement();
				for (ReportLog reportLog : reportLogList) {
					// 审核后的进入统计
					if (reportLog.getAuditStatus() != null && reportLog.getAuditStatus().equals("1")) {
						// 1-电信；2-移动；3-联通
						if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
							f_telecom = iOTSecurityManagementService.queryByReportLogId(reportLog.getId());
							sumarr[0] = fIOTSecurityManagementSegmentService.sum("amount", reportLog.getId(), "1",
									"11");
							sumarr[1] = fIOTSecurityManagementSegmentService.sum("usedAmount", reportLog.getId(), "1",
									"11");
							sumarr[2] = fIOTSecurityManagementSegmentService.sum("amount", reportLog.getId(), "1",
									"13");
							sumarr[3] = fIOTSecurityManagementSegmentService.sum("usedAmount", reportLog.getId(), "1",
									"13");
							sumarr[4] = fIOTSecurityManagementSegmentService.sum("amount", reportLog.getId(), "2",
									"11");
							sumarr[5] = fIOTSecurityManagementSegmentService.sum("usedAmount", reportLog.getId(), "2",
									"13");
							sumarr[6] = fIOTSecurityManagementSegmentService.sum("amount", reportLog.getId(), "2",
									"13");
							sumarr[7] = fIOTSecurityManagementSegmentService.sum("usedAmount", reportLog.getId(), "2",
									"13");
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 2) {
							f_mobile = iOTSecurityManagementService.queryByReportLogId(reportLog.getId());
							sumarr[8] = fIOTSecurityManagementSegmentService.sum("amount", reportLog.getId(), "1",
									"11");
							sumarr[9] = fIOTSecurityManagementSegmentService.sum("usedAmount", reportLog.getId(), "1",
									"11");
							sumarr[10] = fIOTSecurityManagementSegmentService.sum("amount", reportLog.getId(), "1",
									"13");
							sumarr[11] = fIOTSecurityManagementSegmentService.sum("usedAmount", reportLog.getId(), "1",
									"13");
							sumarr[12] = fIOTSecurityManagementSegmentService.sum("amount", reportLog.getId(), "2",
									"11");
							sumarr[13] = fIOTSecurityManagementSegmentService.sum("usedAmount", reportLog.getId(), "2",
									"13");
							sumarr[14] = fIOTSecurityManagementSegmentService.sum("amount", reportLog.getId(), "2",
									"13");
							sumarr[15] = fIOTSecurityManagementSegmentService.sum("usedAmount", reportLog.getId(), "2",
									"13");
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 3) {
							f_unicom = iOTSecurityManagementService.queryByReportLogId(reportLog.getId());
							sumarr[16] = fIOTSecurityManagementSegmentService.sum("amount", reportLog.getId(), "1",
									"11");
							sumarr[17] = fIOTSecurityManagementSegmentService.sum("usedAmount", reportLog.getId(), "1",
									"11");
							sumarr[18] = fIOTSecurityManagementSegmentService.sum("amount", reportLog.getId(), "1",
									"13");
							sumarr[19] = fIOTSecurityManagementSegmentService.sum("usedAmount", reportLog.getId(), "1",
									"13");
							sumarr[20] = fIOTSecurityManagementSegmentService.sum("amount", reportLog.getId(), "2",
									"11");
							sumarr[21] = fIOTSecurityManagementSegmentService.sum("usedAmount", reportLog.getId(), "2",
									"11");
							sumarr[22] = fIOTSecurityManagementSegmentService.sum("amount", reportLog.getId(), "2",
									"13");
							sumarr[23] = fIOTSecurityManagementSegmentService.sum("usedAmount", reportLog.getId(), "2",
									"13");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("系统出现异常，稍后重试");
		}
		return R.ok("获取数据成功").put("reportLogList", reportLogList).put("loadingYear", loadingYear)
				.put("loadingMonth", loadingMonth).put("reportLogList", reportLogList).put("f_telecom", f_telecom)
				.put("f_mobile", f_mobile).put("f_unicom", f_unicom).put("sumarr", sumarr);
	}

	/**
	 * @author liliang
	 * @desc 物联网行业卡安全管理（新）管理处统计表
	 * @param year
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/iOTSecurityManagementJsonByYear", method = RequestMethod.GET)
	public @ResponseBody R iOTSecurityManagementJsonByYear(@RequestParam("loadingYear") Integer loadingYear) {
		List<FIOTSecurityManagement> iOTSecurityManagementList = iOTSecurityManagementService.queryByYear(loadingYear);
		if (iOTSecurityManagementList != null && iOTSecurityManagementList.size() > 0) {
			for (FIOTSecurityManagement fIOTSecurityManagement : iOTSecurityManagementList) {
			
			}
		}
		return R.ok("获取数据成功").put("reportLogList", iOTSecurityManagementList);
	}

}
