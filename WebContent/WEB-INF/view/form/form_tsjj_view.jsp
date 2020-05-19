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
				<c:choose><c:when test="${empty fPriceSpeed}">
						<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单尚未被提交</span>
						</div>
					</c:when><c:otherwise>
				<p class="time">提交时间: <fmt:formatDate value="${reportLog.submitTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				<p class="time">审核状态：<c:choose><c:when test="${reportLog.auditStatus==0}">未审核&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/tsjj/edit/${reportLog.id}">编辑</a></c:if></c:when><c:when test="${reportLog.auditStatus==1}">已审核</c:when><c:otherwise>已退回<c:if test="${curUser.role.code=='USER'}">&nbsp;&nbsp;&nbsp;<a class="btn btn-sm green button-submit" href="/tsjj/edit/${reportLog.id}">&nbsp;&nbsp;&nbsp;重新编辑</a></c:if></c:otherwise></c:choose></p>
				<div class="entry-form entry-form-bordered">
					<table class="entry-table table-bordered" style="width:780px;margin:0 auto;">
						<tr>
							<td class="text-center" width="15%">项目</td>
							<td width="40%" class="text-center">项目</td>
							<td width="45%" class="text-center">填入项</td>
						</tr>
						<tr>
							<td rowspan="6">固定宽带单位带宽平均资费（元/MB）</td>
							<td class="text-center">${reportLog.writeYear-1}年12月底</td>
							<td class="text-left">${fPriceSpeed.field_01}</td>
						</tr>
						<tr>
							<td class="text-center">${reportLog.writeYear}年${reportLog.writeMonth}月底</td>
							<td class="text-left">${fPriceSpeed.field_02}</td>
						</tr>
						<tr>
							<td class="text-center">预计${fPriceSpeed.thisYear}年12月底</td>
							<td class="text-left">${fPriceSpeed.field_03}</td>
						</tr>
						<tr>
							<td class="text-center">集团年度目标</td>
							<td class="text-left">${fPriceSpeed.field_04}</td>
						</tr>
						<tr>
							<td class="text-center">已完成目标</td>
							<td class="text-left">${fPriceSpeed.field_05}</td>
						</tr>
						<tr>
							<td class="text-center">预计完成目标</td>
							<td class="text-left">${fPriceSpeed.field_06}</td>
						</tr>
						<tr>
							<td rowspan="6">手机流量平均资费（元/GB）</td>
							<td class="text-center">${reportLog.writeYear-1}年12月底</td>
							<td class="text-left">${fPriceSpeed.field_07}</td>
						</tr>
						<tr>
							<td class="text-center">${reportLog.writeYear}年${reportLog.writeMonth}月底</td>
							<td class="text-left">${fPriceSpeed.field_08}</td>
						</tr>
						<tr>
							<td class="text-center">预计${reportLog.writeYear}年12月底</td>
							<td class="text-left">${fPriceSpeed.field_09}</td>
						</tr>
						<tr>
							<td class="text-center">集团年度目标</td>
							<td class="text-left">${fPriceSpeed.field_10}"</td>
						</tr>
						<tr>
							<td class="text-center">已完成目标</td>
							<td class="text-left">${fPriceSpeed.field_11}</td>
						</tr>
						<tr>
							<td class="text-center">预计完成目标</td>
							<td class="text-left">${fPriceSpeed.field_12}</td>
						</tr>
						<tr>
							<td rowspan="3">降费举措</td>
							<td class="text-center">固定宽带方面</td>
							<td class="text-left">${fPriceSpeed.field_13}</td>
						</tr>
						<tr>
							<td class="text-center">手机流量方面</td>
							<td class="text-left">${fPriceSpeed.field_14}</td>
						</tr>
						<tr>
							<td class="text-center">宣传方面</td>
							<td class="text-left">${fPriceSpeed.field_15}</td>
						</tr>
					</table>
					<table class="entry-table">
						<tr>
							<td>填表公司：${fPriceSpeed.company}</td>
							<td>填表人：${fPriceSpeed.userName}</td>
							<td>联系方式：${fPriceSpeed.mobile}</td>
							<td>电子邮箱：${fPriceSpeed.email} </td>
						</tr>
					</table>
					<p class="text-right">上海市通信管理局制表</p>
				</div>
				</c:otherwise></c:choose>
			</div>
		</div>
	</div>
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/jquery-validation/js/localization/messages_zh.js" type="text/javascript"></script>
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script src="/assets/apps/scripts/tsjj.form.js" type="text/javascript"></script>
</body>
</html>