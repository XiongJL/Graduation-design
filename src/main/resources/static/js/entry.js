$(function(){
	$("#banner .join>span").mouseenter(function(){
		var index = $(this).index();
		$(this).addClass("active").siblings().removeClass("active");
        $(".join div").eq(index).show().siblings("div").hide();
	});
	
	$(".username,.password").focus(function(){
	  this.placeholder = "";
	});
	
	
	$(".username").blur(function(){
	  this.placeholder = "请输入用户名";
	});
	
	$(".password").blur(function(){
	  this.placeholder = "请输入密码";
	});
});