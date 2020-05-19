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
        <link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="/assets/layouts/layout/css/custom.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="/favicon.ico" />
    </head>
    <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
        <div class="page-wrapper">
           <jsp:include page="../common/top.jsp"></jsp:include>
            <div class="clearfix"> </div>
            <div class="page-container">
                 <jsp:include page="../common/left.jsp"></jsp:include>
                <div class="page-content-wrapper">
                    <div class="page-content">
                        <div class="page-bar">
                            <ul class="page-breadcrumb">
                                <li>
                                    <a href="/index">主页</a>
                                    <i class="fa fa-circle"></i>
                                </li>
                                <li>
                                    <span>系统设置</span>
                                    <i class="fa fa-circle"></i>
                                </li>
                                 <li>
                                    <span>报表模板管理</span>
                                </li>
                            </ul>
                        </div>
                        <div class="row">
                            <div class="col-md-12 margin-top-15">
                            <h3 class="text-center">${report.title}</h3>
                            <div class="actions" style="margin-bottom:8px;">
								<a class="btn btn-primary" data-toggle="modal" data-target="#remarkModal" data-whatever="新增备注"> <i class="fa fa-plus"></i> 新增备注</a> 
							</div>
							<table
								class="table table-striped table-bordered table-advance table-hover">
								<thead>
									<tr>
									    <th style="width:5%;">序号</th>
									    <th style="width:5%;">年份</th>
										<th style="width:45%;">备注内容</th>
										<th style="width:10%;">最后更新日期</th>
										<th style="width:10%;">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty reportFormRemarkList}">
											<tr>
												<td colspan="5" class="text-center">暂无内容</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${reportFormRemarkList}" var="reportFormRemark" varStatus="status">
												<tr><td>${status.index+1}</td><td>${reportFormRemark.year}</td><td>${reportFormRemark.remarkContent}</td><td> <fmt:formatDate value="${reportFormRemark.updateTime}"  pattern="yyyy-MM-dd hh:mm:ss"/></td>
												<td><a class="btn btn-primary" data-toggle="modal" data-target="#remarkModal" data-whatever="编辑备注" data-id="${reportFormRemark.id}"> <i class="fa fa-edit"></i> 编辑</a> </td></tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
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
	<div class="modal fade" id="remarkModal" tabindex="-1" role="dialog" aria-labelledby="remarkModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">添加备注</h4>
				</div>
				<div class="modal-body">
					<form id="form1">
						<div class="form-group">
							<label for="recipient-name" class="control-label">年份:</label>
							<select class="form-control" id="year">
											<option value="">请选择</option>
											<option value="2016">2016</option>
											<option value="2017">2017</option>
											<option value="2018">2018</option>
											<option value="2019">2019</option>
											<option value="2020">2020</option>
											<option value="2021">2021</option>
											<option value="2022">2022</option>
							</select>
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">备注内容:</label>
							<textarea class="form-control" id="remarkContent"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary remark-submit">提交</button>
					<input type="hidden" id="reportId" value="${report.id}">
					<input type="hidden" id="id" value="">
				</div>
			</div>
		</div>
	</div>
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/assets/global/scripts/app.min.js" type="text/javascript"></script>
    <script src="/assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
    <script src="/assets/layer/layer.js" type="text/javascript"></script>
    <script type="text/javascript">
    $(function(){
    	$('#remarkModal').on('show.bs.modal', function (event) {
      	   var button = $(event.relatedTarget);
      	   var recipient = button.data('whatever');
      	   var reportFormRemarkId = button.data('id');
      	   if(reportFormRemarkId!=null && reportFormRemarkId>0){
      		 getReportFormRemarkById(reportFormRemarkId);  
      	   }
      	   var modal = $(this)
      	   modal.find('.modal-title').text(recipient)
      	   modal.find('.modal-body input').val(recipient)
      	})
      	$('#remarkModal').on('hidden.bs.modal', function (event) {
      		$("#year").find("option:selected").prop("selected",false);
			$('#remarkContent').val('');
			$('#id').val('');
      	})
      	
      	$('.remark-submit').on('click',function(){
      		var year = $('#year').val();
      		var remarkContent = $('#remarkContent').val();
      		var reportId = $('#reportId').val();
      		var id = $('#id').val();
      		if(year==''){
      			layer.msg('年份不能为空', {icon : 0});
      			return ;
      		}
            if(remarkContent==''){
            	layer.msg('备注内容不能为空', {icon : 0});
            	return ;
      		}
            $.ajax({
				type : "POST",
				url : "/system/reportFormRemark/save",
				data : {id:id,reportId:reportId,year:year,remarkContent:remarkContent},
				dataType : "json",
				success : function(data) {
					if(data.code!=0){
						layer.msg(data.msg, {icon : 0});
					}else{
						layer.msg(data.msg, {icon : 1});
						setTimeout(function(){
							window.location.reload();	
						},2000) 
					}
				},
				error:function(){
					layer.msg('系统异常，请稍后重试', {icon : 0});
				}
			});
      	})
      	
      	function getReportFormRemarkById(id){
    		 $.ajax({
 				type : "get",
 				url : "/system/reportFormRemark/detail",
 				data : {id:id},
 				dataType : "json",
 				success : function(data) {
 					if(data.code!=0){
 						layer.msg(data.msg, {icon : 0});
 					}else{
 						layer.msg(data.msg, {icon : 1});
 						$("#year").find("option[value = '"+data.reportFormRemark.year+"']").prop("selected",true);
 						$('#remarkContent').val(data.reportFormRemark.remarkContent);
 						$('#id').val(data.reportFormRemark.id);
 					}
 				},
 				error:function(){
 					layer.msg('系统异常，请稍后重试', {icon : 0});
 				}
 			});
    	}
    })
    </script>    
    </body>
</html>