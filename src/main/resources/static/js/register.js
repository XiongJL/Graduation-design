$(function() {

	_form();
	_inputO();
	 a() ;
})



function _form() {
	
	$("#signupForm").validate({
		errorPlacement: function(error, element) {
			
			
			element.parent().find("span[name='error']").html("*"+$(error).html())
	},
	errorElement:'em',
		rules: {
			username: {
				required: true,
				minlength: 4
			},
			password2: {
				required: true,
				minlength: 6
			},
			password1: {
				required: true,
				equalTo: "password2"
			},
			phone: {
				required: true,
				maxlength: 11,
				minlength: 7,
				digits: true

			}
		},
		messages: {
			username: {
				required: "请输入用户名",
				minlength: "至少2个字"
			},
			password2: {
				required: "请输入密码",
				minlength: '请输入至少6位'
			},
			password1: {
				required: "请确认密码",

			},
			phone: {
				required: '请输入你的电话号码',
				maxlength: '请输入一个11位数的电话号码',
				minlength: '请输入一个至少位数的电话号码',
				digits: '必须为正整数'
			}
		}

	});
};

function _inputO() {
		var username = document.getElementsByName('username')[0];
		username.onfocus = function() {
				username.placeholder = '';
			}
		var _password = document.getElementsByName('password2')[0];
		_password.onfocus = function() {
				_password.placeholder = '';
			}
	var _password1 = document.getElementsByName('password1')[0];
	_password1.onfocus = function() {
		_password1.placeholder = '';
	}
	var phone = document.getElementsByName('phone')[0];
	phone.onfocus = function() {
		phone.placeholder = '';
	}
	var yazheng = document.getElementsByName('yazheng')[0];
	yazheng.onfocus = function() {
		yazheng.placeholder = '';
	}
	var yazheng1 = document.getElementsByName('yz')[0];
	yazheng1.onfocus = function() {
		yazheng1.placeholder = '';
	}
}

function a() {	
		//注册
		var _username = document.getElementsByName('username')[0];
		_username.onblur = function() {
				_username.placeholder = '您的账户名和登录名';
			}
		var _password = document.getElementsByName('password2')[0];
		_password.onblur = function() {
				_password.placeholder = '建议设置两种字符密码';
			}
		
		var _password1 = document.getElementsByName('password1')[0];
		_password1.onblur = function() {
				_password1.placeholder = '再次输入密码';
			}
	var phone = document.getElementsByName('phone')[0];
		phone.onblur = function() {
		phone.placeholder = '建议使用常用手机号';
			}
	var yazheng = document.getElementsByName('yazheng')[0];
		yazheng.onblur = function() {
		yazheng.placeholder = '请输入验证码';
			}
	var yazheng1= document.getElementsByName('yz')[0];
		yazheng1.onblur = function() {
		yazheng1.placeholder = '输入手机验证码';
			}
		
}