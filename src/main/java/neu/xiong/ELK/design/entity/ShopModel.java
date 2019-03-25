package neu.xiong.ELK.design.entity;
/**
 *  数据模型类
 * @author Administrator
 *
 */
public class ShopModel {
	private int goodsId;
	private String goodsName;
	private String goodsImg;
	private int goodsPrice;
	private int count;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
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
		return "ShopModel [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsImg=" + goodsImg + ", goodsPrice="
				+ goodsPrice + ", count=" + count + "]";
	}
	
	
}
