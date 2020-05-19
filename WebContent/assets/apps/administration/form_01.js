/**
 * 实名制
 */

$('#searchData').click(function() {
	var loadingYear = $('#selectYear').val();
	if (loadingYear == '') {
		layer.msg('请先选择年份');
		return;
	}
	if (loadingYear != '') {
		queryJsonData(loadingYear);
		formSMZ(loadingYear);
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
		url : "/gj/smz/list",
		data : {year : loadingYear},
		dataType : "json",
		success : function(data) {
			layer.closeAll();
			if (data.realNameRegistrationList!=null&&data.realNameRegistrationList.length>0) {
				layer.msg('数据加载成功');
				$.each(data.realNameRegistrationList,function(index,entity){
					sum11 = entity.field_11+entity.field_12;
					sum21 = entity.field_21+entity.field_22;
					sum31 = entity.field_31+entity.field_32;
					
					sumy1 = entity.field_11+entity.field_21+entity.field_31;
					sumy2 = entity.field_12+entity.field_22+entity.field_32;
					
					sum12 = entity.field_13+entity.field_14;
					sum22 = entity.field_23+entity.field_24;
					sum32 = entity.field_33+entity.field_34;
					
					sumy3 = entity.field_13+entity.field_23+entity.field_33;
					sumy4 = entity.field_14+entity.field_24+entity.field_34;
					
					sum13 = entity.field_15+entity.field_16;
					sum23 = entity.field_25+entity.field_26;
					sum33 = entity.field_35+entity.field_36;
					
					sumy5 = entity.field_15+entity.field_25+entity.field_35;
					sumy6 = entity.field_16+entity.field_26+entity.field_36;
					
					per11 = (sum13/2).toFixed(2);
					per21 = (sum23/2).toFixed(2);
					per31 = (sum33/2).toFixed(2);
					
					pery1 = (sumy5/3).toFixed(2);
					pery2 = (sumy6/3).toFixed(2);
					pery3 = Number(pery1)+ Number(pery2);
					pery3 = (pery3/3).toFixed(2);
					
					dataContent = dataContent + "<tr><td rowspan='4'><a href='javascript:void(0);' onclick='javascript:editData("+entity.id+");'>"+entity.year+"/"+entity.month+"</a></td><td>行业</td><td>"+(sumy1+sumy2).toFixed(2)+"</td><td>"+sumy1.toFixed(2)+"</td><td>"+sumy2.toFixed(2)+"</td><td>"+(sumy3+sumy4).toFixed(2)+"</td><td>"+sumy3.toFixed(2)+"</td><td>"+sumy4.toFixed(2)+"</td><td>"+((sumy3+sumy4)/(sumy1+sumy2)*100).toFixed(2)+"%</td><td>"+(sumy3/sumy1*100).toFixed(2)+"%</td><td>"+(sumy4/sumy2*100).toFixed(2)+"%</td></tr>"+
					                            "<tr><td>电信</td><td>"+sum11.toFixed(2)+"</td><td>"+converter(entity.field_11)+"</td><td>"+converter(entity.field_12)+"</td><td>"+sum12.toFixed(2)+"</td><td>"+converter(entity.field_13)+"</td><td>"+converter(entity.field_14)+"</td><td>"+(sum12/sum11*100).toFixed(2)+"%</td><td>"+converter(entity.field_15)+"%</td><td>"+converter(entity.field_16)+"%</td></tr>"+
					                            "<tr><td>移动</td><td>"+sum21.toFixed(2)+"</td><td>"+converter(entity.field_21)+"</td><td>"+converter(entity.field_22)+"</td><td>"+sum22.toFixed(2)+"</td><td>"+converter(entity.field_23)+"</td><td>"+converter(entity.field_24)+"</td><td>"+(sum22/sum21*100).toFixed(2)+"%</td><td>"+converter(entity.field_25)+"%</td><td>"+converter(entity.field_26)+"%</td></tr>"+
					                            "<tr><td>联通</td><td>"+sum31.toFixed(2)+"</td><td>"+converter(entity.field_31)+"</td><td>"+converter(entity.field_32)+"</td><td>"+sum32.toFixed(2)+"</td><td>"+converter(entity.field_33)+"</td><td>"+converter(entity.field_34)+"</td><td>"+(sum32/sum31*100).toFixed(2)+"%</td><td>"+converter(entity.field_35)+"%</td><td>"+converter(entity.field_36)+"%</td></tr>";
				})
				$('#dataContent').html(dataContent);
			} else {
				layer.msg('没有查询到符合条件的记录', {icon : 0});
				dataContent="<tr><td colspan='12' style='height:150px;text-align:center;font-size:14px;'><span>没有查询到符合条件的记录</span></td></tr>";
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
	//询问框
	layer.confirm('您确定要提交该表单数据吗？', {
		btn : [ '确定', '取消' ]
	//按钮
	}, function() {
		layer.msg('正在提交中...', {icon: 16,shade: 0.01});
		$.ajax({
			type : "post",
			url : "/gj/smz/save",
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
	$.get("/gj/smz/detail?id="+id,function(data,status){
		  $('#year').val(data.entity.year).attr("disabled",true);
		  $('#month').val(data.entity.month).attr("disabled",true);
		  $('#id').val(id);
		  $('#field_11').val(data.entity.field_11);
		  $('#field_12').val(data.entity.field_12);
		  $('#field_13').val(data.entity.field_13);
		  $('#field_14').val(data.entity.field_14);
		  $('#field_15').val(data.entity.field_15);
		  $('#field_16').val(data.entity.field_16);
		  $('#field_21').val(data.entity.field_21);
		  $('#field_22').val(data.entity.field_22);
		  $('#field_23').val(data.entity.field_23);
		  $('#field_24').val(data.entity.field_24);
		  $('#field_25').val(data.entity.field_25);
		  $('#field_26').val(data.entity.field_26);
		  $('#field_31').val(data.entity.field_31);
		  $('#field_32').val(data.entity.field_32);
		  $('#field_33').val(data.entity.field_33);
		  $('#field_34').val(data.entity.field_34);
		  $('#field_35').val(data.entity.field_35);
		  $('#field_36').val(data.entity.field_36);
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
	  $('#field_15').val('');
	  $('#field_16').val('');
	  $('#field_17').val('');
	  $('#field_21').val('');
	  $('#field_22').val('');
	  $('#field_23').val('');
	  $('#field_24').val('');
	  $('#field_25').val('');
	  $('#field_26').val('');
	  $('#field_27').val('');
	  $('#field_31').val('');
	  $('#field_32').val('');
	  $('#field_33').val('');
	  $('#field_34').val('');
	  $('#field_35').val('');
	  $('#field_36').val('');
	  $('#field_37').val('');
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
			url : "/gj/smz/delete",
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

