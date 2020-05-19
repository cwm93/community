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
<link href="/assets/global/css/components.min.css" rel="stylesheet" type="text/css" />
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
				<form class="entry-form entry-form-bordered" name="form1" id="form1" action="/nhyk/save" method="post">
				    <div class="alert alert-warning"><a href="#" class="close" data-dismiss="alert">&times;</a>
					<strong>重要提醒！</strong>为规范数据，方便统计，规定：数值类型为小数时，请保留至小数点后两位，不足补0!
					</div>
					<table class="entry-table table-bordered">
					   <thead>
						<tr>
							<td width="15%"><strong>《关于进一步防范和打击通讯信息诈骗工作的实施意见》
									（工信部网安函〔2016〕452号）工作要求</strong></td>
							<td width="5%"><strong>序号</strong></td>
							<td width="35%"><strong>工作落实情况</strong></td>
							<td width="15%"><strong>自查数据</strong></td>
							<td width="15%"><strong>未完成原因</strong></td>
							<td width="15%"><strong>计划完成时间</strong></td>
						</tr>
						<thead>
						<tr>
							<td rowspan="5">一、对已在网使用的行业卡实名登记情况进行重新核实，对未登记或登记信息错误的用户进行补登记，2017年底前实名率达到100%</td>
							<td>1</td>
							<td>存量物联网卡用户数（个）<br/>存量物联网卡用户数=专用号段物联网卡+公众号段物联网卡</td>
							<td><input type="text" class="form-control input-sm" name="field_01" value="${fIndustryCard.field_01}"/></td>
							<td><textarea class="form-control input-sm" name="field_02">${fIndustryCard.field_02}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_03" value="${fIndustryCard.field_03}"/><span class="help-inline">格式：yyyy-MM-dd</span></td>
						</tr>
						<tr>
							<td>2</td>
							<td>其中：2017年累计已补登记的物联网卡用户数（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_04" value="${fIndustryCard.field_04}"/></td>
							<td><textarea class="form-control input-sm" name="field_05">${fIndustryCard.field_05}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_06" value="${fIndustryCard.field_06}"/></td>
						</tr>
						<tr>
							<td>2-1</td>
							<td>存量物联网卡用户中，累计实名制登记到单位和<strong>责任人</strong>的物联网用户数（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_07" value="${fIndustryCard.field_07}"/></td>
							<td><textarea class="form-control input-sm" name="field_08">${fIndustryCard.field_08}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_09" value="${fIndustryCard.field_09}"/></td>
						</tr>
						<tr>
							<td>2-2</td>
							<td>存量物联网卡用户中，累计实名制登记到单位和<strong>使用人</strong>的物联网用户数（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_10" value="${fIndustryCard.field_10}"/></td>
							<td><textarea class="form-control input-sm" name="field_11">${fIndustryCard.field_11}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_12" value="${fIndustryCard.field_12}"/></td>
						</tr>
						<tr>
							<td>3</td>
							<td>物联网卡用户实名补登记完成进度（%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_13" value="${fIndustryCard.field_13}"/><span class="input-group-addon">%</span></div></td>
							<td><textarea class="form-control input-sm" name="field_14">${fIndustryCard.field_14}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_15" value="${fIndustryCard.field_15}"/></td>
						</tr>
						<tr>
							<td rowspan="6">二、原则上新增的行业卡必须使用13位专用号段，并通过专用网络承载相关业务，特殊情况下需使用11位号段且开通无限制语音功能的，必须按照公众移动电话用户进行实名登记</td>
							<td>4</td>
							<td>存量物联网卡用户中，<strong>使用专用号段的物联网卡</strong>用户数（个）<br/> （专用号段包含13位专用号段和11位专用号段）</td>
							<td><input type="text" class="form-control input-sm" name="field_16" value="${fIndustryCard.field_16}"/></td>
							<td><textarea class="form-control input-sm" name="field_17">${fIndustryCard.field_17}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_18" value="${fIndustryCard.field_18}"/></td>
						</tr>
						<tr>
							<td>5</td>
							<td>存量物联网卡用户中，<strong>使用公众号段的物联网卡</strong>用户数（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_19" value="${fIndustryCard.field_19}"/></td>
							<td><textarea class="form-control input-sm" name="field_20">${fIndustryCard.field_20}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_21" value="${fIndustryCard.field_21}"/></td>
						</tr>
						<tr>
							<td>6</td>
							<td>存量物联网卡用户中，<strong>开通语音功能的物联网卡</strong>用户数（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_22" value="${fIndustryCard.field_22}"/></td>
							<td><textarea class="form-control input-sm" name="field_23">${fIndustryCard.field_23}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_24" value="${fIndustryCard.field_24}"/></td>
						</tr>
						<tr>
							<td>7</td>
							<td>其中：<strong>开通无限制语音功能的物联网卡</strong>用户数（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_25" value="${fIndustryCard.field_25}"/></td>
							<td><textarea class="form-control input-sm" name="field_26">${fIndustryCard.field_26}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_27" value="${fIndustryCard.field_27}"/></td>
						</tr>
						<tr>
							<td>7-1</td>
							<td>开通无限制语音功能的物联网卡，已实名补登记到使用人的用户数（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_28" value="${fIndustryCard.field_28}"/></td>
							<td><textarea class="form-control input-sm" name="field_29">${fIndustryCard.field_29}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_30" value="${fIndustryCard.field_30}"/></td>
						</tr>
						<tr>
							<td>7-2</td>
							<td>开通无限制语音功能的物联网卡，已实名补登记到使用人的完成进度（%） <br/>（2017年底前须完成100%）</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_31" value="${fIndustryCard.field_31}"/><span class="input-group-addon">%</span></div></td>
							<td><textarea class="form-control input-sm" name="field_32">${fIndustryCard.field_32}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_33" value="${fIndustryCard.field_33}"/></td>
						</tr>

						<tr>
							<td rowspan="9">三、对新办理使用行业卡的，从严审核行业用户资质、所需行业卡功能、数量及业务量，按照“功能最小化”原则，屏蔽语音、短信功能，并充分利用技术手段对行业卡使用范围（包括可访问IP地址、端口、通话及短信号码等）、使用场景（如设备IMEI与号卡IMSI一一对应）等进行严格限制和绑定</td>
							<td><strong>序号</strong></td>
							<td><strong>业务限制及机卡绑定技术手段
									（请根据本公司实际情况选取目前在用和即将启用的技术手段）</strong></td>
							<td><strong>采用相应技术手段监控的物联网卡用户数（个）</strong></td>
							<td><strong>未采用该技术原因</strong></td>
							<td><strong>计划上线时间</strong></td>
						</tr>
						<tr>
							<td>8</td>
							<td>已采用业务限制及机卡绑定技术手段的号码小计（需剔重）</td>
							<td><input type="text" class="form-control input-sm" name="field_70" value="${fIndustryCard.field_70}"/></td>
							<td><textarea class="form-control input-sm" name="field_71">${fIndustryCard.field_71}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_72" value="${fIndustryCard.field_72}"/></td>
						</tr>
						<tr>
							<td>9</td>
							<td><strong>通信功能限制</strong>：按照最小限度开通业务功能，短信和语音均默认关闭</td>
							<td><input type="text" class="form-control input-sm" name="field_34" value="${fIndustryCard.field_34}"/></td>
							<td><textarea class="form-control input-sm" name="field_35">${fIndustryCard.field_35}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_36" value="${fIndustryCard.field_36}"/></td>
						</tr>
						<tr>
							<td>10</td>
							<td><strong>专用网络限制</strong>：例如，采用“专用APN+专用电路”或者“VPDN隧道+专线”的方式建立VPDN定向网络实现仅访问企业内网功能</td>
							<td><input type="text" class="form-control input-sm" name="field_37" value="${fIndustryCard.field_37}"/></td>
							<td><textarea class="form-control input-sm" name="field_38">${fIndustryCard.field_38}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_39" value="${fIndustryCard.field_39}"/></td>
						</tr>
						<tr>
							<td>11</td>
							<td><strong>定向IP/URL访问控制</strong>：例如，采用专用APN并在M-GGSN上设置或者通过网络侧设置IP访问策略的方式，实现对物联网终端可访问/不可访问特定IP地址/URL的限制功能</td>
							<td><input type="text" class="form-control input-sm" name="field_40" value="${fIndustryCard.field_40}"/></td>
							<td><textarea class="form-control input-sm" name="field_41">${fIndustryCard.field_41}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_42" value="${fIndustryCard.field_42}"/></td>
						</tr>
						<tr>
							<td>12</td>
							<td><strong>使用区域限制</strong>：在HLR上设置漫游区域，限制仅可在上海使用</td>
							<td><input type="text" class="form-control input-sm" name="field_43" value="${fIndustryCard.field_43}"/></td>
							<td><textarea class="form-control input-sm" name="field_44">${fIndustryCard.field_44}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_45" value="${fIndustryCard.field_45}"/></td>
						</tr>

						<tr>
							<td>13</td>
							<td><strong>语音功能限制</strong>：例如，针对某个客户账户下SIM卡设置群组，为每个群组提供语音接听/拨打定向号码能力</td>
							<td><input type="text" class="form-control input-sm" name="field_46" value="${fIndustryCard.field_46}"/></td>
							<td><textarea class="form-control input-sm" name="field_47">${fIndustryCard.field_47}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_48" value="${fIndustryCard.field_48}"/></td>
						</tr>
						<tr>
							<td>14</td>
							<td><strong>机卡关联绑定</strong>：当物联网卡换到其他终端后，后台一旦检测到绑定信息变化，立即停用物联网卡的功能。</td>
							<td><input type="text" class="form-control input-sm" name="field_49" value="${fIndustryCard.field_49}"/></td>
							<td><textarea class="form-control input-sm" name="field_50">${fIndustryCard.field_50}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_51" value="${fIndustryCard.field_51}"/></td>
						</tr>
						<tr>
							<td>14-1</td>
							<td>其中：通过机卡绑定检测到异常使用的物联网用户数（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_52" value="${fIndustryCard.field_52}"/></td>
							<td><textarea class="form-control input-sm" name="field_53">${fIndustryCard.field_53}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_54" value="${fIndustryCard.field_54}"/></td>
						</tr>
						<tr>
							<td rowspan="6">四、按照“谁发卡、谁负责”原则，加强对行业卡使用情况监测和管控，严禁二次销售和违规使用行业卡。对未采取有监测和管控措施，致使行业卡被倒卖或被用于非行业用户的，从严追究企业负责人的责任</td>
							<td><strong>序号</strong></td>
							<td><strong>工作落实情况</strong></td>
							<td><strong>自查数据</strong></td>
							<td><strong>未完成原因</strong></td>
							<td><strong>计划完成时间</strong></td>
						</tr>
						<tr>
							<td>15</td>
							<td><strong>合同回头看</strong>：因合同不规范，缺少主要合同约定内容，包括业务类型、号卡开通功能、销售数量异常、未明确不得进行二次销售等问题，终止合约的存量集团客户数（家）</td>
							<td><input type="text" class="form-control input-sm" name="field_55" value="${fIndustryCard.field_55}"/></td>
							<td><textarea class="form-control input-sm" name="field_56">${fIndustryCard.field_56}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_57" value="${fIndustryCard.field_56}"/></td>
						</tr>
						<tr>
							<td>16</td>
							<td>本月关停物联网卡用户数（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_58" value="${fIndustryCard.field_58}"/></td>
							<td><textarea class="form-control input-sm" name="field_59">${fIndustryCard.field_59}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_60" value="${fIndustryCard.field_60}"/></td>
						</tr>
						<tr>
							<td>17</td>
							<td>2017年累计关停物联网卡用户数（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_61" value="${fIndustryCard.field_61}"/></td>
							<td><textarea class="form-control input-sm" name="field_62">${fIndustryCard.field_62}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_63" value="${fIndustryCard.field_63}"/></td>
						</tr>
						<tr>
							<td>18</td>
							<td>2017年累计被工信部/集团通报的物联网卡用户违规数量（个）</td>
							<td><input type="text" class="form-control input-sm" name="field_64" value="${fIndustryCard.field_64}"/></td>
							<td><textarea class="form-control input-sm" name="field_65">${fIndustryCard.field_65}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_66" value="${fIndustryCard.field_66}"/></td>
						</tr>
						<tr>
							<td>19</td>
							<td>2017年处罚人员数量（人）</td>
							<td><input type="text" class="form-control input-sm" name="field_67" value="${fIndustryCard.field_67}"/></td>
							<td><textarea class="form-control input-sm" name="field_68">${fIndustryCard.field_68}</textarea></td>
							<td><input type="text" class="form-control input-sm" name="field_69" value="${fIndustryCard.field_69}"/></td>
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
						 <div class="col-xs-12 text-center mt-checkbox-list">
								<input type="checkbox" id="accept"/>本人承诺以上申报数据真实有效，有据可查！
								<input type="hidden" name="reportLogId"value="${reportLog.id}" /> 
								<input type="hidden" name="insertUserId" value="${curUser.id}" /> 
								<input type="hidden" name="id" value="${fIndustryCard.id}" />
								<input type="hidden" name="telecomOperatorId" value="${curUser.telecomOperator.id}" />
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