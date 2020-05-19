<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh-CN" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="zh-CN" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/pages/css/front.css" rel="stylesheet" type="text/css" />
<title>管局表格样式</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
			   <h3 class="title">
					上海市通信管理局<span>市场业务报表综合分析管理</span><a
						href="javascript:window.history.go(-1);"
						class="pull-right btn btn-sm btn-warning"> 返回 <i class="fa fa-undo"></i>
					</a>
				</h3>
				<h5 class="form-title">实名制渠道-数据录入</h5>
				<form class="form-horizontal" name="form1" id="form1" role="form" action="/gj/smz/save" onsubmit="return checkForm();" enctype="multipart/form-data" method="post">
                       <div class="form-group">
						<label for="firstname" class="col-sm-4 control-label">月份</label>
						<div class="col-sm-8 form-inline">
							<select class="form-control input-xsmall" id="selectYear">
								<option value="">请选择</option>
								<option value="2016">2016</option>
								<option value="2017">2017</option>
								<option value="2018">2018</option>
								<option value="2019">2019</option>
								<option value="2020">2020</option>
								<option value="2021">2021</option>
								<option value="2022">2022</option>
								<option value="2023">2023</option>
								<option value="2024">2024</option>
								<option value="2025">2025</option>
								<option value="2026">2026</option>
								<option value="2027">2027</option>
							</select><span style="padding: 0 15px;">年</span><select
								class="form-control input-xsmall" id="selectMonth">
								<option value="">请选择</option>
								<option value="1">01</option>
								<option value="2">02</option>
								<option value="3">03</option>
								<option value="4">04</option>
								<option value="5">05</option>
								<option value="6">06</option>
								<option value="7">07</option>
								<option value="8">08</option>
								<option value="9">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select> <span style="padding: 0 15px;">月</span>
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-4 control-label">自营厅总数</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="firstname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">代理点总数</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">电商平台授权数</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">二代身份证识别设备网点数</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">社会渠道授权牌数</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">本月终止违规代理商数</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">移动电话实名率</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">固定电话实名率</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-4 control-label">合规率</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<button type="submit" class="btn btn-primary">提交</button>
						</div>
					</div>
					<div class="tabbable-custom">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#tab_2016" data-toggle="tab">2016年</a></li>
									<li><a href="#tab_2017" data-toggle="tab">2017年</a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="tab_2016">
										<table class="table table-striped table-bordered table-advance table-hover">
											<thead>
												<tr>
													<td rowspan="2" class="text-center">月份</td>
													<td rowspan="2" class="text-center">单位</td>
													<td colspan="6" class="text-center">项目</td>
												</tr>
												<tr>
													<td>自营厅总数</td>
													<td>代理点总数</td>
													<td>电商平台授权数</td>
													<td>二代身份证识别设备网点数</td>
													<td>社会渠道授权牌数</td>
													<td>本月终止违规代理商数</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td class="text-center"><a href="javascript:void(0);" data-target="#ajax" data-toggle="modal"> 2016-4 </a></td>
													<td class="text-center">行业</td>
													<td>446</td>
													<td>13780</td>
													<td>48</td>
													<td>15153</td>
													<td>14794</td>
													<td>40</td>

												</tr>
												<tr>
													<td class="text-center">2016-5</td>
													<td class="text-center">行业</td>
													<td>448</td>
													<td>13832</td>
													<td>49</td>
													<td>15226</td>
													<td>14867</td>
													<td>65</td>

												</tr>
												<tr>
													<td class="text-center">2016-6</td>
													<td class="text-center">行业</td>
													<td>444</td>
													<td>13676</td>
													<td>52</td>
													<td>15080</td>
													<td>14727</td>
													<td>133</td>

												</tr>
												<tr>
													<td class="text-center">2016-7</td>
													<td class="text-center">行业</td>
													<td>440</td>
													<td>13705</td>
													<td>54</td>
													<td>15099</td>
													<td>14751</td>
													<td>58</td>

												</tr>
												<tr>
													<td class="text-center">2016-8</td>
													<td class="text-center">行业</td>
													<td>443</td>
													<td>14280</td>
													<td>50</td>
													<td>15697</td>
													<td>15344</td>
													<td>10</td>

												</tr>
												<tr>
													<td class="text-center">2016-9</td>
													<td class="text-center">行业</td>
													<td>444</td>
													<td>14255</td>
													<td>51</td>
													<td>15685</td>
													<td>15331</td>
													<td>114</td>

												</tr>
												<tr>
													<td class="text-center">2016-10</td>
													<td class="text-center">行业</td>
													<td>445</td>
													<td>14243</td>
													<td>52</td>
													<td>15687</td>
													<td>15333</td>
													<td>46</td>

												</tr>
												<tr>
													<td class="text-center">2016-11</td>
													<td class="text-center">行业</td>
													<td>445</td>
													<td>14256</td>
													<td>60</td>
													<td>15685</td>
													<td>14875</td>
													<td>57</td>
												</tr>
												<tr>
													<td class="text-center">2016-12</td>
													<td class="text-center">行业</td>
													<td>443</td>
													<td>13900</td>
													<td>26</td>
													<td>15261</td>
													<td>14883</td>
													<td>76</td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="tab-pane" id="tab_2017">
										<table
											class="table table-striped table-bordered table-advance table-hover">
											<thead>
												<tr>
													<td rowspan="2" class="text-center">月份</td>
													<td rowspan="2" class="text-center">单位</td>
													<td colspan="6" class="text-center">项目</td>
												</tr>
												<tr>
													<td>自营厅总数</td>
													<td>代理点总数</td>
													<td>电商平台授权数</td>
													<td>二代身份证识别设备网点数</td>
													<td>社会渠道授权牌数</td>
													<td>本月终止违规代理商数</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td class="text-center"><a href="javascript:void(0);" data-target="#ajax" data-toggle="modal"> 2017-1 </a></td>
													<td class="text-center">行业</td>
													<td>444</td>
													<td>13835</td>
													<td>26</td>
													<td>15211</td>
													<td>14832</td>
													<td>223</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
					
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function checkForm() {
			return false;
		}
	</script>
</body>
</html>