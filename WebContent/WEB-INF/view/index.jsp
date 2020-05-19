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
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="上海市通信管理局-市场业务报表综合分析管理" name="description" />
        <meta content="上海市通信管理局-市场业务报表综合分析管理" name="author" />
        <link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="/assets/layouts/layout/css/custom.css" rel="stylesheet" type="text/css" />
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="/favicon.ico" /> </head>
    <!-- END HEAD -->
<script type="text/javascript" src="https://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
<script src="/assets/global/plugins/highcharts/code/highcharts.js"></script>
<script src="/assets/global/plugins/highcharts/code/modules/exporting.js"></script>
<script src="/assets/global/plugins/highcharts/grouped-categories.js"></script>
<script src="/assets/global/plugins/highcharts/code/highcharts-zh_CN"></script>
<style>
.showCharts{width:980px;height: 450px; margin: 20px auto}
</style>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
        <div class="page-wrapper">
            <jsp:include page="common/top.jsp"></jsp:include>
            <!-- BEGIN HEADER & CONTENT DIVIDER -->
            <div class="clearfix"> </div>
            <!-- END HEADER & CONTENT DIVIDER -->
            <!-- BEGIN CONTAINER -->
            <div class="page-container">
                <jsp:include page="common/left.jsp"></jsp:include>
                <!-- BEGIN CONTENT -->
                <div class="page-content-wrapper">
                    <!-- BEGIN CONTENT BODY -->
                    <div class="page-content">
                        <!-- BEGIN PAGE HEADER-->
                        <!-- BEGIN PAGE BAR -->
                        <div class="page-bar">
                            <ul class="page-breadcrumb">
                                <li>
                                    <a href="index.html">主页</a>
                                    <i class="fa fa-circle"></i>
                                </li>
                                <li>
                                    <span>仪表盘</span>
                                </li>
                            </ul>
                        </div>
                        <!-- END PAGE BAR -->
                        <!-- BEGIN PAGE TITLE-->
                        <h1 class="page-title">
                            <small>欢迎进入上海市通信管理局-市场业务报表综合分析管理</small>
                        </h1>
                        <!-- END PAGE TITLE-->
                        <!-- END PAGE HEADER-->
                        <!-- BEGIN DASHBOARD STATS 1-->
                        <div class="row">
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <a href="/report/under"><div class="dashboard-stat dashboard-stat-v2 blue">
                                    <div class="visual">
                                        <i class="fa fa-comments"></i>
                                    </div>
                                    <div class="details">
                                        <div class="number">
                                            <span>${uncompeletedReportNumber}</span>
                                        </div>
                                        <div class="desc"> 未填写报表 </div>
                                    </div>
                                </div></a>
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                               <a href="/report/history"> <div class="dashboard-stat dashboard-stat-v2 red">
                                    <div class="visual">
                                        <i class="fa fa-bar-chart-o"></i>
                                    </div>
                                    <div class="details">
                                        <div class="number">
                                            <span>${historyReportNumber}</span></div>
                                        <div class="desc"> 历史报表 </div>
                                    </div>
                                </div></a>
                            </div>
                            <c:if test="${curUser.role.code=='ADMIN'||curUser.role.code=='SUBADMIN'}">
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <a href="/summary"><div class="dashboard-stat dashboard-stat-v2 green">
                                    <div class="visual">
                                        <i class="fa fa-shopping-cart"></i>
                                    </div>
                                    <div class="details">
                                        <div class="number">
                                            <span>${summaryReportNumber}</span>
                                        </div>
                                        <div class="desc"> 汇总报表 </div>
                                    </div>
                                </div></a>
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <a href="/schedule"><div class="dashboard-stat dashboard-stat-v2 purple">
                                    <div class="visual">
                                        <i class="fa fa-globe"></i>
                                    </div>
                                    <div class="details">
                                        <div class="number"> 
                                            <span>${planReportNumber}</span></div>
                                        <div class="desc"> 所有计划 </div>
                                    </div>
                                </div></a>
                            </div>
                            </c:if>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                        <div class="col-md-12">
                        <c:if test="${curUser.role.code=='ADMIN'}">
								<div class="tabbable-custom">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#tab_01" data-toggle="tab">实名制</a></li>
										<li><a href="#tab_02" data-toggle="tab">实名制渠道</a></li>
										<li><a href="#tab_03" data-toggle="tab">实名制志愿者检查</a></li>
										<li><a href="#tab_04" data-toggle="tab">通讯信息诈骗举报（手机号）</a></li>
										<li><a href="#tab_05" data-toggle="tab">打击通讯信息诈骗相关业务数据周报</a></li>
										<li><a href="#tab_06" data-toggle="tab">网间平台垃圾短信举报</a></li>
										<li><a href="#tab_07" data-toggle="tab">固网号码资源</a></li>
										<li><a href="#tab_08" data-toggle="tab">宽带资费</a></li>
										<li><a href="#tab_09" data-toggle="tab">降费</a></li>
										<li><a href="#tab_10" data-toggle="tab">增值电信业务</a></li>
										<li><a href="#tab_11" data-toggle="tab">自贸区增值电信业务</a></li>
										<li><a href="#tab_12" data-toggle="tab">百万用户申诉率</a></li>
										<li><a href="#tab_13" data-toggle="tab">虚拟运营商</a></li>
										<li><a href="#tab_14" data-toggle="tab">行业卡管理</a></li>
										<li><a href="#tab_16" data-toggle="tab">码号统计</a></li>
										<li><a href="#tab_17" data-toggle="tab">增值电信业务统计分析（含自贸区）</a></li>
										<li><a href="#tab_18" data-toggle="tab">本地移动通信转售企业业务统计表</a></li>
									</ul>
									<div class="tab-content" style="width:100%;">
										<div class="tab-pane active" id="tab_01">
											<div id="containerSMZ" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_02">
										    <div id="containerSMZQD" class="showCharts"></div></div>
										<div class="tab-pane" id="tab_03">
											<div id="containerZYZJC" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_04">
											<div id="containerXXZP" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_05">
											<div id="containerDJXXZP" class="showCharts"></div>
											<div id="containerZDDXYWYHS" class="showCharts"></div>
											<div id="containerGTYWS" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_06">
											<div id="containerWJLJDXJB" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_07">
											<div id="containerGWHMZY" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_08">
											<div id="containerKDZF" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_09">
											<div id="containerJF" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_10">
											<div id="containerYYSR" class="showCharts"></div>
											<div id="containerSRFB" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_11">
											<div id="containerZMQDXYW" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_12">
											<div id="containerSSL" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_13">
											<div id="containerXNYYSZS" class="showCharts"></div>
											<div id="containerXNYYSXZ" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_14">
											<div id="containerHYK" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_16">
											<div id="containerMHFL" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_17">
											<div id="container_1" class="showCharts"></div>
											<div id="container_4" class="showCharts"></div>
											<div id="container_5" class="showCharts"></div>
											<div id="container_6" class="showCharts"></div>
											<div id="container_7" class="showCharts"></div>
										</div>
										<div class="tab-pane" id="tab_18">
											<div id="form18_1" class="showCharts"></div>
											<div id="form18_2" class="showCharts"></div>
										</div>
									</div>
								</div>
								<script type="text/javascript" src="/assets/apps/administration/hightchats_json.js?version=20180507"></script>
								<script type="text/javascript" src="/assets/apps/administration/hightchats_data.js?version=20180507"></script>
							</c:if>
                        </div>
                        </div>
                    </div>
                    <!-- END CONTENT BODY -->
                </div>
                <!-- END CONTENT -->
            </div>
            <!-- END CONTAINER -->
            <jsp:include page="common/footer.jsp"></jsp:include>
        </div>
        <!--[if lt IE 9]>
		<script src="/assets/global/plugins/respond.min.js"></script>
		<script src="/assets/global/plugins/excanvas.min.js"></script> 
		<script src="/assets/global/plugins/ie8.fix.min.js"></script> 
		<![endif]-->
        <!-- BEGIN CORE PLUGINS -->
        <script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="/assets/global/scripts/app.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="/assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
        <!-- END THEME LAYOUT SCRIPTS -->
    </body>

</html>