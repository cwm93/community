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
		url : "/summary/tsjjJson",
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
						dataContent = dataContent + "<tr>"+"<td><a href='/tsjj/view/"+reportLog.id+"' tagert='_blank'>"+reportLog.title+"</a></td>"+"<td>"+reportLog.toUser.realname+"</td>";
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
						dataContent = dataContent + '<table class="table table-bordered"><tbody><tr><td colspan="5" class="text-center">上海地区电信运营企业提速降价工作情况（统计数据截止至'+loadingYear+'年'+loadingMonth+'月底）</td></tr>'+
						'<tr><td colspan="2" width="25%">项目</td><td width="25%">上海电信</td><td width="25%">上海移动</td><td width="25%">上海联通</td></tr>'+
						'<tr><td rowspan="6">固定宽带<br/>单位带宽<br/>平均资费<br/>（元/Mbps)</td><td>'+(loadingYear-1)+'年12月底</td><td>'+data.f_telecom.field_01+'</td><td>'+data.f_mobile.field_01+'</td><td>'+data.f_unicom.field_01+'</td></tr>'+
						'<tr><td>'+loadingYear+'年'+loadingMonth+'月底</td><td>'+data.f_telecom.field_02+'</td><td>'+data.f_mobile.field_02+'</td><td>'+data.f_unicom.field_02+'</td></tr>'+
						'<tr><td>预计'+loadingYear+'年12月底</td><td>'+data.f_telecom.field_03+'</td><td>'+data.f_mobile.field_03+'</td><td>'+data.f_unicom.field_03+'</td></tr>'+
						'<tr><td>集团年度目标</td><td>'+data.f_telecom.field_04+'</td><td>'+data.f_mobile.field_04+'</td><td>'+data.f_unicom.field_04+'</td></tr>'+
						'<tr><td>已完成目标</td><td>'+data.f_telecom.field_05+'</td><td>'+data.f_mobile.field_05+'</td><td>'+data.f_unicom.field_05+'</td></tr>'+
						'<tr><td>预计完成目标</td><td>'+data.f_telecom.field_06+'</td><td>'+data.f_mobile.field_06+'</td><td>'+data.f_unicom.field_06+'</td></tr>'+
						'<tr><td rowspan="6">手机流量<br/>平均资费<br/>（元/GB）</td><td>'+(loadingYear-1)+'年12月底</td><td>'+data.f_telecom.field_07+'</td><td>'+data.f_mobile.field_07+'</td><td>'+data.f_unicom.field_07+'</td></tr>'+
						'<tr><td>'+loadingYear+'年'+loadingMonth+'月底</td><td>'+data.f_telecom.field_08+'</td><td>'+data.f_mobile.field_08+'</td><td>'+data.f_unicom.field_08+'</td></tr>'+
						'<tr><td>预计'+loadingYear+'年12月底</td><td>'+data.f_telecom.field_09+'</td><td>'+data.f_mobile.field_09+'</td><td>'+data.f_unicom.field_09+'</td></tr>'+
						'<tr><td>集团年度目标</td><td>'+data.f_telecom.field_10+'</td><td>'+data.f_mobile.field_10+'</td><td>'+data.f_unicom.field_10+'</td></tr>'+
						'<tr><td>已完成目标</td><td>'+data.f_telecom.field_11+'</td><td>'+data.f_mobile.field_11+'</td><td>'+data.f_unicom.field_11+'</td></tr>'+
						'<tr><td>预计完成目标</td><td>'+data.f_telecom.field_12+'</td><td>'+data.f_mobile.field_12+'</td><td>'+data.f_unicom.field_12+'</td></tr>'+
						'<tr><td rowspan="3">降费举措</td><td>固定宽带方面</td><td>'+data.f_telecom.field_13+'</td><td>'+data.f_mobile.field_13+'</td><td>'+data.f_unicom.field_13+'</td></tr>'+
						'<tr><td>手机流量方面</td><td>'+data.f_telecom.field_14+'</td><td>'+data.f_mobile.field_14+'</td><td>'+data.f_unicom.field_14+'</td></tr>'+
						'<tr><td>宣传方面</td><td>'+data.f_telecom.field_15+'</td><td>'+data.f_mobile.field_15+'</td><td>'+data.f_unicom.field_15+'</td></tr></tbody></table>';
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