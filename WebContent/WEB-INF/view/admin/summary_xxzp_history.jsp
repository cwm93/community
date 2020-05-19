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
.none-data{min-height: 300px; font-size: 16px;text-align: center; line-height: 300px;margin:0;padding:0;width:100%;}</style>
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
								<h3 style="font-size: 16px; margin: 0; padding: 0;">报表汇总</h3>
							</li>
						</ul>
					</div>
					<!-- END PAGE BAR -->
					<!-- END PAGE HEADER-->
					<div class="row">
						<div class="col-md-12">
							<h3 class="text-center"
								style="padding: 0; margin: 0; font-size: 14px; line-height: 32px;">${report.title}</h3>
							<div class="panel panel-default">
								<div class="panel-heading form-inline">
									<select class="form-control input-xsmall" id="selectYear">
									    <option value="">请选择</option>
										<option value="2017" selected>2017</option>
									</select><span style="padding: 0 15px;">年</span><select
										class="form-control input-xsmall" id="selectWeek">
										<option value="">请选择</option>
										<c:forEach var="i" begin="1" end="27" step="1">
										<option value="${i}" <c:if test="${i==27}">selected</c:if>>${i}</option>
										</c:forEach>
									</select> <span style="padding: 0 15px;">周</span>
									<input type="hidden" id="reportId" value="${report.id}">
									<button class="btn blue" id="searchData">查询</button>
									<a class="btn blue" href="/summary/xxzp">查询最新数据</a>
								</div>
								<div class="panel-body" id="dataContent">
								    <div class="none-data"></div>
								</div>
								<div class="panel-body" style="border-top:1px solid #f0f0f0;padding-top:20px;">
									<form role="form">
										<div class="form-body">
											<div class="form-group">
												<label class="control-label">备注</label>
												<textarea class="form-control" rows="3" id="remarkContext"></textarea>
												<input type="hidden" id="remark_id" value="0">
												<span class="help-inline" id="info">备注内容可追加</span>
											</div>
											<button type="button" class="btn btn-primary" id="submitRemark">提交</button>
										</div>
									</form>
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
	<jsp:include page="../common/footerJs.jsp"></jsp:include>
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script type="text/javascript" src="/assets/apps/data/xxzpJson_history.js"></script>
</body>
</html>