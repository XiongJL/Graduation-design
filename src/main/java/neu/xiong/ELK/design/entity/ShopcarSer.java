package neu.xiong.ELK.design.entity;

import java.io.Serializable;
import java.util.List;

public class ShopcarSer implements Serializable{

	/* 序列化ID */
	private static final long serialVersionUID = 10086L;
	
	private int ctId ;
	
	private int goodsId;
	
	private int goodsPrice;
	
	private int count;

	public int getCtId() {
		return ctId;
	}

	public void setCtId(int ctId) {
		this.ctId = ctId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ShopcarSer [ctId=" + ctId + ", goodsId=" + goodsId + ", goodsPrice=" + goodsPrice + ", count=" + count
				+ "]";
	}
	
	
	
}
