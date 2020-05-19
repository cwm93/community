/**
 * 编辑删除备注操作
 */

	function submitAction(){
		var remarkId = $("#remarkId").val();
		var remarkContent = $("#remarkContent").val();
		if(remarkContent==''){
			layer.msg('备注内容不能为空', {icon : 1});
			return false;
		}
		$.ajax({
			type : "POST",
			url : "/summary/remark/update",
			dataType : "json",
			data : {remarkId : remarkId,remarkContent:remarkContent},
			success : function(data) {
				if (data.data.code == -1) {
					layer.msg(data.data.message, {icon : 0});
					setTimeout(function() {
						layer.closeAll();
					}, 2000);
				} else {
					layer.msg(data.data.message, {icon : 1});
					setTimeout(function() {
						layer.closeAll();
						window.location.reload();
					}, 2000);
				}
			},
			error : function() {
				layer.msg('系统异常，请稍后重试', {icon : 0});
				layer.closeAll();
			}
		})
	}
	
  function editRemark(id){
		$.get("/summary/remark/info",{ remarkId: id}, function(data, status) {
				$('#remarkId').val(data.entity.id);
				$('#remarkContent').val(data.entity.remarkContent);
				$('#remarkModal').modal('show');
		});
	}
	
   function deleteRemark(id){
		layer.confirm('您确定要删除该条记录吗？', {
			btn : [ '确定', '取消' ]
		// 按钮
		}, function() {
			$.ajax({
				type : "POST",
				url : "/summary/remark/delete",
				dataType : "json",
				data : {remarkId : id},
				success : function(data) {
					if (data.data.code == -1) {
						layer.msg(data.data.message, {icon : 0});
						setTimeout(function() {
							layer.closeAll();
						}, 2000);
					} else {
						layer.msg(data.data.message, {icon : 1});
						setTimeout(function() {
							layer.closeAll();
							window.location.reload();
						}, 2000);
					}
				},
				error : function() {
					layer.message('系统异常，请稍后重试', {icon : 0});
					layer.closeAll();
				}
			})
		})
	}
	
	$('#remarkModal').on('hidden.bs.modal', function() {
		$('#remarkId').val(0);
		$('#remarkContent').val('');
	});

