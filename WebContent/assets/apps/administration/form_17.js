$('#searchData').click(function() {
	var loadingYear = $('#selectYear').val();
	var loadingMonth = $('#selectMonth').val();
	
	if (loadingYear == '') {
		layer.msg('请先选择年份');
		return;
	}
	if (loadingMonth == '') {
		layer.msg('请选择月份');
		return;
	}
	queryJsonData(loadingYear,loadingMonth);
	
})
//列表数据
var queryJsonData = function (loadingYear,loadingMonth){
	layer.msg('数据查询中', {
		time : 0, // 不自动关闭
		icon : 16,
		shade : 0.01
	});
	var dataContent = "";
	$.ajax({
		type : "get",
		url : "/gj/telecomValueAdded/list",
		data : {year : loadingYear,month : loadingMonth},
		dataType : "json",
		success : function(data) {
			layer.closeAll();
			if(data.status=='success'){
				if (data.telecomValueAddedBatch.telecomValueAddedList!=null&&data.telecomValueAddedBatch.telecomValueAddedList.length>0) {
					layer.msg('数据加载成功');
					$('#dataContent').html('数据加载成功');
				} else {
					layer.msg('没有查询到符合条件的记录', {icon : 0});
					$('#dataContent').html('没有查询到符合条件的记录');
				}
			}else{
				layer.msg('数据加载有误');
				$('#dataContent').html('数据加载有误');
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
	var loadingMonth = $("#selectMonth").val();
	if(loadingYear==''&&loadingMonth==''){
		var date  = new Date();
		loadingYear = date.getFullYear();
		loadingMonth = date.getMonth();
		//上一年十二月份
		if(loadingMonth==0){
			loadingYear = loadingYear-1;
			loadingMonth = 12;
		}
		$("#selectYear option").each(function (){  
		    if($(this).val()==loadingYear){   
		    	$(this).attr("selected",'selected');  
		 }}); 
		$("#selectMonth option").each(function (){  
		    if($(this).val()==loadingMonth){   
		    	$(this).attr("selected",'selected');
		 }}); 
	}
	queryJsonData(loadingYear,loadingMonth);
}();
