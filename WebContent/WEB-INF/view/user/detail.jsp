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
			<!-- BEGIN CONTENT -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<ul class="page-breadcrumb">
							<li><a href="／index">主页</a> <i class="fa fa-circle"></i></li>
							<li><span>个人资料</span></li>
						</ul>
					</div>
					<div class="row">
						<div class="col-md-12 margin-top-15">
							<div class="tabbable-custom">
								<ul class="nav nav-tabs">
									<li class="active"><a href="/user/${user.id}/datail">
											个人资料 </a></li>
									<c:if test="${user.role.code!='USER'}">
									<li><a href="/user/${user.id}/privilege"> 权限设置 </a></li></c:if>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active">
										<form class="form-horizontal profile-form" modelAttribute="user" action="/user/detail/update" role="form" id="profileForm" method="post">
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
                                                    <label class="col-md-3 control-label">审核状态</label>
                                                    <div class="col-md-9">
                                                      <select class="form-control input-inline input-medium" name="status">
                                                              <c:choose><c:when test="${user.status==0}"><option value="0" selected>未审核账号</option></c:when><c:otherwise><option value="0">未审核账号</option></c:otherwise></c:choose>
															 <c:choose><c:when test="${user.status==1}"><option value="1" selected>启用账号</option></c:when><c:otherwise><option value="1">启用账号</option></c:otherwise></c:choose>
															 <c:choose><c:when test="${user.status==2}"><option value="2" selected>禁用账号</option></c:when><c:otherwise><option value="2">禁用账号</option></c:otherwise></c:choose>
														</select>
														<span class="help-inline">仅管理员可编辑</span>
                                                    </div>
                                                </div>
                                                 <div class="form-group">
                                                    <label class="col-md-3 control-label">角色</label>
                                                    <div class="col-md-9">
                                                       <form:select class="form-control input-inline input-medium" id="role" path="user.role.id" items="${roles}" itemValue="id" itemLabel="name"> </form:select>
                                                        <span class="help-inline">可编辑</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">姓名</label>
                                                    <div class="col-md-9">
                                                        <input type="text" class="form-control input-inline input-medium" name="realname" value="${user.realname}">
                                                        <span class="help-inline">仅管理员可编辑</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">单位名称</label>
                                                    <div class="col-md-9">
                                                       <input type="text" class="form-control input-inline input-medium" name="company" value="${user.company}">
                                                        <span class="help-inline">仅管理员可编辑</span>
                                                    </div>
                                                </div>
                                                 <div class="form-group">
                                                    <label class="col-md-3 control-label">单位属性</label>
                                                    <div class="col-md-9">
														<form:select class="form-control input-inline input-medium" id="companyAttribute" path="user.companyAttribute.id" items="${companyAttributes}" itemValue="id" itemLabel="name"> </form:select> <span class="help-inline">不可编辑</span>
													</div>
                                                </div>
                                                 <div class="form-group">
                                                    <label class="col-md-3 control-label">运营商</label>
                                                    <div class="col-md-9">
                                                       <form:select class="form-control input-inline input-medium" id="telecomOperator" path="user.telecomOperator.id" items="${telecomOperatorList}" itemValue="id" itemLabel="name" disabled="true"> </form:select>
                                                        <span class="help-inline">不可编辑</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">职务</label>
                                                    <div class="col-md-9">
                                                       <input type="text" class="form-control input-inline input-medium" name="position" value="${user.position}">
                                                        <span class="help-inline">可编辑</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">手机号码</label>
                                                    <div class="col-md-9">
                                                       <input type="text" class="form-control input-inline input-medium" name="mobile" value="${user.mobile}" disabled>
                                                        <span class="help-inline">登陆账号唯一，不可编辑</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">电子邮箱</label>
                                                    <div class="col-md-9">
                                                       <input type="text" class="form-control input-inline input-medium" name="email" value="${user.email}">
                                                        <span class="help-inline">可编辑</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">地址</label>
                                                    <div class="col-md-9">
                                                     <input type="text" class="form-control input-inline input-medium" name="address" value="${user.address}">
                                                        <span class="help-inline">可编辑</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">身份证号码</label>
                                                    <div class="col-md-9">
                                                        <input type="text" class="form-control input-inline input-medium" name="idCardNumber" value="${user.idCardNumber}">
                                                        <span class="help-inline">可编辑</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">固定电话</label>
                                                    <div class="col-md-9">
                                                        <input type="text" class="form-control input-inline input-medium" name="telephone" value="${user.telephone}">
                                                        <span class="help-inline">可编辑</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-actions">
                                                <div class="row">
                                                    <div class="col-md-offset-3 col-md-9">
                                                       <input type="hidden" name="id" value="${user.id}"/>
                                                        <button type="submit" id="profileSubmit" class="btn green button-submit"> 更新个人资料
                                                                <i class="fa fa-check"></i></button>
                                                       <a href="/user/list" class="btn blue">返回列表页</a> 
                                                       <c:if test="${curUser.role.code=='ADMIN'}">
									                  <a class="btn btn-danger" href="javascript:resetPassword('${user.id}');">重置密码(默认：abc@123)</a></c:if>        
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
        <script src="/assets/apps/scripts/profile.js?v=1.0" type="text/javascript"></script>
    </body>

</html>