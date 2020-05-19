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
				<h5 class="form-title">基础电信企业家庭用户宽带资费</h5>
				<form class="entry-form entry-form-bordered">
					<table class="entry-table table-bordered">
					    <tr>
							<td class="text-center">带宽</td>
							<td class="text-center">20M</td>
							<td class="text-center">50M</td>
							<td class="text-center">100M</td>
							<td class="text-center">200M</td>
						</tr>
						<tr>
							<td>单宽带套餐资费（上海标准资费）（元/一年）</td>
							<td><input class="form-control input-sm" name="" type="number" step="0.0001"/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>单宽带套餐资费（优惠价格）（元/一年）</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>融合套餐价格（元/月）</td>
							<td rowspan="4">\</td>
							<td rowspan="4">\</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>其中：融合套餐包含的国内分钟数（分钟/月）</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>其中：融合套餐包含的国内流量（M/月）</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>其中：融合套餐包含的优惠</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>用户数（户）</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>用户占比（%）（用户数/总家庭用户数）</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>总家庭用户数(户)</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>总用户数(户)(包含家庭用户、集客用户)</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>当月开账收入（万元）</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>销售收入占比（%）</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>用户平均带宽(含集客用户)</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>降价计划</td>
							<td colspan="4"><textarea class="form-control input-sm" name=""></textarea></td>
						</tr>
						<tr>
							<td>降价后对收入的影响（预期）</td>
							<td colspan="4"><textarea class="form-control input-sm" name=""></textarea></td>
						</tr>
						<tr>
							<td>单宽带套餐资费（北京电信地区标准资费）（元/一年）</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
						<tr>
							<td>单宽带套餐资费（北京联通地区优惠价格）（元/一年）</td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
							<td><input type="text" class="form-control input-sm" name=""/></td>
						</tr>
					</table>
							<table class="entry-table">
						<tr>
							<td>填表公司：<input type="text" class="form-control input-sm" name="company" value="${curUser.company}"/></td>
							<td>填表人：<input type="text" class="form-control input-sm" name="userName" value="${curUser.realname}"/></td>
							<td>联系方式：<input type="text" class="form-control input-sm" name="mobile" value="${curUser.mobile}"/></td>
							<td>电子邮箱： <input type="text" class="form-control input-sm" name="email" value="${curUser.email}"/></td>
						</tr>
					</table>
					<p class="text-right">上海市通信管理局制表</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>