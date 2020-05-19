/**
 * 
 */
jQuery(document).ready(function() {
	$('#searchData').click(function() {
		var loadingYear = $('#selectYear').val();
		var loadingMonth = $('#selectMonth').val();

		if (loadingYear == '') {
			layer.msg('请选择年份');
		}
		if (loadingMonth == '') {
			layer.msg('请选择月份');
		}
		if (loadingYear != '' && loadingMonth != '') {
			queryData(loadingYear,loadingMonth);
			//queryRemark(reportId,loadingYear,loadingMonth);
		}
	})
	
	
	$('#submitRemark').click(function(){
		var remarkId = $('#remark_id').val();
		var reportId = $('#reportId').val();
		var loadingYear = $('#selectYear').val();
		var loadingMonth = $('#selectMonth').val();
		var remarkContext = $('#remarkContext').val();

		if (loadingYear == '') {
			layer.msg('请选择年份');
			return ;
		}
		if (loadingMonth == '') {
			layer.msg('请选择月份');
			return ;
		}
		
		if(remarkContext==''){
			layer.msg('备份内容不能为空', {icon : 0});
			return ;
		}
		$.ajax({
			type : "POST",
			url : "/summary/remark/add",
			data : {
				remarkId:remarkId,
				reportId : reportId,
				remarkContext:remarkContext,
				loadingYear : loadingYear,
				loadingMonth : loadingMonth
			},
			dataType : "json",
			success : function(data) {
				if(data.data.code==0){
					layer.msg('备注提交成功', {icon : 1});
				}else{
					layer.msg('系统异常，提交失败', {icon : 0});
				}
			},
			error:function(){
				layer.msg('系统异常，提交失败');
			}
		})
	})
});

