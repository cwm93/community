<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="/assets/layouts/layout/css/custom.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="/favicon.ico" />
        <style>
        body {background-color: #364150 !important;}
        .table {border-collapse:collapse;width:100%;}
        .table > tbody > tr > td{vertical-align:middle;}
        .undo-status{border:1px solid #555;color:#333;font-size:12px;padding:5px;;}
        .success-status{border:1px solid #36c6d3;color:#36c6d3;font-size:12px;padding:5px;}
        .redo-status{border:1px solid #ed6b75;color:#ed6b75;font-size:12px;padding:5px;}
        </style>
    </head>
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
							<li><a href="/index">主页</a> <i class="fa fa-circle"></i></li>
							<li><span>系统设置</span> <i class="fa fa-circle"></i></li>
							<li><span>历史报表列表</span></li>
						</ul>
					</div>
					<!-- END PAGE BAR -->
					<!-- END PAGE HEADER-->
					<div class="row">
						<div class="col-md-12 margin-top-15 ">
						    <div class="tabbable-line">
							<ul class="nav nav-tabs">
								<li <c:if test="${empty audit}">class='active'</c:if>><a href="/report/history">全部</a></li>
								<li <c:if test="${audit=='0'}">class='active'</c:if>><a href="/report/history?p=1&audit=0">未审核</a></li>
								<li <c:if test="${audit=='2'}">class='active'</c:if>><a href="/report/history?p=1&audit=2">已退回</a></li>
								<li <c:if test="${audit=='1'}">class='active'</c:if>><a href="/report/history?p=1&audit=1">审核通过</a></li>
							</ul>
							
							<div class="tab-content">
                                 <div class="tab-pane active">
							<table class="table table-striped table-bordered table-advance table-hover">
								<thead>
									<tr>
										<th style="width: 35%;">报表名称</th>
										<th style="width: 10%;">填表人</th>
										<th style="width: 10%;">报表类型</th>
										<th style="width: 15%;">报表分类</th>
										<th style="width: 15%;">审核状态</th>
										<th style="width: 15%;">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty reportLogList}">
											<tr>
												<td colspan="6" class="text-center">暂无数据</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${reportLogList}" var="reportLog" varStatus="status">
												<tr>
													<td><a href="/${reportLog.report.formCode}/view/${reportLog.id}">${reportLog.title}</a></td>
													<td>${reportLog.toUser.realname}</td>
													<td>${reportLog.report.reportKind.name}</td>
													<td>${reportLog.report.reportType.name}</td>
													<td><c:if test="${reportLog.auditStatus=='0'}"><span class="undo-status">未审核</span></c:if>
														<c:if test="${reportLog.auditStatus=='1'}"><span class="success-status">已通过</span></c:if> <c:if
															test="${reportLog.auditStatus=='2'}"><span class="redo-status">已退回</span><c:if test="${!empty reportLog.auditReason}"><p>${reportLog.auditReason}</p></c:if></c:if></td>
													<td><c:if test="${curUser.role.code=='USER'}">无操作</c:if>
														<c:if test="${curUser.role.code=='SUBADMIN' || curUser.role.code=='ADMIN'}">
															<div class="btn-group">
																<button type="button" class="btn btn-outline green btn-sm" onclick="javascript:audit(this,'${reportLog.id}',1);">通过</button>
																<button type="button" class="btn btn-outline red btn-sm" onclick="javascript:audit(this,'${reportLog.id}',2);">退回</button>
															</div>
														</c:if></td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
							<div style="margin:0;padding:0;">
								<ul class="pagination pagination-sm pull-right">
								   <li><a href="<%=path %>?p=1&audit=${audit}">首页
									</a></li>
								   <c:forEach items="${pager.showPageNumList}" var="pageNum" varStatus="status">
								   <c:choose>
								   <c:when test='${pager.currentPage==pageNum}'>
								   <li class="active"><a href="<%=path %>?p=${pageNum}&audit=${audit}"> ${pageNum }</a></li>
								   </c:when>
								   <c:otherwise>
								   <li><a href="<%=path %>?p=${pageNum}&audit=${audit}"> ${pageNum } </a></li>
								   </c:otherwise>
								   </c:choose>
								   </c:forEach>
									<li><a href="<%=path %>?p=${totalPage}&audit=${audit}">尾页
									</a></li>
								</ul>
							</div>
							</div></div></div>
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
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/assets/global/scripts/app.min.js" type="text/javascript"></script>
	<script src="/assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
	<c:if test="${curUser.role.code=='SUBADMIN' || curUser.role.code=='ADMIN'}">
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<div class="modal fade" id="confirmForm" role="basic" aria-hidden="true" style="font-size: 12px;">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
						<h4 class="modal-title" id="modelTitle"></h4>
					</div>
					<div class="modal-body clearfix">
						<form name="form1" id="form1" role="form">
							<div class="form-group" id="showAuditReason">
								<label class="control-label">备注（退回原因描述）：</label>
								<textarea class="form-control" rows="3" cols="5" id="auditReason"></textarea>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<input type="hidden" class="form-control" id="reportLogId" value="0">
									<input type="hidden" class="form-control" id="status" value="0">
									<button type="button" class="btn btn-primary" id="submitBtn">确定</button>
									<button type="reset" class="btn btn-warning" data-dismiss="modal">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal -->
	<script type="text/javascript">
    		function audit(obj,reportLogId,status){
    			var yesOrNo = '';
    			if(status==1){
    				yesOrNo = '通过';
    				$('#showAuditReason').hide();
    			}else{
    				yesOrNo = '退回';
    				$('#showAuditReason').show();
    			}
    			var modelTitle = '确定'+yesOrNo+'这条记录吗？';
    			$('#modelTitle').html(modelTitle);
    			$('#reportLogId').val(reportLogId);
    			$('#status').val(status);
    			$('#confirmForm').modal('show');  
        }
    
    		$('#submitBtn').click(function(){
    			var reportLogId = $('#reportLogId').val();
    			var status = $('#status').val();
    			var auditReason = $('#auditReason').val();
   	 		$.ajax({
				cache : true,
				type : "post",
				url : "/report/audit",
				data : {auditReason:auditReason,status:status,reportLogId:reportLogId},
				async : false,
				dataType : "json",
				success : function(data) {
			   		if (data.code == 0) {
			   			$('#confirmForm').modal('hide'); 
						layer.msg(data.message, {icon: 1});
						setTimeout(function(){
							//window.location.reload();
						},3000);
					} else {
						layer.msg(data.message, {icon: 2});
						setTimeout(function(){
							//window.location.reload();
						},3000);
					} 
				},
				error : function() {
				 	layer.msg('系统错误', {icon: 2});
				}
			})
   		})
	</script>
		
	</c:if>
</body>
</html>