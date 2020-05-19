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
				<h3 class="title">上海市通信管理局<span>市场业务报表综合分析管理</span><a href="javascript:window.history.go(-1);" class="pull-right btn btn-sm btn-warning"> 返回 <i class="fa fa-undo"></i></a>
				</h3>
				<h5 class="form-title">增值电信业务统计分析（含自贸区）-数据导入</h5>
				<form class="form-horizontal" name="form1" id="form1" role="form"
					action="/gj/telecomValueAdded/save" onsubmit="return checkForm();"
					enctype="multipart/form-data" method="post">
					<div class="form-inline">
						<select class="form-control input-xsmall" name="selectYear" id="selectYear">
							<option value="">请选择</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
							<option value="2019">2019</option>
							<option value="2020">2020</option>
							<option value="2021">2021</option>
							<option value="2022">2022</option>
						</select><span style="padding: 0 15px;">年</span><select
							class="form-control input-xsmall" name="selectMonth" id="selectMonth">
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
					<div class="form-group">
						<div class="col-sm-12">
							<div class="file">
								<span id="showFileName">请点击选择一个excel文件</span> <input type="file"
									name="file" onChange="showInfo(this);">
							</div>
							<span class="help"></span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-primary">
								<i class="fa fa-upload"></i> <span> 导入 </span>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function checkForm() {
			var file = document.form1.file.value;
			if (file != '') {
				return true;
			} else {
				alert('请选择要导入的excel文件');
			}
			
			return false;
		}

		function getFileName(obj) {
			var pos = obj.value.lastIndexOf("/") * 1;
			return obj.value.substring(pos + 1);
		}

		function getFileExt(obj) {
			return obj.value.replace(/.+./, "");
		}

		function showInfo(obj) {
			var filename = getFileName(obj);
			var fileext = getFileExt(obj);
			if (fileext != null) {
				document.getElementById("showFileName").innerText = filename
						+ fileext;
			} else {
				document.getElementById("showFileName").innerText = '请点击选择一个excel文件';
			}
		}
	</script>
</body>
</html>