var queryData = function(loadingYear,loadingMonth){
	layer.msg('数据查询中', {
		time : 0, // 不自动关闭
		icon : 16,
		shade : 0.01
	});
	var dataContent = "";
	$.ajax({
		type : "get",
		url : "/form/summaryJson",
		data : {
			loadingYear : loadingYear,
			loadingMonth : loadingMonth
		},
		dataType : "json",
		success : function(data) {
			if (data.code == 0) {
				layer.closeAll();
				//alert(data.virtualOperator);
				dataContent = '<h3 class="text-center" style="font-size:16px;line-height:35px;">电信管理处统计表</h3>'+
				'<div style="width:100%;line-height:28px;"><span style="float:right;">'+loadingYear+'年'+loadingMonth+'月</span></div>'+
			    '<table class="table table-bordered">';
				if(data.realNameRegistration!=null){
					realNameRegistration = data.realNameRegistration;
					//用户总数
					sum11 = realNameRegistration.field_11+realNameRegistration.field_12;
					sum21 = realNameRegistration.field_21+realNameRegistration.field_22;
					sum31 = realNameRegistration.field_31+realNameRegistration.field_32;
					sumy1 = sum11+sum21+sum31;
					//已登记
					sum_13 = realNameRegistration.field_13+realNameRegistration.field_14;
					sum_23 = realNameRegistration.field_23+realNameRegistration.field_24;
					sum_33 = realNameRegistration.field_33+realNameRegistration.field_34;
					sumy2 = sum_13+sum_23+sum_33;
					per11 = (sum_13*100/sum11).toFixed(2);
					per21 = (sum_23*100/sum21).toFixed(2);
					per31 = (sum_33*100/sum31).toFixed(2);
					pery3 = (sumy2*100/sumy1).toFixed(2);
					
					dataContent = dataContent + '<tr><th rowspan="5">实名制用户</th><th>单位</th><th>总量（万）</th><th>实名率</th><th>合格率</th><th>目标</th></tr>'+
		            '<tr><th>行业</th><td>'+sumy1.toFixed(2)+'</td><td>'+pery3+'%</td><td>--</td><td rowspan="4">合规率100%</td></tr>' +
		            '<tr><th>电信</th><td>'+converter(sum11.toFixed(2))+'</td><td>'+per11+'%</td><td>'+converter(realNameRegistration.field_17)+'%</td></tr>' +
		            '<tr><th>移动</th><td>'+converter(sum21.toFixed(2))+'</td><td>'+per21+'%</td><td>'+converter(realNameRegistration.field_27)+'%</td></tr>' +
		            '<tr><th>联通</th><td>'+converter(sum31.toFixed(2))+'</td><td>'+per31+'%</td><td>'+converter(realNameRegistration.field_37)+'%</td></tr>';
				}else{
					dataContent = dataContent + '<tr><th rowspan="5">实名制用户</th><th>单位</th><th>总量（万）</th><th>实名率</th><th>合格率</th><th>目标</th></tr>'+
		            '<tr><th>行业</th><td>--</td><td>--</td><td>--</td><td rowspan="4">合规率100%</td></tr>' +
		            '<tr><th>电信</th><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>移动</th><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>联通</th><td>--</td><td>--</td><td>--</td></tr>';
				}
				              
				if(data.mobileFraudReport!=null){
					mobileFraudReport = data.mobileFraudReport;
					dataContent = dataContent + '<tr><th rowspan="4">通讯信息诈骗举报（手机号）</th><th>单位</th><th>排名（集团/全国）</th><th>被举报件次</th><th>被举报率（件次/千万用户）</th><th>被举报率环比</th></tr>'+
		            '<tr><th>电信</th><td>'+converter(mobileFraudReport.field_11)+'</td><td>'+converter(mobileFraudReport.field_12)+'</td><td>'+converter(mobileFraudReport.field_13)+'</td><td>--</td></tr>' +
		            '<tr><th>移动</th><td>'+converter(mobileFraudReport.field_21)+'</td><td>'+converter(mobileFraudReport.field_22)+'</td><td>'+converter(mobileFraudReport.field_23)+'</td><td>--</td></tr>' +
		            '<tr><th>联通</th><td>'+converter(mobileFraudReport.field_31)+'</td><td>'+converter(mobileFraudReport.field_32)+'</td><td>'+converter(mobileFraudReport.field_33)+'</td><td>--</td></tr>';
				}else{
					dataContent = dataContent + '<tr><th rowspan="4">通讯信息诈骗举报（手机号）</th><th>单位</th><th>排名（集团/全国）</th><th>被举报件次</th><th>被举报率（件次/千万用户）</th><th>被举报率环比</th></tr>'+
		            '<tr><th>电信</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>移动</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>联通</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>';
				}
				
				if(data.landlineFraudReport!=null){
					landlineFraudReport = data.landlineFraudReport;
					dataContent = dataContent + '<tr><th rowspan="4">通讯信息诈骗举报（固定电话）</th><th>单位</th><th>排名（集团/全国）</th><th>被举报件次</th><th>被举报率（件次/千万用户）</th><th>被举报率环比</th></tr>'+
		            '<tr><th>电信</th><td>'+converter(landlineFraudReport.field_11)+'</td><td>'+converter(landlineFraudReport.field_12)+'</td><td>'+converter(landlineFraudReport.field_13)+'</td><td>--</td></tr>' +
		            '<tr><th>移动</th><td>'+converter(landlineFraudReport.field_21)+'</td><td>'+converter(landlineFraudReport.field_22)+'</td><td>'+converter(landlineFraudReport.field_23)+'</td><td>--</td></tr>' +
		            '<tr><th>联通</th><td>'+converter(landlineFraudReport.field_31)+'</td><td>'+converter(landlineFraudReport.field_32)+'</td><td>'+converter(landlineFraudReport.field_33)+'</td><td>--</td></tr>';
				}else{
					dataContent = dataContent + '<tr><th rowspan="4">通讯信息诈骗举报（固定电话）</th><th>单位</th><th>排名（集团/全国）</th><th>被举报件次</th><th>被举报率（件次/千万用户）</th><th>被举报率环比</th></tr>'+
		            '<tr><th>电信</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>移动</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>联通</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>';
				}
				              
				             
				if(data.internetPlatformSpamMessage){
					internetPlatformSpamMessage = data.internetPlatformSpamMessage;
					dataContent = dataContent + '<tr><th rowspan="4">网间平台垃圾短信举报</th><th>单位</th><th>排名（集团/全国）</th><th>被举报率（件次/千万用户）</th><th>增幅</th><th>0000退订</th></tr>'+
		            '<tr><th>电信</th><td>'+converter(internetPlatformSpamMessage.field_11)+'</td><td>'+converter(internetPlatformSpamMessage.field_12)+'</td><td>'+converter(internetPlatformSpamMessage.field_13)+'</td><td>'+converter(internetPlatformSpamMessage.field_14)+'</td></tr>' +
		            '<tr><th>移动</th><td>'+converter(internetPlatformSpamMessage.field_21)+'</td><td>'+converter(internetPlatformSpamMessage.field_22)+'</td><td>'+converter(internetPlatformSpamMessage.field_23)+'</td><td>'+converter(internetPlatformSpamMessage.field_24)+'</td></tr>' +
		            '<tr><th>联通</th><td>'+converter(internetPlatformSpamMessage.field_31)+'</td><td>'+converter(internetPlatformSpamMessage.field_32)+'</td><td>'+converter(internetPlatformSpamMessage.field_33)+'</td><td>'+converter(internetPlatformSpamMessage.field_34)+'</td></tr>';
				}else{
					dataContent = dataContent + '<tr><th rowspan="4">网间平台垃圾短信举报</th><th>单位</th><th>排名（集团/全国）</th><th>被举报率（件次/千万用户）</th><th>增幅</th><th>0000退订</th></tr>'+
		            '<tr><th>电信</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>移动</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>联通</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>';
				}
				             
				if(data.valueAddedTelecomBussiness!=null){
					valueAddedTelecomBussiness = data.valueAddedTelecomBussiness;
					dataContent = dataContent + '<tr><th rowspan="5">增值电信业务</th><th>业务种类</th><th>营业收入（亿）</th><th>同比</th><th>互联网业务收入（亿）</th><th>同比</th></tr>'+
		            '<tr><th>总计</th><td>'+converter(valueAddedTelecomBussiness.field_11)+'</td><td>'+converter(valueAddedTelecomBussiness.field_12)+'</td><td>'+converter(valueAddedTelecomBussiness.field_13)+'</td><td>'+converter(valueAddedTelecomBussiness.field_14)+'</td></tr>' +
		            '<tr><th>信息服务</th><td>'+converter(valueAddedTelecomBussiness.field_21)+'</td><td>'+converter(valueAddedTelecomBussiness.field_22)+'</td><td>'+converter(valueAddedTelecomBussiness.field_23)+'</td><td>'+converter(valueAddedTelecomBussiness.field_24)+'</td></tr>' +
		            '<tr><th>互联网接入及相关服务业务</th><td>'+converter(valueAddedTelecomBussiness.field_31)+'</td><td>'+converter(valueAddedTelecomBussiness.field_32)+'</td><td>'+converter(valueAddedTelecomBussiness.field_33)+'</td><td>'+converter(valueAddedTelecomBussiness.field_34)+'</td></tr>' +
		            '<tr><th>互联网平台收入</th><td>'+converter(valueAddedTelecomBussiness.field_41)+'</td><td>'+converter(valueAddedTelecomBussiness.field_42)+'</td><td>'+converter(valueAddedTelecomBussiness.field_43)+'</td><td>'+converter(valueAddedTelecomBussiness.field_44)+'</td></tr>';
				}else{
					dataContent = dataContent + '<tr><th rowspan="5">增值电信业务</th><th>业务种类</th><th>营业收入（亿）</th><th>同比</th><td>互联网业务收入（亿）</th><th>同比</th></tr>'+
		            '<tr><th>总计</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>信息服务</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>互联网接入及相关服务业务</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>互联网平台收入</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>';
				}
				              
				if(data.zoonValueAddedTelecomBussiness!=null){
					zoonValueAddedTelecomBussiness = data.zoonValueAddedTelecomBussiness;
					dataContent = dataContent + '<tr><th rowspan="4">自贸区增值电信业务（总计家）</th><th>业务种类</td><td>营业收入（亿）</th><th>同比</th><th>电信业务收入（亿）</th><th>同比</th></tr>'+
		            '<tr><th>总计</th><td>'+converter(zoonValueAddedTelecomBussiness.field_11)+'</td><td>'+converter(zoonValueAddedTelecomBussiness.field_12)+'</td><td>'+converter(zoonValueAddedTelecomBussiness.field_13)+'</td><td>'+converter(zoonValueAddedTelecomBussiness.field_14)+'</td></tr>' +
		            '<tr><th>电子商务平台交易额</th><td></td><td></td><td></td><td></td></tr>' +
		            '<tr><th>其他</td><td></th><td></td><td></td><td></td></tr>';       
				}else{
					dataContent = dataContent + '<tr><th rowspan="4">自贸区增值电信业务（总计家）</th><th>业务种类</th><th>营业收入（亿）</th><th>同比</th><th>电信业务收入（亿）</th><th>同比</th></tr>'+
		            '<tr><th>总计</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>电子商务平台交易额</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>其他</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>';       
				}    
				
				if(data.millionUserComplaintRate!=null){
					millionUserComplaintRate = data.millionUserComplaintRate;
					sum1 = millionUserComplaintRate.field_11+millionUserComplaintRate.field_21+millionUserComplaintRate.field_31;
					sum2 = (millionUserComplaintRate.field_12+millionUserComplaintRate.field_22+millionUserComplaintRate.field_32).toFixed(2);
					sum3 = ((millionUserComplaintRate.field_13+millionUserComplaintRate.field_23+millionUserComplaintRate.field_33)/3).toFixed(2);
					sum4 = millionUserComplaintRate.field_14+millionUserComplaintRate.field_24+millionUserComplaintRate.field_34;
					sum5 = (millionUserComplaintRate.field_15+millionUserComplaintRate.field_25+millionUserComplaintRate.field_35).toFixed(2);
					sum6 = ((millionUserComplaintRate.field_16+millionUserComplaintRate.field_26+millionUserComplaintRate.field_36)/3).toFixed(2);
					
					dataContent = dataContent + '<tr><th rowspan="5">百万用户申诉率</th><th>单位</th><th>总受理量(件)</th><th>用户总数（万）</th><th>百万用户申诉率（人次/百万用户）</th><th>目标</th></tr>'+
		            '<tr><th>行业</th><td>'+sum1+'</td><td>'+sum2+'</td><td>'+sum3+'</td><td rowspan="4">全年每百万用户申诉率不超过50人次</td></tr>' +
		            '<tr><th>电信</th><td>'+converter(millionUserComplaintRate.field_11)+'</td><td>'+converter(millionUserComplaintRate.field_12)+'</td><td>'+converter(millionUserComplaintRate.field_13)+'</td></tr>' +
		            '<tr><th>移动</th><td>'+converter(millionUserComplaintRate.field_21)+'</td><td>'+converter(millionUserComplaintRate.field_22)+'</td><td>'+converter(millionUserComplaintRate.field_23)+'</td></tr>' +
		            '<tr><th>联通</th><td>'+converter(millionUserComplaintRate.field_31)+'</td><td>'+converter(millionUserComplaintRate.field_32)+'</td><td>'+converter(millionUserComplaintRate.field_33)+'</td></tr>' ;
					dataContent = dataContent + '<tr><th rowspan="4">不明扣费申诉率</th><th>行业</th><td>'+sum4+'</td><td>'+sum5+'</td><td>'+sum6+'</td><td rowspan="4">全年每百万用户不明扣费申诉率不超过5人次</td></tr>'+
		            '<tr><th>电信</th><td>'+converter(millionUserComplaintRate.field_14)+'</td><td>'+converter(millionUserComplaintRate.field_15)+'</td><td>'+converter(millionUserComplaintRate.field_16)+'</td></tr>' +
		            '<tr><th>移动</th><td>'+converter(millionUserComplaintRate.field_24)+'</td><td>'+converter(millionUserComplaintRate.field_25)+'</td><td>'+converter(millionUserComplaintRate.field_26)+'</td></tr>' +
		            '<tr><th>联通</th><td>'+converter(millionUserComplaintRate.field_34)+'</td><td>'+converter(millionUserComplaintRate.field_35)+'</td><td>'+converter(millionUserComplaintRate.field_36)+'</td></tr>' ;
				}else{
					dataContent = dataContent + '<tr><th rowspan="5">百万用户申诉率</th><th>单位</th><th>总受理量(件)</th><th>用户总数（万）</th><th>百万用户申诉率（人次/百万用户）</th><th>目标</th></tr>'+
		            '<tr><th>行业</th><td>--</td><td>--</td><td>--</td><td rowspan="4">全年每百万用户申诉率不超过50人次</td></tr>' +
		            '<tr><th>电信</th><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>移动</th><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>联通</th><td>--</td><td>--</td><td>--</td></tr>';
					dataContent = dataContent + '<tr><th rowspan="4">不明扣费申诉率</th><th>行业</th><td>--</td><td>--</td><td>--</td><td rowspan="4">全年每百万用户不明扣费申诉率不超过5人次</td></tr>' +
		            '<tr><th>电信</th><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>移动</th><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>联通</th><td>--</td><td>--</td><td>--</td></tr>' ;
				} 
				dataContent = dataContent + '<tr><th rowspan="5">物联网号段分配使用情况</th><th>单位</th><th>总数（万）</th><th>已使用数（万）</th><th>使用率（%）</th><th rowspan="5"></th></tr><tr><th>行业</th><td>--</td><td>--</td><td>--</td></tr>' +
	            '<tr><th>电信</th><td>--</td><td>--</td><td>--</td></tr>' +
	            '<tr><th>移动</th><td>--</td><td>--</td><td>--</td></tr>' +
	            '<tr><th>联通</th><td>--</td><td>--</td><td>--</td></tr>' ;
				/*if(data.virtualOperator!=null){
					virtualOperator = data.virtualOperator;
					dataContent = dataContent + '<tr><th rowspan="3">虚拟运营商</th><th>覆盖范围</th><th>用户总数（万）</th><th>本月新增数（万）</th><th> 转售收入总数（万）</th><th>本月转售收（万）</th></tr>'+
		            '<tr><th>全国</th><td>'+converter(virtualOperator.field_11)+'</td><td>'+converter(virtualOperator.field_12)+'</td><td>'+converter(virtualOperator.field_13)+'</td><td>'+converter(virtualOperator.field_14)+'</td></tr>' +
		            '<tr><th>本地</th><td>'+converter(virtualOperator.field_21)+'</td><td>'+converter(virtualOperator.field_22)+'</td><td>'+converter(virtualOperator.field_23)+'</td><td>'+converter(virtualOperator.field_24)+'</td></tr>' ;
				}else{
					dataContent = dataContent + '<tr><th rowspan="3">虚拟运营商</th><th>覆盖范围</th><th>用户总数（万）</th><th>本月新增数（万）</th><th> 转售收入总数（万）</th><th>本月转售收（万）</th></tr>'+
		            '<tr><th>全国</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>' +
		            '<tr><th>本地</th><td>--</td><td>--</td><td>--</td><td>--</td></tr>';
				}  */           
				dataContent = dataContent + '</teble>';
				$('#dataContent').html(dataContent);
				/*if (data.reportLogList!=null) {
					
				} else {
					layer.msg('没有查询到符合条件的记录', {icon : 0});
					dataContent="<div class='none-data'><span>没有查询到符合条件的记录</span></div>";
					$('#dataContent').html(dataContent);
				}*/
			} else {
				setTimeout(function() {
					layer.closeAll();
					layer.msg('数据拉取失败', {icon : 0});
				}, 2000);
			}

		},
		error : function() {
			setTimeout(function() {
				layer.closeAll();
				layer.msg('获取数据操作异常，请稍后重试', {
					icon : 0
				});
			}, 2000);
		}
	})
}

