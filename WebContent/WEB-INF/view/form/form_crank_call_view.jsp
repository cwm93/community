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
					上海市通信管理局<span>市场业务报表综合分析管理</span><a
						href="javascript:window.history.go(-1);"
						class="right btn btn-sm yellow"> 返回 <i class="fa fa-undo"></i>
					</a>
				</h1>
				<h5 class="form-title">${reportLog.title}</h5>
				<c:choose>
				<c:when test="${empty crankCall}">
						<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单尚未被提交</span>
						</div>
					</c:when>
				<c:otherwise>
				<p class="time">提交时间: <fmt:formatDate value="${reportLog.submitTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				<p class="time">审核状态：<c:choose><c:when test="${reportLog.auditStatus==0}">未审核&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/crank_call/edit/${reportLog.id}">编辑</a></c:if></c:when><c:when test="${reportLog.auditStatus==1}">已审核</c:when><c:otherwise>已退回<c:if test="${curUser.role.code=='USER'}">&nbsp;&nbsp;&nbsp;<a class="btn btn-sm green button-submit" href="/crank_call/edit/${reportLog.id}">&nbsp;&nbsp;&nbsp;重新编辑</a></c:if></c:otherwise></c:choose></p>
				
					<table class="entry-table table-bordered">
						<thead>
						    <tr> 
						    	<th class="text-center">归属部门</th>
								<th class="text-center">总举报数量</th>
								<th class="text-center">举报分类科目</th>
								<th class="text-center">举报数量</th>
								<th class="text-center">具体案例描述（填写有明确指向拨打主体的案例）</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center" rowspan="3">公安部门</td>
								<td class="text-center" rowspan="3">${crankCall.field_000}</td>
								<td class="text-center">淫秽色情</td>
								<td class="text-center">${crankCall.field_011}</td>
								<td class="text-center">${crankCall.field_012}</td>
							</tr>
							<tr>
							    <td class="text-center">发票办证</td>
								<td class="text-center">${crankCall.field_021}</td>
								<td class="text-center">${crankCall.field_022}</td>
							</tr>
							<tr>
							    <td class="text-center">诈骗反诈</td>
								<td class="text-center">${crankCall.field_031}</td>
								<td class="text-center">${crankCall.field_032}</td>
							</tr>
							<tr>
								<td class="text-center" rowspan="2">银监会</td>
								<td class="text-center" rowspan="2">${crankCall.field_100}</td>
								<td class="text-center">贷款理财</td>
								<td class="text-center">${crankCall.field_111}</td>
								<td class="text-center">${crankCall.field_112}</td>
							</tr>
							<tr>
							    <td class="text-center">催收电话</td>
								<td class="text-center">${crankCall.field_121}</td>
								<td class="text-center">${crankCall.field_122}</td>
							</tr>
							<tr>
								<td class="text-center">证监会</td>
								<td class="text-center">${crankCall.field_200}</td>
								<td class="text-center">股票证券</td>
								<td class="text-center">${crankCall.field_211}</td>
								<td class="text-center">${crankCall.field_212}</td>
							</tr>
							<tr>
								<td class="text-center">保监会</td>
								<td class="text-center">${crankCall.field_300}</td>
								<td class="text-center">保险推销</td>
								<td class="text-center">${crankCall.field_311}</td>
								<td class="text-center">${crankCall.field_312}</td>
							</tr>
							<tr>
								<td class="text-center">住建部（房管局）</td>
								<td class="text-center">${crankCall.field_400}</td>
								<td class="text-center">房产中介</td>
								<td class="text-center">${crankCall.field_411}</td>
								<td class="text-center">${crankCall.field_412}</td>
							</tr>
							<tr>
								<td class="text-center">教育部</td>
								<td class="text-center">${crankCall.field_500}</td>
								<td class="text-center">教育培训</td>
								<td class="text-center">${crankCall.field_511}</td>
								<td class="text-center">${crankCall.field_512}</td>
							</tr>
							<tr>
								<td class="text-center">卫计委、食药监局</td>
								<td class="text-center">${crankCall.field_600}</td>
								<td class="text-center">卫生保健</td>
								<td class="text-center">${crankCall.field_611}</td>
								<td class="text-center">${crankCall.field_612}</td>
							</tr>
							<tr>
								<td class="text-center">卫计委 </td>
								<td class="text-center">${crankCall.field_700}</td>
								<td class="text-center">医疗美容</td>
								<td class="text-center">${crankCall.field_711}</td>
								<td class="text-center">${crankCall.field_712}</td>
							</tr>
							<tr>
								<td class="text-center">人社部</td>
								<td class="text-center">${crankCall.field_800}</td>
								<td class="text-center">猎头招聘</td>
								<td class="text-center">${crankCall.field_811}</td>
								<td class="text-center">${crankCall.field_812}</td>
							</tr>
							<tr>
								<td class="text-center">旅游局</td>
								<td class="text-center">${crankCall.field_900}</td>
								<td class="text-center">旅游产品</td>
								<td class="text-center">${crankCall.field_911}</td>
								<td class="text-center">${crankCall.field_912}</td>
							</tr>
							<tr>
								<td class="text-center">食药监局</td>
								<td class="text-center">${crankCall.field_1000}</td>
								<td class="text-center">餐饮活动</td>
								<td class="text-center">${crankCall.field_1011}</td>
								<td class="text-center">${crankCall.field_1012}</td>
							</tr>
							<tr>
								<td class="text-center">工商局</td>
								<td class="text-center">${crankCall.field_1100}</td>
								<td class="text-center">产品推销</td>
								<td class="text-center">${crankCall.field_1111}</td>
								<td class="text-center">${crankCall.field_1112}</td>
							</tr>
							<tr>
								<td class="text-center">需文字描述</td>
								<td class="text-center">${crankCall.field_1200}</td>
								<td class="text-center">其他</td>
								<td class="text-center">${crankCall.field_1211}</td>
								<td class="text-center">${crankCall.field_1212}</td>
							</tr>
							<tr>
								<td class="text-center"  rowspan="2">本月总体举报数量</td>
								<td class="text-center"  rowspan="2">${crankCall.field_1300}</td>
								<td class="text-center">上海号码举报数量</td>
								<td class="text-center">${crankCall.field_1301}</td>
								<td class="text-center"></td>
							</tr>
							<tr>
								<td class="text-center">他省号码举报数量</td>
								<td class="text-center">${crankCall.field_1302}</td>
								<td class="text-center"></td>
							</tr>
						</tbody></table>
						<table class="entry-table">
							<tr>
								<td>填表单位：${crankCall.company}</td>
								<td>填表人：${crankCall.userName}</td>
								<td>联系方式：${crankCall.mobile}</td>
								<td>电子邮箱：${crankCall.email}</td>
							</tr>
						</table>
						<p class="text-right">上海市通信管理局制表</p></c:otherwise></c:choose>
			</div>
		</div>
	</div>
</body>
</html>