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
		url : "/summary/iOTSecurityManagementJson",
		data : {
			reportId : reportId,
			loadingYear : loadingYear,
			loadingMonth : loadingMonth
		},
		dataType : "json",
		success : function(data) {
			if (data.code == 0) {
				layer.closeAll();
				if (data.reportLogList!=null) {
					layer.msg('数据加载成功');
					dataContent="<table class='table table-bordered'><tr><td>报表名称</td><td>填表人</td><td>状态</td><td>审核状态</td></tr>";
					$.each(data.reportLogList,function(index,reportLog){
						dataContent = dataContent + "<tr>"+"<td><a href='/iot_management/view/"+reportLog.id+"' tagert='_blank'>"+reportLog.title+"</a></td>"+"<td>"+reportLog.toUser.realname+"</td>";
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
						dataContent = dataContent +'<table class="table table-bordered"><tr><td colspan="9" style="text-align: center;">治理垃圾短信息情况月报表（统计数据截止至'+loadingYear+'年'+loadingMonth+'月底）</td></tr>'
						+'<tr><td class="text-center" width="10%">分类</td><td class="text-center" width="10%">序号</td><td class="text-center" width="10%">统计内容</td><td class="text-center" width="10%">统计单位</td><td class="text-center" width="10%">行业合计</td><td class="text-center" width="10%">上海电信</td><td class="text-center" width="10%">上海移动</td><td class="text-center" width="10%">上海联通</td><td class="text-center" width="10%">备注</td></tr>'
						+'<tr><td class="text-center" rowspan="5">实名登记情况</td><td class="text-center" >1</td><td class="text-center">本月新增物联网行业卡</td><td class="text-center">号卡数（个）</td><td class="text-center">'+(data.f_telecom.field_11+data.f_mobile.field_11+data.f_unicom.field_11)+'</td><td class="text-center">'+data.f_telecom.field_12+'</td><td class="text-center">'+data.f_mobile.field_11+'</td><td class="text-center">'+data.f_unicom.field_11+'</td><td class="text-center"></td></tr>'
						+'<tr><td class="text-center" >2</td>'
						+'<td class="text-center">累计发展物联网行业卡</td>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_12+data.f_mobile.field_12+data.f_unicom.field_12)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_12+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_12+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_12+'</td>'
						+'<td class="text-center"></td></tr>'
						+'<tr>'
						+'<td class="text-center" >3</td>'
						+'<td class="text-center">登记到责任单位和责任人</td>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_13+data.f_mobile.field_13+data.f_unicom.field_13)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_13+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_13+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_13+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" >4</td>'
						+'<td class="text-center">登记到实际使用人</td>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_14+data.f_mobile.field_14+data.f_unicom.field_14)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_14+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_14+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_14+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" >5</td>'
						+'<td class="text-center">物联网行业卡用户实名登记率</td>'
						+'<td class="text-center">百分比（%）</td>'
						+'<td class="text-center">'+((Number(data.f_telecom.field_15)+Number(data.f_mobile.field_15)+Number(data.f_unicom.field_15))/3).toFixed(2)+'%</td>'
						+'<td class="text-center">'+data.f_telecom.field_15+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_15+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_15+'</td>'
						+'<td class="text-center">实名登记率=(登记到责任单位和责任人号卡数+登记到实际使用人号卡数)/累计发展物联网行业卡号卡数</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" rowspan="9">按功能限制分类统计</td>'
						+'<td class="text-center" >6</td>'
						+'<td class="text-center">执行“功能最小化”业务限制</td>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_21+data.f_mobile.field_21+data.f_unicom.field_21)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_21+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_21+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_21+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" >7</td>'
						+'<td class="text-center">短信和语音均默认关闭</td>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_22+data.f_mobile.field_22+data.f_unicom.field_22)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_22+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_22+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_22+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" >8</td>'
						+'<td class="text-center">机卡关联绑定</td>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_23+data.f_mobile.field_23+data.f_unicom.field_23)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_23+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_23+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_23+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" rowspan="2">9</td>'
						+'<td class="text-center" rowspan="2">开通非定向语音</td>'
						+'<td class="text-center">客户数（家）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_24+data.f_mobile.field_24+data.f_unicom.field_24)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_24+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_24+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_24+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_242+data.f_mobile.field_242+data.f_unicom.field_242)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_242+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_242+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_242+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" rowspan="2">10</td>'
						+'<td class="text-center" rowspan="2">开通非定向短信</td>'
						+'<td class="text-center">客户数（家）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_25+data.f_mobile.field_25+data.f_unicom.field_25)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_25+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_25+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_25+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_252+data.f_mobile.field_252+data.f_unicom.field_252)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_252+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_252+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_252+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" rowspan="2">11</td>'
						+'<td class="text-center" rowspan="2">开通非定向上网/流量</td>'
						+'<td class="text-center">客户数（家）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_26+data.f_mobile.field_26+data.f_unicom.field_26)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_26+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_26+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_26+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_262+data.f_mobile.field_262+data.f_unicom.field_262)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_262+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_262+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_262+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" rowspan="12">按业务场景分类统计</td>'
						+'<td class="text-center" rowspan="2">12</td>'
						+'<td class="text-center" rowspan="2">公共事业</td>'
						+'<td class="text-center">客户数（家）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_31+data.f_mobile.field_31+data.f_unicom.field_31)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_31+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_31+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_31+'</td>'
						+'<td class="text-center">如市政设施管理、智能抄表、智慧停车、安防监控等</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_312+data.f_mobile.field_312+data.f_unicom.field_312)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_312+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_312+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_312+'</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" rowspan="2">13</td>'
						+'<td class="text-center" rowspan="2">零售服务</td>'
						+'<td class="text-center">客户数（家）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_32+data.f_mobile.field_32+data.f_unicom.field_32)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_32+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_32+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_32+'</td>'
						+'<td class="text-center">如无线POS机、自动售货机、照片打印机等</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_322+data.f_mobile.field_322+data.f_unicom.field_322)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_322+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_322+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_322+'</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" rowspan="2">14</td>'
						+'<td class="text-center" rowspan="2">车联网</td>'
						+'<td class="text-center">客户数（家）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_33+data.f_mobile.field_33+data.f_unicom.field_33)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_33+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_33+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_33+'</td>'
						+'<td class="text-center">如智能后视镜、T-BOX、导航监控等</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_332+data.f_mobile.field_332+data.f_unicom.field_332)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_332+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_332+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_332+'</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" rowspan="2">15</td>'
						+'<td class="text-center" rowspan="2">能源管理</td>'
						+'<td class="text-center">客户数（家）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_34+data.f_mobile.field_34+data.f_unicom.field_34)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_34+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_34+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_34+'</td>'
						+'<td class="text-center" rowspan="2">如充电桩、空调监控、蓄电池监控等</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_342+data.f_mobile.field_342+data.f_unicom.field_342)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_342+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_342+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_342+'</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" rowspan="2">16</td>'
						+'<td class="text-center" rowspan="2">工业物联网</td>'
						+'<td class="text-center">客户数（家）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_35+data.f_mobile.field_35+data.f_unicom.field_35)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_35+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_35+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_35+'</td>'
						+'<td class="text-center" rowspan="2">如工业自动化生产线、阀门设施监控</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_352+data.f_mobile.field_352+data.f_unicom.field_352)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_352+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_352+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_352+'</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" rowspan="2">17</td>'
						+'<td class="text-center" rowspan="2">其他场景</td>'
						+'<td class="text-center">客户数（家）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_36+data.f_mobile.field_36+data.f_unicom.field_36)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_36+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_36+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_36+'</td>'
						+'<td class="text-center" rowspan="2">如智慧家庭、智慧医疗、智慧物流等其他场景</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_362+data.f_mobile.field_362+data.f_unicom.field_362)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_362+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_362+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_362+'</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" rowspan="7">监测与管控</td>'
						+'<td class="text-center" >18</td>'
						+'<td class="text-center">合同回头看终止客户数</td>'
						+'<td class="text-center">客户数（家）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_41+data.f_mobile.field_41+data.f_unicom.field_41)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_41+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_41+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_41+'</td>'
						+'<td class="text-center">因合同不规范、缺少关键约定内容而终止的合约</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" >19</td>'
						+'<td class="text-center">本月使用流量大于100MB号卡数</td>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_41+data.f_mobile.field_42+data.f_unicom.field_42)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_42+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_42+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_42+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" >20</td>'
						+'<td class="text-center">本月监测异常号卡数</td>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_43+data.f_mobile.field_43+data.f_unicom.field_43)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_43+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_43+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_43+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" >21</td>'
						+'<td class="text-center">本月关停号卡数</td>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_44+data.f_mobile.field_44+data.f_unicom.field_44)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_44+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_44+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_44+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" >22</td>'
						+'<td class="text-center">本年累计关停号卡数</td>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_45+data.f_mobile.field_45+data.f_unicom.field_45)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_45+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_45+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_45+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" >23</td>'
						+'<td class="text-center">本年累计被通报违规号卡数</td>'
						+'<td class="text-center">号卡数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_46+data.f_mobile.field_46+data.f_unicom.field_46)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_46+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_46+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_46+'</td>'
						+'<td class="text-center">工信部和各企业集团公司通报的违规号卡数量</td>'
						+'</tr>'
						+'<tr>'
						+'<td class="text-center" >24</td>'
						+'<td class="text-center">本年累计处罚人员</td>'
						+'<td class="text-center">人员数（个）</td>'
						+'<td class="text-center">'+(data.f_telecom.field_47+data.f_mobile.field_47+data.f_unicom.field_47)+'</td>'
						+'<td class="text-center">'+data.f_telecom.field_47+'</td>'
						+'<td class="text-center">'+data.f_mobile.field_47+'</td>'
						+'<td class="text-center">'+data.f_unicom.field_47+'</td>'
						+'<td class="text-center"></td>'
						+'</tr>'
						+'</table>';
					var hy_1 = data.sumarr[0]+data.sumarr[8]+data.sumarr[16];
					var hy_2 = data.sumarr[1]+data.sumarr[9]+data.sumarr[17];
					var hy_3 = data.sumarr[2]+data.sumarr[10]+data.sumarr[18];
					var hy_4 = data.sumarr[3]+data.sumarr[11]+data.sumarr[19];
					var hy_5 = data.sumarr[4]+data.sumarr[12]+data.sumarr[20];
					var hy_6 = data.sumarr[5]+data.sumarr[13]+data.sumarr[21];
					var hy_7 = data.sumarr[6]+data.sumarr[14]+data.sumarr[22];
					var hy_8 = data.sumarr[7]+data.sumarr[15]+data.sumarr[23];
					var hy_11 = hy_1+hy_3+hy_5+hy_7;
					var hy_12 = hy_2+hy_4+hy_6+hy_8;
					
					var dx_1 = 	data.sumarr[0]+data.sumarr[2]+data.sumarr[4]+data.sumarr[6];
					var dx_2 =  data.sumarr[1]+data.sumarr[3]+data.sumarr[5]+data.sumarr[7];
					var yd_1 = 	data.sumarr[8]+data.sumarr[10]+data.sumarr[12]+data.sumarr[14];
					var yd_2 =  data.sumarr[9]+data.sumarr[11]+data.sumarr[13]+data.sumarr[15];
					var lt_1 = 	data.sumarr[16]+data.sumarr[18]+data.sumarr[20]+data.sumarr[22];
					var lt_2 =  data.sumarr[17]+data.sumarr[19]+data.sumarr[21]+data.sumarr[23];
					
					
					dataContent = dataContent +'<table class="table table-bordered"><tr><td colspan="6" style="text-align: center;">按号段分类统计（全量统计，含未定向分配号段数）</td></tr>'
					+'<tr>'
					+'<td class="text-center" >运营商</td>'
					+'<td class="text-center" colspan="2">号段</td>'
					+'<td class="text-center">总数（个）</td>'
					+'<td class="text-center">已使用数（个）</td>'
					+'<td class="text-center">使用率</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center" rowspan="5">行业统计</td>'
					+'<td class="text-center" rowspan="2">专用</td>'
					+'<td class="text-center">11位</td>'
					+'<td class="text-center">'+hy_1+'</td>'
					+'<td class="text-center">'+hy_2+'</td>'
					+'<td class="text-center">'+GetPercent(hy_2,hy_1)+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center">13位</td>'
					+'<td class="text-center">'+hy_3+'</td>'
					+'<td class="text-center">'+hy_4+'</td>'
					+'<td class="text-center">'+GetPercent(hy_4,hy_3)+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center" rowspan="2">公众</td>'
					+'<td class="text-center">11位</td>'
					+'<td class="text-center">'+hy_5+'</td>'
					+'<td class="text-center">'+hy_6+'</td>'
					+'<td class="text-center">'+GetPercent(hy_6,hy_5)+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center">13位</td>'
					+'<td class="text-center">'+hy_7+'</td>'
					+'<td class="text-center">'+hy_8+'</td>'
					+'<td class="text-center">'+GetPercent(hy_8,hy_7)+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center" colspan="2">合计</td>'
					+'<td class="text-center">'+hy_11+'</td>'
					+'<td class="text-center">'+hy_12+'</td>'
					+'<td class="text-center">'+GetPercent(hy_12,hy_11)+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center" rowspan="5">上海电信</td>'
					+'<td class="text-center" rowspan="2">专用</td>'
					+'<td class="text-center">11位</td>'
					+'<td class="text-center">'+data.sumarr[0]+'</td>'
					+'<td class="text-center">'+data.sumarr[1]+'</td>'
					+'<td class="text-center">'+GetPercent(data.sumarr[0],data.sumarr[1])+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center">13位</td>'
					+'<td class="text-center">'+data.sumarr[2]+'</td>'
					+'<td class="text-center">'+data.sumarr[3]+'</td>'
					+'<td class="text-center">'+GetPercent(data.sumarr[3],data.sumarr[2])+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center" rowspan="2">公众</td>'
					+'<td class="text-center">11位</td>'
					+'<td class="text-center">'+data.sumarr[4]+'</td>'
					+'<td class="text-center">'+data.sumarr[5]+'</td>'
					+'<td class="text-center">'+GetPercent(data.sumarr[5],data.sumarr[4])+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center">13位</td>'
					+'<td class="text-center">'+data.sumarr[6]+'</td>'
					+'<td class="text-center">'+data.sumarr[7]+'</td>'
					+'<td class="text-center">'+GetPercent(data.sumarr[7],data.sumarr[6])+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center" colspan="2">合计</td>'
					+'<td class="text-center">'+dx_1+'</td>'
					+'<td class="text-center">'+dx_2+'</td>'
					+'<td class="text-center">'+GetPercent(dx_1,dx_2)+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center" rowspan="5">上海移动</td>'
					+'<td class="text-center" rowspan="2">专用</td>'
					+'<td class="text-center">11位</td>'
					+'<td class="text-center">'+data.sumarr[8]+'</td>'
					+'<td class="text-center">'+data.sumarr[9]+'</td>'
					+'<td class="text-center">'+GetPercent(data.sumarr[9],data.sumarr[8])+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center">13位</td>'
					+'<td class="text-center">'+data.sumarr[10]+'</td>'
					+'<td class="text-center">'+data.sumarr[11]+'</td>'
					+'<td class="text-center">'+GetPercent(data.sumarr[11],data.sumarr[10])+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center" rowspan="2">公众</td>'
					+'<td class="text-center">11位</td>'
					+'<td class="text-center">'+data.sumarr[12]+'</td>'
					+'<td class="text-center">'+data.sumarr[13]+'</td>'
					+'<td class="text-center">'+GetPercent(data.sumarr[12],data.sumarr[13])+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center">13位</td>'
					+'<td class="text-center">'+data.sumarr[14]+'</td>'
					+'<td class="text-center">'+data.sumarr[15]+'</td>'
					+'<td class="text-center">'+GetPercent(data.sumarr[15],data.sumarr[14])+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center" colspan="2">合计</td>'
					+'<td class="text-center">'+yd_1+'</td>'
					+'<td class="text-center">'+yd_2+'</td>'
					+'<td class="text-center">'+GetPercent(yd_2,yd_1)+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center" rowspan="5">上海联通</td>'
					+'<td class="text-center" rowspan="2">专用</td>'
					+'<td class="text-center">11位</td>'
					+'<td class="text-center">'+data.sumarr[16]+'</td>'
					+'<td class="text-center">'+data.sumarr[17]+'</td>'
					+'<td class="text-center">'+GetPercent(data.sumarr[17],data.sumarr[16])+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center">13位</td>'
					+'<td class="text-center">'+data.sumarr[18]+'</td>'
					+'<td class="text-center">'+data.sumarr[19]+'</td>'
					+'<td class="text-center">'+GetPercent(data.sumarr[19],data.sumarr[18])+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center" rowspan="2">公众</td>'
					+'<td class="text-center">11位</td>'
					+'<td class="text-center">'+data.sumarr[20]+'</td>'
					+'<td class="text-center">'+data.sumarr[21]+'</td>'
					+'<td class="text-center">'+GetPercent(data.sumarr[21],data.sumarr[20])+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center">13位</td>'
					+'<td class="text-center">'+data.sumarr[22]+'</td>'
					+'<td class="text-center">'+data.sumarr[23]+'</td>'
					+'<td class="text-center">'+GetPercent(data.sumarr[23],data.sumarr[22])+'</td>'
					+'</tr>'
					+'<tr>'
					+'<td class="text-center" colspan="2">合计</td>'
					+'<td class="text-center">'+lt_1+'</td>'
					+'<td class="text-center">'+lt_2+'</td>'
					+'<td class="text-center">'+GetPercent(lt_2,lt_1)+'</td>'
					+'</tr>'
					+'</table>';
						
						
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
function GetPercent(num, total) {
    /// <summary>
    /// 求百分比
    /// </summary>
    /// <param name="num">当前数</param>
    /// <param name="total">总数</param>
    num = parseFloat(num);
    total = parseFloat(total);
    if (isNaN(num) || isNaN(total)) {
        return "-";
    }
    return total <= 0 ? "0%" : (Math.round(num / total * 10000) / 100.00)+"%";
}

