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
				<h5 class="form-title">电话实名制志愿者检查情况汇总表</h5>
				<form class="form-horizontal">
					<div class="form-body">
						<div class="form-group">
							<label class="col-md-4 control-label">基础电信企业门店数<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">转售企业门店数（合规）<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">转售企业门店数（违规）<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">检查人次<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">转售企业代理网点合规率（%）<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control" /><span class="help-inline">只填数值部分，无需加"%"号</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">备注<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<textarea class="form-control input-large" rows="3"></textarea>
							</div>
						</div>
						<table class="entry-table">
							<tr>
								<td>填表公司：<input type="text" class="form-control input-sm" /></td>
								<td>填表人：<input type="text" class="form-control input-sm" /></td>
								<td>联系方式：<input type="text" class="form-control input-sm"/></td>
								<td>电子邮箱： <input type="text" class="form-control input-sm"/></td>
							</tr>
						</table>
						<p class="text-right">上海市通信管理局制表</p>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>