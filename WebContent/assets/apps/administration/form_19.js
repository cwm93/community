/**
 * 固网码号资源
 */

$('#searchData').click(function() {
	var loadingYear = $('#selectYear').val();
	if (loadingYear == '') {
		layer.msg('请先选择年份');
		return;
	}
	if (loadingYear != '') {
		//formGWHMZY(loadingYear);
		queryJsonData(loadingYear);
	}
})

var queryJsonData = function (loadingYear){
	layer.msg('数据查询中', {
		time : 0, // 不自动关闭
		icon : 16,
		shade : 0.01
	});
	var dataContent = "";
	$.ajax({
		type : "get",
		url : "/gj/checkjob/list",
		data : {year : loadingYear},
		dataType : "json",
		success : function(data) {
			layer.closeAll();
			if (data.checkJobList!=null&&data.checkJobList.length>0) {
				layer.msg('数据加载成功');
				$.each(data.checkJobList,function(index,entity){
					dataContent = dataContent + "<tr><td  rowspan='3'><a href='javascript:void(0);' onclick='javascript:editData("+entity.id+");'>"+entity.year+"-"+entity.month+"</a></td><td>电信</td><td>"+converter(entity.field_11)+"</td><td>"+converter(entity.field_12)+"%</td><td>"+converter(entity.field_13)+"</td><td>"+converter(entity.field_14)+"%</td></tr>"+
					                            "<tr><td>移动（铁通）</td><td>"+converter(entity.field_21)+"</td><td>"+converter(entity.field_22)+"%</td><td>"+converter(entity.field_23)+"</td><td>"+converter(entity.field_24)+"%</td></tr>"+
					                            "<tr><td>联通</td><td>"+converter(entity.field_31)+"</td><td>"+converter(entity.field_32)+"%</td><td>"+converter(entity.field_33)+"</td><td>"+converter(entity.field_34)+"%</td></tr>";
				})
				$('#dataContent').html(dataContent);
			} else {
				layer.msg('没有查询到符合条件的记录', {icon : 0});
				dataContent="<tr><td colspan='6' style='height:150px;text-align:center;font-size:14px;'><span>没有查询到符合条件的记录</span></td></tr>";
				$('#dataContent').html(dataContent);
			}
		},
		error : function() {
			setTimeout(function() {
				layer.closeAll();
				layer.msg('获取数据操作异常，请稍后重试', {
					icon : 0
				});
			}, 2000);
		}
	})
}


var init = function(){ 
	var loadingYear = $("#selectYear").val();
	if(loadingYear==''){
		var date  = new Date();
		loadingYear = date.getFullYear();
		$("#selectYear option").each(function (){  
		    if($(this).val()==loadingYear){   
		    	$(this).attr("selected",'selected');  
		 }}); 
	}
	queryJsonData(loadingYear);
}();

$("#submitBtn").click(function(){
	var year = $("#year").val();
	var month = $("#month").val();
	if(year=='' || month==''){
		alert('请选择年份月份');
		return ;
	}
	//询问框
	layer.confirm('您确定要提交该表单数据吗？', {
		btn : [ '确定', '取消' ]
	//按钮
	}, function() {
		layer.msg('正在提交中...', {icon: 16,shade: 0.01});
		$.ajax({
			type : "post",
			url : "/gj/checkjob/save",
			data : $("#form1").serialize(),
			dataType : "json",
			success : function(data) {
				if(data.code==0){
					layer.msg(data.msg, {icon: 16,shade: 0.01});
					setTimeout(function(){
						window.location.reload();
					},2000);
				}else{
					layer.msg(data.msg, {icon : 0});
				}
			},
			error:function(){
				layer.alert('系统错误，稍后重试');
			}
		})
	}, function() {
		layer.msg('您已取消提交表单数据');
	});
})

function editData(id){
	$.get("/gj//checkjob/detail?id="+id,function(data,status){
		  $('#year').val(data.entity.year).attr("readOnly",true);
		  $('#month').val(data.entity.month).attr("readOnly",true);
		  $('#id').val(id);
		  $('#field_11').val(data.entity.field_11);
		  $('#field_12').val(data.entity.field_12);
		  $('#field_13').val(data.entity.field_13);
		  $('#field_14').val(data.entity.field_14);
		  $('#field_21').val(data.entity.field_21);
		  $('#field_22').val(data.entity.field_22);
		  $('#field_23').val(data.entity.field_23);
		  $('#field_24').val(data.entity.field_24);
		  $('#field_31').val(data.entity.field_31);
		  $('#field_32').val(data.entity.field_32);
		  $('#field_33').val(data.entity.field_33);
		  $('#field_34').val(data.entity.field_34);
		  $("#deleteBtn").show();
		  $('#add-form').modal('show');
	     // alert("数据：" + data.realNameRegistrationChannel.id);
	});
}

$('#add-form').on('hidden.bs.modal',function(){
	  $('#year').val('').attr("readOnly",false);
	  $('#month').val('').attr("readOnly",false);
	  $('#id').val(0);
	  $('#field_11').val('');
	  $('#field_12').val('');
	  $('#field_13').val('');
	  $('#field_14').val('');
	  $('#field_21').val('');
	  $('#field_22').val('');
	  $('#field_23').val('');
	  $('#field_24').val('');
	  $('#field_31').val('');
	  $('#field_32').val('');
	  $('#field_33').val('');
	  $('#field_34').val('');
	  $("#deleteBtn").hide();
});

$("#deleteBtn").click(function(){
	var id= $("#id").val();
	if(id<1){
		alert('参数错误，无法删除');
		return ;
	}
	layer.confirm('您确定要删除该条记录吗？', {
		btn : [ '确定', '取消' ]
	//按钮
	}, function() {
		layer.msg('正在删除中...', {icon: 16,shade: 0.01});
		$.ajax({
			type : "post",
			url : "/gj/checkjob/delete",
			data : {id:id},
			dataType : "json",
			success : function(data) {
				if(data.code==0){
					layer.msg(date.msg, {icon: 16,shade: 0.01});
					setTimeout(function(){
						window.location.reload();
					},2000);
				}else{
					layer.msg('数据删除失败', {icon : 0});
				}
			},
			error:function(){
				layer.alert('系统错误，稍后重试');
			}
		})
	}, function() {
		layer.msg('您已取消删除数据');
	});
})
var converter = function(param){
	if(param==null){
		return '--';
	}
	return param;
}
