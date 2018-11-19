$(function(){
	
	$("#shop .pay").click(function(){
		$(".true").show();
	});
	$(".true .close>a").click(function(){
		$(".true").hide();
	});
	$(".true .close p.first>span").click(function(){
		$(".true").hide();
	});
	
	
	$("#shop .otherpay a").click(function(){
		$(".false").show();
	});
	$(".false .close>a").click(function(){
		$(".false").hide();
	});
	$(".false .close p.first>span").click(function(){
		$(".false").hide();
	});
});