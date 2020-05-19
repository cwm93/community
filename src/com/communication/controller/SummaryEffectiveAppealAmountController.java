package com.communication.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.FEffectiveAppealAmount;
import com.communication.entity.ReportLog;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.FEffectiveAppealAmountService;
import com.communication.service.ReportLogService;
import com.communication.service.ReportService;
import com.communication.service.UserService;
import com.communication.util.Constants;
import com.communication.util.R;

/**
 * 有效申诉量统计情况
 **/
@Controller
@RequestMapping(value = "/summary")
public class SummaryEffectiveAppealAmountController {

	private static final Logger logger = LoggerFactory.getLogger(SummaryEffectiveAppealAmountController.class);

	@Resource
	private FEffectiveAppealAmountService effectiveAppealAmountService;
	@Resource
	private UserService userService;
	@Resource
	private ReportService reportService;
	@Resource
	private ReportLogService reportLogService;

	/**
	 * @author liliang
	 * @desc 有效申诉量统计情况
	 * @param year,month,reportId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/appealAmountJson", method = RequestMethod.GET)
	public @ResponseBody R appealAmountJson(@RequestParam(value="loadingYear",required=true) int loadingYear,
			@RequestParam(value="loadingMonth",required=true) int loadingMonth, @RequestParam(value="reportId",required=true) long reportId) {
		logger.info("获取有效申诉量统计情况:" + loadingYear + "-" + loadingMonth);
		List<ReportLog> reportLogList = reportLogService.queryByReport(reportId, loadingYear, loadingMonth, "0");
		FEffectiveAppealAmount f_telecom = null;
		FEffectiveAppealAmount f_mobile = null;
		FEffectiveAppealAmount f_unicom = null;
		try {
			reportLogList = reportLogService.queryByReport(reportId, loadingYear, loadingMonth, "0");
			if (reportLogList != null && reportLogList.size() > 0) {
				// 1-电信；2-移动；3-联通
				f_telecom = new FEffectiveAppealAmount();
				f_mobile = new FEffectiveAppealAmount();
				f_unicom = new FEffectiveAppealAmount();
				for (ReportLog reportLog : reportLogList) {
					// 审核后的进入统计
					if (reportLog.getAuditStatus() != null && reportLog.getAuditStatus().equals("1")) {
						// 1-电信；2-移动；3-联通
						if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
							f_telecom = effectiveAppealAmountService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 2) {
							f_mobile = effectiveAppealAmountService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 3) {
							f_unicom = effectiveAppealAmountService.queryByReportLogId(reportLog.getId());
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
				.put("f_mobile", f_mobile).put("f_unicom", f_unicom);
	}
}
