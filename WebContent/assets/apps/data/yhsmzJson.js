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
		url : "/summary/yhsmzJson",
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
						dataContent = dataContent + "<tr>"+"<td><a href='/yhsmz/view/"+reportLog.id+"' tagert='_blank'>"+reportLog.title+"</a></td>"+"<td>"+reportLog.toUser.company+"</td>"+"<td>"+reportLog.toUser.realname+"</td>";
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
					if(data.f_telecom.id >0 && data.f_mobile.id>0 && data.f_unicom.id>0 && data.f_railcom.id>0){
						dataContent = dataContent+ '<div style="width:100%;overflow:auto;"><table class="table table-bordered">'+
						'<tbody><tr><td colspan="25" class="text-center">上海市电话用户真实身份信息登记数据统计表（统计数据截止至'+loadingYear+'年'+loadingMonth+'月底）</td></tr>'+
						'<tr><td colspan="25" class="text-center">表一：电话用户有关数据统计</td></tr>'+
						'<tr><td rowspan="2">类别</td><td colspan="8">移动电话用户(万)</td><td colspan="8">固定电话用户(万)</td><td colspan="8" rowspan="2">所有电话用户（万）</td></tr>'+
						'<tr><td colspan="8">（含无线上网卡用户）</td><td colspan="8">（含无线市话用户）</td></tr>'+
						'<tr><td></td><td colspan="4">截至本月末用户</td><td colspan="4">本月新增用户</td><td colspan="5">截至本月末用户</td><td colspan="3">本月新增用户</td><td colspan="5">截至本月末用户</td><td colspan="3">本月新增用户</td></tr>'+
						'<tr><td>单位</td><td>总用户数</td><td>已登记 用户数</td><td>实名率</td><td>环比增加率</td><td>总用户数</td><td>已登记 用户数</td><td>实名率</td><td>补登记实名制用户数</td><td>总用户数</td><td>已登记 用户数</td><td>实名率</td><td>环比 增加率</td><td>补登记实名制用户数</td><td>总用户数</td><td>已登记 用户数</td><td>实名率</td><td>总用户数</td><td>已登记 用户数</td><td>实名率</td><td>环比 增加率</td><td>补登记实名制用户数</td><td>总用户数</td><td>已登记 用户数</td><td>实名率</td></tr>'+
						'<tr><td>电信公司</td><td>'+data.f_telecom.field_01+'</td><td>'+data.f_telecom.field_07+'</td><td>'+data.f_telecom.field_13+'%</td><td>'+data.f_telecom.field_25+'%</td><td>'+data.f_telecom.field_02+'</td><td>'+data.f_telecom.field_08+'</td><td>'+data.f_telecom.field_14+'%</td><td>'+data.f_telecom.field_19+'</td><td>'+data.f_telecom.field_03+'</td><td>'+data.f_telecom.field_09+'</td><td>'+data.f_telecom.field_15+'%</td><td>'+data.f_telecom.field_26+'%</td><td>'+data.f_telecom.field_21+'</td><td>'+data.f_telecom.field_04+'</td><td>'+data.f_telecom.field_10+'%</td><td>'+data.f_telecom.field_16+'</td><td>'+data.f_telecom.field_05+'</td><td>'+data.f_telecom.field_11+'</td><td>'+data.f_telecom.field_17+'%</td><td>'+data.f_telecom.field_27+'%</td><td>'+data.f_telecom.field_23+'</td><td>'+data.f_telecom.field_06+'</td><td>'+data.f_telecom.field_12+'</td><td>'+data.f_telecom.field_18+'%</td></tr>'+
						'<tr><td>移动公司</td><td>'+data.f_mobile.field_01+'</td><td>'+data.f_mobile.field_07+'</td><td>'+data.f_mobile.field_13+'%</td><td>'+data.f_mobile.field_25+'%</td><td>'+data.f_mobile.field_02+'</td><td>'+data.f_mobile.field_08+'</td><td>'+data.f_mobile.field_14+'%</td><td>'+data.f_mobile.field_19+'</td><td>'+data.f_mobile.field_03+'</td><td>'+data.f_mobile.field_09+'</td><td>'+data.f_mobile.field_15+'%</td><td>'+data.f_mobile.field_26+'%</td><td>'+data.f_mobile.field_21+'</td><td>'+data.f_mobile.field_04+'</td><td>'+data.f_mobile.field_10+'%</td><td>'+data.f_mobile.field_16+'</td><td>'+data.f_mobile.field_05+'</td><td>'+data.f_mobile.field_11+'</td><td>'+data.f_mobile.field_17+'%</td><td>'+data.f_mobile.field_27+'%</td><td>'+data.f_mobile.field_23+'</td><td>'+data.f_mobile.field_06+'</td><td>'+data.f_mobile.field_12+'</td><td>'+data.f_mobile.field_18+'%</td></tr>'+
						'<tr><td>联通公司</td><td>'+data.f_unicom.field_01+'</td><td>'+data.f_unicom.field_07+'</td><td>'+data.f_unicom.field_13+'%</td><td>'+data.f_unicom.field_25+'%</td><td>'+data.f_unicom.field_02+'</td><td>'+data.f_unicom.field_08+'</td><td>'+data.f_unicom.field_14+'%</td><td>'+data.f_unicom.field_19+'</td><td>'+data.f_unicom.field_03+'</td><td>'+data.f_unicom.field_09+'</td><td>'+data.f_unicom.field_15+'%</td><td>'+data.f_unicom.field_26+'%</td><td>'+data.f_unicom.field_21+'</td><td>'+data.f_unicom.field_04+'</td><td>'+data.f_unicom.field_10+'%</td><td>'+data.f_unicom.field_16+'</td><td>'+data.f_unicom.field_05+'</td><td>'+data.f_unicom.field_11+'</td><td>'+data.f_unicom.field_17+'%</td><td>'+data.f_unicom.field_27+'%</td><td>'+data.f_unicom.field_23+'</td><td>'+data.f_unicom.field_06+'</td><td>'+data.f_unicom.field_12+'</td><td>'+data.f_unicom.field_18+'%</td></tr>'+
						'<tr><td>铁通公司</td><td>'+data.f_railcom.field_01+'</td><td>'+data.f_railcom.field_07+'</td><td>'+data.f_railcom.field_13+'%</td><td>'+data.f_railcom.field_25+'%</td><td>'+data.f_railcom.field_02+'</td><td>'+data.f_railcom.field_08+'</td><td>'+data.f_railcom.field_14+'%</td><td>'+data.f_railcom.field_19+'</td><td>'+data.f_railcom.field_03+'</td><td>'+data.f_railcom.field_09+'</td><td>'+data.f_railcom.field_15+'%</td><td>'+data.f_railcom.field_26+'%</td><td>'+data.f_railcom.field_21+'</td><td>'+data.f_railcom.field_04+'</td><td>'+data.f_railcom.field_10+'%</td><td>'+data.f_railcom.field_16+'</td><td>'+data.f_railcom.field_05+'</td><td>'+data.f_railcom.field_11+'</td><td>'+data.f_railcom.field_17+'%</td><td>'+data.f_railcom.field_27+'%</td><td>'+data.f_railcom.field_23+'</td><td>'+data.f_railcom.field_06+'</td><td>'+data.f_railcom.field_12+'</td><td>'+data.f_telecom.field_18+'%</td></tr>'+
						//'<tr><td>合计</td><td>--</td><td>--</td><td>100.00%</td><td>0.00%</td><td>57.43</td><td>57.43</td><td>100%</td><td>0.58</td><td>687.31</td><td>684.82</td><td>99.64%</td><td>0.00%</td><td>24.03</td><td>1.86</td><td>1.86</td><td>100%</td><td>4055.50</td><td>4052.92</td><td>99.94%</td><td>0.00%</td><td>531.1</td><td>59.29</td><td>59.29</td><td>100%</td></tr>'+
						'<tr><td colspan="25">注：“环比增加率”：本月末“实名率”与上月末“实名率”相比，增加了多少百分点。</td></tr></tbody></table>';
						dataContent = dataContent+
					    '<table class="table table-bordered" style="margin-top:35px;">'+
						'<tr><td colspan="7" class="text-center">表二：营销渠道有关数据统计</td></tr>'+
						'<tr><td>类 别</td><td>单 位</td><td>电信公司</td><td>移动公司</td><td>联通公司</td><td>铁通公司</td><td>合计</td></tr>'+
						'<tr><td rowspan="2">自营厅</td><td>总数</td><td>'+data.f_telecom.field_40+'</td><td>'+data.f_mobile.field_40+'</td><td>'+data.f_unicom.field_40+'</td><td>'+data.f_railcom.field_40+'</td><td>'+(Number(data.f_telecom.field_40)+Number(data.f_mobile.field_40)+Number(data.f_unicom.field_40)+Number(data.f_railcom.field_40))+'</td></tr>'+
						'<tr><td>本月发展新用户占比</td><td>'+data.f_telecom.field_41+'%</td><td>'+data.f_mobile.field_41+'%</td><td>'+data.f_unicom.field_41+'%</td><td>'+data.f_railcom.field_41+'%</td><td>'+((Number(data.f_telecom.field_41)+Number(data.f_mobile.field_41)+Number(data.f_unicom.field_41)+Number(data.f_railcom.field_41))/4).toFixed(2)+'%</td></tr>'+
						'<tr><td colspan="2">合作厅/专营厅总数</td><td>'+data.f_telecom.field_42+'</td><td>'+data.f_mobile.field_42+'</td><td>'+data.f_unicom.field_42+'</td><td>'+data.f_railcom.field_42+'</td><td>'+(Number(data.f_telecom.field_42)+Number(data.f_mobile.field_42)+Number(data.f_unicom.field_42)+Number(data.f_railcom.field_42))+'</td></tr>'+
						'<tr><td rowspan="4">代理点</td><td>总数</td><td>'+data.f_telecom.field_43+'</td><td>'+data.f_mobile.field_43+'</td><td>'+data.f_unicom.field_43+'</td><td>'+data.f_railcom.field_43+'</td><td>'+(Number(data.f_telecom.field_43)+Number(data.f_mobile.field_43)+Number(data.f_unicom.field_43)+Number(data.f_railcom.field_43))+'</td></tr>'+
						'<tr><td>开展真实身份信息登记代理点数</td><td>'+data.f_telecom.field_44+'</td><td>'+data.f_mobile.field_44+'</td><td>'+data.f_unicom.field_44+'</td><td>'+data.f_railcom.field_44+'</td><td>'+(Number(data.f_telecom.field_44)+Number(data.f_mobile.field_44)+Number(data.f_unicom.field_44)+Number(data.f_railcom.field_44))+'</td></tr>'+
						'<tr><td>渠道售卡数</td><td></td><td></td><td></td><td></td><td></td></tr>'+
						'<tr><td>照片稽核合规率</td><td></td><td></td><td></td><td></td><td></td></tr>'+
						'<tr><td rowspan="2">电商平台</td><td>授权数</td><td>'+data.f_telecom.field_45+'</td><td>'+data.f_mobile.field_45+'</td><td>'+data.f_unicom.field_45+'</td><td>'+data.f_railcom.field_45+'</td><td>'+(Number(data.f_telecom.field_45)+Number(data.f_mobile.field_45)+Number(data.f_unicom.field_45)+Number(data.f_railcom.field_45))+'</td></tr>'+
						'<tr><td>清理未授权数</td><td>'+data.f_telecom.field_46+'</td><td>'+data.f_mobile.field_46+'</td><td>'+data.f_unicom.field_46+'</td><td>'+data.f_railcom.field_46+'</td><td>'+(Number(data.f_telecom.field_46)+Number(data.f_mobile.field_46)+Number(data.f_unicom.field_46)+Number(data.f_railcom.field_46))+'</td></tr>'+
						'<tr><td colspan="2">实名登记自动录入终端数</td><td>'+data.f_telecom.field_49+'</td><td>'+data.f_mobile.field_49+'</td><td>'+data.f_unicom.field_49+'</td><td>'+data.f_railcom.field_49+'</td><td>'+(Number(data.f_telecom.field_49)+Number(data.f_mobile.field_49)+Number(data.f_unicom.field_49)+Number(data.f_railcom.field_49))+'</td></tr>'+
						'<tr><td colspan="2">二代身份证识别仪数</td><td>'+data.f_telecom.field_50+'</td><td>'+data.f_mobile.field_50+'</td><td>'+data.f_unicom.field_50+'</td><td>'+data.f_railcom.field_50+'</td><td>'+(Number(data.f_telecom.field_50)+Number(data.f_mobile.field_50)+Number(data.f_unicom.field_50)+Number(data.f_railcom.field_50))+'</td></tr>'+
						'<tr><td colspan="2">二代身份证识别设备网点</td><td>'+data.f_telecom.field_51+'</td><td>'+data.f_mobile.field_51+'</td><td>'+data.f_unicom.field_51+'</td><td>'+data.f_railcom.field_51+'</td><td>'+(Number(data.f_telecom.field_51)+Number(data.f_mobile.field_51)+Number(data.f_unicom.field_51)+Number(data.f_railcom.field_51))+'</td></tr>'+
						'<tr><td rowspan="4">行业应用无线上网卡</td><td>单位数（户）</td><td>'+data.f_telecom.field_52+'</td><td>'+data.f_mobile.field_52+'</td><td>'+data.f_unicom.field_52+'</td><td>'+data.f_railcom.field_52+'</td><td>'+(Number(data.f_telecom.field_52)+Number(data.f_mobile.field_52)+Number(data.f_unicom.field_52)+Number(data.f_railcom.field_52))+'</td></tr>'+
						'<tr><td>卡数</td><td>'+data.f_telecom.field_54+'</td><td>'+data.f_mobile.field_54+'</td><td>'+data.f_unicom.field_54+'</td><td>'+data.f_railcom.field_54+'</td><td>'+(Number(data.f_telecom.field_54)+Number(data.f_mobile.field_54)+Number(data.f_unicom.field_54)+Number(data.f_railcom.field_54)).toFixed(2)+'</td></tr>'+
						'<tr><td>单位责任人已登记数</td><td>'+data.f_telecom.field_53+'</td><td>'+data.f_mobile.field_53+'</td><td>'+data.f_unicom.field_53+'</td><td>'+data.f_railcom.field_53+'</td><td>'+(Number(data.f_telecom.field_53)+Number(data.f_mobile.field_53)+Number(data.f_unicom.field_53)+Number(data.f_railcom.field_53)).toFixed(2)+'</td></tr>'+
						'<tr><td>单位责任人未登记数（户）</td><td>'+data.f_telecom.field_55+'</td><td>'+data.f_mobile.field_55+'</td><td>'+data.f_unicom.field_55+'</td><td>'+data.f_railcom.field_55+'</td><td>'+(Number(data.f_telecom.field_55)+Number(data.f_mobile.field_55)+Number(data.f_unicom.field_55)+Number(data.f_railcom.field_55)).toFixed(2)+'</td></tr>'+
						//'<tr><td rowspan="4">集团用户电话卡（含无线上网卡）</td><td>单位数（户）</td><td>'+data.f_telecom.field_56+'</td><td>'+data.f_mobile.field_56+'</td><td>'+data.f_unicom.field_56+'</td><td>'+data.f_railcom.field_56+'</td><td>'+(Number(data.f_telecom.field_56)+Number(data.f_mobile.field_56)+Number(data.f_unicom.field_56)+Number(data.f_railcom.field_56)).toFixed(2)+'</td></tr>'+
						//'<tr><td>卡数</td><td>'+data.f_telecom.field_58+'</td><td>'+data.f_mobile.field_58+'</td><td>'+data.f_unicom.field_58+'</td><td>'+data.f_railcom.field_58+'</td><td>'+(Number(data.f_telecom.field_58)+Number(data.f_mobile.field_58)+Number(data.f_unicom.field_58)+Number(data.f_railcom.field_58)).toFixed(2)+'</td></tr>'+
						//'<tr><td>已登记到用户个人数</td><<td>'+data.f_telecom.field_57+'</td><td>'+data.f_mobile.field_57+'</td><td>'+data.f_unicom.field_57+'</td><td>'+data.f_railcom.field_57+'</td><td>'+(Number(data.f_telecom.field_57)+Number(data.f_mobile.field_57)+Number(data.f_unicom.field_57)+Number(data.f_railcom.field_57)).toFixed(2)+'</td></tr>'+
						//'<tr><td>未登记数用户个人数</td><td>'+data.f_telecom.field_59+'</td><td>'+data.f_mobile.field_59+'</td><td>'+data.f_unicom.field_59+'</td><td>'+data.f_railcom.field_59+'</td><td>'+(Number(data.f_telecom.field_59)+Number(data.f_mobile.field_59)+Number(data.f_unicom.field_59)+Number(data.f_railcom.field_59)).toFixed(2)+'</td></tr>'+
						'<tr><td rowspan="4">同一身份证件登记5张以上移动电话卡</td><td>卡数</td><td>'+data.f_telecom.field_60+'</td><td>'+data.f_mobile.field_60+'</td><td>'+data.f_unicom.field_60+'</td><td>'+data.f_railcom.field_60+'</td><td>'+(Number(data.f_telecom.field_60)+Number(data.f_mobile.field_60)+Number(data.f_unicom.field_60)+Number(data.f_railcom.field_60)).toFixed(2)+'</td></tr>'+
						'<tr><td>用户数</td><td>'+data.f_telecom.field_61+'</td><td>'+data.f_mobile.field_61+'</td><td>'+data.f_unicom.field_61+'</td><td>'+data.f_railcom.field_61+'</td><td>'+(Number(data.f_telecom.field_61)+Number(data.f_mobile.field_61)+Number(data.f_unicom.field_61)+Number(data.f_railcom.field_61)).toFixed(2)+'</td></tr>'+
						'<tr><td>已核查数</td><td>'+data.f_telecom.field_62+'</td><td>'+data.f_mobile.field_62+'</td><td>'+data.f_unicom.field_62+'</td><td>'+data.f_railcom.field_62+'</td><td>'+(Number(data.f_telecom.field_62)+Number(data.f_mobile.field_62)+Number(data.f_unicom.field_62)+Number(data.f_railcom.field_62)).toFixed(2)+'</td></tr>'+
						'<tr><td>已完成补登记数</td><td>'+data.f_telecom.field_63+'</td><td>'+data.f_mobile.field_63+'</td><td>'+data.f_unicom.field_63+'</td><td>'+data.f_railcom.field_63+'</td><td>'+(Number(data.f_telecom.field_63)+Number(data.f_mobile.field_63)+Number(data.f_unicom.field_63)+Number(data.f_railcom.field_63)).toFixed(2)+'</td></tr>'+
						//'<tr><td rowspan="4">漫游至新疆和西藏超过2个月的用户</td><td>卡数</td><td>'+data.f_telecom.field_64+'</td><td>'+data.f_mobile.field_64+'</td><td>'+data.f_unicom.field_64+'</td><td>'+data.f_railcom.field_64+'</td><td>'+(Number(data.f_telecom.field_64)+Number(data.f_mobile.field_64)+Number(data.f_unicom.field_64)+Number(data.f_railcom.field_64))+'</td></tr>'+
						//'<tr><td>用户数</td><td>'+data.f_telecom.field_65+'</td><td>'+data.f_mobile.field_65+'</td><td>'+data.f_unicom.field_65+'</td><td>'+data.f_railcom.field_65+'</td><td>'+(Number(data.f_telecom.field_65)+Number(data.f_mobile.field_65)+Number(data.f_unicom.field_65)+Number(data.f_railcom.field_65))+'</td></tr>'+
						//'<tr><td>已核查数</td><td>'+data.f_telecom.field_66+'</td><td>'+data.f_mobile.field_66+'</td><td>'+data.f_unicom.field_66+'</td><td>'+data.f_railcom.field_66+'</td><td>'+(Number(data.f_telecom.field_66)+Number(data.f_mobile.field_66)+Number(data.f_unicom.field_66)+Number(data.f_railcom.field_66))+'</td></tr>'+
						//'<tr><td>已完成补登记数</td><td>'+data.f_telecom.field_67+'</td><td>'+data.f_mobile.field_67+'</td><td>'+data.f_unicom.field_67+'</td><td>'+data.f_railcom.field_67+'</td><td>'+(Number(data.f_mobile.field_67)+Number(data.f_telecom.field_67)+Number(data.f_unicom.field_67)+Number(data.f_railcom.field_67))+'</td></tr>'+
						'<tr><td rowspan="3">社会渠道授权牌</td><td>应配发总数</td><td>'+data.f_telecom.field_68+'</td><td>'+data.f_mobile.field_68+'</td><td>'+data.f_unicom.field_68+'</td><td>'+data.f_railcom.field_68+'</td><td>'+(Number(data.f_telecom.field_68)+Number(data.f_mobile.field_68)+Number(data.f_unicom.field_68)+Number(data.f_railcom.field_68))+'</td></tr>'+
						'<tr><td>本月新增数</td><td>'+data.f_telecom.field_69+'</td><td>'+data.f_mobile.field_69+'</td><td>'+data.f_unicom.field_69+'</td><td>'+data.f_railcom.field_69+'</td><td>'+(Number(data.f_telecom.field_69)+Number(data.f_mobile.field_69)+Number(data.f_unicom.field_69)+Number(data.f_railcom.field_69))+'</td></tr>'+
						'<tr><td>未配发总数</td><td>'+data.f_telecom.field_70+'</td><td>'+data.f_mobile.field_70+'</td><td>'+data.f_unicom.field_70+'</td><td>'+data.f_railcom.field_70+'</td><td>'+(Number(data.f_telecom.field_70)+Number(data.f_mobile.field_70)+Number(data.f_unicom.field_70)+Number(data.f_railcom.field_70))+'</td></tr>'+
						'<tr><td colspan="2">本月终止违规代理商数</td><td>'+data.f_telecom.field_71+'</td><td>'+data.f_mobile.field_71+'</td><td>'+data.f_unicom.field_71+'</td><td>'+data.f_railcom.field_71+'</td><td>'+(Number(data.f_telecom.field_71)+Number(data.f_mobile.field_71)+Number(data.f_unicom.field_71)+Number(data.f_railcom.field_71))+'</td></tr>'+
						'<tr><td colspan="2">上报黑名单数</td><td>'+data.f_telecom.field_72+'</td><td>'+data.f_mobile.field_72+'</td><td>'+data.f_unicom.field_72+'</td><td>'+data.f_railcom.field_72+'</td><td>'+(Number(data.f_mobile.field_72)+Number(data.f_mobile.field_72)+Number(data.f_unicom.field_72)+Number(data.f_railcom.field_72))+'</td></tr></tbody></table></div>';
						
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

function getTable(){
	var loadingYear = $('#selectYear').val();
	var loadingMonth = $('#selectMonth').val();
var	tableContent = '<table class="table table-bordered">'+
	'<tbody><tr><td colspan="25" class="text-center">上海市电话用户真实身份信息登记数据统计表（统计数据截止至'+loadingYear+'年'+loadingMonth+'月底）</td></tr>'+
	'<tr><td colspan="25" class="text-center">表一：电话用户有关数据统计</td></tr>'+
	'<tr><td rowspan="2">类别</td><td colspan="8">移动电话用户(万)</td><td colspan="8">固定电话用户(万)</td><td colspan="8" rowspan="2">所有电话用户（万）</td></tr>'+
	'<tr><td colspan="8">（含无线上网卡用户）</td><td colspan="8">（含无线市话用户）</td></tr>'+
	'<tr><td></td><td colspan="4">截至本月末用户</td><td colspan="4">本月新增用户</td><td colspan="5">截至本月末用户</td><td colspan="3">本月新增用户</td><td colspan="5">截至本月末用户</td><td colspan="3">本月新增用户</td></tr>'+
	'<tr><td>单位</td><td>总用户数</td><td>已登记 用户数</td><td>实名率</td><td>环比增加率</td><td>总用户数</td><td>已登记 用户数</td><td>实名率</td><td>补登记实名制用户数</td><td>总用户数</td><td>已登记 用户数</td><td>实名率</td><td>环比 增加率</td><td>补登记实名制用户数</td><td>总用户数</td><td>已登记 用户数</td><td>实名率</td><td>总用户数</td><td>已登记 用户数</td><td>实名率</td><td>环比 增加率</td><td>补登记实名制用户数</td><td>总用户数</td><td>已登记 用户数</td><td>实名率</td></tr>'+
	'<tr><td>电信公司</td><td>'+data.f_telecom.field_01+'</td><td>'+data.f_telecom.field_07+'</td><td>'+data.f_telecom.field_13+'</td><td>'+data.f_telecom.field_19+'</td><td>'+data.f_telecom.field_02+'</td><td>'+data.f_telecom.field_08+'</td><td>'+data.f_telecom.field_14+'</td><td>'+data.f_telecom.field_03+'</td><td>'+data.f_telecom.field_09+'</td><td>'+data.f_telecom.field_15+'</td><td>'+data.f_telecom.field_26+'</td><td>0.00%</td><td>'+data.f_telecom.field_04+'</td><td></td><td>'+data.f_telecom.field_10+'</td><td>'+data.f_telecom.field_16+'</td><td>1221.77</td><td>1219.28</td><td>99.80%</td><td>0.00%</td><td>175.84</td><td>16.8</td><td>16.8</td><td>'+data.f_telecom.field_19+'</td></tr>'+
	'<tr><td>移动公司</td><td>2123.33</td><td>2123.24</td><td>100.00%</td><td>0.00%</td><td>21.61</td><td>21.61</td><td>100%</td><td>0.47</td><td>–</td><td>–</td><td>–</td><td>–</td><td>–</td><td>–</td><td>–</td><td>–</td><td>2123.33</td><td>2123.24</td><td>100.00%</td><td>0.00%</td><td>301.59</td><td>21.61</td><td>21.61</td><td>100%</td></tr>'+
	'<tr><td>联通公司</td><td>630.4</td><td>630.4</td><td>100.00%</td><td>0.00%</td><td>20.6</td><td>20.6</td><td>100%</td><td>0.11</td><td>48.7</td><td>48.7</td><td>100.00%</td><td>0.00%</td><td>0</td><td>0.1</td><td>0.1</td><td>100%</td><td>679.1</td><td>679.1</td><td>100.00%</td><td>0.00%</td><td>53.67</td><td>20.7</td><td>20.7</td><td>100%</td></tr>'+
	'<tr><td>铁通公司</td><td>–</td><td>–</td><td>–</td><td>–</td><td>–</td><td>–</td><td>–</td><td>–</td><td>31.3</td><td>31.3</td><td>100.00%</td><td>0.00%</td><td>0</td><td>0.18</td><td>0.18</td><td>100%</td><td>31.3</td><td>31.3</td><td>100.00%</td><td>0.00%</td><td>0</td><td>0.18</td><td>0.18</td><td>100%</td></tr>'+
	'<tr><td>合计</td><td>3368.19</td><td>3368.1</td><td>100.00%</td><td>0.00%</td><td>57.43</td><td>57.43</td><td>100%</td><td>0.58</td><td>687.31</td><td>684.82</td><td>99.64%</td><td>0.00%</td><td>24.03</td><td>1.86</td><td>1.86</td><td>100%</td><td>4055.50</td><td>4052.92</td><td>99.94%</td><td>0.00%</td><td>531.1</td><td>59.29</td><td>59.29</td><td>100%</td></tr>'+
	'<tr><td colspan="25">注：“环比增加率”：本月末“实名率”与上月末“实名率”相比，增加了多少百分点。</td></tr></tbody></table>';
tableContent = tableContent + 
    '<table class="table table-bordered" style="margin-top:35px;">'+
	'<tr><td colspan="7" class="text-center">表二：营销渠道有关数据统计</td></tr>'+
	'<tr><td>类 别</td><td>单 位</td><td>电信公司</td><td>移动公司</td><td>联通公司</td><td>铁通公司</td><td>合计</td></tr>'+
	'<tr><td rowspan="2">自营厅</td><td>总数</td><td>'+data.f_telecom.field_40+'</td><td>'+data.f_mobile.field_40+'</td><td>'+data.f_unicom.field_40+'</td><td>'+data.f_railcom.field_40+'</td><td>'+(data.f_mobile.field_40+data.f_mobile.field_40+data.f_unicom.field_40+data.f_railcom.field_40)+'</td></tr>'+
	'<tr><td>本月发展新用户占比</td><td>'+data.f_telecom.field_41+'</td><td>'+data.f_mobile.field_41+'</td><td>'+data.f_unicom.field_41+'</td><td>'+data.f_railcom.field_41+'</td><td>'+((data.f_mobile.field_41+data.f_mobile.field_41+data.f_unicom.field_41+data.f_railcom.field_41)/3)+'</td></tr>'+
	'<tr><td colspan="2">合作厅/专营厅总数</td><td>'+data.f_telecom.field_42+'</td><td>'+data.f_mobile.field_42+'</td><td>'+data.f_unicom.field_42+'</td><td>'+data.f_railcom.field_42+'</td><td>'+(data.f_mobile.field_42+data.f_mobile.field_42+data.f_unicom.field_42+data.f_railcom.field_42)+'</td></tr>'+
	'<tr><td rowspan="4">代理点</td><td>总数</td><td>'+data.f_telecom.field_43+'</td><td>'+data.f_mobile.field_43+'</td><td>'+data.f_unicom.field_43+'</td><td>'+data.f_railcom.field_43+'</td><td>'+(data.f_mobile.field_43+data.f_mobile.field_43+data.f_unicom.field_43+data.f_railcom.field_43)+'</td></tr>'+
	'<tr><td>开展真实身份信息登记代理点数</td><td>'+data.f_telecom.field_44+'</td><td>'+data.f_mobile.field_44+'</td><td>'+data.f_unicom.field_44+'</td><td>'+data.f_railcom.field_44+'</td><td>'+(data.f_mobile.field_44+data.f_mobile.field_44+data.f_unicom.field_44+data.f_railcom.field_44)+'</td></tr>'+
	'<tr><td>渠道售卡数</td><td></td><td></td><td></td><td></td><td></td></tr>'+
	'<tr><td>照片稽核合规率</td><td></td><td></td><td></td><td></td><td></td></tr>'+
	'<tr><td rowspan="2">电商平台</td><td>授权数</td><td>'+data.f_telecom.field_45+'</td><td>'+data.f_mobile.field_45+'</td><td>'+data.f_unicom.field_45+'</td><td>'+data.f_railcom.field_45+'</td><td>'+(data.f_mobile.field_45+data.f_mobile.field_45+data.f_unicom.field_45+data.f_railcom.field_45)+'</td></tr>'+
	'<tr><td>清理未授权数</td><td>'+data.f_telecom.field_46+'</td><td>'+data.f_mobile.field_46+'</td><td>'+data.f_unicom.field_46+'</td><td>'+data.f_railcom.field_46+'</td><td>'+(data.f_mobile.field_46+data.f_mobile.field_46+data.f_unicom.field_46+data.f_railcom.field_46)+'</td></tr>'+
	'<tr><td colspan="2">实名登记自动录入终端数</td><td>'+data.f_telecom.field_49+'</td><td>'+data.f_mobile.field_49+'</td><td>'+data.f_unicom.field_49+'</td><td>'+data.f_railcom.field_49+'</td><td>'+(data.f_mobile.field_49+data.f_mobile.field_49+data.f_unicom.field_49+data.f_railcom.field_49)+'</td></tr>'+
	'<tr><td colspan="2">二代身份证识别仪数</td><td>'+data.f_telecom.field_50+'</td><td>'+data.f_mobile.field_50+'</td><td>'+data.f_unicom.field_50+'</td><td>'+data.f_railcom.field_50+'</td><td>'+(data.f_mobile.field_50+data.f_mobile.field_50+data.f_unicom.field_50+data.f_railcom.field_50)+'</td></tr>'+
	'<tr><td colspan="2">二代身份证识别设备网点</td><td>'+data.f_telecom.field_51+'</td><td>'+data.f_mobile.field_51+'</td><td>'+data.f_unicom.field_51+'</td><td>'+data.f_railcom.field_51+'</td><td>'+(data.f_mobile.field_51+data.f_mobile.field_51+data.f_unicom.field_51+data.f_railcom.field_51)+'</td></tr>'+
	'<tr><td rowspan="4">行业应用无线上网卡</td><td>单位数（户）</td><td>'+data.f_telecom.field_52+'</td><td>'+data.f_mobile.field_52+'</td><td>'+data.f_unicom.field_52+'</td><td>'+data.f_railcom.field_52+'</td><td>'+(data.f_mobile.field_52+data.f_mobile.field_52+data.f_unicom.field_52+data.f_railcom.field_52)+'</td></tr>'+
	'<tr><td>卡数</td><td>'+data.f_telecom.field_54+'</td><td>'+data.f_mobile.field_54+'</td><td>'+data.f_unicom.field_54+'</td><td>'+data.f_railcom.field_54+'</td><td>'+(data.f_mobile.field_54+data.f_mobile.field_54+data.f_unicom.field_54+data.f_railcom.field_54)+'</td></tr>'+
	'<tr><td>单位责任人已登记数</td><td>'+data.f_telecom.field_53+'</td><td>'+data.f_mobile.field_53+'</td><td>'+data.f_unicom.field_53+'</td><td>'+data.f_railcom.field_53+'</td><td>'+(data.f_mobile.field_53+data.f_mobile.field_53+data.f_unicom.field_53+data.f_railcom.field_53)+'</td></tr>'+
	'<tr><td>单位责任人未登记数（户）</td><td>'+data.f_telecom.field_55+'</td><td>'+data.f_mobile.field_55+'</td><td>'+data.f_unicom.field_55+'</td><td>'+data.f_railcom.field_55+'</td><td>'+(data.f_mobile.field_55+data.f_mobile.field_55+data.f_unicom.field_55+data.f_railcom.field_55)+'</td></tr>'+
	'<tr><td rowspan="4">集团用户电话卡（含无线上网卡）</td><td>单位数（户）</td><td>'+data.f_telecom.field_56+'</td><td>'+data.f_mobile.field_56+'</td><td>'+data.f_unicom.field_56+'</td><td>'+data.f_railcom.field_56+'</td><td>'+(data.f_mobile.field_56+data.f_mobile.field_56+data.f_unicom.field_56+data.f_railcom.field_56)+'</td></tr>'+
	'<tr><td>卡数</td><td>'+data.f_telecom.field_58+'</td><td>'+data.f_mobile.field_58+'</td><td>'+data.f_unicom.field_58+'</td><td>'+data.f_railcom.field_58+'</td><td>'+(data.f_mobile.field_58+data.f_mobile.field_58+data.f_unicom.field_58+data.f_railcom.field_58)+'</td></tr>'+
	'<tr><td>已登记到用户个人数</td><<td>'+data.f_telecom.field_57+'</td><td>'+data.f_mobile.field_57+'</td><td>'+data.f_unicom.field_57+'</td><td>'+data.f_railcom.field_57+'</td><td>'+(data.f_mobile.field_57+data.f_mobile.field_57+data.f_unicom.field_57+data.f_railcom.field_57)+'</td></tr>'+
	'<tr><td>未登记数用户个人数</td><td>'+data.f_telecom.field_59+'</td><td>'+data.f_mobile.field_59+'</td><td>'+data.f_unicom.field_59+'</td><td>'+data.f_railcom.field_59+'</td><td>'+(data.f_mobile.field_59+data.f_mobile.field_59+data.f_unicom.field_59+data.f_railcom.field_59)+'</td></tr>'+
	'<tr><td rowspan="4">同一身份证件登记5张以上移动电话卡</td><td>卡数</td><td>'+data.f_telecom.field_60+'</td><td>'+data.f_mobile.field_60+'</td><td>'+data.f_unicom.field_60+'</td><td>'+data.f_railcom.field_60+'</td><td>'+(data.f_mobile.field_60+data.f_mobile.field_60+data.f_unicom.field_60+data.f_railcom.field_60)+'</td></tr>'+
	'<tr><td>用户数</td><td>'+data.f_telecom.field_61+'</td><td>'+data.f_mobile.field_61+'</td><td>'+data.f_unicom.field_61+'</td><td>'+data.f_railcom.field_61+'</td><td>'+(data.f_mobile.field_61+data.f_mobile.field_61+data.f_unicom.field_61+data.f_railcom.field_661)+'</td></tr>'+
	'<tr><td>已核查数</td><td>'+data.f_telecom.field_62+'</td><td>'+data.f_mobile.field_62+'</td><td>'+data.f_unicom.field_62+'</td><td>'+data.f_railcom.field_62+'</td><td>'+(data.f_mobile.field_62+data.f_mobile.field_62+data.f_unicom.field_62+data.f_railcom.field_62)+'</td></tr>'+
	'<tr><td>已完成补登记数</td><td>'+data.f_telecom.field_63+'</td><td>'+data.f_mobile.field_63+'</td><td>'+data.f_unicom.field_63+'</td><td>'+data.f_railcom.field_63+'</td><td>'+(data.f_mobile.field_63+data.f_mobile.field_63+data.f_unicom.field_63+data.f_railcom.field_63)+'</td></tr>'+
	'<tr><td rowspan="4">漫游至新疆和西藏超过2个月的用户</td><td>卡数</td><td>'+data.f_telecom.field_64+'</td><td>'+data.f_mobile.field_64+'</td><td>'+data.f_unicom.field_64+'</td><td>'+data.f_railcom.field_64+'</td><td>'+(data.f_mobile.field_64+data.f_mobile.field_64+data.f_unicom.field_64+data.f_railcom.field_64)+'</td></tr>'+
	'<tr><td>用户数</td><td>'+data.f_telecom.field_65+'</td><td>'+data.f_mobile.field_65+'</td><td>'+data.f_unicom.field_65+'</td><td>'+data.f_railcom.field_65+'</td><td>'+(data.f_mobile.field_65+data.f_mobile.field_65+data.f_unicom.field_65+data.f_railcom.field_65)+'</td></tr>'+
	'<tr><td>已核查数</td><td>'+data.f_telecom.field_66+'</td><td>'+data.f_mobile.field_66+'</td><td>'+data.f_unicom.field_66+'</td><td>'+data.f_railcom.field_66+'</td><td>'+(data.f_mobile.field_66+data.f_mobile.field_66+data.f_unicom.field_66+data.f_railcom.field_66)+'</td></tr>'+
	'<tr><td>已完成补登记数</td><td>'+data.f_telecom.field_67+'</td><td>'+data.f_mobile.field_67+'</td><td>'+data.f_unicom.field_67+'</td><td>'+data.f_railcom.field_67+'</td><td>'+(data.f_mobile.field_67+data.f_mobile.field_67+data.f_unicom.field_67+data.f_railcom.field_67)+'</td></tr>'+
	'<tr><td rowspan="3">社会渠道授权牌</td><td>应配发总数</td><td>'+data.f_telecom.field_68+'</td><td>'+data.f_mobile.field_68+'</td><td>'+data.f_unicom.field_68+'</td><td>'+data.f_railcom.field_68+'</td><td>'+(data.f_mobile.field_68+data.f_mobile.field_68+data.f_unicom.field_68+data.f_railcom.field_68)+'</td></tr>'+
	'<tr><td>本月新增数</td><td>'+data.f_telecom.field_69+'</td><td>'+data.f_mobile.field_69+'</td><td>'+data.f_unicom.field_69+'</td><td>'+data.f_railcom.field_69+'</td><td>'+(data.f_mobile.field_69+data.f_mobile.field_69+data.f_unicom.field_69+data.f_railcom.field_69)+'</td></tr>'+
	'<tr><td>未配发总数</td><td>'+data.f_telecom.field_70+'</td><td>'+data.f_mobile.field_70+'</td><td>'+data.f_unicom.field_70+'</td><td>'+data.f_railcom.field_70+'</td><td>'+(data.f_mobile.field_70+data.f_mobile.field_70+data.f_unicom.field_70+data.f_railcom.field_70)+'</td></tr>'+
	'<tr><td colspan="2">本月终止违规代理商数</td><td>'+data.f_telecom.field_71+'</td><td>'+data.f_mobile.field_71+'</td><td>'+data.f_unicom.field_71+'</td><td>'+data.f_railcom.field_71+'</td><td>'+(data.f_mobile.field_71+data.f_mobile.field_71+data.f_unicom.field_71+data.f_railcom.field_71)+'</td></tr>'+
	'<tr><td colspan="2">上报黑名单数</td><td>'+data.f_telecom.field_72+'</td><td>'+data.f_mobile.field_72+'</td><td>'+data.f_unicom.field_72+'</td><td>'+data.f_railcom.field_72+'</td><td>'+(data.f_mobile.field_72+data.f_mobile.field_72+data.f_unicom.field_72+data.f_railcom.field_72)+'</td></tr></tbody></table>';
	
    return tableContent;
}



