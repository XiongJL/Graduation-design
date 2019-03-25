package neu.xiong.ELK.design.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import antlr.Utils;
import neu.xiong.ELK.design.dao.GoodsDao;
import neu.xiong.ELK.design.dao.ShopCarDao;
import neu.xiong.ELK.design.entity.Goods;
import neu.xiong.ELK.design.entity.ShopModel;
import neu.xiong.ELK.design.entity.Shopcar;
import neu.xiong.ELK.design.entity.ShopcarSer;
import neu.xiong.ELK.design.util.DesignUtils;

@Controller
@CrossOrigin
public class ShopCarController {
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private ShopCarDao shopCarDao;
	
	/**
	 * 序列化保存购物车
	 * @param cusId
	 * @param goodsId
	 * @param goodsPrice
	 * @param count
	 * @return
	 */
	@GetMapping(value="/api/addShopCar")
	@ResponseBody
	public String addShopCar(String cusId,String goodsId,String goodsPrice,String count){   //需要用戶ID，商品ID
		System.out.println(cusId+","+goodsId+","+count+","+goodsPrice);
		if(StringUtils.isEmpty(count)||StringUtils.isEmpty(goodsId)||StringUtils.isEmpty(count))
			return "0";
		ShopcarSer ss = new ShopcarSer();
		ss.setCount(Integer.valueOf(count));
		ss.setCtId(Integer.valueOf(cusId));
		ss.setGoodsPrice(Integer.valueOf(goodsPrice));
		ss.setGoodsId(Integer.valueOf(goodsId));
		String SerStr = DesignUtils.serialize(ss);
		Shopcar sc = new Shopcar();
		sc.setCtid(Integer.valueOf(cusId));
		sc.setShopcar(SerStr);
		shopCarDao.save(sc);
		return "1";	
	}
	
	@GetMapping(value="/api/shopcar/{ctId}")
	public String shopcar(@PathVariable int ctId,Model model){
		System.out.println("进入购物车");
		int type = 0;
		System.out.println("开始查询");
		List<Shopcar> sc = shopCarDao.findByCtid(ctId, type);
		List<ShopModel> data = new ArrayList<>();
		ShopcarSer ser = null;
		Goods goods = null;	
		for(Shopcar s : sc){
			ShopModel sm = new ShopModel();
			ser = (ShopcarSer)DesignUtils.deserialize(s.getShopcar());
			System.out.println(ser);
			goods=goodsDao.findByGoodsId(ser.getGoodsId());
			System.out.println("------------------");
			System.out.println("goods"+goods);
			sm.setCount(ser.getCount());
			sm.setGoodsId(goods.getGoodsId());
			sm.setGoodsImg(goods.getGoodsImg());
			sm.setGoodsName(goods.getGoodsName());
			sm.setGoodsPrice(goods.getGoodsPrice());
			System.out.println("***************");
			System.out.println(sm);
			data.add(sm);
		}
		for(ShopModel smm : data){
			System.out.println(smm);
		}
		model.addAttribute("shops", data);
		return "shopcar";	
	}
}
