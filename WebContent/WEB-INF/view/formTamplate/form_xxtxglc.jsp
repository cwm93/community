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
				<h5 class="form-title">信息通信管理处统计表</h5>
				<form class="entry-form entry-form-bordered">
					<table class="entry-table table-bordered">
						<tr>
							<td rowspan="5" width="5%" class="text-center">实名制用户</td>
							<td width="5%" class="text-center">单位</td>
							<td width="10%" class="text-center">总量（万）</td>
							<td width="10%" class="text-center">实名率</td>
							<td width="10%" class="text-center">合格率</td>
							<td width="10%" class="text-center">目标</td>
						</tr>
						<tr>
							<td>行业</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td rowspan="4"><textarea class="form-control input-sm" rows="5">合格率</textarea></td>
						</tr>
						<tr>
							<td>电信</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>移动</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>联通</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td rowspan="4" class="text-center">网间平台垃圾短信举报</td>
							<td>单位</td>
							<td class="text-center">排名（集团/全国）</td>
							<td class="text-center">被举报率（件次/千万用户）</td>
							<td class="text-center">增幅</td>
							<td class="text-center">0000退订</td>
						</tr>
						<tr>
							<td>电信</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>移动</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>联通</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td rowspan="5" class="text-center">增值电信业务（总计家）</td>
							<td>业务种类</td>
							<td class="text-center">营业收入（万）</td>
							<td class="text-center">同比</td>
							<td class="text-center">电信业务收入（万）</td>
							<td class="text-center">同比</td>
						</tr>
						<tr>
							<td>总计</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>信息服务</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>接入服务</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>呼叫中心</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td rowspan="4" class="text-center">自贸区增值电信业务（总计家）</td>
							<td>业务种类</td>
							<td class="text-center">营业收入（万）</td>
							<td class="text-center">同比</td>
							<td class="text-center">电信业务收入（万）</td>
							<td class="text-center">同比</td>
						</tr>
						<tr>
							<td>总计</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>电子商务平台交易额</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>其他</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td rowspan="5" class="text-center">百万用户申诉率</td>
							<td>单位</td>
							<td class="text-center">总受理量(件)</td>
							<td class="text-center">用户总数（万）</td>
							<td class="text-center">百万用户申诉率（人次/百万用户）</td>
							<td class="text-center">目标</td>
						</tr>
						<tr>
							<td>行业</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td rowspan="4"><textarea class="form-control input-sm" rows="5">全年每百万用户申诉率不超过50人次</textarea></td>
						</tr>
						<tr>
							<td>电信</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>移动</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>联通</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
						    <td rowspan="4" class="text-center">不明扣费申诉率</td>
							<td>行业</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td rowspan="4"><textarea class="form-control input-sm" rows="5">全年每百万用户不明扣费申诉率不超过5人次</textarea></td>
						</tr>
						<tr>
							<td>电信</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>移动</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>联通</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
						    <td rowspan="3" class="text-center">虚拟运营商</td>
							<td>覆盖范围</td>
							<td class="text-center">用户总数（万）</td>
							<td class="text-center">本月新增数（万）</td>
							<td class="text-center">转售收入总数（万）</td>
							<td class="text-center">本月转售收（万）</td>
						</tr>
						<tr>
							<td>全国</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>本地</td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
							<td><input type="text" class="form-control input-sm" /></td>
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
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
</body>
</html>