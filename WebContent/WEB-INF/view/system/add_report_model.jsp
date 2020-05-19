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
        <link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="/assets/layouts/layout/css/custom.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="/favicon.ico" /> </head>
    <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
	<div class="page-wrapper">
		<jsp:include page="../common/top.jsp"></jsp:include>
		<div class="clearfix"></div>
		<div class="page-container">
			<jsp:include page="../common/left.jsp"></jsp:include>
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<ul class="page-breadcrumb">
							<li><a href="／index">主页</a> <i class="fa fa-circle"></i></li>
							<li><span>报表模板管理</span> <i class="fa fa-circle"></i></li><li><span>编辑</span></li>
						</ul>
					</div>
					<div class="row">
						<div class="col-md-12 margin-top-15">
							<form:form class="form-horizontal profile-form" modelAttribute="report" action="/system/saveReportModel" role="form" id="reportForm" method="post">
								<c:if test="${data!=null}">
									<c:choose>
										<c:when test="${data.code==-1}">
											<div class="alert alert-danger">
												<button class="close" data-close="alert"></button>
												<span>${data.message}</span>
											</div>
										</c:when>
										<c:otherwise>
											<div class="alert alert-success">
												<button class="close" data-close="alert"></button>
												<span>${data.message}</span>
											</div>
										</c:otherwise>
									</c:choose>
								</c:if>
								<div class="form-body">
									<div class="form-group">
										<label class="col-md-3 control-label">报表名称</label>
										<div class="col-md-9">
											<input type="text"
												class="form-control input-inline input-large"
												name="title" id="title" value="${report.title}"> <span
												class="help-inline"><span class="required">*</span>必填</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">报表种类</label>
										<div class="col-md-9">
											<form:select class="form-control input-inline input-large" id="reportKind" path="reportKind.id" items="${reportKinds}" itemValue="id" itemLabel="name"></form:select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">报表分类</label>
										<div class="col-md-9">
										<form:select class="form-control input-inline input-large" id="reportType" path="reportType.id" items="${reportTypes}" itemValue="id" itemLabel="name"></form:select>
									    </div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">备注</label>
										<div class="col-md-9">
										<textarea class="form-control input-inline input-large" rows="3" name="comment">${report.comment}</textarea>
									    </div>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-offset-3 col-md-9">
										    <c:if test="${!empty report.id}"><input type="hidden" name="id" value="${report.id}" /></c:if>
											<button type="button" id="addSubmit"
												class="btn green button-submit">
												提交 <i class="fa fa-check"></i>
											</button>
											<a href="/system/reports" class="btn blue">返回列表页</a>
										</div>
									</div>
								</div>
							</form:form>
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
        <script src="/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="/assets/global/scripts/app.min.js" type="text/javascript"></script>
        <script src="/assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
        <script src="/assets/layer/layer.js" type="text/javascript"></script>
        <script type="text/javascript">
        jQuery(document).ready(function() {
        	  $("#addSubmit").click(function(){
        		  var title = $('#title').val();
        		  if(title==''||title==null){
        			  layer.msg('标题不能为空', {icon : 0});
        			  return false;
        		  }
        		  
        		  $("#reportForm").submit();
        	  })
        });
        </script>
    </body>
</html>