package com.communication.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.entity.FHouseholdBroadbandTariff;
import com.communication.entity.FIndustryCard;
import com.communication.entity.FPhoneUserRealIdentity;
import com.communication.entity.FPriceSpeed;
import com.communication.entity.FSpamMessage;
import com.communication.entity.FXxzp;
import com.communication.entity.FZyzsmz;
import com.communication.entity.GBroadbandTariff;
import com.communication.entity.GBusinessCardManagement;
import com.communication.entity.GCheckedStore;
import com.communication.entity.GCombatFraudBusiness;
import com.communication.entity.GCutFees;
import com.communication.entity.GFixedNumberResource;
import com.communication.entity.GInternetPlatformSpamMessage;
import com.communication.entity.GRealNameRegistration;
import com.communication.entity.GRealNameRegistrationChannel;
import com.communication.entity.ReportLog;
import com.communication.util.Base;
import com.communication.util.NumbericUtil;

@Service
public class AutoDataService {

	private static final Logger logger = LoggerFactory.getLogger(AutoDataService.class);

	@Autowired
	private ReportLogService reportLogService;

	// 实名制和实名制渠道
	@Autowired
	private FPhoneUserRealIdentityService fPhoneUserRealIdentityService;
	@Autowired
	private GRealNameRegistrationService gRealNameRegistrationService;
	@Autowired
	private GRealNameRegistrationChannelService gRealNameRegistrationChannelService;

	// 实名志愿者监督检查-志愿者检查门店数量form_03
	@Autowired
	private FZyzsmzService fZyzsmzService;
	@Autowired
	private GCheckedStoreService gCheckedStoreService;

	// 打击通讯信息诈骗相关业务数据
	@Autowired
	private FXxzpService fXxzpService;
	@Autowired
	private GCombatFraudBusinessService gCombatFraudBusinessService;
	
	//网间平台垃圾短信举报
	@Autowired
	private GInternetPlatformSpamMessageService gInternetPlatformSpamMessageService;
	@Autowired
	private FSpamMessageService fSpamMessageService;

	//固网码号资源
	@Autowired
	private GFixedNumberResourceService gFixedNumberResourceService;
	@Autowired
	private FHmzyService fHmzyService;
	
	//宽带资费
	@Autowired
	private FHouseholdBroadbandTariffService fHouseholdBroadbandTariffService;
	@Autowired
	private GBroadbandTariffService gBroadbandTariffService;
	
	//降费
	@Autowired
	private FPriceSpeedService fPriceSpeedService;
	@Autowired
	private GCutFeesService gCutFeesService;
	
	//行业卡实名登记管理
	@Autowired
	private GBusinessCardManagementService gBusinessCardManagementService;
	@Autowired
	private FIndustryCardService fIndustryCardService;

	private List<ReportLog> reportLogList = null;

