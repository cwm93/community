<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
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
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="/favicon.ico" />
        <style>
        body {background-color: #364150 !important;}
        .table td {padding:3px;font-size:12px;}
        .table td h5{font-weight:bold;font-size:12px;}
        </style>
    </head>
    <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
        <div class="page-wrapper">
           <jsp:include page="../common/top.jsp"></jsp:include>
            <div class="clearfix"> </div>
            <div class="page-container">
                 <jsp:include page="../common/left.jsp"></jsp:include>
                <!-- BEGIN CONTENT -->
                <div class="page-content-wrapper">
                    <div class="page-content">
                        <div class="page-bar">
                            <ul class="page-breadcrumb">
                                <li>
                                    <a href="/index">主页</a>
                                    <i class="fa fa-circle"></i>
                                </li>
                                <li>
                                    <span>系统设置</span>
                                    <i class="fa fa-circle"></i>
                                </li>
                                 <li>
                                    <span>未填写的报表列表</span>
                                </li>
                            </ul>
                        </div>
                        <!-- END PAGE BAR -->
                        <!-- END PAGE HEADER-->
                        <div class="row">
                            <div class="col-md-12">
                           <c:if test="${curUser.role.code=='SUBADMIN' || curUser.role.code=='ADMIN'}"> <ul class="table-top-tools"><li><a href="/report/under">未填写</a></li><li class="active"><span>|</span><a href="/report/deleted">已删除</a></li><li></ul></c:if>
							<table class="table table-striped table-bordered table-advance table-hover">
								<thead>
									<tr>
									    <th style="width:40%;">报表名称</th>
										<th style="width:10%;">填表人</th>
										<th style="width:10%;">报表类型</th>
										<th style="width:10%;">报表分类</th>
										<c:if test="${curUser.role.code=='SUBADMIN' || curUser.role.code=='ADMIN'}"><th style="width:10%;">操作</th></c:if>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty reportLogList}">
											<tr>
												<td colspan="5" class="text-center">暂无数据</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${reportLogList}" var="reportLog" varStatus="status">
												<tr>
													<td><c:choose><c:when test="${curUser.role.code=='USER'}"><a href="/${reportLog.report.formCode}/edit/${reportLog.id}">${reportLog.title}</a></c:when><c:otherwise>${reportLog.title}</c:otherwise></c:choose></td>
													<td>${reportLog.toUser.realname}</td>
													<td>${reportLog.report.reportKind.name}</td>
													<td>${reportLog.report.reportType.name}</td>
												   <c:if test="${curUser.role.code=='SUBADMIN' || curUser.role.code=='ADMIN'}"><td><button class="btn btn-outline red btn-sm" onclick="javascript:restore(${reportLog.id});">恢复</button></td></c:if>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
							<div style="margin:0;padding:0;">
								<ul class="pagination pagination-sm pull-right">
								   <li><a href="<%=path %>?p=1">首页
									</a></li>
								   <c:forEach items="${pager.showPageNumList}" var="pageNum" varStatus="status">
								   <c:choose>
								   <c:when test='${pager.currentPage==pageNum}'>
								   <li class="active"><a href="<%=path %>?p=${pageNum}"> ${pageNum }</a></li>
								   </c:when>
								   <c:otherwise>
								   <li><a href="<%=path %>?p=${pageNum}"> ${pageNum } </a></li>
								   </c:otherwise>
								   </c:choose>
								   </c:forEach>
									<li><a href="<%=path %>?p=${totalPage}">尾页
									</a></li>
								</ul>
							</div>
						</div>
                        </div>
                    </div>
                </div>
            </div>
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
        <script src="/assets/layer/layer.js" type="text/javascript"></script>
        <script type="text/javascript">
            var restore = function(reportLogId){
        		//询问框
				layer.confirm('您确要恢复这一条记录吗？', {
					btn : [ '确定', '取消' ]
				//按钮
					}, function() {
					$.ajax({
							type : "POST",
							url : "/reportlog/restore",
							data : {reportLogId:reportLogId},
							dataType : "json",
							success : function(data) {
								if(data.code!=0){
									layer.msg(data.message, {icon : 0});
								}else{
									layer.msg(data.message, {icon : 1});
									setTimeout(function(){
										window.location.reload();	
									},2000) 
								}
							},
							error:function(){
								layer.msg('系统异常，请稍后重试', {icon : 0});
							}
						}); 
					
					}, function() {
					layer.msg('您已取消恢复操作');
				});
            }
        </script>
    </body>

</html>