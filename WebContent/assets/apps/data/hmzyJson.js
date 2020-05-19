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
		url : "/summary/hmzyJson",
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
						dataContent = dataContent + "<tr>"+"<td><a href='/hmzy/view/"+reportLog.id+"' tagert='_blank'>"+reportLog.title+"</a>"+"<td>"+reportLog.toUser.company+"("+reportLog.toUser.realname+")</td>";
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
					dataContent = dataContent + "</table>";
					if(data.d_codeSum >0 && data.y_codeSum >0 && data.l_codeSum>0){
						dataContent = dataContent +'<table class="table table-bordered" id="export"><tbody><tr><td colspan="4" class="text-center">固网号码资源使用情况统计表（数据截至'+loadingYear+'年'+loadingMonth+'月末）</span></td></tr>'+
						'<tr><td>运 营 商</td><td rowspan="2">电信</td><td rowspan="2">联通</td><td rowspan="2">铁通</td></tr>'+
						'<tr><td>类 别</td></tr><tr><td>局号数（万）</td><td>'+data.d_codeSum+'</td><td>'+data.l_codeSum+'</td><td>'+data.y_codeSum+'</td></tr>'+
						'<tr><td>逻辑号码在用数（个）</td><td>'+data.d_logicUsegeNumber+'</td><td>'+data.l_logicUsegeNumber+'</td><td>'+data.y_logicUsegeNumber+'</td></tr>'+
						'<tr><td>逻辑号码使用率</td><td>'+(data.d_logicUsegeNumber/(data.d_codeSum*10000)*100).toFixed(2)+'%</td><td>'+(data.l_logicUsegeNumber/(data.l_codeSum*10000)*100).toFixed(2)+'%</td><td>'+(data.y_logicUsegeNumber/(data.y_codeSum*10000)*100).toFixed(2)+'%</td></tr>'+
						'<tr><td>物理号码已派配数（个）</td><td>'+data.d_physicsAssignedNumber+'</td><td>'+data.l_physicsAssignedNumber+'</td><td>'+data.y_physicsAssignedNumber+'</td></tr>'+
						'<tr><td>物理号码使用率</td><td>'+(data.d_physicsAssignedNumber/(data.d_codeSum*10000)*100).toFixed(2)+'%</td><td>'+(data.l_physicsAssignedNumber/(data.l_codeSum*10000)*100).toFixed(2)+'%</td><td>'+(data.y_physicsAssignedNumber/(data.y_codeSum*10000)*100).toFixed(2)+'%</td></tr>'+
						'<tr><td>号码占用数（个）</td><td>'+data.d_occupiedNumber+'</td><td>'+data.l_occupiedNumber+'</td><td>'+data.y_occupiedNumber+'</td></tr>'+
						'<tr><td>号码使用率</td><td>'+(data.d_occupiedNumber/(data.d_codeSum*10000)*100).toFixed(2)+'%</td><td>'+(data.l_occupiedNumber/(data.l_codeSum*10000)*100).toFixed(2)+'%</td><td>'+(data.y_occupiedNumber/(data.y_codeSum*10000)*100).toFixed(2)+'%</td></tr></tbody></table>';
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

