<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="/assets/layouts/layout/css/custom.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="/favicon.ico" />
    </head>
    <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
        <div class="page-wrapper">
           <jsp:include page="../common/top.jsp"></jsp:include>
            <div class="clearfix"> </div>
            <div class="page-container">
                 <jsp:include page="../common/left.jsp"></jsp:include>
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
                                    <span>运营商管理</span>
                                </li>
                            </ul>
                        </div>
                        <div class="row">
                            <div class="col-md-12 margin-top-15">
							<div class="actions" style="margin-bottom:8px;">
								<a href="#" class="btn btn-success mt-repeater-add"> <i
									class="fa fa-plus"></i> 新增
								</a> 
							</div>
							<table
								class="table table-striped table-bordered table-advance table-hover">
								<thead>
									<tr>
										<th style="width:15%;">运营商名称</th>
										<th style="width:75%;">备注</th>
										<th style="width:10%;">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty telecomOperators}">
											<tr>
												<td colspan="2" class="text-center">暂无可用数据</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${telecomOperators}" var="telecomOperator">
												<tr>
													<td>${telecomOperator.name}</td>
													<td>${telecomOperator.comment}</td>
													<td><a href="javascript:;">不可编辑</a></td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
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
    </body>

</html>