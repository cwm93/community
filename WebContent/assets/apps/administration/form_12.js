/**
 * 自贸区增值电信业务收入
 */

$('#searchData').click(function() {
	var loadingYear = $('#selectYear').val();
	if (loadingYear == '') {
		layer.msg('请先选择年份');
		return;
	}
	if (loadingYear != '') {
		formZMQDXYW(loadingYear);
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
		url : "/gj/zmqdxywsr/list",
		data : {year : loadingYear},
		dataType : "json",
		success : function(data) {
			layer.closeAll();
			if (data.zoonValueAddedTelecomBussinessList!=null&&data.zoonValueAddedTelecomBussinessList.length>0) {
				layer.msg('数据加载成功');
				$.each(data.zoonValueAddedTelecomBussinessList,function(index,entity){
					dataContent = dataContent + "<tr><td><a href='javascript:void(0);' onclick='javascript:editData("+entity.id+");'>"+entity.year+"-"+entity.month+"</a></td><td>总计</td><td>"+converter(entity.field_11)+"</td><td>"+converter(entity.field_12)+"</td><td>"+converter(entity.field_13)+"</td><td>"+converter(entity.field_14)+"</td></tr>";
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
			url : "/gj/zmqdxywsr/save",
			data : $("#form1").serialize(),
			dataType : "json",
			success : function(data) {
				if(data.status=='success'){
					layer.msg('操作成功,正在刷新，请稍后...', {icon: 16,shade: 0.01});
					setTimeout(function(){
						window.location.reload();
					},2000);
				}else if(data.status=='fail'){
					layer.msg('该月数据已经存在，请重新选择年份月份', {icon : 0});
				}else{
					layer.msg('数据添加失败', {icon : 0});
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
	$.get("/gj//zmqdxywsr/detail?id="+id,function(data,status){
		  $('#year').val(data.entity.year).attr("disabled",true);
		  $('#month').val(data.entity.month).attr("disabled",true);
		  $('#id').val(id);
		  $('#field_11').val(data.entity.field_11);
		  $('#field_12').val(data.entity.field_12);
		  $('#field_13').val(data.entity.field_13);
		  $('#field_14').val(data.entity.field_14);
		  $("#deleteBtn").show();
		  $('#add-form').modal('show');
	     // alert("数据：" + data.realNameRegistrationChannel.id);
	});
}

$('#add-form').on('hidden.bs.modal',function(){
	  $('#year').val('').attr("disabled",false);
	  $('#month').val('').attr("disabled",false);
	  $('#id').val(0);
	  $('#field_11').val('');
	  $('#field_12').val('');
	  $('#field_13').val('');
	  $('#field_14').val('');
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
			url : "/gj/zmqdxywsr/delete",
			data : {id:id},
			dataType : "json",
			success : function(data) {
				if(data.status=="success"){
					layer.msg('删除成功,正在刷新，请稍后...', {icon: 16,shade: 0.01});
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