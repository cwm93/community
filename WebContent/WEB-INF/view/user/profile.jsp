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
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="/assets/layouts/layout/css/custom.css" rel="stylesheet" type="text/css" />
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="/favicon.ico" /> </head>
    <!-- END HEAD -->

    <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
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
									<li class="active"><a href="#tab_1_1_1" data-toggle="tab">
											个人资料 </a></li>
									<li><a href="#tab_1_1_2" data-toggle="tab"> 修改密码 </a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="tab_1_1_1">
										<form:form class="form-horizontal profile-form" modelAttribute="user" action="/user/profile" role="form" id="profileForm" method="post">
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
                                                    <label class="col-md-3 control-label">姓名</label>
                                                    <div class="col-md-9">
                                                        <input type="text" class="form-control input-inline input-medium" name="realname" value="${user.realname}" disabled>
                                                        <span class="help-inline">不可编辑</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">单位名称</label>
                                                    <div class="col-md-9">
                                                       <input type="text" class="form-control input-inline input-medium" name="company" value="${user.company}" disabled>
                                                        <span class="help-inline">不可编辑</span>
                                                    </div>
                                                </div>
                                                 <div class="form-group">
                                                    <label class="col-md-3 control-label">单位属性</label>
                                                    <div class="col-md-9">
														<form:select class="form-control input-inline input-medium" id="companyAttribute" path="companyAttribute.id" items="${companyAttributes}" itemValue="id" itemLabel="name"> </form:select> <span class="help-inline">不可编辑</span>
													</div>
                                                </div>
                                                 <div class="form-group">
                                                    <label class="col-md-3 control-label">运营商</label>
                                                    <div class="col-md-9">
                                                       <form:select class="form-control input-inline input-medium" id="telecomOperator" path="telecomOperator.id" items="${telecomOperatorList}" itemValue="id" itemLabel="name" disabled="true">
                                                       
                                                       </form:select>
                                                     
                                                        <span class="help-inline">不可编辑</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">职务</label>
                                                    <div class="col-md-9">
                                                       <input type="text" class="form-control input-inline input-medium" name="position" value="${user.position}">
                                                        <span class="help-inline"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">手机号码</label>
                                                    <div class="col-md-9">
                                                       <input type="text" class="form-control input-inline input-medium" name="mobile" value="${user.mobile}" disabled>
                                                        <span class="help-inline">登陆账号，不可编辑</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">电子邮箱</label>
                                                    <div class="col-md-9">
                                                       <input type="text" class="form-control input-inline input-medium" name="email" value="${user.email}">
                                                        <span class="help-inline"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">地址</label>
                                                    <div class="col-md-9">
                                                     <input type="text" class="form-control input-inline input-medium" name="address" value="${user.address}">
                                                        <span class="help-inline"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">身份证号码</label>
                                                    <div class="col-md-9">
                                                        <input type="text" class="form-control input-inline input-medium" name="idCardNumber" value="${user.idCardNumber}">
                                                        <span class="help-inline"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">固定电话</label>
                                                    <div class="col-md-9">
                                                        <input type="text" class="form-control input-inline input-medium" name="telephone" value="${user.telephone}">
                                                        <span class="help-inline"></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-actions">
                                                <div class="row">
                                                    <div class="col-md-offset-3 col-md-9">
                                                        <button type="submit" id="profileSubmit" class="btn green button-submit"> 更新个人资料
                                                                <i class="fa fa-check"></i></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form:form>
									</div>
									<div class="tab-pane" id="tab_1_1_2">
										<form class="form-horizontal password-form" action="/user/changePassword"  id="passwordForm" method="POST">
                                            <div class="form-wizard">
                                                <div class="form-body">
                                                    <div class="tab-content">
                                                        <div class="tab-pane active">
                                                            <div class="form-group">
                                                                <label class="control-label col-md-3">旧密码
                                                                    <span class="required"> * </span>
                                                                </label>
                                                                <div class="col-md-9">
                                                                    <input type="password" class="form-control input-inline input-medium" name="oldpassword" />
                                                                </div>
                                                            </div>
                                                             <div class="form-group">
                                                                <label class="control-label col-md-3">新密码
                                                                    <span class="required"> * </span>
                                                                </label>
                                                                <div class="col-md-9">
                                                                    <input type="password" class="form-control input-inline input-medium" name="newpassword" id="newpassword"/>
                                                                </div>
                                                            </div>
                                                             <div class="form-group">
                                                                <label class="control-label col-md-3">确认密码
                                                                    <span class="required"> * </span>
                                                                </label>
                                                                <div class="col-md-9">
                                                                    <input type="password" class="form-control input-inline input-medium" name="rnewpassword" />
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-actions">
                                                    <div class="row">
                                                        <div class="col-md-offset-3 col-md-9">
                                                            <button type="submit" class="btn green button-submit"> 提交
                                                                <i class="fa fa-check"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
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
        <script src="/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="/assets/global/scripts/app.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="/assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
        <!-- END THEME LAYOUT SCRIPTS -->
        <script src="/assets/layer/layer.js" type="text/javascript"></script>
        <script src="/assets/apps/scripts/profile.js" type="text/javascript"></script>
    </body>

</html>