/**
 * 实名制渠道
 */
$('#searchData').click(function() {
	var loadingYear = $('#selectYear').val();
	if (loadingYear == '') {
		layer.msg('请先选择年份');
		return;
	}
	if (loadingYear != '') {
		formSMZQD(loadingYear);
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
		url : "/gj/smzqd/list",
		data : {year : loadingYear},
		dataType : "json",
		success : function(data) {
			var statusData = data.data;
			if (statusData.code == 0) {
				layer.closeAll();
				if (data.realNameRegistrationChannelList!=null&&data.realNameRegistrationChannelList.length>0) {
					layer.msg('数据加载成功');
					$.each(data.realNameRegistrationChannelList,function(index,realNameRegistrationChannel){
						dataContent = dataContent + "<tr onclick='javascript:editData("+realNameRegistrationChannel.id+");' style='cursor:pointer;'><td>"+realNameRegistrationChannel.year+"-"+realNameRegistrationChannel.month+"</td><td>行业</td><td>"+converter(realNameRegistrationChannel.filed_01)+"</td><td>"+converter(realNameRegistrationChannel.filed_02)+"</td><td>"+converter(realNameRegistrationChannel.filed_03)+"</td><td>"+converter(realNameRegistrationChannel.filed_04)+"</td><td>"+converter(realNameRegistrationChannel.filed_05)+"</td><td>"+converter(realNameRegistrationChannel.filed_07)+"</td><td>"+converter(realNameRegistrationChannel.filed_08)+"</td><td>"+converter(realNameRegistrationChannel.filed_06)+"</td></tr>";
					})
					$('#dataContent').html(dataContent);
				} else {
					layer.msg('没有查询到符合条件的记录', {icon : 0});
					dataContent="<tr><td colspan='10' style='height:150px;text-align:center;font-size:14px;'><span>没有查询到符合条件的记录</span></td></tr>";
					$('#dataContent').html(dataContent);
				}
			} else {
				setTimeout(function() {
					layer.closeAll();
					layer.msg('数据拉取失败', {icon : 0});
				}, 2000);
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
			url : "/gj/smzqd/save",
			data : $("#form1").serialize(),
			dataType : "json",
			success : function(data) {
				if(data.data.code==0){
					layer.msg('操作成功,正在刷新，请稍后...', {icon: 16,shade: 0.01});
					setTimeout(function(){
						window.location.reload();
					},2000);
				}else{
					layer.msg(data.data.message, {icon : 0});
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
	$.get("/gj/smzqd/edit?id="+id,function(data,status){
		  $('#year').val(data.realNameRegistrationChannel.year).attr("disabled",true);
		  $('#month').val(data.realNameRegistrationChannel.month).attr("disabled",true);
		  $('#id').val(id);
		  $('#filed_01').val(data.realNameRegistrationChannel.filed_01);
		  $('#filed_02').val(data.realNameRegistrationChannel.filed_02);
		  $('#filed_03').val(data.realNameRegistrationChannel.filed_03);
		  $('#filed_04').val(data.realNameRegistrationChannel.filed_04);
		  $('#filed_05').val(data.realNameRegistrationChannel.filed_05);
		  $('#filed_06').val(data.realNameRegistrationChannel.filed_06);
		  $("#deleteBtn").show();
		  $('#add-form').modal('show');
	     // alert("数据：" + data.realNameRegistrationChannel.id);
	});
}

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
			url : "/gj/smzqd/delete",
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

$('#add-form').on('hidden.bs.modal',function(){
	  $('#year').val('').attr("disabled",false);
	  $('#month').val('').attr("disabled",false);
	  $('#id').val(0);
	  $('#filed_01').val('');
	  $('#filed_02').val('');
	  $('#filed_03').val('');
	  $('#filed_04').val('');
	  $('#filed_05').val('');
	  $('#filed_06').val('');
	  $("#deleteBtn").hide();
});

var converter = function(param){
	if(param==null){
		return '--';
	}
	return param;
}
