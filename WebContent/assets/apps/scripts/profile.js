/**
 * 个人资料&修改密码
 */
var validateData = function(){
	 var handlerChangePw = function(){
	       $('.password-form').validate({
	           errorElement: 'span', //default input error message container
	           errorClass: 'help-block', // default input error message class
	           focusInvalid: false, // do not focus the last invalid input
	           rules: {
	        	   oldpassword: {
	                   required: true
	               },
	               newpassword: {
	                   required: true
	               },
	               rnewpassword: {
	                   required: true,
	                   equalTo:$('#newpassword')
	               }
	           },
	           messages: {
	        	   oldpassword: {
	                   required: "请输入旧密码"
	               },
	               newpassword: {
	                   required: "请输入新密码"
	               },
	               rnewpassword: {
	                   required: "请输入确认密码",
	                   equalTo:"与新密码输入不一致"
	               }
	           },
	           invalidHandler: function(event, validator) { //display error alert on form submit 
	        	   layer.msg('信息填写有误', {icon : 0});
	           },

	           highlight: function(element) { // hightlight error inputs
	               $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
	           },

	           success: function(label) {
	               label.closest('.form-group').removeClass('has-error');
	               label.remove();
	           },

	           errorPlacement: function(error, element) {
	        	   if (element.closest('.input-icon').size() === 1) {
	                    error.insertAfter(element.closest('.input-icon'));
	                } else {
	                    error.insertAfter(element);
	                }
	           },
	           submitHandler: function(form) {
	        	   $.ajax({
	        			cache : true,
	        			type : "POST",
	        			url : "/user/changePassword",
	        			data : $('#passwordForm').serialize(),
	        			async : false,
	        			dataType : "json",
	        			success : function(data) {
	        				if (data.code == 0) {
	        					layer.msg('密码修改成功！', {icon : 1});
	        				} else {
	        					layer.msg('密码修改失败', {icon : 0});
	        				}
	        			},
	        			error : function() {
	        				layer.msg('操作异常，请稍后刷新重试', {icon : 0});
	        			}
	        		})
	           }
	       });
	   }
 return {
        //main function to initiate the module
        init: function() {
        	handlerChangePw();
        }
    };
}();
jQuery(document).ready(function() {
   validateData.init();
});

function resetPassword(userId){
	if(!confirm('您确定要重置该用户的密码吗？')){
		return ;
	}
	$.ajax({
		type : "POST",
		url : "/user/resetPassword",
		data : {userId:userId},
		dataType : "json",
		success : function(data) {
			if (data.code == 0) {
				layer.msg(data.msg, {icon : 1});
			} else {
				layer.msg(data.msg, {icon : 0});
			}
		},
		error : function() {
			layer.msg('操作异常，请稍后刷新重试', {icon : 0});
		}
	})
}