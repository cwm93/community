<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh-CN" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="zh-CN" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/pages/css/front.css" rel="stylesheet" type="text/css" />
<title>管局表格样式</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
			   <h3 class="title">
					上海市通信管理局<span>市场业务报表综合分析管理</span><a
						href="javascript:window.history.go(-1);"
						class="pull-right btn btn-sm btn-warning"> 返回 <i class="fa fa-undo"></i>
					</a>
				</h3>
				<h5 class="form-title">实名制-数据录入</h5>
				<form class="form-horizontal" name="form1" id="form1" role="form" action="/gj/smz/save" onsubmit="return checkForm();" enctype="multipart/form-data" method="post">
					<div class="form-group">
						<label for="firstname" class="col-sm-4 control-label">运营商</label>
						<div class="col-sm-8 form-inline">
							<select class="form-control input-xsmall">
								<option value="">请选择</option>
								<option value="1">电信</option>
								<option value="2">移动</option>
								<option value="3">联通</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-4 control-label">月份</label>
						<div class="col-sm-8 form-inline">
							<select class="form-control input-xsmall" id="selectYear">
								<option value="">请选择</option>
								<option value="2016">2016</option>
								<option value="2017">2017</option>
								<option value="2018">2018</option>
								<option value="2019">2019</option>
								<option value="2020">2020</option>
								<option value="2021">2021</option>
								<option value="2022">2022</option>
								<option value="2023">2023</option>
								<option value="2024">2024</option>
								<option value="2025">2025</option>
								<option value="2026">2026</option>
								<option value="2027">2027</option>
							</select><span style="padding: 0 15px;">年</span><select
								class="form-control input-xsmall" id="selectMonth">
								<option value="">请选择</option>
								<option value="1">01</option>
								<option value="2">02</option>
								<option value="3">03</option>
								<option value="4">04</option>
								<option value="5">05</option>
								<option value="6">06</option>
								<option value="7">07</option>
								<option value="8">08</option>
								<option value="9">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select> <span style="padding: 0 15px;">月</span>
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-4 control-label">移动电话用户总量（万）</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="firstname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">固定电话用户总量（万）</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">已登记用户数（万）</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">移动电话已登记用户数（万）</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">固定电话已登记用户数（万）</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">实名率</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">移动电话实名率</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">固定电话实名率</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">合规率</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<button type="submit" class="btn btn-primary">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function checkForm() {
			return false;
		}
	</script>
</body>
</html>