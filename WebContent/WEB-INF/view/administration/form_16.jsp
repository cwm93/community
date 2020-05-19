<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh-CN" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="zh-CN" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh-CN">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<jsp:include page="../common/head.jsp"></jsp:include>
</head>
<!-- END HEAD -->
<body
	class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
	<div class="page-wrapper">
		<jsp:include page="../common/top.jsp"></jsp:include>
		<!-- BEGIN HEADER & CONTENT DIVIDER -->
		<div class="clearfix"></div>
		<!-- END HEADER & CONTENT DIVIDER -->
		<!-- BEGIN CONTAINER -->
		<div class="page-container">
			<jsp:include page="../common/left.jsp"></jsp:include>
			<!-- BEGIN CONTENT -->
			<div class="page-content-wrapper">
				<!-- BEGIN CONTENT BODY -->
				<div class="page-content">
					<!-- BEGIN PAGE HEADER-->
					<!-- BEGIN PAGE BAR -->
					<div class="page-bar">
						<ul class="page-breadcrumb">
							<li>
								<h3 style="font-size: 16px; margin: 0; padding: 0;">码号统计</h3>
							</li>
						</ul>
					</div>
					<!-- END PAGE BAR -->
					<!-- END PAGE HEADER-->
					<div class="row">
						<div class="col-md-12" style="margin-top: 30px;">
						    <div id="containerMHFL" style="min-width: 310px; height:300px; margin: 20px auto"></div>
						  
						    <div class="actions" style="margin-bottom:8px;">
								<a href="/codeclass/add" class="btn btn-success mt-repeater-add"> <i
									class="fa fa-plus"></i> 码号系统数据导入
								</a> 
							</div>
							<table class="table table-striped table-bordered table-advance table-hover">
								<thead>
									<tr>
										<th style="width: 30%">行标签</th>
										<th style="width: 70%">计数项:短号码/短消息代码代码</th>
									</tr>
								</thead>
								<tbody id="data_tj"></tbody>
							</table>
							<div class="panel panel-default" style="margin-top: 30px;">
                            <div class="panel-heading form-inline">
									<select class="form-control input-xsmall" id="selectYear">
									    <option value="">请选择</option>
										<option value="2016">2016</option>
										<option value="2017">2017</option>
										<option value="2018" selected>2018</option>
										<option value="2019">2019</option>
										<option value="2020">2020</option>
										<option value="2021">2021</option>
										<option value="2022">2022</option>
										<option value="2023">2023</option>
											<option value="2024">2024</option>
											<option value="2025">2025</option>
											<option value="2026">2026</option>
											<option value="2027">2027</option>
									</select><span style="padding: 0 15px;">年</span><select
										class="form-control input-xsmall" id="selectMonth">
										<option value="">请选择</option>
										<option value="1">01</option>
										<option value="2">02</option>
										<option value="3">03</option>
										<option value="4">04</option>
										<option value="5">05</option>
										<option value="6" selected>06</option>
										<option value="7">07</option>
										<option value="8">08</option>
										<option value="9">09</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
									</select> <span style="padding: 0 15px;">月</span>
									<button class="btn blue" id="searchData">查询</button>
								</div>
                            <div class="panel-body" id="dataContent">
							
							</div>
						   </div>
						</div>
					</div>
				</div>
				<!-- END CONTENT BODY -->
			</div>
			<!-- END CONTENT -->
		</div>
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	<jsp:include page="../common/footerJs.jsp"></jsp:include>
	<script src="/assets/global/scripts/datatable.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
	<script type="text/javascript" src="/assets/layer/layer.js"></script>
	<script src="/assets/global/plugins/highcharts/code/highcharts.js"></script>
    <script src="/assets/global/plugins/highcharts/code/modules/exporting.js"></script>
    <script src="/assets/global/plugins/highcharts/code/highcharts-zh_CN"></script>
	<script type="text/javascript" src="/assets/apps/administration/form_16.js?version=20190822"></script>
</body>
</html>