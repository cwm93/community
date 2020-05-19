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
				<h5 class="form-title">${reportLog.title}</h5>
				<c:choose><c:when test="${empty spamMessage}">
						<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单尚未被提交</span>
						</div>
					</c:when><c:otherwise>
				<p class="time">提交时间: <fmt:formatDate value="${reportLog.submitTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				<p class="time">审核状态：<c:choose><c:when test="${reportLog.auditStatus==0}">未审核&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/ljdxx/edit/${reportLog.id}">编辑</a></c:if></c:when><c:when test="${reportLog.auditStatus==1}">已审核</c:when><c:otherwise>已退回<c:if test="${curUser.role.code=='USER'}">&nbsp;&nbsp;&nbsp;<a class="btn btn-sm green button-submit" href="/ljdxx/edit/${reportLog.id}">&nbsp;&nbsp;&nbsp;重新编辑</a></c:if></c:otherwise></c:choose></p>
				<div class="entry-form entry-form-bordered">
					<table class="entry-table table-bordered" style="width:680px;margin:0 auto;">
					    <tr>
							<td colspan="3" class="text-center" width="40%">事项</td>
							<td class="text-center" width="60%">输入项值</td>
						</tr>
						<tr>
							<td colspan="3">收到垃圾短信息投诉量（起）</td>
							<td class="text-left">${spamMessage.field_01}</td>
						</tr>
						<tr>
							<td colspan="3">处理完毕（起）</td>
							<td class="text-left">${spamMessage.field_02}</td>
						</tr>
						<tr>
							<td colspan="3">用户满意率（%）</td>
							<td class="text-left">${spamMessage.field_03}</td>
						</tr>
						<tr>
							<td colspan="3">拦截垃圾短信息总量（万条）</td>
							<td class="text-left">${spamMessage.field_04}</td>
						</tr>
						<tr>
							<td colspan="3">拦截外省市号码发送总量（万条）</td>
							<td class="text-left">${spamMessage.field_05}</td>
						</tr>
						<tr>
							<td rowspan="4">拦截本市点对点号码发送总量（万条）</td>
							<td colspan="2">MO</td>
							<td class="text-left">${spamMessage.field_06}</td>
						</tr>
						<tr>
							<td rowspan="3">MT</td>
							<td>拦截电信发送量</td>
							<td class="text-left">${spamMessage.field_07}</td>
						</tr>
						<tr>
							<td>拦截移动发送量</td>
							<td class="text-left">${spamMessage.field_08}</td>
						</tr>
						<tr>
							<td>拦截联通发送量</td>
							<td class="text-left">${spamMessage.field_09}</td>
						</tr>
						<tr>
							<td colspan="3">拦截本企业企信通类MO短信数量（万条）</td>
							<td class="text-left">${spamMessage.field_10}</td>
						</tr>
						<tr>
							<td colspan="3">拦截外省市企信通类MT短信数量（万条）</td>
							<td class="text-left">${spamMessage.field_11}</td>
						</tr>
						<tr>
							<td rowspan="4">屏蔽手机号码总数</td>
							<td colspan="2">MO（万个）</td>
							<td class="text-left">${spamMessage.field_12}</td>
						</tr>
						<tr>
							<td rowspan="3">MT（个）</td>
							<td>屏蔽电信号码量</td>
							<td class="text-left">${spamMessage.field_13}</td>
						</tr>
						<tr>
							<td>屏蔽移动号码量</td>
							<td class="text-left">${spamMessage.field_14}</td>
						</tr>
						<tr>
							<td>屏蔽联通号码量</td>
							<td class="text-left">${spamMessage.field_15}</td>
						</tr>
						<tr>
							<td colspan="3">封堵违规企信通端口数（个）</td>
							<td class="text-left">${spamMessage.field_16}</td>
						</tr>
						<tr>
						    <td rowspan="3">严重违规通报</td>
							<td colspan="2">合作企业</td>
							<td class="text-left">${spamMessage.field_17}</td>
						</tr>
						<tr>
							<td colspan="2">端口号码</td>
							<td class="text-left">${spamMessage.field_18}</td>
						</tr>
						<tr>
							<td colspan="2">关键词（组）</td>
							<td class="text-left">${spamMessage.field_19}</td>
						</tr>
						<tr>
						    <td rowspan="24">重点垃圾短信拦截量（条）</td>
							<td rowspan="6">房产类</td>
							<td>企信通MO</td>
							<td class="text-left">${spamMessage.field_20}</td>
						</tr>
						<tr>
							<td>企信通MT</td>
							<td class="text-left">${spamMessage.field_21}</td>
						</tr>
						<tr>
							<td>点对点MO</td>
							<td class="text-left">${spamMessage.field_22}</td>
						</tr>
						<tr>
							<td>点对点MT</td>
							<td class="text-left">${spamMessage.field_23}</td>
						</tr>
						<tr>
							<td>数量合计</td>
							<td class="text-left">${spamMessage.field_24}</td>
						</tr>
						<tr>
							<td>样本</td>
							<td class="text-left">${spamMessage.field_25}</td>
						</tr>
						<tr>
							<td rowspan="6">教育类</td>
							<td>企信通MO</td>
							<td class="text-left">${spamMessage.field_26}</td>
						</tr>
						<tr>
							<td>企信通MT</td>
							<td class="text-left">${spamMessage.field_27}</td>
						</tr>
						<tr>
							<td>点对点MO</td>
							<td class="text-left">${spamMessage.field_28}</td>
						</tr>
						<tr>
							<td>点对点MT</td>
							<td class="text-left">${spamMessage.field_29}</td>
						</tr>
						<tr>
							<td>数量合计</td>
							<td class="text-left">${spamMessage.field_30}</td>
						</tr>
						<tr>
							<td>样本</td>
							<td class="text-left">${spamMessage.field_31}</td>
						</tr>
						<tr>
							<td rowspan="6">金融类</td>
							<td>企信通MO</td>
							<td class="text-left">${spamMessage.field_32}</td>
						</tr>
						<tr>
							<td>企信通MT</td>
							<td class="text-left">${spamMessage.field_33}</td>
						</tr>
						<tr>
							<td>点对点MO</td>
							<td class="text-left">${spamMessage.field_34}</td>
						</tr>
						<tr>
							<td>点对点MT</td>
							<td class="text-left">${spamMessage.field_35}</td>
						</tr>
						<tr>
							<td>数量合计</td>
							<td class="text-left">${spamMessage.field_36}</td>
						</tr>
						<tr>
							<td>样本</td>
							<td class="text-left">${spamMessage.field_37}</td>
						</tr>
						<tr>
							<td rowspan="6">诈骗</td>
							<td>企信通MO</td>
							<td class="text-left">${spamMessage.field_38}</td>
						</tr>
						<tr>
							<td>企信通MT</td>
							<td class="text-left">${spamMessage.field_39}</td>
						</tr>
						<tr>
							<td>点对点MO</td>
							<td class="text-left">${spamMessage.field_40}</td>
						</tr>
						<tr>
							<td>点对点MT</td>
							<td class="text-left">${spamMessage.field_41}</td>
						</tr>
						<tr>
							<td>数量合计</td>
							<td class="text-left">${spamMessage.field_42}</td>
						</tr>
						<tr>
							<td>样本</td>
							<td class="text-left">${spamMessage.field_43}</td>
						</tr>
						<tr>
							<td colspan="3">处置策略建议</td>
							<td class="text-left">${spamMessage.field_44}</td>
						</tr>
						<tr>
							<td rowspan="4">运营商网间短信结算量（点对点）</td>
							<td colspan="2">${oneOperator }→（入）亿条</td>
							<td class="text-left">${spamMessage.field_45}</td>
						</tr>
						<tr>
							<td colspan="2">${oneOperator }←（出）亿条</td>
							<td class="text-left">${spamMessage.field_46}</td>
						</tr>
						<tr>
							<td colspan="2">${anotherOperator }→（入）亿条</td>
							<td class="text-left">${spamMessage.field_47}</td>
						</tr>
						<tr>
							<td colspan="2">${anotherOperator }←（出）亿条</td>
							<td class="text-left">${spamMessage.field_48}</td>
						</tr>
						<tr>
							<td colspan="3">本月通过“0000”退订端口短信数量（条）</td>
							<td class="text-left">${spamMessage.field_49}</td>
						</tr>
						<tr>
							<td colspan="3">其他需要特别说明事项</td>
							<td class="text-left">${spamMessage.field_50}</td>
						</tr>
					</table>
					<table class="entry-table">
						<tr>
							<td>填表公司：${spamMessage.company}</td>
							<td>填表人：${spamMessage.userName}</td>
							<td>联系方式：${spamMessage.mobile}</td>
							<td>电子邮箱： ${spamMessage.email}</td>
						</tr>
					</table>
					<p class="text-right">上海市通信管理局制表</p>
				</div>
				</c:otherwise></c:choose>
			</div>
		</div>
	</div>
</body>
</html>