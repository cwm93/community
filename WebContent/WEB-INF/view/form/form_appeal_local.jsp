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
				<h5 class="form-title">本地投诉情况</h5>
				<form class="form-horizontal" action="/appeal_local/save" name="form1" id="form1" method="post">
				   <div class="alert alert-warning"><a href="#" class="close" data-dismiss="alert">&times;</a>
					<strong>重要提醒！</strong>按照要求填写数据!
					</div>
					<table class="entry-table table-bordered">
						<tr>
							<th class="text-left" colspan="6">一、本地投诉总体情况</th>
						</tr>
						<tr>
							<td class="text-center">本月投诉量</td>
							<td class="text-center">上月投诉量</td>
							<td class="text-center">环比（%）</td>
							<td class="text-center">上一年度同月投诉量</td>
							<td class="text-center">同比（%）</td>
							<td class="text-center">备注</td>
						</tr>
						<tr>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="${appealLocal.field_11 }" placeholder="输入整数"/></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="${appealLocal.field_12 }" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_13" value="<fmt:formatNumber type="number" value="${appealLocal.field_13}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="${appealLocal.field_14 }" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_15" value="<fmt:formatNumber type="number" value="${appealLocal.field_15}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control" name="field_16" placeholder="输入文本">${appealLocal.field_16 }</textarea></td>
						</tr>
					</table>
					<table class="entry-table table-bordered">
						<tr>
							<th class="text-left" colspan="10">二、投诉热点问题TOP10</th>
						</tr>
						<tr>
						 	<td class="text-center">序号</td>
						 	<td class="text-center">投诉类型</td>
						 	<td class="text-center">主要问题</td>
							<td class="text-center">本月投诉量</td>
							<td class="text-center">占比%</td>
							<td class="text-center">上月投诉量</td>
							<td class="text-center">环比%</td>
							<td class="text-center">上一年度同月投诉量</td>
							<td class="text-center">同比</td>
							<td class="text-center">解决方案<br/>(客户界面处理口径/内部整改优化方案)</td>
						</tr>
						<c:forEach items="${appealLocal.appealLocalTopTenList}" var="appealLocalTopTen" varStatus="status">   
						<tr>
						    <td class="text-center">${status.index+1}
						    <c:if test="${appealLocal.id>0}"><input type="hidden" name="appealLocalTopTenList[${status.index}].appealLocal.id" value="${appealLocal.id}"/></c:if>
						    <input type="hidden" name="appealLocalTopTenList[${status.index}].id" value="${appealLocalTopTen.id}"/>
						    </td>
						    <td class="text-center"><input type="text" class="form-control input-sm" name="appealLocalTopTenList[${status.index}].top_01" value="${appealLocalTopTen.top_01}" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" name="appealLocalTopTenList[${status.index}].top_02" placeholder="输入文本">${appealLocalTopTen.top_02}</textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="appealLocalTopTenList[${status.index}].top_03" value="${appealLocalTopTen.top_03}" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="appealLocalTopTenList[${status.index}].top_04" value="<fmt:formatNumber type="number" value="${appealLocalTopTen.top_04}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="appealLocalTopTenList[${status.index}].top_05" value="${appealLocalTopTen.top_05}" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="appealLocalTopTenList[${status.index}].top_06" value="<fmt:formatNumber type="number" value="${appealLocalTopTen.top_06}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="appealLocalTopTenList[${status.index}].top_07" value="${appealLocalTopTen.top_07}" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="appealLocalTopTenList[${status.index}].top_08" value="<fmt:formatNumber type="number" value="${appealLocalTopTen.top_08}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="appealLocalTopTenList[${status.index}].top_09" placeholder="输入文本">${appealLocalTopTen.top_09}</textarea></td>
						</tr>
						</c:forEach>
					</table>
					<p>注：本报表为月报表，要求于每月15日前报送上一月数据，如2018年2月15日前报送2018年1月份数据。</p>
						<table class="entry-table">
							<tr>
								<td>填表单位：<input type="text" class="form-control input-sm" name="company" value="${curUser.company}" readOnly/></td>
								<td>填表人：<input type="text" class="form-control input-sm" name="userName" value="${curUser.realname}" readOnly/></td>
								<td>联系方式：<input type="text" class="form-control input-sm" name="mobile" value="${curUser.mobile}" readOnly/></td>
								<td>电子邮箱： <input type="text" class="form-control input-sm" name="email" value="${curUser.email}" readOnly/></td>
							</tr>
						</table>
						<p class="text-right">上海市通信管理局制表</p>
						<div class="form-actions">
							<div class="row">
								<div class="col-xs-12 text-center" style="font-size: 14px; margin: 8px 0;">
									本人承诺以上申报数据真实有效，有据可查！&nbsp;&nbsp;<input type="checkbox" id="accept" /> 
									<input type="hidden" name="reportLogId" value="${reportLog.id}" />
									<input type="hidden" name="insertUserId" value="${curUser.id}" /> 
								    <input type="hidden" name="telecomOperatorId" value="${curUser.telecomOperator.id}" />
									<input type="hidden" name="id" value="${appealLocal.id}" />
									<input type="hidden" name="flag" id="flag" value="0"/>
								</div>
								<div class="col-xs-12 text-center">
							    <button type="button" id="formSave" class="btn btn-sm btn-danger"><i class="fa fa-check"></i>保存不提交</button>
								<button type="submit" id="formSubmit" class="btn btn-sm btn-success"><i class="fa fa-check"></i>保存并提交</button>
							    </div>
							</div>
						</div></form>
			</div>
		</div>
	</div>
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script src="/assets/apps/scripts/common-form.js" type="text/javascript"></script>
</body>
</html>