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
				<c:choose><c:when test="${reportLog.auditStatus=='1'}">
					<div class="entry-form entry-form-bordered none-data">
							<span style="font-size:16px;">该表单已被审核通过不可编辑</span><a href="/yhsmz/view/${reportLog.id }" style="margin:0 8px;text-decoration:none;">查看s<i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
					</div>
				</c:when><c:otherwise>
				<form class="entry-form entry-form-bordered" name="form1" id="form1" action="/yhsmz/save" method="post">
					<div class="alert alert-warning"><a href="#" class="close" data-dismiss="alert">&times;</a>
					<strong>重要提醒！</strong>为规范数据，方便统计，规定：数值类型为小数时，请保留至小数点后两位，不足补0!
					</div>
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
							<td width="10%"><div class="input-group"><input type="text" class="form-control input-sm" name="field_01" value="${fPhoneUserRealIdentity.field_01}"/><span class="input-group-addon">万户</span></div></td>
							<td width="10%"><div class="input-group"><input type="text" class="form-control input-sm" name="field_02" value="${fPhoneUserRealIdentity.field_02}"/><span class="input-group-addon">万户</span></div></td>
							<td width="10%"><div class="input-group"><input type="text" class="form-control input-sm" name="field_03" value="${fPhoneUserRealIdentity.field_03}"/><span class="input-group-addon">万户</span></div></td>
							<td width="10%"><div class="input-group"><input type="text" class="form-control input-sm" name="field_04" value="${fPhoneUserRealIdentity.field_04}"/><span class="input-group-addon">万户</span></div></td>
							<td width="10%"><div class="input-group"><input type="text" class="form-control input-sm" name="field_05" value="${fPhoneUserRealIdentity.field_05}"/><span class="input-group-addon">万户</span></div></td>
							<td width="10%"><div class="input-group"><input type="text" class="form-control input-sm" name="field_06" value="${fPhoneUserRealIdentity.field_06}"/><span class="input-group-addon">万户</span></div></td>
						</tr>
						<tr>
						   <td>已登记实名制用户数</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_07" value="${fPhoneUserRealIdentity.field_07}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_08" value="${fPhoneUserRealIdentity.field_08}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_09" value="${fPhoneUserRealIdentity.field_09}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_10" value="${fPhoneUserRealIdentity.field_10}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_11" value="${fPhoneUserRealIdentity.field_11}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_12" value="${fPhoneUserRealIdentity.field_12}"/><span class="input-group-addon">万户</span></div></td>
						</tr>
						<tr>
						    <td>实名率</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_13" value="${fPhoneUserRealIdentity.field_13}" placeholder="100.00" ><span class="input-group-addon">%</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_14" value="${fPhoneUserRealIdentity.field_14}" placeholder="100.00" ><span class="input-group-addon">%</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_15" value="${fPhoneUserRealIdentity.field_15}" placeholder="100.00" ><span class="input-group-addon">%</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_16" value="${fPhoneUserRealIdentity.field_16}" placeholder="100.00" ><span class="input-group-addon">%</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_17" value="${fPhoneUserRealIdentity.field_17}" placeholder="100.00" ><span class="input-group-addon">%</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_18" value="${fPhoneUserRealIdentity.field_18}" placeholder="100.00" ><span class="input-group-addon">%</span></div></td>
						</tr>
						<tr>
						    <td>补登记实名制用户数</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_19" value="${fPhoneUserRealIdentity.field_19}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_20" value="${fPhoneUserRealIdentity.field_20}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_21" value="${fPhoneUserRealIdentity.field_21}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_22" value="${fPhoneUserRealIdentity.field_22}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_23" value="${fPhoneUserRealIdentity.field_23}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_24" value="${fPhoneUserRealIdentity.field_24}"/><span class="input-group-addon">万户</span></div></td>
						</tr>
						<tr>
						    <td>环比增加率</td>
							<td colspan="2"><div class="input-group"><input type="text" class="form-control input-sm" name="field_25" value="${fPhoneUserRealIdentity.field_25}" placeholder="100.00" ><span class="input-group-addon">%</span></div></td>
							<td colspan="2"><div class="input-group"><input type="text" class="form-control input-sm" name="field_26" value="${fPhoneUserRealIdentity.field_26}" placeholder="100.00" ><span class="input-group-addon">%</span></div></td>
							<td colspan="2"><div class="input-group"><input type="text" class="form-control input-sm" name="field_27" value="${fPhoneUserRealIdentity.field_27}" placeholder="100.00" ><span class="input-group-addon">%</span></div></td>
						</tr>
						<tr>
						    <td>后付费用户数</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_28" value="${fPhoneUserRealIdentity.field_28}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_29" value="${fPhoneUserRealIdentity.field_29}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_30" value="${fPhoneUserRealIdentity.field_30}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_31" value="${fPhoneUserRealIdentity.field_31}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_32" value="${fPhoneUserRealIdentity.field_32}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_33" value="${fPhoneUserRealIdentity.field_33}"/><span class="input-group-addon">万户</span></div></td>
						</tr>
						<tr>
						    <td>预付费用户数</td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_34" value="${fPhoneUserRealIdentity.field_34}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_35" value="${fPhoneUserRealIdentity.field_35}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_36" value="${fPhoneUserRealIdentity.field_36}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_37" value="${fPhoneUserRealIdentity.field_37}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_38" value="${fPhoneUserRealIdentity.field_38}"/><span class="input-group-addon">万户</span></div></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_39" value="${fPhoneUserRealIdentity.field_39}"/><span class="input-group-addon">万户</span></div></td>
						</tr>
						<tr>
							<td rowspan="2" class="text-center">自营厅</td>
							<td colspan="3" class="text-center">总数</td>
						    <td colspan="3"><input type="text" class="form-control input-sm" name="field_40" value="${fPhoneUserRealIdentity.field_40}"/></td>
						</tr>
						<tr>
							<td colspan="3" class="text-center">本月发展新用户占比</td>
							<td colspan="3"><div class="input-group"><input type="text" class="form-control input-sm" name="field_41" value="${fPhoneUserRealIdentity.field_41}" placeholder="100.00" ><span class="input-group-addon">%</span></div></td>
						</tr>
						<tr>
							<td colspan="2" class="text-center">合作厅/专营店</td>
							<td colspan="5"><input type="text" class="form-control input-sm" name="field_42" value="${fPhoneUserRealIdentity.field_42}"/></td>
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
							<td><input type="text" class="form-control input-sm" name="field_43" value="${fPhoneUserRealIdentity.field_43}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_44" value="${fPhoneUserRealIdentity.field_44}"/></td>
							<td><input type="text" class="form-control input-sm" name="field_73" value="${fPhoneUserRealIdentity.field_73}"/></td>
							<td><div class="input-group"><input type="text" class="form-control input-sm" name="field_74" value="${fPhoneUserRealIdentity.field_74}" placeholder="100.00" ><span class="input-group-addon">%</span></div></td>
							<td><input type="text" class="form-control input-sm" name="field_45" value="${fPhoneUserRealIdentity.field_45}"/></td>
							<td colspan="2"><input type="text" class="form-control input-sm" name="field_46" value="${fPhoneUserRealIdentity.field_46}"/></td>
						</tr>
						<tr>
						    <td colspan="2">售卡数小计</td>
							<td colspan="5"><input type="text" class="form-control input-sm" name="field_75" value="${fPhoneUserRealIdentity.field_75}"/></td>
						</tr><tr>
						    <td colspan="2">售卡拍照核验数小计</td>
							<td colspan="5"><input type="text" class="form-control input-sm" name="field_76" value="${fPhoneUserRealIdentity.field_76}"/></td>
						</tr><tr>
						    <td colspan="2">售卡拍照核验通过数小计</td>
							<td colspan="5"><input type="text" class="form-control input-sm" name="field_77" value="${fPhoneUserRealIdentity.field_77}"/></td>
						</tr><tr>
						    <td colspan="2">售卡拍照核验合规率（%）</td>
							<td colspan="5"><div class="input-group"><input type="text" class="form-control input-sm" name="field_78" value="${fPhoneUserRealIdentity.field_78}" placeholder="100.00" ><span class="input-group-addon">%</span></div></td>
						</tr>
						<tr>
						    <td colspan="2">实名登记APP终端数</td>
							<td colspan="5"><input type="text" class="form-control input-sm" name="field_47" value="${fPhoneUserRealIdentity.field_47}"/></td>
						</tr>
						<tr>
						    <td colspan="2">已禁止实名登记人工录入终端数</td>
							<td colspan="2"><input type="text" class="form-control input-sm" name="field_48" value="${fPhoneUserRealIdentity.field_48}"/></td>
						    <td>实名登记自动录入终端数</td>
							<td colspan="2"><input type="text" class="form-control input-sm" name="field_49" value="${fPhoneUserRealIdentity.field_49}"/></td>
						</tr>
						<tr>
						    <td colspan="2">二代身份证识别仪数</td>
							<td colspan="2"><input type="text" class="form-control input-sm" name="field_50" value="${fPhoneUserRealIdentity.field_50}"/></td>
						    <td>二代身份证识别设备网点数</td>
							<td colspan="2"><input type="text" class="form-control input-sm" name="field_51" value="${fPhoneUserRealIdentity.field_51}"/></td>
						</tr>
						<tr>
						    <td rowspan="2" colspan="2">行业应用无线上网卡</td>
							<td>单位数</td>
						    <td><input type="text" class="form-control input-sm" name="field_52" value="${fPhoneUserRealIdentity.field_52}"/></td>
							<td rowspan="2">单位责任人</td>
							<td>已登记数</td>
							<td><input type="text" class="form-control input-sm" name="field_53" value="${fPhoneUserRealIdentity.field_53}"/></td>
						</tr>
						<tr>
						    <td>卡数</td>
							<td><input type="text" class="form-control input-sm" name="field_54" value="${fPhoneUserRealIdentity.field_54}"/></td>
						    <td>未登记数</td>
							<td><input type="text" class="form-control input-sm" name="field_55" value="${fPhoneUserRealIdentity.field_55}"/></td>
						</tr>
						<tr>
						    <td rowspan="2" colspan="2">集团用户电话卡（含无线上网卡）</td>
							<td>单位数</td>
						    <td><input type="text" class="form-control input-sm" name="field_56" value="${fPhoneUserRealIdentity.field_56}"/></td>
							<td rowspan="2">登记到用户个人</td>
							<td>已登记数</td>
							<td><input type="text" class="form-control input-sm" name="field_57" value="${fPhoneUserRealIdentity.field_57}"/></td>
						</tr>
						<tr>
						    <td>卡数</td>
							<td><input type="text" class="form-control input-sm" name="field_58" value="${fPhoneUserRealIdentity.field_58}"/></td>
						    <td>未登记数</td>
							<td><input type="text" class="form-control input-sm" name="field_59" value="${fPhoneUserRealIdentity.field_59}"/></td>
						</tr>
						<tr>
						    <td colspan="2">同一身份证件登记5张以上移动电话卡</td>
							<td colspan="5"><table class="entry-table">
									<tr>
										<td width="10%">卡数</td>
										<td width="10%"><input type="text" class="form-control input-sm" name="field_60" value="${fPhoneUserRealIdentity.field_60}"/></td>
										<td width="10%">用户数</td>
										<td width="10%"><input type="text" class="form-control input-sm" name="field_61" value="${fPhoneUserRealIdentity.field_61}"/></td>
										<td width="10%">已核查</td>
										<td width="10%"><input type="text" class="form-control input-sm" name="field_62" value="${fPhoneUserRealIdentity.field_62}"/></td>
										<td width="10%">已完成补登记数</td>
										<td width="10%"><input type="text" class="form-control input-sm" name="field_63" value="${fPhoneUserRealIdentity.field_63}"/></td>
									</tr>
								</table></td>
						</tr>
						<tr>
							<td colspan="2">漫游至新疆和西藏超过2个月的用户</td>
							<td colspan="5"><table class="entry-table">
									<tr>
										<td width="10%">卡数</td>
										<td width="10%"><input type="text" class="form-control input-sm" name="field_64" value="${fPhoneUserRealIdentity.field_64}"/></td>
										<td width="10%">用户数</td>
										<td width="10%"><input type="text" class="form-control input-sm" name="field_65" value="${fPhoneUserRealIdentity.field_65}"/></td>
										<td width="10%">已核查</td>
										<td width="10%"><input type="text" class="form-control input-sm" name="field_66" value="${fPhoneUserRealIdentity.field_66}"/></td>
										<td width="10%">已完成补登记数</td>
										<td width="10%"><input type="text" class="form-control input-sm" name="field_67" value="${fPhoneUserRealIdentity.field_67}"/></td>
									</tr>
								</table></td>
						</tr>
						<tr>
						    <td colspan="2">社会渠道授权牌应配发总数</td>
							<td><input type="text" class="form-control input-sm" name="field_68" value="${fPhoneUserRealIdentity.field_68}"/></td>
							<td>本月新增</td>
							<td><input type="text" class="form-control input-sm" name="field_69" value="${fPhoneUserRealIdentity.field_69}"/></td>
							<td>社会渠道授权牌未配发总数</td>
							<td><input type="text" class="form-control input-sm" name="field_70" value="${fPhoneUserRealIdentity.field_70}"/></td>
						</tr>
						<tr>
						    <td colspan="2">本月终止违规代理商数</td>
							<td colspan="2"><input type="text" class="form-control input-sm" name="field_71" value="${fPhoneUserRealIdentity.field_71}"/></td>
							<td>上报黑名单数</td>
							<td  colspan="2"><input type="text" class="form-control input-sm" name="field_72" value="${fPhoneUserRealIdentity.field_72}"/></td>
						</tr>
					</table>
					<p><strong>注：</strong><br />1、“环比增加率”：本月末“实名率”与上月末“实名率”相比，增加了多少百分点；<br />
						2、“本月发展新用户占比”：指本月自营厅发展的新用户占本月所有新用户的比例；<br />
						3、“开展真实身份信息登记代理点数”：指销售电话卡并对用户进行真实身份信息登记的代理点个数；<br />
					</p>
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
								本人承诺以上申报数据真实有效，有据可查！&nbsp;&nbsp;<input type="checkbox" id="accept"/>
							<input type="hidden" name="reportLogId" value="${reportLog.id}"/> 
							<input type="hidden" name="insertUserId" value="${curUser.id}"/>
							<input type="hidden" name="telecomOperatorId" value="${curUser.telecomOperator.id}"/>
							<input type="hidden" name="id" value="${fPhoneUserRealIdentity.id}"/>
							<input type="hidden" name="flag" id="flag" value="0"/>
						</div>
						<div class="col-xs-12 text-center">
								<button type="button" id="formSave"class="btn btn-sm btn-danger"><i class="fa fa-check"></i>保存不提交</button>
								<button type="submit" id="formSubmit"class="btn btn-sm btn-success"><i class="fa fa-check"></i>保存并提交</button>
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