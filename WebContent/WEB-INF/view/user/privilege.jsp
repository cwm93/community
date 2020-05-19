<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN THEME GLOBAL STYLES -->
<link href="/assets/global/css/components.min.css" rel="stylesheet"
	id="style_components" type="text/css" />
<link href="/assets/global/css/plugins.min.css" rel="stylesheet"
	type="text/css" />
<!-- END THEME GLOBAL STYLES -->
<!-- BEGIN THEME LAYOUT STYLES -->
<link href="/assets/layouts/layout/css/layout.min.css" rel="stylesheet"
	type="text/css" />
<link href="/assets/layouts/layout/css/themes/darkblue.min.css"
	rel="stylesheet" type="text/css" id="style_color" />
<link href="/assets/layouts/layout/css/custom.css" rel="stylesheet"
	type="text/css" />
<!-- END THEME LAYOUT STYLES -->
<link rel="shortcut icon" href="/favicon.ico" />
<style>
.table td,.table th {
	font-size: 12px;
}
</style>
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
							<li><a href="／index">主页</a> <i class="fa fa-circle"></i></li>
							<li><span>个人资料</span></li>
						</ul>
					</div>
					<!-- END PAGE BAR -->
					<!-- END PAGE HEADER-->
					<div class="row">
						<div class="col-md-12 margin-top-15">
							<div class="tabbable-custom">
								<ul class="nav nav-tabs">
									<li><a href="/user/${user.id}/detail"> 个人资料 </a></li>
									<li class="active"><a href="/user/${user.id}/privilege">
											权限设置 </a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active">
										<div class="row">
											<div class="col-lg-6 col-xs-12 col-sm-12">
												<!-- BEGIN PORTLET-->
												<div class="portlet light bordered">
													<div class="portlet-title">
														<div class="caption">
															<i class="icon-user font-dark hide"></i> <span class="caption-subject font-dark">已分配的用户</span>
														</div>
													</div>
													<div class="portlet-body">
														<div class="table-toolbar">
															<div class="row">
																<div class="col-lg-6 col-xs-12 col-sm-12">
																	<div class="clearfix">
																		<a class="btn blue" id="selectUser">
																			<i class="fa fa-plus"></i> 分配
																		</a>
																	</div>
																</div>
															</div>
														</div>
														<form id="select_user_form" method="post">
														<table class="table table-bordered table-hover">
															<thead>
																<tr>

																	<th><span>#</span></th>
																	<th>姓名</th>
																	<th>单位</th>
																	<th>单位属性</th>
																</tr>
															</thead>
															<tbody>
															    <c:choose><c:when test="${empty userList}"><tr>
																		<td colspan="4" class="text-center">没有可分配人员</td></tr>  </c:when><c:otherwise><c:forEach items="${userList}" var="user">
																	<tr>
																		<td><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
																				<input type="checkbox" class="checkboxes" name="select_user_id"
																				value="${user.id}" <c:forEach items="${assignedUsers}" var="assignedUser"><c:if test="${assignedUser.id==user.id}">checked</c:if></c:forEach> /> <span></span>
																		</label></td>
																		<td>${user.realname}</td>
																		<td>${user.company}</td>
																		<td>${user.companyAttribute.name}</td>
																	</tr>
																</c:forEach></c:otherwise></c:choose>
															</tbody>
														</table>
														<input type="hidden" name="user_id" value="${user.id}"/>
														</form>
													</div>
												</div>
												<!-- END PORTLET-->
											</div>
											<div class="col-lg-6 col-xs-12 col-sm-12">
												<!-- BEGIN PORTLET-->
												<div class="portlet light bordered">
													<div class="portlet-title">
														<div class="caption">
															<i class="icon-user font-dark hide"></i> <span
																class="caption-subject font-dark">已分配的报表模板</span>
														</div>
													</div>
													<div class="portlet-body">
														<div class="table-toolbar">
															<div class="row">
																<div class="col-lg-6 col-xs-12 col-sm-12">
																	<div class="clearfix">
																		<a class="btn blue" id="select_report_model">
																			<i class="fa fa-plus"></i> 分配
																		</a>
																	</div>
																</div>
															</div>
														</div>
														<form id="select_report_form" method="post">
														<table class="table table-bordered table-hover">
															<thead>
																<tr>
																	<th><span>#</span></th>
																	<th>报表模板名称</th>
																	<th>报表种类</th>
																	<th>报表分类</th>

																</tr>
															</thead>
															<tbody>
															<c:choose><c:when test="${empty reportList}"><tr>
																		<td colspan="4" class="text-center">还没有可分配的报表模板</td></tr>  </c:when><c:otherwise>
																<c:forEach items="${reportList}" var="report">
																	<tr>
																		<td><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
																				<input type="checkbox" class="checkboxes" name="select_report_id"
																				value="${report.id}" <c:forEach items="${assignedReports}" var="assignedReport"><c:if test="${assignedReport.id==report.id}">checked</c:if></c:forEach>/> <span></span>
																		</label></td>
																		<td>${report.title}</td>
																		<td>${report.reportKind.name}</td>
																		<td>${report.reportType.name}</td>
																	</tr>
																</c:forEach></c:otherwise></c:choose>
															</tbody>
														</table>
														<input type="hidden" name="user_id" value="${user.id}"/>
														</form>
													</div>
												</div>
												<!-- END PORTLET-->
											</div>
												<div class="col-lg-6 col-xs-12 col-sm-12">
												<!-- BEGIN PORTLET-->
												<div class="portlet light bordered">
													<div class="portlet-title">
														<div class="caption">
															<i class="icon-user font-dark hide"></i> <span
																class="caption-subject font-dark">管理局统计表分配</span>
														</div>
													</div>
													<div class="portlet-body">
														<div class="table-toolbar">
															<div class="row">
																<div class="col-lg-6 col-xs-12 col-sm-12">
																	<div class="clearfix">
																		<a class="btn blue" id="select_administration_report">
																			<i class="fa fa-plus"></i> 分配
																		</a>
																	</div>
																</div>
															</div>
														</div>
														<form id="select_administration_report_form" method="post">
														<table class="table table-bordered table-hover">
															<thead>
																<tr>
																	<th><span>#</span></th>
																	<th>报表名称</th>
																</tr>
															</thead>
															<tbody>
															<c:choose><c:when test="${empty administrationReportList}"><tr>
																		<td colspan="4" class="text-center">还没有可分配的报表模板</td></tr>  </c:when><c:otherwise>
																<c:forEach items="${administrationReportList}" var="administrationReport">
																	<tr>
																		<td><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
																				<input type="checkbox" class="checkboxes" name="select_administration_report_id"
																				value="${administrationReport.id}" <c:forEach items="${assignedAdministrationReports}" var="assignedAdministrationReport"><c:if test="${assignedAdministrationReport.id==administrationReport.id}">checked</c:if></c:forEach>/> <span></span>
																		</label></td>
																		<td>${administrationReport.title}</td>
																	</tr>
																</c:forEach></c:otherwise></c:choose>
															</tbody>
														</table>
														<input type="hidden" name="user_id" value="${user.id}"/>
														</form>
													</div>
												</div>
												<!-- END PORTLET-->
											</div>
										</div>
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
	<!-- BEGIN THEME GLOBAL SCRIPTS -->
	<script src="/assets/global/scripts/app.min.js" type="text/javascript"></script>
	<!-- END THEME GLOBAL SCRIPTS -->
	<!-- BEGIN THEME LAYOUT SCRIPTS -->
	<script src="/assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
	<!-- END THEME LAYOUT SCRIPTS -->
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script type="text/javascript">
	jQuery(document).ready(function() {
		$('#selectUser').click(function(){
			var select_user_ids =$.makeArray($('input[name="select_user_id"]:checked'));//定义一个数组    
			/* if(select_user_ids.length<=0){
				alert('还没有选择一个用户');
				return;
			} */
			$.ajax({
				cache : true,
    				type : "post",
    				url : "/settings/selectUsers",
    				data : $('#select_user_form').serialize(),
    				async : false,
    				dataType : "json",
    				success : function(data) {
    					if (data.code == 0) {
    						layer.msg(data.message, {icon : 1});
    					} else {
    						layer.msg(data.message, {icon : 0});
    					}
    				},	
    				error : function() {
    					layer.msg('操作异常，请稍后刷新重试', {icon : 0});
    				}
			})
			
		})
	
		$('#select_report_model').click(function(){
			$.ajax({
				cache : true,
    				type : "post",
    				url : "/settings/selectReportForm",
    				data : $('#select_report_form').serialize(),
    				async : false,
    				dataType : "json",
    				success : function(data) {
    					if (data.code == 0) {
    						layer.msg(data.message, {icon : 1});
    					} else {
    						layer.msg(data.message, {icon : 0});
    					}
    				},
    				error : function() {
    					layer.msg('操作异常，请稍后刷新重试', {icon : 0});
    				}
			})
		})
		
		$('#select_administration_report').click(function(){
			$.ajax({
				cache : true,
    				type : "post",
    				url : "/settings/selectAdministrationReport",
    				data : $('#select_administration_report_form').serialize(),
    				async : false,
    				dataType : "json",
    				success : function(data) {
    					if (data.code == 0) {
    						layer.msg(data.message, {icon : 1});
    					} else {
    						layer.msg(data.message, {icon : 0});
    					}
    				},
    				error : function() {
    					layer.msg('操作异常，请稍后刷新重试', {icon : 0});
    				}
			})
		})
		
	})
	</script>	
</body>
</html>