package jp.com.inotaku.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import jp.com.inotaku.domain.Customer;
import jp.com.inotaku.repository.CustomerRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application*.xml")
public class CustomerTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	private Customer customer1;
	private Customer customer2;
	
	@Before
	public void init(){
		customer1 = new Customer(1, "user", "0001");
		customer2 = new Customer(2, "admin", "0002");
		customerRepository.save(customer1);
		customerRepository.save(customer2);
	}
	
	@Test
	public void test() {
		List<Customer> customers = customerRepository.findAll();
		assertThat(customers.get(0).getCustomerName(), is("user"));
		assertThat(customers.get(1).getPassword(), is("0002"));
		System.out.println(customers);
	}

}
