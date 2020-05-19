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
		url : "/summary/dhsmzJson",
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
						dataContent = dataContent + "<tr>"+"<td><a href='/dhsmz/view/"+reportLog.id+"' tagert='_blank'>"+reportLog.title+"</a></td>"+"<td>"+reportLog.toUser.realname+"</td>";
						var status = '';
						var auditStatus = '';
						if(reportLog.status==1){
							status = "已提交";
						}else{
							status = "未提交";
						}
						if(reportLog.auditStatus==2){
							auditStatus = "已退回";
						}else if(reportLog.auditStatus==1){
							auditStatus = "已通过";
						}else{
							auditStatus = "未审核";
						}
						dataContent = dataContent +"<td>"+status+"</td>"+"<td>"+auditStatus+"</td>"                         
						+"</tr>";
					})
					dataContent = dataContent+"</table>";
					
					if(data.f_telecom.id >0 && data.f_mobile.id>0 && data.f_unicom.id>0){
						sum1 = data.f_telecom.jcdxmds+data.f_mobile.jcdxmds+data.f_unicom.jcdxmds;
						sum2 = data.f_telecom.jcdxmdhgs+data.f_mobile.jcdxmdhgs+data.f_unicom.jcdxmdhgs;
						sum3 = data.f_telecom.zsqymdjcs+data.f_mobile.zsqymdjcs+data.f_unicom.zsqymdjcs;
						sum4 = data.f_telecom.zsqymdshg+data.f_mobile.zsqymdshg+data.f_unicom.zsqymdshg;
						dataContent = dataContent + '<table class="table table-bordered"><tr><td colspan="5" class="text-center">电话实名制志愿者检查情况汇总表（统计数据截止至'+loadingYear+'年'+loadingMonth+'月底）</td></tr>'+
						'<tr><td width="20%">项目</td><td width="20%">电信</td><td width="20%">移动</td><td width="20%">联通</td><td width="20%">总计</td></tr>'+
						'<tr><td>基础电信企业门店数</td><td>'+data.f_telecom.jcdxmds+'</td><td>'+data.f_mobile.jcdxmds+'</td><td>'+data.f_unicom.jcdxmds+'</td><td>'+sum1+'</td></tr>'+
						'<tr><td>基础电信企业门店检查数（合规数）</td><td>'+data.f_telecom.jcdxmdhgs+'</td><td>'+data.f_mobile.jcdxmdhgs+'</td><td>'+data.f_unicom.jcdxmdhgs+'</td><td>'+sum2+'</td></tr>'+
						'<tr><td>基础电信企业门店合规率（%）</td><td>'+((data.f_telecom.jcdxmdhgs/data.f_telecom.jcdxmds)*100).toFixed(2)+'%</td><td>'+((data.f_mobile.jcdxmdhgs/data.f_mobile.jcdxmds)*100).toFixed(2)+'%</td><td>'+((data.f_unicom.jcdxmdhgs/data.f_unicom.jcdxmds)*100).toFixed(2)+'%</td><td>'+(sum2/sum1*100).toFixed(2)+'%</td></tr>'+
						'<tr><td>转售企业门店数检查数</td><td>'+data.f_telecom.zsqymdjcs+'</td><td>'+data.f_mobile.zsqymdjcs+'</td><td>'+data.f_unicom.zsqymdjcs+'</td><td>'+sum3+'</td></tr>'+
						'<tr><td>转售企业门店数（合规）</td><td>'+data.f_telecom.zsqymdshg+'</td><td>'+data.f_mobile.zsqymdshg+'</td><td>'+data.f_unicom.zsqymdshg+'</td><td>'+sum4+'</td></tr>'+
						'<tr><td>转售企业代理网点合规率（%）</td><td>'+((data.f_telecom.zsqymdshg/data.f_telecom.zsqymdjcs)*100).toFixed(2)+'%</td><td>'+((data.f_mobile.zsqymdshg/data.f_mobile.zsqymdjcs)*100).toFixed(2)+'%</td><td>'+((data.f_unicom.zsqymdshg/data.f_unicom.zsqymdjcs)*100).toFixed(2)+'%</td><td>'+(sum4/sum3*100).toFixed(2)+'%</td></tr>'+
						'<tr><td>检查人次</td><td>'+data.f_telecom.checkNumber+'</td><td>'+data.f_mobile.checkNumber+'</td><td>'+data.f_telecom.checkNumber+'</td><td>'+(data.f_telecom.checkNumber+data.f_mobile.checkNumber+data.f_unicom.checkNumber)+'</td></tr>'+
						'<tr><td>志愿者检查门店合规率（%）</td><td>'+((data.f_telecom.jcdxmdhgs+data.f_telecom.zsqymdshg)/(data.f_telecom.jcdxmds+data.f_telecom.zsqymdjcs)*100).toFixed(2)+'%</td><td>'+((data.f_mobile.jcdxmdhgs+data.f_mobile.zsqymdshg)/(data.f_mobile.jcdxmds+data.f_mobile.zsqymdjcs)*100).toFixed(2)+'%</td><td>'+((data.f_unicom.jcdxmdhgs+data.f_unicom.zsqymdshg)/(data.f_unicom.jcdxmds+data.f_unicom.zsqymdjcs)*100).toFixed(2)+'%</td><td>'+((sum2+sum4)/(sum1+sum3)*100).toFixed(2)+'%</td></tr>'+
						'</table>';
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


