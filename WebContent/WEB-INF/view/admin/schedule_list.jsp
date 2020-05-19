<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
        <title>上海市通信管理局-市场业务报表综合分析管理</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="上海市通信管理局-市场业务报表综合分析管理" name="description" />
        <meta content="上海市通信管理局-市场业务报表综合分析管理" name="author" />
              <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="/assets/layouts/layout/css/custom.css" rel="stylesheet" type="text/css" />
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="/favicon.ico" />
        <style>
        body {background-color: #364150 !important;}
        .schedule-table{border-collapse:collapse;width:100%;text-align:center;}
        .schedule-table > tbody > tr > td{vertical-align:middle;}
        .schedule-table td h5{font-weight:bold;font-size:12px;}
        .schedule-table td p{line-height:25px;font-size:12px;margin:0;padding:0;}
        .undo-status{border:1px solid #555;color:#333;font-size:12px;padding:5px;;}
        .success-status{border:1px solid #36c6d3;color:#36c6d3;font-size:12px;padding:5px;}
        .doing-status{border:1px solid #ed6b75;color:#ed6b75;font-size:12px;padding:5px;}
        </style>
    </head>
    <!-- END HEAD -->

    <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
        <div class="page-wrapper">
           <jsp:include page="../common/top.jsp"></jsp:include>
            <!-- BEGIN HEADER & CONTENT DIVIDER -->
            <div class="clearfix"> </div>
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
                                   <h3 style="font-size:16px;margin:0;padding:0;">所有计划<c:if test="${curUser.role.code=='SUBADMIN' }"><a class="btn green btn-sm margin-left-15" href="/schedule/add">新建计划</a></c:if></h3>
                                </li>
                            </ul>
                        </div>
                        <!-- END PAGE BAR -->
                        <!-- END PAGE HEADER-->
                        <div class="row">
                            <div class="col-md-12">
                            <ul class="table-top-tools"><li><a href="/schedule">全部（<span id="count_all">0</span>）</a></li><li><span>|</span><a href="/schedule/unstart">未开始（<span id="count_unstarted">0</span>）</a></li><li><span>|</span><a href="/schedule/uncompleted">进行中（<span id="count_uncompleted">0</span>）</a></li><li><span>|</span><a href="/schedule/completed">已结束（<span id="count_completed">0</span>）</a></li></ul>
						    <table id="tablesList" class="table table-striped table-bordered table-advance table-hover schedule-table">
								<thead>
									<tr>
									    <th style="width:5%;" class="text-center">计划ID</th>
										<th style="width:20%;" class="text-center">计划名称</th>
										<th style="width:30%;" class="text-center">报表模板</th>
										<th style="width:25%;" class="text-center">发送方式</th>
										<th style="width:20%;" class="text-center">当前状态</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${scheduleReportList==null}">
											<tr>
												<td colspan="4" class="center">暂无可用数据</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${scheduleReportList}" var="scheduleReport">
												<tr>
												    <td>${scheduleReport.id}</td>
													<td><c:choose><c:when test="${curUser.role.code=='SUBADMIN'}"><a href="/schedule/${scheduleReport.id}/edit">${scheduleReport.name}</a></c:when><c:otherwise>${scheduleReport.name}</c:otherwise></c:choose></td>
													<td><a href="/form/${scheduleReport.report.formCode}">${scheduleReport.report.title}</a></td>
													<td  class="text-left" style="padding-left:25px;"><c:choose>
															<c:when test="${scheduleReport.type=='1'}">
																<p>发送方式：按日</p>
																<p>发送日期：<fmt:formatDate value="${scheduleReport.sendDate}" pattern="yyyy-MM-dd"/></p>
																<p>发送时间：${scheduleReport.sendTime}</p>
															</c:when>
															<c:when test="${scheduleReport.type=='2'}">
																<p>发送方式：按周</p>
																<p>发送日期：每周${scheduleReport.sendWeek}</p>
																<p>发送时间段：<fmt:formatDate value="${scheduleReport.startTime}" pattern="yyyy-MM-dd"/>至<fmt:formatDate value="${scheduleReport.endTime}" pattern="yyyy-MM-dd"/></p>
															    <p>发送时间：${scheduleReport.sendTime}</p>
															</c:when>
															<c:when test="${scheduleReport.type=='3'}">
																<p>发送方式：按月</p>
																<p>发送日期：每月${scheduleReport.sendDay}号</p>
																<p>发送时间段：<fmt:formatDate value="${scheduleReport.startTime}" pattern="yyyy-MM-dd"/>至<fmt:formatDate value="${scheduleReport.endTime}" pattern="yyyy-MM-dd"/></p>
																<p>发送时间：${scheduleReport.sendTime}</p>
															</c:when>
														</c:choose></td>
													<td><c:choose>
															<c:when test="${scheduleReport.status=='2'}"><span class="success-status">已结束</span></c:when>
															<c:when test="${scheduleReport.status=='1'}"><span class="doing-status">进行中</span></c:when>
															<c:otherwise><span class="undo-status">未开始</span></c:otherwise>
														</c:choose></td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
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
	<!--[if lt IE 9]>
<script src="/assets/global/plugins/respond.min.js"></script>
<script src="/assets/global/plugins/excanvas.min.js"></script> 
<script src="/assets/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->
	<!-- BEGIN CORE PLUGINS -->
        <script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
       <script src="/assets/global/scripts/datatable.js" type="text/javascript"></script>
	   <script src="/assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
	   <script src="/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="/assets/global/scripts/app.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="/assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
        <script src="/assets/pages/scripts/table-datatables-common.js" type="text/javascript"></script>
        <!-- END THEME LAYOUT SCRIPTS -->
        <script type="text/javascript">
        jQuery(document).ready(function() {
        	var init = function(){
        		$.ajax({
        			cache : true,
        			type : "get",
        			url : "/schedule/count",
        			async : false,
        			dataType : "json",
        			success : function(data) {
        				if (data.check_user_login == '1') {
        					$("#count_all").html(data.count_all);
        					$("#count_unstarted").html(data.count_unstarted)
        					$("#count_uncompleted").html(data.count_uncompleted)
        					$("#count_completed").html(data.count_completed)
        				}else{
        					window.location.href="/login";
        				} 
        			},
        			error : function() {
        			}
        		})
        	}
        	init();
        })
        </script>
    </body>

</html>