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
				<h5 class="form-title">基础电信运营商电话用户真实身份信息登记数据统计表</h5>
				<form class="entry-form entry-form-bordered">
					<table class="entry-table table-bordered">
					    <tr>
							<td rowspan="2" class="text-center">类别</td>
							<td colspan="2" class="text-center">移动电话用户（万）（含无线上网卡用户）</td>
							<td colspan="2" class="text-center">固定电话用户（万）（含无线市话用户）</td>
							<td colspan="2" class="text-center">所有电话用户（万）</td>
						</tr>
						<tr>
							<td class="text-center">截至本月末</td>
							<td class="text-center">本月新增</td>
							<td class="text-center">截至本月末</td>
							<td class="text-center">本月新增</td>
							<td class="text-center">截至本月末</td>
							<td class="text-center">本月新增</td>
						</tr>
						<tr>
						    <td width="10%">总用户数</td>
							<td width="10%"><input type="text" class="form-control input-sm"/></td>
							<td width="10%"><input type="text" class="form-control input-sm"/></td>
							<td width="10%"><input type="text" class="form-control input-sm"/></td>
							<td width="10%"><input type="text" class="form-control input-sm"/></td>
							<td width="10%"><input type="text" class="form-control input-sm"/></td>
							<td width="10%"><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						   <td>已登记实名制用户数</td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td>实名率</td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td>补登记实名制用户数</td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td>环比增加率</td>
							<td colspan="2"><input type="text" class="form-control input-sm"/></td>
							<td colspan="2"><input type="text" class="form-control input-sm"/></td>
							<td colspan="2"><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td>后付费用户数</td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td>预付费用户数</td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td colspan="2" class="text-center">自营厅</td>
							<td class="text-center">合作厅/专营店</td>
							<td colspan="2" class="text-center">代理点</td>
							<td colspan="2" class="text-center">电商平台</td>
						</tr>
						<tr>
						    <td class="text-center">总数</td>
							<td class="text-center">本月发展新用户占比</td>
							<td class="text-center">总数</td>
							<td class="text-center">总数</td>
							<td class="text-center">用户真实身份信息登记代理点数</td>
							<td class="text-center">授权数</td>
							<td class="text-center">清理未授权数</td>
						</tr>
						<tr>
						   <td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td colspan="2">实名登记APP终端数</td>
							<td colspan="5"><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td colspan="2">已禁止实名登记人工录入终端数</td>
							<td colspan="2"><input type="text" class="form-control input-sm"/></td>
						    <td>实名登记自动录入终端数</td>
							<td colspan="2"><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td colspan="2">二代身份证识别仪数</td>
							<td colspan="2"><input type="text" class="form-control input-sm"/></td>
						    <td>二代身份证识别设备网点数</td>
							<td colspan="2"><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td rowspan="2" colspan="2">业应用无线上网卡</td>
							<td>单位数</td>
						    <td><input type="text" class="form-control input-sm"/></td>
							<td rowspan="2">单位责任人</td>
							<td>已登记数</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td>卡数</td>
							<td><input type="text" class="form-control input-sm"/></td>
						    <td>未登记数</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td rowspan="2" colspan="2">集团用户电话卡（含无线上网卡）</td>
							<td>单位数</td>
						    <td><input type="text" class="form-control input-sm"/></td>
							<td rowspan="2">登记到用户个人</td>
							<td>已登记数</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td>卡数</td>
							<td><input type="text" class="form-control input-sm"/></td>
						    <td>未登记数</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td colspan="2">同一身份证件登记5张以上移动电话卡</td>
							<td colspan="5"><table class="entry-table">
									<tr>
										<td width="10%">卡数</td>
										<td width="10%"><input type="text" class="form-control input-sm"/></td>
										<td width="10%">用户数</td>
										<td width="10%"><input type="text" class="form-control input-sm"/></td>
										<td width="10%">已核查</td>
										<td width="10%"><input type="text" class="form-control input-sm"/></td>
										<td width="10%">已完成补登记数</td>
										<td width="10%"><input type="text" class="form-control input-sm"/></td>
									</tr>
								</table></td>
						</tr>
						<tr>
							<td colspan="2">漫游至新疆和西藏超过2个月的用户</td>
							<td colspan="5"><table class="entry-table">
									<tr>
										<td width="10%">卡数</td>
										<td width="10%"><input type="text" class="form-control input-sm"/></td>
										<td width="10%">用户数</td>
										<td width="10%"><input type="text" class="form-control input-sm"/></td>
										<td width="10%">已核查</td>
										<td width="10%"><input type="text" class="form-control input-sm"/></td>
										<td width="10%">已完成补登记数</td>
										<td width="10%"><input type="text" class="form-control input-sm"/></td>
									</tr>
								</table></td>
						</tr>
						<tr>
						    <td colspan="2">社会渠道授权牌应配发总数</td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td>本月新增</td>
							<td><input type="text" class="form-control input-sm"/></td>
							<td>社会渠道授权牌未配发总数</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
						    <td colspan="2">本月终止违规代理商数</td>
							<td colspan="2"><input type="text" class="form-control input-sm"/></td>
							<td>上报黑名单数</td>
							<td  colspan="2"><input type="text" class="form-control input-sm"/></td>
						</tr>
					</table>
					<p><strong>注：</strong><br />1、“环比增加率”：本月末“实名率”与上月末“实名率”相比，增加了多少百分点；<br />
						2、“本月发展新用户占比”：指本月自营厅发展的新用户占本月所有新用户的比例；<br />
						3、“开展真实身份信息登记代理点数”：指销售电话卡并对用户进行真实身份信息登记的代理点个数；<br />
					</p>
						<table class="entry-table">
						<tr>
							<td>填表公司：<input type="text" class="form-control input-sm"/></td>
							<td>填表人：<input type="text" class="form-control input-sm"/></td>
							<td>联系方式：<input type="text" class="form-control input-sm"/></td>
							<td>电子邮箱： <input type="text" class="form-control input-sm"/></td>
						</tr>
					</table>
					<p class="text-right">上海市通信管理局制表</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>