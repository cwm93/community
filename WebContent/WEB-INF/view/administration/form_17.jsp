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
								<h3 style="font-size: 16px; margin: 0; padding: 0;">增值电信业务统计分析（含自贸区）</h3>
							</li>
						</ul>
					</div>
					<!-- END PAGE BAR -->
					<!-- END PAGE HEADER-->
					<div class="row">
						<div class="col-md-12">
							<div class="tabbable-custom" style="margin-top: 30px;">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#tab_01" data-toggle="tab">基础数据</a></li>
									<li><a href="/administration/form_17#tab_02"
										data-toggle="tab">批准日期</a></li>
									<li><a href="/administration/form_17#tab_03"
										data-toggle="tab">许可证</a></li>
									<li><a href="/administration/form_17#tab_04"
										data-toggle="tab">企业性质</a></li>
									<li><a href="/administration/form_17#tab_05"
										data-toggle="tab">上市情况</a></li>
									<li><a href="/administration/form_17#tab_06"
										data-toggle="tab">自贸区</a></li>
									<li><a href="/administration/form_17#tab_07"
										data-toggle="tab">注册资本</a></li>
								</ul>
								<div class="tab-content" style="width: 100%;">
									<div class="tab-pane active" id="tab_01">
										<div class="actions" style="margin-bottom: 8px;">
											<a href="/gj/telecomValueAdded/add"
												class="btn btn-success mt-repeater-add"> <i
												class="fa fa-plus"></i> 原始数据导入
											</a>
										</div>
										<div class="panel-heading form-inline">
											<select class="form-control input-xsmall" id="selectYear">
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
											</select><span style="padding: 0 15px;">年</span><select
												class="form-control input-xsmall" id="selectMonth">
												<option value="">请选择</option>
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
											<button class="btn blue" id="searchData">查询</button>
										</div>
										<div class="panel-body" id="dataContent"></div>
									</div>
									<div class="tab-pane" id="tab_02">
									    <div id="container_1" style="width: 780px; height:300px; margin: 20px auto"></div>
										<table class="table table-bordered">
											<tbody>
												<tr class="firstRow">
													<td rowspan="2">业务种类</td>
													<td colspan="2">2015年</td>
													<td colspan="2">2016年</td>
													<td colspan="2">2017年</td>
												</tr>
												<tr>
													<td>企业数</td>
													<td>前置审批数</td>
													<td>企业数</td>
													<td>前置审批数</td>
													<td>企业数</td>
													<td>前置审批数</td>
												</tr>
												<tr>
													<td>存储转发类业务</td>
													<td>1</td>
													<td></td>
													<td>2</td>
													<td></td>
													<td>1</td>
													<td></td>
												</tr>
												<tr>
													<td>国内多方通信服务业务</td>
													<td>3</td>
													<td></td>
													<td>2</td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>国内呼叫中心业务</td>
													<td>19</td>
													<td></td>
													<td>21</td>
													<td></td>
													<td>5</td>
													<td></td>
												</tr>
												<tr>
													<td>国内互联网虚拟专用网业务</td>
													<td>2</td>
													<td></td>
													<td>4</td>
													<td></td>
													<td>1</td>
													<td></td>
												</tr>
												<tr>
													<td>互联网接入服务业务</td>
													<td>29</td>
													<td></td>
													<td>45</td>
													<td></td>
													<td>36</td>
													<td></td>
												</tr>
												<tr>
													<td>互联网数据中心业务</td>
													<td>3</td>
													<td></td>
													<td>5</td>
													<td></td>
													<td>8</td>
													<td></td>
												</tr>
												<tr>
													<td>信息服务业务（不含互联网信息服务）</td>
													<td>17</td>
													<td></td>
													<td>10</td>
													<td></td>
													<td>6</td>
													<td></td>
												</tr>
												<tr>
													<td>信息服务业务（仅限固定网电话信息服务）</td>
													<td></td>
													<td></td>
													<td>1</td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>信息服务业务（仅限互联网信息服务）</td>
													<td>191</td>
													<td></td>
													<td>304</td>
													<td>66</td>
													<td>182</td>
													<td>71</td>
												</tr>
												<tr>
													<td>在线数据处理与交易处理业务</td>
													<td>5</td>
													<td></td>
													<td>27</td>
													<td></td>
													<td>14</td>
													<td></td>
												</tr>
												<tr>
													<td>总计</td>
													<td>271</td>
													<td></td>
													<td>421</td>
													<td>66</td>
													<td>253</td>
													<td>71</td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="tab-pane" id="tab_03">
										<table class="table table-bordered">
											<tbody>
												<tr>
													<td rowspan="2">业务种类</td>
													<td colspan="5">许可证发放情况</td>
													<td colspan="6">前置审批数</td>
												</tr>
												<tr>
													<td>历史</td>
													<td>国有控股</td>
													<td>民营控股</td>
													<td>中外合资</td>
													<td>总计</td>
													<td>含出版、文化</td>
													<td>含文化</td>
													<td>含文化、视听节目</td>
													<td>含药品和医疗器械</td>
													<td>新闻</td>
													<td>总计</td>
												</tr>
												<tr>
													<td>X.400电子邮件业务</td>
													<td></td>
													<td>3</td>
													<td></td>
													<td></td>
													<td>3</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>存储转发类业务</td>
													<td>1</td>
													<td>5</td>
													<td>9</td>
													<td></td>
													<td>15</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>固定网国内数据传送业务</td>
													<td></td>
													<td>3</td>
													<td></td>
													<td></td>
													<td>3</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>国内多方通信服务业务</td>
													<td></td>
													<td>1</td>
													<td>5</td>
													<td>1</td>
													<td>7</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>国内呼叫中心业务</td>
													<td>12</td>
													<td>25</td>
													<td>66</td>
													<td>4</td>
													<td>107</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>国内互联网虚拟专用网业务</td>
													<td></td>
													<td>6</td>
													<td>13</td>
													<td>1</td>
													<td>20</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>国内甚小口径终端地球站通信业务</td>
													<td></td>
													<td>3</td>
													<td></td>
													<td></td>
													<td>3</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>互联网接入服务业务</td>
													<td>21</td>
													<td>30</td>
													<td>221</td>
													<td>1</td>
													<td>273</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>互联网数据中心业务</td>
													<td></td>
													<td>14</td>
													<td>21</td>
													<td></td>
													<td>35</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>基础业务</td>
													<td></td>
													<td>5</td>
													<td></td>
													<td></td>
													<td>5</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>模拟集群通信业务</td>
													<td></td>
													<td>2</td>
													<td></td>
													<td></td>
													<td>2</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>网络托管业务</td>
													<td></td>
													<td>3</td>
													<td></td>
													<td></td>
													<td>3</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>无线数据传送业务</td>
													<td></td>
													<td>2</td>
													<td></td>
													<td></td>
													<td>2</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>无线寻呼业务</td>
													<td>2</td>
													<td>2</td>
													<td>3</td>
													<td></td>
													<td>7</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>信息服务业务（不含互联网信息服务）</td>
													<td>18</td>
													<td>24</td>
													<td>60</td>
													<td>1</td>
													<td>103</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>信息服务业务（仅限固定网电话信息服务）</td>
													<td>1</td>
													<td>5</td>
													<td>1</td>
													<td></td>
													<td>7</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>信息服务业务（仅限互联网信息服务）</td>
													<td>131</td>
													<td>82</td>
													<td>921</td>
													<td>10</td>
													<td>1144</td>
													<td>2</td>
													<td>130</td>
													<td>1</td>
													<td>4</td>
													<td>4</td>
													<td>141</td>
												</tr>
												<tr>
													<td>用户驻地网业务</td>
													<td></td>
													<td>3</td>
													<td></td>
													<td></td>
													<td>3</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>语音信箱业务</td>
													<td></td>
													<td>3</td>
													<td></td>
													<td></td>
													<td>3</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>在线数据处理与交易处理业务</td>
													<td></td>
													<td>9</td>
													<td>32</td>
													<td>16</td>
													<td>57</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td>总计</td>
													<td>186</td>
													<td>230</td>
													<td>1352</td>
													<td>34</td>
													<td>1802</td>
													<td>2</td>
													<td>130</td>
													<td>1</td>
													<td>4</td>
													<td>4</td>
													<td>141</td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="tab-pane" id="tab_04">
									    <div id="container_4" style="width: 740px; height:300px; margin: 20px auto"></div>
										<table class="table table-bordered">
											<tbody>
												<tr>
													<td>企业性质</td>
													<td>数量</td>
												</tr>
												<tr>
													<td>历史</td>
													<td>186</td>
												</tr>
												<tr>
													<td>国有控股</td>
													<td>230</td>
												</tr>
												<tr>
													<td>民营控股</td>
													<td>1352</td>
												</tr>
												<tr>
													<td>中外合资</td>
													<td>34</td>
												</tr>
												<tr>
													<td>总计</td>
													<td>1802</td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="tab-pane" id="tab_05">
									    <div id="container_5" style="width: 740px; height:300px; margin: 20px auto"></div>
										<table class="table table-bordered">
											<tr>
												<td>是否上市</td>
												<td>数量</td>
											</tr>
											<tr>
												<td>未上市</td>
												<td>1393</td>
											</tr>
											<tr>
												<td>已上市</td>
												<td>8</td>
											</tr>
											<tr>
												<td>空白</td>
												<td>401</td>
											</tr>
											<tr>
												<td>总计</td>
												<td>1802</td>
											</tr>
										</table>
									</div>
									<div class="tab-pane" id="tab_06">
									    <div id="container_6" style="width: 740px; height:300px; margin: 20px auto"></div>
										<table id="tablesList"
											class="table table-striped table-bordered table-advance table-hover">
											<tbody>
												<tr>
													<td>自贸区业务名称</td>
													<td>数量</td>
												</tr>
												<tr>
													<td>国内多方通信服务业务</td>
													<td>1</td>
												</tr>
												<tr>
													<td>国内呼叫中心业务</td>
													<td>4</td>
												</tr>
												<tr>
													<td>国内互联网虚拟专用网业务</td>
													<td>1</td>
												</tr>
												<tr>
													<td>互联网接入服务业务</td>
													<td>1</td>
												</tr>
												<tr>
													<td>信息服务业务（不含互联网信息服务）</td>
													<td>1</td>
												</tr>
												<tr>
													<td>信息服务业务（仅限互联网信息服务）</td>
													<td>10</td>
												</tr>
												<tr>
													<td>在线数据处理与交易处理业务</td>
													<td>16</td>
												</tr>
												<tr>
													<td>总计</td>
													<td>34</td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="tab-pane" id="tab_07">
									    <div id="container_7" style="width: 740px; height:300px; margin: 20px auto"></div>
										<table class="table table-bordered">
											<tbody>
												<tr>
													<td>注册资本</td>
													<td>许可证数量</td>
												</tr>
												<tr>
													<td>&lt;100万元</td>
													<td>6</td>
												</tr>
												<tr>
													<td>&lt;300万元，〉=100万元</td>
													<td>452</td>
												</tr>
												<tr>
													<td>&lt;500万元，〉=300万元</td>
													<td>44</td>
												</tr>
												<tr>
													<td>〉=500万元</td>
													<td>1300</td>
												</tr>
												<tr>
													<td>总计</td>
													<td>1802</td>
												</tr>
											</tbody>
										</table>
									</div>
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
    <script src="/assets/global/plugins/highcharts/code/highcharts.js"></script>
    <script src="/assets/global/plugins/highcharts/code/modules/exporting.js"></script>
    <script src="/assets/global/plugins/highcharts/grouped-categories.js"></script>
    <script src="/assets/global/plugins/highcharts/code/highcharts-zh_CN"></script>
    <script type="text/javascript" src="/assets/apps/administration/hightchats_data.js?version=20180507"></script>
    <script type="text/javascript" src="/assets/layer/layer.js"></script>
	<script type="text/javascript" src="/assets/apps/administration/form_17.js?version=20190822"></script>
</body>
</html>