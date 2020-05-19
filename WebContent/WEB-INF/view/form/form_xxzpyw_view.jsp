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
				<c:choose><c:when test="${empty FXxzp}">
						<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单尚未被提交</span>
						</div>
					</c:when><c:otherwise>
                <p class="time">提交时间: <fmt:formatDate value="${reportLog.submitTime}" pattern="yyyy-MM-dd HH:mm:ss"/>  </p>
				<p class="time">审核状态：<c:choose><c:when test="${reportLog.auditStatus==0}">未审核&nbsp;&nbsp;&nbsp;<c:if test="${curUser.role.code=='USER'}"><a class="btn btn-sm green button-submit" href="/xxzp/edit/${reportLog.id}">编辑</a></c:if></c:when><c:when test="${reportLog.auditStatus==1}">已审核</c:when><c:otherwise>已退回<c:if test="${curUser.role.code=='USER'}">&nbsp;&nbsp;&nbsp;<a class="btn btn-sm green button-submit" href="/xxzp/edit/${reportLog.id}">&nbsp;&nbsp;&nbsp;重新编辑</a></c:if></c:otherwise></c:choose></p>
				<div class="entry-form entry-form-bordered">
					<table class="entry-table table-bordered">
						<tr>
							<td colspan="3"><h5>一、严格规范语音专线出租业务</h5></td>
						</tr>
						<tr>
							<td rowspan="5" style="width: 30%;">语音专线出租业务</td>
							<td style="width: 30%;">总用户数（家）</td>
							<td style="width: 40%;" class="text-left">${FXxzp.field_1 }</td>
						</tr>
						<tr>

							<td>实名率（%）</td>
							<td class="text-left">${FXxzp.field_2}</td>
						</tr>
						<tr>

							<td>老用户核查率（%）</td>
							<td class="text-left">${FXxzp.field_3}</td>
						</tr>
						<tr>
							<td>关停企业（家）</td>
							<td class="text-left">${FXxzp.field_4}</td>
						</tr>
						<tr>
							<td>关停号码（个）</td>
							<td class="text-left">${FXxzp.field_5}</td>
						</tr>

						<tr>
							<td colspan="3"><h5>二、切实规范“400”、一号通、商务总机业务</h5></td>
						</tr>
						<tr>
							<td rowspan="5">“400”业务</td>
							<td>总用户数（家）</td>
							<td class="text-left">${FXxzp.field_6}</td>
						</tr>
						<tr>

							<td>实名率（%）</td>
							<td class="text-left">${FXxzp.field_7}</td>
						</tr>
						<tr>

							<td>老用户核查率（%）</td>
							<td class="text-left">${FXxzp.field_8}</td>
						</tr>
						<tr>
							<td>关停企业（家）</td>
							<td class="text-left">${FXxzp.field_9}</td>
						</tr>
						<tr>
							<td>关停号码（个）</td>
							<td class="text-left">${FXxzp.field_10}</td>
						</tr>
						<tr>
							<td rowspan="5">一号通业务</td>
							<td>总用户数（家）</td>
							<td class="text-left">${FXxzp.field_11}</td>
						</tr>
						<tr>

							<td>实名率（%）</td>
							<td class="text-left">${FXxzp.field_12}</td>
						</tr>
						<tr>

							<td>老用户核查率（%）</td>
							<td class="text-left">${FXxzp.field_13}</td>
						</tr>
						<tr>
							<td>关停企业（家）</td>
							<td class="text-left">${FXxzp.field_14}</td>
						</tr>
						<tr>
							<td>关停号码（个）</td>
							<td class="text-left">${FXxzp.field_15}</td>
						</tr>
						<tr>
							<td rowspan="5">商务总机业务</td>
							<td>总用户数（家）</td>
							<td class="text-left">${FXxzp.field_16}</td>
						</tr>
						<tr>

							<td>实名率（%）</td>
							<td class="text-left">${FXxzp.field_17}</td>
						</tr>
						<tr>

							<td>老用户核查率（%）</td>
							<td class="text-left">${FXxzp.field_18}</td>
						</tr>
						<tr>
							<td>关停企业（家）</td>
							<td class="text-left">${FXxzp.field_19}</td>
						</tr>
						<tr>
							<td>关停号码（个）</td>
							<td class="text-left">${FXxzp.field_20}</td>
						</tr>
						<tr>
							<td colspan="3"><h5>三、从严管理社会营销渠道</h5></td>
						</tr>
						<tr>
							<td rowspan="2">代理行为监管</td>
							<td>代理商总数（家）</td>
							<td class="text-left">${FXxzp.field_21}</td>
						</tr>
						<tr>
							<td>代理商清理数（家）</td>
							<td class="text-left">${FXxzp.field_22}</td>
						</tr>
						<tr>
							<td colspan="3"><h5>四、严格规范国际通信业务出入口局主叫号码传送</h5></td>
						</tr>
						<tr>
							<td>封堵境外非法透传</td>
							<td>拦截数量（万次）</td>
							<td class="text-left">${FXxzp.field_23}</td>
						</tr>
						<tr>
							<td colspan="3"><h5>五、全面实施语音专线主叫鉴权</h5></td>
						</tr>
						<tr>
							<td rowspan="4">语音专线主叫鉴权</td>
							<td>总电路数（条）</td>
							<td class="text-left">${FXxzp.field_24}</td>
						</tr>
						<tr>
							<td>未完成主叫鉴权电路数（条）</td>
							<td class="text-left">${FXxzp.field_25}</td>
						</tr>
						<tr>
							<td>关停电路数（条）</td>
							<td class="text-left">${FXxzp.field_26}</td>
						</tr>
						<tr>
							<td>主叫鉴权率（%）</td>
							<td class="text-left">${FXxzp.field_27}</td>
						</tr>
						<tr>
							<td colspan="3"><h5>六、加大网内和网间虚假主叫发现与拦截力度</h5></td>
						</tr>
						<tr>
							<td>虚假改号呼叫拦截</td>
							<td>拦截数量（次）</td>
							<td class="text-left">${FXxzp.field_28}</td>
						</tr>
						<tr>
							<td colspan="3"><h5>七、提升用户终端安全防护能力</h5></td>
						</tr>
						<tr>
							<td>非法诈骗链接处置</td>
							<td>处置数量（次）</td>
							<td class="text-left">${FXxzp.field_29}</td>
						</tr>
						<tr>
							<td>防骚扰提醒服务</td>
							<td>总用户数（人）</td>
							<td class="text-left">${FXxzp.field_30}</td>
						</tr>
						<tr>
							<td rowspan="3">骚扰电话整顿</td>
							<td>配置白名单中继线（条）</td>
							<td class="text-left">${FXxzp.field_31}</td>
						</tr>
						<tr>
							<td>关停中继线（条）</td>
							<td class="text-left">${FXxzp.field_32}</td>
						</tr>
						<tr>
							<td>关停号码（个）</td>
							<td class="text-left">${FXxzp.field_33}</td>
						</tr>
						<tr>
							<td colspan="3"><h5>八、积极配合公安机关做好打击查处工作</h5></td>
						</tr>
						<tr>
							<td rowspan="2">配合打击伪基站</td>
							<td>缴获设备（台）</td>
							<td class="text-left">${FXxzp.field_34}</td>
						</tr>
						<tr>
							<td>抓获嫌疑人（人）</td>
							<td class="text-left">${FXxzp.field_35}</td>
						</tr>
						<tr>
							<td colspan="3"><h5>九、畅通社会监督举报渠道</h5></td>
						</tr>
						<tr>
							<td rowspan="3">不良信息举报</td>
							<td>受理举报总数（起）</td>
							<td class="text-left">${FXxzp.field_36}</td>
						</tr>
						<tr>
							<td>平台处置举报（起）</td>
							<td class="text-left">${FXxzp.field_37}</td>
						</tr>
						<tr>
							<td>处置端口（个）</td>
							<td class="text-left">${FXxzp.field_38}</td>
						</tr>
						<tr>
							<td>一键退订</td>
							<td>退订数量（万起）</td>
							<td class="text-left">${FXxzp.field_39}</td>
						</tr>
						<tr>
							<td colspan="3"><h5>十、加强公众教育与宣传引导</h5></td>
						</tr>
						<tr>
							<td rowspan="4">涉诈骗号码提示服务</td>
							<td>发送提醒短信 （条）</td>
							<td class="text-left">${FXxzp.field_40}</td>
						</tr>
						<tr>
							<td>客服回访 （次）</td>
							<td class="text-left">${FXxzp.field_41}</td>
						</tr>
						<tr>
							<td>回访成功 （次）</td>
							<td class="text-left">${FXxzp.field_42}</td>
						</tr>
						<tr>
							<td>推送公安介入 （次）</td>
							<td class="text-left">${FXxzp.field_43}</td>
						</tr>
					</table>
					<table class="entry-table">
						<tr>
							<td>填表公司：${FXxzp.company}</td>
							<td>填表人：${FXxzp.userName}</td>
							<td>联系方式：${FXxzp.mobile}</td>
							<td>电子邮箱：${FXxzp.email}</td>
						</tr>
					</table>
					<p class="text-right">上海市通信管理局制表</p>
				</div>
				</c:otherwise></c:choose>
			</div>
		</div>
	</div>
</body>
</html>