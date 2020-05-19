<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<style>
.entry-table {
	text-align: left;
}
.error {
	color: red;
}
</style>
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="top-title">上海市通信管理局<span>市场业务报表综合分析管理</span><a href="javascript:window.history.go(-1);" class="right btn btn-sm yellow"> 返回 <i class="fa fa-undo"></i></a></h1>
				<h5 class="form-title">骚扰电话举报分类汇总表</h5>
				<div class="panel panel-warning">
					<div class="panel-body">
						<form class="entry-form">
							<table class="entry-table table-bordered">
						<thead>
						    <tr> 
						    	<th class="text-center">归属部门</th>
								<th class="text-center">总举报数量</th>
								<th class="text-center">举报分类科目</th>
								<th class="text-center">举报数量</th>
								<th class="text-center">具体案例描述（填写有明确指向拨打主体的案例）</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center" rowspan="3">公安部门</td>
								<td class="text-center" rowspan="3"><input type="text" class="form-control input-sm" name="field_000" placeholder="请输入整数"></td>
								<td class="text-center">淫秽色情</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_011" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_012" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
							    <td class="text-center">发票办证</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_021" placeholder="请输入整数"></td>
								<td class="text-center"><textarea type="text" class="form-control input-sm" name="field_022" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
							    <td class="text-center">诈骗反诈</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_031" placeholder="请输入整数"></td>
								<td class="text-center"><textarea type="text" class="form-control input-sm" name="field_032" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center" rowspan="2">银监会</td>
								<td class="text-center" rowspan="2"><input type="text" class="form-control input-sm" name="field_100" placeholder="请输入整数"></td>
								<td class="text-center">贷款理财</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_111" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_112" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
							    <td class="text-center">催收电话</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_121" placeholder="请输入整数"></td>
								<td class="text-center"><textarea type="text" class="form-control input-sm" name="field_122" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center">证监会</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_200" placeholder="请输入整数"></td>
								<td class="text-center">股票证券</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_211" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_212" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center">保监会</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_300" placeholder="请输入整数"></td>
								<td class="text-center">保险推销</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_311" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_312" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center">住建部（房管局）</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_400" placeholder="请输入整数"></td>
								<td class="text-center">房产中介</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_411" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_412" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center">教育部</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_500" placeholder="请输入整数"></td>
								<td class="text-center">教育培训</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_511" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_512" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center">卫计委、食药监局</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_600" placeholder="请输入整数"></td>
								<td class="text-center">卫生保健</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_611" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_612" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center">卫计委 </td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_700" placeholder="请输入整数"></td>
								<td class="text-center">医疗美容</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_711" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_712" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center">人社部</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_800" placeholder="请输入整数"></td>
								<td class="text-center">猎头招聘</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_811" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_812" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center">旅游局</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_900" placeholder="请输入整数"></td>
								<td class="text-center">旅游产品</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_911" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_912" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center">食药监局</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_1000" placeholder="请输入整数"></td>
								<td class="text-center">餐饮活动</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_1011" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_1012" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center">工商局</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_1100" placeholder="请输入整数"></td>
								<td class="text-center">产品推销</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_1111" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_1112" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center">需文字描述</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_1200" placeholder="请输入整数"></td>
								<td class="text-center">其他</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_1211" placeholder="请输入整数"></td>
								<td class="text-center"><textarea class="form-control input-sm" name="field_1212" placeholder="案例描述"></textarea></td>
							</tr>
							<tr>
								<td class="text-center"  rowspan="2">本月总体举报数量</td>
								<td class="text-center"  rowspan="2"><input type="text" class="form-control input-sm" name="field_1300" placeholder="请输入整数"></td>
								<td class="text-center">上海号码举报数量</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_1301" placeholder="请输入整数"></td>
								<td class="text-center"></td>
							</tr>
							<tr>
								<td class="text-center">他省号码举报数量</td>
								<td class="text-center"><input type="text" class="form-control input-sm" name="field_1302" placeholder="请输入整数"></td>
								<td class="text-center"></td>
							</tr>
						</tbody></table>
							<table class="entry-table">
								<tr>
									<td width="25%">填表公司：<input type="text" class="form-control input-sm" /></td>
									<td width="25%">填表人：<input type="text" class="form-control input-sm" /></td>
									<td width="25%">联系方式：<input type="text" class="form-control input-sm" /></td>
									<td width="25%">电子邮箱： <input type="email" class="form-control input-sm" /></td>
								</tr>
							</table>
							本人承诺以上申报数据真实有效，有据可查！<input type="checkbox" name="accept" /><br />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>