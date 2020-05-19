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
.details .desc p{text-align:left;padding:3px 3px 0 32px;font-size:12px;font-weight:bold;}
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
								<h3 style="font-size: 16px; margin: 0; padding: 0;">报表汇总</h3>
							</li>
						</ul>
					</div>
					<!-- END PAGE BAR -->
					<!-- END PAGE HEADER-->
					<div class="row">
						<div class="col-md-12" style="margin-top:30px;">
							<c:forEach items="${reportList}" var="report" varStatus="status">
							   <c:if test="${report.formCode!='wlwhd' ||report.formCode!='zsqysmz' ||report.formCode!='xswdxx'}">
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
									<a href="/summary/${report.formCode}" style="display:block;">
										<div class="dashboard-stat dashboard-stat-v1 <c:if test='${status.index%5==0}'>purple</c:if> <c:if test='${status.index%5==1}'>blue</c:if> <c:if test='${status.index%5==2}'>red</c:if> <c:if test='${status.index%5==3}'>green</c:if> <c:if test='${status.index%5==4}'>yellow</c:if>">
											<div class="visual">
												<i class="fa fa-bar-chart-o"></i>
											</div>
											<div class="details">
												<div class="desc">
													<p>${report.title}</p>
												</div>
											</div>
										</div>
									</a>
								</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
					<div class="row">
					<div class="col-md-12">
							<table class="table table-striped table-bordered table-advance table-hover" id="tablesList">
								<thead>
									<tr>
										<th style="width: 10%;">管理员</th>
										<th style="width: 35%;">备注内容</th>
										<th style="width: 30%;">报表名称</th>
										<th style="width: 10%;">最后更新时间</th>
										<th style="width: 15%;">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${reportRemarkList!=null}">
										<c:forEach items="${reportRemarkList}" var="reportRemark">
											<tr>
												<td>${reportRemark.userName}</td>
												<td>${reportRemark.remarkContent}</td>
												<td>${reportRemark.report.title}_${reportRemark.year}年<c:if test="${!(empty reportRemark.month)}">${reportRemark.month}月</c:if><c:if test="${!(empty reportRemark.week)}">第${reportRemark.week}周</c:if></td>
												<td><fmt:formatDate value="${reportRemark.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
												<td><button type="button" class="btn btn-info btn-sm" onclick="javascript:editRemark(${reportRemark.id});"><i class="fa fa-edit"></i>编辑</button>
												<button type="button" class="btn btn-danger btn-sm" onclick="javascript:deleteRemark(${reportRemark.id});"><i class="fa fa-times"></i>删除</button></td>
											</tr>
										</c:forEach>
									</c:if>
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
	<div class="modal fade" id="remarkModal" tabindex="-1" role="basic" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			    <form class="form-horizontal" name="form1" id="form1" role="form" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title">编辑报表备注</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label class="col-sm-3 control-label">备注内容</label>
						<div class="col-sm-9">
						    <input type="hidden" id="remarkId">
						    <textarea class="form-control" id="remarkContent"></textarea>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn dark btn-outline" data-dismiss="modal">关闭</button>
					<button type="button" class="btn green" onclick="javascript:submitAction();">保存</button>
				</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
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
        <script src="/assets/layer/layer.js" type="text/javascript"></script>
        <script type="text/javascript" src="/assets/apps/data/summary_index.js"></script>
        <!-- END THEME LAYOUT SCRIPTS -->
</body>
</html>