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
				<form class="entry-form entry-form-bordered">
				    <p>注：项目1为可选填项，可随时更新；项目2、3、4为每月定期报送必填项，请注意统计口径。请于每月15日前报送上月自查情况。谢谢！</p>
					<table class="entry-table text-left" style="width:720px;margin:0 auto;">
						<tr>
							<td width="55%;">企业名称</td>
							<td width="45%;"><input type="text" class="form-control input-sm" name="field_01" value="${fResaleRealNameRegistration.field_01}"/></td>
						</tr>
						<tr>
							<td width="45%;">统计日期</td>
							<td width="55%;"><input type="text" class="form-control input-sm" name="field_02" value="${fResaleRealNameRegistration.field_02}"/></td>
						</tr>
						<tr><td colspan="2" class="text-left"><h5>1、转售企业基本信息</h5></td></tr>
						<tr><td colspan="2" class="text-left pd-left-15"><h5>1.1上海地区公司负责人</h5></td></tr>
						<tr>
							<td class="pd-left-30">1.1.1姓名</td>
							<td><input type="text" class="form-control input-sm" name="field_03" value="${fResaleRealNameRegistration.field_03}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">1.1.2联系电话</td>
							<td><input type="text" class="form-control input-sm" name="field_04" value="${fResaleRealNameRegistration.field_04}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">1.1.3联系邮箱</td>
							<td><input type="text" class="form-control input-sm" name="field_05" value="${fResaleRealNameRegistration.field_05}"/></td>
						</tr>
						<tr><td colspan="2" class="text-left pd-left-15"><h5>1.2上海地区实名制负责人</h5></td></tr>
						<tr>
							<td class="pd-left-30">1.2.1姓名</td>
							<td><input type="text" class="form-control input-sm" name="field_06" value="${fResaleRealNameRegistration.field_06}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">1.2.2联系电话</td>
							<td><input type="text" class="form-control input-sm" name="field_07" value="${fResaleRealNameRegistration.field_07}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">1.2.3联系邮箱</td>
							<td><input type="text" class="form-control input-sm" name="field_08" value="${fResaleRealNameRegistration.field_08}"/></td>
						</tr>
						<tr><td colspan="2" class="text-left pd-left-15"><h5>1.3上海地区实名制违规行为举报渠道</h5></td></tr>
						<tr>
							<td class="pd-left-30">1.3.1举报电话</td>
							<td><input type="text" class="form-control input-sm" name="field_09" value="${fResaleRealNameRegistration.field_09}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">1.3.2举报邮箱</td>
							<td><input type="text" class="form-control input-sm" name="field_10" value="${fResaleRealNameRegistration.field_10}"/></td>
						</tr>
						<tr><td colspan="2" class="text-left"><h5>2、上海地区转售业务经营和财务状况</h5></td></tr>
						<tr><td colspan="2" class="pd-left-15"><h5>2.1转售业务经营状况</h5></td></tr>
						<tr>
							<td class="pd-left-30">2.1.1上海地区本年度累计上月月底仍在网的移动电话用户数量（户）<span class="help-info blue">（2.1.1数据中应包含2.1.2和2.1.3）</span></td>
							<td><input type="text" class="form-control input-sm" name="field_11" value="${fResaleRealNameRegistration.field_11}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">2.1.2上海地区本年度累计上月月底仍在网的单位用户数量（户）</td>
							<td><input type="text" class="form-control input-sm" name="field_12" value="${fResaleRealNameRegistration.field_12}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">2.1.3上海地区本年度累计上月月底仍在网的行业应用上网卡数量（户）</td>
							<td><input type="text" class="form-control input-sm" name="field_13" value="${fResaleRealNameRegistration.field_13}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">2.1.4上海地区上一月新增补登记数量（户）</td>
							<td><input type="text" class="form-control input-sm" name="field_14" value="${fResaleRealNameRegistration.field_14}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">2.1.5上海地区本年度累计上月月底补登记数量（户）</td>
							<td><input type="text" class="form-control input-sm" name="field_15" value="${fResaleRealNameRegistration.field_15}"/></td>
						</tr>
						<tr><td colspan="2" class="pd-left-15"><h5>2.2转售企业财务状况</h5></td></tr>
						<tr>
							<td class="pd-left-30">2.2.1上海地区本年度累计上月月底移动转售业务收入（万元）<span class="help-info">（此项为统计收入，并非利润，不应有负数）</span></td>
							<td><input type="text" class="form-control input-sm" name="field_16" value="${fResaleRealNameRegistration.field_16}"/></td>
						</tr>
						<tr><td colspan="2"><h5>3、社会渠道网点信息和二代证识别设备配备情况（截止统计日）</h5></td></tr>
						<tr><td colspan="2" class="pd-left-15"><h5>3.1、社会渠道网点信息</h5></td></tr>
						<tr>
							<td class="pd-left-30">3.1.1上海地区社会渠道签约数量（实体代理店数）</td>
							<td><input type="text" class="form-control input-sm" name="field_17" value="${fResaleRealNameRegistration.field_17}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">3.1.2上海地区社会渠道签约数量（网络代理店数）</td>
							<td><input type="text" class="form-control input-sm" name="field_18" value="${fResaleRealNameRegistration.field_18}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">3.1.3上海地区社会渠道统一配发授权牌数量（张）</td>
							<td><input type="text" class="form-control input-sm" name="field_19" value="${fResaleRealNameRegistration.field_19}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">3.1.4上海地区网络销售渠道售卡是否执行二次认证规范（是/否）</td>
							<td class="mt-radio-list" data-error-container="#form_field_20_error"><input type="radio" name="field_20" value="1" <c:if test="${fResaleRealNameRegistration.field_20==1}">checked</c:if>/>是&nbsp;&nbsp;&nbsp;<input type="radio" name="field_20" value="0" <c:if test="${fResaleRealNameRegistration.field_24==0}">checked</c:if>/>否<div id="form_field_20_error"> </div></td>
						</tr>
						<tr><td colspan="2" class="pd-left-15"><h5>3、2实体渠道二代证识别设备配备情况</h5></td></tr>
						<tr>
							<td class="pd-left-30">3.2.1二上海地区二代证识别设备铺设情况（已配备台数）</td>
							<td><input type="text" class="form-control input-sm" name="field_21" value="${fResaleRealNameRegistration.field_21}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">3.2.2其他身份核验手段（请文字说明）</td>
							<td><textarea class="form-control input-sm" name="field_22" rows="5">${fResaleRealNameRegistration.field_22}</textarea></td>
						</tr>
						<tr><td colspan="2"><h5>4、实体渠道二代证识别设备配备情况</h5></td></tr>
						<tr><td colspan="2" class="pd-left-15"><h5>4.1实名登记规范自查情况</h5></td></tr>
						<tr>
							<td class="pd-left-30">4.1.1仅受理居民身份证件（是/否）</td>
							<td class="mt-radio-list" data-error-container="#form_field_23_error"><input type="radio" name="field_23" value="1" <c:if test="${fResaleRealNameRegistration.field_23==1}">checked</c:if>/>是&nbsp;&nbsp;&nbsp;<input type="radio" name="field_23" value="0" <c:if test="${fResaleRealNameRegistration.field_24==0}">checked</c:if>/>否<div id="form_field_23_error"> </div></td>
						</tr>
						<tr>
							<td class="pd-left-30">4.1.2未配备二代证识别设备的社会营销网点不得违规办理（是/否）</td>
							<td class="mt-radio-list" data-error-container="#form_field_24_error"><input type="radio" name="field_24" value="1" <c:if test="${fResaleRealNameRegistration.field_24==1}">checked</c:if> />是&nbsp;&nbsp;&nbsp;<input type="radio" name="field_24" value="0" <c:if test="${fResaleRealNameRegistration.field_24==0}">checked</c:if>/>否<div id="form_field_24_error"> </div></td>
						</tr>
						<tr>
							<td class="pd-left-30">4.1.3用户登记信息是否主动做好人证一致性核验（是/否）</td>
							<td class="mt-radio-list" data-error-container="#form_field_25_error"><input type="radio" name="field_25" value="1" <c:if test="${fResaleRealNameRegistration.field_25==1}">checked</c:if>/>是&nbsp;&nbsp;&nbsp;<input type="radio" name="field_25" value="0" <c:if test="${fResaleRealNameRegistration.field_25==0}">checked</c:if>/>否<div id="form_field_25_error"> </div></td>
						</tr>
						<tr>
							<td class="pd-left-30">4.1.4本年度累计上月月底网络售卡代理清理数量（家）</td>
							<td><input type="text" class="form-control input-sm" name="field_26" value="${fResaleRealNameRegistration.field_26}"/></td>
						</tr>
						<tr><td colspan="2" class="pd-left-15"><h5>4.2实名登记违规处罚情况</h5></td></tr>
						<tr>
							<td class="pd-left-30">4.2.1上一月检查次数</td>
							<td><input type="text" class="form-control input-sm" name="field_27" value="${fResaleRealNameRegistration.field_27}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">4.2.2本年度累计上月月底自查次数</td>
							<td><input type="text" class="form-control input-sm" name="field_28" value="${fResaleRealNameRegistration.field_28}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">4.2.3本年度累计上月月底处罚和取消代理网点数</td>
							<td><input type="text" class="form-control input-sm" name="field_29" value="${fResaleRealNameRegistration.field_29}"/></td>
						</tr>
						<tr>
							<td class="pd-left-30">4.2.4本年度累计上月月底处罚人员数</td>
							<td><input type="text" class="form-control input-sm" name="field_30" value="${fResaleRealNameRegistration.field_30}"/></td>
						</tr>
					</table>
					<table class="entry-table">
						<tr>
							<td>填表公司：<input type="text" class="form-control input-sm" name="company" value="${curUser.company}"/></td>
							<td>填表人：<input type="text" class="form-control input-sm" name="userName" value="${curUser.realname}"/></td>
							<td>联系方式：<input type="text" class="form-control input-sm" name="mobile" value="${curUser.mobile}"/></td>
							<td>电子邮箱： <input type="text" class="form-control input-sm" name="email" value="${curUser.email}"/></td>
						</tr>
					</table>
					<p class="text-right">上海市通信管理局制表</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>