$(function(){
	$("#hotbook .content ul li").mouseenter(function(){
		$(this).css("background-color","#CCCCCC");
	});
	$("#hotbook .content ul li").mouseleave(function(){
		$(this).css("background-color","#fff");
	});
	
	$(".booka>.totle").eq(0).show()
	$(".booka .title ul li").mouseover(function(){
		var index = $(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$(".booka>.totle").eq(index).show().siblings(".booka>.totle").hide();
	});
	
	
	
  
  $("#book .content .text>p>a").click(function(){
  	$(this).addClass("b").siblings().removeClass("b");
  });
  //清除浏览器默认行为
	$("li.addnum,li.reduce").each(function(index,item){
				item.onselectstart=function(){
					return false;
				};
			});
	//全选
  $("li.addnum").click(function(){
     var num = $(".text>p.add span").text();
     num++;
     $(".text>p.add span").text(num);
  });
  
    $("li.reduce").click(function(){
     var num = $(".text>p.add span").text();
     num--;
     if(num<1){
     	num = 1;
     }
     $(".text>p.add span").text(num);
  });
});