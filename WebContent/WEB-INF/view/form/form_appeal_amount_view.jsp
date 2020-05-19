<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link href="/assets/pages/css/form.css" rel="stylesheet" type="text/css" />
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
				<c:choose><c:when test="${empty effectiveAppealAmount}">
						<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单尚未被提交</span>
						</div>
					</c:when><c:otherwise>
				<p class="time">提交时间: <fmt:formatDate value="${reportLog.submitTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				<p class="time">审核状态：<c:choose><c:when test="${reportLog.auditStatus==0}">未审核&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/appeal_amount/edit/${reportLog.id}">编辑</a></c:if></c:when><c:when test="${reportLog.auditStatus==1}">已审核</c:when><c:otherwise>已退回<c:if test="${curUser.role.code=='USER'}">&nbsp;&nbsp;&nbsp;<a class="btn btn-sm green button-submit" href="/appeal_amount/edit/${reportLog.id}">&nbsp;&nbsp;&nbsp;重新编辑</a></c:if></c:otherwise></c:choose></p>
					<table class="entry-table table-bordered">
						<tr>
							<td class="text-center" colspan="2">项目</td>
							<td class="text-center">数值</td>
						</tr>
						<tr>
							<td class="text-center" colspan="2">受理总量</td>
							<td class="text-center">${effectiveAppealAmount.field_01}</td>
						</tr>
						<tr>
							<td class="text-center" colspan="2">有效申诉量</td>
							<td class="text-center">${effectiveAppealAmount.field_02}</td>
						</tr>
						<tr>
							<td class="text-center" colspan="2">剔除总数</td>
							<td class="text-center">${effectiveAppealAmount.field_03}</td>
						</tr>
						<tr>
							<td class="text-center" style="width:10%" rowspan="4">不符合工信部35号令第十条属于无效投诉的</td>
							<td class="text-left" style="width:10%">（一）申诉人是与申诉事项有直接利害关系的当事人</td>
							<td class="text-center" style="width:10%">${effectiveAppealAmount.field_04}</td>
						</tr>
						<tr>
							<td class="text-left">（二）有明确的被申诉人</td>
							<td class="text-center">${effectiveAppealAmount.field_05}</td>
						</tr>
						
						<tr>
							<td class="text-left">（三）有具体的申诉请求和事实根据</td>
							<td class="text-center">${effectiveAppealAmount.field_06}</td>
						</tr>
						<tr>
							<td class="text-left">（四）已经向被申诉人投诉且对其处理结果不满意或者其未在15日内答</td>
							<td class="text-center">${effectiveAppealAmount.field_07}</td>
						</tr>
						<tr>
							<td class="text-center" rowspan="5">属于工信部35号令第十一条情况不予受理的</td>
							<td class="text-left">（一）属于收费争议的申诉，申诉事项发生时距提起申诉时超过五个月的，其他申诉，申诉事项发生时距提起申诉时超过二年的；</td>
							<td class="text-center">${effectiveAppealAmount.field_08}</td>
						</tr>
						<tr>
							<td class="text-left">（二）申诉人与被申诉人已经达成和解协议并执行的；</td>
							<td class="text-center">${effectiveAppealAmount.field_09}</td>
						</tr>
						<tr>
							<td class="text-left">（三）申诉受理机构已经受理或者处理的；</td>
							<td class="text-center">${effectiveAppealAmount.field_10}</td>
						</tr>
						<tr>
							<td class="text-left">（四）人民法院、仲裁机构、消费者组织或者其他行政机关已经受理或者处理的；</td>
							<td class="text-center">${effectiveAppealAmount.field_11}</td>
						</tr>
						<tr>
							<td class="text-left">（五）国家法律、行政法规及部门规章另有规定的。</td>
							<td class="text-center">${effectiveAppealAmount.field_12}</td>
						</tr>
						<tr>
						    <td class="text-center">不符合工信部35号令第十二条缺少以下内容的</td>
							<td class="text-left">（一）申诉人姓名或名称、地址、电话号码、邮政编码；二）被申诉人名称、地址；（三）申诉要求、理由、事实根据；（四）申诉日期。</td>
							<td class="text-center">${effectiveAppealAmount.field_13}</td>
						</tr>
					</table>
						<table class="entry-table">
							<tr>
								<td>填表单位：${effectiveAppealAmount.company}</td>
								<td>填表人：${effectiveAppealAmount.userName}</td>
								<td>联系方式：${effectiveAppealAmount.mobile}</td>
								<td>电子邮箱：${effectiveAppealAmount.email}</td>
							</tr>
						</table>
						<p class="text-right">上海市通信管理局制表</p></c:otherwise></c:choose>
			</div>
		</div>
	</div>
</body>
</html>