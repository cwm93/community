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
				<form class="entry-form entry-form-bordered" name="form1" id="form1" action="/yhkdzf/save" method="post">
					<table class="entry-table table-bordered" style="width:780px;margin:0 auto;">
					    <c:choose>
					    <c:when test="${curUser.telecomOperator.id==6}">
					    <tr>
							<td class="text-center">带宽</td>
							<td class="text-center">10/15M</td>
							<td class="text-center">30M</td>
							<td class="text-center">50M</td>
							<td class="text-center">200M</td>
						</tr>
					    </c:when><c:otherwise> <tr>
							<td class="text-center">带宽</td>
							<td class="text-center">20M</td>
							<td class="text-center">50M</td>
							<td class="text-center">100M</td>
							<td class="text-center">200M</td>
						</tr></c:otherwise></c:choose>
						<tr>
							<td>单宽带套餐资费（上海标准资费）（元/一年）</td>
							<td><input type="text" class="form-control input-sm" name="field_01" value="${fHouseholdBroadbandTariff.field_01}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_02" value="${fHouseholdBroadbandTariff.field_02}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_03" value="${fHouseholdBroadbandTariff.field_03}"/></td>
						</tr>
						<tr>
							<td>单宽带套餐资费（优惠价格）（元/一年）</td>
							<td><input type="text" class="form-control input-sm" name="field_04" value="${fHouseholdBroadbandTariff.field_04}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_05" value="${fHouseholdBroadbandTariff.field_05}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_06" value="${fHouseholdBroadbandTariff.field_06}"/></td>
						</tr>
						<tr>
							<td>融合套餐价格（元/月）</td>
							<td><input type="text" class="form-control input-sm" name="field_07" value="${fHouseholdBroadbandTariff.field_07}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_08" value="${fHouseholdBroadbandTariff.field_08}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_09" value="${fHouseholdBroadbandTariff.field_09}"/></td>
						</tr>
						<tr>
							<td>其中：融合套餐包含的国内分钟数（分钟/月）</td>
							<td><input type="text" class="form-control input-sm" name="field_10" value="${fHouseholdBroadbandTariff.field_10}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_11" value="${fHouseholdBroadbandTariff.field_11}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_12" value="${fHouseholdBroadbandTariff.field_12}"/></td>
						</tr>
						<tr>
							<td>其中：融合套餐包含的国内流量（M/月）</td>
							<td><input type="text" class="form-control input-sm" name="field_13" value="${fHouseholdBroadbandTariff.field_13}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_14" value="${fHouseholdBroadbandTariff.field_14}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_15" value="${fHouseholdBroadbandTariff.field_15}"/></td>
						</tr>
						<tr>
							<td>其中：融合套餐包含的优惠</td>
							<td colspan="3"><input type="text" class="form-control input-sm" name="field_16" value="${fHouseholdBroadbandTariff.field_16}"/></td>
						</tr>
						<tr>
							<td>用户数（万户）</td>
							<td><input type="text" class="form-control input-sm" name="field_17" value="${fHouseholdBroadbandTariff.field_17}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_18" value="${fHouseholdBroadbandTariff.field_18}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_19" value="${fHouseholdBroadbandTariff.field_19}"/></td>
						</tr>
						<tr>
							<td>用户占比（%）（用户数/总家庭用户数）</td>
							<td><input type="text" class="form-control input-sm" name="field_20" value="${fHouseholdBroadbandTariff.field_20}"/>%</td>
							<td><input type="text" class="form-control input-sm" name="field_21" value="${fHouseholdBroadbandTariff.field_21}"/>%</td>
							<td><input type="text" class="form-control input-sm" name="field_22" value="${fHouseholdBroadbandTariff.field_22}"/>%</td>
						</tr>
						<tr>
							<td>总家庭用户数(万户)</td>
							<td colspan="3"><input type="text" class="form-control input-sm" name="field_23" value="${fHouseholdBroadbandTariff.field_23}"/></td>
						</tr>
						<tr>
							<td>总用户数(万户 )(包含家庭用户、集客用户)</td>
							<td colspan="3"><input type="text" class="form-control input-sm" name="field_24" value="${fHouseholdBroadbandTariff.field_24}"/></td>
						</tr>
						<tr>
							<td>当月开账收入（万元）</td>
							<td><input type="text" class="form-control input-sm" name="field_25" value="${fHouseholdBroadbandTariff.field_25}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_26" value="${fHouseholdBroadbandTariff.field_26}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_27" value="${fHouseholdBroadbandTariff.field_27}"/></td>
						</tr>
						<tr>
							<td>销售收入占比（%）</td>
							<td><input type="text" class="form-control input-sm" name="field_28" value="${fHouseholdBroadbandTariff.field_28}"/>%</td>
							<td><input type="text" class="form-control input-sm" name="field_29" value="${fHouseholdBroadbandTariff.field_29}"/>%</td>
							<td><input type="text" class="form-control input-sm" name="field_30" value="${fHouseholdBroadbandTariff.field_30}"/>%</td>
						</tr>
						<tr>
							<td>平均带宽</td>
							<td colspan="3"><input type="text" class="form-control input-sm" name="field_31" value="${fHouseholdBroadbandTariff.field_31}"/></td>
						</tr>
						<tr>
							<td>千兆用户数</td>
							<td colspan="3"><input type="text" class="form-control input-sm" name="field_32" value="${fHouseholdBroadbandTariff.field_32}"/></td>
						</tr>
						<tr>
							<td>降价计划</td>
							<td colspan="3"><textarea class="form-control input-sm" name="field_33"> ${fHouseholdBroadbandTariff.field_33}</textarea></td>
						</tr>
						<tr>
							<td>降价后对收入的影响（预期）</td>
							<td colspan="3"><textarea class="form-control input-sm" name="field_34">${fHouseholdBroadbandTariff.field_34}</textarea></td>
						</tr>
						<tr>
							<td>单宽带套餐资费（北京地区标准资费）（元/一年）</td>
							<td><input type="text" class="form-control input-sm" name="field_35" value="${fHouseholdBroadbandTariff.field_35}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_36" value="${fHouseholdBroadbandTariff.field_36}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_37" value="${fHouseholdBroadbandTariff.field_37}"/></td>
						</tr>
						<tr>
							<td>单宽带套餐资费（北京地区优惠价格）（元/一年）</td>
							<td><input type="text" class="form-control input-sm" name="field_38" value="${fHouseholdBroadbandTariff.field_38}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_39" value="${fHouseholdBroadbandTariff.field_39}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_40" value="${fHouseholdBroadbandTariff.field_40}"/></td>
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
					<div class="form-actions">
						<div class="row">
						  <div class="col-xs-12 text-center" style="font-size:14px;margin:8px 0;">
								本人承诺以上申报数据真实有效，有据可查！&nbsp;&nbsp;<input type="checkbox" id="accept"/>
							<input type="hidden" name="reportLogId" value="${reportLog.id}" /> 
							<input type="hidden" name="insertUserId" value="${curUser.id}" />
							<input type="hidden" name="telecomOperatorId" value="${curUser.telecomOperator.id}" />
							<input type="hidden" name="id" value="${fHouseholdBroadbandTariff.id}" />
							<input type="hidden" name="flag" id="flag" value="0"/>
							</div>
							<div class="col-xs-12 text-center">
								<button type="button" id="formSave"class="btn btn-sm btn-danger"><i class="fa fa-check"></i>保存不提交</button>
								<button type="submit" id="formSubmit"class="btn btn-sm btn-success"><i class="fa fa-check"></i>保存并提交</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script src="/assets/apps/scripts/common-form.js" type="text/javascript"></script>
</body>
</html>