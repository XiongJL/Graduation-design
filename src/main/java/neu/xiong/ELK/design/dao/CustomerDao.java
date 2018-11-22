package neu.xiong.ELK.design.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.xiong.ELK.design.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	Customer findByUsername(String username);
	
}
