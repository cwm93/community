/**
 * 
 */
jQuery(document).ready(function() {
	$('#searchData').click(function() {
		var loadingYear = $('#selectYear').val();
		var loadingMonth = $('#selectMonth').val();
		var reportId = $('#reportId').val();

		if (loadingYear == '') {
			layer.msg('请选择年份');
		}
		if (loadingMonth == '') {
			layer.msg('请选择月份');
		}
		if (loadingYear != '' && loadingMonth != '') {
			queryData(reportId,loadingYear,loadingMonth);
			queryRemark(reportId,loadingYear,loadingMonth);
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

var queryData = function(reportId,loadingYear,loadingMonth){
	layer.msg('数据查询中', {
		time : 0, // 不自动关闭
		icon : 16,
		shade : 0.01
	});
	var dataContent = "";
	$.ajax({
		type : "get",
		url : "/summary/nhykJson",
		data : {
			reportId : reportId,
			loadingYear : loadingYear,
			loadingMonth : loadingMonth
		},
		dataType : "json",
		success : function(data) {
			var statusData = data.data;
			if (statusData.code == 0) {
				layer.closeAll();
				if (data.reportLogList!=null) {
					layer.msg('数据加载成功');
					dataContent="<table class='table table-bordered'><tr><td>报表名称</td><td>填表人</td><td>状态</td><td>审核状态</td></tr>";
					$.each(data.reportLogList,function(index,reportLog){
						dataContent = dataContent + "<tr>"+"<td><a href='/nhyk/view/"+reportLog.id+"' tagert='_blank'>"+reportLog.title+"</a></td>"+"<td>"+reportLog.toUser.realname+"</td>";
						var status = '';
						var auditStatus = '';
						if(reportLog.status==1){
							status = "已提交"
						}else{
							status = "未提交"
						}
						if(reportLog.auditStatus==2){
							auditStatus = "已退回"
						}else if(reportLog.auditStatus==1){
							auditStatus = "已通过"
						}else{
							auditStatus = "未审核";
						}
						dataContent = dataContent +"<td>"+status+"</td>"+"<td>"+auditStatus+"</td>"                         
						+"</tr>";
					})
					dataContent = dataContent+"</table>";
					
					if(data.f_telecom.id >0 && data.f_mobile.id>0 && data.f_unicom.id>0){
						dataContent = dataContent + '<table class="table table-bordered"><tbody><tr><td colspan="12"class="text-center">上海分公司关于强化行业卡实名登记管理工作要求自查月报表（统计数据截止至'+loadingYear+'年'+loadingMonth+'月底）</td></tr>'+
						'<tr><td rowspan="2" width="10%">《关于进一步防范和打击通讯信息诈骗工作的实施意见》<br/>（工信部网安函〔2016〕452号）工作要求</td><td rowspan="2" width="5%">序号</td><td rowspan="2" width="10%">工作落实情况</td><td colspan="3" width="25%">上海电信</td><td colspan="3" width="25%">上海移动</td><td colspan="3" width="25%">上海联通</td></tr>'+
						'<tr><td width="10%">自查数据</td><td width="10%">未完成原因</td><td width="10%">计划完成时间</td><td width="10%">自查数据</td><td width="10%">未完成原因</td><td width="10%">计划完成时间</td><td width="10%">自查数据</td><td width="10%">未完成原因</td><td width="10%">计划完成时间</td></tr>'+
						'<tr><td rowspan="5">一、对已在网使用的行业卡实名登记情况进行重新核实，对未登记或登记信息错误的用户进行补登记，2017年底前实名率达到100%</td><td>1</td><td>存量物联网卡用户数（个）<br/>存量物联网卡用户数=专用号段物联网卡+公众号段物联网卡</td><td>'+data.f_telecom.field_01+'</td><td>'+data.f_telecom.field_02+'</td><td>'+data.f_telecom.field_03+'</td><td>'+data.f_mobile.field_01+'</td><td>'+data.f_mobile.field_02+'</td><td>'+data.f_mobile.field_03+'</td><td>'+data.f_unicom.field_01+'</td><td>'+data.f_unicom.field_02+'</td><td>'+data.f_unicom.field_03+'</td></tr>'+
						'<tr><td>2</td><td>其中：2016年累计已补登记的物联网卡用户数（个）</td><td>'+data.f_telecom.field_04+'</td><td>'+data.f_telecom.field_05+'</td><td>'+data.f_telecom.field_06+'</td><td>'+data.f_mobile.field_04+'</td><td>'+data.f_mobile.field_05+'</td><td>'+data.f_mobile.field_06+'</td><td>'+data.f_unicom.field_04+'</td><td>'+data.f_unicom.field_05+'</td><td>'+data.f_unicom.field_06+'</td></tr>'+
						'<tr><td>2-1</td><td>存量物联网卡用户中，累计实名制登记到单位和责任人的物联网用户数（个）</td><td>'+data.f_telecom.field_07+'</td><td>'+data.f_telecom.field_08+'</td><td>'+data.f_telecom.field_09+'</td><td>'+data.f_mobile.field_07+'</td><td>'+data.f_mobile.field_08+'</td><td>'+data.f_mobile.field_09+'</td><td>'+data.f_unicom.field_07+'</td><td>'+data.f_unicom.field_08+'</td><td>'+data.f_unicom.field_09+'</td></tr>'+
						'<tr><td>2-2</td><td>存量物联网卡用户中，累计实名制登记到单位和使用人的物联网用户数（个）</td><td>'+data.f_telecom.field_10+'</td><td>'+data.f_telecom.field_11+'</td><td>'+data.f_telecom.field_12+'</td><td>'+data.f_mobile.field_10+'</td><td>'+data.f_mobile.field_11+'</td><td>'+data.f_mobile.field_12+'</td><td>'+data.f_unicom.field_10+'</td><td>'+data.f_unicom.field_11+'</td><td>'+data.f_unicom.field_12+'</td></tr>'+
						'<tr><td>3</td><td>物联网卡用户实名补登记完成进度（%）<br/>（2016年底前须完成100%）</td><td>'+data.f_telecom.field_13+'</td><td>'+data.f_telecom.field_14+'</td><td>'+data.f_telecom.field_15+'</td><td>'+data.f_mobile.field_13+'</td><td>'+data.f_mobile.field_14+'</td><td>'+data.f_mobile.field_15+'</td><td>'+data.f_unicom.field_13+'</td><td>'+data.f_unicom.field_14+'</td><td>'+data.f_unicom.field_15+'</td></tr>'+
						'<tr><td rowspan="6">二、原则上新增的行业卡必须使用13位专用号段，并通过专用网络承载相关业务，特殊情况下需使用11位号段且开通无限制语音功能的，必须按照公众移动电话用户进行实名登记</td><td>4</td><td>存量物联网卡用户中，使用专用号段的物联网卡用户数（个）<br/>（专用号段包含13位专用号段和11位专用号段）</td><td>'+data.f_telecom.field_16+'</td><td>'+data.f_telecom.field_17+'</td><td>'+data.f_telecom.field_18+'</td><td>'+data.f_mobile.field_16+'</td><td>'+data.f_mobile.field_17+'</td><td>'+data.f_mobile.field_18+'</td><td>'+data.f_unicom.field_16+'</td><td>'+data.f_unicom.field_17+'</td><td>'+data.f_unicom.field_18+'</td></tr>'+
						'<tr><td>5</td><td>存量物联网卡用户中，使用公众号段的物联网卡用户数（个）</td><td>'+data.f_telecom.field_19+'</td><td>'+data.f_telecom.field_20+'</td><td>'+data.f_telecom.field_21+'</td><td>'+data.f_mobile.field_19+'</td><td>'+data.f_mobile.field_20+'</td><td>'+data.f_mobile.field_21+'</td><td>'+data.f_unicom.field_19+'</td><td>'+data.f_unicom.field_20+'</td><td>'+data.f_unicom.field_21+'</td></tr>'+
						'<tr><td>6</td><td>存量物联网卡用户中，开通语音功能的物联网卡用户数（个）</td><td>'+data.f_telecom.field_22+'</td><td>'+data.f_telecom.field_23+'</td><td>'+data.f_telecom.field_24+'</td><td>'+data.f_mobile.field_22+'</td><td>'+data.f_mobile.field_23+'</td><td>'+data.f_mobile.field_24+'</td><td>'+data.f_unicom.field_22+'</td><td>'+data.f_unicom.field_23+'</td><td>'+data.f_unicom.field_24+'</td></tr>'+
						'<tr><td>7</td><td>其中：开通无限制语音功能的物联网卡用户数（个）</td><td>'+data.f_telecom.field_25+'</td><td>'+data.f_telecom.field_26+'</td><td>'+data.f_telecom.field_27+'</td><td>'+data.f_mobile.field_25+'</td><td>'+data.f_mobile.field_26+'</td><td>'+data.f_mobile.field_27+'</td><td>'+data.f_unicom.field_25+'</td><td>'+data.f_unicom.field_26+'</td><td>'+data.f_unicom.field_27+'</td></tr>'+
						'<tr><td>7-1</td><td>开通无限制语音功能的物联网卡，已实名补登记到使用人的用户数（个）</td><td>'+data.f_telecom.field_28+'</td><td>'+data.f_telecom.field_29+'</td><td>'+data.f_telecom.field_30+'</td><td>'+data.f_mobile.field_28+'</td><td>'+data.f_mobile.field_29+'</td><td>'+data.f_mobile.field_30+'</td><td>'+data.f_unicom.field_28+'</td><td>'+data.f_unicom.field_29+'</td><td>'+data.f_unicom.field_30+'</td></tr>'+
						'<tr><td>7-2</td><td>开通无限制语音功能的物联网卡，已实名补登记到使用人的完成进度（%）<br/>（2017年底前须完成100%）</td><td>'+data.f_telecom.field_31+'</td><td>'+data.f_telecom.field_32+'</td><td>'+data.f_telecom.field_33+'</td><td>'+data.f_mobile.field_31+'</td><td>'+data.f_mobile.field_32+'</td><td>'+data.f_mobile.field_33+'</td><td>'+data.f_unicom.field_31+'</td><td>'+data.f_unicom.field_32+'</td><td>'+data.f_unicom.field_33+'</td></tr>'+
						'<tr><td rowspan="9">三、对新办理使用行业卡的，从严审核行业用户资质、所需行业卡功能、数量及业务量，按照“功能最小化”原则，屏蔽语音、短信功能，并充分利用技术手段对行业卡使用范围（包括可访问IP地址、端口、通话及短信号码等）、使用场景（如设备IMEI与号卡IMSI一一对应）等进行严格限制和绑定</td><td>序号</td><td>业务限制及机卡绑定技术手段<br/>（请根据本公司实际情况选取目前在用和即将启用的技术手段）</td><td>采用相应技术手段监控的物联网卡用户数（个）</td><td>未采用该技术原因</td><td>计划上线时间</td><td>采用相应技术手段监控的物联网卡用户数（个）</td><td>未采用该技术原因</td><td>计划上线时间</td><td>采用相应技术手段监控的物联网卡用户数（个）</td><td>未采用该技术原因</td><td>计划上线时间</td></tr>'+
						'<tr><td>8</td><td>已采用业务限制及机卡绑定技术手段的号码小计（需剔重）</td><td>'+data.f_telecom.field_70+'</td><td>'+data.f_telecom.field_71+'</td><td>'+data.f_telecom.field_72+'</td><td>'+data.f_mobile.field_70+'</td><td>'+data.f_mobile.field_71+'</td><td>'+data.f_mobile.field_72+'</td><td>'+data.f_unicom.field_70+'</td><td>'+data.f_unicom.field_71+'</td><td>'+data.f_unicom.field_72+'</td></tr>'+
						'<tr><td>9</td><td>通信功能限制：按照最小限度开通业务功能，短信和语音均默认关闭</td><td>'+data.f_telecom.field_34+'</td><td>'+data.f_telecom.field_35+'</td><td>'+data.f_telecom.field_36+'</td><td>'+data.f_mobile.field_34+'</td><td>'+data.f_mobile.field_35+'</td><td>'+data.f_mobile.field_36+'</td><td>'+data.f_unicom.field_34+'</td><td>'+data.f_unicom.field_35+'</td><td>'+data.f_unicom.field_36+'</td></tr>'+
						'<tr><td>10</td><td>专用网络限制：例如，采用“专用APN+专用电路”或者“VPDN隧道+专线”的方式建立VPDN定向网络实现仅访问企业内网功能</td><td>'+data.f_telecom.field_37+'</td><td>'+data.f_telecom.field_38+'</td><td>'+data.f_telecom.field_39+'</td><td>'+data.f_mobile.field_37+'</td><td>'+data.f_mobile.field_38+'</td><td>'+data.f_mobile.field_39+'</td><td>'+data.f_unicom.field_37+'</td><td>'+data.f_unicom.field_38+'</td><td>'+data.f_unicom.field_39+'</td></tr>'+
						'<tr><td>11</td><td>定向IP/URL访问控制：例如，采用专用APN并在M-GGSN上设置或者通过网络侧设置IP访问策略的方式，实现对物联网终端可访问/不可访问特定IP地址/URL的限制功能</td><td>'+data.f_telecom.field_40+'</td><td>'+data.f_telecom.field_41+'</td><td>'+data.f_telecom.field_42+'</td><td>'+data.f_mobile.field_40+'</td><td>'+data.f_mobile.field_41+'</td><td>'+data.f_mobile.field_42+'</td><td>'+data.f_unicom.field_40+'</td><td>'+data.f_unicom.field_41+'</td><td>'+data.f_unicom.field_42+'</td></tr>'+
						'<tr><td>12</td><td>使用区域限制：在HLR上设置漫游区域，限制仅可在上海使用</td><td>'+data.f_telecom.field_43+'</td><td>'+data.f_telecom.field_44+'</td><td>'+data.f_telecom.field_45+'</td><td>'+data.f_mobile.field_43+'</td><td>'+data.f_mobile.field_44+'</td><td>'+data.f_mobile.field_45+'</td><td>'+data.f_unicom.field_43+'</td><td>'+data.f_unicom.field_44+'</td><td>'+data.f_unicom.field_45+'</td></tr>'+
						'<tr><td>13</td><td>语音功能限制：例如，针对某个客户账户下SIM卡设置群组，为每个群组提供语音接听/拨打定向号码能力</td><td>'+data.f_telecom.field_46+'</td><td>'+data.f_telecom.field_47+'</td><td>'+data.f_telecom.field_48+'</td><td>'+data.f_mobile.field_46+'</td><td>'+data.f_mobile.field_47+'</td><td>'+data.f_mobile.field_48+'</td><td>'+data.f_unicom.field_46+'</td><td>'+data.f_unicom.field_47+'</td><td>'+data.f_unicom.field_48+'</td></tr>'+
						'<tr><td>14</td><td>机卡关联绑定：当物联网卡换到其他终端后，后台一旦检测到绑定信息变化，立即停用物联网卡的功能。</td><td>'+data.f_telecom.field_49+'</td><td>'+data.f_telecom.field_50+'</td><td>'+data.f_telecom.field_51+'</td><td>'+data.f_mobile.field_49+'</td><td>'+data.f_mobile.field_50+'</td><td>'+data.f_mobile.field_51+'</td><td>'+data.f_unicom.field_49+'</td><td>'+data.f_unicom.field_50+'</td><td>'+data.f_unicom.field_51+'</td></tr>'+
						'<tr><td>14-1</td><td>其中：通过机卡绑定检测到异常使用的物联网用户数（个）</td><td>'+data.f_telecom.field_52+'</td><td>'+data.f_telecom.field_53+'</td><td>'+data.f_telecom.field_54+'</td><td>'+data.f_mobile.field_52+'</td><td>'+data.f_mobile.field_53+'</td><td>'+data.f_mobile.field_54+'</td><td>'+data.f_unicom.field_52+'</td><td>'+data.f_unicom.field_53+'</td><td>'+data.f_unicom.field_54+'</td></tr>'+
						
						'<tr><td rowspan="6">四、按照“谁发卡、谁负责”原则，加强对行业卡使用情况监测和管控，严禁二次销售和违规使用行业卡。对未采取有监测和管控措施，致使行业卡被倒卖或被用于非行业用户的，从严追究企业负责人的责任</td><td>序号</td><td>工作落实情况</td><td>自查数据</td><td>未完成原因</td><td>计划完成时间</td><td>自查数据</td><td>未完成原因</td><td>计划完成时间</td><td>自查数据</td><td>未完成原因</td><td>计划完成时间</td></tr>'+
						'<tr><td>15</td><td>合同回头看：因合同不规范，缺少主要合同约定内容，包括业务类型、号卡开通功能、销售数量异常、未明确不得进行二次销售等问题，终止合约的存量集团客户数（家）</td><td>'+data.f_telecom.field_55+'</td><td>'+data.f_telecom.field_56+'</td><td>'+data.f_telecom.field_57+'</td><td>'+data.f_mobile.field_55+'</td><td>'+data.f_mobile.field_56+'</td><td>'+data.f_mobile.field_57+'</td><td>'+data.f_unicom.field_55+'</td><td>'+data.f_unicom.field_56+'</td><td>'+data.f_unicom.field_57+'</td></tr>'+
						'<tr><td>16</td><td>本月关停物联网卡用户数（个）</td><td>'+data.f_telecom.field_58+'</td><td>'+data.f_telecom.field_59+'</td><td>'+data.f_telecom.field_60+'</td><td>'+data.f_mobile.field_58+'</td><td>'+data.f_mobile.field_59+'</td><td>'+data.f_mobile.field_60+'</td><td>'+data.f_unicom.field_58+'</td><td>'+data.f_unicom.field_59+'</td><td>'+data.f_unicom.field_60+'</td></tr>'+
						'<tr><td>17</td><td>2017年累计关停物联网卡用户数（个）</td><td>'+data.f_telecom.field_61+'</td><td>'+data.f_telecom.field_62+'</td><td>'+data.f_telecom.field_63+'</td><td>'+data.f_mobile.field_61+'</td><td>'+data.f_mobile.field_62+'</td><td>'+data.f_mobile.field_63+'</td><td>'+data.f_unicom.field_61+'</td><td>'+data.f_unicom.field_62+'</td><td>'+data.f_unicom.field_63+'</td></tr>'+
						'<tr><td>18</td><td>2017年累计被工信部/集团通报的物联网卡用户违规数量（个）</td><td>'+data.f_telecom.field_64+'</td><td>'+data.f_telecom.field_65+'</td><td>'+data.f_telecom.field_66+'</td><td>'+data.f_mobile.field_64+'</td><td>'+data.f_mobile.field_65+'</td><td>'+data.f_mobile.field_66+'</td><td>'+data.f_unicom.field_64+'</td><td>'+data.f_unicom.field_65+'</td><td>'+data.f_unicom.field_66+'</td></tr>'+
						'<tr><td>19</td><td>2017年处罚人员数量（人）</td><td>'+data.f_telecom.field_67+'</td><td>'+data.f_telecom.field_68+'</td><td>'+data.f_telecom.field_69+'</td><td>'+data.f_mobile.field_67+'</td><td>'+data.f_mobile.field_68+'</td><td>'+data.f_mobile.field_69+'</td><td>'+data.f_unicom.field_67+'</td><td>'+data.f_unicom.field_68+'</td><td>'+data.f_unicom.field_69+'</td></tr></tbody></table>';
					}else{
						dataContent = dataContent + '<table class="table table-bordered"><tbody><tr><td class="text-center" style="background-color:#FF5722;color:#fff;padding:8px 0;font-size:14px;">提示</td></tr><tr><td class="text-center">数据未提交或审核未通过，无法生成汇总表格</td></tr><tbody>';
					}
					
					$('#dataContent').html(dataContent);
				} else {
					layer.msg('没有查询到符合条件的记录', {icon : 0});
					dataContent="<div class='none-data'><span>没有查询到符合条件的记录</span></div>";
					$('#dataContent').html(dataContent);
					
				}
			} else {
				setTimeout(function() {
					layer.closeAll();
					layer.msg('数据拉取失败', {
						icon : 0
					});
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
	var reportId = $('#reportId').val();
	queryData(reportId,loadingYear,loadingMonth);
	queryRemark(reportId,loadingYear,loadingMonth);
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
