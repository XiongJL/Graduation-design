package neu.xiong.ELK.design.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shopcar")
public class Shopcar {
	/*购物车id是用户ID,不需要自增*/
	@Id
	private int ctid;
	
	/*存储的是购物车实体序列化信息*/
	private String shopcar;

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
		return "Shopcar [ctid=" + ctid + ", shopcar=" + shopcar + "]";
	}
	
	
	
}
