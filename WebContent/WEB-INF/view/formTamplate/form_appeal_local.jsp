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
				<form class="form-horizontal" action="/appealAmount/save" name="form1" id="form1" method="post">
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
							<td class="text-center">环比%</td>
							<td class="text-center">上一年度同月投诉量</td>
							<td class="text-center">同比</td>
							<td class="text-center">备注</td>
						</tr>
						<tr>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入整数"/></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_13" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_15" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control" name="field_16" placeholder="输入文本"></textarea></td>
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
						<tr>
						    <td class="text-center">1</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
						</tr>
						<tr>
						    <td class="text-center">1</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
						</tr>
						<tr>
						    <td class="text-center">2</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
						</tr>
						<tr>
						    <td class="text-center">3</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
						</tr>
						<tr>
						    <td class="text-center">4</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
						</tr>
						<tr>
						    <td class="text-center">5</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
						</tr>
						<tr>
						    <td class="text-center">6</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
						</tr>
						<tr>
						    <td class="text-center">7</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
						</tr>
						<tr>
						    <td class="text-center">8</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
						</tr>
						<tr>
						    <td class="text-center">9</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
						</tr>
						<tr>
						    <td class="text-center">10</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="field_16" placeholder="输入文本"></textarea></td>
						</tr>
					</table>
					<p>注：本报表为月报表，要求于每月15日前报送上一月数据，如2018年2月15日前报送2018年1月份数据。</p>
						<table class="entry-table">
							<tr>
								<td>填表公司：<input type="text" class="form-control input-sm" name="company" value="" readOnly/></td>
								<td>填表人：<input type="text" class="form-control input-sm" name="userName" value="" readOnly/></td>
								<td>联系方式：<input type="text" class="form-control input-sm" name="mobile" value="" readOnly/></td>
								<td>电子邮箱： <input type="text" class="form-control input-sm" name="email" value="" readOnly/></td>
							</tr>
						</table>
						<p class="text-right">上海市通信管理局制表</p>
						<div class="form-actions">
							<div class="row">
								<div class="col-xs-12 text-center" style="font-size: 14px; margin: 8px 0;">
									本人承诺以上申报数据真实有效，有据可查！&nbsp;&nbsp;<input type="checkbox" id="accept" /> 
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
</body>
</html>