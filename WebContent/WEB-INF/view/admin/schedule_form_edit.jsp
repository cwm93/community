<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh-CN" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="zh-CN" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh-CN">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->
    <head>
        <meta charset="utf-8" />
        <title>上海市通信管理局-市场业务报表综合分析管理</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="上海市通信管理局-市场业务报表综合分析管理" name="description" />
        <meta content="上海市通信管理局-市场业务报表综合分析管理" name="author" />
        <link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap-daterangepicker/daterangepicker.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/jquery-multi-select/css/multi-select.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="/assets/layouts/layout/css/custom.css" rel="stylesheet" type="text/css" />
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="/favicon.ico" /> </head>
    <!-- END HEAD -->

    <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
	<div class="page-wrapper">
		<jsp:include page="../common/top.jsp"></jsp:include>
		<div class="clearfix"></div>
		<div class="page-container">
			<jsp:include page="../common/left.jsp"></jsp:include>
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<ul class="page-breadcrumb">
							<li><a href="/index">主页</a> <i class="fa fa-circle"></i></li>
							<li><span>编辑计划</span></li>
						</ul>
					</div>
					<div class="row">
						<div class="col-md-12 margin-top-15">
							<form class="form-horizontal schedule-form" modelAttribute="scheduleReport" action="/schedule/save" role="form" id="scheduleForm" method="post">
								<div class="form-body">
									<div class="form-group">
										<label class="col-md-3 control-label">计划名称</label>
										<div class="col-md-3">
											<input type="text" class="form-control" name="name" value="${scheduleReport.name}">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">选择报表模板</label>
										<div class="col-md-3">
											<select class="form-control" name="reportId"><option
													value="0">...选择一个报表模版...</option>
												<c:forEach items="${reports}" var="report">
												    <c:choose><c:when test="${scheduleReport.report.id==report.id}"><option value="${report.id}" selected>${report.title}--（${report.reportType.name}）</option></c:when><c:otherwise><option value="${report.id}">${report.title}--（${report.reportType.name}）</option></c:otherwise></c:choose>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">选择用户</label>
										<div class="col-md-9">
											<select multiple="multiple" class="multi-select" id="user_multi_select" name="sendedUsers">
												<c:forEach items="${users}" var="user">
												  <option value="${user.id}" <c:forEach items="${scheduleReport.sendedUsers }" var ="sendUser"><c:if test="${sendUser.id==user.id}">selected</c:if></c:forEach>>${user.realname}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">发送方式</label>
										<div class="col-md-6">
											<div class="mt-radio-inline">
												<label class="mt-radio"> <input type="radio"
													name="type" value="1"  <c:if test="${scheduleReport.type==1}">checked</c:if>/>按日发<span></span>
												</label><label class="mt-radio"><input type="radio"
													name="type" value="2"  <c:if test="${scheduleReport.type==2}">checked</c:if>/>按周发<span></span></label> <label
													class="mt-radio"><input type="radio" name="type"
													value="3"  <c:if test="${scheduleReport.type==3}">checked</c:if>/>按月发<span></span></label>
											</div>
										</div>
									</div>
									<div class="tab-content">
										<div class="tab-pane active" id="tab_1">
											<div class="form-group">
												<label class="col-md-3 control-label">发送日期</label>
												<div class="col-md-3">
													<input class="form-control date date-picker"
														data-date-format="yyyy-mm-dd" name="sendDate" value="<fmt:formatDate value="${scheduleReport.sendDate}" pattern="yyyy-MM-dd"/>"/>
												</div>
											</div>
										</div>
										<div class="tab-pane" id="tab_2">
											<div class="form-group">
												<div class="col-md-offset-3 col-md-3">
													<select class="form-control" name="sendWeek">
														<option value="1" <c:if test="${scheduleReport.sendWeek==1}">selected</c:if>>周一</option>
														<option value="2" <c:if test="${scheduleReport.sendWeek==2}">selected</c:if>>周二</option>
														<option value="3" <c:if test="${scheduleReport.sendWeek==3}">selected</c:if>>周三</option>
														<option value="4" <c:if test="${scheduleReport.sendWeek==4}">selected</c:if>>周四</option>
														<option value="5" <c:if test="${scheduleReport.sendWeek==5}">selected</c:if>>周五</option>
														<option value="6" <c:if test="${scheduleReport.sendWeek==6}">selected</c:if>>周六</option>
														<option value="7" <c:if test="${scheduleReport.sendWeek==7}">selected</c:if>>周日</option>
													</select><span class="help-inline">选择在每周固定日期发表计划</span>
												</div>
											</div>
											<div class="form-group">
												<div class="col-md-offset-3 col-md-3">
													<div
														class="input-group input-large date-picker input-daterange"
														data-date-format="yyyy-mm-dd">
														<input type="text" class="form-control" name="startDate2" value="<fmt:formatDate value="${scheduleReport.startTime}" pattern="yyyy-MM-dd"/>">
														<span class="input-group-addon"> 至 </span> <input
															type="text" class="form-control" name="endDate2" value="<fmt:formatDate value="${scheduleReport.endTime}" pattern="yyyy-MM-dd"/>">
													</div>
													<span class="help-inline">选择计划执行日期范围</span>
												</div>
											</div>
										</div>
										<div class="tab-pane" id="tab_3">
											<div class="form-group">
												<div class="col-md-offset-3 col-md-3">
													<select class="form-control" name="sendDay">
														<c:forEach var="s" begin="01" end="31">
															<option value="${s}" <c:if test="${scheduleReport.sendDay==s}">selected</c:if>>${s}</option>
														</c:forEach>
													</select><span class="help-inline">选择在每月固定日期发表计划</span>
												</div>
											</div>
											<div class="form-group">
												<div class="col-md-offset-3 col-md-3">
													<div
														class="input-group input-large date-picker input-daterange"
														data-date-format="yyyy-mm-dd">
														<input type="text" class="form-control" name="startDate3" value="<fmt:formatDate value="${scheduleReport.startTime}" pattern="yyyy-MM-dd"/>">
														<span class="input-group-addon"> 至 </span> <input
															type="text" class="form-control" name="endDate3" value="<fmt:formatDate value="${scheduleReport.endTime}" pattern="yyyy-MM-dd"/>">
													</div>
													<span class="help-inline">选择计划执行日期范围</span>
												</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-offset-3 col-md-3">
											<div class="input-group">
												<input type="text"
													class="form-control timepicker timepicker-24"
													name="sendTime" value="${scheduleReport.sendTime}"> <span class="input-group-btn">
													<button class="btn default" type="button">
														<i class="fa fa-clock-o"></i>
													</button>
												</span>
											</div>
											<span class="help-inline">选择在固定时间发表计划</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">备注</label>
										<div class="col-md-3">
											<textarea class="form-control input-inline input-large"
												rows="3" name="description">${scheduleReport.description}</textarea>
											<span class="help-inline"></span>
										</div>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-offset-3 col-md-3">
											<button type="submit" id="profileSubmit"
												class="btn green button-submit">
												发布计划 <i class="fa fa-check"></i>
											</button><input type="hidden" name="scheduleReportId" value="${scheduleReport.id}"/>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	<!--[if lt IE 9]>
