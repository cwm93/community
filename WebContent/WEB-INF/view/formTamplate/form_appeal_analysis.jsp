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
				<h5 class="form-title">申诉情况分析月报</h5>
				<form class="form-horizontal" action="#" name="form1" id="form1" method="post">
				   <div class="alert alert-warning"><a href="#" class="close" data-dismiss="alert">&times;</a>
					<strong>重要提醒！</strong>按照要求填写数据!
					</div>
					<table class="entry-table table-bordered">
						<tr>
							<th class="text-left" colspan="7">一、申诉总体趋势</th>
						</tr>
						<tr>
							<td class="text-center"></td>
							<td class="text-center">本月投诉量</td>
							<td class="text-center">上月投诉量</td>
							<td class="text-center">环比%</td>
							<td class="text-center">上一年度同月投诉量</td>
							<td class="text-center">同比</td>
							<td class="text-center">备注</td>
						</tr>
						<tr>
							<td class="text-center">申诉总量</td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_11" value="${appealAnalysis.field_11 }" placeholder="输入整数"/></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_12" value="${appealAnalysis.field_12 }" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_13" value="<fmt:formatNumber type="number" value="${appealAnalysis.field_13}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_14" value="${appealAnalysis.field_14 }" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_15" value="<fmt:formatNumber type="number" value="${appealAnalysis.field_15}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control" name="field_16" placeholder="输入文本">${appealAnalysis.field_16 }</textarea></td>
						
						</tr>
						<tr>
							<td class="text-center">重复单量</td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_21" value="${appealAnalysis.field_21 }" placeholder="输入整数"/></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_22" value="${appealAnalysis.field_22 }" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_23" value="<fmt:formatNumber type="number" value="${appealAnalysis.field_23}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_24" value="${appealAnalysis.field_14 }" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_25" value="<fmt:formatNumber type="number" value="${appealAnalysis.field_25}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control" name="field_16" placeholder="输入文本">${appealAnalysis.field_16 }</textarea></td>
						</tr>
						<tr>
							<td class="text-center">无效单量</td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_31" value="${appealAnalysis.field_31 }" placeholder="输入整数"/></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_32" value="${appealAnalysis.field_32 }" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_33" value="<fmt:formatNumber type="number" value="${appealAnalysis.field_33}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_34" value="${appealAnalysis.field_34 }" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_35" value="<fmt:formatNumber type="number" value="${appealAnalysis.field_35}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control" name="field_36" placeholder="输入文本">${appealAnalysis.field_36 }</textarea></td>
						</tr>
						<tr>
							<td class="text-center">有效单量</td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_41" value="${appealAnalysis.field_41 }" placeholder="输入整数"/></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_42" value="${appealAnalysis.field_42 }" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_43" value="<fmt:formatNumber type="number" value="${appealAnalysis.field_43}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_44" value="${appealAnalysis.field_44 }" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_45" value="<fmt:formatNumber type="number" value="${appealAnalysis.field_45}" pattern="0.00" maxFractionDigits="2"/>" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control" name="field_46" placeholder="输入文本">${appealAnalysis.field_46 }</textarea></td>
						</tr>
					</table>
					<table class="entry-table table-bordered">
						<tr>
							<th class="text-left" colspan="10">二、申诉内容分析</th>
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
						    <td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" placeholder="输入文本"></textarea></td>
						</tr><tr>
						    <td class="text-center">2</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" placeholder="输入文本"></textarea></td>
						</tr><tr>
						    <td class="text-center">3</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" placeholder="输入文本"></textarea></td>
						</tr><tr>
						    <td class="text-center">4</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" placeholder="输入文本"></textarea></td>
						</tr><tr>
						    <td class="text-center">5</td>
						    <td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入文本"/></td>
						    <td class="text-center"><textarea class="form-control input-sm" placeholder="输入文本"></textarea></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" placeholder="输入文本"></textarea></td>
						</tr>
					</table>
					<table class="entry-table table-bordered">
						<tr>
							<th class="text-left" colspan="8">三、申诉内容分析</th>
						</tr>
						<tr>
						 	<td class="text-center"></td>
						 	<td class="text-center">本月</td>
						 	<td class="text-center">占比</td>
							<td class="text-center">上月</td>
							<td class="text-center">环比</td>
							<td class="text-center">上一年度同月</td>
							<td class="text-center">环比%</td>
							<td class="text-center">备注</td>
						</tr>
						<tr>
						    <td class="text-center">和解量<br/>（用户对处理结果认可）</td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm"placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" name="field_57" placeholder="输入文本"></textarea></td>
						</tr>
						<tr>
						    <td class="text-center">不认可量<br/>（用户对处理结果不认可）</td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" placeholder="输入文本"></textarea></td>
						</tr>
						<tr>
						    <td class="text-center">知晓量<br/>（用户对处理结果表示知晓）</td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><input type="text" class="form-control input-sm" placeholder="输入整数"/></td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" placeholder="保留两位小数"><span class="input-group-addon">%</span> </div></td>
							<td class="text-center"><textarea class="form-control input-sm" placeholder="输入文本"></textarea></td>
						</tr>
					</table>
					<p>注：<br/>
1、本报表为月报表，要求于每月5日前报送上一月数据，如2018年2月5日前报送2018年1月份数据。<br/>
2、“申诉总量”指上海申诉中心转派单总量；“重复单”指同一设备号码且申诉同一问题；“无效单量”指非本企业申诉或不在受理范围等；“有效单量”=申诉总量-重复单量-无效单量。</p>
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
								</div>
								<div class="col-xs-12 text-center">
							    <button type="button" id="formSave" class="btn btn-sm btn-danger"><i class="fa fa-check"></i>保存不提交</button>
								<button type="button" id="formSubmit" class="btn btn-sm btn-success"><i class="fa fa-check"></i>保存并提交</button>
							    </div>
							</div>
						</div></form>
			</div>
		</div>
	</div>
</body>
</html>