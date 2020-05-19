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
						href="javascript:window.history.back(-1);"
						class="right btn btn-sm yellow"> 返回 <i class="fa fa-undo"></i>
					</a></h1>
				<h5 class="form-title">${reportLog.title}</h5>
				<c:choose><c:when test="${empty fZyzsmz}">
						<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单尚未被提交</span>
						</div>
					</c:when><c:otherwise>
				<p class="time">提交时间: <fmt:formatDate value="${reportLog.submitTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				<p class="time">审核状态：<c:choose><c:when test="${reportLog.auditStatus==0}">未审核&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/dhsmz/edit/${reportLog.id}">编辑</a></c:if></c:when><c:when test="${reportLog.auditStatus==1}">已审核</c:when><c:otherwise>已退回<c:if test="${curUser.role.code=='USER'}">&nbsp;&nbsp;&nbsp;<a class="btn btn-sm green button-submit" href="/dhsmz/edit/${reportLog.id}">&nbsp;&nbsp;&nbsp;重新编辑</a></c:if></c:otherwise></c:choose></p>
				<form class="entry-form entry-form-bordered">
					<table class="entry-table">
						<tr>
							<td width="30%">基础电信企业门店数</td>
							<td width="70%" class="text-left">${fZyzsmz.jcdxmds}</td>
						</tr>
						<tr>
							<td width="30%">基础电信企业门店检查数（合规数）</td>
							<td width="70%" class="text-left">${fZyzsmz.jcdxmdhgs}</td>
						</tr>
						<tr>
							<td width="30%">基础电信企业门店合规率（%）</td>
							<td width="70%" class="text-left"><fmt:formatNumber value="${(fZyzsmz.jcdxmdhgs/fZyzsmz.jcdxmds)*100}" pattern="0.00"/>%</td>
						</tr>
						<tr>
							<td>转售企业门店数检查数</td>
							<td class="text-left">${fZyzsmz.zsqymdjcs}</td>
						</tr>
						<tr>
							<td>转售企业门店数（合规数）</td>
							<td class="text-left">${fZyzsmz.zsqymdshg}</td>
						</tr>
						<tr>
							<td width="30%">转售企业代理网点合规率（%）</td>
							<td width="70%" class="text-left"><fmt:formatNumber value="${(fZyzsmz.zsqymdshg/fZyzsmz.zsqymdjcs)*100}" pattern="0.00"/>%</td>
						</tr>
						<tr>
							<td>志愿者检查门店总数</td>
							<td class="text-left">${(fZyzsmz.jcdxmds+fZyzsmz.zsqymdjcs)}</td>
						</tr>
						<tr>
							<td>检查人次</td>
							<td class="text-left">${fZyzsmz.checkNumber}</td>
						</tr>
						<tr>
							<td>志愿者检查门店合规率（%）</td>
							<td class="text-left"><fmt:formatNumber value="${((fZyzsmz.jcdxmdhgs+fZyzsmz.zsqymdshg)/(fZyzsmz.jcdxmds+fZyzsmz.zsqymdjcs))*100}" pattern="0.00"/>%</td>
						</tr>
						<tr>
							<td>备注</td>
							<td class="text-left">${fZyzsmz.comment}</td>
						</tr>
					</table>
					<table class="entry-table">
						<tr>
							<td>填表公司：${fZyzsmz.company}</td>
							<td>填表人：${fZyzsmz.userName}</td>
							<td>联系方式：${fZyzsmz.mobile}</td>
							<td>电子邮箱：${fZyzsmz.email} </td>
						</tr>
					</table>
					<p class="text-right">上海市通信管理局制表</p>
				</form>
				</c:otherwise></c:choose>
			</div>
		</div>
	</div>
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
</body>
</html>