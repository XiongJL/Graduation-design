package neu.xiong.ELK.design.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import neu.xiong.ELK.design.entity.Shopcar;

public interface ShopCarDao extends JpaRepository<Shopcar, Integer> {
	@Query(value="SELECT s FROM Shopcar s WHERE s.ctid = :ctid AND s.type= :type")
	List<Shopcar> findByCtid(@Param("ctid")int ctid,@Param("type")int type);
}
