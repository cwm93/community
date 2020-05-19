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
<style type="text/css">
.details{position:absolute;margin:0;padding:0;left:0;top:0px;}
.details .desc p{text-align:left;padding:3px 3px 0 32px;font-size:8px;font-weight:bold;}
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
							<li>
								<h3 style="font-size: 16px; margin: 0; padding: 0;">管理处统计表</h3>
							</li>
						</ul>
					</div>
					<!-- END PAGE BAR -->
					<!-- END PAGE HEADER-->
					<div class="row">
						<div class="col-md-12" style="margin-top:30px;">
						    <c:choose><c:when test="${empty administrationReportList}">
						    		<div style="height:150px;line-height:150px;text-align:center;border:1px solid #f0f0f0;">当前您没有分配到任何管理处统计表</div>
						    </c:when><c:otherwise>
						    <c:forEach items="${administrationReportList}" var="administrationReport" varStatus="status">
								<div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
									<a href="/administration/${administrationReport.code}">
										<div class="dashboard-stat dashboard-stat-v1 <c:if test='${status.index%5==0}'>purple</c:if> <c:if test='${status.index%5==1}'>blue</c:if> <c:if test='${status.index%5==2}'>red</c:if> <c:if test='${status.index%5==3}'>green</c:if> <c:if test='${status.index%5==4}'>yellow</c:if>">
											<div class="visual">
												<i class="fa fa-bar-chart-o"></i>
											</div>
											<div class="details">
												 <div class="desc">
													<p style="font-size:10px;">${administrationReport.title}</p>
												</div>
											</div>
										</div>
									</a>
								</div>
							</c:forEach>
						    </c:otherwise></c:choose>
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
	<script src="/assets/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="/assets/global/scripts/app.min.js" type="text/javascript"></script>
	<script src="/assets/layouts/layout/scripts/layout.min.js"
		type="text/javascript"></script>
</body>
</html>