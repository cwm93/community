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
				<h1 class="top-title">
					上海市通信管理局<span>市场业务报表综合分析管理</span><a
						href="javascript:window.history.go(-1);"
						class="right btn btn-sm yellow"> 返回 <i class="fa fa-undo"></i>
					</a>
				</h1>
				<h5 class="form-title">${reportLog.title}</h5>
				<c:choose><c:when test="${reportLog.auditStatus=='1'}">
					<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单已被审核通过不可编辑</span><a href="/xxzp/view/${reportLog.id }" style="margin:0 8px;text-decoration:none;">查看s<i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
					</div>
				</c:when><c:otherwise>
				<form class="form-horizontal" action="/dhsmz/save" name="form1" id="form1" method="post">
				    <div class="alert alert-warning"><a href="#" class="close" data-dismiss="alert">&times;</a>
					<strong>重要提醒！</strong>为规范数据，方便统计，规定：数值类型为小数时，请保留至小数点后两位，不足补0!
					</div>
					<div class="form-body">
						<div class="form-group">
							<label class="col-md-4 control-label">基础电信企业门店数<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="jcdxmds" value="${fZyzsmz.jcdxmds}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">基础电信企业门店检查数（合规数）<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="jcdxmdhgs"
									value="${fZyzsmz.jcdxmdhgs}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">基础电信企业门店合规率（%）<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<c:choose><c:when test="${fZyzsmz.jcdxmds!=0}"><input type="text" class="form-control" id="p1" value="<fmt:formatNumber value="${(fZyzsmz.jcdxmdhgs/fZyzsmz.jcdxmds)*100}" pattern="0.00"/>" readOnly /></c:when><c:otherwise><input type="text" class="form-control" id="p1" value="100.00" readOnly/></c:otherwise></c:choose>	
								<span class="help-info">系统自动计算生成，无需填写</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">转售企业门店数检查数<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="zsqymdjcs"
									value="${fZyzsmz.zsqymdjcs}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">转售企业门店数（合规数）<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="zsqymdshg"
									value="${fZyzsmz.zsqymdshg}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">转售企业代理网点合规率（%）<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<c:choose><c:when test="${fZyzsmz.zsqymdjcs!=0}"><input type="text" class="form-control" id="p2" value="<fmt:formatNumber value="${(fZyzsmz.zsqymdshg/fZyzsmz.zsqymdjcs)*100}" pattern="0.00"/>" readOnly /></c:when><c:otherwise><input type="text" class="form-control" id="p2" value="100.00" readOnly/></c:otherwise></c:choose>	
								<span class="help-info">系统自动计算生成，无需填写</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">志愿者检查门店总数<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<c:choose><c:when test="${fZyzsmz.jcdxmds!=0}"><input type="text" class="form-control" id="p4" value="${fZyzsmz.jcdxmds+fZyzsmz.zsqymdjcs}" readOnly /></c:when><c:otherwise><input type="text" class="form-control" id="p4" value="0" readOnly/></c:otherwise></c:choose>	
								<span class="help-info">系统自动计算生成，无需填写</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">检查人次<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="checkNumber"
									value="${fZyzsmz.checkNumber}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">志愿者检查门店合规率（%）<span
								class="required"> * </span></label>
							<div class="col-md-4">
							     <c:choose><c:when test="${fZyzsmz.jcdxmds!=0}"> <input type="text" class="form-control" id="p3" value="<fmt:formatNumber value="${((fZyzsmz.jcdxmdhgs+fZyzsmz.zsqymdshg)/(fZyzsmz.jcdxmds+fZyzsmz.zsqymdjcs))*100}" pattern="0.00"/>" disabled/></c:when><c:otherwise><input type="text" class="form-control" id="p3" value="100.00" readOnly/></c:otherwise></c:choose>	
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">备注<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<textarea class="form-control input-large" rows="3"
									name="comment">${fZyzsmz.comment}</textarea>
							</div>
						</div>
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
									<input type="hidden" name="id" value="${fZyzsmz.id}" />
									<input type="hidden" name="flag" id="flag" value="0"/>
								</div>
								<div class="col-xs-12 text-center">
							    <button type="button" id="formSave" class="btn btn-sm btn-danger"><i class="fa fa-check"></i>保存不提交</button>
								<button type="submit" id="formSubmit" class="btn btn-sm btn-success"><i class="fa fa-check"></i>保存并提交</button>
							    </div>
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