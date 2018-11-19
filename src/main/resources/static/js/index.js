$(function(){
	//左侧导航菜单
	$(".leftmenu>li").mouseenter(function(){
		$(this).addClass("current").siblings().removeClass("current");		
	});
	
	$(".leftmenu>li").mouseleave(function(){
		$(this).removeClass("current");		
	});
	//图书推荐js代码
	$("#book>.totle").eq(0).show()
	$("#book .title ul li").mouseover(function(){
		var index = $(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$("#book>.totle").eq(index).show().siblings("#book>.totle").hide();
	});
	
	$(".last_content>ul>li").mouseenter(function(){
		$(this).addClass("_active").siblings().removeClass("_active");
	});
	//服装推荐js代码
	$("#cloth>.totle").eq(0).show()
	$("#cloth .title ul li").mouseover(function(){
		var index = $(this).index();
		console.log(index);
		$(this).addClass("active").siblings().removeClass("active");
		$("#cloth>.totle").eq(index).show().siblings("#cloth>.totle").hide();
	});
	//运动装js代码
	$("#sport>.totle").eq(0).show()
	$("#sport .title ul li").mouseover(function(){
		var index = $(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$("#sport>.totle").eq(index).show().siblings("#sport>.totle").hide();
	});
	//童装js代码
	$("#child>.totle").eq(0).show()
	$("#child .title ul li").mouseover(function(){
		var index = $(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$("#child>.totle").eq(index).show().siblings("#child>.totle").hide();
	});
	//推广商品js代码
	$("#intor>.promenu").eq(0).show()
	$("#intor .title ul li").mouseover(function(){
		var index = $(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$("#intor>.promenu").eq(index).show().siblings("#intor>.promenu").hide();
	});
	$("#intor>.promenu ul li").mouseenter(function(){
		$(this).css("background-color","#CCCCCC");
	});
	$("#intor>.promenu ul li").mouseleave(function(){
		$(this).css("background-color","#fff");
	});
	
	//首页轮播特效
 
	var opts={
			boxh:430,//盒子的高度
			w:1000,//盒子的宽度
			h:400,//图片的高度
			isShow:true,//是否显示控制器
			isShowBtn:true,//是否显示左右按钮
			controltop:6,//控制按钮上下偏移的位置,要将按钮向下移动   首先保证boxh 高度>图片 h
			controlsW:22,//控制按钮宽度
			controlsH:22,//控制按钮高度
			radius:11,//控制按钮圆角度数
			controlsColor:"#CCC",//普通控制按钮的颜色
			controlsCurrentColor:"#ff6600"//当前控制按钮的颜色
	};
	$("#ppt01").tyslide(opts);
	
	//图书轮播特效
	var opts={
			boxh:220,//盒子的高度
			w:334,//盒子的宽度
			h:220,//图片的高度
			isShow:false,//是否显示控制器
			isShowBtn:true,//是否显示左右按钮
			controltop:6,//控制按钮上下偏移的位置,要将按钮向下移动   首先保证boxh 高度>图片 h
			controlsW:22,//控制按钮宽度
			controlsH:22,//控制按钮高度
			radius:11,//控制按钮圆角度数
			controlsColor:"#CCC",//普通控制按钮的颜色
			controlsCurrentColor:"#ff6600"//当前控制按钮的颜色
	};
	$(".ppt02").tyslide(opts);
	
	
	//服装推荐轮播
	var opts={
			boxh:340,//盒子的高度
			w:427,//盒子的宽度
			h:340,//图片的高度
			isShow:false,//是否显示控制器
			isShowBtn:true,//是否显示左右按钮
			controltop:6,//控制按钮上下偏移的位置,要将按钮向下移动   首先保证boxh 高度>图片 h
			controlsW:22,//控制按钮宽度
			controlsH:22,//控制按钮高度
			radius:11,//控制按钮圆角度数
			controlsColor:"#CCC",//普通控制按钮的颜色
			controlsCurrentColor:"#ff6600"//当前控制按钮的颜色
	};
	$(".ppt03").tyslide(opts);
	//运动日常轮播
	var opts={
			boxh:340,//盒子的高度
			w:427,//盒子的宽度
			h:340,//图片的高度
			isShow:false,//是否显示控制器
			isShowBtn:true,//是否显示左右按钮
			controltop:6,//控制按钮上下偏移的位置,要将按钮向下移动   首先保证boxh 高度>图片 h
			controlsW:22,//控制按钮宽度
			controlsH:22,//控制按钮高度
			radius:11,//控制按钮圆角度数
			controlsColor:"#ccc",//普通控制按钮的颜色
			controlsCurrentColor:"#ff6600"//当前控制按钮的颜色
	};
	$(".ppt04").tyslide(opts);
	
	//儿童服装轮播
	var opts={
			boxh:340,//盒子的高度
			w:427,//盒子的宽度
			h:340,//图片的高度
			isShow:false,//是否显示控制器
			isShowBtn:true,//是否显示左右按钮
			controltop:6,//控制按钮上下偏移的位置,要将按钮向下移动   首先保证boxh 高度>图片 h
			controlsW:22,//控制按钮宽度
			controlsH:22,//控制按钮高度
			radius:11,//控制按钮圆角度数
			controlsColor:"#CCC",//普通控制按钮的颜色
			controlsCurrentColor:"#ff6600"//当前控制按钮的颜色
	};
	$(".ppt05").tyslide(opts);
	
	
	$(window).scroll(function(){
		setFixedWrapper();
		showGotoTop();
		change();
	});
	function setFixedWrapper()
	{
		if($(document).scrollTop()>100)
		{
			$("#fixedwrapper").slideDown(500);
		}
		else{
			$("#fixedwrapper").slideUp(500);
		}
	}
	
	
	$("input[name='searchinput']").focus(function(){
		 if($(this).val()==$(this).attr("data-title"))
		 {
		 	$(this).val("");
		 	$(this).css({"color":"#000"});
		 }


	}).blur(function(){//trim函数就是把字符串中的空格去掉
		if(!($(this).val().trim().length>0))
		{
			$(this).val($(this).attr("data-title"));
			$(this).css({"color":"#ccc"});
		}
	});
	
	//电梯效果
	$("#floors>li").mouseenter(function(){
		var txt=$(this).attr("data-text");
		var bgcolor=$(this).attr("data-color");
		$(this).find("span").text(txt).show();
		$(this).css({"background-color":bgcolor});
		$(this).stop(true,true).animate({"width":"80px"},500);
	});
	
	$("#floors>li").mouseleave(function(){
		$(this).find("span").hide();
		$(this).css({"background-color":"transparent"});
		$(this).stop(true,true).animate({"width":"40px"},500);
	});
	
	
	$("#floors>li").click(function(){
		var id=$(this).attr("data-id");
		var topval=$("#"+id).offset().top;
		$("html,body").animate({
			scrollTop:(topval-100)
		});
		
	});
	
	
		function showGotoTop()
	{
		if($(document).scrollTop()>1000)
		{
			$("#btngototop").fadeIn();
		}
		else
		{
			$("#btngototop").fadeOut();
		}
	}
	
	
	//滚动到顶部的效果
	$("#btngototop").click(function(){
		$("html,body").animate({
			 scrollTop:0
		},500)
	});
	
	
	//二维码效果
	$("#twocode>li.middle").mouseenter(function(){
		$("#codeimg").stop(true,true).fadeIn();
	}).mouseleave(function(){
		$("#codeimg").stop(true,true).fadeOut();
	});
	
	//滑动楼层变色效果
	function change(){
		var topvalbook=$("#book").offset().top;
		var topvalcloth=$("#cloth").offset().top;
		var topvalsport = $("#sport").offset().top;
		var topvalchild = $("#child").offset().top;
		var topvalfamily = $("#family").offset().top;
		if($(document).scrollTop()>topvalbook-200&&$(document).scrollTop()<topvalcloth-200)
		{
			$("#floors .book").addClass("change");
			$("#floors .book").siblings().removeClass("change");
		}
	    
		else if($(document).scrollTop()>topvalcloth-200&&$(document).scrollTop()<topvalsport-200){
			$("#floors .cloth").addClass("change");
				$("#floors .cloth").siblings().removeClass("change");
		}
		else if($(document).scrollTop()>topvalsport-200&&$(document).scrollTop()<topvalchild-200){
			$("#floors .sport").addClass("change");
				$("#floors .sport").siblings().removeClass("change");
		}
		else if($(document).scrollTop()>topvalchild-200&&$(document).scrollTop()<topvalfamily-200){
			$("#floors .child").addClass("change");
				$("#floors .child").siblings().removeClass("change");
		}
		
		else if($(document).scrollTop()>topvalfamily-200&&$(document).scrollTop()<topvalfamily+400){
			$("#floors .family").addClass("change");
			$("#floors .family").siblings().removeClass("change");
		}
	    else if($(document).scrollTop()<topvalbook-200 || $(document).scrollTop()>topvalfamily-100){
		$("#floors").children().removeClass("change");
	    }
	}
});