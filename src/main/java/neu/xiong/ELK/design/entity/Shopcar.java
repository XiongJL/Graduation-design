package neu.xiong.ELK.design.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shopcar")
public class Shopcar {
	/*购物车id是用户ID,不需要自增*/
	
	private int ctid;
	
	/*存储的是购物车实体序列化信息*/
	@Id
	private String shopcar;
	/*0尚未提交订单 ， 1 已提交订单*/
	private int type;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCtid() {
		return ctid;
	}

	public void setCtid(int ctid) {
		this.ctid = ctid;
	}

	public String getShopcar() {
		return shopcar;
	}

	public void setShopcar(String shopcar) {
		this.shopcar = shopcar;
	}

	@Override
	public String toString() {
		return "Shopcar [ctid=" + ctid + ", shopcar=" + shopcar + ", type=" + type + "]";
	}

	
	
	
	
}
