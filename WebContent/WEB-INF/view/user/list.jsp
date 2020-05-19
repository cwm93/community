<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                                    <a href="/index">主页</a>
                                    <i class="fa fa-circle"></i>
                                </li>
                                <li>
                                    <span>用户管理</span>
                                    <i class="fa fa-circle"></i>
                                </li>
                                 <li>
                                    <span>所有用户</span>
                                </li>
                            </ul>
                        </div>
                        <!-- END PAGE BAR -->
                        <!-- END PAGE HEADER-->
                        <div class="row">
                            <div class="col-md-12 ">
                             <ul class="table-top-tools"><li><a href="/user/list">全部（${countAll}）</a></li><li><span>|</span><a href="/user/list?status=1">已审核（${countOk}）</a></li><li><span>|</span><a href="/user/list?status=0">未审核（${countNotOk}）</a></li><li><span>|</span><a href="/user/list?status=2">已禁用（${countForbid}）</a></li></ul>
							<table class="table table-striped table-bordered table-advance table-hover" id="tablesList">
								<thead>
									<tr>
										<th style="width:10%;">姓名</th>
										<th style="width:10%;">手机号码</th>
										<th style="width:10%;">角色</th>
										<th style="width:15%;">单位</th>
										<th style="width:10%;">单位属性</th>
										<th style="width:10%;">当前状态</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>姓名</th>
										<th>手机号码</th>
										<th>角色</th>
										<th>单位</th>
										<th>单位属性</th>
										<th>当前状态</th>
									</tr>
								</tfoot>
								<tbody>
									<c:if test="${userList!=null}">
										<c:forEach items="${userList}" var="user">
											<tr>
												<td><c:choose>
														<c:when test="${user.role.code=='ADMIN'}">
															<a href="javascript:alert('超级管理员，不可编辑');" title="不可编辑">${user.realname}</a>
														</c:when>
														<c:otherwise>
															<a href="/user/${user.id}/detail">${user.realname}</a>
														</c:otherwise>
													</c:choose></td>
												<td>${user.mobile}</td>
												<td>${user.role.name}</td>
												<td>${user.company}</td>
												<td>${user.companyAttribute.name}</td>
												<td><c:choose>
														<c:when test="${user.status=='2'}">已禁用</c:when>
														<c:when test="${user.status=='1'}">已启用</c:when>
														<c:otherwise>未审核</c:otherwise>
													</c:choose></td>
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
    </body>

</html>