	public void saveAuto(Long reportId, Integer loadingYear, Integer loadingMonth) {
		logger.info("管局统计处自动获取数据");
		// 根据reportId获取审核通过的reportLog
		reportLogList = reportLogService.queryByReportAndMonthAndAudited(reportId, loadingYear, loadingMonth, "0", "1");
		if (Base.empty(reportLogList)) {
			logger.info("没有获取到任何数据");
			return;
		}

		int length = reportLogList.size();
		// 用户实名制和实名制渠道
		if (reportId == 7L && length > 3) {
			GRealNameRegistration gRealNameRegistration = gRealNameRegistrationService.queryOneByYearAndMonth(loadingYear, loadingMonth);
			if (null == gRealNameRegistration) {
				gRealNameRegistration = new GRealNameRegistration();
				gRealNameRegistration.setYear(loadingYear);
				gRealNameRegistration.setMonth(loadingMonth);
				gRealNameRegistration.setInsertTime(new Date());
				gRealNameRegistration.setCreateUserId(0L);
				gRealNameRegistration.setSourceFrom("1");
			}
			GRealNameRegistrationChannel gRealNameRegistrationChannel = gRealNameRegistrationChannelService.queryOneByYearAndMonth(loadingYear, loadingMonth);
			if (null == gRealNameRegistrationChannel) {
				gRealNameRegistrationChannel = new GRealNameRegistrationChannel();
				gRealNameRegistrationChannel.setYear(loadingYear);
				gRealNameRegistrationChannel.setMonth(loadingMonth);
				gRealNameRegistrationChannel.setInsertTime(new Date());
				gRealNameRegistrationChannel.setCreatedUserId(0L);
			}
			Integer filed_01 = 0;// 自营厅总数
			Integer filed_02 = 0;// 代理点总数
			Integer filed_03 = 0;// 电商平台授权数
			Integer filed_04 = 0;// 二代身份证识别设备网点数
			Integer filed_05 = 0;// 社会渠道授权牌数
			Integer filed_06 = 0;// 本月终止违规代理商数
			Integer filed_07 = 0;// 代理渠道售卡数
			Integer filed_08 = 0;// 代理渠道售卡拍照核验不合规数

			for (ReportLog reportLog : reportLogList) {
				FPhoneUserRealIdentity fPhoneUserRealIdentity = fPhoneUserRealIdentityService.queryByReportLogId(reportLog.getId());
				if (fPhoneUserRealIdentity.getTelecomOperatorId() == 1L) {// 电信
					gRealNameRegistration.setField_11(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_01()));
					gRealNameRegistration.setField_12(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_03()));
					gRealNameRegistration.setField_13(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_07()));
					gRealNameRegistration.setField_14(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_09()));
					gRealNameRegistration.setField_15(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_13()));
					gRealNameRegistration.setField_16(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_15()));
				} else if (fPhoneUserRealIdentity.getTelecomOperatorId() == 2L) {// 移动
					gRealNameRegistration.setField_21(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_01()));
					gRealNameRegistration.setField_23(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_07()));
					gRealNameRegistration.setField_25(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_13()));
				} else if (fPhoneUserRealIdentity.getTelecomOperatorId() == 3L) {// 联通
					gRealNameRegistration.setField_31(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_01()));
					gRealNameRegistration.setField_32(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_03()));
					gRealNameRegistration.setField_33(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_07()));
					gRealNameRegistration.setField_34(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_09()));
					gRealNameRegistration.setField_35(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_13()));
					gRealNameRegistration.setField_36(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_15()));
				} else if (fPhoneUserRealIdentity.getTelecomOperatorId() == 7L) {// 移动铁通
					gRealNameRegistration.setField_22(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_03()));
					gRealNameRegistration.setField_24(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_09()));
					gRealNameRegistration.setField_26(NumbericUtil.strToFloat(fPhoneUserRealIdentity.getField_15()));
				}
				
				filed_01 = filed_01 + NumbericUtil.strToInteger(fPhoneUserRealIdentity.getField_40());
				filed_02 = filed_02 + NumbericUtil.strToInteger(fPhoneUserRealIdentity.getField_43());
				filed_03 = filed_03 + NumbericUtil.strToInteger(fPhoneUserRealIdentity.getField_45());
				filed_04 = filed_04 + NumbericUtil.strToInteger(fPhoneUserRealIdentity.getField_51());
				filed_05 = filed_05 + NumbericUtil.strToInteger(fPhoneUserRealIdentity.getField_68());
				filed_06 = filed_06 + NumbericUtil.strToInteger(fPhoneUserRealIdentity.getField_71());
				filed_07 = filed_07 + NumbericUtil.strToInteger(fPhoneUserRealIdentity.getField_73());
				// filed_08 = filed_08 +
				// NumbericUtil.strToInteger(fPhoneUserRealIdentity.getField_40());
			}
			// saveOrUpdate；合规率默认100%
			gRealNameRegistration.setField_17(100.00F);
			gRealNameRegistration.setField_27(100.00F);
			gRealNameRegistration.setField_37(100.00F);
			gRealNameRegistrationService.update(gRealNameRegistration);

			gRealNameRegistrationChannel.setFiled_01(filed_01);
			gRealNameRegistrationChannel.setFiled_02(filed_02);
			gRealNameRegistrationChannel.setFiled_03(filed_03);
			gRealNameRegistrationChannel.setFiled_04(filed_04);
			gRealNameRegistrationChannel.setFiled_05(filed_05);
			gRealNameRegistrationChannel.setFiled_06(filed_06);
			gRealNameRegistrationChannel.setFiled_07(filed_07);
			gRealNameRegistrationChannel.setFiled_08(filed_08);
			gRealNameRegistrationChannelService.update(gRealNameRegistrationChannel);

			logger.info("数据自动进入实名制和实名制渠道统计表中");
			return;
		}
		// 实名制志愿者检查
		if (reportId == 12 && length > 2) {
			GCheckedStore gCheckedStore = gCheckedStoreService.queryOneByYearAndMonth(loadingYear, loadingMonth);
			if (null == gCheckedStore) {
				gCheckedStore = new GCheckedStore();
				gCheckedStore.setCreatedUserId(0L);
				gCheckedStore.setYear(loadingYear);
				gCheckedStore.setMonth(loadingMonth);
				gCheckedStore.setInsertTime(new Date());
			}

			int field_01 = 0;// 基础电信企业门店数
			int field_04 = 0;// 基础电信企业门店检查数（合规数）
			double field_05 = 0.00;// 基础电信企业门店合规率（%）

			int field_06 = 0;// 转售企业门店数检查数
			int field_02 = 0;// 转售企业门店数（合规数）
			double field_07 = 0.00;// 转售企业代理网点合规率（%）

			int field_08 = 0;// 志愿者检查门店总数
			int field_03 = 0;// 检查人次
			double field_09 = 0.00;// 志愿者检查门店合规率（%）

			for (ReportLog reportLog : reportLogList) {
				FZyzsmz fZyzsmz = fZyzsmzService.queryByReportLogId(reportLog.getId());
				field_01 = field_01 + fZyzsmz.getJcdxmds();
				field_04 = field_04 + fZyzsmz.getJcdxmdhgs();
				field_06 = field_06 + fZyzsmz.getZsqymdjcs();
				field_02 = field_02 + fZyzsmz.getZsqymdshg();
				field_03 = field_03 + fZyzsmz.getCheckNumber();
			}
			field_08 = field_01 + field_06;
			field_05 = NumbericUtil.div(Double.valueOf(field_04), Double.valueOf(field_01))*100;
			field_07 = NumbericUtil.div(Double.valueOf(field_02), Double.valueOf(field_06))*100;
			if(field_08>0) {
				field_09 = NumbericUtil.div(Double.valueOf(field_02 + field_04), Double.valueOf(field_08))*100;
			}else {
				field_09 = 0.00;
			}
			

			gCheckedStore.setField_01(field_01);
			gCheckedStore.setField_02(field_02);
			gCheckedStore.setField_03(field_03);
			gCheckedStore.setField_04(field_04);
			gCheckedStore.setField_05(Float.valueOf(String.valueOf(field_05)));
			gCheckedStore.setField_06(field_06);
			gCheckedStore.setField_07(Float.valueOf(String.valueOf(field_07)));
			gCheckedStore.setField_08(field_08);
			gCheckedStore.setField_09(Float.valueOf(String.valueOf(field_09)));
            System.out.println("//////////////////////////////");
			gCheckedStoreService.update(gCheckedStore);
			return;
		}
		// 打击通讯信息诈骗相关业务数据
		if (reportId == 1 && length > 2) {
			GCombatFraudBusiness gCombatFraudBusiness = gCombatFraudBusinessService.queryOneByYearAndMonth(loadingYear,loadingMonth);
			if (null == gCombatFraudBusiness) {
				gCombatFraudBusiness = new GCombatFraudBusiness();
				gCombatFraudBusiness.setCreateUserId(0L);
				gCombatFraudBusiness.setYear(loadingYear);
				gCombatFraudBusiness.setMonth(loadingMonth);
				gCombatFraudBusiness.setInsertTime(new Date());
			}

			// 语音专线出租业务
			int field_11 = 0;// 总用户数（家）
			double field_12 = 0.00;// 实名率（%）
			int field_13 = 0;// 关停号码（个）
			// “400”业务
			int field_21 = 0;// 总用户数（家）
			double field_22 = 0.00;// 实名率（%）
			int field_23 = 0;// 关停号码（个）
			// 一号通业务
			int field_31 = 0;// 总用户数（家）
			double field_32 = 0.00;// 实名率（%）
			int field_33 = 0;// 关停号码（个）
			// 商务总机业务
			int field_41 = 0;// 总用户数（家）
			double field_42 = 0.00;// 实名率（%）
			int field_43 = 0;// 关停号码（个）
			// 封堵境外非法透传
			double field_51 = 0.0000;// 拦截数量（万次）
			// 语音专线主叫鉴权
			int field_61 = 0;// 总电路数（条）
			double field_62 = 0.00;// 主叫鉴权率（%）
			// 虚假改号呼叫拦截
			int field_71 = 0;// 拦截数量（次）
			// 一键退订
			double field_81 = 0.0000;// 退订数量（万起）

			for (ReportLog reportLog : reportLogList) {
				FXxzp fXxzp = fXxzpService.queryByReportLogId(reportLog.getId());
				// 语音专线出租业务
				field_11 = field_11 + NumbericUtil.strToInteger(fXxzp.getField_1());
				field_12 = NumbericUtil.add(field_12, NumbericUtil.strToDouble(fXxzp.getField_2()));
				field_13 = field_13 + NumbericUtil.strToInteger(fXxzp.getField_5());
				// “400”业务
				field_21 = field_21 + NumbericUtil.strToInteger(fXxzp.getField_6());
				field_22 = NumbericUtil.add(field_22, NumbericUtil.strToDouble(fXxzp.getField_7()));
				field_23 = field_23 + NumbericUtil.strToInteger(fXxzp.getField_10());
				// 一号通业务
				field_31 = field_31 + NumbericUtil.strToInteger(fXxzp.getField_11());
				field_32 = NumbericUtil.add(field_32, NumbericUtil.strToDouble(fXxzp.getField_12()));
				field_33 = field_33 + NumbericUtil.strToInteger(fXxzp.getField_15());
				// 商务总机业务
				field_41 = field_41 + NumbericUtil.strToInteger(fXxzp.getField_16());
				field_42 = NumbericUtil.add(field_42, NumbericUtil.strToDouble(fXxzp.getField_17()));
				field_43 = field_43 + NumbericUtil.strToInteger(fXxzp.getField_20());
				// 封堵境外非法透传
				field_51 = NumbericUtil.add(field_51, NumbericUtil.strToDouble(fXxzp.getField_23()));
				// 语音专线主叫鉴权
				field_61 = field_61 + NumbericUtil.strToInteger(fXxzp.getField_24());
				field_62 = NumbericUtil.add(field_62, NumbericUtil.strToDouble(fXxzp.getField_27()));
				field_71 = field_71 + NumbericUtil.strToInteger(fXxzp.getField_28());
				// 一键退订
				field_81 = NumbericUtil.add(field_81, NumbericUtil.strToDouble(fXxzp.getField_39()));
			}
			field_12 = NumbericUtil.div(field_12, 3);
			field_22 = NumbericUtil.div(field_32, 3);
			field_32 = NumbericUtil.div(field_32, 3);
			field_42 = NumbericUtil.div(field_42, 3);
			field_62 = NumbericUtil.div(field_62, 3);
			
			gCombatFraudBusiness.setField_11(field_11);
			gCombatFraudBusiness.setField_12(Float.valueOf(String.valueOf(field_12)));
			gCombatFraudBusiness.setField_13(field_13);
			gCombatFraudBusiness.setField_21(field_21);
			gCombatFraudBusiness.setField_22(Float.valueOf(String.valueOf(field_22)));
			gCombatFraudBusiness.setField_23(field_23);
			gCombatFraudBusiness.setField_31(field_31);
			gCombatFraudBusiness.setField_32(Float.valueOf(String.valueOf(field_32)));
			gCombatFraudBusiness.setField_33(field_33);
			gCombatFraudBusiness.setField_41(field_41);
			gCombatFraudBusiness.setField_42(Float.valueOf(String.valueOf(field_42)));
			gCombatFraudBusiness.setField_43(field_43);
			gCombatFraudBusiness.setField_51(Float.valueOf(String.valueOf(field_51)));
			gCombatFraudBusiness.setField_61(field_61);
			gCombatFraudBusiness.setField_62(Float.valueOf(String.valueOf(field_62)));
			gCombatFraudBusiness.setField_71(field_71);
			gCombatFraudBusiness.setField_81(Float.valueOf(String.valueOf(field_81)));
			gCombatFraudBusinessService.update(gCombatFraudBusiness);
			
			return;
		}
		
		//网间平台垃圾短信举报
		if(reportId == 11 && length > 2 ) {
			GInternetPlatformSpamMessage gInternetPlatformSpamMessage = gInternetPlatformSpamMessageService.queryOneByYearAndMonth(loadingYear,loadingMonth);
			if(null==gInternetPlatformSpamMessage) {
				gInternetPlatformSpamMessage = new GInternetPlatformSpamMessage();
				gInternetPlatformSpamMessage.setCreateUserId(0L);
				gInternetPlatformSpamMessage.setYear(loadingYear);
				gInternetPlatformSpamMessage.setMonth(loadingMonth);
				gInternetPlatformSpamMessage.setInsertTime(new Date());
			}
			
			// 电信
			
			int field_14 = 0;// 0000退订
			int field_15 = 0;// 收到垃圾短信息投诉量（起）
			int field_16 = 0;// 处理完毕（起）
			float field_17 = 0.0000f;// 拦截垃圾短信息总量（万条）
			// 移动
			int field_24 = 0;// 0000退订
			int field_25 = 0;// 收到垃圾短信息投诉量（起）
			int field_26 = 0;// 处理完毕（起）
			float field_27 = 0.0000f;// 拦截垃圾短信息总量（万条）
			// 联通
			int field_34 = 0;// 0000退订
			int field_35 = 0;// 收到垃圾短信息投诉量（起）
			int field_36 = 0;// 处理完毕（起）
			float field_37 = 0.0000f;// 拦截垃圾短信息总量（万条）
			
			for (ReportLog reportLog : reportLogList) {
				FSpamMessage fSpamMessage = fSpamMessageService.queryByReportLogId(reportLog.getId());
				if(fSpamMessage.getTelecomOperatorId()==1L) {//电信
					field_14 = NumbericUtil.strToInteger(fSpamMessage.getField_49());
				    field_15 = NumbericUtil.strToInteger(fSpamMessage.getField_01());
				    field_16 = NumbericUtil.strToInteger(fSpamMessage.getField_02());	
				    field_17 = NumbericUtil.strToFloat(fSpamMessage.getField_04());
				}else if(fSpamMessage.getTelecomOperatorId()==2L) {//移动
					field_24 = NumbericUtil.strToInteger(fSpamMessage.getField_49());
				    field_25 = NumbericUtil.strToInteger(fSpamMessage.getField_01());
				    field_26 = NumbericUtil.strToInteger(fSpamMessage.getField_02());
				    field_27 = NumbericUtil.strToFloat(fSpamMessage.getField_04());
				}else if(fSpamMessage.getTelecomOperatorId()==3L) {//联通
					field_34 = NumbericUtil.strToInteger(fSpamMessage.getField_49());
				    field_35 = NumbericUtil.strToInteger(fSpamMessage.getField_01());
				    field_36 = NumbericUtil.strToInteger(fSpamMessage.getField_02());
				    field_37 = NumbericUtil.strToFloat(fSpamMessage.getField_04());
				}
			}
			gInternetPlatformSpamMessage.setField_14(field_14);
			gInternetPlatformSpamMessage.setField_15(field_15);
			gInternetPlatformSpamMessage.setField_16(field_16);
			gInternetPlatformSpamMessage.setField_27(field_17);
			gInternetPlatformSpamMessage.setField_24(field_24);
			gInternetPlatformSpamMessage.setField_25(field_25);
			gInternetPlatformSpamMessage.setField_26(field_26);
			gInternetPlatformSpamMessage.setField_27(field_27);
			gInternetPlatformSpamMessage.setField_34(field_34);
			gInternetPlatformSpamMessage.setField_35(field_35);
			gInternetPlatformSpamMessage.setField_36(field_36);
			gInternetPlatformSpamMessage.setField_37(field_37);
			gInternetPlatformSpamMessageService.update(gInternetPlatformSpamMessage);
			
			return ;
		}
		
		//固网码号资源
		if(reportId == 12 && length > 2) {
			GFixedNumberResource gFixedNumberResource = gFixedNumberResourceService.queryOneByYearAndMonth(loadingYear,loadingMonth);
			if(null == gFixedNumberResource) {
				gFixedNumberResource = new GFixedNumberResource();
				gFixedNumberResource.setCreateUserId(0L);
				gFixedNumberResource.setYear(loadingYear);
				gFixedNumberResource.setMonth(loadingMonth);
				gFixedNumberResource.setInsertTime(new Date());
			}
			
			//电信
			int field_11 = 0;// 局号数（万）
			double field_12 = 0.00;// 号码使用率
			//移动（铁通）
			int field_21 = 0;// 局号数（万）
			double field_22 = 0.00;// 号码使用率
			//联通
			int field_31 = 0;// 局号数（万）
			double field_32 = 0.00;// 号码使用率
			int codePhysicsAssignedNumber=0;
			
			for(ReportLog reportLog : reportLogList) {
				codePhysicsAssignedNumber = 0;
				if(reportLog.getToUser().getTelecomOperator().getId() == 1L) {
					field_11 = fHmzyService.sumByReportLogId("id", reportLog.getId());
					codePhysicsAssignedNumber = fHmzyService.sumByReportLogId("physicsAssignedNumber", reportLog.getId());
					field_12 = NumbericUtil.div(codePhysicsAssignedNumber*100, field_11*10000);
				}else if(reportLog.getToUser().getTelecomOperator().getId() == 7L) {
					field_21 = fHmzyService.sumByReportLogId("id", reportLog.getId());
					codePhysicsAssignedNumber = fHmzyService.sumByReportLogId("physicsAssignedNumber", reportLog.getId());
					field_22 = NumbericUtil.div(codePhysicsAssignedNumber*100, field_11*10000);
				}else if(reportLog.getToUser().getTelecomOperator().getId() == 3L) {
					field_31 = fHmzyService.sumByReportLogId("id", reportLog.getId());
					codePhysicsAssignedNumber = fHmzyService.sumByReportLogId("physicsAssignedNumber", reportLog.getId());
					field_32 = NumbericUtil.div(codePhysicsAssignedNumber*100, field_11*10000);
				}
			}
			gFixedNumberResource.setField_11(field_11);
			gFixedNumberResource.setField_12(Float.valueOf(String.valueOf(field_12)));
			gFixedNumberResource.setField_11(field_21);
			gFixedNumberResource.setField_12(Float.valueOf(String.valueOf(field_22)));
			gFixedNumberResource.setField_11(field_31);
			gFixedNumberResource.setField_12(Float.valueOf(String.valueOf(field_32)));
			gFixedNumberResourceService.update(gFixedNumberResource);
			return ;
		}
		
		//宽带资费
		if(reportId == 4 && length > 4) {
			logger.info("进入宽带资费自动数据统计");
			GBroadbandTariff gBroadbandTariff = gBroadbandTariffService.queryOneByYearAndMonth(loadingYear,loadingMonth);
			if(null == gBroadbandTariff) {
				gBroadbandTariff = new GBroadbandTariff();
				gBroadbandTariff.setCreateUserId(0L);
				gBroadbandTariff.setYear(loadingYear);
				gBroadbandTariff.setMonth(loadingMonth);
				gBroadbandTariff.setInsertTime(new Date());
			}
			
			for(ReportLog reportLog : reportLogList) {
				FHouseholdBroadbandTariff fHouseholdBroadbandTariff = fHouseholdBroadbandTariffService.queryByReportLogId(reportLog.getId());
				if(fHouseholdBroadbandTariff.getTelecomOperatorId() == 1L) {
					gBroadbandTariff.setField_11(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_23()));
					gBroadbandTariff.setField_12(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_24()));
					gBroadbandTariff.setField_13(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_31()));
				}else if(fHouseholdBroadbandTariff.getTelecomOperatorId() == 2L) {
					gBroadbandTariff.setField_21(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_23()));
					gBroadbandTariff.setField_22(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_24()));
					gBroadbandTariff.setField_23(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_31()));
				}else if(fHouseholdBroadbandTariff.getTelecomOperatorId() == 3L) {
					gBroadbandTariff.setField_31(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_23()));
					gBroadbandTariff.setField_32(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_24()));
					gBroadbandTariff.setField_33(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_31()));
				}else if(fHouseholdBroadbandTariff.getTelecomOperatorId() == 5L) {
					gBroadbandTariff.setField_41(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_23()));
					gBroadbandTariff.setField_42(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_24()));
					gBroadbandTariff.setField_43(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_31()));
				}else if(fHouseholdBroadbandTariff.getTelecomOperatorId() == 6L) {
					gBroadbandTariff.setField_51(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_23()));
					gBroadbandTariff.setField_52(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_24()));
					gBroadbandTariff.setField_53(NumbericUtil.strToFloat(fHouseholdBroadbandTariff.getField_31()));
				}
			}
			gBroadbandTariffService.update(gBroadbandTariff);
			return ;
		}
		
		//降费
		if(reportId == 5 && length > 2) {
			logger.info("进入提速降费自动数据统计");
			GCutFees gCutFees = gCutFeesService.queryOneByYearAndMonth(loadingYear, loadingMonth);
			if(null == gCutFees) {
				gCutFees = new GCutFees();
				gCutFees.setCreateUserId(0L);
				gCutFees.setYear(loadingYear);
				gCutFees.setMonth(loadingMonth);
				gCutFees.setInsertTime(new Date());
			}
			
			for(ReportLog reportLog:reportLogList) {
				FPriceSpeed fPriceSpeed = fPriceSpeedService.queryByReportLogId(reportLog.getId());
				if(fPriceSpeed.getTelecomOperatorId()==1L) {
					gCutFees.setField_11(NumbericUtil.strToFloat(fPriceSpeed.getField_02()));
					gCutFees.setField_12(NumbericUtil.strToFloat(fPriceSpeed.getField_08()));
				}else if(fPriceSpeed.getTelecomOperatorId()==2L) {
					gCutFees.setField_21(NumbericUtil.strToFloat(fPriceSpeed.getField_02()));
					gCutFees.setField_22(NumbericUtil.strToFloat(fPriceSpeed.getField_08()));
				}else if(fPriceSpeed.getTelecomOperatorId()==3L) {
					gCutFees.setField_31(NumbericUtil.strToFloat(fPriceSpeed.getField_02()));
					gCutFees.setField_32(NumbericUtil.strToFloat(fPriceSpeed.getField_08()));
				}
			}
			
			gCutFeesService.update(gCutFees);
			
			return ;
		}
		
		//行业卡管理
		if(reportId==10&&length>2) {
			logger.info("进入行业卡自动数据统计");
			GBusinessCardManagement gBusinessCardManagement = gBusinessCardManagementService.queryOneByYearAndMonth(loadingYear,loadingMonth);
			if(null == gBusinessCardManagement) {
				gBusinessCardManagement = new GBusinessCardManagement();
				gBusinessCardManagement.setCreateUserId(0L);
				gBusinessCardManagement.setYear(loadingYear);
				gBusinessCardManagement.setMonth(loadingMonth);
				gBusinessCardManagement.setInsertTime(new Date());
			}
			
			for(ReportLog reportLog:reportLogList) {
				FIndustryCard fIndustryCard = fIndustryCardService.queryByReportLogId(reportLog.getId());
				if(fIndustryCard.getTelecomOperatorId()==1L) {
					gBusinessCardManagement.setField_11(NumbericUtil.strToInteger(fIndustryCard.getField_01()));
					gBusinessCardManagement.setField_12(NumbericUtil.strToInteger(fIndustryCard.getField_70()));
					gBusinessCardManagement.setField_13(Float.valueOf(String.valueOf(NumbericUtil.div(Double.valueOf(fIndustryCard.getField_70()), Double.valueOf(fIndustryCard.getField_01()),4)*100)));
				}else if(fIndustryCard.getTelecomOperatorId()==2L) {
					gBusinessCardManagement.setField_21(NumbericUtil.strToInteger(fIndustryCard.getField_01()));
					gBusinessCardManagement.setField_22(NumbericUtil.strToInteger(fIndustryCard.getField_70()));
					gBusinessCardManagement.setField_23(Float.valueOf(String.valueOf(NumbericUtil.div(Double.valueOf(fIndustryCard.getField_70()), Double.valueOf(fIndustryCard.getField_01()),4)*100)));
				}else if(fIndustryCard.getTelecomOperatorId()==3L) {
					gBusinessCardManagement.setField_31(NumbericUtil.strToInteger(fIndustryCard.getField_01()));
					gBusinessCardManagement.setField_32(NumbericUtil.strToInteger(fIndustryCard.getField_70()));
					gBusinessCardManagement.setField_33(Float.valueOf(String.valueOf(NumbericUtil.div(Double.valueOf(fIndustryCard.getField_70()), Double.valueOf(fIndustryCard.getField_01()),4)*100)));
				}
			}
			
			gBusinessCardManagementService.update(gBusinessCardManagement);
			
			return ;
		}

	}

}
