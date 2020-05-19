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
								<h3 style="font-size: 16px; margin: 0; padding: 0;">百万用户申诉率</h3>
							</li>
						</ul>
					</div>
					<!-- END PAGE BAR -->
					<!-- END PAGE HEADER-->
					<div class="row">
						<div class="col-md-12" style="margin-top: 30px;">
						    <div id="containerSSL" style="min-width: 310px; height:450px; margin: 20px auto"></div>
						    
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="actions" style="margin-bottom: 8px;">
										<a class="btn btn-success mt-repeater-add" href="#add-form"
											data-toggle="modal"> <i class="fa fa-plus"></i> 添加数据
										</a>
									</div>
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
												<td class="text-center" rowspan="2">月份</td>
												<td class="text-center" rowspan="2">单位</td>
												<td class="text-center" colspan="3">百万用户申诉率</td>
												<td class="text-center" colspan="3">不明扣费申诉率</td>
											</tr>
											<tr>
												<td>总受理量(件)</td>
												<td>用户总数（万）</td>
												<td>百万用户申诉率（人次/百万用户）</td>
												<td>总受理量(件)</td>
												<td>用户总数（万）</td>
												<td>百万用户申诉率（人次/百万用户）</td>
											</tr>
										</thead>
										<tbody id="dataContent"></tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- END CONTENT BODY -->
			</div>
			<!-- END CONTENT -->
		</div>
		<!-- END CONTAINER -->
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	<div class="modal fade" id="add-form" role="basic" aria-hidden="true"
		style="font-size: 12px;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title">百万用户申诉率</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" name="form1" id="form1" role="form">
						<div class="form-group">
							<label for="year" class="col-sm-4 control-label">月份</label>
							<div class="col-sm-8 form-inline">
								<select class="form-control input-xsmall" name="year" id="year">
									<option value="">年份</option>
									<option value="2016">2016</option>
									<option value="2017" selected>2017</option>
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
								</select><span style="padding: 0 15px;">年</span><select
									class="form-control input-xsmall" name="month" id="month">
									<option value="">月份</option>
									<option value="1">01</option>
									<option value="2">02</option>
									<option value="3">03</option>
									<option value="4">04</option>
									<option value="5">05</option>
									<option value="6">06</option>
									<option value="7">07</option>
									<option value="8">08</option>
									<option value="9">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select> <span style="padding: 0 15px;">月</span>
							</div>
						</div>
						<div class="form-group" style="border-bottom: 1px solid #f0f0f0; font-size: 16px;">
							<label class="col-sm-4 control-label">电信</label>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">百万用户申诉率--总受理量(件)</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_11" id="field_11">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">百万用户申诉率--用户总数（万）</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_12" id="field_12" >
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">百万用户申诉率--百万用户申诉率（人次/百万用户）</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_13" id="field_13">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">不明扣费申诉率／总受理量(件)</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_14" id="field_14">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">不明扣费申诉率／用户总数（万）</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_15" id="field_15" >
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">不明扣费申诉率／百万用户申诉率（人次/百万用户）</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_16" id="field_16">
							</div>
						</div>
						<div class="form-group" style="border-bottom: 1px solid #f0f0f0; font-size: 16px;">
							<label class="col-sm-4 control-label">移动</label>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">百万用户申诉率／总受理量(件)</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_21" id="field_21">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">百万用户申诉率／用户总数（万）</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_22" id="field_22" >
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">百万用户申诉率／百万用户申诉率（人次/百万用户）</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_23" id="field_23">
							</div>
						</div><div class="form-group">
							<label class="col-sm-4 control-label">不明扣费申诉率／总受理量(件)</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_24" id="field_24">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">不明扣费申诉率／用户总数（万）</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_25" id="field_25" >
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">不明扣费申诉率／百万用户申诉率（人次/百万用户）</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_26" id="field_26">
							</div>
						</div>
						<div class="form-group" style="border-bottom: 1px solid #f0f0f0; font-size: 16px;">
							<label class="col-sm-4 control-label">联通</label>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">百万用户申诉率--总受理量(件)</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_31" id="field_31">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">百万用户申诉率--用户总数（万）</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_32" id="field_32" >
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">百万用户申诉率--百万用户申诉率（人次/百万用户）</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_33" id="field_33">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">不明扣费申诉率／总受理量(件)</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_34" id="field_34">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">不明扣费申诉率／用户总数（万）</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_35" id="field_35" >
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">不明扣费申诉率／百万用户申诉率（人次/百万用户）</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="field_36" id="field_36">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<input type="hidden" class="form-control" name="id" id="id" value="0">
								<button type="button" class="btn btn-primary" id="submitBtn">提交</button>
								<button type="reset" class="btn btn-warning" data-dismiss="modal">取消</button>
								<button type="button" class="btn btn-danger" id="deleteBtn" style="display:none;">删除</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->
	<jsp:include page="../common/footerJs.jsp"></jsp:include>
	<script type="text/javascript" src="/assets/layer/layer.js"></script>
	<script src="/assets/global/plugins/highcharts/code/highcharts.js"></script>
    <script src="/assets/global/plugins/highcharts/code/modules/exporting.js"></script>
    <script src="/assets/global/plugins/highcharts/code/highcharts-zh_CN"></script>
    <script type="text/javascript" src="/assets/apps/administration/hightchats_json.js?version=20180507"></script>
	<script type="text/javascript" src="/assets/apps/administration/form_13.js?version=20190822"></script>
</body>
</html>