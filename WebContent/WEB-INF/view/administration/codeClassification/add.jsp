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
				<h5 class="form-title">码号统计-数据导入</h5>
				<form class="form-horizontal" name="form1" id="form1" role="form" action="/codeclass/save" onsubmit="return checkForm();" enctype="multipart/form-data" method="post">
					<div class="form-group form-inline">
					    <div class="col-sm-12">
						<select class="form-control input-xsmall" name="selectYear">
							<option value="">请选择</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
							<option value="2019">2019</option>
							<option value="2020">2020</option>
							<option value="2021">2021</option>
							<option value="2022">2022</option>
						</select><span style="padding: 0 15px;">年</span><select
							class="form-control input-xsmall" name="selectMonth">
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
					</div></div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="file">
								<span id="showFileName">请点击选择一个excel文件</span> <input type="file" name="file" onChange="showInfo(this);">
							</div>
							<span class="help"></span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-primary"><i class="fa fa-upload"></i> <span> 导入 </span></button>
						</div>
					</div>
					<p>友情提示：1、表格内容请全部设置为文本格式（<a href="/assets/example/code.xlsx">样例</a>）<br/><span style="padding-left:70px;"></span>2、上传文件处理可能很慢，提交后请耐心等待处理结果
					<br/><span style="padding-left:70px;"></span>3、每次上传会自动覆盖之前的历史内容，请小心操作</p>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/assets/global/plugins/jquery.min.js"></script>
	<script type="text/javascript" src="/assets/layer/layer.js"></script>
	<script type="text/javascript">
		function checkForm() {
			
			var year = document.form1.selectYear.value;
			var month = document.form1.selectMonth.value;
			var file = document.form1.file.value;
			
			if(year==''||month==''){
				alert('请完整选择要导入的年、月份');
				return false;
			}
			
			if (file != '') {
				layer.msg('请不要关闭或操作本页面，数据正在导入中...', {
					time : 0, // 不自动关闭
					icon : 16,
					shade : 0.01
				});
				return true;
			} else {
				alert('请选择要导入的excel文件');
			}
			
			return false;
		}
		
		function getFileName(obj)
		{
		    var pos = obj.value.lastIndexOf("/")*1;
		    return obj.value.substring(pos+1);
		}

		function getFileExt(obj)
		{
		    return obj.value.replace(/.+./,"");
		}

		function showInfo(obj)
		{
		    var filename = getFileName(obj);
		    var fileext = getFileExt(obj);
		    if(fileext!=null){
		    	document.getElementById("showFileName").innerText = filename+fileext;
		    }else{
		    	document.getElementById("showFileName").innerText = '请点击选择一个excel文件';
		    }
		}
	</script>
</body>
</html>