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
<link href="/assets/pages/css/form.css?20190612" rel="stylesheet" type="text/css" />
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
				<h5 class="form-title">物联网行业卡安全管理</h5>
				<form class="entry-form entry-form-bordered" name="form1" id="form1" action="#" method="post">
					<table class="entry-table table-bordered">
					    <thead>
						<tr>
							<th class="text-center" width="5%">分类</th>
							<th class="text-center" width="5%" >序号</th>
							<th class="text-center" width="10%">统计内容</th>
							<th class="text-center" width="5%">统计单位</th>
							<th class="text-center" width="10%">数值</th>
							<th class="text-center" width="10%">备注</th>
						</tr></thead>
						<tr>
							<td class="text-center" rowspan="5">实名登记情况</td>
							<td class="text-center" >1</td>
							<td class="text-center">本月新增物联网行业卡</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_11" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >2</td>
							<td class="text-center">累计发展物联网行业卡</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_12" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >3</td>
							<td class="text-center">登记到责任单位和责任人</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_13" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >4</td>
							<td class="text-center">登记到实际使用人</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_14" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >5</td>
							<td class="text-center">物联网行业卡用户实名登记率</td>
							<td class="text-center">百分比（%）</td>
							<td class="text-center"><div class="input-group"><input type="text" class="form-control input-sm" name="field_15" value="" readOnly/><span class="input-group-addon">%</span></div></td>
							<td class="text-center">实名登记率=(登记到责任单位和责任人号卡数+登记到实际使用人号卡数)/累计发展物联网行业卡号卡数</td>
						</tr>
						<tr>
							<td class="text-center" rowspan="9">按功能限制分类统计</td>
							<td class="text-center" >6</td>
							<td class="text-center">执行“功能最小化”业务限制</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_21" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >7</td>
							<td class="text-center">短信和语音均默认关闭</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_22" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >8</td>
							<td class="text-center">机卡关联绑定</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_23" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">9</td>
							<td class="text-center" rowspan="2">开通非定向语音</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_24" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_242" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">10</td>
							<td class="text-center" rowspan="2">开通非定向短信</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_25" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_252" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">11</td>
							<td class="text-center" rowspan="2">开通非定向上网/流量</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_26" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_262" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="12">按业务场景分类统计</td>
							<td class="text-center" rowspan="2">12</td>
							<td class="text-center" rowspan="2">公共事业</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_31" value=""/></td>
							<td class="text-center">如市政设施管理、智能抄表、智慧停车、安防监控等</td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_312" value=""/></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">13</td>
							<td class="text-center" rowspan="2">零售服务</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_32" value=""/></td>
							<td class="text-center">如无线POS机、自动售货机、照片打印机等</td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_322" value=""/></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">14</td>
							<td class="text-center" rowspan="2">车联网</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_33" value=""/></td>
							<td class="text-center">如智能后视镜、T-BOX、导航监控等</td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_332" value=""/></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">15</td>
							<td class="text-center" rowspan="2">能源管理</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_34" value=""/></td>
							<td class="text-center" rowspan="2">如充电桩、空调监控、蓄电池监控等</td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_342" value=""/></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">16</td>
							<td class="text-center" rowspan="2">工业物联网</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_35" value=""/></td>
							<td class="text-center" rowspan="2">如工业自动化生产线、阀门设施监控</td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_352" value=""/></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="2">17</td>
							<td class="text-center" rowspan="2">其他场景</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_36" value=""/></td>
							<td class="text-center" rowspan="2">如智慧家庭、智慧医疗、智慧物流等其他场景</td>
						</tr>
						<tr>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_362" value=""/></td>
						</tr>
						<tr>
							<td class="text-center" rowspan="7">监测与管控</td>
							<td class="text-center" >18</td>
							<td class="text-center">合同回头看终止客户数</td>
							<td class="text-center">客户数（家）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_41" value=""/></td>
							<td class="text-center">因合同不规范、缺少关键约定内容而终止的合约</td>
						</tr>
						<tr>
							<td class="text-center" >19</td>
							<td class="text-center">本月使用流量大于100MB号卡数</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_42" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >20</td>
							<td class="text-center">本月监测异常号卡数</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_43" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >21</td>
							<td class="text-center">本月关停号卡数</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="number" class="form-control input-sm" name="field_44" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >22</td>
							<td class="text-center">本年累计关停号卡数</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_45" value=""/></td>
							<td class="text-center"></td>
						</tr>
						<tr>
							<td class="text-center" >23</td>
							<td class="text-center">本年累计被通报违规号卡数</td>
							<td class="text-center">号卡数（个）</td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_46" value=""/></td>
							<td class="text-center">工信部和各企业集团公司通报的违规号卡数量</td>
						</tr>
						<tr>
							<td class="text-center" >24</td>
							<td class="text-center">本年累计处罚人员</td>
							<td class="text-center">人员数（个）</td>
							<td class="text-center"><input type="text" class="form-control input-sm" name="field_47" value=""/></td>
							<td class="text-center"></td>
						</tr>
					</table>
					<h5>按号段分类统计（全量统计，含未定向分配号段数）</h5>
					<table class="entry-table table-bordered">
						<thead><tr><th>专用/公用号段</th><th>11位/13位号段</th><th>号段明细</th><th>总数（个）</th><th>已使用个数（个）</th><th>未使用个数（个）</th><th>操作</th></tr></thead>
						<tbody id="trlist"></tbody>
						<tfoot style="margin-top:15px;"><tr>
						<td><select class="form-control input-sm" id="type"><option value="">请选择</option><option value="1">专用</option><option value="2">公用</option></select></td>
						<td><select class="form-control input-sm" id="digitType"><option value="">请选择</option><option value="11">11位</option><option value="13">13位</option></select></td>
						<td><input type="text" class="form-control input-sm" name="hdmx"></td>
						<td><input type="number" class="form-control input-sm" name="amount"></td>
						<td><input type="number" class="form-control input-sm" name="usedAmount"></td>
						<td><input type="text" class="form-control input-sm" name="unusedAmount" placeholder="系统自行计算" readOnly></td>
						<td><button class="btn btn-sm btn-primary" id="addrow">添加</button></td>
						</tr></tfoot>
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
							<div class="col-xs-12 text-center" style="font-size: 14px; margin: 8px 0;">
								本人承诺以上申报数据真实有效，有据可查！&nbsp;&nbsp;<input type="checkbox" id="accept" /> 
							</div>
							<div class="col-xs-12 text-center">
								<button type="button" id="formSave"class="btn btn-sm btn-danger" disabled><i class="fa fa-check"></i>保存不提交</button>
								<button type="submit" id="formSubmit"class="btn btn-sm btn-success" disabled><i class="fa fa-check"></i>保存并提交</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script src="/assets/apps/scripts/common-form.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {
			$('input[name=field_12]').bind('input propertychange change',function(event){
				countProcess();
			})
			$('input[name=field_13]').bind('input propertychange change',function(event){
				countProcess();
			})
			$('input[name=field_14]').bind('input propertychange change',function(event){
				countProcess();
			})
			getIotManagementSegmentList();
			$("#addrow").click(function(event){
				event.preventDefault();
				var digitType = $('#digitType').val();
				var type = $('#type').val();
				var hdmx = $('input[name=hdmx]').val();
				var amount = $('input[name=amount]').val();
				var usedAmount = $('input[name=usedAmount]').val();
				var company = $('input[name=company]').val();
				var userName = $('input[name=userName]').val();
				var mobile = $('input[name=mobile]').val();
				var email = $('input[name=email]').val();
				var reportLogId = $('input[name=reportLogId]').val();
				var insertUserId = $('input[name=insertUserId]').val();
				var telecomOperatorId = $('input[name=telecomOperatorId]').val();
				if(type==''){
					layer.msg('请选择专用或者公用', { icon : 0});
					return ;
				}
				if(digitType==''){
					layer.msg('请选择11位或者13位', { icon : 0});
					return ;
				}
				if(hdmx==''){
					layer.msg('号段明细不能为空', { icon : 0});
					return ;
				}
				if(amount==''){
					layer.msg('总数不能为空', { icon : 0});
					return ;
				}
				if(usedAmount==''){
					layer.msg('已使用个数不为空', { icon : 0});
					return ;
				}
				$('input[name=unusedAmount]').val(amount-usedAmount);
				var unusedAmount = $('input[name=unusedAmount]').val();
				//
				
				
			});
		})
		var countProcess = function(){
			var field_12 = $('input[name=field_12]').val();
			var field_13 = $('input[name=field_13]').val();
			var field_14 = $('input[name=field_14]').val();
			if(field_12!=''&&field_13!=''&&field_14!=''){
				$('input[name=field_15]').val(Math.round((Number(field_13)+Number(field_14))/field_12*10000)/100.00);
			}
		}
		
	</script>
</body>
</html>