package com.communication.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.Data;
import com.communication.entity.FHouseholdBroadbandTariff;
import com.communication.entity.FIndustryCard;
import com.communication.entity.FPhoneUserRealIdentity;
import com.communication.entity.FPriceSpeed;
import com.communication.entity.FSpamMessage;
import com.communication.entity.FXxzp;
import com.communication.entity.FZyzsmz;
import com.communication.entity.Report;
import com.communication.entity.ReportLog;
import com.communication.entity.ReportRemark;
import com.communication.entity.Role;
import com.communication.entity.User;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.FHmzyService;
import com.communication.service.FHouseholdBroadbandTariffService;
import com.communication.service.FIndustryCardService;
import com.communication.service.FPhoneUserRealIdentityService;
import com.communication.service.FPriceSpeedService;
import com.communication.service.FSpamMessageService;
import com.communication.service.FXxzpService;
import com.communication.service.FZyzsmzService;
import com.communication.service.ReportLogService;
import com.communication.service.ReportRemarkService;
import com.communication.service.ReportService;
import com.communication.service.UserService;
import com.communication.util.Constants;

/**
 * @author Administrator
 *
 */
@Controller
public class SummaryController {

	private static final Logger logger = LoggerFactory.getLogger(SummaryController.class);

	@Resource
	private ReportService reportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private UserService userService;
	@Resource
	private FZyzsmzService fzyzsmzService;// 志愿者实名制检查
	@Resource
	private FHmzyService hmzyService;// 号码资源
	@Resource
	private FXxzpService xxzpService;// 信息诈骗
	@Resource
	private FSpamMessageService spamMessageService;// 治理垃圾短消息
	@Resource
	private FIndustryCardService industryCardService;// 年行业卡
	@Resource
	private FPriceSpeedService priceSpeedService;// 提速降价
	@Resource
	private FHouseholdBroadbandTariffService householdBroadbandTariffService;// 宽带资费
	@Resource
	private FPhoneUserRealIdentityService phoneUserRealIdentityService;// 基础电信运营商电话用户真实身份信息登记
	@Resource
	private ReportRemarkService reportRemarkService;

	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		logger.info("processing in summary");
		User curUser = userService.find((Long) session.getAttribute("curUserId"));
		Role role = curUser.getRole();
		List<Report> reportList = new ArrayList<Report>();
		List<ReportRemark> reportRemarkList = new ArrayList<ReportRemark>();
		try {
			if (role.getCode().equals("ADMIN")) {
				reportList = reportService.findAll();
				reportRemarkList = reportRemarkService.queryAll();
			} else if (role.getCode().equals("SUBADMIN")) {
				reportList.addAll(curUser.getAssignedReports());
				reportRemarkList = reportRemarkService.queryByUserId(curUser.getId());
			} else {
				return "redirect:/permissionDenied";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("reportList", reportList);
		model.addAttribute("reportRemarkList", reportRemarkList);
		return "/admin/summary";
	}

	/**
	 * @author liliang
	 * @desc 进入统计页面
	 * @param formCode
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/{formCode}", method = RequestMethod.GET)
	public String summaryViewDetail(@PathVariable("formCode") String formCode, Model model, HttpSession session) {
		logger.info("processing in summary");
		Report report = reportService.findByFormCode(formCode);
		model.addAttribute("report", report);
		return "/admin/summary_" + formCode;
	}
	
	/**
	 * @author liliang
	 * @desc 进入统计页面
	 * @param formCode
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/xxzpHistory", method = RequestMethod.GET)
	public String xxzpHistory(Model model, HttpSession session) {
		logger.info("processing in summary");
		Report report = reportService.findByFormCode("xxzp");
		model.addAttribute("report", report);
		return "/admin/summary_xxzp_history";
	}

	/**
	 * @author liliang
	 * @desc 电话实名制志愿者监督检查情况
	 * @param year,month,reportId,reportLogId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/dhsmzJson", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> dhsmz(HttpServletRequest request, HttpServletResponse reponse,
			HttpSession session) {
		Map<String, Object> map = new HashMap<>();

		Long reportId = Long.valueOf(request.getParameter("reportId"));
		Integer loadingYear = Integer.valueOf(request.getParameter("loadingYear"));
		Integer loadingMonth = Integer.valueOf(request.getParameter("loadingMonth"));

		List<ReportLog> reportLogList = new ArrayList<ReportLog>();
		Data data = Data.failure("获取数据失败");

		// 1-电信；2-移动；3-联通
		FZyzsmz f_telecom = new FZyzsmz();
		FZyzsmz f_mobile = new FZyzsmz();
		FZyzsmz f_unicom = new FZyzsmz();

		try {
			reportLogList = reportLogService.queryByReport(reportId, loadingYear, loadingMonth, "0");

			if (reportLogList != null && reportLogList.size() > 0) {
				for (ReportLog reportLog : reportLogList) {
					// 审核后的进入统计
					if (reportLog.getAuditStatus() != null && reportLog.getAuditStatus().equals("1")) {
						// 1-电信；2-移动；3-联通
						if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
							f_telecom = fzyzsmzService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 2) {
							f_mobile = fzyzsmzService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 3) {
							f_unicom = fzyzsmzService.queryByReportLogId(reportLog.getId());
						}
					}
				}
			}
			data = Data.success("获取数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.failure("获取数据出现异常");
		}

		map.put("loadingYear", loadingYear);
		map.put("loadingMonth", loadingMonth);
		map.put("reportLogList", reportLogList);
		map.put("f_telecom", f_telecom);
		map.put("f_mobile", f_mobile);
		map.put("f_unicom", f_unicom);
		map.put("data", data);

		return map;
	}

	/**
	 * @author liliang
	 * @desc 号码资源
	 * @param year,month,reportId,reportLogId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/hmzyJson", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> hmzy(HttpServletRequest request, HttpServletResponse reponse,
			HttpSession session) {
		Map<String, Object> map = new HashMap<>();

		Long reportId = Long.valueOf(request.getParameter("reportId"));
		Integer loadingYear = Integer.valueOf(request.getParameter("loadingYear"));
		Integer loadingMonth = Integer.valueOf(request.getParameter("loadingMonth"));

		List<ReportLog> reportLogList = new ArrayList<ReportLog>();
		// 电信
		long d_codeSum = 0;// 局号数
		int d_logicUsegeNumber = 0;// 逻辑号码在用数量
		int d_physicsAssignedNumber = 0;// 物理号码已分配个数
		int d_occupiedNumber = 0;// 占用数量
		// 7-移动（铁通）
		long y_codeSum = 0;// 局号数
		int y_logicUsegeNumber = 0;// 逻辑号码在用数量
		int y_physicsAssignedNumber = 0;// 物理号码已分配个数
		int y_occupiedNumber = 0;// 占用数量
		// 联通
		long l_codeSum = 0;// 局号数
		int l_logicUsegeNumber = 0;// 逻辑号码在用数量
		int l_physicsAssignedNumber = 0;// 物理号码已分配个数
		int l_occupiedNumber = 0;// 占用数量
		Data data = Data.failure("获取数据失败");
		try {
			reportLogList = reportLogService.queryByReport(reportId, loadingYear, loadingMonth, "0");

			if (reportLogList != null && reportLogList.size() > 0) {
				for (ReportLog reportLog : reportLogList) {
					long reportLogId = reportLog.getId();
					// 审核后的进入统计
					if (reportLog.getAuditStatus() != null && reportLog.getAuditStatus().equals("1")) {
						// 1-电信；7-移动（铁通）；3-联通
						if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
							d_codeSum = hmzyService.count("id", reportLogId);
							d_logicUsegeNumber = hmzyService.sumByReportLogId("logicUsegeNumber", reportLogId);
							d_physicsAssignedNumber = hmzyService.sumByReportLogId("physicsAssignedNumber",
									reportLogId);
							d_occupiedNumber = hmzyService.sumByReportLogId("occupiedNumber", reportLogId);
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 7) {
							y_codeSum = hmzyService.count("id", reportLogId);
							y_logicUsegeNumber = hmzyService.sumByReportLogId("logicUsegeNumber", reportLogId);
							y_physicsAssignedNumber = hmzyService.sumByReportLogId("physicsAssignedNumber",
									reportLogId);
							y_occupiedNumber = hmzyService.sumByReportLogId("occupiedNumber", reportLogId);
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 3) {
							l_codeSum = hmzyService.count("id", reportLogId);
							l_logicUsegeNumber = hmzyService.sumByReportLogId("logicUsegeNumber", reportLogId);
							l_physicsAssignedNumber = hmzyService.sumByReportLogId("physicsAssignedNumber",
									reportLogId);
							l_occupiedNumber = hmzyService.sumByReportLogId("occupiedNumber", reportLogId);
						}
					}
				}
			}
			data = Data.success("获取数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.failure("获取数据出现异常");
		}

		map.put("loadingYear", loadingYear);
		map.put("loadingMonth", loadingMonth);
		map.put("reportLogList", reportLogList);

		map.put("d_codeSum", d_codeSum);
		map.put("d_logicUsegeNumber", d_logicUsegeNumber);
		map.put("d_physicsAssignedNumber", d_physicsAssignedNumber);
		map.put("d_occupiedNumber", d_occupiedNumber);

		map.put("y_codeSum", y_codeSum);
		map.put("y_logicUsegeNumber", y_logicUsegeNumber);
		map.put("y_physicsAssignedNumber", y_physicsAssignedNumber);
		map.put("y_occupiedNumber", y_occupiedNumber);

		map.put("l_codeSum", l_codeSum);
		map.put("l_logicUsegeNumber", l_logicUsegeNumber);
		map.put("l_physicsAssignedNumber", l_physicsAssignedNumber);
		map.put("l_occupiedNumber", l_occupiedNumber);

		map.put("data", data);

		return map;
	}
	/**
	 * @author liliang
	 * @desc 打击通讯信息诈骗相关业务数据---历史数据调用
	 * @param year,week,reportId,reportLogId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/xxzpJsonHistory", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> xxzpHistory(HttpServletRequest request, HttpServletResponse reponse,
			HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		Long reportId = Long.valueOf(request.getParameter("reportId"));
		Integer loadingYear = request.getParameter("loadingYear") == null ? 2017
				: Integer.valueOf(request.getParameter("loadingYear"));
		Integer loadingWeek = request.getParameter("loadingWeek") == null ? 27
				: Integer.valueOf(request.getParameter("loadingWeek"));

		List<ReportLog> reportLogList = new ArrayList<ReportLog>();

		// 1-电信；2-移动；3-联通
		FXxzp f_telecom = new FXxzp();
		FXxzp f_mobile = new FXxzp();
		FXxzp f_unicom = new FXxzp();

		Data data = Data.failure("获取数据失败");
		try {
			reportLogList = reportLogService.queryByReportAndWeek(reportId, loadingYear, loadingWeek, "0");

			if (reportLogList != null && reportLogList.size() > 0) {
				for (ReportLog reportLog : reportLogList) {
					// 审核后的进入统计
					if (reportLog.getAuditStatus() != null && reportLog.getAuditStatus().equals("1")) {
						// 1-电信；2-移动；3-联通
						if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
							f_telecom = xxzpService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 2) {
							f_mobile = xxzpService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 3) {
							f_unicom = xxzpService.queryByReportLogId(reportLog.getId());
						}
					}
				}
			}
			data = Data.success("获取数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.failure("获取数据出现异常");
		}

		map.put("loadingYear", loadingYear);
		map.put("loadingWeek", loadingWeek);
		map.put("reportLogList", reportLogList);
		map.put("f_telecom", f_telecom);
		map.put("f_mobile", f_mobile);
		map.put("f_unicom", f_unicom);
		map.put("data", data);
		return map;
	}
	/**
	 * @author liliang
	 * @desc 打击通讯信息诈骗相关业务数据
	 * @param year,week,reportId,reportLogId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/xxzpJson", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> xxzp(HttpServletRequest request, HttpServletResponse reponse,
			HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		Long reportId = Long.valueOf(request.getParameter("reportId"));
		Integer loadingYear = Integer.valueOf(request.getParameter("loadingYear"));
		Integer loadingMonth = Integer.valueOf(request.getParameter("loadingMonth"));

		List<ReportLog> reportLogList = new ArrayList<ReportLog>();

		// 1-电信；2-移动；3-联通
		FXxzp f_telecom = new FXxzp();
		FXxzp f_mobile = new FXxzp();
		FXxzp f_unicom = new FXxzp();

		Data data = Data.failure("获取数据失败");
		try {
			reportLogList = reportLogService.queryByReportAndMonth(reportId, loadingYear, loadingMonth, "0");

			if (reportLogList != null && reportLogList.size() > 0) {
				for (ReportLog reportLog : reportLogList) {
					// 审核后的进入统计
					if (reportLog.getAuditStatus() != null && reportLog.getAuditStatus().equals("1")) {
						// 1-电信；2-移动；3-联通
						if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
							f_telecom = xxzpService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 2) {
							f_mobile = xxzpService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 3) {
							f_unicom = xxzpService.queryByReportLogId(reportLog.getId());
						}
					}
				}
			}
			data = Data.success("获取数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.failure("获取数据出现异常");
		}

		map.put("loadingYear", loadingYear);
		map.put("loadingMonth", loadingMonth);
		map.put("reportLogList", reportLogList);
		map.put("f_telecom", f_telecom);
		map.put("f_mobile", f_mobile);
		map.put("f_unicom", f_unicom);
		map.put("data", data);
		return map;
	}

	/**
	 * @author liliang
	 * @desc 清理垃圾短信息情况月报表
	 * @param year,month,reportId,reportLogId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/ljdxxJson", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> ljdxx(HttpServletRequest request, HttpServletResponse reponse,
			HttpSession session) {
		Map<String, Object> map = new HashMap<>();

		Long reportId = Long.valueOf(request.getParameter("reportId"));
		Integer loadingYear = Integer.valueOf(request.getParameter("loadingYear"));
		Integer loadingMonth = Integer.valueOf(request.getParameter("loadingMonth"));

		List<ReportLog> reportLogList = new ArrayList<ReportLog>();

		// 1-电信；2-移动；3-联通
		FSpamMessage f_telecom = new FSpamMessage();
		FSpamMessage f_mobile = new FSpamMessage();
		FSpamMessage f_unicom = new FSpamMessage();

		Data data = Data.failure("获取数据失败");
		try {
			reportLogList = reportLogService.queryByReport(reportId, loadingYear, loadingMonth, "0");

			if (reportLogList != null && reportLogList.size() > 0) {
				for (ReportLog reportLog : reportLogList) {
					// 审核后的进入统计
					if (reportLog.getAuditStatus() != null && reportLog.getAuditStatus().equals("1")) {
						// 1-电信；2-移动；3-联通
						if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
							f_telecom = spamMessageService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 2) {
							f_mobile = spamMessageService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 3) {
							f_unicom = spamMessageService.queryByReportLogId(reportLog.getId());
						}
					}
				}
			}
			data = Data.success("获取数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.failure("获取数据出现异常");
		}

		map.put("loadingYear", loadingYear);
		map.put("loadingMonth", loadingMonth);
		map.put("reportLogList", reportLogList);
		map.put("f_telecom", f_telecom);
		map.put("f_mobile", f_mobile);
		map.put("f_unicom", f_unicom);
		map.put("data", data);

		return map;
	}

	/**
	 * @author liliang
	 * @desc 年行业卡
	 * @param year,month,reportId,reportLogId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/nhykJson", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> nhyk(HttpServletRequest request, HttpServletResponse reponse,
			HttpSession session) {
		Map<String, Object> map = new HashMap<>();

		Long reportId = Long.valueOf(request.getParameter("reportId"));
		Integer loadingYear = Integer.valueOf(request.getParameter("loadingYear"));
		Integer loadingMonth = Integer.valueOf(request.getParameter("loadingMonth"));

		List<ReportLog> reportLogList = new ArrayList<ReportLog>();

		// 1-电信；2-移动；3-联通
		FIndustryCard f_telecom = new FIndustryCard();
		FIndustryCard f_mobile = new FIndustryCard();
		FIndustryCard f_unicom = new FIndustryCard();

		Data data = Data.failure("获取数据失败");
		try {
			reportLogList = reportLogService.queryByReport(reportId, loadingYear, loadingMonth, "0");

			if (reportLogList != null && reportLogList.size() > 0) {
				for (ReportLog reportLog : reportLogList) {
					// 审核后的进入统计
					if (reportLog.getAuditStatus() != null && reportLog.getAuditStatus().equals("1")) {
						// 1-电信；2-移动；3-联通
						if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
							f_telecom = industryCardService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 2) {
							f_mobile = industryCardService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 3) {
							f_unicom = industryCardService.queryByReportLogId(reportLog.getId());
						}
					}
				}
			}
			data = Data.success("获取数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.failure("获取数据出现异常");
		}

		map.put("loadingYear", loadingYear);
		map.put("loadingMonth", loadingMonth);
		map.put("reportLogList", reportLogList);
		map.put("f_telecom", f_telecom);
		map.put("f_mobile", f_mobile);
		map.put("f_unicom", f_unicom);
		map.put("data", data);

		return map;
	}

	/**
	 * @author liliang
	 * @desc 宽带提速降价
	 * @param year,month,reportId,reportLogId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/tsjjJson", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> tsjj(HttpServletRequest request, HttpServletResponse reponse,
			HttpSession session) {
		Map<String, Object> map = new HashMap<>();

		Long reportId = Long.valueOf(request.getParameter("reportId"));
		Integer loadingYear = Integer.valueOf(request.getParameter("loadingYear"));
		Integer loadingMonth = Integer.valueOf(request.getParameter("loadingMonth"));

		List<ReportLog> reportLogList = new ArrayList<ReportLog>();

		FPriceSpeed f_telecom = new FPriceSpeed();
		FPriceSpeed f_mobile = new FPriceSpeed();
		FPriceSpeed f_unicom = new FPriceSpeed();

		Data data = Data.failure("获取数据失败");
		try {
			reportLogList = reportLogService.queryByReport(reportId, loadingYear, loadingMonth, "0");

			if (reportLogList != null && reportLogList.size() > 0) {
				for (ReportLog reportLog : reportLogList) {
					// 审核后的进入统计
					if (reportLog.getAuditStatus() != null && reportLog.getAuditStatus().equals("1")) {
						// 1-电信；2-移动；3-联通
						if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
							f_telecom = priceSpeedService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 2) {
							f_mobile = priceSpeedService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 3) {
							f_unicom = priceSpeedService.queryByReportLogId(reportLog.getId());
						}
					}
				}
			}
			data = Data.success("获取数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.failure("获取数据出现异常");
		}

		map.put("loadingYear", loadingYear);
		map.put("loadingMonth", loadingMonth);
		map.put("reportLogList", reportLogList);
		map.put("f_telecom", f_telecom);
		map.put("f_mobile", f_mobile);
		map.put("f_unicom", f_unicom);
		map.put("data", data);

		return map;
	}

	/**
	 * @author liliang
	 * @desc 用户宽带资费
	 * @param year,month,reportId,reportLogId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/yhkdzfJson", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> yhkdzf(HttpServletRequest request, HttpServletResponse reponse,
			HttpSession session) {
		Map<String, Object> map = new HashMap<>();

		Long reportId = Long.valueOf(request.getParameter("reportId"));
		Integer loadingYear = Integer.valueOf(request.getParameter("loadingYear"));
		Integer loadingMonth = Integer.valueOf(request.getParameter("loadingMonth"));

		List<ReportLog> reportLogList = new ArrayList<ReportLog>();

		// 1-电信；2-移动；3-联通,5-长城宽带;6-东方有线
		FHouseholdBroadbandTariff f_telecom = new FHouseholdBroadbandTariff();
		FHouseholdBroadbandTariff f_mobile = new FHouseholdBroadbandTariff();
		FHouseholdBroadbandTariff f_unicom = new FHouseholdBroadbandTariff();
		FHouseholdBroadbandTariff f_cckd = new FHouseholdBroadbandTariff();
		FHouseholdBroadbandTariff f_dfyx = new FHouseholdBroadbandTariff();

		Data data = Data.failure("获取数据失败");
		try {
			reportLogList = reportLogService.queryByReport(reportId, loadingYear, loadingMonth, "0");

			if (reportLogList != null && reportLogList.size() > 0) {
				for (ReportLog reportLog : reportLogList) {
					// 审核后的进入统计
					if (reportLog.getAuditStatus() != null && reportLog.getAuditStatus().equals("1")) {
						// 1-电信；2-移动；3-联通
						if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
							f_telecom = householdBroadbandTariffService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 2) {
							f_mobile = householdBroadbandTariffService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 3) {
							f_unicom = householdBroadbandTariffService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 5) {
							f_cckd = householdBroadbandTariffService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 6) {
							f_dfyx = householdBroadbandTariffService.queryByReportLogId(reportLog.getId());
						}
					}
				}
			}
			data = Data.success("获取数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.failure("获取数据出现异常");
		}

		map.put("loadingYear", loadingYear);
		map.put("loadingMonth", loadingMonth);
		map.put("reportLogList", reportLogList);
		map.put("f_telecom", f_telecom);
		map.put("f_mobile", f_mobile);
		map.put("f_unicom", f_unicom);
		map.put("f_cckd", f_cckd);
		map.put("f_dfyx", f_dfyx);
		map.put("data", data);

		return map;
	}

	/**
	 * @author liliang
	 * @desc 用户实名制
	 * @param year,month,reportId,reportLogId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/yhsmzJson", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> yhsmz(HttpServletRequest request, HttpServletResponse reponse,
			HttpSession session) {
		Map<String, Object> map = new HashMap<>();

		Long reportId = Long.valueOf(request.getParameter("reportId"));
		Integer loadingYear = Integer.valueOf(request.getParameter("loadingYear"));
		Integer loadingMonth = Integer.valueOf(request.getParameter("loadingMonth"));

		List<ReportLog> reportLogList = new ArrayList<ReportLog>();

		// 1-电信；2-移动；3-联通;7-铁通
		FPhoneUserRealIdentity f_telecom = new FPhoneUserRealIdentity();
		FPhoneUserRealIdentity f_mobile = new FPhoneUserRealIdentity();
		FPhoneUserRealIdentity f_unicom = new FPhoneUserRealIdentity();
		FPhoneUserRealIdentity f_railcom = new FPhoneUserRealIdentity();
		
		Data data = Data.failure("获取数据失败");
		try {
			reportLogList = reportLogService.queryByReport(reportId, loadingYear, loadingMonth, "0");

			if (reportLogList != null && reportLogList.size() > 0) {
				for (ReportLog reportLog : reportLogList) {
					// 审核后的进入统计
					if (reportLog.getAuditStatus() != null && reportLog.getAuditStatus().equals("1")) {
						// 1-电信；2-移动；3-联通;7-铁通
						if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
							f_telecom = phoneUserRealIdentityService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 2) {
							f_mobile = phoneUserRealIdentityService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 3) {
							f_unicom = phoneUserRealIdentityService.queryByReportLogId(reportLog.getId());
						} else if (reportLog.getToUser().getTelecomOperator().getId() == 7) {
							f_railcom = phoneUserRealIdentityService.queryByReportLogId(reportLog.getId());
						}
					}
				}
			}
			data = Data.success("获取数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.failure("获取数据出现异常");
		}
		
		map.put("loadingYear", loadingYear);
		map.put("loadingMonth", loadingMonth);
		map.put("reportLogList", reportLogList);
		map.put("f_telecom", f_telecom);
		map.put("f_mobile", f_mobile);
		map.put("f_unicom", f_unicom);
		map.put("f_railcom", f_railcom);
		map.put("data", data);

		return map;
	}

	/**
	 * @author liliang
	 * @desc 报表备注
	 * @param year,month,reportId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/remark", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> remark(HttpServletRequest request, HttpServletResponse reponse) {
		Map<String, Object> map = new HashMap<>();
		Data data = Data.failure("获取数据失败");

		long reportId = Long.valueOf(request.getParameter("reportId"));
		String loadingYear = request.getParameter("loadingYear");
		String loadingMonth = request.getParameter("loadingMonth") == null ? "" : request.getParameter("loadingMonth");
		String loadingWeek = request.getParameter("loadingWeek") == null ? "" : request.getParameter("loadingWeek");

		try {
			ReportRemark reportRemark = new ReportRemark();
			if(!loadingWeek.equals("") && reportId==1 ){
				reportRemark = reportRemarkService.queryByReportIdAndYearWeek(reportId, loadingYear,loadingWeek);
			}else{
				reportRemark = reportRemarkService.queryByReportIdAndYearMonth(reportId, loadingYear,loadingMonth);
			}
			map.put("reportRemark", reportRemark);
			data = Data.success("获取数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.success("获取数据异常");
		}
		map.put("data", data);
		return map;
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/remark/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> AddRemark(HttpServletRequest request, HttpServletResponse reponse) {
		Map<String, Object> map = new HashMap<>();
		Data data = Data.failure("获取数据失败");
		long remarkId = Long.valueOf(request.getParameter("remarkId"));
		long reportId = Long.valueOf(request.getParameter("reportId"));
		String remarkContent = request.getParameter("remarkContext");
		String loadingYear = request.getParameter("loadingYear");
		String loadingMonth = request.getParameter("loadingMonth") == null ? "" : request.getParameter("loadingMonth");
		String loadingWeek = request.getParameter("loadingWeek") == null ? "" : request.getParameter("loadingWeek");
		HttpSession session = request.getSession();
		User curUser = userService.find((Long) session.getAttribute("curUserId"));
		try {
			Report report = reportService.find(reportId);
			ReportRemark reportRemark = new ReportRemark();
			if (remarkId > 0) {
				reportRemark = reportRemarkService.find(remarkId);
				reportRemark.setReport(report);
				reportRemark.setYear(loadingYear);
				reportRemark.setMonth(loadingMonth);
				reportRemark.setWeek(loadingWeek);
				reportRemark.setUserId(curUser.getId());
				reportRemark.setUserName(curUser.getRealname());
				reportRemark.setRemarkContent(remarkContent);
				reportRemark.setUpdateTime(new Date());
				reportRemarkService.update(reportRemark);
			} else {
				reportRemark.setReport(report);
				reportRemark.setYear(loadingYear);
				reportRemark.setMonth(loadingMonth);
				reportRemark.setWeek(loadingWeek);
				reportRemark.setUserId(curUser.getId());
				reportRemark.setUserName(curUser.getRealname());
				reportRemark.setRemarkContent(remarkContent);
				reportRemark.setInsertTime(new Date());
				reportRemark.setUpdateTime(new Date());
				reportRemarkService.save(reportRemark);	
			}
			map.put("reportRemark", reportRemark);
			data = Data.success("获取数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.success("获取数据异常");
		}
		map.put("data", data);
		return map;
	}
	
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/remark/info", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getRemark(HttpServletRequest request, HttpServletResponse reponse){
		Map<String, Object> map = new HashMap<>();
		long remarkId = Long.valueOf(request.getParameter("remarkId"));
		ReportRemark reportRemark = reportRemarkService.find(remarkId);
		map.put("entity", reportRemark);
		return map;
	}
	
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/remark/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateRemark(HttpServletRequest request, HttpServletResponse reponse){
		Map<String, Object> map = new HashMap<>();
		Data data = Data.failure("更新数据失败");
		//获取参数--只更新内容
		long remarkId = Long.valueOf(request.getParameter("remarkId"));
		String remarkContent = request.getParameter("remarkContent");
		System.out.println(remarkContent+"---"+remarkId);
		try {
			ReportRemark reportRemark = reportRemarkService.find(remarkId);
			reportRemark.setRemarkContent(remarkContent);
			reportRemark.setUpdateTime(new Date());
			reportRemarkService.update(reportRemark);
			data = Data.success("更新成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
		map.put("data", data);
		return map;
		
	}
	
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/summary/remark/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteRemark(HttpServletRequest request, HttpServletResponse reponse){
		Map<String, Object> map = new HashMap<>();
		Data data = Data.failure("删除数据失败");
		//获取参数
		Long remarkId = Long.valueOf(request.getParameter("remarkId"));
		if(remarkId!=null&&remarkId>0) {
			reportRemarkService.deleteById(remarkId);
			data = Data.success("删除成功");
		}
		map.put("data", data);
		return map;
	}
	
}
