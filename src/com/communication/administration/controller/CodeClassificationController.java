package com.communication.administration.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.communication.entity.Data;
import com.communication.entity.GCodeClassification;
import com.communication.entity.GCodeClassificationBatch;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GCodeClassificationBatchService;
import com.communication.service.GCodeClassificationService;
import com.communication.util.Constants;
import com.communication.util.ImportExecl;

/**
 * 码号分类
 **/
@Controller
public class CodeClassificationController {

	private static final Logger logger = LoggerFactory.getLogger(CodeClassificationController.class);
	@Resource
	private GCodeClassificationService codeClassificationService;
	@Resource
	private GCodeClassificationBatchService codeClassificationBatchService;

	/**
	 * 获取列表
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/codeclass/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year, @RequestParam("month") Integer month) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GCodeClassification> list = null;
		if (year != null && month != null) {
			GCodeClassificationBatch batch = codeClassificationBatchService.queryOneByYearAndMonth(year, month);
			long counter[] = { 0, 0, 0, 0, 0, 0, 0 };
			long counterAll = 0;
			if (batch != null) {
				try {
					counter[0] = codeClassificationService.countByCodeClass("10630", batch.getId());
					counter[1] = codeClassificationService.countByCodeClass("10639", batch.getId());
					counter[2] = codeClassificationService.countByCodeClass("1062XXXX", batch.getId());
					counter[3] = codeClassificationService.countByCodeClass("10635-10638", batch.getId());
					counter[4] = codeClassificationService.countByCodeClass("962XXX", batch.getId());
					counter[5] = codeClassificationService.countByCodeClass("96XXX", batch.getId());
					counterAll = codeClassificationService.countAll(batch.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}

				list = codeClassificationService.queryByBatch(batch.getId());

			}
			returnMap.put("counter", counter);
			returnMap.put("counterAll", counterAll);
			returnMap.put("codeClassificationList", list);
			returnMap.put("status", "success");

		} else {
			returnMap.put("status", "error");
		}

		return returnMap;
	}

	/**
	 * 导入form
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/codeclass/add", method = RequestMethod.GET)
	public String add() {
		logger.info("view code classification add form");
		return "administration/codeClassification/add";
	}

	/**
	 * 导入excel
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/codeclass/save", method = RequestMethod.POST)
	private String save(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("selectYear") Integer year, @RequestParam("selectMonth") Integer month,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		logger.info("code classification saving");
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

		GCodeClassificationBatch batch = codeClassificationBatchService.queryOneByYearAndMonth(year, month);

		try {
			ImportExecl poi = new ImportExecl();
			if (poi.validateExcel(path + "/" + fileName)) {
				List<List<String>> list = poi.read(path + "/" + fileName);
				if (list != null && list.size() > 0) {
					if (batch != null) {
						// 删除相同批次之前的数据
						List<GCodeClassification> GCodeClassificationList = codeClassificationService.queryByBatch(batch.getId());
						if (GCodeClassificationList != null && GCodeClassificationList.size() > 0) {
							for (GCodeClassification codeClassification : GCodeClassificationList) {
								codeClassificationService.deleteById(codeClassification.getId());
							}
						}
					} else {
						batch = new GCodeClassificationBatch();
						batch.setYear(year);
						batch.setMonth(month);
						batch.setInsertTime(new Date());
						batch.setUpdateTime(new Date());
						batch.setUserId((Long) request.getSession().getAttribute("curUserId"));
						codeClassificationBatchService.save(batch);
					}

					// 依次保存数据
					for (int i = 1; i < list.size(); i++) {
						List<String> cellList = list.get(i);
						GCodeClassification codeClassification = new GCodeClassification();
						codeClassification.setBatch(batch);
						codeClassification.setCodeNumber(cellList.get(0).trim());
						codeClassification.setClassification(cellList.get(1).trim());
						codeClassification.setStartTime(cellList.get(2).trim());
						codeClassification.setUsedCompany(cellList.get(3).trim());
						codeClassification.setAuditedTime(cellList.get(4).trim());
						codeClassification.setEndTime(cellList.get(5).trim());
						codeClassification.setType(cellList.get(6).trim());
						codeClassification.setInsertTime(now);
						codeClassification.setUpdateTime(now);
						codeClassificationService.save(codeClassification);
					}
					data = Data.success("数据导入成功", "/administration/form_16", "立即查看");
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
	 * 获取图表数据
	 * 
	 * @param null
	 * @return json
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/codeclass/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GCodeClassificationBatch batch = codeClassificationBatchService.queryLastOne();
		long counter[] = { 0, 0, 0, 0, 0, 0, 0 };
		if (batch != null) {
			try {
				counter[0] = codeClassificationService.countByCodeClass("10630", batch.getId());
				counter[1] = codeClassificationService.countByCodeClass("10639", batch.getId());
				counter[2] = codeClassificationService.countByCodeClass("1062XXXX", batch.getId());
				counter[3] = codeClassificationService.countByCodeClass("10635-10638", batch.getId());
				counter[4] = codeClassificationService.countByCodeClass("962XXX", batch.getId());
				counter[5] = codeClassificationService.countByCodeClass("96XXX", batch.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		returnMap.put("batch", batch);
		returnMap.put("counter", counter);
		return returnMap;
	}
}
