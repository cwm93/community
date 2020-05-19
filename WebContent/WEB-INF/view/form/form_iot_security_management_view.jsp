<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh-CN" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="zh-CN" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh-CN">
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<title>上海市通信管理局-市场业务报表综合分析管理</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="上海市通信管理局-市场业务报表综合分析管理" name="description" />
<meta content="上海市通信管理局-市场业务报表综合分析管理" name="author" />
<link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
<link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/pages/css/form.css?20190612" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="top-title">
					上海市通信管理局<span>市场业务报表综合分析管理</span><a
						href="javascript:window.history.go(-1);"
						class="right btn btn-sm yellow"> 返回 <i class="fa fa-undo"></i>
					</a>
				</h1>
				<h5 class="form-title">${reportLog.title}</h5>
				<c:choose><c:when test="${empty fIOTSecurityManagement}">
						<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单尚未被提交</span>
						</div>
				</c:when><c:otherwise>
				<p class="time">提交时间: <fmt:formatDate value="${reportLog.submitTime}" pattern="yyyy-MM-dd HH:mm:ss"/>  </p>
				<p class="time">审核状态：<c:choose><c:when test="${reportLog.auditStatus==0}">未审核&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/iot_management/edit/${reportLog.id}">编辑</a></c:if></c:when><c:when test="${reportLog.auditStatus==1}">已审核</c:when><c:otherwise>已退回&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/iot_management/edit/${reportLog.id}">编辑</a></c:if></c:otherwise></c:choose></p>
					<table class="entry-table table-bordered">
					    <thead>
						<tr>
							<th class="text-center" width="5%">分类</th>
							<th class="text-center" width="5%" >序号</th>
							<th class="text-center" width="10%">统计内容</th>
							<th class="text-center" width="5%">统计单位</th>
							<th class="text-center" width="10%">数值</th>
							<th class="text-center" width="10%">备注</th>
						</tr></thead>
						<tr>
							<td class="text-center" rowspan="5">实名登记情况</td>
							<td class="text-center" >1</td>
							<td class="text-center">本月新增物联网行业卡</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_11}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >2</td>
							<td class="text-center">累计发展物联网行业卡</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_12}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >3</td>
							<td class="text-center">登记到责任单位和责任人</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_13}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >4</td>
							<td class="text-center">登记到实际使用人</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_14}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >5</td>
							<td class="text-center">物联网行业卡用户实名登记率</td>
							<td class="text-center">百分比（%）</td>
							<td class="text-center">${fIOTSecurityManagement.field_15}%</td>
							<td class="text-center">实名登记率=(登记到责任单位和责任人号卡数+登记到实际使用人号卡数)/累计发展物联网行业卡号卡数</td>
						</tr>
						<tr>
							<td class="text-center" rowspan="9">按功能限制分类统计</td>
							<td class="text-center" >6</td>
							<td class="text-center">执行“功能最小化”业务限制</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_21}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >7</td>
							<td class="text-center">短信和语音均默认关闭</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_22}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >8</td>
							<td class="text-center">机卡关联绑定</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_23}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">9</td>
							<td class="text-center" rowspan="2">开通非定向语音</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center">${fIOTSecurityManagement.field_24}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_242}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">10</td>
							<td class="text-center" rowspan="2">开通非定向短信</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center">${fIOTSecurityManagement.field_25}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_252}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">11</td>
							<td class="text-center" rowspan="2">开通非定向上网/流量</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center">${fIOTSecurityManagement.field_26}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_262}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="12">按业务场景分类统计</td>
							<td class="text-center" rowspan="2">12</td>
							<td class="text-center" rowspan="2">公共事业</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center">${fIOTSecurityManagement.field_31}</td>
							<td class="text-center">如市政设施管理、智能抄表、智慧停车、安防监控等</td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_312}</td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">13</td>
							<td class="text-center" rowspan="2">零售服务</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center">${fIOTSecurityManagement.field_32}</td>
							<td class="text-center">如无线POS机、自动售货机、照片打印机等</td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_322}</td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">14</td>
							<td class="text-center" rowspan="2">车联网</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center">${fIOTSecurityManagement.field_33}</td>
							<td class="text-center">如智能后视镜、T-BOX、导航监控等</td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_332}</td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">15</td>
							<td class="text-center" rowspan="2">能源管理</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center">${fIOTSecurityManagement.field_34}</td>
							<td class="text-center" rowspan="2">如充电桩、空调监控、蓄电池监控等</td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_342}</td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">16</td>
							<td class="text-center" rowspan="2">工业物联网</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center">${fIOTSecurityManagement.field_35}</td>
							<td class="text-center" rowspan="2">如工业自动化生产线、阀门设施监控</td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_352}</td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">17</td>
							<td class="text-center" rowspan="2">其他场景</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center">${fIOTSecurityManagement.field_36}</td>
							<td class="text-center" rowspan="2">如智慧家庭、智慧医疗、智慧物流等其他场景</td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_362}</td>
						</tr>
						<tr>
							<td class="text-center" rowspan="7">监测与管控</td>
							<td class="text-center" >18</td>
							<td class="text-center">合同回头看终止客户数</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center">${fIOTSecurityManagement.field_41}</td>
							<td class="text-center">因合同不规范、缺少关键约定内容而终止的合约</td>
						</tr>
						<tr>
							<td class="text-center" >19</td>
							<td class="text-center">本月使用流量大于100MB号卡数</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_42}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >20</td>
							<td class="text-center">本月监测异常号卡数</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_43}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >21</td>
							<td class="text-center">本月关停号卡数</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_44}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >22</td>
							<td class="text-center">本年累计关停号卡数</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_45}</td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >23</td>
							<td class="text-center">本年累计被通报违规号卡数</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_46}</td>
							<td class="text-center">工信部和各企业集团公司通报的违规号卡数量</td>
						</tr>
						<tr>
							<td class="text-center" >24</td>
							<td class="text-center">本年累计处罚人员</td>
							<td class="text-center">人员数（个）</td>
							<td class="text-center">${fIOTSecurityManagement.field_47}</td>
							<td class="text-center"></td>
						</tr>
					</table>
					<h5>按号段分类统计（全量统计，含未定向分配号段数）</h5>
					<table class="entry-table table-bordered">
						<thead><tr><th>专用/公用号段</th><th>11位/13位号段</th><th>号段明细</th><th>总数（个）</th><th>已使用个数（个）</th><th>未使用个数（个）</th></tr></thead>
						<tbody id="trlist">
						<c:forEach items="${iotSecurityManagementSegmentList}" var="iotSecurityManagementSegment" varStatus="status">
						<tr>
						<td><c:choose><c:when test="${iotSecurityManagementSegment.type eq '1'}">专用</c:when><c:otherwise>公用</c:otherwise></c:choose></td>
						<td><c:choose><c:when test="${iotSecurityManagementSegment.digitType eq '11'}">11位</c:when><c:otherwise>13位</c:otherwise></c:choose></td>
						<td>${iotSecurityManagementSegment.hdmx}</td>
						<td>${iotSecurityManagementSegment.amount}</td>
						<td>${iotSecurityManagementSegment.usedAmount}</td>
						<td>${iotSecurityManagementSegment.unusedAmount}</td>
						</tr></c:forEach></tbody>
					</table>
					<table class="entry-table">
						<tr>
							<td>填表公司：${fIOTSecurityManagement.company}</td>
							<td>填表人：${fIOTSecurityManagement.userName}</td>
							<td>联系方式：${fIOTSecurityManagement.mobile}</td>
							<td>电子邮箱： ${fIOTSecurityManagement.email}</td>
						</tr>
					</table>
					<p class="text-right">上海市通信管理局制表</p>
				</c:otherwise></c:choose>
			</div>
		</div>
	</div>
</body>
</html>