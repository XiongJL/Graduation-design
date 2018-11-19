$(function(){
	$(".click .content ul li").mouseenter(function(){
		$(this).children("a.join").stop().fadeIn();
	});
	$(".click .content ul li").mouseleave(function(){
		$(this).children("a.join").stop().fadeOut();
	});
	
	//首页轮播特效
 
	var opts={
			boxh:500,//盒子的高度
			w:700,//盒子的宽度
			h:460,//图片的高度
			isShow:true,//是否显示控制器
			isShowBtn:true,//是否显示左右按钮
			controltop:60,//控制按钮上下偏移的位置,要将按钮向下移动   首先保证boxh 高度>图片 h
			controlsW:22,//控制按钮宽度
			controlsH:22,//控制按钮高度
			radius:11,//控制按钮圆角度数
			controlsColor:"#CCC",//普通控制按钮的颜色
			controlsCurrentColor:"#ff6600"//当前控制按钮的颜色
	};
	$("#ppt01").tyslide(opts);
	
	$("#logo .lists a").mouseenter(function(){
		$(this).addClass("a").siblings().removeClass("a");
	});
});