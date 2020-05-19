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
				<c:choose><c:when test="${reportLog.auditStatus=='1'}">
					<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单已被审核通过不可编辑</span><a href="/yhkdzf/view/${reportLog.id }" style="margin:0 8px;text-decoration:none;">查看s<i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
					</div>
				</c:when><c:otherwise>
				<form class="entry-form entry-form-bordered" name="form1" id="form1" action="/yhkdzf/save" method="post">
				    <div class="alert alert-warning"><a href="#" class="close" data-dismiss="alert">&times;</a>
					<strong>重要提醒！</strong>为规范数据，方便统计，规定：数值类型为小数时，请保留至小数点后四位，不足请补0!
					</div>
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
							<td><input type="text" class="form-control input-sm" name="field_01" value="${fHouseholdBroadbandTariff.field_01}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_02" value="${fHouseholdBroadbandTariff.field_02}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_03" value="${fHouseholdBroadbandTariff.field_03}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_2001" value="${fHouseholdBroadbandTariff.field_2001}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_5001" value="${fHouseholdBroadbandTariff.field_5001}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_10241" value="${fHouseholdBroadbandTariff.field_10241}"/></td>
							
						</tr>
						<tr>
							<td colspan="2">单宽带套餐资费（优惠价格）（元/一年）</td>
							<td><input type="text" class="form-control input-sm" name="field_04" value="${fHouseholdBroadbandTariff.field_04}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_05" value="${fHouseholdBroadbandTariff.field_05}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_06" value="${fHouseholdBroadbandTariff.field_06}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_2002" value="${fHouseholdBroadbandTariff.field_2002}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_5002" value="${fHouseholdBroadbandTariff.field_5002}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_10242" value="${fHouseholdBroadbandTariff.field_10242}"/></td>
						</tr>
						<tr>
							<td colspan="2">融合套餐价格（元/月）</td>
							<td rowspan="4"><input type="text" class="form-control input-sm" name="field_07" value="${fHouseholdBroadbandTariff.field_07}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_08" value="${fHouseholdBroadbandTariff.field_08}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_09" value="${fHouseholdBroadbandTariff.field_09}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_2003" value="${fHouseholdBroadbandTariff.field_2003}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_5003" value="${fHouseholdBroadbandTariff.field_5003}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_10243" value="${fHouseholdBroadbandTariff.field_10243}"/></td>
						</tr>
						<tr>
							<td colspan="2">其中：融合套餐包含的国内分钟数（分钟/月）</td>
							<td><input type="text" class="form-control input-sm" name="field_11" value="${fHouseholdBroadbandTariff.field_11}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_12" value="${fHouseholdBroadbandTariff.field_12}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_2004" value="${fHouseholdBroadbandTariff.field_2004}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_5004" value="${fHouseholdBroadbandTariff.field_5004}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_10244" value="${fHouseholdBroadbandTariff.field_10244}"/></td>
						</tr>
						<tr>
							<td colspan="2">其中：融合套餐包含的国内流量（M/月）</td>
							<td><input type="text" class="form-control input-sm" name="field_14" value="${fHouseholdBroadbandTariff.field_14}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_15" value="${fHouseholdBroadbandTariff.field_15}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_2005" value="${fHouseholdBroadbandTariff.field_2005}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_5005" value="${fHouseholdBroadbandTariff.field_5005}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_10245" value="${fHouseholdBroadbandTariff.field_10245}"/></td>
						</tr>
						<tr>
							<td colspan="2">其中：融合套餐包含的优惠</td>
							<td colspan="6"><input type="text" class="form-control input-sm" name="field_16" value="${fHouseholdBroadbandTariff.field_16}"/></td>
						</tr>
						<tr>
							<td colspan="2">用户数（万户）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_17" value="${fHouseholdBroadbandTariff.field_17}"/><span class="input-group-addon">万户</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_18" value="${fHouseholdBroadbandTariff.field_18}"/><span class="input-group-addon">万户</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_19" value="${fHouseholdBroadbandTariff.field_19}"/><span class="input-group-addon">万户</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_2006" value="${fHouseholdBroadbandTariff.field_2006}"/><span class="input-group-addon">万户</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_5006" value="${fHouseholdBroadbandTariff.field_5006}"/><span class="input-group-addon">万户</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_10246" value="${fHouseholdBroadbandTariff.field_10246}"/><span class="input-group-addon">万户</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td colspan="2">用户占比（%）（用户数/总家庭用户数）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_20" value="${fHouseholdBroadbandTariff.field_20}" placeholder="100.00" ><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_21" value="${fHouseholdBroadbandTariff.field_21}" placeholder="100.00" ><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" value="${fHouseholdBroadbandTariff.field_22}" placeholder="100.00" ><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_2007" value="${fHouseholdBroadbandTariff.field_2007}" placeholder="100.00" ><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_5007" value="${fHouseholdBroadbandTariff.field_5007}" placeholder="100.00" ><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_10247" value="${fHouseholdBroadbandTariff.field_10247}" placeholder="100.00" ><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td colspan="2">总家庭用户数(万户)</td>
							<td colspan="6"><input type="text" class="form-control input-sm" name="field_23" value="${fHouseholdBroadbandTariff.field_23}"/></td>
						</tr>
						<tr>
							<td colspan="2">总用户数(万户 )(包含家庭用户、集客用户)</td>
							<td colspan="6"><input type="text" class="form-control input-sm" name="field_24" value="${fHouseholdBroadbandTariff.field_24}"/></td>
						</tr>
						<tr>
							<td colspan="2">当月开账收入（万元）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_25" value="${fHouseholdBroadbandTariff.field_25}"/><span class="input-group-addon">万元</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_26" value="${fHouseholdBroadbandTariff.field_26}"/><span class="input-group-addon">万元</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_27" value="${fHouseholdBroadbandTariff.field_27}"/><span class="input-group-addon">万元</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_2008" value="${fHouseholdBroadbandTariff.field_2008}"/><span class="input-group-addon">万元</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_5008" value="${fHouseholdBroadbandTariff.field_5008}"/><span class="input-group-addon">万元</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_10248" value="${fHouseholdBroadbandTariff.field_10248}"/><span class="input-group-addon">万元</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td colspan="2">销售收入占比（%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_28" value="${fHouseholdBroadbandTariff.field_28}" placeholder="100.00" ><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_29" value="${fHouseholdBroadbandTariff.field_29}" placeholder="100.00" ><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_30" value="${fHouseholdBroadbandTariff.field_30}" placeholder="100.00" ><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_2009" value="${fHouseholdBroadbandTariff.field_2009}" placeholder="100.00" ><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_5009" value="${fHouseholdBroadbandTariff.field_5009}" placeholder="100.00"/><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_10249" value="${fHouseholdBroadbandTariff.field_10249}" placeholder="100.00"/><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td colspan="2">平均带宽</td>
							<td colspan="6"><input type="text" class="form-control input-sm" name="field_31" value="${fHouseholdBroadbandTariff.field_31}"/></td>
						</tr>
						<tr>
							<td rowspan="2">百兆以上用户占比（%）（注：19年百兆以上用户占比达80%）</td>
							<td>2018年12月底占比（%）</td>
							<td colspan="6"><input type="text" class="form-control input-sm" name="field_41" value="${fHouseholdBroadbandTariff.field_41}"/></td>
						</tr>
						<tr>
							<td>目前占比（%）</td>
							<td colspan="6"><input type="text" class="form-control input-sm" name="field_42" value="${fHouseholdBroadbandTariff.field_42}"/></td>
						</tr>
						<tr>
							<td colspan="2">千兆用户数</td>
							<td colspan="6"><input type="text" class="form-control input-sm" name="field_32" value="${fHouseholdBroadbandTariff.field_32}"/></td>
						</tr>
						<tr>
							<td colspan="2">降价计划</td>
							<td colspan="6"><textarea class="form-control input-sm" name="field_33">${fHouseholdBroadbandTariff.field_33}</textarea></td>
						</tr>
						<tr>
							<td colspan="2">降价后对收入的影响（预期）</td>
							<td colspan="6"><textarea class="form-control input-sm" name="field_34">${fHouseholdBroadbandTariff.field_34}</textarea></td>
						</tr>
						<tr>
							<td colspan="2">单宽带套餐资费（北京地区标准资费）（元/一年）</td>
							<td><input type="text" class="form-control input-sm" name="field_35" value="${fHouseholdBroadbandTariff.field_35}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_36" value="${fHouseholdBroadbandTariff.field_36}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_37" value="${fHouseholdBroadbandTariff.field_37}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_20010" value="${fHouseholdBroadbandTariff.field_20010}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_50010" value="${fHouseholdBroadbandTariff.field_50010}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_102410" value="${fHouseholdBroadbandTariff.field_102410}"/></td>
							
						</tr>
						<tr>
							<td colspan="2">单宽带套餐资费（北京地区优惠价格）（元/一年）</td>
							<td><input type="text" class="form-control input-sm" name="field_38" value="${fHouseholdBroadbandTariff.field_38}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_39" value="${fHouseholdBroadbandTariff.field_39}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_40" value="${fHouseholdBroadbandTariff.field_40}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_20011" value="${fHouseholdBroadbandTariff.field_20011}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_50011" value="${fHouseholdBroadbandTariff.field_50011}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_102411" value="${fHouseholdBroadbandTariff.field_102411}"/></td>
						</tr>
					</table>
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