var init = function(){
	var loadingYear = $("#selectYear").val();
	var loadingMonth = $("#selectMonth").val();
	if(loadingYear==''&&loadingMonth==''){
		var date  = new Date();
		loadingYear = date.getFullYear();
		loadingMonth = date.getMonth();
		//上一年十二月份
		if(loadingMonth==0){
			loadingYear = loadingYear-1;
			loadingMonth = 12;
		}
		$("#selectYear option").each(function (){  
		    if($(this).val()==loadingYear){   
		    	$(this).attr("selected",'selected');  
		 }}); 
		$("#selectMonth option").each(function (){  
		    if($(this).val()==loadingMonth){   
		    	$(this).attr("selected",'selected');
		 }}); 
	}
	queryData(loadingYear,loadingMonth);
	//queryRemark(reportId,loadingYear,loadingMonth);
}();

function queryRemark(reportId,loadingYear,loadingMonth){
	$.ajax({
		type : "get",
		url : "/summary/remark",
		data : {
			reportId : reportId,
			loadingYear : loadingYear,
			loadingMonth : loadingMonth
		},
		dataType : "json",
		success : function(data) {
			   // alert(data.reportRemark.remarkContent);
				if(data.reportRemark!=null){
					$('#remarkContext').html(data.reportRemark.remarkContent);
					$('#remark_id').val(data.reportRemark.id);
				}else{
					$('#remarkContext').html('');
					$('#remark_id').val('0');
				}
		},
		error:function(){
			layer.msg('获取备注失败');
		}
	})
}

var converter = function(param){
	if(param==null){
		return '--';
	}
	return param;
}
