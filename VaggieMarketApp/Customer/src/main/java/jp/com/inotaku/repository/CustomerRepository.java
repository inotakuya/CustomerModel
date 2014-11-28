package jp.com.inotaku.repository;

import java.util.List;

import jp.com.inotaku.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	public List<Customer> findByCustomerName(String customerName);

}
