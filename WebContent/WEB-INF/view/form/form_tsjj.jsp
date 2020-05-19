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
<link href="/assets/pages/css/form.css?v=20190515" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="/favicon.ico" />
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
				<c:choose><c:when test="${reportLog.auditStatus=='1'}">
					<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单已被审核通过不可编辑</span><a href="/tsjj/view/${reportLog.id }" style="margin:0 8px;text-decoration:none;">查看s<i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
					</div>
				</c:when><c:otherwise>
				<form class="entry-form entry-form-bordered" name="form1" id="form1" action="/tsjj/save" method="post">
					<div class="alert alert-warning"><a href="#" class="close" data-dismiss="alert">&times;</a>
					<strong>重要提醒！</strong>为规范数据，方便统计，规定：数值类型为小数时，请保留至小数点后两位，不足请补0!
					</div>
					<table class="entry-table table-bordered">
						<tr>
							<td class="text-center" width="15%">项目</td>
							<td width="40%" class="text-center">项目</td>
							<td width="45%" class="text-center">填入项</td>
						</tr>
						<tr>
							<td rowspan="6">固定宽带单位带宽平均资费（元/MB）</td>
							<td class="text-center">${reportLog.writeYear-1}年12月底</td>
							<td><input type="text" class="form-control input-sm" name="field_01" value="${fPriceSpeed.field_01}"/></td>
						</tr>
						<tr>
							<td class="text-center">${reportLog.writeYear}年${reportLog.writeMonth}月底</td>
							<td><input type="text" class="form-control input-sm" name="field_02" value="${fPriceSpeed.field_02}"/></td>
						</tr>
						<tr>
							<td class="text-center">预计${fPriceSpeed.thisYear}年12月底</td>
							<td><input type="text" class="form-control input-sm" name="field_03" value="${fPriceSpeed.field_03}"/></td>
						</tr>
						<tr>
							<td class="text-center">集团年度目标</td>
							<td><input type="text" class="form-control input-sm" name="field_04" value="${fPriceSpeed.field_04}"/></td>
						</tr>
						<tr>
							<td class="text-center">已完成目标</td>
							<td><input type="text" class="form-control input-sm" name="field_05" value="${fPriceSpeed.field_05}"/></td>
						</tr>
						<tr>
							<td class="text-center">预计完成目标</td>
							<td><input type="text" class="form-control input-sm" name="field_06" value="${fPriceSpeed.field_06}"/></td>
						</tr>
						<tr>
							<td rowspan="6">手机流量平均资费（元/GB）</td>
							<td class="text-center">${reportLog.writeYear-1}年12月底</td>
							<td><input type="text" class="form-control input-sm" name="field_07" value="${fPriceSpeed.field_07}"/></td>
						</tr>
						<tr>
							<td class="text-center">${reportLog.writeYear}年${reportLog.writeMonth}月底</td>
							<td><input type="text" class="form-control input-sm" name="field_08" value="${fPriceSpeed.field_08}"/></td>
						</tr>
						<tr>
							<td class="text-center">预计${reportLog.writeYear}年12月底</td>
							<td><input type="text" class="form-control input-sm" name="field_09" value="${fPriceSpeed.field_09}"/></td>
						</tr>
						<tr>
							<td class="text-center">集团年度目标</td>
							<td><input type="text" class="form-control input-sm" name="field_10" value="${fPriceSpeed.field_10}"/></td>
						</tr>
						<tr>
							<td class="text-center">已完成目标</td>
							<td><input type="text" class="form-control input-sm" name="field_11" value="${fPriceSpeed.field_11}"/></td>
						</tr>
						<tr>
							<td class="text-center">预计完成目标</td>
							<td><input type="text" class="form-control input-sm" name="field_12" value="${fPriceSpeed.field_12}"/></td>
						</tr>
						<tr>
							<td rowspan="3">降费举措</td>
							<td class="text-center">固定宽带方面</td>
							<td><textarea class="form-control input-sm" rows="5" name="field_13">${fPriceSpeed.field_13}</textarea></td>
						</tr>
						<tr>
							<td class="text-center">手机流量方面</td>
							<td><textarea class="form-control input-sm" rows="5" name="field_14">${fPriceSpeed.field_14}</textarea></td>
						</tr>
						<tr>
							<td class="text-center">宣传方面</td>
							<td><textarea class="form-control input-sm" rows="5" name="field_15">${fPriceSpeed.field_15}</textarea></td>
						</tr>
					</table>
					<p class="form-remark"><c:if test="${!empty reportFormRemark}">${reportFormRemark.remarkContent}</c:if></p>
					<table class="entry-table">
						<tr>
							<td>填表公司：<input type="text" class="form-control input-sm" name="company" value="${curUser.company}" readOnly/></td>
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
									<input type="hidden" name="id" value="${fPriceSpeed.id}" />
									<input type="hidden" name="flag" id="flag" value="0"/>
							</div>
							<div class="col-xs-12 text-center">
								<button type="button" id="formSave"class="btn btn-sm btn-danger"><i class="fa fa-check"></i>保存不提交</button>
								<button type="submit" id="formSubmit"class="btn btn-sm btn-success"><i class="fa fa-check"></i>保存并提交</button>
							</div>
						</div>
					</div>
				</form>
				</c:otherwise></c:choose>
			</div>
		</div>
	</div>
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script src="/assets/apps/scripts/common-form.js" type="text/javascript"></script>
</body>
</html>