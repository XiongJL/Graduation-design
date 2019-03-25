package neu.xiong.ELK.design.design;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import neu.xiong.ELK.design.dao.ShopCarDao;
import neu.xiong.ELK.design.entity.Shopcar;
import neu.xiong.ELK.design.entity.ShopcarSer;
import neu.xiong.ELK.design.util.DesignUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignApplicationTests {
	@Autowired
	private ShopCarDao scdao;
	@Test
	public void findByCtidAndType() {
		System.out.println("开始查询");
		List<Shopcar> sc = scdao.findByCtid(1, 0);
		List<ShopcarSer> result = null;
		ShopcarSer ser = null;
		for(Shopcar s : sc){
			ser = (ShopcarSer)DesignUtils.deserialize(s.getShopcar());
			result.add(ser);
		}
	}

}
