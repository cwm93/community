<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh-CN" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="zh-CN" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh-CN">
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<title>上海市通信管理局-市场业务报表综合分析管理</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="上海市通信管理局-市场业务报表综合分析管理" name="description" />
<meta content="上海明兹信息科技有限公司技术支持" name="author" />
<link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
<link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/pages/css/login.css" rel="stylesheet" type="text/css" />
<style>
.login .login-title {
	margin: 0;
	padding: 0;
	text-align: center;
}

.login .login-title h2 {
	color: #FFF;
	font-size: 28px;
}

.login .login-title h3 {
	color: red;
	font-size: 16px;
}

.code-input {
	width: 180px;
	border: border: none;
	background-color: #dde3ec;
	height: 43px;
	color: #8290a3;
	border: 1px solid #dde3ec;
	padding: 0 9px;
}

.code-input:focus, .code-input:active , .code-input:hover{
	border: 1px solid #dde3ec;outline:none;
}

.code-input::-moz-placeholder {
	color: #8290a3;
	opacity: 1;
}

.code-input:-ms-input-placeholder {
	color: #8290a3;
}

.code-input::-webkit-input-placeholder {
	color: #8290a3;
}

.code-btn {
	width: 155px;
	height: 43px;
	background-color: #ffffff;
	border: 1px solid #dde3ec;
}
.code-form-group{margin-bottom:0;padding-bottom:0;}
</style>
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body class="login">
	<div class="login-title">
		<h2>上海市通信管理局</h2>
		<h3>市场业务报表综合分析管理</h3>
	</div>
	<div class="content">
		<form class="login-form">
			<h3 class="form-title font-green">登录系统</h3>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">手机号码</label> <input class="form-control form-control-solid placeholder-no-fix" type="text" placeholder="手机号码" id="mobile" />
			</div>
			<div class="form-group code-form-group">
				<label class="control-label visible-ie8 visible-ie9">短信验证码</label> <input class="code-input" type="text" placeholder="短信验证码" id="smsCode" /> <input class="code-btn" type="button" value="点击获取" />
			</div>
			<div class="form-actions">
			    <input type="hidden" name="sms" value="1">
			    <input type="hidden" name="token" value="${token}">
				<button type="button" class="btn green btn-block submit-btn">登录</button>
			</div>
			<div class="create-account">
				<p>
					<a href="javascript:;" id="register-btn">注册新账号</a>
				</p>
			</div>
		</form>
	</div>
	<div class="copyright">2019 © 上海市通信管理局 <span style="padding-left:35px;">沪ICP备05000001号-7</span></div>
	<!--[if lt IE 9]>
		<script src="/assets/global/plugins/respond.min.js"></script>
		<script src="/assets/global/plugins/excanvas.min.js"></script> 
		<script src="/assets/global/plugins/ie8.fix.min.js"></script> 
	<![endif]-->
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){ 
			function sendCode(){
				var mobile = $('#mobile').val();
				if(!(/^1[3|4|5|7|8][0-9]\d{8,8}$/.test(mobile))){ 
					layer.msg("输入的手机格式不正确", {icon : 0});  
			        return ; 
			    } 
				$.ajax({
					type : "POST",
					url : "/sendCode",
					data : {mobile:mobile},
					dataType : "json",
					success : function(data) {
						if (data.code == 0) {
							layer.msg(data.msg, {icon : 1});
						} else {
							layer.msg(data.msg, {icon : 0});
						}
					},
					error : function() {
						layer.msg('操作异常，请稍后刷新重试', {icon : 0});
					}
				})
			}
			function timerSec(){
				$('.code-btn').attr("disabled", true);
				$('.code-btn').val('重新获取(60秒)');
				var sec = 60;
				var timer = setInterval(function(){
					sec--;
					$('.code-btn').val('重新获取('+sec+'秒)');
					if(sec < 1){
						$('.code-btn').attr("disabled", false);
						$('.code-btn').val('重新获取');
						clearInterval(timer);
					}
				},1000);
			}
			$('.code-btn').click(function(event){
				event.preventDefault();
				var mobile = $('#mobile').val();
				if(!(/^1[3|4|5|7|8][0-9]\d{8,8}$/.test(mobile))){ 
					layer.msg("输入的手机格式不正确", {icon : 0});  
			        return false; 
			    } 
				timerSec();
				sendCode();
			})
			$('.submit-btn').click(function(event){
				event.preventDefault();
				var mobile = $('#mobile').val();
				var smsCode = $('#smsCode').val();
				if(!mobile){
					layer.msg('请输入手机号码', {icon : 0});
					return ;
				}
				if(!(/^1[3|4|5|7|8][0-9]\d{4,8}$/.test(mobile))){ 
					layer.msg("输入的手机格式不正确", {icon : 0});  
			        return ; 
			    } 
				if(!smsCode){
					layer.msg('请输入验证码', {icon : 0});
					return ;
				}
				$.ajax({
					type : "POST",
					url : "/smsLogin",
					data : {mobile:mobile,smsCode:smsCode},
					dataType : "json",
					success : function(data) {
						if (data.code == 0) {
							layer.msg(data.msg, {icon : 1});
							setTimeout(function(){
								window.location.href=data.url;
							},2000);
						} else {
							layer.msg(data.msg, {icon : 0});
						}
					},
					error : function() {
						layer.msg('操作异常，请稍后刷新重试', {icon : 0});
					}
				})
			})
		})
	</script>
</body>
</html>