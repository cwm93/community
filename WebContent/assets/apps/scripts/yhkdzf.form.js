$.validator.setDefaults({
	submitHandler : function(form) {
		// 询问框
		layer.confirm('您确定要提交该表单数据吗？', {
			btn : [ '确定', '取消' ]
		// 按钮
		}, function() {
			form1.submit();
			layer.msg('正在提交中...', {
				icon : 16,
				shade : 0.01
			});
		}, function() {
			layer.msg('您已取消提交表单数据');
		});
	}
});

$(document).ready(function() {
	$('#form1').validate({
		rules : {
			accept : {
				required : true
			}
		},
		messages : {
			accept : {
				required : "请勾选承诺数据有效，真实可靠"
			}
		}
	});
})
