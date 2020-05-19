<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh-CN" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="zh-CN" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<title>管局表格样式</title>
</head>
<body>
	<div class="container" style="width:780px;margin-top:50px;border:1px solid #f0f0f0;padding:20px;">
		<div class="row">
			<div class="col-sm-12">
				<form class="form-horizontal" role="form" action="/administration/save" method="post">
					<div class="form-group">
						<label for="firstname" class="col-sm-4 control-label">标题</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="title" required>
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">代码</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="code" required>
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">备注</label>
						<div class="col-sm-8">
							<textarea class="form-control" name="comment"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<button type="submit" class="btn btn-default">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>