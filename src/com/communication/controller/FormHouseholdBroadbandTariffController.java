package com.communication.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.FHouseholdBroadbandTariff;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FHouseholdBroadbandTariffService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;
import com.communication.util.R;

/**
 * @author Administrator
 * @基础电信企业家庭用户宽带资费汇总
 */
@Controller
public class FormHouseholdBroadbandTariffController {
	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FHouseholdBroadbandTariffService fHouseholdBroadbandTariffService;

	@RequestMapping(value = "/yhkdzf/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);
		if (reportLog.getToUser().getId() == curUser.getId()) {
			FHouseholdBroadbandTariff fHouseholdBroadbandTariff = fHouseholdBroadbandTariffService
					.queryByReportLogId(reportLogId);
			if (fHouseholdBroadbandTariff == null) {
				fHouseholdBroadbandTariff = new FHouseholdBroadbandTariff();
			}
			model.addAttribute("reportLog", reportLog);
			model.addAttribute("fHouseholdBroadbandTariff", fHouseholdBroadbandTariff);
		} else {
			return "redirect:/hasNoRight";
		}
		return "/form/form_yhkdzf";
	}

	@RequestMapping(value = "/yhkdzf/view/{report_log_id}")
	public String view(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);
		if (curUser.getRole().getCode().equals("USER")) {
			if (reportLog.getToUser().getId() != curUser.getId()) {
				return "redirect:/hasNoRight";
			}
		}
		FHouseholdBroadbandTariff fHouseholdBroadbandTariff = fHouseholdBroadbandTariffService.queryByReportLogId(reportLogId);
		model.addAttribute("fHouseholdBroadbandTariff", fHouseholdBroadbandTariff);
		model.addAttribute("reportLog", reportLog);

		return "/form/form_yhkdzf_view";
	}

	@RequestMapping(value = "/yhkdzf/save", method = RequestMethod.POST)
	public @ResponseBody R save(
			@ModelAttribute("fHouseholdBroadbandTariff") FHouseholdBroadbandTariff fHouseholdBroadbandTariff,
			HttpServletRequest request) {
		String flag = request.getParameter("flag");
		try {
			if (fHouseholdBroadbandTariff.getId() > 0) {
				FHouseholdBroadbandTariff temp = new FHouseholdBroadbandTariff();
				temp = fHouseholdBroadbandTariff;
				temp.setUpdateTime(new Date());
				fHouseholdBroadbandTariffService.update(temp);
			} else {
				fHouseholdBroadbandTariff.setCreateTime(new Date());
				fHouseholdBroadbandTariff.setUpdateTime(new Date());
				fHouseholdBroadbandTariffService.save(fHouseholdBroadbandTariff);
			}

			ReportLog reportLog = reportLogService.find(fHouseholdBroadbandTariff.getReportLogId());
			if (flag.equals("1")) {
				reportLog.setStatus("1");
				reportLog.setAuditStatus("0");
				reportLog.setSubmitTime(new Date());
			} else {
				reportLog.setStatus("2");
			}
			reportLogService.update(reportLog);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("操作失败");
		}
		return R.ok("操作成功");
	}

}
