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
				<h5 class="form-title">${reportLog.title }</h5>
				<c:choose><c:when test="${empty fPhoneUserRealIdentity}">
						<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单尚未被提交</span>
						</div>
					</c:when><c:otherwise>
				<p class="time">提交时间: <fmt:formatDate value="${reportLog.submitTime}" pattern="yyyy-MM-dd HH:mm:ss"/>  </p>
				<p class="time">审核状态：<c:choose><c:when test="${reportLog.auditStatus==0}">未审核&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/yhsmz/edit/${reportLog.id}">编辑</a></c:if></c:when><c:when test="${reportLog.auditStatus==1}">已审核</c:when><c:otherwise>已退回<c:if test="${curUser.role.code=='USER'}">&nbsp;&nbsp;&nbsp;<a class="btn btn-sm green button-submit" href="/yhsmz/edit/${reportLog.id}">&nbsp;&nbsp;&nbsp;重新编辑</a></c:if></c:otherwise></c:choose></p>
				<form class="entry-form entry-form-bordered" name="form1" id="form1" action="/yhsmz/save" method="post">
					<table class="entry-table table-bordered">
					    <tr>
							<td rowspan="2" class="text-center">类别</td>
							<td colspan="2" class="text-center">移动电话用户（万）（含无线上网卡用户）</td>
							<td colspan="2" class="text-center">固定电话用户（万）（含无线市话用户）</td>
							<td colspan="2" class="text-center">所有电话用户（万）</td>
						</tr>
						<tr>
							<td class="text-center">截至本月末</td>
							<td class="text-center">本月新增</td>
							<td class="text-center">截至本月末</td>
							<td class="text-center">本月新增</td>
							<td class="text-center">截至本月末</td>
							<td class="text-center">本月新增</td>
						</tr>
						<tr>
						    <td width="10%">总用户数</td>
							<td width="10%">${fPhoneUserRealIdentity.field_01}</td>
							<td width="10%">${fPhoneUserRealIdentity.field_02}</td>
							<td width="10%">${fPhoneUserRealIdentity.field_03}</td>
							<td width="10%">${fPhoneUserRealIdentity.field_04}</td>
							<td width="10%">${fPhoneUserRealIdentity.field_05}</td>
							<td width="10%">${fPhoneUserRealIdentity.field_06}</td>
						</tr>
						<tr>
						   <td>已登记实名制用户数</td>
							<td>${fPhoneUserRealIdentity.field_07}</td>
							<td>${fPhoneUserRealIdentity.field_08}</td>
							<td>${fPhoneUserRealIdentity.field_09}</td>
							<td>${fPhoneUserRealIdentity.field_10}</td>
							<td>${fPhoneUserRealIdentity.field_11}</td>
							<td>${fPhoneUserRealIdentity.field_12}</td>
						</tr>
						<tr>
						    <td>实名率</td>
							<td>${fPhoneUserRealIdentity.field_13}</td>
							<td>${fPhoneUserRealIdentity.field_14}</td>
							<td>${fPhoneUserRealIdentity.field_15}</td>
							<td>${fPhoneUserRealIdentity.field_16}</td>
							<td>${fPhoneUserRealIdentity.field_17}</td>
							<td>${fPhoneUserRealIdentity.field_18}</td>
						</tr>
						<tr>
						    <td>补登记实名制用户数</td>
							<td>${fPhoneUserRealIdentity.field_19}</td>
							<td>${fPhoneUserRealIdentity.field_20}</td>
							<td>${fPhoneUserRealIdentity.field_21}</td>
							<td>${fPhoneUserRealIdentity.field_22}</td>
							<td>${fPhoneUserRealIdentity.field_23}</td>
							<td>${fPhoneUserRealIdentity.field_24}</td>
						</tr>
						<tr>
						    <td>环比增加率</td>
							<td colspan="2">${fPhoneUserRealIdentity.field_25}</td>
							<td colspan="2">${fPhoneUserRealIdentity.field_26}</td>
							<td colspan="2">${fPhoneUserRealIdentity.field_27}</td>
						</tr>
						<tr>
						    <td>后付费用户数</td>
							<td>${fPhoneUserRealIdentity.field_28}</td>
							<td>${fPhoneUserRealIdentity.field_29}</td>
							<td>${fPhoneUserRealIdentity.field_30}</td>
							<td>${fPhoneUserRealIdentity.field_31}</td>
							<td>${fPhoneUserRealIdentity.field_32}</td>
							<td>${fPhoneUserRealIdentity.field_33}</td>
						</tr>
						<tr>
						    <td>预付费用户数</td>
							<td>${fPhoneUserRealIdentity.field_34}</td>
							<td>${fPhoneUserRealIdentity.field_35}</td>
							<td>${fPhoneUserRealIdentity.field_36}</td>
							<td>${fPhoneUserRealIdentity.field_37}</td>
							<td>${fPhoneUserRealIdentity.field_38}</td>
							<td>${fPhoneUserRealIdentity.field_39}</td>
						</tr>
					    <tr>
							<td rowspan="2" class="text-center">自营厅</td>
							<td colspan="3" class="text-center">总数</td>
							<td colspan="3">${fPhoneUserRealIdentity.field_40}</td>
							
						</tr>
						<tr>
						    <td colspan="3" class="text-center">本月发展新用户占比</td>
							<td colspan="3">${fPhoneUserRealIdentity.field_41}</td>
						</tr>
						<tr>
							<td colspan="2" class="text-center">合作厅/专营店</td>
							<td colspan="5">${fPhoneUserRealIdentity.field_42}</td>
						</tr>
						<tr>
							<td colspan="4" class="text-center">代理点</td>
							<td colspan="3" class="text-center">电商平台</td>
						</tr>
						<tr>
							<td class="text-center">总数</td>
							<td class="text-center">用户真实身份信息登记代理点数</td>
							<td class="text-center">代理点售卡数</td>
							<td class="text-center">照片稽核合规率（%）</td>
							<td class="text-center">授权数</td>
							<td colspan="2" class="text-center">清理未授权数</td>
						</tr>
						<tr>
							<td>${fPhoneUserRealIdentity.field_43}</td>
							<td>${fPhoneUserRealIdentity.field_44}</td>
							<td>${fPhoneUserRealIdentity.field_73}</td>
							<td>${fPhoneUserRealIdentity.field_74}</td>
							<td>${fPhoneUserRealIdentity.field_45}</td>
							<td colspan="2">${fPhoneUserRealIdentity.field_46}</td>
						</tr>
						<tr>
						    <td colspan="2">售卡数小计</td>
							<td colspan="5">${fPhoneUserRealIdentity.field_75}</td>
						</tr><tr>
						    <td colspan="2">售卡拍照核验数小计</td>
							<td colspan="5">${fPhoneUserRealIdentity.field_76}</td>
						</tr><tr>
						    <td colspan="2">售卡拍照核验通过数小计</td>
							<td colspan="5">${fPhoneUserRealIdentity.field_77}</td>
						</tr><tr>
						    <td colspan="2">售卡拍照核验合规率（%）</td>
							<td colspan="5">${fPhoneUserRealIdentity.field_78}</td>
						</tr>
						<tr>
						    <td colspan="2">实名登记APP终端数</td>
							<td colspan="5">${fPhoneUserRealIdentity.field_47}</td>
						</tr>
						<tr>
						    <td colspan="2">已禁止实名登记人工录入终端数</td>
							<td colspan="2">${fPhoneUserRealIdentity.field_48}</td>
						    <td>实名登记自动录入终端数</td>
							<td colspan="2">${fPhoneUserRealIdentity.field_49}</td>
						</tr>
						<tr>
						    <td colspan="2">二代身份证识别仪数</td>
							<td colspan="2">${fPhoneUserRealIdentity.field_50}</td>
						    <td>二代身份证识别设备网点数</td>
							<td colspan="2">${fPhoneUserRealIdentity.field_51}</td>
						</tr>
						<tr>
						    <td rowspan="2" colspan="2">行业应用无线上网卡</td>
							<td>单位数</td>
						    <td>${fPhoneUserRealIdentity.field_52}</td>
							<td rowspan="2">单位责任人</td>
							<td>已登记数</td>
							<td>${fPhoneUserRealIdentity.field_53}</td>
						</tr>
						<tr>
						    <td>卡数</td>
							<td>${fPhoneUserRealIdentity.field_54}</td>
						    <td>未登记数</td>
							<td>${fPhoneUserRealIdentity.field_55}</td>
						</tr>
						<tr>
						    <td rowspan="2" colspan="2">集团用户电话卡（含无线上网卡）</td>
							<td>单位数</td>
						    <td>${fPhoneUserRealIdentity.field_56}</td>
							<td rowspan="2">登记到用户个人</td>
							<td>已登记数</td>
							<td>${fPhoneUserRealIdentity.field_57}</td>
						</tr>
						<tr>
						    <td>卡数</td>
							<td>${fPhoneUserRealIdentity.field_58}</td>
						    <td>未登记数</td>
							<td>${fPhoneUserRealIdentity.field_59}</td>
						</tr>
						<tr>
						    <td colspan="2">同一身份证件登记5张以上移动电话卡</td>
							<td colspan="5"><table class="entry-table">
									<tr>
										<td width="10%">卡数</td>
										<td width="10%">${fPhoneUserRealIdentity.field_60}</td>
										<td width="10%">用户数</td>
										<td width="10%">${fPhoneUserRealIdentity.field_61}</td>
										<td width="10%">已核查</td>
										<td width="10%">${fPhoneUserRealIdentity.field_62}</td>
										<td width="10%">已完成补登记数</td>
										<td width="10%">${fPhoneUserRealIdentity.field_63}</td>
									</tr>
								</table></td>
						</tr>
						<tr>
							<td colspan="2">漫游至新疆和西藏超过2个月的用户</td>
							<td colspan="5"><table class="entry-table">
									<tr>
										<td width="10%">卡数</td>
										<td width="10%">${fPhoneUserRealIdentity.field_64}</td>
										<td width="10%">用户数</td>
										<td width="10%">${fPhoneUserRealIdentity.field_65}</td>
										<td width="10%">已核查</td>
										<td width="10%">${fPhoneUserRealIdentity.field_66}</td>
										<td width="10%">已完成补登记数</td>
										<td width="10%">${fPhoneUserRealIdentity.field_67}</td>
									</tr>
								</table></td>
						</tr>
						<tr>
						    <td colspan="2">社会渠道授权牌应配发总数</td>
							<td>${fPhoneUserRealIdentity.field_68}</td>
							<td>本月新增</td>
							<td>${fPhoneUserRealIdentity.field_69}</td>
							<td>社会渠道授权牌未配发总数</td>
							<td>${fPhoneUserRealIdentity.field_70}</td>
						</tr>
						<tr>
						    <td colspan="2">本月终止违规代理商数</td>
							<td colspan="2">${fPhoneUserRealIdentity.field_71}</td>
							<td>上报黑名单数</td>
							<td  colspan="2">${fPhoneUserRealIdentity.field_72}</td>
						</tr>
					</table>
					<p><strong>注：</strong><br />1、“环比增加率”：本月末“实名率”与上月末“实名率”相比，增加了多少百分点；<br />
						2、“本月发展新用户占比”：指本月自营厅发展的新用户占本月所有新用户的比例；<br />
						3、“开展真实身份信息登记代理点数”：指销售电话卡并对用户进行真实身份信息登记的代理点个数；<br />
					</p>
						<table class="entry-table">
						<tr>
							<td>填表公司：${fPhoneUserRealIdentity.company}</td>
							<td>填表人：${fPhoneUserRealIdentity.userName}</td>
							<td>联系方式：${fPhoneUserRealIdentity.mobile}</td>
							<td>电子邮箱： ${fPhoneUserRealIdentity.email}</td>
						</tr>
					</table>
					<p class="text-right">上海市通信管理局制表</p>
				</form>
				</c:otherwise></c:choose>
			</div>
		</div>
	</div>
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/jquery-validation/js/localization/messages_zh.js" type="text/javascript"></script>
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script src="/assets/apps/scripts/yhsmz.form.js" type="text/javascript"></script>
</body>
</html>