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
								<h3 style="font-size: 16px; margin: 0; padding: 0;">打击通讯信息诈骗相关业务数据</h3>
							</li>
						</ul>
					</div>
					<!-- END PAGE BAR -->
					<!-- END PAGE HEADER-->
					<div class="row">
						<div class="col-md-12" style="margin-top: 30px;">
						    <div id="containerDJXXZP" style="min-width: 310px; height: 450px; margin: 20px auto"></div>
						    <div id="containerZDDXYWYHS" style="min-width: 310px; height: 450px; margin: 20px auto"></div>
						    <div id="containerGTYWS" style="min-width: 310px; height: 450px; margin: 20px auto"></div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="actions" style="margin-bottom: 8px;">
										<a class="btn btn-success mt-repeater-add" href="#add-form" data-toggle="modal"> <i class="fa fa-plus"></i> 添加数据
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
												<tr>
													<td rowspan="2">时间</td>
													<td colspan="3">语音专线出租业务</td>
													<td colspan="3">“400”业务</td>
													<td colspan="3">一号通业务</td>
													<td colspan="3">商务总机业务</td>
													<td>封堵境外非法透传</td>
													<td colspan="2">语音专线主叫鉴权</td>
													<td>虚假改号呼叫拦截</td>
													<td>一键退订</td>
												</tr>
												<tr>
													<td>总用户数（家）</td>
													<td>实名率（%）</td>
													<td>关停号码（个）</td>
													<td>总用户数（家）</td>
													<td>实名率（%）</td>
													<td>关停号码（个）</td>
													<td>总用户数（家）</td>
													<td>实名率（%）</td>
													<td>关停号码（个）</td>
													<td>总用户数（家）</td>
													<td>实名率（%）</td>
													<td>关停号码（个）</td>
													<td>拦截数量（万次）</td>
													<td>总电路数（条）</td>
													<td>主叫鉴权率（%）</td>
													<td>拦截数量（次）</td>
													<td>退订数量（万起）</td>
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
		<div class="modal fade" id="add-form" role="basic" aria-hidden="true" style="font-size:12px;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
							<h4 class="modal-title">打击通讯信息诈骗相关业务数据</h4>
						</div>
						<div class="modal-body">
							<form class="form-horizontal" name="form1" id="form1" role="form">
								<div class="form-group">
									<label for="year" class="col-sm-4 control-label">日期</label>
									<div class="col-sm-8 form-inline">
										<select class="form-control input-xsmall" style="margin-right:8px;" name="year" id="year">
											<option value="">年</option>
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
										</select><select
											class="form-control input-xsmall" style="margin-right:8px;" name="month" id="month">
											<option value="">月</option>
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
										</select><select
											class="form-control input-xsmall" name="day" id="day">
											<option value="">日</option>
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
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="12">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
											<option value="21">21</option>
											<option value="22">22</option>
											<option value="23">23</option>
											<option value="24">24</option>
											<option value="25">25</option>
											<option value="26">26</option>
											<option value="27">27</option>
											<option value="28">28</option>
											<option value="29">29</option>
											<option value="30">30</option>
											<option value="31" selected>31</option>
										</select> 
									</div>
								</div>
								<div class="form-group" style="border-bottom:1px solid #f0f0f0;font-size:14px;"><label class="col-sm-4 control-label">语音专线出租业务</label></div>
								<div class="form-group">
									<label class="col-sm-4 control-label">总用户数（家）</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="field_11" id="field_11">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">实名率（%）</label>
									<div class="col-sm-8">
										<div class="input-group"><input type="text" class="form-control" name="field_12" id="field_12" placeholder="100.00"><span class="input-group-addon">%</span> </div>
										<span class="help-block">百分制，请不要填写"%"</span>
									</div>
								</div>
							    <div class="form-group">
									<label class="col-sm-4 control-label">关停号码（个）</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="field_13" id="field_13">
									</div>
							   </div>
							   <div class="form-group" style="border-bottom:1px solid #f0f0f0;font-size:14px;"><label class="col-sm-4 control-label">“400”业务</label></div>
								<div class="form-group">
									<label class="col-sm-4 control-label">总用户数（家）</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="field_21" id="field_21">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">实名率（%）</label>
									<div class="col-sm-8">
										<div class="input-group"><input type="text" class="form-control" name="field_22" id="field_22" placeholder="100.00"><span class="input-group-addon">%</span> </div>
										<span class="help-block">百分制，请不要填写"%"</span>
									</div>
								</div>
							    <div class="form-group">
									<label class="col-sm-4 control-label">关停号码（个）</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="field_23" id="field_23">
									</div>
							   </div>
							   <div class="form-group" style="border-bottom:1px solid #f0f0f0;font-size:14px;"><label class="col-sm-4 control-label">一号通业务</label></div>
								<div class="form-group">
									<label class="col-sm-4 control-label">总用户数（家）</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="field_31" id="field_31">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">实名率（%）</label>
									<div class="col-sm-8">
										<div class="input-group"><input type="text" class="form-control" name="field_32" id="field_32" placeholder="100.00"><span class="input-group-addon">%</span> </div>
										<span class="help-block">百分制，请不要填写"%"</span>
									</div>
								</div>
							    <div class="form-group">
									<label class="col-sm-4 control-label">关停号码（个）</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="field_33" id="field_33">
									</div>
							   </div>
							   <div class="form-group" style="border-bottom:1px solid #f0f0f0;font-size:14px;"><label class="col-sm-4 control-label">商务总机业务</label></div>
								<div class="form-group">
									<label class="col-sm-4 control-label">总用户数（家）</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="field_41" id="field_41">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">实名率（%）</label>
									<div class="col-sm-8">
										<div class="input-group"><input type="text" class="form-control" name="field_42" id="field_42" placeholder="100.00"><span class="input-group-addon">%</span> </div>
										<span class="help-block">百分制，请不要填写"%"</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">关停号码（个）</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="field_43" id="field_43">
									</div>
							   </div>
								 <div class="form-group" style="border-bottom:1px solid #f0f0f0;font-size:14px;"><label class="col-sm-4 control-label">封堵境外非法透传</label></div>
							    <div class="form-group">
									<label class="col-sm-4 control-label">拦截数量（万次）</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="field_51" id="field_51">
									</div>
							   </div>
							   <div class="form-group" style="border-bottom:1px solid #f0f0f0;font-size:14px;"><label class="col-sm-4 control-label">语音专线主叫鉴权</label></div>
								<div class="form-group">
									<label class="col-sm-4 control-label">总电路数（条）</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="field_61" id="field_61">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">主叫鉴权率（%）</label>
									<div class="col-sm-8">
										<div class="input-group"><input type="text" class="form-control" name="field_62" id="field_62" placeholder="100.00"><span class="input-group-addon">%</span> </div>
										<span class="help-block">百分制，请不要填写"%"</span>
									</div>
								</div>
								<div class="form-group" style="border-bottom:1px solid #f0f0f0;font-size:14px;"><label class="col-sm-4 control-label">虚假改号呼叫拦截</label></div>
								<div class="form-group">
									<label class="col-sm-4 control-label">拦截数量（次）</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="field_71" id="field_71">
									</div>
								</div>
								<div class="form-group" style="border-bottom:1px solid #f0f0f0;font-size:14px;"><label class="col-sm-4 control-label">一键退订</label></div>
								<div class="form-group">
									<label class="col-sm-4 control-label">退订数量（万起）</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="field_81" id="field_81">
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
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	<jsp:include page="../common/footerJs.jsp"></jsp:include>
	<script type="text/javascript" src="/assets/layer/layer.js"></script>
	<script src="/assets/global/plugins/highcharts/code/highcharts.js"></script>
    <script src="/assets/global/plugins/highcharts/code/modules/exporting.js"></script>
    <script src="/assets/global/plugins/highcharts/code/highcharts-zh_CN"></script>
    <script type="text/javascript" src="/assets/apps/administration/hightchats_json.js?version=20180507"></script>
	<script type="text/javascript" src="/assets/apps/administration/form_06.js?version=20190822"></script>
</body>
</html>