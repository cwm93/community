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
		if(loadingYear==2017 && loadingMonth < 7){
			layer.msg('2017年7月份之前的数据请访问历史数据', {time : 3000, icon : 0,shade : 0.01});
			return ;
		}
		var dataContent = "";
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
			return;
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
	layer.msg('数据查询中', {time : 0, icon : 16,shade : 0.01});

	$.ajax({
		type : "get",
		url : "/summary/xxzpJson",
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
					dataContent="<table class='table table-bordered'><tr><td>报表名称</td><td>所在公司</td><td>填表人</td><td>状态</td><td>审核状态</td></tr>";
					$.each(data.reportLogList,function(index,reportLog){
						dataContent = dataContent + "<tr>"+"<td><a href='/xxzp/view/"+reportLog.id+"' tagert='_blank'>"+reportLog.title+"</a></td>"+"<td>"+reportLog.toUser.company+"</td>"+"<td>"+reportLog.toUser.realname+"</td>";
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
						dataContent = dataContent +'<table class="table table-bordered"><tbody><tr><td colspan="2">主要任务</td><td>上海电信</td><td>上海移动（含上海铁通）</td><td>上海联通</td><td>行业情况</td></tr>'+
						'<tr><td colspan="6">一、严格规范语音专线出租业务</td></tr>'+
						'<tr><td rowspan="5">语音专线出租业务</td><td>总用户数（家）</td><td>'+data.f_telecom.field_1+'</td><td>'+data.f_mobile.field_1+'</td><td>'+data.f_unicom.field_1+'</td><td>'+(Number(data.f_telecom.field_1)+Number(data.f_mobile.field_1)+Number(data.f_unicom.field_1))+'</td></tr>'+
						'<tr><td>实名率（%）</td><td>'+data.f_telecom.field_2+'%</td><td>'+data.f_mobile.field_2+'%</td><td>'+data.f_unicom.field_2+'%</td><td>'+((Number(data.f_telecom.field_2)+Number(data.f_mobile.field_2)+Number(data.f_unicom.field_2))/3).toFixed(2)+'%</td></tr>'+
						'<tr><td>老用户核查率（%）</td><td>'+data.f_telecom.field_3+'%</td><td>'+data.f_mobile.field_3+'%</td><td>'+data.f_unicom.field_3+'%</td><td>'+((Number(data.f_telecom.field_3)+Number(data.f_mobile.field_3)+Number(data.f_unicom.field_3))/3).toFixed(2)+'%</td></tr>'+
						'<tr><td>关停企业（家）</td><td>'+data.f_telecom.field_4+'</td><td>'+data.f_mobile.field_4+'</td><td>'+data.f_unicom.field_4+'</td><td>'+(Number(data.f_telecom.field_4)+Number(data.f_mobile.field_4)+Number(data.f_unicom.field_4))+'</td></tr>'+
						'<tr><td>关停号码（个）</td><td>'+data.f_telecom.field_5+'</td><td>'+data.f_mobile.field_5+'</td><td>'+data.f_unicom.field_5+'</td><td>'+(Number(data.f_telecom.field_5)+Number(data.f_mobile.field_5)+Number(data.f_unicom.field_5))+'</td></tr>'+
						'<tr><td colspan="6">二、切实规范“400”、一号通、商务总机业务</td></tr>'+
						'<tr><td rowspan="5">“400”业务</td><td>总用户数（家）</td><td>'+data.f_telecom.field_6+'</td><td>'+data.f_mobile.field_6+'</td><td>'+data.f_unicom.field_6+'</td><td>'+(Number(data.f_telecom.field_6)+Number(data.f_mobile.field_6)+Number(data.f_unicom.field_6))+'</td></tr>'+
						'<tr><td>实名率（%）</td><td>'+data.f_telecom.field_7+'%</td><td>'+data.f_mobile.field_7+'%</td><td>'+data.f_unicom.field_7+'%</td><td>'+((Number(data.f_telecom.field_7)+Number(data.f_mobile.field_7)+Number(data.f_unicom.field_7))/3).toFixed(2)+'%</td></tr>'+
						'<tr><td>老用户核查率（%）</td><td>'+data.f_telecom.field_8+'%</td><td>'+data.f_mobile.field_8+'%</td><td>'+data.f_unicom.field_8+'%</td><td>'+((Number(data.f_telecom.field_8)+Number(data.f_mobile.field_8)+Number(data.f_unicom.field_8))/3).toFixed(2)+'%</td></tr>'+
						'<tr><td>关停企业（家）</td><td>'+data.f_telecom.field_9+'</td><td>'+data.f_mobile.field_9+'</td><td>'+data.f_unicom.field_9+'</td><td>'+(Number(data.f_telecom.field_9)+Number(data.f_mobile.field_9)+Number(data.f_unicom.field_9))+'</td></tr>'+
						'<tr><td>关停号码（个）</td><td>'+data.f_telecom.field_10+'</td><td>'+data.f_mobile.field_10+'</td><td>'+data.f_unicom.field_10+'</td><td>'+(Number(data.f_telecom.field_10)+Number(data.f_mobile.field_10)+Number(data.f_unicom.field_10))+'</td></tr>'+
						'<tr><td rowspan="5">一号通业务</td><td>总用户数（家）</td><td>'+data.f_telecom.field_11+'</td><td>'+data.f_mobile.field_11+'</td><td>'+data.f_unicom.field_11+'</td><td>'+(Number(data.f_telecom.field_11)+Number(data.f_mobile.field_11)+Number(data.f_unicom.field_11))+'</td></tr>'+
						'<tr><td>实名率（%）</td><td>'+data.f_telecom.field_12+'%</td><td>'+data.f_mobile.field_12+'%</td><td>'+data.f_unicom.field_12+'%</td><td>'+((Number(data.f_telecom.field_12)+Number(data.f_mobile.field_12)+Number(data.f_unicom.field_12))/3).toFixed(2)+'%</td></tr>'+
						'<tr><td>老用户核查率（%）</td><td>'+data.f_telecom.field_13+'%</td><td>'+data.f_mobile.field_13+'%</td><td>'+data.f_unicom.field_13+'%</td><td>'+((Number(data.f_telecom.field_13)+Number(data.f_mobile.field_13)+Number(data.f_unicom.field_13))/3).toFixed(2)+'%</td></tr>'+
						'<tr><td>关停企业（家）</td><td>'+data.f_telecom.field_14+'</td><td>'+data.f_mobile.field_14+'</td><td>'+data.f_unicom.field_14+'</td><td>'+(Number(data.f_telecom.field_14)+Number(data.f_mobile.field_14)+Number(data.f_unicom.field_14))+'</td></tr>'+
						'<tr><td>关停号码（个）</td><td>'+data.f_telecom.field_15+'</td><td>'+data.f_mobile.field_15+'</td><td>'+data.f_unicom.field_15+'</td><td>'+(Number(data.f_telecom.field_15)+Number(data.f_mobile.field_15)+Number(data.f_unicom.field_15))+'</td></tr>'+
						'<tr><td rowspan="5">商务总机业务</td><td>总用户数（家）</td><td>'+data.f_telecom.field_16+'</td><td>'+data.f_mobile.field_16+'</td><td>'+data.f_unicom.field_16+'</td><td>'+(Number(data.f_telecom.field_16)+Number(data.f_mobile.field_16)+Number(data.f_unicom.field_16))+'</td></tr>'+
						'<tr><td>实名率（%）</td><td>'+data.f_telecom.field_17+'%</td><td>'+data.f_mobile.field_17+'%</td><td>'+data.f_unicom.field_17+'%</td><td>'+((Number(data.f_telecom.field_17)+Number(data.f_mobile.field_17)+Number(data.f_unicom.field_17))/3).toFixed(2)+'%</td></tr>'+
						'<tr><td>老用户核查率（%）</td><td>'+data.f_telecom.field_18+'%</td><td>'+data.f_mobile.field_18+'%</td><td>'+data.f_unicom.field_18+'%</td><td>'+((Number(data.f_telecom.field_18)+Number(data.f_mobile.field_18)+Number(data.f_unicom.field_18))/3).toFixed(2)+'%</td></tr>'+
						'<tr><td>关停企业（家）</td><td>'+data.f_telecom.field_19+'</td><td>'+data.f_mobile.field_19+'</td><td>'+data.f_unicom.field_19+'</td><td>'+(Number(data.f_telecom.field_19)+Number(data.f_mobile.field_19)+Number(data.f_unicom.field_19))+'</td></tr>'+
						'<tr><td>关停号码（个）</td><td>'+data.f_telecom.field_20+'</td><td>'+data.f_mobile.field_20+'</td><td>'+data.f_unicom.field_20+'</td><td>'+(Number(data.f_telecom.field_20)+Number(data.f_mobile.field_20)+Number(data.f_unicom.field_20))+'</td></tr>'+
						'<tr><td colspan="6">三、从严管理社会营销渠道</td></tr>'+
						'<tr><td rowspan="2">代理行为监管</td><td>代理商总数（家）</td><td>'+data.f_telecom.field_21+'</td><td>'+data.f_mobile.field_21+'</td><td>'+data.f_unicom.field_21+'</td><td>'+(Number(data.f_telecom.field_21)+Number(data.f_mobile.field_21)+Number(data.f_unicom.field_21))+'</td></tr>'+
						'<tr><td>代理商清理数（家）</td><td>'+data.f_telecom.field_22+'</td><td>'+data.f_mobile.field_22+'</td><td>'+data.f_unicom.field_22+'</td><td>'+(Number(data.f_telecom.field_22)+Number(data.f_mobile.field_22)+Number(data.f_unicom.field_22))+'</td></tr>'+
						'<tr><td colspan="6">四、严格规范国际通信业务出入口局主叫号码传送</td></tr>'+
						'<tr><td>封堵境外非法透传</td><td>拦截数量（万次）</td><td>'+data.f_telecom.field_23+'</td><td>'+data.f_mobile.field_23+'</td><td>'+data.f_unicom.field_23+'</td><td>'+(Number(data.f_telecom.field_23)+Number(data.f_mobile.field_23)+Number(data.f_unicom.field_23)).toFixed(4)+'</td></tr>'+
						'<tr><td colspan="6">五、全面实施语音专线主叫鉴权</td></tr>'+
						'<tr><td rowspan="4">语音专线主叫鉴权</td><td>总电路数（条）</td><td>'+data.f_telecom.field_24+'</td><td>'+data.f_mobile.field_24+'</td><td>'+data.f_unicom.field_24+'</td><td>'+(Number(data.f_telecom.field_24)+Number(data.f_mobile.field_24)+Number(data.f_unicom.field_24))+'</td></tr>'+
						'<tr><td>未完成主叫鉴权电路数（条）</td><td>'+data.f_telecom.field_25+'</td><td>'+data.f_mobile.field_25+'</td><td>'+data.f_unicom.field_25+'</td><td>'+(Number(data.f_telecom.field_25)+Number(data.f_mobile.field_25)+Number(data.f_unicom.field_25))+'</td></tr>'+
						'<tr><td>关停电路数（条）</td><td>'+data.f_telecom.field_26+'</td><td>'+data.f_mobile.field_26+'</td><td>'+data.f_unicom.field_26+'</td><td>'+(Number(data.f_telecom.field_26)+Number(data.f_mobile.field_26)+Number(data.f_unicom.field_26))+'</td></tr>'+
						'<tr><td>主叫鉴权率（%）</td><td>'+data.f_telecom.field_27+'%</td><td>'+data.f_mobile.field_27+'%</td><td>'+data.f_unicom.field_27+'%</td><td>'+((Number(data.f_telecom.field_27)+Number(data.f_mobile.field_27)+Number(data.f_unicom.field_27))/3).toFixed(2)+'%</td></tr>'+
						'<tr><td colspan="6">六、加大网内和网间虚假主叫发现与拦截力度</td></tr>'+
						'<tr><td>虚假改号呼叫拦截</td><td>拦截数量（次）</td><td>'+data.f_telecom.field_28+'</td><td>'+data.f_mobile.field_28+'</td><td>'+data.f_unicom.field_28+'</td><td>'+(Number(data.f_telecom.field_28)+Number(data.f_mobile.field_28)+Number(data.f_unicom.field_28))+'</td></tr>'+
						'<tr><td colspan="6">七、提升用户终端安全防护能力</td></tr>'+
						'<tr><td>非法诈骗链接处置</td><td>处置数量（次）</td><td>'+data.f_telecom.field_29+'</td><td>'+data.f_mobile.field_29+'</td><td>'+data.f_unicom.field_29+'</td><td>'+(Number(data.f_telecom.field_29)+Number(data.f_mobile.field_29)+Number(data.f_unicom.field_29))+'</td></tr>'+
						'<tr><td>防骚扰提醒服务</td><td>总用户数（人）</td><td>'+data.f_telecom.field_30+'</td><td>'+data.f_mobile.field_30+'</td><td>'+data.f_unicom.field_30+'</td><td>'+(Number(data.f_telecom.field_30)+Number(data.f_mobile.field_30)+Number(data.f_unicom.field_30))+'</td></tr>'+
						'<tr><td rowspan="3">骚扰电话整顿</td><td>配置白名单中继线（条）</td><td>'+data.f_telecom.field_31+'</td><td>'+data.f_mobile.field_31+'</td><td>'+data.f_unicom.field_31+'</td><td>'+(Number(data.f_telecom.field_31)+Number(data.f_mobile.field_31)+Number(data.f_unicom.field_31))+'</td></tr>'+
						'<tr><td>关停中继线（条）</td><td>'+data.f_telecom.field_32+'</td><td>'+data.f_mobile.field_32+'</td><td>'+data.f_unicom.field_32+'</td><td>'+(Number(data.f_telecom.field_32)+Number(data.f_mobile.field_32)+Number(data.f_unicom.field_32))+'</td></tr>'+
						'<tr><td>关停号码（个）</td><td>'+data.f_telecom.field_33+'</td><td>'+data.f_mobile.field_33+'</td><td>'+data.f_unicom.field_33+'</td><td>'+(Number(data.f_telecom.field_33)+Number(data.f_mobile.field_33)+Number(data.f_unicom.field_33))+'</td></tr>'+
						'<tr><td colspan="6">八、积极配合公安机关做好打击查处工作</td></tr>'+
						'<tr><td rowspan="2">配合打击伪基站</td><td>缴获设备（台）</td><td>'+data.f_telecom.field_34+'</td><td>'+data.f_mobile.field_34+'</td><td>'+data.f_unicom.field_34+'</td><td>'+(Number(data.f_telecom.field_34)+Number(data.f_mobile.field_34)+Number(data.f_unicom.field_34))+'</td></tr>'+
						'<tr><td>抓获嫌疑人（人）</td><td>'+data.f_telecom.field_35+'</td><td>'+data.f_mobile.field_35+'</td><td>'+data.f_unicom.field_35+'</td><td>'+(Number(data.f_telecom.field_35)+Number(data.f_mobile.field_35)+Number(data.f_unicom.field_35))+'</td></tr>'+
						'<tr><td colspan="6">九、畅通社会监督举报渠道</td></tr>'+
						'<tr><td rowspan="3">不良信息举报</td><td>受理举报总数（起）</td><td>'+data.f_telecom.field_36+'</td><td>'+data.f_mobile.field_36+'</td><td>'+data.f_unicom.field_36+'</td><td>'+(Number(data.f_telecom.field_36)+Number(data.f_mobile.field_36)+Number(data.f_unicom.field_36))+'</td></tr>'+
						'<tr><td>平台处置举报（起）</td><td>'+data.f_telecom.field_37+'</td><td>'+data.f_mobile.field_37+'</td><td>'+data.f_unicom.field_37+'</td><td>'+(Number(data.f_telecom.field_37)+Number(data.f_mobile.field_37)+Number(data.f_unicom.field_37))+'</td></tr>'+
						'<tr><td>处置端口（个）</td><td>'+data.f_telecom.field_38+'</td><td>'+data.f_mobile.field_38+'</td><td>'+data.f_unicom.field_38+'</td><td>'+(Number(data.f_telecom.field_38)+Number(data.f_mobile.field_38)+Number(data.f_unicom.field_38))+'</td></tr>'+
						'<tr><td>一键退订</td><td>退订数量（万起）</td><td>'+data.f_telecom.field_39+'</td><td>'+data.f_mobile.field_39+'</td><td>'+data.f_unicom.field_39+'</td><td>'+(Number(data.f_telecom.field_39)+Number(data.f_mobile.field_39)+Number(data.f_unicom.field_39)).toFixed(4)+'</td></tr>'+
						'<tr><td colspan="6">十、加强公众教育与宣传引导</td></tr>'+
						'<tr><td rowspan="4">涉诈骗号码提示服务</td><td>发送提醒短信 （条）</td><td>'+data.f_telecom.field_40+'</td><td>'+data.f_mobile.field_40+'</td><td>'+data.f_unicom.field_40+'</td><td>'+(Number(data.f_telecom.field_40)+Number(data.f_mobile.field_40)+Number(data.f_unicom.field_40))+'</td></tr>'+
						'<tr><td>客服回访 （次）</td><td>'+data.f_telecom.field_41+'</td><td>'+data.f_mobile.field_41+'</td><td>'+data.f_unicom.field_41+'</td><td>'+(Number(data.f_telecom.field_41)+Number(data.f_mobile.field_41)+Number(data.f_unicom.field_41))+'</td></tr>'+
						'<tr><td>回访成功 （次）</td><td>'+data.f_telecom.field_42+'</td><td>'+data.f_mobile.field_42+'</td><td>'+data.f_unicom.field_42+'</td><td>'+(Number(data.f_telecom.field_42)+Number(data.f_mobile.field_42)+Number(data.f_unicom.field_42))+'</td></tr>'+
						'<tr><td>推送公安介入 （次）</td><td>'+data.f_telecom.field_43+'</td><td>'+data.f_mobile.field_43+'</td><td>'+data.f_unicom.field_43+'</td><td>'+(Number(data.f_telecom.field_43)+Number(data.f_mobile.field_43)+Number(data.f_unicom.field_43))+'</td></tr></tbody></table>';
					}else{
						dataContent = dataContent +'<table class="table table-bordered"><tbody><tr><td class="text-center" style="background-color:#FF5722;color:#fff;padding:8px 0;font-size:14px;">提示</td></tr><tr><td class="text-center">数据未提交或审核未通过，无法生成汇总表格</td></tr><tbody>';
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
		//该页面禁止访问2017年7月份之前的数据
		if(loadingYear==2017&&loadingMonth==6){
			loadingMonth =7;
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
	//alert(reportId+"--"+loadingYear+"--"+loadingMonth);
	$.ajax({
		type : "get",
		url : "/summary/remark",
		data : {
			reportId : reportId,
			loadingMonth : loadingMonth,
			loadingYear: loadingYear
		},
		dataType : "json",
		success : function(data) {
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

