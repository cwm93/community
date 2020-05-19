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
							<span style="font-size:16px;">该表单已被审核通过不可编辑</span><a href="/xxzp/view/${reportLog.id }" style="margin:0 8px;text-decoration:none;">查看s<i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
					</div>
				</c:when><c:otherwise>
				<form class="entry-form entry-form-bordered" name="form1" id="form1" action="/ljdxx/save" method="post">
				    <div class="alert alert-warning"><a href="#" class="close" data-dismiss="alert">&times;</a>
					<strong>重要提醒！</strong>为规范数据，方便统计，规定：数值类型为小数时，请保留至小数点后两位，不足补0!
					</div>
					<table class="entry-table table-bordered">
					    <tr>
							<td colspan="3" class="text-center" width="40%">事项</td>
							<td class="text-center" width="60%">输入项值</td>
						</tr>
						<tr>
							<td colspan="3">收到垃圾短信息投诉量（起）</td>
							<td><input type="text" class="form-control input-sm" name="field_01" value="${spamMessage.field_01}"/></td>
						</tr>
						<tr>
							<td colspan="3">处理完毕（起）</td>
							<td><input type="text" class="form-control input-sm" name="field_02" value="${spamMessage.field_02}"/></td>
						</tr>
						<tr>
							<td colspan="3">用户满意率（%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_03" value="${spamMessage.field_03}"/><span class="input-group-addon">%</span></div></td>
						</tr>
						<tr>
							<td colspan="3">拦截垃圾短信息总量（万条）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_04" value="${spamMessage.field_04}"/><span class="input-group-addon">万条</span></div></td>
						</tr>
						<tr>
							<td colspan="3">拦截外省市号码发送总量（万条）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_05" value="${spamMessage.field_05}"/><span class="input-group-addon">万条</span></div></td>
						</tr>
						<tr>
							<td rowspan="4">拦截本市点对点号码发送总量（万条）</td>
							<td colspan="2">MO</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_06" value="${spamMessage.field_06}"/><span class="input-group-addon">万条</span></div></td>
						</tr>
						<tr>
							<td rowspan="3">MT</td>
							<td>拦截电信发送量</td>
							<td><input type="text" class="form-control input-sm" name="field_07" value="${spamMessage.field_07}"/></td>
						</tr>
						<tr>
							<td>拦截移动发送量</td>
							<td><input type="text" class="form-control input-sm" name="field_08" value="${spamMessage.field_08}"/></td>
						</tr>
						<tr>
							<td>拦截联通发送量</td>
							<td><input type="text" class="form-control input-sm" name="field_09" value="${spamMessage.field_09}"/></td>
						</tr>
						<tr>
							<td colspan="3">拦截本企业企信通类MO短信数量（万条）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_10" value="${spamMessage.field_10}"/><span class="input-group-addon">万条</span></div></td>
						</tr>
						<tr>
							<td colspan="3">拦截外省市企信通类MT短信数量（万条）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_11" value="${spamMessage.field_11}"/><span class="input-group-addon">万条</span></div></td>
						</tr>
						<tr>
							<td rowspan="4">屏蔽手机号码总数</td>
							<td colspan="2">MO（万个）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_12" value="${spamMessage.field_12}"/><span class="input-group-addon">万个</span></div></td>
						</tr>
						<tr>
							<td rowspan="3">MT（个）</td>
							<td>屏蔽电信号码量</td>
							<td><input type="text" class="form-control input-sm" name="field_13" value="${spamMessage.field_13}"/></td>
						</tr>
						<tr>
							<td>屏蔽移动号码量</td>
							<td><input type="text" class="form-control input-sm" name="field_14" value="${spamMessage.field_14}"/></td>
						</tr>
						<tr>
							<td>屏蔽联通号码量</td>
							<td><input type="text" class="form-control input-sm" name="field_15" value="${spamMessage.field_15}"/></td>
						</tr>
						<tr>
							<td colspan="3">封堵违规企信通端口数（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_16" value="${spamMessage.field_16}"/></td>
						</tr>
						<tr>
						    <td rowspan="3">严重违规通报</td>
							<td colspan="2">合作企业</td>
							<td><textarea class="form-control input-sm" name="field_17">${spamMessage.field_17}</textarea></td>
						</tr>
						<tr>
							<td colspan="2">端口号码</td>
							<td><input type="text" class="form-control input-sm" name="field_18" value="${spamMessage.field_18}"/></td>
						</tr>
						<tr>
							<td colspan="2">关键词（组）</td>
							<td><textarea class="form-control input-sm" name="field_19">${spamMessage.field_19}</textarea></td>
						</tr>
						<tr>
						    <td rowspan="24">重点垃圾短信拦截量（条）</td>
							<td rowspan="6">房产类</td>
							<td>企信通MO</td>
							<td><input type="text" class="form-control input-sm" name="field_20" value="${spamMessage.field_20}"/></td>
						</tr>
						<tr>
							<td>企信通MT</td>
							<td><input type="text" class="form-control input-sm" name="field_21" value="${spamMessage.field_21}"/></td>
						</tr>
						<tr>
							<td>点对点MO</td>
							<td><input type="text" class="form-control input-sm" name="field_22" value="${spamMessage.field_22}"/></td>
						</tr>
						<tr>
							<td>点对点MT</td>
							<td><input type="text" class="form-control input-sm" name="field_23" value="${spamMessage.field_23}"/></td>
						</tr>
						<tr>
							<td>数量合计</td>
							<td><input type="text" class="form-control input-sm" name="field_24" value="${spamMessage.field_24}"/></td>
						</tr>
						<tr>
							<td>样本</td>
							<td><textarea class="form-control input-sm" name="field_25">${spamMessage.field_25}</textarea></td>
						</tr>
						<tr>
							<td rowspan="6">教育类</td>
							<td>企信通MO</td>
							<td><input type="text" class="form-control input-sm" name="field_26" value="${spamMessage.field_26}"/></td>
						</tr>
						<tr>
							<td>企信通MT</td>
							<td><input type="text" class="form-control input-sm" name="field_27" value="${spamMessage.field_27}"/></td>
						</tr>
						<tr>
							<td>点对点MO</td>
							<td><input type="text" class="form-control input-sm" name="field_28" value="${spamMessage.field_28}"/></td>
						</tr>
						<tr>
							<td>点对点MT</td>
							<td><input type="text" class="form-control input-sm" name="field_29" value="${spamMessage.field_29}"/></td>
						</tr>
						<tr>
							<td>数量合计</td>
							<td><input type="text" class="form-control input-sm" name="field_30" value="${spamMessage.field_30}"/></td>
						</tr>
						<tr>
							<td>样本</td>
							<td><textarea class="form-control input-sm" name="field_31">${spamMessage.field_31}</textarea></td>
						</tr>
						<tr>
							<td rowspan="6">金融类</td>
							<td>企信通MO</td>
							<td><input type="text" class="form-control input-sm" name="field_32" value="${spamMessage.field_32}"/></td>
						</tr>
						<tr>
							<td>企信通MT</td>
							<td><input type="text" class="form-control input-sm" name="field_33" value="${spamMessage.field_33}"/></td>
						</tr>
						<tr>
							<td>点对点MO</td>
							<td><input type="text" class="form-control input-sm" name="field_34" value="${spamMessage.field_34}"/></td>
						</tr>
						<tr>
							<td>点对点MT</td>
							<td><input type="text" class="form-control input-sm" name="field_35" value="${spamMessage.field_35}"/></td>
						</tr>
						<tr>
							<td>数量合计</td>
							<td><input type="text" class="form-control input-sm" name="field_36" value="${spamMessage.field_36}"/></td>
						</tr>
						<tr>
							<td>样本</td>
							<td><textarea class="form-control input-sm" name="field_37">${spamMessage.field_37}</textarea></td>
						</tr>
						<tr>
							<td rowspan="6">诈骗</td>
							<td>企信通MO</td>
							<td><input type="text" class="form-control input-sm" name="field_38" value="${spamMessage.field_38}"/></td>
						</tr>
						<tr>
							<td>企信通MT</td>
							<td><input type="text" class="form-control input-sm" name="field_39" value="${spamMessage.field_39}"/></td>
						</tr>
						<tr>
							<td>点对点MO</td>
							<td><input type="text" class="form-control input-sm" name="field_40" value="${spamMessage.field_40}"/></td>
						</tr>
						<tr>
							<td>点对点MT</td>
							<td><input type="text" class="form-control input-sm" name="field_41" value="${spamMessage.field_41}"/></td>
						</tr>
						<tr>
							<td>数量合计</td>
							<td><input type="text" class="form-control input-sm" name="field_42" value="${spamMessage.field_42}"/></td>
						</tr>
						<tr>
							<td>样本</td>
							<td><textarea class="form-control input-sm" name="field_43">${spamMessage.field_43}</textarea></td>
						</tr>
						<tr>
							<td colspan="3">处置策略建议</td>
							<td><textarea class="form-control input-sm" name="field_44">${spamMessage.field_44}</textarea></td>
						</tr>
						<tr>
							<td rowspan="4">运营商网间短信结算量（点对点）</td>
							<td colspan="2">${oneOperator}→（入）亿条</td>
							<td><div class="input-group"><input class="form-control input-sm" name="field_45" value="${spamMessage.field_45}"/><span class="input-group-addon">亿条</span></div></td>
						</tr>
						<tr>
							<td colspan="2">${oneOperator}←（出）亿条</td>
							<td><div class="input-group"><input class="form-control input-sm" name="field_46" value="${spamMessage.field_46}"/><span class="input-group-addon">亿条</span></div></td>
						</tr>
						<tr>
							<td colspan="2">${anotherOperator}→（入）亿条</td>
							<td><div class="input-group"><input class="form-control input-sm" name="field_47" value="${spamMessage.field_47}"/><span class="input-group-addon">亿条</span></div></td>
						</tr>
						<tr>
							<td colspan="2">${anotherOperator}←（出）亿条</td>
							<td><div class="input-group"><input class="form-control input-sm" name="field_48" value="${spamMessage.field_48}"/><span class="input-group-addon">亿条</span></div></td>
						</tr>
						<tr>
							<td colspan="3">本月通过“0000”退订端口短信数量（条）</td>
							<td><input class="form-control input-sm" name="field_49" value="${spamMessage.field_49}"/></td>
						</tr>
						<tr>
							<td colspan="3">其他需要特别说明事项</td>
							<td><textarea class="form-control input-sm" name="field_50">${spamMessage.field_50}</textarea></td>
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
							<input type="hidden" name="id" value="${spamMessage.id}" />
							<input type="hidden" name="flag" id="flag" value="0"/>
							</div>
							<div class="col-xs-12 text-center">
							    <button type="button" id="formSave" class="btn btn-sm btn-danger"><i class="fa fa-check"></i>保存不提交</button>
								<button type="submit" id="formSubmit" class="btn btn-sm btn-success"><i class="fa fa-check"></i>保存并提交</button>
							</div>
						</div>
					</div>
				</form></c:otherwise></c:choose>
			</div>
		</div>
	</div>
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script src="/assets/apps/scripts/common-form.js" type="text/javascript"></script>
</body>
</html>