package neu.xiong.ELK.design.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  infoid :  用户详细信息ID
 *  username : 用户名称,与customer表关联副键
 *  address: 收货地址
 *  avatar : 头像地址
 *  introduction:  自我介绍
 * @author Administrator
 *
 */
@Entity
@Table(name="customerInfo")
public class CustomerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int infoid;
	
	private String username;
	
	private String address;
	//阿凡达,(头像)
	private String avatar;
	
	private String introduction;

	public int getInfoid() {
		return infoid;
	}

	public void setInfoid(int infoid) {
		this.infoid = infoid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Override
	public String toString() {
		return "CustomerInfo [infoid=" + infoid + ", username=" + username + ", address=" + address + ", avatar="
				+ avatar + ", introduction=" + introduction + "]";
	}
	
	
}
