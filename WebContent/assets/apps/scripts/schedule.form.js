/**
 * 
 */
jQuery(document).ready(function() {
        	$('.date-picker').datepicker({
                language: 'zh-CN',
                autoclose: true,
                todayHighlight: true
            })
            $('.timepicker-24').timepicker({
                autoclose: true,
                minuteStep: 5,
                showSeconds: false,
                showMeridian: false
            });
        	$('.timepicker').parent('.input-group').on('click', '.input-group-btn', function(e){
                e.preventDefault();
                $(this).parent('.input-group').find('.timepicker').timepicker('showWidget');
            });
        	$(':radio').click(function(){
        		$(':radio').each(function(index,domEle){	
          		   if($(this).is(":checked")){
          			 $("#tab_"+$(this).val()).addClass("active");
              	   }else{
              		  $("#tab_"+$(this).val()).removeClass("active");
              	   }
               	})
        	})
        	$('#user_multi_select').multiSelect();
            
        	var FormValidation = function(){
        		// basic validation
        	    var handleValidation = function() {
        	    	var scheduleForm = $('#scheduleForm');
                    var error = $('.alert-danger', scheduleForm);
                    var success = $('.alert-success', scheduleForm);
                    scheduleForm.validate({
                        errorElement: 'span', //default input error message container
                        errorClass: 'help-block help-block-error', // default input error message class
                        focusInvalid: false, // do not focus the last invalid input
                        ignore: "",  // validate all fields including form hidden input
                        messages: {
                        	sendedUsers: {
                                minlength: jQuery.validator.format("至少选择{0} 人")
                            }
                        },
                        rules: {
                            name: {
                                required: true
                            },
                            reportId: {
                                required: true
                            },
                            sendedUsers: {
                                required: true,
                                minlength: 1
                            },
                            type:{
                            	 required: true
                            },
                            sendTime:{
                            	required: true
                            }
                        },
                        invalidHandler: function (event, validator) { //display error alert on form submit              
                            success.hide();
                            error.show();
                            App.scrollTo(error, -200);
                        },

                        errorPlacement: function (error, element) { // render error placement for each input type
                            var cont = $(element).parent('.input-group');
                            if (cont) {
                                cont.after(error);
                            } else {
                                element.after(error);
                            }
                        },
                        highlight: function (element) { // hightlight error inputs
                            $(element) .closest('.form-group').addClass('has-error'); // set error class to the control group
                        },
                        unhighlight: function (element) { // revert the change done by hightlight
                            $(element).closest('.form-group').removeClass('has-error'); // set error class to the control group
                        },
                        success: function (label) {
                            label.closest('.form-group').removeClass('has-error'); // set success class to the control group
                        },
                        submitHandler: function (form) {
                            success.show();
                            error.hide();
                            flag = true;
                            $(':radio').each(function(index,domEle){	
                       		   if($(this).is(":checked")){
                       			 if($(this).val()==1){
                                 	if($("#sendDate")==''){
                                 		alert('发送日期不能为空');
                                 		flag = false;
                                 	}
                                 }else if($(this).val()==2){
                                	 if($("#sendWeek")==''){
                                  		alert('星期不能为空');
                                  		flag = false;
                                  	 }
                                	 if($('#startDate2').val()==''||$('#endDate2').val()==''){
                                		 alert('执行日期范围均不为空');
                                		 flag = false;
                                	 }
                                 }else{
                                	if($("#sendDay")==''){
                                  		alert('每月几号不能为空');
                                  		flag = false;
                                  	}
                                	if($('#startDate3').val()==''||$('#endDate3').val()==''){
                                		 alert('执行日期范围均不为空');
                                		 flag = false;
                                	}
                                 }
                           	   }
                             })
                           if(flag){
                        	 //询问框
               				layer.confirm('您确定要提交该表单数据吗？', {
               					btn : [ '确定', '取消' ]
               				//按钮
               				}, function() {
               					form1.submit();
               					layer.msg('正在提交中...', {
               						  icon: 16
               						  ,shade: 0.01
               						});
               				}, function() {
               					layer.msg('您已取消提交表单数据');
               				});
                           }
                           
                        }
                    });
        		}
        	    return {
        	        //main function to initiate the module
        	        init: function () {
        	            handleValidation();
        	        }
        	    };
        	}();
        	FormValidation.init();
        })