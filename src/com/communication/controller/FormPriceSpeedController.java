package com.communication.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.communication.entity.FPriceSpeed;
import com.communication.entity.ReportFormRemark;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FPriceSpeedService;
import com.communication.service.ReportFormRemarkService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;
import com.communication.util.R;

/**
 * @author Administrator 上海地区电信运营商企业提速降价工作情况
 */
@Controller
public class FormPriceSpeedController {

	private static final Logger logger = LoggerFactory.getLogger(FormResaleRealNameRegistrationController.class);
	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FPriceSpeedService fPriceSpeedService;
	@Resource
	private ReportFormRemarkService reportFormRemarkService;

	@SuppressWarnings("deprecation")
	@RequestMapping("/tsjj/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		String urlReturn = null;
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (reportLog.getToUser().getId() == curUser.getId()) {
			FPriceSpeed fPriceSpeed = fPriceSpeedService.queryByReportLogId(reportLogId);

			if (fPriceSpeed == null) {
				fPriceSpeed = new FPriceSpeed();
			}
			Date insertDate = reportLog.getCreateTime();

			Integer year = insertDate.getYear() + 1900;
			Integer month = insertDate.getMonth() + 1;
			Integer lastYear = year - 1;
			fPriceSpeed.setLastYear(lastYear);
			fPriceSpeed.setThisYear(year);
			fPriceSpeed.setThisMonth(month);
			ReportFormRemark reportFormRemark = reportFormRemarkService.queryByReportIdAndYear(reportLog.getReport().getId(),reportLog.getWriteYear());
			model.addAttribute("reportFormRemark", reportFormRemark);
			model.addAttribute("reportLog", reportLog);
			model.addAttribute("fPriceSpeed", fPriceSpeed);
			urlReturn = "/form/form_tsjj";
		} else {
			return "redirect:/hasNoRight";
		}
		logger.info("processing in tsjj edit");

		return urlReturn;
	}

	@RequestMapping(value = "/tsjj/view/{report_log_id}")
	public String view(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (curUser.getRole().getCode().equals("USER")) {
			if (reportLog.getToUser().getId() != curUser.getId()) {
				return "redirect:/hasNoRight";
			}
		}
		FPriceSpeed fPriceSpeed = fPriceSpeedService.queryByReportLogId(reportLogId);
		model.addAttribute("fPriceSpeed", fPriceSpeed);
		model.addAttribute("reportLog", reportLog);

		return "/form/form_tsjj_view";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/tsjj/save", method = RequestMethod.POST)
	public @ResponseBody R save(@ModelAttribute("fPriceSpeed") FPriceSpeed fPriceSpeed, HttpServletRequest request) {
		String flag = request.getParameter("flag");
		try {
			ReportLog reportLog = reportLogService.find(fPriceSpeed.getReportLogId());
			if (fPriceSpeed.getId() > 0) {
				FPriceSpeed fPriceSpeedTemp = fPriceSpeedService.find(fPriceSpeed.getId());
				fPriceSpeedTemp = fPriceSpeed;
				fPriceSpeedTemp.setUpdateTime(new Date());
				fPriceSpeedService.update(fPriceSpeedTemp);
			} else {
				Date insertDate = reportLog.getCreateTime();

				Integer year = insertDate.getYear() + 1900;
				Integer month = insertDate.getMonth() + 1;
				Integer lastYear = year - 1;
				fPriceSpeed.setLastYear(lastYear);
				fPriceSpeed.setThisYear(year);
				fPriceSpeed.setThisMonth(month);
				fPriceSpeed.setCreateTime(new Date());
				fPriceSpeed.setUpdateTime(new Date());
				fPriceSpeedService.save(fPriceSpeed);
			}
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
