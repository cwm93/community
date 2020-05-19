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
		url : "/summary/yhkdzfJson",
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
					dataContent="<table class='table table-bordered'><tr><td>报表名称</td><td>填表人</td><td>所在单位</td><td>状态</td><td>审核状态</td></tr>";
					$.each(data.reportLogList,function(index,reportLog){
						dataContent = dataContent + "<tr>"+"<td><a href='/yhkdzf/view/"+reportLog.id+"' tagert='_blank'>"+reportLog.title+"</a></td>"+"<td>"+reportLog.toUser.realname+"</td>"+"<td>"+reportLog.toUser.company+"</td>";
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
					if(data.f_telecom.id >0 && data.f_mobile.id>0 && data.f_unicom.id>0&& data.f_cckd.id>0 && data.f_dfyx.id>0){
						dataContent = dataContent+ '<div style="width:100%;overflow:auto;"><table class="table table-bordered"><tbody><tr><td colspan="31" style="text-align:center;">基础电信企业家庭用户宽带资费汇总（统计数据截止至'+loadingYear+'年'+loadingMonth+'月底）</td></tr>'+
						'<tr><td width="20%">基础电信企业</td><td colspan="6" width="20%" align="center">上海电信</td><td colspan="6" width="20%" align="center">上海移动</td><td colspan="6" width="20%" align="center">上海联通</td><td colspan="6" width="20%" align="center">长城宽带</td><td colspan="6" width="20%" align="center">东方有线</td></tr>'+
						'<tr><td>带宽</td><td>20M</td><td>50M</td><td>100M</td><td>200M</td><td>500M</td><td>1G</td><td>20M</td><td>50M</td><td>100M</td><td>200M</td><td>500M</td><td>1G</td><td>20M</td><td>50M</td><td>100M</td><td>200M</td><td>500M</td><td>1G</td><td>20M</td><td>50M</td><td>100M</td><td>200M</td><td>500M</td><td>1G</td><td>10M/15M</td><td>30M</td><td>50M</td><td>200M</td><td>500M</td><td>1G</td></tr>'+
						'<tr><td>单宽带套餐资费（上海标准资费）（元/一年）</td><td>'+data.f_telecom.field_01+'</td><td>'+data.f_telecom.field_02+'</td><td>'+data.f_telecom.field_03+'</td><td>'+data.f_telecom.field_2001+'</td><td>'+formatValue(data.f_telecom.field_5001)+'</td><td>'+formatValue(data.f_telecom.field_10241)+'</td><td>'+data.f_mobile.field_01+'</td><td>'+data.f_mobile.field_02+'</td><td>'+data.f_mobile.field_03+'</td><td>'+data.f_mobile.field_2001+'</td><td>'+formatValue(data.f_mobile.field_5001)+'</td><td>'+formatValue(data.f_mobile.field_10241)+'</td><td>'+data.f_unicom.field_01+'</td><td>'+data.f_unicom.field_02+'</td><td>'+data.f_unicom.field_03+'</td><td>'+data.f_unicom.field_2001+'</td><td>'+formatValue(data.f_unicom.field_5001)+'</td><td>'+formatValue(data.f_unicom.field_10241)+'</td><td>'+data.f_cckd.field_01+'</td><td>'+data.f_cckd.field_02+'</td><td>'+data.f_cckd.field_03+'</td><td>'+data.f_cckd.field_2001+'</td><td>'+formatValue(data.f_cckd.field_5001)+'</td><td>'+formatValue(data.f_cckd.field_102411)+'</td><td>'+data.f_dfyx.field_01+'</td><td>'+data.f_dfyx.field_02+'</td><td>'+data.f_dfyx.field_03+'</td><td>'+data.f_dfyx.field_2001+'</td><td>'+formatValue(data.f_dfyx.field_5001)+'</td><td>'+formatValue(data.f_dfyx.field_10241)+'</td></tr>'+
						'<tr><td>单宽带套餐资费（优惠价格）（元/一年）</td><td>'+data.f_telecom.field_04+'</td><td>'+data.f_telecom.field_05+'</td><td>'+data.f_telecom.field_06+'</td><td>'+data.f_telecom.field_2002+'</td><td>'+formatValue(data.f_telecom.field_5002)+'</td><td>'+formatValue(data.f_telecom.field_10242)+'</td><td>'+data.f_mobile.field_04+'</td><td>'+data.f_mobile.field_05+'</td><td>'+data.f_mobile.field_06+'</td><td>'+data.f_mobile.field_2002+'</td><td>'+formatValue(data.f_mobile.field_5002)+'</td><td>'+formatValue(data.f_mobile.field_10242)+'</td><td>'+data.f_unicom.field_04+'</td><td>'+data.f_unicom.field_05+'</td><td>'+data.f_unicom.field_06+'</td><td>'+data.f_unicom.field_2002+'</td><td>'+formatValue(data.f_unicom.field_5002)+'</td><td>'+formatValue(data.f_unicom.field_10242)+'</td><td>'+data.f_cckd.field_04+'</td><td>'+data.f_cckd.field_05+'</td><td>'+data.f_cckd.field_06+'</td><td>'+data.f_cckd.field_2002+'</td><td>'+formatValue(data.f_cckd.field_5002)+'</td><td>'+formatValue(data.f_cckd.field_10242)+'</td><td>'+data.f_dfyx.field_04+'</td><td>'+data.f_dfyx.field_05+'</td><td>'+data.f_dfyx.field_06+'</td><td>'+data.f_dfyx.field_2002+'</td><td>'+formatValue(data.f_dfyx.field_5002)+'</td><td>'+formatValue(data.f_dfyx.field_10242)+'</td></tr>'+
						'<tr><td>融合套餐价格（元/月）</td><td rowspan="3">'+data.f_telecom.field_07+'</td><td>'+data.f_telecom.field_08+'</td><td>'+data.f_telecom.field_09+'</td><td>'+data.f_telecom.field_2003+'</td><td>'+formatValue(data.f_telecom.field_5003)+'</td><td>'+formatValue(data.f_telecom.field_10243)+'</td><td rowspan="3">'+data.f_mobile.field_07+'</td><td>'+data.f_mobile.field_08+'</td><td>'+data.f_mobile.field_09+'</td><td>'+data.f_mobile.field_2003+'</td><td>'+formatValue(data.f_mobile.field_5003)+'</td><td>'+formatValue(data.f_mobile.field_10243)+'</td><td rowspan="3">'+data.f_unicom.field_07+'</td><td>'+data.f_unicom.field_08+'</td><td>'+data.f_unicom.field_09+'</td><td>'+data.f_unicom.field_2003+'</td><td>'+formatValue(data.f_unicom.field_5003)+'</td><td>'+data.f_unicom.field_10243+'</td><td rowspan="3">'+data.f_cckd.field_07+'</td><td>'+data.f_cckd.field_08+'</td><td>'+data.f_cckd.field_09+'</td><td>'+data.f_cckd.field_2003+'</td><td>'+formatValue(data.f_cckd.field_5003)+'</td><td>'+formatValue(data.f_cckd.field_10243)+'</td><td rowspan="3">'+data.f_dfyx.field_07+'</td><td>'+data.f_dfyx.field_08+'</td><td>'+data.f_dfyx.field_09+'</td><td>'+data.f_dfyx.field_2003+'</td><td>'+formatValue(data.f_dfyx.field_5003)+'</td><td>'+formatValue(data.f_dfyx.field_10243)+'</td></tr>'+
						'<tr><td>其中：融合套餐包含的国内分钟数（分钟/月）</td><td>'+data.f_telecom.field_11+'</td><td>'+data.f_telecom.field_12+'</td><td>'+data.f_telecom.field_2004+'</td><td>'+formatValue(data.f_telecom.field_5004)+'</td><td>'+formatValue(data.f_telecom.field_10244)+'</td><td>'+data.f_mobile.field_11+'</td><td>'+data.f_mobile.field_12+'</td><td>'+data.f_mobile.field_2004+'</td><td>'+formatValue(data.f_mobile.field_5004)+'</td><td>'+formatValue(data.f_mobile.field_10244)+'</td><td>'+data.f_unicom.field_11+'</td><td>'+data.f_unicom.field_12+'</td><td>'+data.f_unicom.field_2004+'</td><td>'+formatValue(data.f_unicom.field_5004)+'</td><td>'+formatValue(data.f_unicom.field_10244)+'</td><td>'+data.f_cckd.field_11+'</td><td>'+data.f_cckd.field_12+'</td><td>'+data.f_cckd.field_2004+'</td><td>'+formatValue(data.f_cckd.field_5004)+'</td><td>'+formatValue(data.f_cckd.field_10244)+'</td><td>'+data.f_dfyx.field_11+'</td><td>'+data.f_dfyx.field_12+'</td><td>'+data.f_dfyx.field_2004+'</td><td>'+formatValue(data.f_dfyx.field_5004)+'</td><td>'+formatValue(data.f_dfyx.field_10244)+'</td></tr>'+
						'<tr><td>其中：融合套餐包含的国内流量（M/月）</td><td>'+data.f_telecom.field_14+'</td><td>'+data.f_telecom.field_15+'</td><td>'+data.f_telecom.field_2005+'</td><td>'+formatValue(data.f_telecom.field_5005)+'</td><td>'+formatValue(data.f_telecom.field_10245)+'</td><td>'+data.f_mobile.field_14+'</td><td>'+data.f_mobile.field_15+'</td><td>'+data.f_mobile.field_2005+'</td><td>'+formatValue(data.f_mobile.field_5005)+'</td><td>'+formatValue(data.f_mobile.field_10245)+'</td><td>'+data.f_unicom.field_14+'</td><td>'+data.f_unicom.field_15+'</td><td>'+data.f_unicom.field_2005+'</td><td>'+formatValue(data.f_unicom.field_5005)+'</td><td>'+formatValue(data.f_unicom.field_10245)+'</td><td>'+data.f_cckd.field_14+'</td><td>'+data.f_cckd.field_15+'</td><td>'+data.f_cckd.field_2005+'</td><td>'+formatValue(data.f_cckd.field_5005)+'</td><td>'+formatValue(data.f_cckd.field_10245)+'</td><td>'+data.f_dfyx.field_14+'</td><td>'+data.f_dfyx.field_15+'</td><td>'+data.f_dfyx.field_2005+'</td><td>'+formatValue(data.f_dfyx.field_5005)+'</td><td>'+formatValue(data.f_dfyx.field_10245)+'</td></tr>'+
						'<tr><td>其中：融合套餐包含的优惠</td><td colspan="6">'+data.f_telecom.field_16+'</td><td colspan="6">'+data.f_mobile.field_16+'</td><td colspan="6">'+data.f_unicom.field_16+'</td><td colspan="6">'+data.f_cckd.field_16+'</td><td colspan="6">'+data.f_dfyx.field_16+'</td></tr>'+
						'<tr><td>用户数（万户）</td><td>'+data.f_telecom.field_17+'</td><td>'+data.f_telecom.field_18+'</td><td>'+data.f_mobile.field_19+'</td><td>'+data.f_telecom.field_2006+'</td><td>'+formatValue(data.f_telecom.field_5006)+'</td><td>'+formatValue(data.f_telecom.field_10246)+'</td><td>'+data.f_mobile.field_17+'</td><td>'+data.f_mobile.field_18+'</td><td>'+data.f_mobile.field_19+'</td><td>'+data.f_mobile.field_2006+'</td><td>'+formatValue(data.f_mobile.field_5006)+'</td><td>'+formatValue(data.f_mobile.field_10246)+'</td><td>'+data.f_unicom.field_17+'</td><td>'+data.f_unicom.field_18+'</td><td>'+data.f_unicom.field_19+'</td><td>'+data.f_unicom.field_2006+'</td><td>'+formatValue(data.f_unicom.field_5006)+'</td><td>'+formatValue(data.f_unicom.field_10246)+'</td><td>'+data.f_cckd.field_17+'</td><td>'+data.f_cckd.field_18+'</td><td>'+data.f_cckd.field_19+'</td><td>'+data.f_cckd.field_2006+'</td><td>'+formatValue(data.f_cckd.field_5006)+'</td><td>'+formatValue(data.f_cckd.field_10246)+'</td><td>'+data.f_dfyx.field_17+'</td><td>'+data.f_dfyx.field_18+'</td><td>'+data.f_dfyx.field_19+'</td><td>'+data.f_dfyx.field_2006+'</td><td>'+formatValue(data.f_dfyx.field_5006)+'</td><td>'+formatValue(data.f_dfyx.field_10246)+'</td></tr>'+
						'<tr><td>用户占比（%）<br>（用户数/总家庭用户数）</td><td>'+data.f_telecom.field_20+'</td><td>'+data.f_telecom.field_21+'</td><td>'+data.f_telecom.field_22+'</td><td>'+data.f_telecom.field_2007+'</td><td>'+formatValue(data.f_telecom.field_5007)+'</td><td>'+data.f_mobile.field_20+'</td><td>'+data.f_mobile.field_21+'</td><td>'+data.f_mobile.field_22+'</td><td>'+data.f_mobile.field_2007+'</td><td>'+formatValue(data.f_mobile.field_5007)+'</td><td>'+data.f_unicom.field_20+'</td><td>'+data.f_unicom.field_21+'</td><td>'+data.f_unicom.field_22+'</td><td>'+data.f_unicom.field_2007+'</td><td>'+formatValue(data.f_unicom.field_5007)+'</td><td>'+data.f_cckd.field_20+'</td><td>'+data.f_cckd.field_21+'</td><td>'+data.f_cckd.field_22+'</td><td>'+data.f_cckd.field_2007+'</td><td>'+formatValue(data.f_cckd.field_5007)+'</td><td>'+data.f_dfyx.field_20+'</td><td>'+data.f_dfyx.field_21+'</td><td>'+data.f_dfyx.field_22+'</td><td>'+data.f_dfyx.field_2007+'</td><td>'+formatValue(data.f_dfyx.field_5007)+'</td></tr>'+
						'<tr><td>总家庭用户数（万户）</td><td colspan="6">'+data.f_telecom.field_23+'</td><td colspan="6">'+data.f_mobile.field_23+'</td><td colspan="6">'+data.f_unicom.field_23+'</td><td colspan="6">'+data.f_cckd.field_23+'</td><td colspan="6">'+data.f_dfyx.field_23+'</td></tr>'+
						'<tr><td>总用户数（万户）<br>&nbsp; &nbsp; （包含家庭用户、集客用户）</td><td colspan="6">'+data.f_telecom.field_24+'</td><td colspan="6">'+data.f_mobile.field_23+'</td><td colspan="6">'+data.f_unicom.field_24+'</td><td colspan="6">'+data.f_cckd.field_24+'</td><td colspan="6">'+data.f_dfyx.field_24+'</td></tr>'+
						'<tr><td>当月开账收入（万元）</td><td>'+data.f_telecom.field_25+'</td><td>'+data.f_telecom.field_26+'</td><td>'+data.f_telecom.field_27+'</td><td>'+data.f_telecom.field_2008+'</td><td>'+formatValue(data.f_telecom.field_5008)+'</td><td>'+formatValue(data.f_telecom.field_10248)+'</td><td>'+data.f_mobile.field_25+'</td><td>'+data.f_mobile.field_26+'</td><td>'+data.f_mobile.field_27+'</td><td>'+data.f_mobile.field_2008+'</td><td>'+formatValue(data.f_mobile.field_5008)+'</td><td>'+formatValue(data.f_mobile.field_10248)+'</td><td>'+data.f_unicom.field_25+'</td><td>'+data.f_unicom.field_26+'</td><td>'+data.f_unicom.field_27+'</td><td>'+data.f_unicom.field_2008+'</td><td>'+formatValue(data.f_unicom.field_5008)+'</td><td>'+formatValue(data.f_unicom.field_10248)+'</td><td>'+data.f_cckd.field_25+'</td><td>'+data.f_cckd.field_26+'</td><td>'+data.f_cckd.field_27+'</td><td>'+data.f_cckd.field_2008+'</td><td>'+formatValue(data.f_cckd.field_5008)+'</td><td>'+formatValue(data.f_cckd.field_10248)+'</td><td>'+data.f_dfyx.field_25+'</td><td>'+data.f_dfyx.field_26+'</td><td>'+data.f_dfyx.field_27+'</td><td>'+data.f_dfyx.field_2008+'</td><td>'+formatValue(data.f_dfyx.field_5008)+'</td><td>'+formatValue(data.f_dfyx.field_10248)+'</td></tr>'+
						'<tr><td>销售收入占比（%）</td><td>'+data.f_telecom.field_28+'</td><td>'+data.f_telecom.field_29+'</td><td>'+data.f_telecom.field_30+'</td><td>'+data.f_telecom.field_2009+'</td><td>'+formatValue(data.f_telecom.field_5009)+'</td><td>'+formatValue(data.f_telecom.field_10249)+'</td><td>'+data.f_mobile.field_28+'</td><td>'+data.f_mobile.field_29+'</td><td>'+data.f_mobile.field_30+'</td><td>'+data.f_mobile.field_2009+'</td><td>'+formatValue(data.f_mobile.field_5009)+'</td><td>'+formatValue(data.f_mobile.field_10249)+'</td><td>'+data.f_unicom.field_28+'</td><td>'+data.f_unicom.field_29+'</td><td>'+data.f_unicom.field_30+'</td><td>'+data.f_unicom.field_2009+'</td><td>'+formatValue(data.f_unicom.field_5009)+'</td><td>'+formatValue(data.f_unicom.field_10249)+'</td><td>'+data.f_cckd.field_28+'</td><td>'+data.f_cckd.field_29+'</td><td>'+data.f_cckd.field_30+'</td><td>'+data.f_cckd.field_2009+'</td><td>'+formatValue(data.f_cckd.field_5009)+'</td><td>'+formatValue(data.f_cckd.field_10249)+'</td><td>'+data.f_dfyx.field_28+'</td><td>'+data.f_dfyx.field_29+'</td><td>'+data.f_dfyx.field_30+'</td><td>'+data.f_dfyx.field_2009+'</td><td>'+formatValue(data.f_dfyx.field_5009)+'</td><td>'+formatValue(data.f_dfyx.field_10249)+'</td></tr>'+
						'<tr><td>平均带宽</td><td colspan="6">'+data.f_telecom.field_31+'</td><td colspan="6">'+data.f_mobile.field_31+'</td><td colspan="6">'+data.f_unicom.field_31+'</td><td colspan="6">'+data.f_cckd.field_31+'</td><td colspan="6">'+data.f_dfyx.field_31+'</td></tr>'+
						'<tr><td>千兆用户数</td><td colspan="6">'+data.f_telecom.field_32+'</td><td colspan="6">'+data.f_mobile.field_32+'</td><td colspan="6">'+data.f_unicom.field_32+'</td><td colspan="6">'+data.f_cckd.field_32+'</td><td colspan="6">'+data.f_dfyx.field_32+'</td></tr>'+
						'<tr><td>降价后对收入的影响（预期）</td><td colspan="6">'+data.f_telecom.field_34+'</td><td colspan="6">'+data.f_mobile.field_34+'</td><td colspan="6">'+data.f_unicom.field_34+'</td><td colspan="6">'+data.f_cckd.field_34+'</td><td colspan="6">'+data.f_dfyx.field_34+'</td></tr>'+
						'<tr><td>单宽带套餐资费（北京地区标准资费）（元/一年）</td><td>'+data.f_telecom.field_35+'</td><td>'+data.f_telecom.field_36+'</td><td>'+data.f_telecom.field_37+'</td><td>'+data.f_telecom.field_20010+'</td><td>'+formatValue(data.f_telecom.field_50010)+'</td><td>'+formatValue(data.f_telecom.field_102410)+'</td><td>'+data.f_mobile.field_35+'</td><td>'+data.f_mobile.field_36+'</td><td>'+data.f_mobile.field_37+'</td><td>'+data.f_mobile.field_20010+'</td><td>'+formatValue(data.f_mobile.field_50010)+'</td><td>'+formatValue(data.f_mobile.field_102410)+'</td><td>'+data.f_unicom.field_35+'</td><td>'+data.f_unicom.field_36+'</td><td>'+data.f_unicom.field_37+'</td><td>'+data.f_unicom.field_20010+'</td><td>'+formatValue(data.f_unicom.field_50010)+'</td><td>'+formatValue(data.f_unicom.field_102410)+'</td><td>'+data.f_cckd.field_35+'</td><td>'+data.f_cckd.field_36+'</td><td>'+data.f_cckd.field_37+'</td><td>'+data.f_cckd.field_20010+'</td><td>'+formatValue(data.f_cckd.field_50010)+'</td><td>'+formatValue(data.f_cckd.field_102410)+'</td><td>'+data.f_dfyx.field_35+'</td><td>'+data.f_dfyx.field_36+'</td><td>'+data.f_dfyx.field_37+'</td><td>'+data.f_dfyx.field_20010+'</td><td>'+formatValue(data.f_dfyx.field_50010)+'</td><td>'+formatValue(data.f_dfyx.field_102410)+'</td></tr>'+
						'<tr><td>单宽带套餐资费（北京地区优惠价格）（元/一年）</td>'+data.f_telecom.field_38+'<td></td><td>'+data.f_telecom.field_39+'</td><td>'+data.f_telecom.field_40+'</td><td>'+data.f_telecom.field_20011+'</td><td>'+formatValue(data.f_telecom.field_50011)+'</td><td>'+formatValue(data.f_telecom.field_102411)+'</td><td>'+data.f_mobile.field_38+'</td><td>'+data.f_mobile.field_39+'</td><td>'+data.f_mobile.field_40+'</td><td>'+data.f_mobile.field_20011+'</td><td>'+formatValue(data.f_mobile.field_50011)+'</td><td>'+formatValue(data.f_mobile.field_102411)+'</td><td>'+data.f_unicom.field_38+'</td><td>'+data.f_unicom.field_39+'</td><td>'+data.f_unicom.field_40+'</td><td>'+data.f_unicom.field_20011+'</td><td>'+formatValue(data.f_unicom.field_50011)+'</td><td>'+formatValue(data.f_unicom.field_102411)+'</td><td>'+data.f_cckd.field_38+'</td><td>'+data.f_cckd.field_39+'</td><td>'+data.f_cckd.field_40+'</td><td>'+data.f_cckd.field_20011+'</td><td>'+formatValue(data.f_cckd.field_50011)+'</td><td>'+formatValue(data.f_cckd.field_102411)+'</td><td>'+data.f_dfyx.field_38+'</td><td>'+data.f_dfyx.field_39+'</td><td>'+data.f_dfyx.field_40+'</td><td>'+data.f_dfyx.field_20011+'</td><td>'+formatValue(data.f_dfyx.field_50011)+'</td><td>'+formatValue(data.f_dfyx.field_102411)+'</td></tr></tbody></table><div>';
					}else{
                        dataContent = dataContent +'<table class="table table-bordered"><tbody><tr><td class="text-center" style="background-color:#FF5722;color:#fff;padding:8px 0;font-size:14px;">提示</td></tr><tr><td class="text-center">数据未提交或审核未通过，无法生成汇总表格</td></tr><tbody>';
					}
					$('#dataContent').html(dataContent);
				} else {
					layer.msg('没有查询到符合条件的记录', {icon : 0});
					dataContent="<div class='none-data'>没有查询到符合条件的记录</div>";
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


function formatValue(target){
	if(target==null){
		return '--';
	}else{
		return target;
	}
}