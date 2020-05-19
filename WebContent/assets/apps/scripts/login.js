var Login = function() {

    var handleLogin = function() {

        $('.login-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
                username: {
                    required: true
                },
                password: {
                    required: true
                },
                remember: {
                    required: false
                }
            },

            messages: {
                username: {
                    required: "请输入账号"
                },
                password: {
                    required: "请输入密码"
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit 
            	$("#errMsg").html("请输入账号或密码");
                $('.alert-danger', $('.login-form')).show();
            },

            highlight: function(element) { // hightlight error inputs
                $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form) {
            	$.ajax({
        			cache : true,
        			type : "POST",
        			url : "/login",
        			data : $('#loginForm').serialize(),
        			async : false,
        			dataType : "json",
        			success : function(data) {
        				if (data.code == 0) {
        					window.location.href = "/index";
        				} else {
        					$("#errMsg").html(data.message);
        					$('.alert-danger', $('.login-form')).show();
        				}
        			},
        			error : function() {
        				$("#errMsg").html("系统错误");
        				$('.alert-danger', $('.login-form')).show();
        			}
        		})
            }
        });

        $('.login-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.login-form').validate().form()) {
                	$.ajax({
            			cache : true,
            			type : "POST",
            			url : "/login",
            			data : $('#loginForm').serialize(),
            			async : false,
            			dataType : "json",
            			success : function(data) {
            				if (data.code == 0) {
            					window.location.href = "/index";
            				} else {
            					$("#errMsg").html(data.message);
            					$('.alert-danger', $('.login-form')).show();
            				}
            			},
            			error : function() {
            				$("#errMsg").html("系统错误");
            				$('.alert-danger', $('.login-form')).show();
            			}
            		})
                }
                return false;
            }
        });
    }
    
    

    var handleForgetPassword = function() {
        $('.forget-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {
                email: {
                    required: true,
                    email: true
                }
            },

            messages: {
                email: {
                    required: "请输入电子邮箱地址",
                    email:"输入的电子邮箱地址格式不正确"
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
            	 $('.alert-danger', $('.forget-form')).show();
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
            	alert('ok');
            }
        });

        jQuery('#forget-password').click(function() {
           window.location.href="/forgotPassword";
        });

        jQuery('#back-btn').click(function() {
        	 window.location.href="/login";
        });

    }

    var handleRegister = function() {
    	
        $('.register-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {
                realname: {
                    required: true
                },
                company: {
                    required: true
                },
                telecomOperator: {
                    required: true
                },
                companyAttribute: {
                    required: true
                },
                position: {
                    required: true
                },
                mobile: {
                    required: true
                },
                email: {
                    required: true,
                    email: true
                },

                username: {
                    required: true
                },
                password: {
                    required: true
                },
                rpassword: {
                	required: true,
                    equalTo: "#register_password"
                }
            },

            messages: { // custom messages for radio buttons and checkboxes
            	 realname: {
                     required: "*这里是必填项"
                 },
                 company: {
                     required: "*这里是必填项"
                 },
                 telecomOperator: {
                     required: "*这里是必选项"
                 },
                 companyAttribute: {
                     required: "*这里是必选项"
                 },
                 position: {
                     required: "*这里是必填项"
                 },
                 mobile: {
                     required: "*这里是必填项"
                 },
                 email: {
                     required: "*这里是必填项",
                     email: "*请填写正确的邮箱格式"
                 },
                 username: {
                     required: "*这里是必填项"
                 },
                 password: {
                     required: "*这里是必填项"
                 },
                 rpassword: {
                 	required: "*这里是必填项",
                     equalTo: "*两次密码不一致"
                 }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
            	$("#errMsg").html("*信息填写不完整 ");
				$('.alert-danger', $('.register-form')).show();
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
            	document.getElementById('#registerForm').submit();
            }
        });

        $('.register-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.register-form').validate().form()) {
                	$('.register-form').submit();
                }
                return false;
            }
        });

        jQuery('#register-btn').click(function() {
        	window.location.href="/register";
        });

        jQuery('#register-back-btn').click(function() {
            window.location.href="/login";
        });
    }
    return {
        //main function to initiate the module
        init: function() {
            handleLogin();
            handleForgetPassword();
            handleRegister();
        }
    };
}();

jQuery(document).ready(function() {
    Login.init();
});