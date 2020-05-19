<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<style type="text/css">
.entry-table td{text-align:center;}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="top-title">
					上海市通信管理局<span>市场业务报表综合分析管理</span><a
						href="javascript:window.history.go(-1);"
						class="right btn btn-sm yellow"> 返回 <i class="fa fa-undo"></i>
					</a>
				</h1>
				<h5 class="form-title">${reportLog.title}</h5>
				<c:choose><c:when test="${empty fHouseholdBroadbandTariff}">
						<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单尚未被提交</span>
						</div>
					</c:when><c:otherwise>
				<p class="time">提交时间: <fmt:formatDate value="${reportLog.submitTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				<p class="time">审核状态：<c:choose><c:when test="${reportLog.auditStatus==0}">未审核&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/yhkdzf/edit/${reportLog.id}">编辑</a></c:if></c:when><c:when test="${reportLog.auditStatus==1}">已审核</c:when><c:otherwise>已退回<c:if test="${curUser.role.code=='USER'}">&nbsp;&nbsp;&nbsp;<a class="btn btn-sm green button-submit" href="/yhkdzf/edit/${reportLog.id}">&nbsp;&nbsp;&nbsp;重新编辑</a></c:if></c:otherwise></c:choose></p>
				<div class="entry-form entry-form-bordered">
					<table class="entry-table table-bordered">
						<c:choose>
					    <c:when test="${curUser.telecomOperator.id==6}">
					    <tr>
							<td colspan="2" class="text-center" style="width:10%">带宽</td>
							<td class="text-center" style="width:10%">10/15M</td>
							<td class="text-center" style="width:10%">30M</td>
							<td class="text-center" style="width:10%">50M</td>
							<td class="text-center" style="width:10%">200M</td>
							<td class="text-center" style="width:10%">500M</td>
							<td class="text-center" style="width:10%">1G</td>
						</tr>
					    </c:when><c:otherwise> <tr>
							<td colspan="2" class="text-center" style="width:10%">带宽</td>
							<td class="text-center" style="width:10%">20M</td>
							<td class="text-center" style="width:10%">50M</td>
							<td class="text-center" style="width:10%">100M</td>
							<td class="text-center" style="width:10%">200M</td>
							<td class="text-center" style="width:10%">500M</td>
							<td class="text-center" style="width:10%">1G</td>
						</tr></c:otherwise></c:choose>
						<tr>
							<td colspan="2">单宽带套餐资费（上海标准资费）（元/一年）</td>
							<td>${fHouseholdBroadbandTariff.field_01}</td>
							<td>${fHouseholdBroadbandTariff.field_02}</td>
							<td>${fHouseholdBroadbandTariff.field_03}</td>
							<td>${fHouseholdBroadbandTariff.field_2001}</td>
							<td>${fHouseholdBroadbandTariff.field_5001}</td>
							<td>${fHouseholdBroadbandTariff.field_10241}</td>
						</tr>
						<tr>
							<td colspan="2">单宽带套餐资费（优惠价格）（元/一年）</td>
							<td>${fHouseholdBroadbandTariff.field_04}</td>
							<td>${fHouseholdBroadbandTariff.field_05}</td>
							<td>${fHouseholdBroadbandTariff.field_06}</td>
							<td>${fHouseholdBroadbandTariff.field_2002}</td>
							<td>${fHouseholdBroadbandTariff.field_5002}</td>
							<td>${fHouseholdBroadbandTariff.field_10242}</td>
						</tr>
						<tr>
							<td colspan="2">融合套餐价格（元/月）</td>
							<td rowspan="4">${fHouseholdBroadbandTariff.field_07}</td>
							<td>${fHouseholdBroadbandTariff.field_08}</td>
							<td>${fHouseholdBroadbandTariff.field_09}</td>
							<td>${fHouseholdBroadbandTariff.field_2003}</td>
							<td>${fHouseholdBroadbandTariff.field_5003}</td>
							<td>${fHouseholdBroadbandTariff.field_10243}</td>
						</tr>
						<tr>
							<td colspan="2">其中：融合套餐包含的国内分钟数（分钟/月）</td>
							<td>${fHouseholdBroadbandTariff.field_11}</td>
							<td>${fHouseholdBroadbandTariff.field_12}</td>
							<td>${fHouseholdBroadbandTariff.field_2004}</td>
							<td>${fHouseholdBroadbandTariff.field_5004}</td>
							<td>${fHouseholdBroadbandTariff.field_10244}</td>
						</tr>
						<tr>
							<td colspan="2">其中：融合套餐包含的国内流量（M/月）</td>
							<td>${fHouseholdBroadbandTariff.field_14}</td>
							<td>${fHouseholdBroadbandTariff.field_15}</td>
							<td>${fHouseholdBroadbandTariff.field_2005}</td>
							<td>${fHouseholdBroadbandTariff.field_5005}</td>
							<td>${fHouseholdBroadbandTariff.field_10245}</td>
						</tr>
						<tr>
							<td colspan="2">其中：融合套餐包含的优惠</td>
							<td colspan="6">${fHouseholdBroadbandTariff.field_16}</td>
						</tr>
						<tr>
							<td colspan="2">用户数（万户）</td>
							<td>${fHouseholdBroadbandTariff.field_17}</td>
							<td>${fHouseholdBroadbandTariff.field_18}</td>
							<td>${fHouseholdBroadbandTariff.field_19}</td>
							<td>${fHouseholdBroadbandTariff.field_2006}</td>
							<td>${fHouseholdBroadbandTariff.field_5006}</td>
							<td>${fHouseholdBroadbandTariff.field_10246}</td>
						</tr>
						<tr>
							<td colspan="2">用户占比（%）（用户数/总家庭用户数）</td>
							<td>${fHouseholdBroadbandTariff.field_20}</td>
							<td>${fHouseholdBroadbandTariff.field_21}</td>
							<td>${fHouseholdBroadbandTariff.field_22}</td>
							<td>${fHouseholdBroadbandTariff.field_2007}</td>
							<td>${fHouseholdBroadbandTariff.field_5007}</td>
							<td>${fHouseholdBroadbandTariff.field_10247}</td>
						</tr>
						<tr>
							<td colspan="2">总家庭用户数(万户)</td>
							<td colspan="6">${fHouseholdBroadbandTariff.field_23}</td>
						</tr>
						<tr>
							<td colspan="2">总用户数(万户 )(包含家庭用户、集客用户)</td>
							<td colspan="6">${fHouseholdBroadbandTariff.field_24}</td>
						</tr>
						<tr>
							<td colspan="2">当月开账收入（万元）</td>
							<td>${fHouseholdBroadbandTariff.field_25}</td>
							<td>${fHouseholdBroadbandTariff.field_26}</td>
							<td>${fHouseholdBroadbandTariff.field_27}</td>
							<td>${fHouseholdBroadbandTariff.field_2008}</td>
							<td>${fHouseholdBroadbandTariff.field_5008}</td>
							<td>${fHouseholdBroadbandTariff.field_10248}</td>
						</tr>
						<tr>
							<td colspan="2">销售收入占比（%）</td>
							<td>${fHouseholdBroadbandTariff.field_28}</td>
							<td>${fHouseholdBroadbandTariff.field_29}</td>
							<td>${fHouseholdBroadbandTariff.field_30}</td>
							<td>${fHouseholdBroadbandTariff.field_2009}</td>
							<td>${fHouseholdBroadbandTariff.field_5009}</td>
							<td>${fHouseholdBroadbandTariff.field_10249}</td>
							
						</tr>
						<tr>
							<td colspan="2">平均带宽</td>
							<td colspan="6">${fHouseholdBroadbandTariff.field_31}</td>
						</tr>
						<tr>
							<td rowspan="2">百兆以上用户占比（%）（注：19年百兆以上用户占比达80%）</td>
							<td>2018年12月底占比（%）</td>
							<td colspan="6">${fHouseholdBroadbandTariff.field_41}</td>
						</tr>
						<tr>
							<td>目前占比（%）</td>
							<td colspan="6">${fHouseholdBroadbandTariff.field_42}</td>
						</tr>
						<tr>
							<td colspan="2">千兆用户数</td>
							<td colspan="6">${fHouseholdBroadbandTariff.field_32}</td>
						</tr>
						<tr>
							<td colspan="2">降价计划</td>
							<td colspan="6">${fHouseholdBroadbandTariff.field_33}</td>
						</tr>
						<tr>
							<td colspan="2">降价后对收入的影响（预期）</td>
							<td colspan="6">${fHouseholdBroadbandTariff.field_34}</td>
						</tr>
						<tr>
							<td colspan="2">单宽带套餐资费（北京地区标准资费）（元/一年）</td>
							<td>${fHouseholdBroadbandTariff.field_35}</td>
							<td>${fHouseholdBroadbandTariff.field_36}</td>
							<td>${fHouseholdBroadbandTariff.field_37}</td>
							<td>${fHouseholdBroadbandTariff.field_20010}</td>
							<td>${fHouseholdBroadbandTariff.field_50010}</td>
							<td>${fHouseholdBroadbandTariff.field_102410}</td>
						</tr>
						<tr>
							<td colspan="2">单宽带套餐资费（北京地区优惠价格）（元/一年）</td>
							<td>${fHouseholdBroadbandTariff.field_38}</td>
							<td>${fHouseholdBroadbandTariff.field_39}</td>
							<td>${fHouseholdBroadbandTariff.field_40}</td>
							<td>${fHouseholdBroadbandTariff.field_20011}</td>
							<td>${fHouseholdBroadbandTariff.field_50011}</td>
							<td>${fHouseholdBroadbandTariff.field_102411}</td>
						</tr>
					</table>
					<table class="entry-table">
						<tr>
							<td>填表公司：${fHouseholdBroadbandTariff.company}</td>
							<td>填表人：${fHouseholdBroadbandTariff.userName}</td>
							<td>联系方式：${fHouseholdBroadbandTariff.mobile}</td>
							<td>电子邮箱：${fHouseholdBroadbandTariff.email}</td>
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