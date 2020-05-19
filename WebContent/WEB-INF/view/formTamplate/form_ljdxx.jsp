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
				<h5 class="form-title"> 	上海电信治理垃圾短信息情况月报表</h5>
				<form class="entry-form entry-form-bordered">
					<table class="entry-table table-bordered">
					    <tr>
							<td colspan="3" class="text-center" width="40%">事项</td>
							<td class="text-center" width="60%">输入项值</td>
						</tr>
						<tr>
							<td colspan="3">收到垃圾短信息投诉量（起）</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td colspan="3">处理完毕（起）</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td colspan="3">用户满意率（%）</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td colspan="3">拦截垃圾短信息总量（万条）</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td colspan="3">拦截外省市号码发送总量（万条）</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td rowspan="4">拦截本市点对点号码发送总量（万条）</td>
							<td colspan="2">MO</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td rowspan="3">MT</td>
							<td>拦截电信发送量</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>拦截移动发送量</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>拦截联通发送量</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td colspan="3">拦截本企业企信通类MO短信数量（万条）</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td colspan="3">拦截外省市企信通类MT短信数量（万条）</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td rowspan="4">屏蔽手机号码总数</td>
							<td colspan="2">MO（万个）</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td rowspan="3">MT（个）</td>
							<td>屏蔽电信号码量</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>屏蔽移动号码量</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>屏蔽联通号码量</td>
							<td><input type="text" class="form-control input-sm" name="field_15"/></td>
						</tr>
						<tr>
							<td colspan="3">封堵违规企信通端口数（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_16"/></td>
						</tr>
						<tr>
						    <td rowspan="3">严重违规通报</td>
							<td colspan="2">合作企业</td>
							<td><textarea class="form-control input-sm"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">端口号码</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td colspan="2">关键词（组）</td>
							<td><textarea class="form-control input-sm"></textarea></td>
						</tr>
						<tr>
						    <td rowspan="24">重点垃圾短信拦截量（条）</td>
							<td rowspan="6">房产类</td>
							<td>企信通MO</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>企信通MT</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>点对点MO</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>点对点MT</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>数量合计</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>样本</td>
							<td><textarea class="form-control input-sm"></textarea></td>
						</tr>
						<tr>
							<td rowspan="6">教育类</td>
							<td>企信通MO</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>企信通MT</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>点对点MO</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>点对点MT</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>数量合计</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>样本</td>
							<td><textarea class="form-control input-sm"></textarea></td>
						</tr>
						<tr>
							<td rowspan="6">金融类</td>
							<td>企信通MO</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>企信通MT</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>点对点MO</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>点对点MT</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>数量合计</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>样本</td>
							<td><textarea class="form-control input-sm"></textarea></td>
						</tr>
						<tr>
							<td rowspan="6">诈骗</td>
							<td>企信通MO</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>企信通MT</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>点对点MO</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>点对点MT</td>
							<td><input type="text" class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td>数量合计</td>
							<td><input type="text" class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>样本</td>
							<td><textarea class="form-control input-sm" ></textarea></td>
						</tr>
						<tr>
							<td colspan="3">处置策略建议</td>
							<td><textarea class="form-control input-sm"></textarea></td>
						</tr>
						<tr>
							<td rowspan="4">运营商网间短信结算量（点对点）</td>
							<td colspan="2">移动→（入）亿条</td>
							<td><input class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td colspan="2">移动←（出）亿条</td>
							<td><input class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td colspan="2">联通→（入）亿条</td>
							<td><input class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td colspan="2">联通←（出）亿条</td>
							<td><input class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td colspan="3">本月通过“0000”退订端口短信数量（条）</td>
							<td><input class="form-control input-sm"/></td>
						</tr>
						<tr>
							<td colspan="3">其他需要特别说明事项</td>
							<td><textarea class="form-control input-sm">}</textarea></td>
						</tr>
					</table>
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