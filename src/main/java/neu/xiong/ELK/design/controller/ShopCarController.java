package neu.xiong.ELK.design.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import neu.xiong.ELK.design.dao.GoodsDao;

@Controller
@CrossOrigin
public class ShopCarController {
	@Autowired
	private GoodsDao goodsDao;
	
	@GetMapping(value="/api/addShopCar")
	public String addShopCar(int cusId,int goodsId){   //需要用戶ID，商品ID
		System.out.println(cusId+","+goodsId);
		return "index";	
	}
}
