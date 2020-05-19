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
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
			    <h1 class="top-title">上海市通信管理局<span>市场业务报表综合分析管理</span><a
						href="javascript:window.history.go(-1);"
						class="right btn btn-sm yellow"> 返回 <i class="fa fa-undo"></i>
					</a></h1>
				<h5 class="form-title">基础电信企业实名制工作情况周报汇总</h5>
				<form class="entry-form entry-form-bordered">
					<table class="entry-table table-bordered">
					    <tr>
							<td colspan="2" width="15%" class="text-center">工作项目</td>
							<td width="10%"></td>
							<td width="10%" class="text-center">工作目标</td>
						</tr>
						<tr>
							<td colspan="2">实名合规率达到100%</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td rowspan="10"><textarea class="form-control input-sm"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">待停机</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td colspan="2">已补登</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td colspan="2">已停机</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td rowspan="6">停机（万户）</td>
							<td>剩余未登记或信息错误的用户数量（个人）</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>累计已补登记用户数（个人）</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>累计已停机用户数量（个人）</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>剩余未登记或信息错误的用户数量（政企）</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>累计已补登记用户数（政企）</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>累计已停机用户数量（政企）</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>特殊情况处理（万户）</td>
							<td>一证多户（个人）已核查补登数量</td>
							<td colspan="2"><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td rowspan="4">拍照</td>
							<td>全市售卡网点数量（营业厅）</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td rowspan="4"><textarea class="form-control input-sm"></textarea></td>
						</tr>
						<tr>
							<td>开卡时拍照设备铺设数量（营业厅）</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>全市售卡网点数量（代理渠道）</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>开卡时拍照设备铺设数量（代理渠道）</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
					</table>
					<table class="entry-table">
						<tr>
							<td>填表公司：<input type="text"/></td>
							<td>填表人：<input type="text" /></td>
							<td>联系方式：<input type="text" /></td>
							<td>电子邮箱： <input type="text" /></td>
						</tr>
					</table>
					<p class="text-right">上海市通信管理局制表</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>