<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<meta content="上海明兹信息科技有限公司" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN THEME GLOBAL STYLES -->
<link href="/assets/global/css/components.min.css" rel="stylesheet"
	id="style_components" type="text/css" />
<link href="/assets/global/css/plugins.min.css" rel="stylesheet"
	type="text/css" />
<!-- END THEME GLOBAL STYLES -->
<head>
<meta charset="UTF-8">
<title>消息提示页面</title>
<style type="text/css">
.margin-top-30 {
	margin-top: 30px;
}
</style>
</head>
<body>
	<div class="container margin-top-30">
		<div class="row">
			<div class="col-md-12">
				<div class="portlet light bordered"
					id="blockui_sample_1_portlet_body">
					<div class="portlet-title">
						<div class="caption">
							<i class="icon-bubble font-green-sharp"></i> <span
								class="caption-subject font-green-sharp sbold">消息提示</span>
						</div>
					</div>
					<div class="portlet-body">
						<c:choose>
							<c:when test="${data!=null}">
								<p>${data.message}</p>
							</c:when>
							<c:otherwise>
								<p>这是一个提示页面</p>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${data.url!=null}">
								<p>
									<a href="${data.url}" class="btn btn-outline sbold green-haze"
										id="blockui_sample_1_3"> ${data.urlTitle}</a>
								</p>
							</c:when>
							<c:otherwise>
								<p>
									<a href="javascript:window.history.go(-1);" class="btn btn-outline sbold green-haze"
										id="blockui_sample_1_3"> 返回上一页</a>
								</p>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>