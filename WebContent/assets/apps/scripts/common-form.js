/**
 * 
 */
$(function() {
	$('#formSave').click(function() {
		$('#flag').val('0');
		layer.msg('正在保存中...', {icon : 16,shade : 0.01});
		submitAction();
	})

	$('#formSubmit').click(function() {
		$('#flag').val('1');
		$("#form1").submit(function(event) {
			event.preventDefault();
			if (!$('#accept').is(':checked')) {
				alert('请勾选本人承诺以上申报数据真实有效，有据可查');
				return false;
			}
			layer.msg('正在提交中...', {icon : 16,shade : 0.01});
			submitAction();
		});
	})

	var submitAction = function() {
		var url = $('#form1').attr("action");
		$.ajax({
			type : 'post',
			url : url,
			data : $('#form1').serialize(),
			dataType : 'json',
			success : function(data) {
				if (data.code == 0) {
					layer.msg('操作成功,正在刷新，请稍后...', {icon : 16,shade : 0.01});
					setTimeout(function() {
						window.location.reload();
					}, 2000);
				} else {
					layer.msg(data.msg, { icon : 0});
				}
			},
			error : function() {
				layer.msg('数据格式有误，请仔细检查后提交', { icon : 0});
			}
		})
	}
})