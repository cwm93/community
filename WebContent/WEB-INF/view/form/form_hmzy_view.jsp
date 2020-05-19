<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
<meta charset="utf-8" />
<title>${reportLog.title}</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta
	content="Preview page of Metronic Admin Theme #1 for buttons extension demos"
	name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
	rel="stylesheet" type="text/css" />
<link
	href="/assets/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="/assets/global/plugins/simple-line-icons/simple-line-icons.min.css"
	rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<link href="/assets/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL STYLES -->
<link href="/assets/global/css/components.min.css" rel="stylesheet"
	id="style_components" type="text/css" />
<link href="/assets/global/css/plugins.min.css" rel="stylesheet"
	type="text/css" />
<!-- END THEME GLOBAL STYLES -->
<!-- BEGIN THEME LAYOUT STYLES -->
<link href="/assets/layouts/layout/css/custom.min.css" rel="stylesheet"
	type="text/css" />
<link href="/assets/pages/css/form.css" rel="stylesheet" type="text/css" />	
<!-- END THEME LAYOUT STYLES -->
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<!-- END HEAD -->

<body>
    <div class="container">
	<div class="row">
		<div class="col-md-12">
			<h1 class="top-title">
					上海市通信管理局<span>市场业务报表综合分析管理</span><a
						href="javascript:window.history.go(-1);"
						class="right btn btn-sm yellow"> 返回 <i class="fa fa-undo"></i>
					</a>
				</h1>
				<h5 class="form-title">${reportLog.title}</h5>
			    <c:choose><c:when test="${empty FHmzyList}">
						<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单尚未被提交</span>
						</div>
				</c:when><c:otherwise>
				<p class="time">提交时间: <fmt:formatDate value="${reportLog.submitTime}" pattern="yyyy-MM-dd HH:mm:ss"/>  </p>
				<p class="time">审核状态：<c:choose><c:when test="${reportLog.auditStatus==0}">未审核&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/hmzy/edit/${reportLog.id}">编辑</a></c:if></c:when><c:when test="${reportLog.auditStatus==1}">已审核</c:when><c:otherwise>已退回&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/hmzy/edit/${reportLog.id}">编辑</a></c:if></c:otherwise></c:choose></p>
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<td width="10%">局号数</td>
							<td width="10%">逻辑号码在用个数</td>
							<td width="10%">逻辑号码使用率</td>
							<td width="10%">物理号码已派个数</td>
							<td width="10%">物理号码使用率</td>
							<td width="10%">号码占用个数</td>
							<td width="10%">号码占用率</td>
						</tr>
					</thead>
					<tbody>
					    <c:choose><c:when test="${codeSum==0}">
					    <tr><td>0</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td></tr>
					    </c:when><c:otherwise><tr>
							<td>${codeSum}</td>
							<td>${logicUsegeNumber}</td>
							<td><fmt:formatNumber type="number" value="${logicUsegeNumber/(codeSum*10000)*100}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td>${physicsAssignedNumber}</td>
							<td><fmt:formatNumber type="number" value="${physicsAssignedNumber/(codeSum*10000)*100}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td>${occupiedNumber}</td>
							<td><fmt:formatNumber type="number" value="${occupiedNumber/(codeSum*10000)*100}" pattern="0.00" maxFractionDigits="2"/>%</td>
						</tr>
					    </c:otherwise></c:choose>
					</tbody>
				</table>
				<div class="portlet light bordered">
				<div class="portlet-title">
					<div class="tools"></div>
				</div>
				<div class="portlet-body">
					<table class="table table-striped table-bordered table-hover" id="sample_1">
						<thead>
							<tr>
								<th width="10%">局号</th>
								<th width="10%">区号</th>
								<th width="10%">逻辑号码在用个数</th>
								<th width="10%">逻辑号码使用率</th>
								<th width="10%">物理号码已派个数</th>
								<th width="10%">物理号码使用率</th>
								<th width="10%">号码占用个数</th>
								<th width="10%">号码占用率</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>局号</th>
								<th>区号</th>
								<th>逻辑号码在用个数</th>
								<th>逻辑号码在用个数</th>
								<th>物理号码已派个数</th>
								<th>物理号码使用率</th>
								<th>号码占用个数</th>
								<th>号码占用率</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${FHmzyList}" var="fHmzy" >
							<tr>
								
								<td>${fHmzy.code }</td>
								<td>${fHmzy.zoneCode }</td>
								<td>${fHmzy.logicUsegeNumber}</td>
								<td><fmt:formatNumber type="number" value="${fHmzy.logicUsegeNumber/10000*100}" pattern="0.00" maxFractionDigits="2"/>%</td>
								<td>${fHmzy.physicsAssignedNumber}</td>
								<td><fmt:formatNumber type="number" value="${fHmzy.physicsAssignedNumber/10000*100}" pattern="0.00" maxFractionDigits="2"/>%</td>
								<td>${fHmzy.occupiedNumber}</td>
								<td><fmt:formatNumber type="number" value="${fHmzy.occupiedNumber/10000*100}" pattern="0.00" maxFractionDigits="2"/>%</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- END EXAMPLE TABLE PORTLET-->
			</c:otherwise></c:choose>
		</div>
	</div>
</div>
	<!--[if lt IE 9]>
<script src="/assets/global/plugins/respond.min.js"></script>
<script src="/assets/global/plugins/excanvas.min.js"></script> 
<script src="/assets/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->
	<!-- BEGIN CORE PLUGINS -->
	<script src="/assets/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
		type="text/javascript"></script>
	<script src="/assets/global/scripts/datatable.js"
		type="text/javascript"></script>
	<script src="/assets/global/plugins/datatables/datatables.min.js"
		type="text/javascript"></script>
	<script
		src="/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js"
		type="text/javascript"></script>
	<script
		src="/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"
		type="text/javascript"></script>
	<script src="/assets/global/scripts/app.min.js" type="text/javascript"></script>
	<script src="/assets/pages/scripts/table-datatables-buttons.js"
		type="text/javascript"></script>
</body>

</html>