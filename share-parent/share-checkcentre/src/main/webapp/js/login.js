function Login(){};

var login = new Login();

/**
 * 加载验证码
 */
Login.prototype.loadCaptcha = function(){
	$.ajax({
		url: "../prelogin",
		type: "GET",
		dataType:"json",
		success : function(data){
			if (data) {
				$("#captcha").attr("src", data.imgData);
			}
		}
	});
}

/**
 * 点击验证码
 */
Login.prototype.clickCaptcha = function(){
	$("#captcha").on('click', function(){
		login.loadCaptcha();
	});
}

/**
 * 主函数调用
 */
$(document).ready(function(){
	login.loadCaptcha();
	login.clickCaptcha(); //注册点击事件
});
