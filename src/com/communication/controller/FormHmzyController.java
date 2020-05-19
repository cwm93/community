/**
 * 
 */
package com.communication.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.communication.entity.Data;
import com.communication.entity.FHmzy;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FHmzyService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;
import com.communication.util.ImportExecl;

/**
 * @author liliang
 *
 */
@Controller
public class FormHmzyController {
	private static final Logger logger = LoggerFactory.getLogger(FormHmzyController.class);

	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FHmzyService formService;

	/**
	 * 统计号码数量
	 **/

	@RequestMapping(value = "/hmzy/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		String urlReturn = null;
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (reportLog.getToUser().getId() == curUser.getId()) {
			urlReturn = "/form/form_hmzy";
		} else {
			return "redirect:/hasNoRight";
		}

		model.addAttribute("reportLog", reportLog);
		return urlReturn;

	}

	@RequestMapping(value = "/hmzy/view/{report_log_id}")
	public String view(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {

		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);
		List<FHmzy> fHmzyList = null;

		if (curUser.getRole().getCode().equals("USER")) {
			if (reportLog.getToUser().getId() != curUser.getId()) {
				return "redirect:/hasNoRight";
			}
		}
		int codeSum = 0;// 局号数
		int logicUsegeNumber = 0;// 逻辑号码在用数量
		int physicsAssignedNumber = 0;// 物理号码已分配个数
		int occupiedNumber = 0;// 占用数量

		fHmzyList = formService.queryByReportLog(reportLog.getId(), reportLog.getToUser().getId());
		if (fHmzyList != null) {
			codeSum = fHmzyList.size();
		} else {
			codeSum = 0;
		}
		logicUsegeNumber = formService.sumByReportLogId("logicUsegeNumber", reportLogId);
		physicsAssignedNumber = formService.sumByReportLogId("physicsAssignedNumber", reportLogId);
		occupiedNumber = formService.sumByReportLogId("occupiedNumber", reportLogId);

		logger.info("view to form-form_hmzy_view");
		model.addAttribute("FHmzyList", fHmzyList);
		model.addAttribute("reportLog", reportLog);
		model.addAttribute("codeSum", codeSum);
		model.addAttribute("logicUsegeNumber", logicUsegeNumber);
		model.addAttribute("physicsAssignedNumber", physicsAssignedNumber);
		model.addAttribute("occupiedNumber", occupiedNumber);

		return "/form/form_hmzy_view";

	}

	@RequestMapping(value = "/hmzy/import", method = RequestMethod.POST)
	public String importExcel(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Data data = Data.failure("提交失败");
		User user = (User) request.getSession().getAttribute("curUser");

		String userName = user.getRealname();
		String company = user.getCompany();
		String mobile = user.getMobile();
		String email = user.getEmail();
		long userId = user.getId();
		long telecomOperatorId = user.getTelecomOperator().getId();
		long reportLogId = Long.valueOf(request.getParameter("reportLogId"));

		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ImportExecl poi = new ImportExecl();
			// 先删除
			formService.deleteByReportLogId(reportLogId);
			// 导入
			if (poi.validateExcel(path + "/" + fileName)) {

				List<List<String>> list = poi.read(path + "/" + fileName);
				if (list != null && list.size() > 0) {
					for (int i = 1; i < list.size(); i++) {
						List<String> cellList = list.get(i);
						FHmzy form = new FHmzy();
						form.setCode(cellList.get(0).trim());
						form.setZoneCode(cellList.get(1).trim());
						form.setLogicUsegeNumber(Integer.valueOf(cellList.get(2).trim()));
						form.setPhysicsAssignedNumber(Integer.valueOf(cellList.get(3).trim()));
						form.setOccupiedNumber(Integer.valueOf(cellList.get(4).trim()));
						form.setCompany(company);
						form.setUserName(userName);
						form.setMobile(mobile);
						form.setEmail(email);
						form.setInsertTime(new Date());
						form.setInsertUserId(userId);
						form.setReportLogId(reportLogId);
						form.setTelecomOperatorId(telecomOperatorId);
						formService.save(form);
					}
					/************ 标记已完成 ********************/
					ReportLog reportLog = reportLogService.find(reportLogId);
					reportLog.setStatus("1");
					reportLog.setAuditStatus("0");
					reportLog.setSubmitTime(new Date());
					reportLogService.update(reportLog);
					data = Data.success("提交成功", "/report/history", "进入历史报表");
				} else {
					data = Data.failure("提交失败，导入的数据不能为空");
				}
			} else {
				data = Data.failure("提交失败，文件格式出错了，请导入正确的xls、xlsx文件");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("data", data);
		return "redirect:/message";
	}

}
