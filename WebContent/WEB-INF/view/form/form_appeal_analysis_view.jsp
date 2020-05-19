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
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="top-title">
					上海市通信管理局<span>市场业务报表综合分析管理</span>
				</h1>
				<h5 class="form-title">${reportLog.title}</h5>
				<c:choose><c:when test="${empty appealAnalysis}">
						<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单尚未被提交</span>
						</div>
					</c:when><c:otherwise>
				<p class="time">提交时间: <fmt:formatDate value="${reportLog.submitTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				<p class="time">审核状态：<c:choose><c:when test="${reportLog.auditStatus==0}">未审核&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/appeal_analysis/edit/${reportLog.id}">编辑</a></c:if></c:when><c:when test="${reportLog.auditStatus==1}">已审核</c:when><c:otherwise>已退回<c:if test="${curUser.role.code=='USER'}">&nbsp;&nbsp;&nbsp;<a class="btn btn-sm green button-submit" href="/appeal_analysis/edit/${reportLog.id}">&nbsp;&nbsp;&nbsp;重新编辑</a></c:if></c:otherwise></c:choose></p>
					<table class="entry-table table-bordered">
						<tr>
							<th class="text-left" colspan="7">一、申诉总体趋势</th>
						</tr>
						<tr>
							<td class="text-center"></td>
							<td class="text-center">本月投诉量</td>
							<td class="text-center">上月投诉量</td>
							<td class="text-center">环比（%）</td>
							<td class="text-center">上一年度同月投诉量</td>
							<td class="text-center">同比（%）</td>
							<td class="text-center">备注</td>
						</tr>
						<tr>
							<td class="text-center">申诉总量</td>
							<td class="text-center">${appealAnalysis.field_11 }</td>
							<td class="text-center">${appealAnalysis.field_12 }</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_13}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_14 }</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_15}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_16 }</td>
						
						</tr>
						<tr>
							<td class="text-center">重复单量</td>
							<td class="text-center">${appealAnalysis.field_21 }</td>
							<td class="text-center">${appealAnalysis.field_22 }</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_23}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_24 }</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_25}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_26 }</td>
						</tr>
						<tr>
							<td class="text-center">无效单量</td>
							<td class="text-center">${appealAnalysis.field_31 }</td>
							<td class="text-center">${appealAnalysis.field_32 }</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_33}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_34 }</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_35}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_36 }</td>
						</tr>
						<tr>
							<td class="text-center">有效单量</td>
							<td class="text-center">${appealAnalysis.field_41 }</td>
							<td class="text-center">${appealAnalysis.field_42 }</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_43}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_44 }</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_45}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_46 }</td>
						</tr>
					</table>
					<table class="entry-table table-bordered">
						<tr>
							<th class="text-left" colspan="10">二、申诉内容分析</th>
						</tr>
						<tr>
						 	<td class="text-center">序号</td>
						 	<td class="text-center">投诉类型</td>
						 	<td class="text-center">主要问题</td>
							<td class="text-center">本月投诉量</td>
							<td class="text-center">占比（%）</td>
							<td class="text-center">上月投诉量</td>
							<td class="text-center">环比（%）</td>
							<td class="text-center">上一年度同月投诉量</td>
							<td class="text-center">同比（%）</td>
							<td class="text-center">解决方案<br/>(客户界面处理口径/内部整改优化方案)</td>
						</tr>
						<c:forEach items="${appealAnalysis.appealAnalysisContentList}" var="appealAnalysisContent" varStatus="status">   
						<tr>
						    <td class="text-center">${status.index+1}</td>
						    <td class="text-center">${appealAnalysisContent.top_01}</td>
						    <td class="text-center">${appealAnalysisContent.top_02}</td>
							<td class="text-center">${appealAnalysisContent.top_03}</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysisContent.top_04}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysisContent.top_05}</td>
							<td class="text-center"><fmt:formatNumber type="number"  value="${appealAnalysisContent.top_06}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysisContent.top_07}</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysisContent.top_08}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysisContent.top_09}</td>
						</tr>
						</c:forEach>
					</table>
					<table class="entry-table table-bordered">
						<tr>
							<th class="text-left" colspan="8">三、申诉内容分析</th>
						</tr>
						<tr>
						 	<td class="text-center"></td>
						 	<td class="text-center">本月</td>
						 	<td class="text-center">占比（%）</td>
							<td class="text-center">上月</td>
							<td class="text-center">环比（%）</td>
							<td class="text-center">上一年度同月</td>
							<td class="text-center">环比（%）</td>
							<td class="text-center">备注</td>
						</tr>
						<tr>
						    <td class="text-center">和解量<br/>（用户对处理结果认可）</td>
							<td class="text-center">${appealAnalysis.field_51}</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_52}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_53}</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_54}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_55}"</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_56}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_57}</td>
						</tr>
						<tr>
						    <td class="text-center">不认可量<br/>（用户对处理结果不认可）</td>
							<td class="text-center">${appealAnalysis.field_61}</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_62}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_63}</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_64}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_65}</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_66}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_67}</td>
						</tr>
						<tr>
						    <td class="text-center">知晓量<br/>（用户对处理结果表示知晓）</td>
							<td class="text-center">${appealAnalysis.field_71}</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_72}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_73}</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_74}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_75}</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${appealAnalysis.field_76}" pattern="0.00" maxFractionDigits="2"/>%</td>
							<td class="text-center">${appealAnalysis.field_77}</td>
						</tr>
					</table>
					<p>注：<br/>
1、本报表为月报表，要求于每月5日前报送上一月数据，如2018年2月5日前报送2018年1月份数据。<br/>
2、“申诉总量”指上海申诉中心转派单总量；“重复单”指同一设备号码且申诉同一问题；“无效单量”指非本企业申诉或不在受理范围等；“有效单量”=申诉总量-重复单量-无效单量。</p>
						<table class="entry-table">
							<tr>
								<td>填表单位：${appealAnalysis.company}</td>
								<td>填表人：${appealAnalysis.userName}</td>
								<td>联系方式：${appealAnalysis.mobile}</td>
								<td>电子邮箱：${appealAnalysis.email}</td>
							</tr>
						</table>
						<p class="text-right">上海市通信管理局制表</p></c:otherwise></c:choose>
			</div>
		</div>
	</div>
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script src="/assets/apps/scripts/common-form.js" type="text/javascript"></script>
</body>
</html>