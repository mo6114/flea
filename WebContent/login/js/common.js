//打开字滑入效果
window.onload = function(){
	$(".connect p").eq(0).animate({"left":"0%"}, 600);
	$(".connect p").eq(1).animate({"left":"0%"}, 400);
};
//jquery.validate表单验证
$(document).ready(function(){
	//登陆表单验证
	$("#loginForm").validate({
		rules:{
			userName:{
				required:true,
				minlength:3,
				maxlength:20,
			},
			password:{
				required:true,
				minlength:3, 
				maxlength:32,
			},
		},
		//错误信息提示
		messages:{
			userName:{
				required:"必须填写用户名",
				minlength:"用户名至少为3个字符",
				maxlength:"用户名至多为20个字符",
				remote: "用户名已存在",
			},
			password:{
				required:"必须填写密码",
				minlength:"密码至少为3个字符",
				maxlength:"密码至多为32个字符",
			},
		},

	});
	//注册表单验证
	$("#registerForm").validate({
		rules:{
			userName:{
				required:true,
				minlength:2,
				maxlength:20,
				remote: {
					url: "/flea/fUser/userNameIsExist",
					type: "get",
					dataType: "json",
					data: {
						userName: function() {
							return $(".userName").val();
						}
					}
				}
			},
			password:{
				required:true,
				minlength:3, 
				maxlength:32,
			},
			email:{
				required:true,
				email:true,
				remote: {
					url: "/flea/fUser/emailIsExist",     //后台处理程序
					type: "get",               //数据发送方式
					dataType: "json",           //接受数据格式
					data: {                     //要传递的数据
						email: function() {
							return $(".email").val();
						}
					}
				}
			},
			confirm_password:{
				required:true,
				minlength:3,
				equalTo:'.password'
			},
			phone_number:{
				required:true,
				phone_number:true,//自定义的规则
				digits:true,//整数
			}
		},
		//错误信息提示
		messages:{
			userName:{
				required:"必须填写用户名",
				minlength:"用户名至少为2个字符",
				maxlength:"用户名至多为20个字符",
				remote:"用户名已存在"
			},
			password:{
				required:"必须填写密码",
				minlength:"密码至少为3个字符",
				maxlength:"密码至多为32个字符",
			},
			email:{
				required:"请输入邮箱地址",
				email: "请输入正确的email地址",
				remote:"邮箱已存在"
			},
			confirm_password:{
				required: "请再次输入密码",
				minlength: "确认密码不能少于3个字符",
				equalTo: "两次输入密码不一致",//与另一个元素相同
			},
			phone_number:{
				required:"请输入手机号码",
				digits:"请输入正确的手机号码",
			},
		
		},
	});
	//取消keyup事件
	$(".userName").validate({
		onkeyup:false
	})
	$(".email").validate({
		onkeyup:false
	})
	//添加自定义验证规则
	jQuery.validator.addMethod("phone_number", function(value, element) {
		var length = value.length; 
		var phone_number = /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/
		return this.optional(element) || (length == 11 && phone_number.test(value)); 
	}, "手机号码格式错误");
	jQuery.validator.addMethod("email", function(value, element) {
		var email = /^[a-z]*([a-z0-9]*[-_]?[a-z0-9]+)*@([a-z0-9]*[-_]?[a-z0-9]+)+[\.][a-z]{2,3}([\.][a-z]{2})?$/
		return this.optional(element)||email.test(value);
	}, "邮箱格式错误");
});
