$(function(){

	//清除浏览器默认行为
	$("span.add,span.reduce").each(function(index,item){
				item.onselectstart=function(){
					return false;
				};
			});
	//全选
	$("input.all").click(function(){
		$("input.all,input.one").prop("checked",$(this).prop("checked"));
		sum()
	});
	
	$("input.one").click(function(){
			var flag=true;
				$("input.one").each(function(index,item){
					if(!$(item).is(":checked"))
					{
						flag=false;
					}
				});
				$("input.all").prop("checked",flag);		
		sum();
	});
	//点击加号加一
	$("span.add").click(function(){
		if(!$(this).parent().parent().find("input.one").is(":checked"))
		{
			$(this).parent().parent().find("input.one").trigger("click");//如果当前的cb复选框没有被选中，这个时候点击添加商品按钮，就触发复选框的点击事件
		}			
		var oldnum = $(this).parent().find("input.sum").val();
		oldnum++;
		$(this).parent().find("input.sum").val(oldnum);
		sum()
	});
	//点击减号减一
	$("span.reduce").click(function(){
		if(!$(this).parent().parent().find("input.one").is(":checked"))
		{
			$(this).parent().parent().find("input.one").trigger("click");//如果当前的cb复选框没有被选中，这个时候点击添加商品按钮，就触发复选框的点击事件
		}			
		var oldnum = $(this).parent().find("input.sum").val();
		oldnum--;
		if(oldnum<=0){
			oldnum = 1;
		}
		$(this).parent().find("input.sum").val(oldnum);
		sum()
	});
	
	//计算总和
	function sum(){
		var sumprice = 0;
		var count = 0;
		$("#allshop input.sum").each(function(index,item){
			var num = $(item).val();  //取出每行的商品数量
			var price = $(item).parent().parent().find("li.price").text(); //将每行的单价取出来
			price = parseFloat(price);
			num = parseInt(num);
			var rowsum = num*price;  //计算每行的价格总和
			$(item).parent().parent().find("li.sumtotle").text(rowsum.toFixed(2)); //将总和显示在数量后面
			if($(item).parent().parent().find("input.one").prop("checked")){
				sumprice+=rowsum;
				count+=num;
			}
			$("span.totlecount").text(count);
			$("span.totleprice").text(sumprice.toFixed(2));
		});
	
	}
	$("#gotoapply").click(function(){
		$(".true").show();
	});
	
	$(".true .close .last .a").click(function(){
		$(".true").hide();
	});
	$(".true .close p.first>span").click(function(){
		$(".true").hide();
	});
});