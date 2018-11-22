package neu.xiong.ELK.design.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import neu.xiong.ELK.design.entity.Goods;
//带有多个查询条件的话则需要继承JpaSpecificationExecutor接口
public interface GoodsDao extends JpaRepository<Goods, Integer>,JpaSpecificationExecutor<Goods> {
	//查询首页上的最后12个,今日推荐商品
	@Query(value="select * from goods  ORDER BY goodsId DESC limit 12 ", nativeQuery = true)
	List<Goods> indexGoods();

	//根据goodsId查找goods
	Goods findByGoodsId(int goodsId);
}
