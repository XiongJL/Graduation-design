$(function(){
	
	$(".sendto span").click(function(){
		$(".true").show();
	});
	$(".true .close .last .a").click(function(){
		$(".true").hide();
	});
	$(".true .close p.first>span").click(function(){
		$(".true").hide();
	});
	
	$("#content .pay>p>span").click(function(){
		$(this).addClass("a").siblings().removeClass("a");
	});
});