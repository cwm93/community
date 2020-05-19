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

	$.ajax({
		type : "get",
		url : "/summary/ljdxxJson",
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
						dataContent = dataContent + "<tr>"+"<td><a href='/ljdxx/view/"+reportLog.id+"' tagert='_blank'>"+reportLog.title+"</a></td>"+"<td>"+reportLog.toUser.realname+"</td>";
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
						dataContent = dataContent +'<table class="table table-bordered"><tbody><tr><td colspan="7" style="text-align: center;">治理垃圾短信息情况月报表（统计数据截止至'+loadingYear+'年'+loadingMonth+'月底）</td></tr>'+
						'<tr><td colspan="3" style="width:25%;">事项</td><td style="width:20%;">电信</td><td style="width:20%;">移动</td><td style="width:20%;">联通</td><td style="width:15%;">总计</td></tr>'+
						'<tr><td colspan="3">收到垃圾短信息投诉量（起）</td><td>'+data.f_telecom.field_01+'</td><td>'+data.f_mobile.field_01+'</td><td>'+data.f_unicom.field_01+'</td><td>'+(Number(data.f_telecom.field_01)+Number(data.f_mobile.field_01)+Number(data.f_unicom.field_01))+'</td></tr>'+
						'<tr><td colspan="3">处理完毕（起）</td><td>'+data.f_telecom.field_02+'</td><td>'+data.f_mobile.field_02+'</td><td>'+data.f_unicom.field_02+'</td><td>'+(Number(data.f_telecom.field_02)+Number(data.f_mobile.field_02)+Number(data.f_unicom.field_02))+'</td></tr>'+
						'<tr><td colspan="3">用户满意率（%）</td><td>'+data.f_telecom.field_03+'%</td><td>'+data.f_mobile.field_03+'%</td><td>'+data.f_unicom.field_03+'%</td><td>'+((Number(data.f_telecom.field_03)+Number(data.f_mobile.field_03)+Number(data.f_unicom.field_03))/3
								).toFixed(2)+'%</td></tr>'+
						'<tr><td colspan="3">拦截垃圾短信息总量（万条）</td><td>'+data.f_telecom.field_04+'</td><td>'+data.f_mobile.field_04+'</td><td>'+data.f_unicom.field_04+'</td><td>'+(Number(data.f_telecom.field_04)+Number(data.f_mobile.field_04)+Number(data.f_unicom.field_04))+'</td></tr>'+
						'<tr><td colspan="3">拦截外省市号码发送总量（万条）</td><td>'+data.f_telecom.field_05+'</td><td>'+data.f_mobile.field_05+'</td><td>'+data.f_unicom.field_05+'</td><td>'+(Number(data.f_telecom.field_05)+Number(data.f_mobile.field_05)+Number(data.f_unicom.field_05))+'</td></tr>'+
						'<tr><td rowspan="4">拦截本市点对点号码发送总量（万条）</td><td colspan="2">MO</td><td>'+data.f_telecom.field_06+'</td><td>'+data.f_mobile.field_06+'</td><td>'+data.f_unicom.field_06+'</td><td>'+(Number(data.f_telecom.field_06)+Number(data.f_mobile.field_06)+Number(data.f_unicom.field_06)).toFixed(4)+'</td></tr>'+
						'<tr><td rowspan="3">MT</td><td>拦截电信发送量</td><td>'+data.f_telecom.field_07+'</td><td>'+data.f_mobile.field_07+'</td><td>'+data.f_unicom.field_07+'</td><td>'+(Number(data.f_telecom.field_07)+Number(data.f_mobile.field_07)+Number(data.f_unicom.field_07)).toFixed(4)+'</td></tr>'+
						'<tr><td>拦截移动发送量</td><td>'+data.f_telecom.field_08+'</td><td>'+data.f_mobile.field_08+'</td><td>'+data.f_unicom.field_08+'</td><td>'+(Number(data.f_telecom.field_08)+Number(data.f_mobile.field_08)+Number(data.f_unicom.field_08)).toFixed(4)+'</td></tr>'+
						'<tr><td>拦截联通发送量</td><td>'+data.f_telecom.field_09+'</td><td>'+data.f_mobile.field_09+'</td><td>'+data.f_unicom.field_09+'</td><td>'+(Number(data.f_telecom.field_09)+Number(data.f_mobile.field_09)+Number(data.f_unicom.field_09)).toFixed(4)+'</td></tr>'+
						'<tr><td colspan="3">拦截本企业企信通类MO短信数量（万条）</td><td>'+data.f_telecom.field_10+'</td><td>'+data.f_mobile.field_10+'</td><td>'+data.f_unicom.field_10+'</td><td>'+(Number(data.f_telecom.field_10)+Number(data.f_mobile.field_10)+Number(data.f_unicom.field_10)).toFixed(4)+'</td></tr>'+
						'<tr><td colspan="3">拦截外省市企信通类MT短信数量（万条）</td><td>'+data.f_telecom.field_11+'</td><td>'+data.f_mobile.field_11+'</td><td>'+data.f_unicom.field_11+'</td><td>'+(Number(data.f_telecom.field_11)+Number(data.f_mobile.field_11)+Number(data.f_unicom.field_11)).toFixed(4)+'</td></tr>'+
						'<tr><td rowspan="4">屏蔽手机号码总数</td><td colspan="2">MO(万个）</td><td>'+data.f_telecom.field_12+'</td><td>'+data.f_mobile.field_12+'</td><td>'+data.f_unicom.field_12+'</td><td>'+(Number(data.f_telecom.field_12)+Number(data.f_mobile.field_12)+Number(data.f_unicom.field_12)).toFixed(4)+'</td></tr>'+
						'<tr><td rowspan="3">MT（个）</td><td>屏蔽电信号码量</td><td>'+data.f_telecom.field_13+'</td><td>'+data.f_mobile.field_13+'</td><td>'+data.f_unicom.field_13+'</td><td>'+(Number(data.f_telecom.field_13)+Number(data.f_mobile.field_13)+Number(data.f_unicom.field_13))+'</td></tr>'+
						'<tr><td>屏蔽移动号码量</td><td>'+data.f_telecom.field_14+'</td><td>'+data.f_mobile.field_14+'</td><td>'+data.f_unicom.field_14+'</td><td>'+(Number(data.f_telecom.field_14)+Number(data.f_mobile.field_14)+Number(data.f_unicom.field_14))+'</td></tr>'+
						'<tr><td>屏蔽联通号码量</td><td>'+data.f_telecom.field_15+'</td><td>'+data.f_mobile.field_15+'</td><td>'+data.f_unicom.field_15+'</td><td>'+(Number(data.f_telecom.field_15)+Number(data.f_mobile.field_15)+Number(data.f_unicom.field_15))+'</td></tr>'+
						'<tr><td colspan="3">封堵违规企信通端口数（个）</td><td>'+data.f_telecom.field_16+'</td><td>'+data.f_mobile.field_16+'</td><td>'+data.f_unicom.field_16+'</td><td>'+(Number(data.f_telecom.field_16)+Number(data.f_mobile.field_16)+Number(data.f_unicom.field_16))+'</td></tr>'+
						'<tr><td rowspan="3">严重违规通报</td><td colspan="2">合作企业</td><td>'+data.f_telecom.field_17+'</td><td>'+data.f_mobile.field_17+'</td><td>'+data.f_unicom.field_17+'</td><td></td></tr>'+
						'<tr><td colspan="2">端口号码</td><td>'+data.f_telecom.field_18+'</td><td>'+data.f_mobile.field_18+'</td><td>'+data.f_unicom.field_18+'</td><td></td></tr>'+
						'<tr><td colspan="2">关键词（组）</td><td>'+data.f_telecom.field_19+'</td><td>'+data.f_mobile.field_19+'</td><td>'+data.f_unicom.field_19+'</td><td></td></tr>'+
						'<tr><td rowspan="42">重点垃圾短信拦截量（条）</td><td rowspan="6">房产类</td><td>企信通MO</td><td>'+data.f_telecom.field_20+'</td><td>'+data.f_mobile.field_20+'</td><td>'+data.f_unicom.field_20+'</td><td>'+(Number(data.f_telecom.field_20)+Number(data.f_mobile.field_20)+Number(data.f_unicom.field_20))+'</td></tr>'+
						'<tr><td>企信通MT</td><td>'+data.f_telecom.field_21+'</td><td>'+data.f_mobile.field_21+'</td><td>'+data.f_unicom.field_21+'</td><td>'+(Number(data.f_telecom.field_21)+Number(data.f_mobile.field_21)+Number(data.f_unicom.field_21))+'</td></tr>'+
						'<tr><td>点对点MO</td><td>'+data.f_telecom.field_22+'</td><td>'+data.f_mobile.field_22+'</td><td>'+data.f_unicom.field_22+'</td><td>'+(Number(data.f_telecom.field_22)+Number(data.f_mobile.field_22)+Number(data.f_unicom.field_22))+'</td></tr>'+
						'<tr><td>点对点MT</td><td>'+data.f_telecom.field_23+'</td><td>'+data.f_mobile.field_23+'</td><td>'+data.f_unicom.field_23+'</td><td>'+(Number(data.f_telecom.field_23)+Number(data.f_mobile.field_23)+Number(data.f_unicom.field_23))+'</td></tr>'+
						'<tr><td>数量合计</td><td>'+data.f_telecom.field_24+'</td><td>'+data.f_mobile.field_24+'</td><td>'+data.f_unicom.field_24+'</td><td>'+(Number(data.f_telecom.field_24)+Number(data.f_mobile.field_24)+Number(data.f_unicom.field_24))+'</td></tr>'+
						'<tr><td>样本</td><td>'+data.f_telecom.field_25+'</td><td>'+data.f_mobile.field_25+'</td><td></td></tr>'+
						'<tr><td rowspan="6">教育类</td><td>企信通MO</td><td>'+data.f_telecom.field_26+'</td><td>'+data.f_mobile.field_26+'</td><td>'+data.f_unicom.field_26+'</td><td>'+(Number(data.f_telecom.field_26)+Number(data.f_mobile.field_26)+Number(data.f_unicom.field_26))+'</td></tr>'+
						'<tr><td>企信通MT</td><td>'+data.f_telecom.field_27+'</td><td>'+data.f_mobile.field_27+'</td><td>'+data.f_unicom.field_27+'</td><td>'+(Number(data.f_telecom.field_27)+Number(data.f_mobile.field_27)+Number(data.f_unicom.field_27))+'</td></tr>'+
						'<tr><td>点对点MO</td><td>'+data.f_telecom.field_28+'</td><td>'+data.f_mobile.field_28+'</td><td>'+data.f_unicom.field_28+'</td><td>'+(Number(data.f_telecom.field_28)+Number(data.f_mobile.field_28)+Number(data.f_unicom.field_28))+'</td></tr>'+
						'<tr><td>点对点MT</td><td>'+data.f_telecom.field_29+'</td><td>'+data.f_mobile.field_29+'</td><td>'+data.f_unicom.field_29+'</td><td>'+(Number(data.f_telecom.field_29)+Number(data.f_mobile.field_29)+Number(data.f_unicom.field_29))+'</td></tr>'+
						'<tr><td>数量合计</td><td>'+data.f_telecom.field_30+'</td><td>'+data.f_mobile.field_30+'</td><td>'+data.f_unicom.field_30+'</td><td>'+(Number(data.f_telecom.field_30)+Number(data.f_mobile.field_30)+Number(data.f_unicom.field_30))+'</td></tr>'+
						'<tr><td>样本</td><td>'+data.f_telecom.field_31+'</td><td>'+data.f_mobile.field_31+'</td><td>'+data.f_unicom.field_31+'</td><td></td></tr>'+
						'<tr><td rowspan="6">金融类</td><td>企信通MO</td><td>'+data.f_telecom.field_32+'</td><td>'+data.f_mobile.field_32+'</td><td>'+data.f_unicom.field_32+'</td><td>'+(Number(data.f_telecom.field_32)+Number(data.f_mobile.field_32)+Number(data.f_unicom.field_32))+'</td></tr>'+
						'<tr><td>企信通MT</td><td>'+data.f_telecom.field_33+'</td><td>'+data.f_mobile.field_33+'</td><td>'+data.f_unicom.field_33+'</td><td>'+(Number(data.f_telecom.field_33)+Number(data.f_mobile.field_33)+Number(data.f_unicom.field_33))+'</td></tr>'+
						'<tr><td>点对点MO</td><td>'+data.f_telecom.field_34+'</td><td>'+data.f_mobile.field_34+'</td><td>'+data.f_unicom.field_34+'</td><td>'+(Number(data.f_telecom.field_34)+Number(data.f_mobile.field_34)+Number(data.f_unicom.field_34))+'</td></tr>'+
						'<tr><td>点对点MT</td><td>'+data.f_telecom.field_35+'</td><td>'+data.f_mobile.field_35+'</td><td>'+data.f_unicom.field_35+'</td><td>'+(Number(data.f_telecom.field_35)+Number(data.f_mobile.field_35)+Number(data.f_unicom.field_35))+'</td></tr>'+
						'<tr><td>数量合计</td><td>'+data.f_telecom.field_36+'</td><td>'+data.f_mobile.field_36+'</td><td>'+data.f_unicom.field_36+'</td><td>'+(Number(data.f_telecom.field_36)+Number(data.f_mobile.field_36)+Number(data.f_unicom.field_36))+'</td></tr>'+
						'<tr><td>样本</td><td>'+data.f_telecom.field_37+'</td><td>'+data.f_mobile.field_37+'</td><td>'+data.f_unicom.field_37+'</td><td></td></tr>'+
						'<tr><td rowspan="6">诈骗</td><td>企信通MO</td><td>'+data.f_telecom.field_38+'</td><td>'+data.f_mobile.field_38+'</td><td>'+data.f_unicom.field_38+'</td><td>'+(Number(data.f_telecom.field_38)+Number(data.f_mobile.field_38)+Number(data.f_unicom.field_38))+'</td></tr>'+
						'<tr><td>企信通MT</td><td>'+data.f_telecom.field_39+'</td><td>'+data.f_mobile.field_39+'</td><td>'+data.f_unicom.field_39+'</td><td>'+(Number(data.f_telecom.field_39)+Number(data.f_mobile.field_39)+Number(data.f_unicom.field_39))+'</td></tr>'+
						'<tr><td>点对点MO</td><td>'+data.f_telecom.field_40+'</td><td>'+data.f_mobile.field_40+'</td><td>'+data.f_unicom.field_40+'</td><td>'+(Number(data.f_telecom.field_40)+Number(data.f_mobile.field_40)+Number(data.f_unicom.field_40))+'</td></tr>'+
						'<tr><td>点对点MT</td><td>'+data.f_telecom.field_41+'</td><td>'+data.f_mobile.field_41+'</td><td>'+data.f_unicom.field_41+'</td><td>'+(Number(data.f_telecom.field_41)+Number(data.f_mobile.field_41)+Number(data.f_unicom.field_41))+'</td></tr>'+
						'<tr><td>数量合计</td><td>'+data.f_telecom.field_42+'</td><td>'+data.f_mobile.field_42+'</td><td>'+data.f_unicom.field_42+'</td><td>'+(Number(data.f_telecom.field_42)+Number(data.f_mobile.field_42)+Number(data.f_unicom.field_42))+'</td></tr>'+
						'<tr><td>样本</td><td>'+data.f_telecom.field_43+'</td><td>'+data.f_mobile.field_43+'</td><td>'+data.f_unicom.field_43+'</td><td></td></tr>'+
						'<tr><td colspan="2">处置策略建议</td><td>'+data.f_telecom.field_44+'</td><td>'+data.f_mobile.field_44+'</td><td>'+data.f_unicom.field_44+'</td><td></td></tr>'+
						'<tr><td rowspan="4">运营商网间短信结算量（点对点）</td><td>→&nbsp;（出）&nbsp;&nbsp;亿条</td><td>'+data.f_telecom.field_45+'</td><td>'+data.f_mobile.field_45+'</td><td>'+data.f_unicom.field_45+'</td><td>'+(Number(data.f_telecom.field_45)+Number(data.f_mobile.field_45)+Number(data.f_unicom.field_45)).toFixed(4)+'</td></tr>'+
						'<tr><td>→&nbsp;（出）&nbsp;&nbsp;亿条</td><td>'+data.f_telecom.field_46+'</td><td>'+data.f_mobile.field_46+'</td><td>'+data.f_unicom.field_46+'</td><td>'+(Number(data.f_telecom.field_46)+Number(data.f_mobile.field_46)+Number(data.f_unicom.field_46)).toFixed(4)+'</td></tr>'+
						'<tr><td>←&nbsp;（入）&nbsp;&nbsp;亿条</td><td>'+data.f_telecom.field_47+'</td><td>'+data.f_mobile.field_47+'</td><td>'+data.f_unicom.field_47+'</td><td>'+(Number(data.f_telecom.field_47)+Number(data.f_mobile.field_47)+Number(data.f_unicom.field_47)).toFixed(4)+'</td></tr>'+
						'<tr><td>←&nbsp;（入）&nbsp;&nbsp;亿条</td><td>'+data.f_telecom.field_48+'</td><td>'+data.f_mobile.field_48+'</td><td>'+data.f_unicom.field_48+'</td><td>'+(Number(data.f_telecom.field_48)+Number(data.f_mobile.field_48)+Number(data.f_unicom.field_48)).toFixed(4)+'</td></tr>'+
						'<tr><td colspan="2">本月通过“0000”退订端口短信数量（条）</td><td>'+data.f_telecom.field_49+'</td><td>'+data.f_mobile.field_49+'</td><td>'+data.f_unicom.field_49+'</td><td>'+(Number(data.f_telecom.field_49)+Number(data.f_mobile.field_49)+Number(data.f_unicom.field_49))+'</td></tr>'+
						'<tr><td colspan="2">其他需要特别说明事项</td><td>'+data.f_telecom.field_50+'</td><td>'+data.f_mobile.field_50+'</td><td>'+data.f_unicom.field_50+'</td><td></td></tr></tbody></table>';;
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
