<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<meta content="上海市通信管理局-市场业务报表综合分析管理" name="description" />
<meta content="上海市通信管理局-市场业务报表综合分析管理" name="author" />
<link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
<link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/pages/css/form.css" rel="stylesheet" type="text/css" />
<style>
.entry-table{text-align:left;}
</style>
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="top-title">
					上海市通信管理局<span>市场业务报表综合分析管理</span><a
						href="javascript:window.history.go(-1);"
						class="right btn btn-sm yellow"> 返回 <i class="fa fa-undo"></i>
					</a>
				</h1>
				<h5 class="form-title">${reportLog.title}</h5>
				<div class="panel panel-warning">
					<div class="panel-body">
					    <form class="entry-form" id="form1"
					action="/hmzy/import" enctype="multipart/form-data" method="post">
					<input type="file" name="file" /> <br /> <input type="hidden"
						name="reportLogId" value="${reportLog.id}" /> <input
						type="hidden" name="userId" value="${curUser.id}" />
					<table class="entry-table">
						<tr>
							<td width="25%">填表公司：<input type="text"
								class="form-control input-sm" name="company" id="company"
								value="${curUser.company}" /></td>
							<td width="25%">填表人：<input type="text"
								class="form-control input-sm" name="username" id="username"
								value="${curUser.realname}" /></td>
							<td width="25%">联系方式：<input type="text"
								class="form-control input-sm" name="mobile" id="mobile"
								value="${curUser.mobile}" /></td>
							<td width="25%">电子邮箱： <input type="email"
								class="form-control input-sm" name="email" id="email"
								value="${curUser.email}" /></td>
						</tr>
					</table>
					本人承诺以上申报数据真实有效，有据可查！<input type="checkbox" name="accept"/><br />
					<span class="error"></span>
					<button type="submit" id="formSubmit"
						class="btn green button-submit">
						<i class="fa fa-upload"></i> <span> 提交 </span>
					</button>
				</form>
						<p>数据上传说明:<br/>
							1、请严格按照样本格式上传<span class="demo">（<a href="/assets/example/gwhmzy.xlsx">下载样本</a>）</span><br />
							2、样本单元格格式统一为文本格式<br />
							3、计算部分不需要填写，只需录入局号、区号、逻辑号码在用个数、物理号码已派个数、号码占用数目<br />
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/jquery-validation/js/localization/messages_zh.js" type="text/javascript"></script>
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script type="text/javascript">
		$.validator.setDefaults({
			submitHandler : function() {
				//询问框
				layer.confirm('您确定要提交该表单数据吗？', {
					btn : [ '确定', '取消' ]
				//按钮
				}, function() {
					form1.submit();
					layer.msg('正在提交中...', {
						  icon: 16
						  ,shade: 0.01
						});
				}, function() {
					layer.msg('您已取消提交表单数据');
				});
			}
		});
		$(document).ready(function() {
			$('#form1').validate({
				rules:{
					file: {
				        required: true,
				      },
				      accept:{
				    	required: true,
				      }
				},
			    messages: {
			    	file: {
			            required: "请选择文件"
			          },
			          accept:{
				    	required: "请勾选此项",
				      }
			    }
			});
		})
	</script>
</body>
</html>