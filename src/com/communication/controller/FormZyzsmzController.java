package com.communication.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.FZyzsmz;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FZyzsmzService;
import com.communication.service.ReportLogService;
import com.communication.service.UserService;
import com.communication.util.R;

/**
 * @author Administrator 电话实名制志愿者监督检查情况
 */
@Controller
public class FormZyzsmzController {

	private static final Logger logger = Logger.getLogger(FormZyzsmzController.class);
	@Resource
	private UserService userService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FZyzsmzService formService;

	@RequestMapping(value = "/dhsmz/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		logger.info("edit dhsmz form");
		User curUser = (User) session.getAttribute("curUser");
		String urlReturn = null;
		ReportLog reportLog = reportLogService.find(reportLogId);
		if (reportLog.getToUser().getId() == curUser.getId()) {
			FZyzsmz fZyzsmz = formService.queryByReportLogId(reportLog.getId());
			if (fZyzsmz == null) {
				fZyzsmz = new FZyzsmz();
			}
			model.addAttribute("reportLog", reportLog);
			model.addAttribute("fZyzsmz", fZyzsmz);
			urlReturn = "/form/form_dhsmz";
		} else {
			urlReturn = "redirect:/hasNoRight";
		}
		return urlReturn;
	}

	@RequestMapping(value = "/dhsmz/view/{report_log_id}")
	public String view(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (curUser.getRole().getCode().equals("USER")) {
			if (reportLog.getToUser().getId() != curUser.getId()) {
				return "redirect:/hasNoRight";
			}
		}
		FZyzsmz entity = formService.queryByReportLogId(reportLog.getId());
		model.addAttribute("fZyzsmz", entity);
		model.addAttribute("reportLog", reportLog);
		return "/form/form_dhsmz_view";
	}

	@RequestMapping(value = "/dhsmz/save", method = RequestMethod.POST)
	public @ResponseBody R save(@ModelAttribute("fZyzsmz") FZyzsmz entity, @RequestParam("flag") String flag) {
		try {
			if (entity.getId() > 0) {
				FZyzsmz tempFZyzsmz = formService.find(entity.getId());
				tempFZyzsmz.setJcdxmds(entity.getJcdxmds());
				tempFZyzsmz.setJcdxmdhgs(entity.getJcdxmdhgs());
				tempFZyzsmz.setZsqymdjcs(entity.getZsqymdjcs());
				tempFZyzsmz.setZsqymdshg(entity.getZsqymdshg());
				tempFZyzsmz.setCheckNumber(entity.getCheckNumber());
				tempFZyzsmz.setComment(entity.getComment());
				tempFZyzsmz.setUpdateTime(new Date());
				formService.update(tempFZyzsmz);
			} else {
				formService.save(entity);
			}
			ReportLog reportLog = reportLogService.find(entity.getReportLogId());
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
		return R.ok("提交成功");
	}

}