<script src="/assets/global/plugins/respond.min.js"></script>
<script src="/assets/global/plugins/excanvas.min.js"></script> 
<script src="/assets/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->
        <script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/moment.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/bootstrap-daterangepicker/daterangepicker.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/bootstrap-timepicker/js/bootstrap-timepicker.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
        <script src="/assets/global/plugins/jquery-multi-select/js/jquery.multi-select.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/jquery-multi-select/js/jquery.multi-select.js" type="text/javascript"></script>
        <script src="/assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
        <script src="/assets/global/scripts/app.min.js" type="text/javascript"></script>
        <script src="/assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
        <script src="/assets/layer/layer.js" type="text/javascript"></script>
        <script type="text/javascript"> 
        jQuery(document).ready(function() {
            var init =  function(){
            	$(':radio').each(function(index,domEle){	
           		   if($(this).is(":checked")){
           			 $("#tab_"+$(this).val()).addClass("active");
               	   }else{
               		  $("#tab_"+$(this).val()).removeClass("active");
               	   }
                })
                	
                $('#user_multi_select').multiSelect();
            }
        	$('.date-picker').datepicker({
                language: 'zh-CN',
                autoclose: true,
                todayHighlight: true
            })
            $('.timepicker-24').timepicker({
                autoclose: true,
                minuteStep: 5,
                showSeconds: false,
                showMeridian: false
            });
        	$('.timepicker').parent('.input-group').on('click', '.input-group-btn', function(e){
                e.preventDefault();
                $(this).parent('.input-group').find('.timepicker').timepicker('showWidget');
            });
        	
        	init();
        	
        	$(':radio').click(function(){
        		$(':radio').each(function(index,domEle){	
          		   if($(this).is(":checked")){
          			 $("#tab_"+$(this).val()).addClass("active");
              	   }else{
              		  $("#tab_"+$(this).val()).removeClass("active");
              	   }
               	})
        	})
        	
        })
        </script>
    </body>
</html>