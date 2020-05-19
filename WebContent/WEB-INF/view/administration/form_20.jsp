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
<head>
<meta charset="utf-8" />
<jsp:include page="../common/head.jsp"></jsp:include>
</head>
<body
	class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
	<div class="page-wrapper">
		<jsp:include page="../common/top.jsp"></jsp:include>
		<div class="clearfix"></div>
		<div class="page-container">
			<jsp:include page="../common/left.jsp"></jsp:include>
			<div class="page-content-wrapper">
				<!-- BEGIN CONTENT BODY -->
				<div class="page-content">
					<div class="page-bar">
						<ul class="page-breadcrumb">
							<li>
								<h3 style="font-size: 16px; margin: 0; padding: 0;">物联网号段分配使用情况</h3>
							</li>
						</ul>
					</div>
					<div class="row">
						<div class="col-md-12" style="margin-top: 30px;">
						    <div id="containerCheckJobList" style="min-width: 310px; height:450px; margin: 20px auto;"></div>
						    
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="form-inline">
										<select class="form-control input-small" id="selectYear">
											<option value="">请选择</option>
											<option value="2016">2016</option>
											<option value="2017">2017</option>
											<option value="2018">2018</option>
											<option value="2019">2019</option>
											<option value="2020">2020</option>
											<option value="2021">2021</option>
											<option value="2022">2022</option>
											<option value="2023">2023</option>
											<option value="2024">2024</option>
											<option value="2025">2025</option>
											<option value="2026">2026</option>
											<option value="2027">2027</option>
										</select><span style="padding: 0 15px;">年</span>
										<button class="btn blue" id="searchData">查询</button>
									</div>
								</div>
								<div class="panel-body">
									<table class="table table-striped table-bordered table-advance table-hover">
										<thead>
											<tr>
												<td class="text-center">月份</td>
												<td class="text-center">单位</td>
												<td class="text-center">号段</td>
												<td class="text-center">总数（个）</td>
												<td class="text-center">已使用个数（个）</td>
												<td class="text-center">使用率</td>
											</tr>
										</thead>
										<tbody id="dataContent"></tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	<jsp:include page="../common/footerJs.jsp"></jsp:include>
	<script type="text/javascript" src="/assets/layer/layer.js"></script>
	<script src="/assets/global/plugins/highcharts/code/highcharts.js"></script>
    <script src="/assets/global/plugins/highcharts/code/modules/exporting.js"></script>
    <script src="/assets/global/plugins/highcharts/code/highcharts-zh_CN"></script>
    <script type="text/javascript" src="/assets/apps/administration/hightchats_json.js"></script>
	<script type="text/javascript" src="/assets/apps/administration/form_20.js"></script>
</body>
</html>