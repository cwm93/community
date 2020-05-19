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
        <meta content="上海明兹信息科技有限公司" name="author" />
        <link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <link href="/assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN PAGE LEVEL STYLES -->
        <link href="/assets/pages/css/login.css" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL STYLES -->
        <style>
        .login .login-title{margin:0;padding:0;text-align:center;}
        .login .login-title h2{color:#FFF;font-size:28px;}
        .login .login-title h3{color:red;font-size:16px;}
        </style>
        <link rel="shortcut icon" href="/favicon.ico" /> </head>
    <!-- END HEAD -->

    <body class="login">
        <!-- BEGIN LOGO -->
        <div class="login-title">
            <h2>上海市通信管理局</h2>
            <h3>市场业务报表综合分析管理</h3>
        </div>
        <!-- END LOGO -->
        <!-- BEGIN LOGIN -->
        <div class="content">
            <!-- BEGIN REGISTRATION FORM -->
            <form:form class="register-form" action="/register" id="registerForm" method="post" commondName="user">
                <h3 class="font-green">注册新账号</h3>
                <div class="alert alert-danger display-hide">
                    <button class="close" data-close="alert"></button>
                    <span id="errMsg">信息填写不完整 </span>
                </div>
                <p class="hint">输入您的个人信息：</p>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">姓名</label>
                    <input class="form-control placeholder-no-fix" type="text" placeholder="姓名" name="realname" /> </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">单位名称</label>
                    <input class="form-control placeholder-no-fix" type="text" placeholder="单位名称" name="company" /> </div>  
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">运营商</label>
                    <select name="telecomOperator" class="form-control">
                        <option value="">...选择运营商...</option>
                       <c:forEach items="${telecomOperatorList}" var="telecomOperator">
                       <option value="${telecomOperator.id}">${telecomOperator.name}</option>
                       </c:forEach>
                    </select>
                </div>      
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">单位属性</label>
                    <select name="companyAttribute" class="form-control">
                        <option value="">...选择单位属性...</option>
                         <c:forEach items="${companyAttributeList}" var="companyAttribute">
                       <option value="${companyAttribute.id}">${companyAttribute.name}</option>
                       </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                    <label class="control-label visible-ie8 visible-ie9">职务</label>
                    <input class="form-control placeholder-no-fix" type="text" placeholder="职务" name="position" /> </div>
                <div class="form-group">
                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                    <label class="control-label visible-ie8 visible-ie9">手机号码</label>
                    <input class="form-control placeholder-no-fix" type="text" placeholder="手机号码（用于登录）" name="mobile" /> </div>
                <div class="form-group">
                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                    <label class="control-label visible-ie8 visible-ie9">邮箱</label>
                    <input class="form-control placeholder-no-fix" type="text" placeholder="邮箱" name="email" /> </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">地址</label>
                    <input class="form-control placeholder-no-fix" type="text" placeholder="地址" name="address" /> </div>
                     <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">身份证号码</label>
                    <input class="form-control placeholder-no-fix" type="text" placeholder="身份证号码" name="idCardNumber" /> </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">固定电话</label>
                    <input class="form-control placeholder-no-fix" type="text" placeholder="固定电话" name="telephone" /> </div>
              
                <p class="hint">请输入您的账号信息： </p>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">密码</label>
                    <input class="form-control placeholder-no-fix" type="password" autocomplete="off" id="register_password" placeholder="密码" name="password" /> </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">确认密码</label>
                    <input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="确认密码" name="rpassword" /> </div>
                <div class="form-actions">
                    <button type="submit" id="register-submit-btn" class="btn btn-success uppercase">注册</button>
                    <button type="button" id="register-back-btn" class="btn green btn-outline pull-right">返回登录</button>
                </div>
            </form:form>
            <!-- END REGISTRATION FORM -->
        </div>
        <div class="copyright"> 2019 © 上海市通信管理局 <span style="padding-left:35px;">沪ICP备05000001号-7</span> </div>
        <!--[if lt IE 9]>
<script src="/assets/global/plugins/respond.min.js"></script>
<script src="/assets/global/plugins/excanvas.min.js"></script> 
<script src="/assets/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->
        <!-- BEGIN CORE PLUGINS -->
        <script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <script src="/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="/assets/global/scripts/app.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script src="/assets/apps/scripts/login.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <!-- END THEME LAYOUT SCRIPTS -->
    </body>

</html>