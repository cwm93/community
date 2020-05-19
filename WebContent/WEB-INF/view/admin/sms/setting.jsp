<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh-CN" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="zh-CN" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh-CN">
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<jsp:include page="../../common/head.jsp"></jsp:include>
<link href="/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
<style>
body {font-size: 14px;}
</style>
</head>
<body
	class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
	<div class="page-wrapper">
		<jsp:include page="../../common/top.jsp"></jsp:include>
		<!-- BEGIN HEADER & CONTENT DIVIDER -->
		<div class="clearfix"></div>
		<!-- END HEADER & CONTENT DIVIDER -->
		<!-- BEGIN CONTAINER -->
		<div class="page-container">
			<jsp:include page="../../common/left.jsp"></jsp:include>
			<!-- BEGIN CONTENT -->
			<div class="page-content-wrapper">
				<!-- BEGIN CONTENT BODY -->
				<div class="page-content">
					<div class="row">
						<div class="col-md-12">
							<!-- BEGIN PORTLET-->
                                <div class="portlet light form-fit bordered">
                                    <div class="portlet-title">
                                        <div class="caption">
                                            <i class="icon-settings font-red"></i>
                                            <span class="caption-subject font-red sbold uppercase">短消息开启／关闭设置<span style="color:#777;font-size:12px;padding-left:15px;font-weight:normal;">剩余可发送短信数量：<span id="pieces">--</span>条（本数据来源于第三方有一定的网络延迟）</span></span>
                                        </div>
                                    </div>
                                    <div class="portlet-body form">
                                        <!-- BEGIN FORM-->
                                        <form class="form-horizontal form-bordered" id="smsForm">
                                            <div class="form-body">
                                                <c:forEach items="${smsList}" var="sms">
                                                 <div class="form-group">
                                                    <label class="control-label col-md-3">${sms.comment}</label>
                                                    <div class="col-md-9">
                                                        <input type="checkbox" id="sms_${sms.type}" <c:if test="${sms.closed==0}">checked</c:if> class="make-switch" data-size="small"> </div>
                                                </div>
                                                </c:forEach>
                                            </div>
                                            <div class="form-actions">
                                                <div class="row">
                                                    <div class="col-md-offset-3 col-md-9">
                                                        <button  type="submit" class="btn green setting-submit"><i class="fa fa-check"></i> 提交</button>
                                                        <button type="reset" class="btn btn-warning"><i class="fa fa-times"></i> 取消</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                        <!-- END FORM-->
                                    </div>
                                </div>
                                <!-- END PORTLET-->
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../../common/footer.jsp"></jsp:include>
	</div>
	<jsp:include page="../../common/footerJs.jsp"></jsp:include>
	<script type="text/javascript" src="/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="/assets/pages/scripts/bootstrap-switch.js"></script>
	<script src="/assets/layer/layer.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {
			$('.setting-submit').click(function(event) {
				event.preventDefault();
				var sms_1 = $('#sms_1').is(':checked') ? 0 : 1;
				var sms_2 = $('#sms_2').is(':checked') ? 0 : 1;
				var sms_3 = $('#sms_3').is(':checked') ? 0 : 1;
				$.ajax({
					type : "POST",
					url : "/sys/sms/update",
					data : {
						sms_1 : sms_1,
						sms_2 : sms_2,
						sms_3 : sms_3
					},
					dataType : "json",
					success : function(data) {
						if (data.code == 0) {
							layer.msg('短消息设置成功', {
								icon : 1
							});
							setTimeout(function() {
								window.location.reload();
							}, 3000);
						} else {
							layer.msg('短消息设置失败', {
								icon : 0
							});
						}
					},
					error : function() {
						layer.msg('操作异常，请稍后刷新重试', {
							icon : 0
						});
					}
				})
			})
		})
		var inti = function() {
			$.ajax({
				type : "get",
				url : "/sys/sms/pieces",
				dataType : "json",
				success : function(data) {
					if (data.code == 0) {
						$('#pieces').html(data.pieces);
					}else{
						$('#pieces').html("(获取失败)");
					}
				}
			})
		}();
	</script>
</body>
</html>