package com.communication.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.FIndustryCard;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FIndustryCardService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;
import com.communication.util.R;

/**
 * @author Administrator
 * @关于强化行业卡实名登记管理工作要求自查月报表
 */

@Controller
public class FormIndustryCard {

	private static final Logger logger = LoggerFactory.getLogger(FormIndustryCard.class);
	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FIndustryCardService industryCardService;

	@RequestMapping("/nhyk/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		String urlReturn = null;
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (reportLog.getToUser().getId() == curUser.getId()) {
			FIndustryCard fIndustryCard = industryCardService.queryByReportLogId(reportLogId);

			if (fIndustryCard == null) {
				fIndustryCard = new FIndustryCard();
			}

			model.addAttribute("reportLog", reportLog);
			model.addAttribute("fIndustryCard", fIndustryCard);
			urlReturn = "/form/form_nhyk";
		} else {
			return "redirect:/hasNoRight";
		}
		logger.info("processing in industry card edit");

		return urlReturn;
	}

	@RequestMapping(value = "/nhyk/view/{report_log_id}")
	public String view(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (curUser.getRole().getCode().equals("USER")) {
			if (reportLog.getToUser().getId() != curUser.getId()) {
				return "redirect:/hasNoRight";
			}
		}
		FIndustryCard fIndustryCard = industryCardService.queryByReportLogId(reportLogId);
		model.addAttribute("fIndustryCard", fIndustryCard);
		model.addAttribute("reportLog", reportLog);

		return "/form/form_nhyk_view";
	}

	@RequestMapping(value = "/nhyk/save", method = RequestMethod.POST)
	public @ResponseBody R save(@ModelAttribute("fIndustryCard") FIndustryCard fIndustryCard,
			@RequestParam("flag") String flag) {
		try {
			if (fIndustryCard.getId() > 0) {
				FIndustryCard temp = new FIndustryCard();
				temp = fIndustryCard;
				temp.setUpdateTime(new Date());
				industryCardService.update(temp);
			} else {
				fIndustryCard.setCreateTime(new Date());
				fIndustryCard.setUpdateTime(new Date());
				industryCardService.save(fIndustryCard);
			}

			ReportLog reportLog = reportLogService.find(fIndustryCard.getReportLogId());
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
			return R.error("提交失败");
		}
		return R.ok("操作成功");
	}

}
