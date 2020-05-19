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
				<h5 class="form-title">${reportLog.title}<span style="font-size:12px;font-weight:normal;">（统计截至<c:choose><c:when test="${reportLog.writeYear==2017 && reportLog.writeMonth < 7 }"><fmt:formatDate value="${reportLog.createTime}" pattern="yyyy-MM-dd" /></c:when><c:otherwise>${reportLog.writeYear}年${reportLog.writeMonth}月底</c:otherwise></c:choose>）</span></h5>
				<c:choose><c:when test="${reportLog.auditStatus=='1'}">
					<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单已被审核通过不可编辑</span><a href="/xxzp/view/${reportLog.id }" style="margin:0 8px;text-decoration:none;">查看s<i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
					</div>
				</c:when><c:otherwise>
				<form class="entry-form entry-form-bordered" id="form1" action="/xxzp/save">
				    <div class="alert alert-warning"><a href="#" class="close" data-dismiss="alert">&times;</a>
					<strong>重要提醒！</strong>为规范数据，方便统计，规定：数值类型为小数时，请保留至小数点后两位，不足补0!
					</div>
					<table class="entry-table table-bordered">
						<tr>
							<td colspan="3"><h5>一、严格规范语音专线出租业务</h5></td>
						</tr>
						<tr>
							<td rowspan="5" style="width: 30%;">语音专线出租业务</td>
							<td style="width: 30%;">总用户数（家）</td>
							<td style="width: 40%;"><input type="text" class="form-control input-sm" name="field_1" value="${FXxzp.field_1}" required></td>
						</tr>
						<tr>
							<td>实名率（%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_2" value="${FXxzp.field_2}" placeholder="100.00" required><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td>老用户核查率（%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_3" value="${FXxzp.field_3}" placeholder="100.00" required><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td>关停企业（家）</td>
							<td><input type="text" class="form-control input-sm" name="field_4" value="${FXxzp.field_4}" required></td>
						</tr>
						<tr>
							<td>关停号码（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_5" value="${FXxzp.field_5}" required></td>
						</tr>

						<tr>
							<td colspan="3"><h5>二、切实规范“400”、一号通、商务总机业务</h5></td>
						</tr>
						<tr>
							<td rowspan="5">“400”业务</td>
							<td>总用户数（家）</td>
							<td><input type="text" class="form-control input-sm" name="field_6" value="${FXxzp.field_6}" required></td>
						</tr>
						<tr>
							<td>实名率（%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_7" value="${FXxzp.field_7}" placeholder="100.00" required><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td>老用户核查率（%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_8" value="${FXxzp.field_8}" placeholder="100.00" required><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td>关停企业（家）</td>
							<td><input type="text" class="form-control input-sm" name="field_9" value="${FXxzp.field_9}" required></td>
						</tr>
						<tr>
							<td>关停号码（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_10" value="${FXxzp.field_10}" required></td>
						</tr>
						<tr>
							<td rowspan="5">一号通业务</td>
							<td>总用户数（家）</td>
							<td><input type="text" class="form-control input-sm" name="field_11" value="${FXxzp.field_11}" required></td>
						</tr>
						<tr>
							<td>实名率（%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_12" value="${FXxzp.field_12}" placeholder="100.00" required><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td>老用户核查率（%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_13" value="${FXxzp.field_13}" placeholder="100.00" required><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td>关停企业（家）</td>
							<td><input type="text" class="form-control input-sm" name="field_14" value="${FXxzp.field_14}" required></td>
						</tr>
						<tr>
							<td>关停号码（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_15" value="${FXxzp.field_15}" required></td>
						</tr>
						<tr>
							<td rowspan="5">商务总机业务</td>
							<td>总用户数（家）</td>
							<td><input type="text" class="form-control input-sm" name="field_16" value="${FXxzp.field_16}" required></td>
						</tr>
						<tr>
							<td>实名率（%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_17" value="${FXxzp.field_17}" placeholder="100.00" required><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td>老用户核查率（%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_18" value="${FXxzp.field_18}" placeholder="100.00" required><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td>关停企业（家）</td>
							<td><input type="text" class="form-control input-sm" name="field_19" value="${FXxzp.field_19}" required></td>
						</tr>
						<tr>
							<td>关停号码（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_20" value="${FXxzp.field_20}" required></td>
						</tr>
						<tr>
							<td colspan="3"><h5>三、从严管理社会营销渠道</h5></td>
						</tr>
						<tr>
							<td rowspan="2">代理行为监管</td>
							<td>代理商总数（家）</td>
							<td><input type="text" class="form-control input-sm" name="field_21" value="${FXxzp.field_21}" required></td>
						</tr>
						<tr>
							<td>代理商清理数（家）</td>
							<td><input type="text" class="form-control input-sm" name="field_22" value="${FXxzp.field_22}" required></td>
						</tr>
						<tr>
							<td colspan="3"><h5>四、严格规范国际通信业务出入口局主叫号码传送</h5></td>
						</tr>
						<tr>
							<td>封堵境外非法透传</td>
							<td>拦截数量（万次）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_23" value="${FXxzp.field_23}" required><span class="input-group-addon">万次</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td colspan="3"><h5>五、全面实施语音专线主叫鉴权</h5></td>
						</tr>
						<tr>
							<td rowspan="4">语音专线主叫鉴权</td>
							<td>总电路数（条）</td>
							<td><input type="text" class="form-control input-sm" name="field_24" value="${FXxzp.field_24}" required></td>
						</tr>
						<tr>
							<td>未完成主叫鉴权电路数（条）</td>
							<td><input type="text" class="form-control input-sm" name="field_25" value="${FXxzp.field_25}" required></td>
						</tr>
						<tr>
							<td>关停电路数（条）</td>
							<td><input type="text" class="form-control input-sm" name="field_26" value="${FXxzp.field_26}" required></td>
						</tr>
						<tr>
							<td>主叫鉴权率（%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_27" value="${FXxzp.field_27}" placeholder="100.00" required><span class="input-group-addon">%</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td colspan="3"><h5>六、加大网内和网间虚假主叫发现与拦截力度</h5></td>
						</tr>
						<tr>
							<td>虚假改号呼叫拦截</td>
							<td>拦截数量（次）</td>
							<td><input type="text" class="form-control input-sm" name="field_28" value="${FXxzp.field_28}" required></td>
						</tr>
						<tr>
							<td colspan="3"><h5>七、提升用户终端安全防护能力</h5></td>
						</tr>
						<tr>
							<td>非法诈骗链接处置</td>
							<td>处置数量（次）</td>
							<td><input type="text" class="form-control input-sm" name="field_29" value="${FXxzp.field_29}" required></td>
						</tr>
						<tr>
							<td>防骚扰提醒服务</td>
							<td>总用户数（人）</td>
							<td><input type="text" class="form-control input-sm" name="field_30" value="${FXxzp.field_30}" required></td>
						</tr>
						<tr>
							<td rowspan="3">骚扰电话整顿</td>
							<td>配置白名单中继线（条）</td>
							<td><input type="text" class="form-control input-sm" name="field_31" value="${FXxzp.field_31}" required></td>
						</tr>
						<tr>
							<td>关停中继线（条）</td>
							<td><input type="text" class="form-control input-sm" name="field_32" value="${FXxzp.field_32}" required></td>
						</tr>
						<tr>
							<td>关停号码（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_33" value="${FXxzp.field_33}" required></td>
						</tr>
						<tr>
							<td colspan="3"><h5>八、积极配合公安机关做好打击查处工作</h5></td>
						</tr>
						<tr>
							<td rowspan="2">配合打击伪基站</td>
							<td>缴获设备（台）</td>
							<td><input type="text" class="form-control input-sm" name="field_34" value="${FXxzp.field_34}" required></td>
						</tr>
						<tr>
							<td>抓获嫌疑人（人）</td>
							<td><input type="text" class="form-control input-sm" name="field_35" value="${FXxzp.field_35}" required></td>
						</tr>
						<tr>
							<td colspan="3"><h5>九、畅通社会监督举报渠道</h5></td>
						</tr>
						<tr>
							<td rowspan="3">不良信息举报</td>
							<td>受理举报总数（起）</td>
							<td><input type="text" class="form-control input-sm" name="field_36" value="${FXxzp.field_36}" required></td>
						</tr>
						<tr>
							<td>平台处置举报（起）</td>
							<td><input type="text" class="form-control input-sm" name="field_37" value="${FXxzp.field_37}" required></td>
						</tr>
						<tr>
							<td>处置端口（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_38" value="${FXxzp.field_38}" required></td>
						</tr>
						<tr>
							<td>一键退订</td>
							<td>退订数量（万起）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_39" value="${FXxzp.field_39}" required><span class="input-group-addon">万起</span></div><span class="help-block">请保留至小数点后两位</span></td>
						</tr>
						<tr>
							<td colspan="3"><h5>十、加强公众教育与宣传引导</h5></td>
						</tr>
						<tr>
							<td rowspan="4">涉诈骗号码提示服务</td>
							<td>发送提醒短信 （条）</td>
							<td><input type="text" class="form-control input-sm" name="field_40" value="${FXxzp.field_40}" required></td>
						</tr>
						<tr>
							<td>客服回访 （次）</td>
							<td><input type="text" class="form-control input-sm" name="field_41" value="${FXxzp.field_41}" required></td>
						</tr>
						<tr>
							<td>回访成功 （次）</td>
							<td><input type="text" class="form-control input-sm" name="field_42" value="${FXxzp.field_42}" required></td>
						</tr>
						<tr>
							<td>推送公安介入 （次）</td>
							<td><input type="text" class="form-control input-sm"name="field_43" value="${FXxzp.field_43}" required></td>
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
								本人承诺以上申报数据真实有效，有据可查！<input type="checkbox" id="accept"/>
								<input type="hidden" name="reportLogId" value="${reportLog.id}"/>
								<input type="hidden" name="insertUserId" value="${curUser.id}"/>
								<input type="hidden" name="telecomOperatorId" value="${curUser.telecomOperator.id}" />
								<input type="hidden" name="flag" id="flag" value="0"/>
								<input type="hidden" name="id" value="${FXxzp.id}"/>
							</div>
							<div class="col-xs-12 text-center">
							    <button type="button" id="formSave" class="btn btn-sm btn-danger"><i class="fa fa-check"></i>保存不提交</button>
								<button type="submit" id="formSubmit" class="btn btn-sm btn-success"><i class="fa fa-check"></i>保存并提交</button>
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