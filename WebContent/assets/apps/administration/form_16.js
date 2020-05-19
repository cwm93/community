/**
 * 码号管理
 */
/**
			 * 码号分类 form_16
			 */
			
			
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

var queryJsonData = function (loadingYear,loadingMonth){
	layer.msg('数据查询中', {
		time : 0, // 不自动关闭
		icon : 16,
		shade : 0.01
	});
	var dataContent = "";
	var dataContent2= "";
	$.ajax({
		type : "get",
		url : "/codeclass/list",
		data : {year : loadingYear,month : loadingMonth},
		dataType : "json",
		success : function(data) {
			layer.closeAll();
			if(data.status=='success'){
				if (data.codeClassificationList!=null&&data.codeClassificationList.length>0) {
					layer.msg('数据加载成功');
					
					dataContent2 =  "<tr><td>10630</td><td>"+data.counter[0]+"</td></tr>"+
									"<tr><td>10639</td><td>"+data.counter[1]+"</td></tr>"+
									"<tr><td>1062XXXX</td><td>"+data.counter[2]+"</td></tr>"+
									"<tr><td>10635-10638</td><td>"+data.counter[3]+"</td></tr>"+
									"<tr><td>962XXX</td><td>"+data.counter[4]+"</td></tr>"+
									"<tr><td>96XXX</td><td>"+data.counter[5]+"</td></tr>"+
									"<tr><td>总计</td><td>"+data.counterAll+"</td></tr>";
					$('#data_tj').html(dataContent2);
					//显示到图表
					showHighchats(data.counter);
				    dataContent= dataContent+'<table id="tablesList" class="table table-striped table-bordered table-advance table-hover schedule-table">'+
					'<thead><tr><th class="text-center">短号码/短消息代码代码</th><th class="text-center">分类</th><th class="text-center">启用时间</th><th class="text-center">批准使用单位</th><th class="text-center">批准时间</th><th class="text-center">码号截止日期</th><th class="text-center">类型</th></tr></thead>'+
					'<tbody>';
				    //为了重新渲染TableList
					$("#tablesList").dataTable().fnDestroy();
					$.each(data.codeClassificationList,function(index,entity){
						dataContent = dataContent +'<tr><td>'+entity.codeNumber+'</td><td>'+entity.classification+'</td><td>'+entity.startTime+'</td><td>'+entity.usedCompany+'</td><td>'+entity.auditedTime+'</td><td>'+entity.endTime+'</td><td>'+entity.type+'</td></tr>';
					})
					$('#dataContent').html(dataContent+'</tbody></table>');
					$('#tablesList').dataTable({
			            "language": {
			                "aria": {
			                    "sortAscending": ": activate to sort column ascending",
			                    "sortDescending": ": activate to sort column descending"
			                },
			                "info": "显示 _START_ 到 _END_ 条  共 _TOTAL_ 条",
			                "infoEmpty": "没有发现可加载的数据",
			                "infoFiltered": "",
			                "lengthMenu": "_MENU_ 条",
			                "search": "全局检索:",
			                "zeroRecords": "没有发现匹配项目"
			            },

			            "order": [
			                [0, 'asc']
			            ],
			            
			            "lengthMenu": [
			                [5, 10, 15, 20, -1],
			                [5, 10, 15, 20, "全部"] // change per page values here
			            ],
			            // set the initial value
			            "pageLength": 10,
			            bDestroy: true
			        });
					$('#containerMHFL').show();
				} else {
					layer.msg('没有查询到符合条件的记录', {icon : 0});
					dataContent2 =  "<tr><td>10630</td><td>0</td></tr>"+
					"<tr><td>10639</td><td>0</td></tr>"+
					"<tr><td>1062XXXX</td><td>0</td></tr>"+
					"<tr><td>10635-10638</td><td>0</td></tr>"+
					"<tr><td>962XXX</td><td>0</td></tr>"+
					"<tr><td>96XXX</td><td>0</td></tr>"+
					"<tr><td>总计</td><td>0</td></tr>";
					$('#data_tj').html(dataContent2);
					dataContent= dataContent+'<table class="table table-striped table-bordered table-advance table-hover schedule-table">'+
					'<thead><tr><th class="text-center">短号码/短消息代码代码</th><th class="text-center">分类</th><th class="text-center">启用时间</th><th class="text-center">批准使用单位</th><th class="text-center">批准时间</th><th class="text-center">码号截止日期</th><th class="text-center">类型</th></tr></thead>'+
					'<tbody><tr><td colspan="7" style="height:150px;text-align:center;font-size:14px;"><span>没有查询到符合条件的记录</span></td></tr></tbody></table>';
					$('#dataContent').html(dataContent);
					$('#containerMHFL').hide();
				}
			}else{
				layer.msg('数据加载有误');
				$('#containerMHFL').hide();
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

var showHighchats = function(counter){
	$('#containerMHFL').highcharts({
				chart : {
					plotBackgroundColor : null,
					plotBorderWidth : null,
					plotShadow : false
				},
				title : {
					text : '码号分类'
				},
				tooltip : {
					headerFormat : '{series.name}<br>',
					pointFormat : '{point.name}: <b>{point.percentage:.1f}%</b>'
				},
				plotOptions : {
					pie : {
						allowPointSelect : true,
						cursor : 'pointer',
						dataLabels : {
							enabled : true,
							format : '<b>{point.name}</b>: {point.percentage:.1f} %',
							style : {
								color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
										|| 'black'
							}
						},
						showInLegend : true
					}
				},
				series : [ {
					type : 'pie',
					name : '码号类型占比',
					data : [ 
						    [ '10630', counter[0] ], 
						    [ '10639', counter[1] ],
							[ '1062XXXX', counter[2] ],
							[ '10635-10638', counter[3] ],
							[ '962XXX', counter[4] ], 
							[ '96XXX', counter[5] ] ]
				} ]
	});	
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

