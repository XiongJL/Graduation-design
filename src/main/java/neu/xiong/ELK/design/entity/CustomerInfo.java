package neu.xiong.ELK.design.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="customerInfo")
public class CustomerInfo {
	private int infoid;
	
	private String username;
	
	private String address;
	//阿凡达,(头像)
	private String avatar;
	
	private String introduction;
	
	
}
