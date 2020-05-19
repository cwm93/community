package com.communication.administration.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.communication.entity.Data;
import com.communication.entity.GTelecomValueAdded;
import com.communication.entity.GTelecomValueAddedBatch;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GTelecomValueAddedBatchService;
import com.communication.service.GTelecomValueAddedService;
import com.communication.util.Constants;
import com.communication.util.ImportExecl;

/**
 * 各类增值业务
 **/
@Controller
@RequestMapping("/gj/")
public class GTelecomValueAddedController {

	private static final Logger logger = LoggerFactory.getLogger(GTelecomValueAddedController.class);

	@Autowired
	private GTelecomValueAddedService telecomValueAddedService;
	@Autowired
	private GTelecomValueAddedBatchService telecomValueAddedBatchService;

	/**
	 * 文本导入界面
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("/telecomValueAdded/add")
	public String add() {
		logger.info("add telecom value added");
		return "administration/telecomValueAdded/add";
	}

	/**
	 * 获取
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("/telecomValueAdded/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year, @RequestParam("month") Integer month) {
		logger.info("get telecom value list");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GTelecomValueAddedBatch telecomValueAddedBatch = telecomValueAddedBatchService.queryByYearMonth(year,month);
		
		if(null==telecomValueAddedBatch) {
			telecomValueAddedBatch = new GTelecomValueAddedBatch();
			telecomValueAddedBatch.setTelecomValueAddedList(null);
		}
		returnMap.put("telecomValueAddedBatch", telecomValueAddedBatch);
		returnMap.put("status", "success");
		return returnMap;
	}

	/**
	 * 导入excel
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/telecomValueAdded/save", method = RequestMethod.POST)
	private String save(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("selectYear") Integer year, @RequestParam("selectMonth") Integer month, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		logger.info("GTelecomValueAdded saving");
		Data data = Data.failure("提交失败");

		String path = request.getServletContext().getRealPath("upload");
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
		Date now = new Date();
		Long userId = (Long) request.getSession().getAttribute("curUserId");
		try {
			ImportExecl poi = new ImportExecl();
			if (poi.validateExcel(path + "/" + fileName)) {
				List<List<String>> list = poi.read(path + "/" + fileName);
				if (list != null && list.size() > 0) {
					
					GTelecomValueAddedBatch telecomValueAddedBatch = telecomValueAddedBatchService.queryByYearMonth(year,month);
					
					Set<GTelecomValueAdded> telecomValueAddedList = new HashSet<GTelecomValueAdded>(0);
					if(telecomValueAddedBatch!=null) {
						Set<GTelecomValueAdded> setList = telecomValueAddedBatch.getTelecomValueAddedList();
						if(setList!=null&&setList.size()>0) {
							for(GTelecomValueAdded temp:setList) {
								telecomValueAddedService.deleteById(temp.getId());
							}
						}
					}else {
						telecomValueAddedBatch = new GTelecomValueAddedBatch();
						telecomValueAddedBatch.setTelecomValueAddedList(telecomValueAddedList);
						telecomValueAddedBatch.setYear(year);
						telecomValueAddedBatch.setMonth(month);
						telecomValueAddedBatch.setInsertTime(new Date());
						//telecomValueAddedBatchService.save(telecomValueAddedBatch);
					}
					for (int i = 1; i < list.size(); i++) {
						List<String> cellList = list.get(i);
						GTelecomValueAdded telecomValueAdded = new GTelecomValueAdded();
						telecomValueAdded.setCode(cellList.get(0).trim());
						telecomValueAdded.setCompanyName(cellList.get(1).trim());
						telecomValueAdded.setBusinessCategory(cellList.get(2).trim());
						telecomValueAdded.setBusinessCoverage(cellList.get(3).trim());
						telecomValueAdded.setServiceItems(cellList.get(4).trim());
						telecomValueAdded.setApprovalDate(cellList.get(5).trim());
						telecomValueAdded.setLicenseValidity(cellList.get(6).trim());
						telecomValueAdded.setEnterpriseNature(cellList.get(7).trim());
						telecomValueAdded.setRegisteredCapital(cellList.get(8).trim());
						telecomValueAdded.setListedCompany(cellList.get(9).trim());
						telecomValueAdded.setUserId(userId);
						telecomValueAdded.setInsertTime(now);
						telecomValueAdded.setUpdateTime(now);
						telecomValueAdded.setBatch(telecomValueAddedBatch);
						telecomValueAddedService.save(telecomValueAdded);
					}
					data = Data.success("数据导入成功", "/administration/form_17", "立即查看");
				} else {
					data = Data.failure("数据导入失败:导入的数据不能为空");
				}
			} else {
				data = Data.failure("数据导入失败，文件格式出错了，请导入正确的xls、xlsx文件");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("data", data);
		return "redirect:/message";
	}
	/**
	 * 获取图表数据:显示最新的批次信息
	 * 
	 * @param null
	 * @return json
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/telecomValueAdded/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GTelecomValueAddedBatch telecomValueAddedBatch = telecomValueAddedBatchService.queryLatestOne();
		returnMap.put("telecomValueAddedBatch", telecomValueAddedBatch);
		if(telecomValueAddedBatch==null) {
			returnMap.put("code", -1);
			return returnMap;
		}else {
			returnMap.put("code", 0);
		}
		
		/********4、企业性质******/
		Long qyxz_ls = telecomValueAddedService.countByBatch(telecomValueAddedBatch.getId(),"enterpriseNature","历史");
		Long qyxz_gykg = telecomValueAddedService.countByBatch(telecomValueAddedBatch.getId(),"enterpriseNature","国有控股");
		Long qyxz_mykg = telecomValueAddedService.countByBatch(telecomValueAddedBatch.getId(),"enterpriseNature","民营控股");
		Long qyxz_zwhz = telecomValueAddedService.countByBatch(telecomValueAddedBatch.getId(),"enterpriseNature","中外合资");
		returnMap.put("qyxz_ls", qyxz_ls);
		returnMap.put("qyxz_gykg", qyxz_gykg);
		returnMap.put("qyxz_mykg", qyxz_mykg);
		returnMap.put("qyxz_zwhz", qyxz_zwhz);
		
