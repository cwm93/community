package com.communication.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

import com.communication.entity.FAppealLocal;
import com.communication.entity.FAppealLocalTopTen;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FAppealLocalService;
import com.communication.service.FAppealLocalTopTenService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;
import com.communication.util.R;

/**
 * 本地投诉情况
 */
@Controller
@RequestMapping("/appeal_local")
public class FormAppealLocalController {
	
	private static final Logger logger = LoggerFactory.getLogger(FormAppealLocalController.class);
	
	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FAppealLocalService appealLocalService;
	@Resource
	private FAppealLocalTopTenService appealLocalTopTenService;
	
	/**
	 * 编辑
	 **/
	@RequestMapping("/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);
		if (reportLog.getToUser().getId() == curUser.getId()) {
			FAppealLocal appealLocal = appealLocalService.queryByReportLogId(reportLogId);
			if (null == appealLocal) {
				List<FAppealLocalTopTen> appealLocalTopTenList = new ArrayList<FAppealLocalTopTen>(10);
				for(int i=0;i<10;i++) {
					FAppealLocalTopTen appealLocalTopTen = new FAppealLocalTopTen();
					appealLocalTopTen.setType(i);
					appealLocalTopTenList.add(appealLocalTopTen);
				}
				appealLocal = new FAppealLocal();
				appealLocal.setAppealLocalTopTenList(appealLocalTopTenList);
			}
			model.addAttribute("reportLog", reportLog);
			model.addAttribute("appealLocal", appealLocal);
		} else {
			return "redirect:/hasNoRight";
		}
		logger.info("编辑有效申诉量统计情况：reportLogId：" + reportLogId);
		return "/form/form_appeal_local";
	}

	/**
	 * 预览
	 **/
	@RequestMapping(value = "/view/{report_log_id}")
	public String view(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (curUser.getRole().getCode().equals("USER")) {
			if (reportLog.getToUser().getId() != curUser.getId()) {
				return "redirect:/hasNoRight";
			}
		}

		FAppealLocal appealLocal = appealLocalService.queryByReportLogId(reportLogId);
		model.addAttribute("reportLog", reportLog);
		model.addAttribute("appealLocal", appealLocal);

		return "/form/form_appeal_local_view";
	}

	/**
	 * 保存
	 **/
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody R save(@ModelAttribute("appealLocal") FAppealLocal appealLocal,@RequestParam("flag") String flag) throws Exception{
		try {
			
			if (appealLocal.getId() > 0) {
				appealLocal.setUpdateTime(new Date());
				appealLocalService.update(appealLocal);
			} else {
				appealLocal.setInsertTime(new Date());
				appealLocal.setUpdateTime(new Date());
				appealLocalService.save(appealLocal);
			}
			System.out.println(appealLocal.toString());
			
			
			ReportLog reportLog = reportLogService.find(appealLocal.getReportLogId());
			if ("1".equals(flag)) {
				reportLog.setStatus("1");
				reportLog.setAuditStatus("0");
				reportLog.setSubmitTime(new Date());
			} else {
				reportLog.setStatus("2");
			}
			reportLogService.update(reportLog);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return R.error("操作失败");
		}
		return R.ok("操作成功");
	}
	
	
	
	

}