		/********5、是否上市********/
		Long sh_yes = telecomValueAddedService.countByBatch(telecomValueAddedBatch.getId(),"listedCompany","已上市");
		Long sh_no = telecomValueAddedService.countByBatch(telecomValueAddedBatch.getId(),"listedCompany","未上市");
		Long sh_none = telecomValueAddedService.countByBatch(telecomValueAddedBatch.getId(),"listedCompany","");
		returnMap.put("sh_yes", sh_yes);
		returnMap.put("sh_no", sh_no);
		returnMap.put("sh_none", sh_none);
		
		/********6、自贸区业务名称******/
		Long zm_01 = telecomValueAddedService.countZmByBatch(telecomValueAddedBatch.getId(),"businessCategory","国内多方通信服务业务");
		Long zm_02 = telecomValueAddedService.countZmByBatch(telecomValueAddedBatch.getId(),"businessCategory","国内呼叫中心业务");
		Long zm_03 = telecomValueAddedService.countZmByBatch(telecomValueAddedBatch.getId(),"businessCategory","国内互联网虚拟专用网业务");
		Long zm_04 = telecomValueAddedService.countZmByBatch(telecomValueAddedBatch.getId(),"businessCategory","互联网接入服务业务");
		Long zm_05 = telecomValueAddedService.countZmByBatch(telecomValueAddedBatch.getId(),"businessCategory","信息服务业务（不含互联网信息服务）");
		Long zm_06 = telecomValueAddedService.countZmByBatch(telecomValueAddedBatch.getId(),"businessCategory","信息服务业务（仅限互联网信息服务）");
		Long zm_07 = telecomValueAddedService.countZmByBatch(telecomValueAddedBatch.getId(),"businessCategory","在线数据处理与交易处理业务");
		returnMap.put("zm_01", zm_01);
		returnMap.put("zm_02", zm_02);
		returnMap.put("zm_03", zm_03);
		returnMap.put("zm_04", zm_04);
		returnMap.put("zm_05", zm_05);
		returnMap.put("zm_06", zm_06);
		returnMap.put("zm_07", zm_07);
		
		/********7、注册资本******/
		Long rc_lt_100 = telecomValueAddedService.countByBatch(telecomValueAddedBatch.getId(),"registeredCapital","<100万元");
		Long rc_lt_300_gt_100 = telecomValueAddedService.countByBatch(telecomValueAddedBatch.getId(),"registeredCapital","<300万元，〉=100万元");
		Long rc_lt_500_gt_300 = telecomValueAddedService.countByBatch(telecomValueAddedBatch.getId(),"registeredCapital","<500万元，〉=300万元");
		Long rc_gt_500 = telecomValueAddedService.countByBatch(telecomValueAddedBatch.getId(),"registeredCapital","〉=500万元");
		returnMap.put("rc_lt_100", rc_lt_100);
		returnMap.put("rc_lt_300_gt_100", rc_lt_300_gt_100);
		returnMap.put("rc_lt_500_gt_300", rc_lt_500_gt_300);
		returnMap.put("rc_gt_500", rc_gt_500);
		
		return returnMap;
	}

}
